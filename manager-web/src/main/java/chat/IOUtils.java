package cn.huateng.internet.chat;

import java.io.Closeable;
import java.io.IOException;

public class IOUtils {
    /**
     * �ͷ���Դ
     */
    public static void close(Closeable... targets){
        for(Closeable target :targets){
            if(null == target){
                try {
                    target.close();
                } catch (IOException e) {
                }
            }
        }
    }

}
