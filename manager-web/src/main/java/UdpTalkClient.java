package cn.huateng.internet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
        * ��ν��������Ͷ�
        * 1.ʹ��DatagramSocket ָ���˿� �������Ͷ�
        * 2.׼������  һ��ת���ֽ�����
        * 3.��װDatagramPacket ��������Ҫָ��Ŀ�ĵ�
        * 4.���Ͱ���send��DatagrmaPacket p��
        * 5.�ͷ���Դ
        */
public class UdpTalkClient {
    public static void main(String[] args) throws Exception{
        System.out.println("���ͷ�������������");
        //ʹ��DatagramSocket ָ���˿� �������Ͷ�
        DatagramSocket clinet = new DatagramSocket(9999);
        // ׼������  һ��ת���ֽ�����
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String data = reader.readLine();
            byte[] datas = data.getBytes();
            //��װDatagramPacket ��������Ҫָ��Ŀ�ĵ�
            DatagramPacket packet = new DatagramPacket(datas,0,datas.length,
                    new InetSocketAddress("localhost",8888));
            //���Ͱ���send��DatagrmaPacket p)
            clinet.send(packet);
            if(data.equals("�ټ�")){
                break;
            }
        }

        // �ͷ���Դ
        clinet.close();
    }

}
