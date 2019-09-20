package cn.huateng.buffered;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;

/**
 * 字符流写出
 * 1.创建源
 * 2.选择流
 * 3.操作
 * 4.释放资源
 * @author Dusongsong
 *
 */
public class BufferedTest03 {

	public static void main(String[] args) {
		//1.创建源
		File dest = new File("test02.text");
		//2.选择流
		BufferedWriter writer=null;
		try {
			writer = new BufferedWriter(new FileWriter(dest));
			//3.写出
			/*String data = "学习使我快乐!\r\n";
		    char[] b = data.toCharArray();//字符串-》字节（编码）
		    writer.write(b,0,b.length);*/
			//写法二
			/*String data = "学习使我快乐!\r\n";
			 writer.write(data);*/
			//写法三
			writer.write("为什么还不改");
			writer.append("漂亮!");
			writer.newLine();
			writer.append("大方!");
			writer.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}



}
