package cn.huateng.buffered;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * 文件夹下的文件拷贝
 * @author Dusongsong
 *
 */
public class CopyFiles {

	public static void main(String[] args) {
		File file = new File("H:/workspaceJ2ee/MyPro02");
		copyFile(file, "test01.text", "copy.text");
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
			try (BufferedReader is = new BufferedReader(new FileReader(fileSrc));
				 BufferedWriter os = new BufferedWriter(new FileWriter(fileDest))){
				//分段读取
				String line = null;
				while((line=is.readLine())!=null) {
					os.write(line);
					os.flush();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
