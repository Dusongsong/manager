package cn.huateng.internet.chat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *  使用多线程封装:发送端
 *  1、发送消息
 *  2、从控制台获取消息
 *  3、释放资源
 *  4、重写run
 */
public class Send implements  Runnable{
      private Socket client;
      private DataOutputStream outputStream;
      private BufferedReader reader;
      private boolean isRunning;

    public Send(Socket client) {
        this.client = client;
        reader = new BufferedReader(new InputStreamReader(System.in));
        this.isRunning=true;
        try {
            outputStream = new DataOutputStream(client.getOutputStream());
        } catch (IOException e) {
            System.out.println("==1==");
            this.release();
        }
    }



    //1、发送消息
    public void send(String msg){
        try {
            outputStream.writeUTF(msg);
            outputStream.flush();
        } catch (IOException e) {
            System.out.println(e);
            System.out.println("===3==");
            release();
        }

    }
    //2、从控制台获取消息
    public String getConMsg(){
        try {
           return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
    //3、释放资源
    private void release() {
        this.isRunning =false;
        IOUtils.close(outputStream,client);
    }
    //4、重写run

    @Override
    public void run() {
      while (isRunning){
         String msg = getConMsg();
         if(!msg.equals("")){
             send(msg);
         }

      }
    }
}
