package cn.huateng.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * 文件夹下的文件拷贝
 * @author Dusongsong
 *
 */
public class CopyFiles {

	public static void main(String[] args) {
		File file = new File("H:/workspaceJ2ee/MyPro02");
		copyFile(file, "abc.text", "copy.text");
	}
	
	//递归方法
	public static void copyFile(File src,String srcPath,String destPath) {
		if(src ==null || !src.exists()) {
			return;
		}else if(src.isDirectory()){
			//1.创建源
			File fileSrc = new File(srcPath);//源
			File fileDest = new File(destPath);//目的	
			//2.选择流
					InputStream is = null;
					OutputStream os =null;
					try {
						 is = new FileInputStream(fileSrc);
						 os = new FileOutputStream(fileDest,true);	
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
			for(File s:src.listFiles()) {
				copyFile(s,srcPath,destPath);
			}
		}
	}
	
}
