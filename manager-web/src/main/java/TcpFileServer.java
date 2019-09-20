package cn.huateng.internet;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 存储文件
 * 创建服务器
 *
 */
public class TcpFileServer {

    public static void main(String[] args) throws Exception{
        //1.指定端口 使用ServerSocket创建服务器
        ServerSocket server = new ServerSocket(8888);
        //2.阻塞式等待连接 accept
          Socket client = server.accept();
        System.out.println("一个客户端建立了连接。。");
        //3.操作：输入输出流操作
        DataInputStream inputStream = new DataInputStream(client.getInputStream());
        String data = inputStream.readUTF();
        System.out.println(data);
        //4.释放资源
        inputStream.close();
        client.close();
        server.close();
    }


}
