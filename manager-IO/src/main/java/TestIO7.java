package cn.huateng.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 图片读到字节数组中
 * 字节数组输出文件
 * 1.创建源
 * 2.选择流
 * 3.操作
 * 4.释放资源
 * @author Dusongsong
 *
 */
public class TestIO7 {

	public static void main(String[] args) {
		byte[] data = fileToByteArray("p.png");
		System.out.println(data.length);

	}

	/**
	 * 1.图片读取到字节数组
	 * 图片到程序 InputStream
	 * 程序到字节数组 ByteArrayOutputStream
	 */
	public static byte[] fileToByteArray(String filePath) {
		//创建源与目的地
		File src = new File(filePath);
		byte[] dest = null;
		//选择流
		InputStream inputStream = null;
		ByteArrayOutputStream  byteArrayOutputStream = null;
		try {
			inputStream = new FileInputStream(src);
			byteArrayOutputStream = new ByteArrayOutputStream();
			//读取
			int len = -1;
			byte[] flush = new byte[1024];
			while((len = inputStream.read(flush))!=-1) {
				byteArrayOutputStream.write(flush,0,len);
			}
			byteArrayOutputStream.flush();
			return byteArrayOutputStream.toByteArray();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(byteArrayOutputStream!=null) {
					byteArrayOutputStream.close();
				}
				if(inputStream!=null) {
					inputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return null;
	}

	/**
	 * 2.字节数组写出到图片
	 * 字节数组读取到程序 ByteArrayInputStream
	 * 程序写出到图片 FileOutputStream
	 */
	public static void byteArrayToFile(byte[] src,String filePath) {
		//1.创建源
		File dest = new File(filePath);
		//2.选择流

		try ( ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(src);
			  OutputStream outputStream = new FileOutputStream(dest)){
			//读取
			int len = -1;
			byte[] flush = new byte[1024];
			while((len=byteArrayInputStream.read(flush))!=-1) {
				outputStream.write(flush, 0, len);
			}
			outputStream.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}


	}



}
