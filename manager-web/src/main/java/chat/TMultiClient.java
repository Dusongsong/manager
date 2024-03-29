package cn.huateng.internet.chat;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 在线聊天室: 客户端
 * 目标: 封装实现多个客户可以正常收发多条消息
 * 问题：其他客户必须等待之前的客户退出，才能继续 排队
 *
 *
 */
public class TMultiClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("-----Client-----");
		//1、建立连接: 使用Socket创建客户端 +服务的地址和端口
		Socket client =new Socket("localhost",8888);
		//2、客户端发送消息
		new Thread().start();
		new Thread().start();
		BufferedReader console =new BufferedReader(new InputStreamReader(System.in));
		DataOutputStream dos =new DataOutputStream(client.getOutputStream());		
		DataInputStream dis =new DataInputStream(client.getInputStream());
		boolean isRunning = true;
		while(isRunning) {
			String msg = console.readLine();
			dos.writeUTF(msg);
			dos.flush();
			//3、获取消息
			msg =dis.readUTF();
			System.out.println(msg);
		}
		dos.close();
		dis.close();
		client.close();
		
	}
}
