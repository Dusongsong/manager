package cn.huateng.collection;

import java.util.ArrayList;
import java.util.List;

public class TestList {

	public static void main(String[] args) {
		test01();
	}
	
	public static void test01() {
		List<String> list = new ArrayList<String>();
		list.add("aa");
		list.add("bb");
		list.add("cc");
		list.add("dd");
		list.add(2, "ee");
		list.remove(2);
		list.set(2, "ff");
		list.indexOf("aa");
		System.out.println("list:"+list);
		System.out.println(	list.indexOf("aa"));
	}
    public static void test02() {
		
    	List<String> list01 = new ArrayList<String>();
    	list01.add("aa");
    	list01.add("bb");
    	list01.add("cc");
    	List<String> list02 = new ArrayList<String>();
    	list02.add("aa");
    	list02.add("dd");
    	list02.add("ee");
    	list01.removeAll(list02);
    	System.out.println("01:"+list01);
	}
}
