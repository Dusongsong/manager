package cn.huateng.internet.chat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *  ʹ�ö��̷߳�װ:���Ͷ�
 *  1��������Ϣ
 *  2���ӿ���̨��ȡ��Ϣ
 *  3���ͷ���Դ
 *  4����дrun
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



    //1��������Ϣ
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
    //2���ӿ���̨��ȡ��Ϣ
    public String getConMsg(){
        try {
           return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
    //3���ͷ���Դ
    private void release() {
        this.isRunning =false;
        IOUtils.close(outputStream,client);
    }
    //4����дrun

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
