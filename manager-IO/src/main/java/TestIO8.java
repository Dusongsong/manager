package cn.huateng.io;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 字节数组输出流
 * 1.创建源
 * 2.选择流
 * 3.操作
 * 4.释放资源
 * @author Dusongsong
 *
 */
public class TestIO8 {

	public static void main(String[] args) {
		//1.创建源
		byte[] dest = null;
		//2.选择流
		ByteArrayOutputStream arrayOutputStream = null;
		try {
			arrayOutputStream = new ByteArrayOutputStream();
			//3.写出
			String data = "helle world polpor!";
			byte[] b = data.getBytes();//字符串-》字节（编码）
			arrayOutputStream.write(b,0,b.length);
			arrayOutputStream.flush();
			//获取数据
			dest = arrayOutputStream.toByteArray();
			System.out.println(dest.length+":"+new String(dest,0,dest.length));
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(arrayOutputStream!=null) {
					arrayOutputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}



}
