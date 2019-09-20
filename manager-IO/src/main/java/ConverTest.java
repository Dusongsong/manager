package cn.huateng.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 转换流：InputStreamReader OutputSteameWriter
 * 1.以字符流的形式操作字节流
 * 2.指导字符集
 * @author Dusongsong
 *
 */
public class ConverTest {

	
	public static void main(String[] args) {
		//操作System.in和System.out
		try(BufferedReader bufferedReader  = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter( new OutputStreamWriter(System.out));){
			//获取键盘的输入
			String msg = "";
			while(!msg.equals("exit")) {
				msg = bufferedReader.readLine();
				bufferedWriter.write(msg);
				bufferedWriter.newLine();
				bufferedWriter.flush();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
