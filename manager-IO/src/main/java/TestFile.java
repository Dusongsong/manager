package cn.huateng.io;

import java.io.File;

public class TestFile {

	
	public static void main(String[] args) {
		File file = new File("H:/workspaceJ2ee/MyPro02");
		printName(file, 0);
		
	}
	
	private static void printName(File src,int deep) {
		for(int i =0 ;i<deep;i++) {
			System.out.println("-");
		}
		System.out.println(src.getName());
		if(null ==src||!src.exists()) {
			System.out.println("Ä¿Â¼²»´æÔÚ");
		}else if(src.isDirectory()) {
			for(File s:src.listFiles()) {
				printName(s,deep+1);
			}
		}
		
	}
}
