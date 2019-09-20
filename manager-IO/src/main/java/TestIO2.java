package cn.huateng.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 1.创建源
 * 2.选择流
 * 3.操作
 * 4.释放资源
 * @author Dusongsong
 *
 */
public class TestIO2 {

	public static void main(String[] args) {
		InputStream is=null;
		File file = new File("abc.text");
		try {
			is = new FileInputStream(file);
			int temp;
			while((temp=is.read())!=-1) {
				System.out.println((char)temp);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(null!=is) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}



}
