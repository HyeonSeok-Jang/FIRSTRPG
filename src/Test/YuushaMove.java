package Test;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class YuushaMove extends JFrame implements KeyListener, Runnable{
	private JPanel panel = new JPanel();
//	private Toolkit tk = Toolkit.getDefaultToolkit();
	private Image img = Toolkit.getDefaultToolkit().getImage("src\\Source\\Icon.png");;
//	private ImageIcon title = new ImageIcon("src\\Source\\BackGround\\����ȭ��-���.png");
//	Image title2 = new ImageIcon("\\src\\Source\\����ȭ��-���.png").getImage();
	private ImageIcon backG;
	
	private JLabel label = new JLabel();
	
//	private JPanel panel = new JPanel() {
//		public void paint(Graphics g) {
//			g.drawImage(title2,0,0,null);
//		}
//	};
	
	public YuushaMove(){
		backG = new ImageIcon("src\\Source\\BackGround\\�ձ�_��.png");
//		JLabel labe = new JLabel();
//		ImageIcon backG2 = new ImageIcon("src\\Source\\Character\\��õ��_4_normal.png");
//		labe.setIcon(backG2);
		setTitle("��� ������ ����");
		setSize(940,560);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		panel.setIcon(backG);
		setLayout(null);
		
		panel.setLayout(null);
		panel.setBounds(0, -10, 940, 560);
//		labe.setBounds(100,100,570,570);
		label.setIcon(backG);
		label.setBounds(0, 0, 940, 560);
		setIconImage(img);
		
		add(panel);
		
//		panel.add(label);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		YuushaMove move = new YuushaMove();
		Thread thread1 = new Thread(move, "Yuusha");
		System.out.println("aaa");
		thread1.start();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Test YuushaMoving = new Test();
		Smile slime = new Smile();
		BackGround back = new BackGround();
		Thread thread2 = new Thread(YuushaMoving, "YuushaMoving");
		Thread threadS = new Thread(slime, "Slime");
		Thread threadB = new Thread(back, "Back");
		thread2.start();
		threadS.start();
//		threadB.start();
		setVisible(true);
	}
	public JPanel getPanel() {
		return panel;
	}
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	public JLabel getLabel() {
		return label;
	}
	public void setLabel(JLabel label) {
		this.label = label;
	}

	
	
	
}
