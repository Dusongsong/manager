package cn.huateng.internet;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
        * 基本流程：发送端
        * 1.使用DatagramSocket 指定端口 创建发送端
        * 2.准备数据  一定转成字节数组
        * 3.封装DatagramPacket 包裹，需要指定目的地
        * 4.发送包裹send（DatagrmaPacket p）
        * 5.释放资源
        */
public class UdpClient {
    public static void main(String[] args) throws Exception{
        //使用DatagramSocket 指定端口 创建发送端
        DatagramSocket clinet = new DatagramSocket(9999);
        // 准备数据  一定转成字节数组
        String data="你好。。。。";
        byte[] datas = data.getBytes();
        //封装DatagramPacket 包裹，需要指定目的地
        DatagramPacket packet = new DatagramPacket(datas,0,datas.length,
                new InetSocketAddress("localhost",8888));
        //发送包裹send（DatagrmaPacket p)
        clinet.send(packet);
        // 释放资源
        clinet.close();
    }

}
