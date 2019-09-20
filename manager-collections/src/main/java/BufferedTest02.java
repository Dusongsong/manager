package cn.huateng.buffered;

import java.io.BufferedReader;
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
public class BufferedTest02 {

	public static void main(String[] args) {
		File file = new File("abc.text");
		BufferedReader reader = null;
		try {
			reader =new BufferedReader( new FileReader(file));
			String line = null;
			while((line=reader.readLine())!=null) {
				System.out.println(line);
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
