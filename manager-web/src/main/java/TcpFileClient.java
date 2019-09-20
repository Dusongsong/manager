package cn.huateng.internet;

import java.io.*;
import java.net.Socket;

/**
 * �洢�ļ�
 * �����ͻ���
 */
public class TcpFileClient {
    public static void main(String[] args) throws Exception{

        System.out.println("----Client----");
        //1.�������ӣ�ʹ��Socket�����ͻ���+����ĵ�ַ+�˿�
        Socket client = new Socket("localhost",8888);
        //2.�����������ϴ�
        InputStream inputStream = new BufferedInputStream(new FileInputStream("imamges/ndl.png"));
        OutputStream outputStream =new BufferedOutputStream(client.getOutputStream());
        byte[] flush = new byte[1024];
        int len = -1;
        while ((len=inputStream.read(flush)) !=-1){
          outputStream.write(flush,0,len);
        }
        // 3.�ͷ���Դ

        outputStream.close();
        inputStream.close();
        client.close();
    }

}
