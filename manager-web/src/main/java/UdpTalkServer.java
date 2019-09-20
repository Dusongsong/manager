package cn.huateng.internet;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * �������̣����ն�
 * 1.ʹ��DatagramSocket ָ���˿� �������ն�
 * 2.׼������ ��װ��DatagramPacket ����
 * 3.����ʽ���հ��� receive(DatagramPacket p)
 * 4.�������� byte[] getData   getLength()
 * 5.�ͷ���Դ
 */
public class UdpTalkServer {
    public static void main(String[] args) throws Exception {
        System.out.println("���շ�����������");
        //ʹ��DatagramSocket ָ���˿� �������ն�
        DatagramSocket server = new DatagramSocket(8888);
        while(true){
            //׼������ ��װ��DatagramPacket ����
            byte[] container = new byte[1024*60];
            DatagramPacket packet = new DatagramPacket(container,0,container.length);
            //����ʽ���հ��� receive(DatagramPacket p)
            server.receive(packet);
            //�������� byte[] getData   getLength()
            byte[] datas = packet.getData();
            int len = packet.getLength();
            String data = new String(datas,0,len);
            System.out.println(data);
            if(data.equals("�ټ�")){
                break;
            }
        }

        //�ͷ���Դ
        server.close();
    }

}
