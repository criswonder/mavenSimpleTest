package com.hongyun.testHierachicalInitOrder;

public class ClassA extends BaseClass {
	
	/**
	 * 这里编译器会强制你 调用父内的constructor
	 * Implicit super constructor BaseClass() is undefined. 
	 * Must explicitly invoke another constructor
	 * @param id
	 * @param name
	 */
	public ClassA(String id, String name) {
		super(id, name);
	}

}
