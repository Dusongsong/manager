package cn.huateng.internet;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ����������
 *
 */
public class TcpLoginServer {

    public static void main(String[] args) throws Exception{
        //1.ָ���˿� ʹ��ServerSocket����������
        ServerSocket server = new ServerSocket(8888);
        //2.����ʽ�ȴ����� accept
          Socket client = server.accept();
        System.out.println("һ���ͻ��˽��������ӡ���");
        //3.�������������������
        DataInputStream inputStream = new DataInputStream(client.getInputStream());
        String data = inputStream.readUTF();
         String [] dataArray = data.split("&");
         for(String info : dataArray){
             String [] userInfo = info.split("=");
             if(userInfo[0].equals("uname")) {
                 System.out.println("����û���Ϊ:"+userInfo[1]);
             }else if(userInfo[0].equals("upwd")) {
                 System.out.println("�������Ϊ:"+userInfo[1]);
             }
         }
        //4.�ͷ���Դ
        inputStream.close();
        client.close();
        server.close();
    }


}
