package cn.huateng.demo;
import  java.awt.*;
import javax.swing.*;

public class BallGame2 extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.png");
	Image desk = Toolkit.getDefaultToolkit().getImage("images/desk.jpg");
	double x=100;//С��ĺ�����
	double y=100;//С���������
	double degree = 3.14/3;//���ȡ��˴����ǣ�60��
	
	//�����ڵķ���
	public void paint(Graphics g) {
	System.out.println("���ڻ�һ��");
	g.drawImage(desk, 0, 0, null);
	g.drawImage(ball, (int)x, (int)y, null);
	//���±߽���ײ
	x=x+10*Math.cos(degree);
	y=y+10*Math.sin(degree);
	if(y>500-40-30||y<40+40) {//500ʱ���ڸ߶ȣ�40�����ӱ߿�30����ֱ��;���һ��40�Ǳ������߶�
		degree = -degree;
	}
	//���ұ߽���ײ
	if(x<40||x>856-40-30) {
		degree = 3.14-degree;
	}
	}
	//���ڼ���
	public void launchFrame() {
		setSize(856,500);
		setLocation(50,50);
		setVisible(true);
	
	 //�ػ�����
		while(true) {
			repaint();
			try {
		Thread.sleep(40);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	//main��������ִ�����
	public static void main(String[] args) {
		System.out.println("----��Ϸ��������");
		BallGame2 game = new BallGame2();
		game.launchFrame();
	}
}
