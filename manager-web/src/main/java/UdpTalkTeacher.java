package cn.huateng.internet;

public class UdpTalkTeacher {
    public static void main(String[] args) {
        //����
        new Thread(new UdpTalkRecevie(9999,"ѧ��")).start();
       //����
        new Thread(new UdpTalkSend(5555,8888,"localhost")).start();

    }
}
