package test1;

public class Suger implements Coffee {

    private int price2=2;
    private int o=33;
    private int weight2=4;
	@Override
	public void func1() {
		System.out.println("func1");
	}

	@Override
	public void func2() {
		System.out.println("price是"+price2+"         weight是"+weight2);

	}
	public void func3() {
		System.out.println("func3");

	}
	public static void main(String[] args) {
		Coffee coff=new Suger();//接口亦可以定义成父类引用的形式   在装饰者模式里面用到很多
		Suger sug=new Suger();
		Coffee coff2=(Coffee)sug;
		coff2.func1();
		Suger sug2=(Suger)coff2;
		sug2.func2();
		System.out.println("========上面是对于强制类型转换的操作");
		//接口的操作与继承的操作在这里都一样
		sug.func2();
		
		sug.func3();
		coff.func1();
		
		//coff.func3();
	}

    }
