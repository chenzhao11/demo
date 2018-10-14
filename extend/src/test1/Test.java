package test1;

public class Test extends Suger {
	
	 private int price2=5;
	
	 private int weight2=6;
	

	@Override
	public void func1() {
		super.func1();
	}

	@Override
	public void func2() {
		System.out.println("price是"+price2+"   weight是"+weight2);
	}
	
    //重载
	public void func3(int i) {
		System.out.println(i);
	}
	public void func4() {
		System.out.println("func4");
	}

	public static void main(String[] args) {
		//==========子类强制转换成父类对象还可以强制转换回子类对象
		Test test=new Test();
		Suger suger=(Suger)test;
		//suger.func4();// 强转过后子类独有的方法不能用了
		Test test2=(Test)suger;
		test2.func4(); 
		System.out.println("========================================");
		/*
		 * 父类强制转换成子类在编译的时候不会报错但是运行的时候回抛出异常不能进行类型转换
		 * 在内存层面就是父类的内存空间小不能转化成内存空间更大的子类
		 * 但是子类可以转化成内存小的父类，转化是指的 大的部分也就是自己加上的方法不能用，但是还可以再
		 * 从父类转化成子类，此时就可以使用子类的方法了
		 *  Exception in thread "main" func4
			java.lang.ClassCastException: test1.Suger cannot be cast to test1.Test
		    at test1.Test.main(Test.java:39)
		 */
		//Suger suger11=new Suger();
		//Test test3=(Test)suger11;
		//Suger suger12=(Suger)test3;
		//test3.func4();
		//suger11.func4();错误
	

		
		
		
		
		
	
		Suger sug=new Test();
		Test tes=new Test();
		sug.func1();
		sug.func2();//方法二进行过重载
		sug.func3();
		//sug.func3(666);错误因为在父类里面没有定义
		//sug.func4();
		System.out.println("============================tes===========================================");
		tes.func1();
		tes.func2();
		tes.func3(100000);
		tes.func4();
		
		//System.out.println(o);//private不可见
	}

}
