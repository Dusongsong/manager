package cn.huateng.thread;

public class StaticProxy {


}
interface Marry{
    void happyMarry();
}
class YOU implements Marry{
    public static void main(String[] args) {
        new WeddingComcony(new YOU()).happyMarry();

    }
    @Override
    public void happyMarry() {
        System.out.println("终于结婚了。。。。。。。");
    }
}
class WeddingComcony implements Marry{
    private YOU you;

    public WeddingComcony(YOU you) {
        this.you = you;
    }

    @Override
    public void happyMarry() {
      ready();
      this.you.happyMarry();
      after();
    }

    private  void ready(){
        System.out.println("替你准备婚礼");
    }
    private void after(){
        System.out.println("结完婚给钱吧");
    }
}