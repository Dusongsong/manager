package cn.huateng.thread;

public class BlockedJoin {

    public static void main(String[] args) {
      new Thread(new Father()).start();
    }
}
class Father extends Thread{
    @Override
    public void run() {
        System.out.println("父亲：盐没了，儿子去买盐");
        Thread thread = new Thread(new Son());
        thread.start();

        try{
            thread.join();//father被阻塞
       System.out.println("老爸：接过盐，炒菜去了");
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
class Son extends Thread{
    @Override
    public void run() {
        System.out.println("儿子拿到钱出去了。。。。");
        System.out.println("路边有个游戏厅，玩了10秒");
        for(int i=1;i<=10;i++){
            System.out.println(i+"秒过去了");
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
        System.out.println("儿子：想起来买盐了，赶紧去买盐");
    }
}