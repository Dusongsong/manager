package cn.huateng.internet;

import java.io.DataOutputStream;
import java.net.Socket;

/**
 * 创建客户端
 */
public class TcpClient {
    public static void main(String[] args) throws Exception{

        System.out.println("----Client----");
        //1.创建连接：使用Socket创建客户端+服务的地址+端口
        Socket client = new Socket("localhost",8888);
        //2.操作：输入输出流操作
        DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());
        String data = "hello world";
        outputStream.writeUTF(data);
        outputStream.flush();
        // 3.释放资源
        outputStream.close();
        client.close();
    }

}
