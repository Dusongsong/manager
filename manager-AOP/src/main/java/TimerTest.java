package cn.huateng.threadothers;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 任务调度：Timer和TimerTask类
 */
public class TimerTest {
    public static void main(String[] args) {
        Timer timer = new Timer();
        Calendar calendar = new GregorianCalendar(2099,12,13,11,10,20);
        timer.schedule(new MyTask(),calendar.getTime(),2000);//指定时间
    }

}
//任务类
class MyTask extends TimerTask{
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("休息一会");
        }
        System.out.println("------end------");
    }
}
