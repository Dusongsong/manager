package cn.huateng.thread;

/**
 * 协作模型：生产者消费者实现方式一：管程法
 * 借助缓冲区
 */
public class CoTest01 {
    public static void main(String[] args) {
        SynContainter synContainter = new SynContainter();
        new Productor(synContainter).start();
        new Consumer(synContainter).start();
    }
}
//生产者
class Productor extends Thread{
    SynContainter containter;
    public Productor( SynContainter containter){
        this.containter = containter;
    }
    @Override
    public void run() {
        //生产
        for(int i=0;i<100;i++){
            System.out.println("生产-->"+i+"个商品");
            containter.push(new Goods(i));
        }
    }
}
//消费者
class Consumer extends Thread{
    SynContainter containter;
    public Consumer(SynContainter containter){
        this.containter = containter;
    }

    @Override
    public void run() {
      for (int i = 0;i<100;i++){
          System.out.println("消费-->"+containter.pop().id+"个商品");
      }
    }
}
//缓冲区
class SynContainter{
    int counts = 0;//计数器
    Goods[] goods = new Goods[10];//容器

    public synchronized void push(Goods good){//存放
        if(counts ==goods.length){//存放空间满了，线程阻塞
            try{
                this.wait();
            }catch (InterruptedException e){
                    e.printStackTrace();
            }

        }
        goods[counts] = good;//存在空间可以生产
        counts++;
        this.notifyAll();//通知消费者消费

    }
    //获取
    public synchronized Goods pop(){
        if(counts ==0){
            try{
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        //存在数据可以消费
        counts--;
        Goods good = goods[counts];
        this.notifyAll();//存在空间了，可以唤醒生产者可以生产
        return good;
    }

}
class Goods{
    int id;

    public Goods(int id) {
        this.id = id;
    }
}
