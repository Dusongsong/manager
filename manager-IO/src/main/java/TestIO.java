package cn.huateng.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 1.创建源
 * 2.选择流
 * 3.操作
 * 4.释放资源
 * @author Dusongsong
 *
 */
public class TestIO {
	
	public static void main(String[] args) {
		File file = new File("abc.text");
		try {
			InputStream is = new FileInputStream(file);	
			int data =is.read();
			System.out.println((char)data);
			is.close();
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}

	
	
}
