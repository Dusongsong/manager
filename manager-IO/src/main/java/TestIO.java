package cn.huateng.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 1.����Դ
 * 2.ѡ����
 * 3.����
 * 4.�ͷ���Դ
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
