package cn.huateng.internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class UdpTalkSend implements Runnable{
    private DatagramSocket client;
    private BufferedReader reader ;
    private int toPort;
    private String toIp;
    public UdpTalkSend(int port, int toPort, String toIp){
        this.toPort = toPort;
        this.toIp = toIp;
        try {
            client = new DatagramSocket(port);
            reader= new BufferedReader(new InputStreamReader(System.in));
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(true) {
            String data;
            try {
                data = reader.readLine();
                byte[] datas = data.getBytes();
                //3、 封装成DatagramPacket 包裹，需要指定目的地
                DatagramPacket packet =new DatagramPacket(datas,0,datas.length,
                        new InetSocketAddress(this.toIp,this.toPort));
                //4、发送包裹send?(DatagramPacket p) *
                client.send(packet);
                if(data.equals("bye")) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        // 5、释放资源
        client.close();
    }
}
