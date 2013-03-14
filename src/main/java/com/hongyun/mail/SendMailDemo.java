package com.hongyun.mail;

public class SendMailDemo {
    public static void main(String[] args) {
        SendMail sm = new SendMail("Hzsmtp1.800best.com");
        sm.setNeedAuth(false);
        sm.setNamePass("crismao@163.com", "woaini");
        sm.setSubject("测试,测试");
        sm.setFrom("peidewan@ldtec.com");
        sm.setTo("andymao@qq.com");
        //        sm.addFileAffix("f:/adsl.txt");
        StringBuffer bs = new StringBuffer();
        bs.append("裴德万:\n");
        bs.append("       测试度奇珍异宝埼地在檌!!!!!!!!!!!");
        sm.setBody("DFSAAAAAAAAAAAAAAAAA");
        sm.setNeedAuth(true);
        boolean b = sm.setOut();
        if (b) {
            System.out.println("\n邮件发送成功!!!!!");
        } else {
            System.out.println("邮件发送失败!!!!");
        }
    }
}
