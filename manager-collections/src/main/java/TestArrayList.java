package cn.huateng.collection;

/**
 * ����get��set���� ��������߽�ļ��
 * 
 * @author Dusongsong
 *
 * @param <T>
 */
public class TestArrayList<T> {

	private Object[] elementData;
	private int size;
	private static final int DEFALT_CAPACITY = 10;

	public TestArrayList() {
		elementData = new Object[DEFALT_CAPACITY];
	}

	public TestArrayList(int capacity) {
		elementData = new Object[capacity];
	}
 
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0?true:false;
	}
	public void add(T element) {
		if (size == elementData.length) {
			Object[] newArray = new Object[elementData.length + (elementData.length >> 1)];// ���ݵĳ���1.5��
			System.arraycopy(elementData, 0, newArray, 0, elementData.length);
			elementData = newArray;
		}
		elementData[size++] = element;
	}

	public T get(int index) {
        checkRange(index);
		return (T) elementData[index];
	}

	public void checkRange(int index) {
		// �ж������Ϸ�
		if (index < 0 || index > size - 1) {
			throw new RuntimeException("�������Ϸ�:" + index);
		}

	}

	public void set(T element, int index) {
		  checkRange(index);
		elementData[index] = element;
	}
   
	public void remove(T element) {
		//����������Ԫ�ذ����Ƚϣ���õ�һ���Ƚ�Ϊtrue�ģ�����
		for(int i = 0;i<size;i++) {
			if(element.equals(get(i))) {
				remove(i);
				
			}
		}
	}
	 public void remove(int index) {
		 
		 int numMoved = elementData.length-index-1;
		 if(numMoved>0) { 
			 System.arraycopy(elementData, index+1, elementData, index, numMoved);
		 }
			 elementData[--size] = null;
	
	 }
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < size; i++) {
			sb.append(elementData[i] + ",");
		}
		sb.setCharAt(sb.length() - 1, ']');
		return sb.toString();
	}

	public static void main(String[] args) {
		TestArrayList<String> arrayList = new TestArrayList<String>();
		for (int i = 0; i < 40; i++) {
			arrayList.add("aa" + i);

		}
		arrayList.set("bb", 10);
		System.out.println("--:" + arrayList);
		System.out.println("--:" + arrayList.get(40));

	}
}
