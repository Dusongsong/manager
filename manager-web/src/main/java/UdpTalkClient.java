package cn.huateng.internet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
        * 多次交流：发送端
        * 1.使用DatagramSocket 指定端口 创建发送端
        * 2.准备数据  一定转成字节数组
        * 3.封装DatagramPacket 包裹，需要指定目的地
        * 4.发送包裹send（DatagrmaPacket p）
        * 5.释放资源
        */
public class UdpTalkClient {
    public static void main(String[] args) throws Exception{
        System.out.println("发送方启动。。。。");
        //使用DatagramSocket 指定端口 创建发送端
        DatagramSocket clinet = new DatagramSocket(9999);
        // 准备数据  一定转成字节数组
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String data = reader.readLine();
            byte[] datas = data.getBytes();
            //封装DatagramPacket 包裹，需要指定目的地
            DatagramPacket packet = new DatagramPacket(datas,0,datas.length,
                    new InetSocketAddress("localhost",8888));
            //发送包裹send（DatagrmaPacket p)
            clinet.send(packet);
            if(data.equals("再见")){
                break;
            }
        }

        // 释放资源
        clinet.close();
    }

}
