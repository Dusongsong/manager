package cn.huateng.demo;

public class TestEnum {

	public static void main(String[] args) {
		Season son = Season.AUTUMN;
		
		switch(son) {
		case SPRING:System.out.println("���졣������");break;
		case SUMMER:System.out.println("���졣������");break;
		case AUTUMN:System.out.println("���졣������");break;
		case WINTER:System.out.println("���졣������");break;
		
		}
	}
	
	enum Season{
		SPRING,SUMMER,AUTUMN,WINTER
	}
    enum Week{
    	����һ,���ڶ�,������,������,������,������,������
    }
	
}
