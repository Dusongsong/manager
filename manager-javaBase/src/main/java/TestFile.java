package cn.huateng.demo;
import java.io.File;

public class TestFile {

	public static void main(String[] args) {
		File f = new File("F:\\01. JAVA�����׶�\\01. JAVA�����׶Ρ�������ѧ�á���ս����Ա��");
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
