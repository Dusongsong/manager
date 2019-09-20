package cn.huateng.internet;

import java.io.*;
import java.net.Socket;

/**
 * 存储文件
 * 创建客户端
 */
public class TcpFileClient {
    public static void main(String[] args) throws Exception{

        System.out.println("----Client----");
        //1.创建连接：使用Socket创建客户端+服务的地址+端口
        Socket client = new Socket("localhost",8888);
        //2.操作：拷贝上传
        InputStream inputStream = new BufferedInputStream(new FileInputStream("imamges/ndl.png"));
        OutputStream outputStream =new BufferedOutputStream(client.getOutputStream());
        byte[] flush = new byte[1024];
        int len = -1;
        while ((len=inputStream.read(flush)) !=-1){
          outputStream.write(flush,0,len);
        }
        // 3.释放资源

        outputStream.close();
        inputStream.close();
        client.close();
    }

}
