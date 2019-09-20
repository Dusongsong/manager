package cn.huateng.collection;

public class TestGeneric {

	public static void main(String[] args) {
		MyCollection<String> coll = new MyCollection<String>();
		coll.set("ddd", 0);
		coll.set("eee", 1);
		coll.set("fff", 2);
		
		String b = coll.get(1);
		
	}
}
class MyCollection<T>{
	Object[] o = new Object[5];
	public void set(T t,int index) {
		o[index] = t;
	}
	
	public T get(int index) {
		return (T)o[index];
	}
}