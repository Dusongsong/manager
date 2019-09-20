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
public class TestIO3 {

	private static int lenght;

	public static void main(String[] args) {
		//1.创建源
		File file = new File("abc.text");
		//2.选择流
		InputStream is=null;
		try {
			is = new FileInputStream(file);
			// 3.操作
			byte[] flush = new byte[1024];//缓冲容器
			int len = -1;
			while((len=is.read(flush))!=-1) {
				//解码
				String s  = new String(flush,0,len);
				System.out.println(s);
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
