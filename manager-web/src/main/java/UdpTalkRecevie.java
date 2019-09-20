package cn.huateng.internet;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * ���նˣ�ʹ����������װ
 */
public class UdpTalkRecevie implements Runnable{
     //ʹ��DatagramSocket ָ���˿� �������ն�
     private  DatagramSocket server;
     private String from;
    public UdpTalkRecevie(int port, String form){
        this.from = form;
        try {
            server = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        while(true) {
            // 2��׼������ ��װ��DatagramPacket ����
            byte[] container =new byte[1024*60];
            DatagramPacket packet = new DatagramPacket(container,0,container.length);
            // 3������ʽ���հ���receive?(DatagramPacket p)
            try {
                server.receive(packet);//����ʽ
                // 4����������
                byte[]  datas =packet.getData();
                int len = packet.getLength();
                String data=new String(datas,0,len);
                System.out.println(from+":"+data);
                if(data.equals("bye")) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 5���ͷ���Դ
        server.close();
    }
}
