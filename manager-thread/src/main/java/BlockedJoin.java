package cn.huateng.thread;

public class BlockedJoin {

    public static void main(String[] args) {
      new Thread(new Father()).start();
    }
}
class Father extends Thread{
    @Override
    public void run() {
        System.out.println("���ף���û�ˣ�����ȥ����");
        Thread thread = new Thread(new Son());
        thread.start();

        try{
            thread.join();//father������
       System.out.println("�ϰ֣��ӹ��Σ�����ȥ��");
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
class Son extends Thread{
    @Override
    public void run() {
        System.out.println("�����õ�Ǯ��ȥ�ˡ�������");
        System.out.println("·���и���Ϸ��������10��");
        for(int i=1;i<=10;i++){
            System.out.println(i+"���ȥ��");
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
        System.out.println("���ӣ������������ˣ��Ͻ�ȥ����");
    }
}