package cn.huateng.internet;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 接收端：使用面向对象封装
 */
public class UdpTalkRecevie implements Runnable{
     //使用DatagramSocket 指定端口 创建接收端
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
            // 2、准备容器 封装成DatagramPacket 包裹
            byte[] container =new byte[1024*60];
            DatagramPacket packet = new DatagramPacket(container,0,container.length);
            // 3、阻塞式接收包裹receive?(DatagramPacket p)
            try {
                server.receive(packet);//阻塞式
                // 4、分析数据
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
        // 5、释放资源
        server.close();
    }
}
