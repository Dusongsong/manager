package cn.huateng.internet;

import java.io.DataOutputStream;
import java.net.Socket;

/**
 * �����ͻ���
 */
public class TcpClient {
    public static void main(String[] args) throws Exception{

        System.out.println("----Client----");
        //1.�������ӣ�ʹ��Socket�����ͻ���+����ĵ�ַ+�˿�
        Socket client = new Socket("localhost",8888);
        //2.�������������������
        DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());
        String data = "hello world";
        outputStream.writeUTF(data);
        outputStream.flush();
        // 3.�ͷ���Դ
        outputStream.close();
        client.close();
    }

}
