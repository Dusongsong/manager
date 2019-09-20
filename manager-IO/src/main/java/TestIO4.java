package cn.huateng.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 文件字节输入流
 * 1.创建源
 * 2.选择流
 * 3.操作
 * 4.释放资源
 * @author Dusongsong
 *
 */
public class TestIO4 {

	public static void main(String[] args) {
		//1.
		File file = new File("test01.text");
		//2.
		OutputStream os=null;
		try {
			os = new FileOutputStream(file,true);
			//3.写出
			String data = "helle world java!";
			byte[] b = data.getBytes();//字符串-》字节（编码）
			os.write(b,0,b.length);
			os.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(os!=null) {
					os.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}



}
