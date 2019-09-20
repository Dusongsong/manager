package cn.huateng.demo;

public class TestEnum {

	public static void main(String[] args) {
		Season son = Season.AUTUMN;
		
		switch(son) {
		case SPRING:System.out.println("春天。。。。");break;
		case SUMMER:System.out.println("夏天。。。。");break;
		case AUTUMN:System.out.println("秋天。。。。");break;
		case WINTER:System.out.println("冬天。。。。");break;
		
		}
	}
	
	enum Season{
		SPRING,SUMMER,AUTUMN,WINTER
	}
    enum Week{
    	星期一,星期二,星期三,星期四,星期五,星期六,星期日
    }
	
}
