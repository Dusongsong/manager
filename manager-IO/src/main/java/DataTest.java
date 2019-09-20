package cn.huateng.io;

import java.io.*;

/**
 * ������
 * 1.д�����ȡ
 * 2.��ȡ��˳����д���ı���һ��
 * DateOutputStream
 * DataInputStream
 */
public class DataTest {
  public static void main(String[] args) throws IOException {
      //д��
      ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
      DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(arrayOutputStream));
      //������������+����
      dataOutputStream.writeUTF("����ַַ�");
      dataOutputStream.writeInt(18);
      dataOutputStream.writeBoolean(false);
      dataOutputStream.writeChar('a');
      dataOutputStream.flush();
      byte[] datas = arrayOutputStream.toByteArray();
      //��ȡ
      DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
     //д��˳��һ��
      String msg = dataInputStream.readUTF();
      int age = dataInputStream.readInt();
     boolean flag =  dataInputStream.readBoolean();
      char ch = dataInputStream.readChar();
      System.out.println(msg);

  }


}
