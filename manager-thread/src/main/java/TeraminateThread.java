package cn.huateng.thread;

/**
 * ͨ����ʶ��ֹ�߳�
 */
public class TeraminateThread implements Runnable{
    private boolean flag;
    private String name;

    public TeraminateThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        int i=0;
        while (flag){//������ʶ
            System.out.println(name+"-->"+i++);
        }
    }

    private void teraminateThread(){
          this.flag = false;
    }

    public static void main(String[] args) {
        TeraminateThread thread = new TeraminateThread("C��");
        new Thread(thread).start();
        for(int i=0;i<99;i++){
            if(i==88){
                thread.teraminateThread();
                System.out.println("game over");
            }
            System.out.println("main-->"+i);
        }
    }
}
