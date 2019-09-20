package cn.huateng.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * �ļ����µ��ļ�����
 * @author Dusongsong
 *
 */
public class CopyFiles {

	public static void main(String[] args) {
		File file = new File("H:/workspaceJ2ee/MyPro02");
		copyFile(file, "abc.text", "copy.text");
	}
	
	//�ݹ鷽��
	public static void copyFile(File src,String srcPath,String destPath) {
		if(src ==null || !src.exists()) {
			return;
		}else if(src.isDirectory()){
			//1.����Դ
			File fileSrc = new File(srcPath);//Դ
			File fileDest = new File(destPath);//Ŀ��	
			//2.ѡ����
					InputStream is = null;
					OutputStream os =null;
					try {
						 is = new FileInputStream(fileSrc);
						 os = new FileOutputStream(fileDest,true);	
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
			for(File s:src.listFiles()) {
				copyFile(s,srcPath,destPath);
			}
		}
	}
	
}
