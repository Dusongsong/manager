package cn.huateng.thread;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class Web12306 implements  Runnable{
  private int ticketNum = 99;
  private boolean flag=true;
    public static void main(String[] args) {
        //共享一份资源
        Web12306 web12306 = new Web12306();
        //多个代理
          new Thread(web12306,"飞猪").start();
          new Thread(web12306,"携程").start();
          new Thread(web12306,"同城").start();
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
        if (ticketNum <= 0) {//0票就退出
            return;
        }
        synchronized ( this) {//考虑最后1张票的情况
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
