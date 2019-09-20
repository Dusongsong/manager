package cn.huateng.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * ת������InputStreamReader OutputSteameWriter
 * 1.���ַ�������ʽ�����ֽ���
 * 2.ָ���ַ���
 * @author Dusongsong
 *
 */
public class ConverTest {

	
	public static void main(String[] args) {
		//����System.in��System.out
		try(BufferedReader bufferedReader  = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter( new OutputStreamWriter(System.out));){
			//��ȡ���̵�����
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
