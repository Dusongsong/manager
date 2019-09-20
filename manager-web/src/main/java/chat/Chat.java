package cn.huateng.internet.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 在线聊天室: 服务器
 * 目标: 加入容器实现群聊
 *
 * @author Dusongsong
 *
 */
public class Chat {
	private static CopyOnWriteArrayList<Channels> all = new CopyOnWriteArrayList<>();//容器
	public static void main(String[] args) throws IOException {
		System.out.println("-----Server-----");
		// 1、指定端口 使用ServerSocket创建服务器
		ServerSocket server =new ServerSocket(8888);
		// 2、阻塞式等待连接 accept
		while (true){
			Socket  client =server.accept();
			System.out.println("一个客户端建立了连接");
			Channels c  = new Channels(client);
					all.add(c);//管理所有的成员
			new Thread(new Channel(client)).start();
		}

	}
}
//一个客户代表一个Channel
 class Channels implements Runnable{
	private DataInputStream dis;
	private DataOutputStream dos;
	private Socket client;
	private boolean isRunning;
	private String name;
	private CopyOnWriteArrayList<Channels> all ;//容器
	public Channels(Socket client) {
		this.client = client;
		try {
			dis =new DataInputStream(client.getInputStream());
			dos =new DataOutputStream(client.getOutputStream());
		} catch (IOException e) {
			System.out.println("---1------");
			release();
		}

	}
	//发送消息
	public String receive(){
		String msg="";
		try {
			msg = dis.readUTF();
		} catch (IOException e) {
			System.out.println("---2------");
			release();
		}
		return msg;
	}
	//发送消息
	public void send(String msg){
		try{
			dos.writeUTF(msg);
			dos.flush();
		}catch (IOException e){
			System.out.println("---3------");
			release();
		}

	}

	/**
	 * 群聊;获取自己的消息，发给其他人
	 */
	private void sendOther(String msg,boolean isSys){
		for(Channels other : all){
			if(other==this){
				continue;
			}
			if(!isSys) {
				other.send(this.name +"对所有人说:"+msg);//群聊消息
			}else {
				other.send(msg); //系统消息
			}
		}

	}

	//释放资源
	public void release(){
		this.isRunning =false;
		IOUtils.close(dis,dos,client);
		//退出
		all.remove(this);
		sendOther(this.name+"离开大家庭...",true);
	}
	@Override
	public void run() {
		while (isRunning){
			String msg = receive();
			if(!msg.equals("")) {
				send(msg);
			}
		}

	}
}
