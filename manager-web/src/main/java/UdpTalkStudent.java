package cn.huateng.internet;


public class UdpTalkStudent {
    public static void main(String[] args) {
        //����
        new Thread(new UdpTalkSend(7777,9999,"localhost")).start();
        //����
        new Thread(new UdpTalkRecevie(8888,"��ʦ")).start();
    }


}
