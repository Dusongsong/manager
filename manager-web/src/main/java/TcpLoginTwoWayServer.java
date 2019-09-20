package cn.huateng.internet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 模拟登录 双向
 * 创建服务器
 *
 */
public class TcpLoginTwoWayServer {

    public static void main(String[] args) throws Exception{
        //1.指定端口 使用ServerSocket创建服务器
        ServerSocket server = new ServerSocket(8888);
        //2.阻塞式等待连接 accept
          Socket client = server.accept();
        System.out.println("一个客户端建立了连接。。");
        //3.操作：输入输出流操作
        DataInputStream inputStream = new DataInputStream(client.getInputStream());
        String data = inputStream.readUTF();
        String uname ="";
        String upwd ="";
         String [] dataArray = data.split("&");
         for(String info : dataArray){
             String [] userInfo = info.split("=");
             if(userInfo[0].equals("uname")) {
                 System.out.println("你的用户名为:"+userInfo[1]);
             }else if(userInfo[0].equals("upwd")) {
                 System.out.println("你的密码为:"+userInfo[1]);
             }
         }
        //输出
        DataOutputStream dos =new DataOutputStream(client.getOutputStream());
        if(uname.equals("shsxt") && upwd.equals("laopei")) { //成功
            dos.writeUTF("登录成功，欢迎回来");
        }else { //失败
            dos.writeUTF("用户名或密码错误");
        }
        dos.flush();
        //4.释放资源
        inputStream.close();
        client.close();
        server.close();
    }


}
