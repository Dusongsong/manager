package cn.huateng.thread;

/**
 * �����̷߳�ʽһ
 * 1.�������̳�Thread+��дrun
 * 2.�����������������
 */
public class ThreadTest extends Thread{
    /**
     * �߳���ڵ�
     */
    @Override
    public void run() {
     for (int i=0;i<20;i++){
         System.out.println("aaaaaa");
     }
    }

    public static void main(String[] args){
        ThreadTest threadTest = new ThreadTest();
        threadTest.start();
        for (int i=0;i<20;i++){
            System.out.println("bbbbbb");
        }
    }


}
