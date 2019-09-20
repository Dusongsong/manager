package cn.huateng.io;

import java.io.*;

/**
 * 数据流
 * 1.写出后读取
 * 2.读取的顺序与写出的保持一致
 * DateOutputStream
 * DataInputStream
 */
public class DataTest {
  public static void main(String[] args) throws IOException {
      //写出
      ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
      DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(arrayOutputStream));
      //操作数据类型+数据
      dataOutputStream.writeUTF("编码分分分");
      dataOutputStream.writeInt(18);
      dataOutputStream.writeBoolean(false);
      dataOutputStream.writeChar('a');
      dataOutputStream.flush();
      byte[] datas = arrayOutputStream.toByteArray();
      //读取
      DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
     //写出顺序一致
      String msg = dataInputStream.readUTF();
      int age = dataInputStream.readInt();
     boolean flag =  dataInputStream.readBoolean();
      char ch = dataInputStream.readChar();
      System.out.println(msg);

  }


}
