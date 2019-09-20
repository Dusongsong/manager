package cn.huateng.threadothers;

/**
 * 指令重排：代码执行的顺序与预期的不一致
 * 目的：提高性能
 */
public class HappenBefore {
    //变量1
    private static int a =0;
    //变量2
    private static boolean flag =false;

    public static void main(String[] args) throws Exception{
        for(int i=0;i<10;i++){
            a = 0;
            flag =false;
            //线程1 更改数据
            Thread t1 = new Thread(()->{
                a = 1;
                flag = true;
            });
            //线程2 更改数据
            Thread t2 = new Thread(()->{
                if(flag){
                    a *=1;

                }
                //指令重排
                if(a ==0){
                    System.out.println("happen before a->"+a);
                }
            });
            t1.start();
            t2.start();
            //合并线程
            t1.join();
            t2.join();
        }
    }
}
