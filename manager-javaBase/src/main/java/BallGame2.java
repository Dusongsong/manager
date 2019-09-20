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
	double x=100;//小球的横坐标
	double y=100;//小球的纵坐标
	double degree = 3.14/3;//弧度。此处就是：60度
	
	//画窗口的方法
	public void paint(Graphics g) {
	System.out.println("窗口画一次");
	g.drawImage(desk, 0, 0, null);
	g.drawImage(ball, (int)x, (int)y, null);
	//上下边界碰撞
	x=x+10*Math.cos(degree);
	y=y+10*Math.sin(degree);
	if(y>500-40-30||y<40+40) {//500时窗口高度，40是桌子边框，30是球直径;最后一个40是标题栏高度
		degree = -degree;
	}
	//左右边界碰撞
	if(x<40||x>856-40-30) {
		degree = 3.14-degree;
	}
	}
	//窗口加载
	public void launchFrame() {
		setSize(856,500);
		setLocation(50,50);
		setVisible(true);
	
	 //重画窗口
		while(true) {
			repaint();
			try {
		Thread.sleep(40);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	//main方法程序执行入口
	public static void main(String[] args) {
		System.out.println("----游戏跑起来了");
		BallGame2 game = new BallGame2();
		game.launchFrame();
	}
}
