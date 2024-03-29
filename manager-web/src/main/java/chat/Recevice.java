package cn.huateng.internet.chat;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 使用多线程封装
 * 接收
 *  1、接收消息
 *  * 2、释放资源
 *  * 3、重写run
 */
public class Recevice implements Runnable{
    private Socket client;
    private boolean isRunning;
    private DataInputStream inputStream;
    public Recevice(Socket client) {
        this.client = client;
        try {
            inputStream = new DataInputStream(client.getInputStream());
        } catch (IOException e) {
            System.out.println("====2=====");
            release();
        }
    }
    //接收消息
    public String receive(){
        String msg = "";
        try {
            msg = inputStream.readUTF();
        } catch (IOException e) {
            System.out.println("====4====");
            release();
        }
        return msg;
    }

   //释放资源
    private void release() {
        this.isRunning = false;
        IOUtils.close(inputStream,client);
    }
    //重写run方法
    @Override
    public void run() {
     while (isRunning){
         String msg =receive();
         if(!msg.equals("")) {
             System.out.println(msg);
         }
     }
    }
}
