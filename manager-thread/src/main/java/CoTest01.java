package cn.huateng.thread;

/**
 * Э��ģ�ͣ�������������ʵ�ַ�ʽһ���̷ܳ�
 * ����������
 */
public class CoTest01 {
    public static void main(String[] args) {
        SynContainter synContainter = new SynContainter();
        new Productor(synContainter).start();
        new Consumer(synContainter).start();
    }
}
//������
class Productor extends Thread{
    SynContainter containter;
    public Productor( SynContainter containter){
        this.containter = containter;
    }
    @Override
    public void run() {
        //����
        for(int i=0;i<100;i++){
            System.out.println("����-->"+i+"����Ʒ");
            containter.push(new Goods(i));
        }
    }
}
//������
class Consumer extends Thread{
    SynContainter containter;
    public Consumer(SynContainter containter){
        this.containter = containter;
    }

    @Override
    public void run() {
      for (int i = 0;i<100;i++){
          System.out.println("����-->"+containter.pop().id+"����Ʒ");
      }
    }
}
//������
class SynContainter{
    int counts = 0;//������
    Goods[] goods = new Goods[10];//����

    public synchronized void push(Goods good){//���
        if(counts ==goods.length){//��ſռ����ˣ��߳�����
            try{
                this.wait();
            }catch (InterruptedException e){
                    e.printStackTrace();
            }

        }
        goods[counts] = good;//���ڿռ��������
        counts++;
        this.notifyAll();//֪ͨ����������

    }
    //��ȡ
    public synchronized Goods pop(){
        if(counts ==0){
            try{
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        //�������ݿ�������
        counts--;
        Goods good = goods[counts];
        this.notifyAll();//���ڿռ��ˣ����Ի��������߿�������
        return good;
    }

}
class Goods{
    int id;

    public Goods(int id) {
        this.id = id;
    }
}
