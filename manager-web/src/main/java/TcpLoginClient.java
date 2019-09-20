package cn.huateng.internet;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * ģ���¼ ����
 * �����ͻ���
 */
public class TcpLoginClient {
    public static void main(String[] args) throws Exception{

        System.out.println("----Client----");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("�������û���:");
        String uname = reader.readLine();
        System.out.print("����������:");
        String upwd = reader.readLine();
        //1.�������ӣ�ʹ��Socket�����ͻ���+����ĵ�ַ+�˿�
        Socket client = new Socket("localhost",8888);
        //2.�������������������
        DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());
        outputStream.writeUTF("uname="+uname+"&"+"upwd="+upwd);
        outputStream.flush();
        // 3.�ͷ���Դ
        outputStream.close();
        client.close();
    }

}
