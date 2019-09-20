package cn.huateng.io;

/**
 * 1.抽象组件：需要装饰的抽象对象（一般为接口或者父类）
 * 2.具体组件：需要装饰的对象
 * 3.抽象装饰类：包含了对抽象组件的引用以及装饰着共有的方法
 * 4.具体装饰类：被装饰的对象
 * @author Dusongsong
 *
 */
public class DecorateTest {

	public static void main(String[] args) {
		Coffee coffee = new Coffee();
		System.out.println(coffee.info()+":"+coffee.cost());
		Milk milk = new Milk(coffee);
		System.out.println(milk.info()+":"+milk.cost());
		Suger suger = new Suger(coffee);
		System.out.println(suger.info()+":"+suger.cost());
	}
}

//1.抽象组件
interface Drink{
	double cost();//费用
	String info();//说明
}
//2.具体组件
class Coffee implements Drink{

	private String name = "原味咖啡";
	@Override
	public double cost() {
	
		return 10;
	}

	@Override
	public String info() {
	
		return name;
	}
	
}
//3.抽象装饰类
 abstract class Decorate implements Drink{
	 private Drink drink;
	 public Decorate(Drink drink) {
		this.drink = drink;
	}
	 @Override
		public double cost() {
			return this.drink.cost();
		}

		@Override
		public String info() {
			return this.drink.info();
		}
 }
 //4.具体装饰类
 class Milk extends Decorate{

	public Milk(Drink drink) {
		super(drink);
	}
	@Override
	public double cost() {
		return super.cost()*4;
	}

	@Override
	public String info() {
		return super.info()+"加入了牛奶";
	}
 }
//4.具体装饰类
class Suger extends Decorate{

	public Suger(Drink drink) {
		super(drink);
	}
	@Override
	public double cost() {
		return super.cost()*2;
	}

	@Override
	public String info() {
		return super.info()+"加入了白糖";
	}
}