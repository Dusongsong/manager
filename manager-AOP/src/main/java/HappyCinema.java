package cn.huateng.threadothers;

public class HappyCinema {
    public static void main(String[] args) {
        Cinema cinema = new Cinema(20,"万达");
        new Thread(new Customer(cinema,4),"张三").start();
        new Thread(new Customer(cinema,2),"李四").start();
        new Thread(new Customer(cinema,3),"王戈").start();
        new Thread(new Customer(cinema,3),"王五").start();
    }
}
class Cinema{
    int available;//可用位置
    String name;//名称
    public Cinema(int available, String name) {
        this.available = available;
        this.name = name;
    }
    //购票
    public boolean buyTicket(int seats){
        if(available<seats){
            return false;
        }
        available -=seats;
        return true;
    }

}
class Customer implements Runnable{
    Cinema cinema;
    int seats;
    public Customer(Cinema cinema, int seats) {
        this.cinema = cinema;
        this.seats = seats;
    }

    @Override
    public void run() {
        synchronized ( cinema ){
            boolean flag = cinema.buyTicket(seats);
            if(flag){
                System.out.println("出票成功"+Thread.currentThread().getName()+"位置为"+seats);
                System.out.println("可用位置为："+cinema.available);
            }else{
                System.out.println("出票失败"+Thread.currentThread().getName()+"位置为不够");
            }
        }

    }
}

