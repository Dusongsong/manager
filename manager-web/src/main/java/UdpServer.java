package cn.huateng.internet;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 基本流程：接收端
 * 1.使用DatagramSocket 指定端口 创建接收端
 * 2.准备容器 封装成DatagramPacket 包裹
 * 3.阻塞式接收包裹 receive(DatagramPacket p)
 * 4.分析数据 byte[] getData   getLength()
 * 5.释放资源
 */
public class UdpServer {
    public static void main(String[] args) throws Exception {
        System.out.println("接收方启动。。。");
        //使用DatagramSocket 指定端口 创建接收端
        DatagramSocket server = new DatagramSocket(8888);
        //准备容器 封装成DatagramPacket 包裹
        byte[] container = new byte[1024*60];
        DatagramPacket packet = new DatagramPacket(container,0,container.length);
        //阻塞式接收包裹 receive(DatagramPacket p)
         server.receive(packet);
        //分析数据 byte[] getData   getLength()
        byte[] datas = packet.getData();
        int len = packet.getLength();
        System.out.println(new String(datas,0,len));
        //释放资源
        server.close();
    }

}
