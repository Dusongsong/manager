package cn.huateng.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 封装输入输出流
 * 封装释放资源
 * @author Dusongsong
 *
 */
public class FileUtils {
	
	public static void main(String[] args) {
		//文件到文件
		try {
			InputStream inputStream = new FileInputStream("abc.text");
			OutputStream outputStream = new FileOutputStream("test01.text");
			copy(outputStream, inputStream);
		}catch(IOException e) {
			e.printStackTrace();
		}
		//文件到字节数组
		try {
			InputStream inputStream = new FileInputStream("abc.text");
			ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
			copy(arrayOutputStream, inputStream);
			byte[] b = arrayOutputStream.toByteArray();
		}catch(IOException e) {
			e.printStackTrace();
		}
		//字节数组到文件
		try{
			byte[] b = null;
			InputStream arrayInputStream = new ByteArrayInputStream(b);
			OutputStream outputStream = new FileOutputStream("abc.text");
		
			copy(outputStream,arrayInputStream );
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
		/**
		 * 对接输入输入流
		 * @param outputStream
		 * @param inputStream
		 */
		public static void copy(OutputStream outputStream,InputStream inputStream) {
			
			try{
			//读取
			int len = -1;
			byte[] flush = new byte[1024];
			while((len = inputStream.read(flush))!=-1) {
				outputStream.write(flush,0,len);
			}
			outputStream.flush();
			}catch(FileNotFoundException e) {
				e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}
			
		}
		//原始版本
		public static void close(OutputStream outputStream,InputStream inputStream) {
			try {
				if(outputStream!=null) {
					outputStream.close();
				}
				if(inputStream!=null) {
					inputStream.close();
				}
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			
		}
		//加强版本
		public static void close(Closeable... ios) {
			for(Closeable io :ios) {
				try {
					if(io!=null) {
						io.close();
					}
					if(io!=null) {
						io.close();
					}
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
		}
		
}
