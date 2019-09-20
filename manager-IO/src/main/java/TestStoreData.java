package cn.huateng.io;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestStoreData {

	public static void main(String[] args) {

		Map<String,Object> row1 = new HashMap<String,Object>();
		row1.put("id", 1001);
		row1.put("name", "张三");
		row1.put("salary", 6000);
		row1.put("入职日期", "2018.5.1");

		Map<String,Object> row2 = new HashMap<String,Object>();
		row2.put("id", 1002);
		row2.put("name", "李四");
		row2.put("salary", 5000);
		row2.put("入职日期", "2018.6.1");

		Map<String,Object> row3 = new HashMap<String,Object>();
		row3.put("id", 1003);
		row3.put("name", "王五");
		row3.put("salary", 3000);
		row3.put("入职日期", "2018.7.1");
		List<Map<String,Object>> table = new ArrayList<>();
		table.add(row1);
		table.add(row2);
		table.add(row3);
		for(Map<String,Object> row :table) {
			Set<String> keySet = row.keySet();
			for(String key :  keySet) {
				System.out.print(key+":"+row.get(key)+"\t");
			}
			System.out.println();
		}

	}

}
