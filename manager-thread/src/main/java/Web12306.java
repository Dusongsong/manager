package cn.huateng.thread;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class Web12306 implements  Runnable{
  private int ticketNum = 99;
  private boolean flag=true;
    public static void main(String[] args) {
        //����һ����Դ
        Web12306 web12306 = new Web12306();
        //�������
          new Thread(web12306,"����").start();
          new Thread(web12306,"Я��").start();
          new Thread(web12306,"ͬ��").start();
    }

    @Override
    public  void run() {
        while(flag){
            try{
                Thread.sleep(200);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            test01();
        }

    }

    public void test01() {
        if (ticketNum <= 0) {//0Ʊ���˳�
            return;
        }
        synchronized ( this) {//�������1��Ʊ�����
            if (ticketNum <= 0) {
                return;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":" + ticketNum--);
        }
    }

}
