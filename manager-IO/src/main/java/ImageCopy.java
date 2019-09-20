package cn.huateng.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * ͼƬ����
 * 1.����Դ
 * 2.ѡ����
 * 3.����
 * 4.�ͷ���Դ
 * @author Dusongsong
 *
 */
public class ImageCopy {
	
	public static void main(String[] args) {
		
		
		copy("src/cn/huateng/io/ImageCopy.java", "copy.text");
	}
	public static void copy(String srcPath,String destPath) {
		//1.����Դ
		File src = new File(srcPath);//Դ
		File dest = new File(destPath);//Ŀ��	
		//2.ѡ����
				InputStream is = null;
				OutputStream os =null;
				try {
					 is = new FileInputStream(src);
					 os = new FileOutputStream(dest,true);	
				//�ֶζ�ȡ
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
					//4,�ͷ���Դ���ȿ����
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
