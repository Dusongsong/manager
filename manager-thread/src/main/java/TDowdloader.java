package cn.huateng.thread;

public class TDowdloader extends Thread{
    private String url;
    private String name;

    public TDowdloader(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
       WebDownloader downloader = new WebDownloader();
        downloader.download(url,name);
    }

    public static void main(String[] args) {
        TDowdloader tDowdloader1 = new TDowdloader("","");
        TDowdloader tDowdloader2 = new TDowdloader("","");
        TDowdloader tDowdloader3 = new TDowdloader("","");
        //启动三个线程
        tDowdloader1.start();
        tDowdloader2.start();
        tDowdloader3.start();
    }
}
