package cn.huateng.internet;

public class UdpTalkTeacher {
    public static void main(String[] args) {
        //接收
        new Thread(new UdpTalkRecevie(9999,"学生")).start();
       //发送
        new Thread(new UdpTalkSend(5555,8888,"localhost")).start();

    }
}
