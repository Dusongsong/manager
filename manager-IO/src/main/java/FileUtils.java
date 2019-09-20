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
 * ��װ���������
 * ��װ�ͷ���Դ
 * @author Dusongsong
 *
 */
public class FileUtils {
	
	public static void main(String[] args) {
		//�ļ����ļ�
		try {
			InputStream inputStream = new FileInputStream("abc.text");
			OutputStream outputStream = new FileOutputStream("test01.text");
			copy(outputStream, inputStream);
		}catch(IOException e) {
			e.printStackTrace();
		}
		//�ļ����ֽ�����
		try {
			InputStream inputStream = new FileInputStream("abc.text");
			ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
			copy(arrayOutputStream, inputStream);
			byte[] b = arrayOutputStream.toByteArray();
		}catch(IOException e) {
			e.printStackTrace();
		}
		//�ֽ����鵽�ļ�
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
		 * �Խ�����������
		 * @param outputStream
		 * @param inputStream
		 */
		public static void copy(OutputStream outputStream,InputStream inputStream) {
			
			try{
			//��ȡ
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
		//ԭʼ�汾
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
		//��ǿ�汾
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
