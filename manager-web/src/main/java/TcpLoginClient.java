package cn.huateng.internet;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 模拟登录 单向
 * 创建客户端
 */
public class TcpLoginClient {
    public static void main(String[] args) throws Exception{

        System.out.println("----Client----");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("请输入用户名:");
        String uname = reader.readLine();
        System.out.print("请输入密码:");
        String upwd = reader.readLine();
        //1.创建连接：使用Socket创建客户端+服务的地址+端口
        Socket client = new Socket("localhost",8888);
        //2.操作：输入输出流操作
        DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());
        outputStream.writeUTF("uname="+uname+"&"+"upwd="+upwd);
        outputStream.flush();
        // 3.释放资源
        outputStream.close();
        client.close();
    }

}
