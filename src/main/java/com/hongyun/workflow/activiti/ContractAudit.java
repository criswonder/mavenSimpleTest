package com.hongyun.workflow.activiti;

import java.util.HashMap;
import java.util.List;

import junit.framework.TestCase;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

public class ContractAudit extends TestCase {
    RuntimeService    runtimeService;
    RepositoryService repositoryService;
    HistoryService    historyService;
    TaskService       taskService;

    @Override
    protected void setUp() throws Exception {
        ProcessEngine processEngine = ProcessEngineConfiguration
                .createStandaloneProcessEngineConfiguration().buildProcessEngine();

        // Get Activiti services
        repositoryService = processEngine.getRepositoryService();
        runtimeService = processEngine.getRuntimeService();
        // verify that the process is actually finished
        historyService = processEngine.getHistoryService();
        taskService = processEngine.getTaskService();
        // Deploy the process definition
        repositoryService.createDeployment()
                .addClasspathResource("CARRIERCONTRACTAUDIT.bpmn20.xml").deploy();

        super.setUp();
    }

    @Test
    public void testcontracttest() {
        ProcessInstance pi = runtimeService.startProcessInstanceByKey("CARRIERCONTRACTAUDIT");

        List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup("SPD").list();


        for (Task t : tasks) {
            taskService.claim(t.getId(), "管理员");
        }
        tasks = taskService.createTaskQuery().taskAssignee("管理员").list();
        
       

        HashMap<String, Object> vars;
        for (Task t : tasks) {
            vars = new HashMap<String, Object>();
            vars.put("AUDITACTION", "APPROVE");
            taskService.complete(t.getId(), vars);

        }

        //二级 开始审核
        tasks = taskService.createTaskQuery().taskCandidateGroup("合同管理员").list();
        for (Task t : tasks) {
            taskService.claim(t.getId(), "管理员");
        }
        tasks = taskService.createTaskQuery().taskAssignee("管理员").list();

        for (Task t : tasks) {
            vars = new HashMap<String, Object>();
            vars.put("AUDITACTION", "APPROVE");
            vars.put("STANDARD", false);
            taskService.complete(t.getId(), vars);

        }
        
        //三级 开始审核
        tasks = taskService.createTaskQuery().taskCandidateGroup("分总").list();
        for (Task t : tasks) {
            taskService.claim(t.getId(), "管理员");
        }
        tasks = taskService.createTaskQuery().taskAssignee("管理员").list();

        for (Task t : tasks) {
            vars = new HashMap<String, Object>();
            vars.put("AUDITACTION", "REJECT");
            taskService.complete(t.getId(), vars);

        }
        
        //三级 开始审核
        tasks = taskService.createTaskQuery().taskCandidateGroup("法务部").list();
        for (Task t : tasks) {
            taskService.claim(t.getId(), "管理员");
        }
        tasks = taskService.createTaskQuery().taskAssignee("管理员").list();
        
        for (Task t : tasks) {
            vars = new HashMap<String, Object>();
            vars.put("AUDITACTION", "REJECT");
            taskService.complete(t.getId(), vars);
            
        }

    }
}
