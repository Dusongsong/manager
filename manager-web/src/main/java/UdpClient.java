package cn.huateng.internet;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
        * �������̣����Ͷ�
        * 1.ʹ��DatagramSocket ָ���˿� �������Ͷ�
        * 2.׼������  һ��ת���ֽ�����
        * 3.��װDatagramPacket ��������Ҫָ��Ŀ�ĵ�
        * 4.���Ͱ���send��DatagrmaPacket p��
        * 5.�ͷ���Դ
        */
public class UdpClient {
    public static void main(String[] args) throws Exception{
        //ʹ��DatagramSocket ָ���˿� �������Ͷ�
        DatagramSocket clinet = new DatagramSocket(9999);
        // ׼������  һ��ת���ֽ�����
        String data="��á�������";
        byte[] datas = data.getBytes();
        //��װDatagramPacket ��������Ҫָ��Ŀ�ĵ�
        DatagramPacket packet = new DatagramPacket(datas,0,datas.length,
                new InetSocketAddress("localhost",8888));
        //���Ͱ���send��DatagrmaPacket p)
        clinet.send(packet);
        // �ͷ���Դ
        clinet.close();
    }

}
