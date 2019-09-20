package cn.huateng.demo;
import java.io.File;

public class TestFile {

	public static void main(String[] args) {
		File f = new File("F:\\01. JAVA初级阶段\\01. JAVA初级阶段【北京尚学堂·百战程序员】");
		printFile(f, 0);
	}
	
	public static void printFile(File file,int level) {
		for(int i=0;i<level;i++) {
			System.out.print("*");
		}
		System.out.println(file.getName());
		if(file.isDirectory()) {
			File[] files = file.listFiles();
			for(File temp: files) {
				printFile(temp, level+1);
			}
		}
	}
}
