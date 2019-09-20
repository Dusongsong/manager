package cn.huateng.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/**
 * 字符流读取
 * 1.创建源
 * 2.选择流
 * 3.操作
 * 4.释放资源
 * @author Dusongsong
 *
 */
public class TestIO5 {

	public static void main(String[] args) {
		File file = new File("abc.text");
		Reader reader = null;
		try {
			reader = new FileReader(file);
			int len = -1;
			char[] flush = new char[1024];//缓冲器
			while((len=reader.read(flush))!=-1) {
				String str = new String(flush, 0, len);
				System.out.println(str);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(reader!=null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}



}
