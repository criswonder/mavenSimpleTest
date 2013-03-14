package com.hongyun.testFinal;

public class TestFinal {
	public  final String str="f you !";
	public  Object str1;
	
	protected class InnerClass implements InterfaceA{
		@Override
		public void method1() {
			System.out.println(str);
		}

        @Override
        public void method2() {}
	}
	
	InterfaceA interfaceA = new InterfaceA() {
		
		public void method1() {
			String newStr = new String("listen to me!");
			System.out.println(str1);
		}
		public void method2(String str) {
			System.out.println(str1);
		}
        @Override
        public void method2() {}
	};
}
