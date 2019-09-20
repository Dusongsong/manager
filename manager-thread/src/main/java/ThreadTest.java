package cn.huateng.thread;

/**
 * 创建线程方式一
 * 1.创建：继承Thread+重写run
 * 2.启动：创建子类对象
 */
public class ThreadTest extends Thread{
    /**
     * 线程入口点
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
