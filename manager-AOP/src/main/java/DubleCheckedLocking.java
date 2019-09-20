package cn.huateng.threadothers;



/**
 * DCL:单例模式：懒汉式套路基础上加入并发控制，保证在多线程环境下，对外存在一个对象
 * 1.构造器私有化-->避免外部new构造器
 * 2.提供私有的静态属性-->存储对象的地址
 * 3.提供公共的静态方法-->获取属性
 */
public class DubleCheckedLocking {
    //构造器私有化
    private DubleCheckedLocking(){

    }
    //2.提供私有的静态属性
    //没有 volatile 其他线程可能访问一个没有初始化的对象
    private static volatile DubleCheckedLocking instance;
    //提供公共的静态方法
    public static DubleCheckedLocking getInstance(){
        //再次检测
        if(null != instance){//避免不必要的同步 ，已经存在对象
            return instance;
        }
        synchronized ( DubleCheckedLocking.class ){
            if(null == instance){
                instance = new DubleCheckedLocking(); //1、开辟空间 //2、初始化对象信息 //3、返回对象的地址给引用
            }
        }


        return instance;
    }
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            System.out.println(DubleCheckedLocking.getInstance());
        });
        thread.start();
        System.out.println(DubleCheckedLocking.getInstance());
    }
}
