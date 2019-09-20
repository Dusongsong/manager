package cn.huateng.io;

/**
 * 1.�����������Ҫװ�εĳ������һ��Ϊ�ӿڻ��߸��ࣩ
 * 2.�����������Ҫװ�εĶ���
 * 3.����װ���ࣺ�����˶Գ�������������Լ�װ���Ź��еķ���
 * 4.����װ���ࣺ��װ�εĶ���
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

//1.�������
interface Drink{
	double cost();//����
	String info();//˵��
}
//2.�������
class Coffee implements Drink{

	private String name = "ԭζ����";
	@Override
	public double cost() {
	
		return 10;
	}

	@Override
	public String info() {
	
		return name;
	}
	
}
//3.����װ����
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
 //4.����װ����
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
		return super.info()+"������ţ��";
	}
 }
//4.����װ����
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
		return super.info()+"�����˰���";
	}
}