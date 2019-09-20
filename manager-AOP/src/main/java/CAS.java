package cn.huateng.threadothers;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS:�Ƚϲ�����
 */
public class CAS {
    //���
    private static AtomicInteger stock = new AtomicInteger(5);//ԭ�Ӳ�����

    public static void main(String[] args) {
        for(int i=0;i<5;i++){
            new Thread(()->{
                //ģ�������ӳ�
                Integer left = stock.decrementAndGet();
                if(left<1){
                    System.out.println("�����ˡ�������");
                    return ;
                }
                System.out.print(Thread.currentThread().getName()+"����һ����Ʒ");
                System.out.println("-->��ʣ"+left);
            }).start();
        }
    }
}
