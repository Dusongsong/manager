package cn.huateng.threadothers;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS:比较并交换
 */
public class CAS {
    //库存
    private static AtomicInteger stock = new AtomicInteger(5);//原子操作类

    public static void main(String[] args) {
        for(int i=0;i<5;i++){
            new Thread(()->{
                //模拟网络延迟
                Integer left = stock.decrementAndGet();
                if(left<1){
                    System.out.println("抢完了。。。。");
                    return ;
                }
                System.out.print(Thread.currentThread().getName()+"抢了一件商品");
                System.out.println("-->还剩"+left);
            }).start();
        }
    }
}
