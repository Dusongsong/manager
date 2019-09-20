package cn.huateng.internet;


public class UdpTalkStudent {
    public static void main(String[] args) {
        //发送
        new Thread(new UdpTalkSend(7777,9999,"localhost")).start();
        //接收
        new Thread(new UdpTalkRecevie(8888,"老师")).start();
    }


}
