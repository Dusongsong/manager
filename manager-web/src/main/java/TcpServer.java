package cn.huateng.internet;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ����������
 *
 */
public class TcpServer {

    public static void main(String[] args) throws Exception{
        //1.ָ���˿� ʹ��ServerSocket����������
        ServerSocket server = new ServerSocket(8888);
        //2.����ʽ�ȴ����� accept
          Socket client = server.accept();
        System.out.println("һ���ͻ��˽��������ӡ���");
        //3.�������������������
        DataInputStream inputStream = new DataInputStream(client.getInputStream());
        String data = inputStream.readUTF();
        System.out.println(data);
        //4.�ͷ���Դ
        inputStream.close();
        client.close();
        server.close();
    }


}
