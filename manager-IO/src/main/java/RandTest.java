package cn.huateng.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;


public class RandTest {
    public static void main(String[] args) throws IOException {
      //分多少块
        File src = new File("p.png");
        //总长度
        long len = src.length();
        //每块大小
        int blockSize = 1024;
        int size = (int) Math.ceil(len*1.0/blockSize);
        //起始位置和实际大小
        int beginPos = 0;
        int actualSize = blockSize>len? (int) len :blockSize;
        for(int i=0;i<size;i++){
            beginPos = i*blockSize;
            if(i==size-1){//最后一块
                actualSize = (int) len;
            }else{
                actualSize=blockSize;
                len -=actualSize;//剩余量
            }
            System.out.println(i+"-->"+beginPos +"-->"+actualSize);
            split(i,beginPos,actualSize);
        }
    }

    /**
     * 指定第i块的起始位置 和实际长度
     * @param i
     * @param beginPos
     * @param actualSize
     */
    public static  void split(int i,int beginPos,int actualSize) throws IOException {
        RandomAccessFile raf =new RandomAccessFile(new File("p.png"),"r");
        RandomAccessFile raf2 =new RandomAccessFile(new File("dest/"+i+"p.png"),"rw");
        //随机读取
        raf.seek(beginPos);
        //分段读取
        byte[] flush = new byte[1024];
        int len = -1;
        while ((len = raf.read(flush))!=-1){
           if(actualSize>len){//获取本次读取的所有内容
               raf2.write(flush,0,len);
               actualSize = len;
           }else{
               raf2.write(flush,0,actualSize);
               break;
           }
        }
        raf.close();
        raf2.close();
    }
}