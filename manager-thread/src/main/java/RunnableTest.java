package cn.huateng.thread;

/**
 * �����̷߳�ʽһ
 * 1.������ʵ��Runnable�ӿ�+��дrun
 * 2.����������ʵ�������Thread����+start
 */
public class RunnableTest implements Runnable{
    /**
     * �߳���ڵ�
     */
    @Override
    public void run() {
     for (int i=0;i<20;i++){
         System.out.println("aaaaaa");
     }
    }

    public static void main(String[] args){
       /* //����ʵ�������
        RunnableTest threadTest = new RunnableTest();
        //�������������
        Thread thread = new Thread(threadTest);
        //����
        thread.start();*/
       //�������ֻ��Ҫ��һ�Σ��ȿ���ʹ������
        new Thread(new RunnableTest()).start();
        for (int i=0;i<20;i++){
            System.out.println("bbbbbb");
        }
    }


}
