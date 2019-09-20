package cn.huateng.internet.chat;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * ʹ�ö��̷߳�װ
 * ����
 *  1��������Ϣ
 *  * 2���ͷ���Դ
 *  * 3����дrun
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
    //������Ϣ
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

   //�ͷ���Դ
    private void release() {
        this.isRunning = false;
        IOUtils.close(inputStream,client);
    }
    //��дrun����
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
