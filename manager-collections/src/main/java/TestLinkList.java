package cn.huateng.collection;
/**
 * �Զ�������
 * @author Dusongsong
 *
 */
public class TestLinkList {
private Node first;
private Node last;
private int size;

   public void add(Object obj) {
	   Node node = new Node(obj);
	   if(first ==null) {
		   first=node;
		   last = node;
	   }else {
		   node.previous = last;
		   node.next = null;
		   last.next = node;
		   last = node;
	   }
   }
	
}
