package cn.huateng.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCollections {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		for(int i=0;i<10;i++) {
			list.add("aa"+i);
		}
		System.out.println("Ç°£º"+list);
		//Collections.shuffle(list);	
		Collections.reverse(list);
		Collections.sort(list);
		System.out.println("ºó£º"+list);
	}
}
