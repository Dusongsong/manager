package cn.huateng.internet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ģ���¼ ˫��
 * ����������
 *
 */
public class TcpLoginTwoWayServer {

    public static void main(String[] args) throws Exception{
        //1.ָ���˿� ʹ��ServerSocket����������
        ServerSocket server = new ServerSocket(8888);
        //2.����ʽ�ȴ����� accept
          Socket client = server.accept();
        System.out.println("һ���ͻ��˽��������ӡ���");
        //3.�������������������
        DataInputStream inputStream = new DataInputStream(client.getInputStream());
        String data = inputStream.readUTF();
        String uname ="";
        String upwd ="";
         String [] dataArray = data.split("&");
         for(String info : dataArray){
             String [] userInfo = info.split("=");
             if(userInfo[0].equals("uname")) {
                 System.out.println("����û���Ϊ:"+userInfo[1]);
             }else if(userInfo[0].equals("upwd")) {
                 System.out.println("�������Ϊ:"+userInfo[1]);
             }
         }
        //���
        DataOutputStream dos =new DataOutputStream(client.getOutputStream());
        if(uname.equals("shsxt") && upwd.equals("laopei")) { //�ɹ�
            dos.writeUTF("��¼�ɹ�����ӭ����");
        }else { //ʧ��
            dos.writeUTF("�û������������");
        }
        dos.flush();
        //4.�ͷ���Դ
        inputStream.close();
        client.close();
        server.close();
    }


}
