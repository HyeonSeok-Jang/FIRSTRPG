package Test;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Test implements Runnable, KeyListener{
//public class Test extends YuushaMove{
	private ImageIcon YuushaImg = new ImageIcon("src\\Source\\Character\\주인공_normal_1.png");
	static JLabel Yuusha = new JLabel();
	static boolean moveNow = false;
	static int code = 0;
//	private Thread rest= new Thread(new TestNormal(),"통상");
	@Override
	public void run() {
		System.out.println("DDD");
		
		Yuusha.setIcon(YuushaImg);
		Yuusha.setBounds(100, 300, 182, 182);
//		getPanel().setBounds(150, 50, 400, 400);
		YuushaStaticMove.getPanel().add(Yuusha);
		while(true) {
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				System.out.println("ASB");
				if(code==88) {
					for(int i = 1;i<=4;i++) {
						Test.setImg("src\\Source\\Character\\주인공_attack_"+i+".png");
						try {
							switch(i) {
							case 1:
								Thread.sleep(200);
								break;
							case 2:
								Thread.sleep(200);
								break;
							case 3:
								Thread.sleep(250);
								break;
							case 4:
								Thread.sleep(500);
								break;
							}
							
						}catch(InterruptedException e1) {
							
						}
					}
					
				}
				if(code==67) {
					for(int i = 18;i>=0;i--) {
						if(i==6||i==18) {
							Test.setImg("src\\Source\\Character\\주인공_jump_2.png");
						}else if(i==0||i==12){
							Test.setImg("src\\Source\\Character\\주인공_jump_3.png");	
						}

						
						Test.Yuusha.setBounds(Test.Yuusha.getX(), (int)(Test.Yuusha.getY()-(Math.sin(Math.toRadians(i*5))*5)), 182, 182);
						
						try {
							Thread.sleep(50);
						}catch(InterruptedException e1) {
							
						}
					}
					
				}
				for(int i = 1;i<=4;i++) {
					Test.setImg("src\\Source\\Character\\주인공_run_"+i+".png");
//					Test.getYuusha().setIcon(new ImageIcon("src\\Source\\Character\\주인공_run_"+i+".png"));
					switch(code) {
					case KeyEvent.VK_LEFT:
						Test.getYuusha().setBounds(Test.getYuusha().getX()-10, Test.getYuusha().getY(), Test.getYuusha().getWidth(), Test.getYuusha().getHeight());
						break;
					case KeyEvent.VK_KP_LEFT:
						Test.getYuusha().setBounds(Test.getYuusha().getX()-10, Test.getYuusha().getY(), Test.getYuusha().getWidth(), Test.getYuusha().getHeight());
						break;
					case KeyEvent.VK_RIGHT:
						Test.getYuusha().setBounds(Test.getYuusha().getX()+10, Test.getYuusha().getY(), Test.getYuusha().getWidth(), Test.getYuusha().getHeight());
						break;
					case KeyEvent.VK_KP_RIGHT:
						Test.getYuusha().setBounds(Test.getYuusha().getX()+10, Test.getYuusha().getY(), Test.getYuusha().getWidth(), Test.getYuusha().getHeight());
						break;
					}
					try {
						Thread.sleep(150);
					}catch(InterruptedException e1) {
						
					}
					
				}
				int i = 0;
				while(Yuusha.getY()<300) {
					if(i==25||i==80) {
						Test.setImg("src\\Source\\Character\\주인공_jump_2.png");
					}else if(i==0||i==50){
						Test.setImg("src\\Source\\Character\\주인공_jump_3.png");	
					}
					Yuusha.setBounds(Test.Yuusha.getX(), (int)(Test.Yuusha.getY()+(Math.sin(Math.toRadians(i*5))*5)), 182, 182);
//					Test.Yuusha.setBounds(Test.Yuusha.getX(), (int)(Test.Yuusha.getY()+(Math.cos((double)i*Math.PI/180))), 182, 182);
					try {
						Thread.sleep(50);
					}catch(InterruptedException e1) {
						
					}
					if(i<90) {
						i++;
					}
				}
				YuushaStaticMove.setPressed(false);
			}

		}
		
		
//		setVisible(true);
//		rest.start();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("CCC");
		// TODO Auto-generated method stub
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_LEFT||code == KeyEvent.VK_RIGHT||code == KeyEvent.VK_UP||code == KeyEvent.VK_DOWN) {
			switch(code) {
			case KeyEvent.VK_LEFT:
				Yuusha.setBounds(Yuusha.getX()-10, Yuusha.getY(), Yuusha.getWidth(), Yuusha.getHeight());
				break;
			case KeyEvent.VK_KP_LEFT:
				Yuusha.setBounds(Yuusha.getX()-10, Yuusha.getY(), Yuusha.getWidth(), Yuusha.getHeight());
				break;
			case KeyEvent.VK_RIGHT:
				Yuusha.setBounds(Yuusha.getX()+10, Yuusha.getY(), Yuusha.getWidth(), Yuusha.getHeight());
				break;
			case KeyEvent.VK_KP_RIGHT:
				Yuusha.setBounds(Yuusha.getX()+10, Yuusha.getY(), Yuusha.getWidth(), Yuusha.getHeight());
				break;
			}
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
//		rest.start();
	}

	public static boolean isMoveNow() {
		return moveNow;
	}

	public static void setMoveNow(boolean moveNow) {
		Test.moveNow = moveNow;
	}

	public static void setImg(String str) {
		ImageIcon imgIcon = new ImageIcon(str);
		Test.Yuusha.setIcon(imgIcon);
		
	}

	public static JLabel getYuusha() {
		return Yuusha;
	}

	public static void setYuusha(JLabel yuusha) {
		Test.Yuusha = yuusha;
	}
	
}
