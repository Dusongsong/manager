package cn.huateng.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 图片复制
 * 1.创建源
 * 2.选择流
 * 3.操作
 * 4.释放资源
 * @author Dusongsong
 *
 */
public class ImageCopy {
	
	public static void main(String[] args) {
		
		
		copy("src/cn/huateng/io/ImageCopy.java", "copy.text");
	}
	public static void copy(String srcPath,String destPath) {
		//1.创建源
		File src = new File(srcPath);//源
		File dest = new File(destPath);//目的	
		//2.选择流
				InputStream is = null;
				OutputStream os =null;
				try {
					 is = new FileInputStream(src);
					 os = new FileOutputStream(dest,true);	
				//分段读取
					 int len = -1;
					 byte[] read = new byte [1024];
					while((len=is.read(read))!=-1) { 
						String s = new String(read,0,len);
						 byte[] b = s.getBytes();
						 os.write(b, 0, b.length);
					}			
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					//4,释放资源，先开后关
						try {
							
							if(os!=null) {
							os.close();
							}
		                    if(is!=null) {
							is.close();	
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
	}
	
}
