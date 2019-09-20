package cn.huateng.thread;

/**
 * 模拟龟兔赛跑
 */
public class Racer implements Runnable{
    private static String Winner;//胜利者

    public static void main(String[] args) {
        Racer racer = new Racer();
        new Thread(racer,"tortoise").start();
        new Thread(racer,"rabbit").start();
    }
    @Override
    public void run() {
        for(int steps=1;steps<=100;steps++){
            if(Thread.currentThread().getName().equals("rabbit") && steps%10 == 0){
                try{
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

            }
            System.out.println(Thread.currentThread().getName()+":"+steps);
            //比赛是否结束
            boolean flag = gameOver(steps);
            if(flag){
                break;
            }
        }
    }

    private boolean gameOver(int steps){
        //是否存在胜利者
        if(Winner != null){
            return  true;
        }else{
            if(steps==100){
                Winner = Thread.currentThread().getName();
                System.out.println("Winner :"+Winner);
                return true;
            }
        }
        return false;
    }
}
