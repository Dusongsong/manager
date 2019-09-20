package cn.huateng.thread;

/**
 * 创建线程方式一
 * 1.创建：实现Runnable接口+重写run
 * 2.启动：创建实现类对象（Thread对象）+start
 */
public class RunnableTest implements Runnable{
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
       /* //创建实现类对象
        RunnableTest threadTest = new RunnableTest();
        //创建代理类对象
        Thread thread = new Thread(threadTest);
        //启动
        thread.start();*/
       //如果对象只是要用一次，既可以使用匿名
        new Thread(new RunnableTest()).start();
        for (int i=0;i<20;i++){
            System.out.println("bbbbbb");
        }
    }


}
