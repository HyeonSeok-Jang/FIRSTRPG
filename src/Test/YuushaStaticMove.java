package Test;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class YuushaStaticMove extends JFrame implements Runnable, KeyListener{
	private Thread rest= new Thread(new TestNormal(),"통상");
	public static JPanel panel = new JPanel();
//	private Toolkit tk = Toolkit.getDefaultToolkit();
	private Image img = Toolkit.getDefaultToolkit().getImage("src\\Source\\Icon.png");
//	private ImageIcon title = new ImageIcon("src\\Source\\BackGround\\메인화면-용사.png");
//	Image title2 = new ImageIcon("\\src\\Source\\메인화면-용사.png").getImage();
	private ImageIcon backG;
	static boolean pressed = false;
	private static boolean waitNormal = true;
	private JLabel label = new JLabel();
	private static Test YuushaMoving = new Test();
	private static Thread thread2 = new Thread(YuushaMoving, "YuushaMoving");
	
//	private JPanel panel = new JPanel() {
//		public void paint(Graphics g) {
//			g.drawImage(title2,0,0,null);
//		}
//	};
	
	public YuushaStaticMove(){
		backG = new ImageIcon("src\\Source\\BackGround\\왕궁_왕.png");
//		JLabel labe = new JLabel();
//		ImageIcon backG2 = new ImageIcon("src\\Source\\Character\\사천왕_4_normal.png");
//		labe.setIcon(backG2);
		
		addKeyListener(this);
		setTitle("용사 움직임 실험");
		setSize(940,560);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		panel.setIcon(backG);
		setLayout(null);
		
		panel.setLayout(null);
		panel.setBounds(0, -10, 940, 560);
//		labe.setBounds(100,100,570,570);
//		label.setIcon(backG);
		label.setBounds(0, 0, 940, 560);
		setIconImage(img);
		
		
		add(panel);
		
		
	}
//		panel.add(label);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		YuushaStaticMove move = new YuushaStaticMove();
		Thread thread1 = new Thread(move, "Yuusha");
		
		thread1.start();
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("aaa");
//		Test YuushaMoving = new Test();
		Smile slime = new Smile();
		BackGround back = new BackGround();
//		Thread thread2 = new Thread(YuushaMoving, "YuushaMoving");
		Thread threadS = new Thread(slime, "Slime");
		Thread threadB = new Thread(back, "Back");
		thread2.start();
		
		
		threadS.start();
		setVisible(true);
		threadB.start();
		setVisible(true);
		try {
			Thread.sleep(10000);
		}catch(InterruptedException e) {
			
		}
		rest.start();
		
		
	}
	public static JPanel getPanel() {
		return panel;
	}
	public static void setPanel(JPanel panel) {
		YuushaStaticMove.panel = panel;
	}
	public JLabel getLabel() {
		return label;
	}
	public void setLabel(JLabel label) {
		this.label = label;
	}
	
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		waitNormal = false;
		
		// TODO Auto-generated method stub
		System.out.println("CCC");
		// TODO Auto-generated method stub
		
//		rest.sleep(1000);
		int code = e.getKeyCode();
		if(pressed)
			return;
		if(code == 67&&!pressed) {
			pressed = true;
			Test.code = code;
			int a = 0;
			
			thread2.interrupt();

			
		}
		if(!pressed) {
			pressed = true;
			
//			if(code == KeyEvent.VK_LEFT||code == KeyEvent.VK_RIGHT||code == KeyEvent.VK_UP||code == KeyEvent.VK_DOWN) {
//				for(int i = 1;i<=4;i++) {
//					Test.setImg("src\\Source\\Character\\주인공_run_"+i+".png");
////					Test.getYuusha().setIcon(new ImageIcon("src\\Source\\Character\\주인공_run_"+i+".png"));
//					switch(code) {
//					case KeyEvent.VK_LEFT:
//						Test.getYuusha().setBounds(Test.getYuusha().getX()-10, Test.getYuusha().getY(), Test.getYuusha().getWidth(), Test.getYuusha().getHeight());
//						break;
//					case KeyEvent.VK_KP_LEFT:
//						Test.getYuusha().setBounds(Test.getYuusha().getX()-10, Test.getYuusha().getY(), Test.getYuusha().getWidth(), Test.getYuusha().getHeight());
//						break;
//					case KeyEvent.VK_RIGHT:
//						Test.getYuusha().setBounds(Test.getYuusha().getX()+10, Test.getYuusha().getY(), Test.getYuusha().getWidth(), Test.getYuusha().getHeight());
//						break;
//					case KeyEvent.VK_KP_RIGHT:
//						Test.getYuusha().setBounds(Test.getYuusha().getX()+10, Test.getYuusha().getY(), Test.getYuusha().getWidth(), Test.getYuusha().getHeight());
//						break;
//					}
//					try {
//						
//					}catch(InterruptedException e1) {
//						
//					}
//					
//				}
//				
//			}
			Test.code = code;
			thread2.interrupt();
			
		}
		
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
//		rest.start();
//		pressed = false;
		System.out.println("PPP");
		waitNormal = true;
	}
	public static Thread getThread2() {
		return thread2;
	}
	public static void setThread2(Thread thread2) {
		YuushaStaticMove.thread2 = thread2;
	}
	public static boolean isPressed() {
		return pressed;
	}
	public static void setPressed(boolean pressed) {
		YuushaStaticMove.pressed = pressed;
	}
	public static boolean isWaitNormal() {
		return waitNormal;
	}
	public static void setWaitNormal(boolean waitNormal) {
		YuushaStaticMove.waitNormal = waitNormal;
	}
	
	
}
