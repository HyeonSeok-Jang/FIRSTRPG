package Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.event.*;
import Character.*;
import GUI.*;
import Main.YuushaStatus;

public class ClickScriptPass extends JFrame implements MouseListener, Runnable{
	private JPanel panel = new JPanel();
	private JLabel back = new JLabel();
//	private JLabel script = new JLabel();
//	private JLabel scriptGUI = new JLabel();
//	private JLabel scriptGUI2 = new JLabel();
//	private JLabel name = new JLabel();
//	private JLabel name3 = new JLabel(); 
//	private JLabel nickName = new JLabel();
//	private JLabel face = new JLabel();
//	private JLabel face2 = new JLabel();
	private JLabel ch = new JLabel(new ImageIcon("src\\Source\\Character\\����_hit.png"));
	private JLabel ch2 = new JLabel(new ImageIcon("src\\Source\\Character\\��õ��_4_normal.png"));
	
	private ImageIcon backGP = new ImageIcon("src\\Source\\BackGround\\���չ�.png");
//	private ImageIcon scriptGP = new ImageIcon("src\\Source\\Script\\St11\\���1.png");
//	private ImageIcon scriptGUIGP = new ImageIcon("src\\Source\\GUI\\Text_P_2.png");
//	private ImageIcon scriptGUIGP2 = new ImageIcon("src\\Source\\GUI\\Text_A_2.png");
//	private ImageIcon name2 = new ImageIcon("src\\Source\\GUI\\HP_UI_150.png");
//	private ImageIcon name4 = new ImageIcon("src\\Source\\GUI\\HP_P_Bar_15.png");
//	private ImageIcon nickName2 = new ImageIcon("src\\Source\\GUI\\Potion.png");
//	private ImageIcon faceImg = new ImageIcon("src\\Source\\Face\\���ΰ�_face_1.png");
//	private ImageIcon faceImg2 = new ImageIcon("src\\Source\\Face\\��õ��_face_1.png");
	
	private int scTh = 2;
	public ClickScriptPass(){
		
		setSize(975,560);
		setTitle("��ũ��Ʈ �׽�Ʈ");
//		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
//		setUndecorated(true);
//		setBackground(new Color(0,0,0,255));
//		setBackground(new Color)
		panel.setLayout(null);
		
//		script.setIcon(scriptGP);
//		scriptGUI.setIcon(scriptGUIGP);
//		scriptGUI2.setIcon(scriptGUIGP2);
//		name.setIcon(name2);
//		name3.setIcon(name4);
//		face.setIcon(faceImg);
//		face2.setIcon(faceImg2);
//		nickName.setIcon(nickName2);
//		backGP.setImage(image);
		
		//7��������
//		ch = new JLabel(new ImageIcon("src\\Source\\Character\\��õ��_1_normal.png"));
//		ch.setBounds(570,230,200,275);
		
		//8��������
//		ch = new JLabel(new ImageIcon("src\\Source\\Character\\��õ��_2_normal.png"));
//		ch.setBounds(570,330,132,182);
		
		//9��������
//		ch = new JLabel(new ImageIcon("src\\Source\\Character\\��õ��_3_normal.png"));
//		ch.setBounds(420,250,148,198);
		
		//10��������
//		ch2.setBounds(650,320,182,182);
		
		//11��������
//		ch.setBounds(570,310,132,182); //ī��
//		ch2.setBounds(500,320,182,182);
		
		backGP = new ImageIcon("src\\Source\\BackGround\\��õ��1.png");
		
		
		back.setBounds(0, -10, 960, 560);
		back.setIcon(backGP);
//		scriptGUI.setBounds(10, 195, 940, 360);
//		scriptGUI2.setBounds(10, 195, 940, 360);
//		script.setBounds(10, 290, 940, 240);
//		name.setBounds(120,245,618,58);//��� 120,245,120,30
//		name3.setBounds(129,254,600,40);
//		nickName.setBounds(550,200,271,259);
		//600,195,160,30
//		scriptGUI.setOpaque(true); //������ MAX, �����ϴ� ��浵 ������� ĥ������ ��
//		name.setBounds(20,20,412,38);//�ִ� ü�� ��
//		name3.setBounds(26,26,400,26);//���� ü�� ��
//		nickName.setBounds(820,0,135,130);//����
//		Image img1 = name2.getImage().getScaledInstance(412, 38, Image.SCALE_SMOOTH);
//		Image img2 = name4.getImage().getScaledInstance(400, 26, Image.SCALE_SMOOTH);
//		Image img3 = nickName2.getImage().getScaledInstance(135, 130, Image.SCALE_SMOOTH);
//		ImageIcon img5 = new ImageIcon(img2);
//		ImageIcon img6 = new ImageIcon(img3);
		
//		name.setIcon(img4);
////		name3.setIcon(img5);
//		name3.setIcon(new ImageIcon(new ImageIcon("src\\Source\\GUI\\HP_UI_100.png").getImage().getScaledInstance(412, 38, Image.SCALE_SMOOTH)));
//		nickName.setIcon(img6);
		
		/*
		 * �ױ��� 745,245,120,30
		 * ������ 765,245,120,30
		 * �α��� 775,245,120,30
		 * ����??? 785,245,120,30
		 * �� 795,245,120,30
		 */
//		face.setBounds(0,-25,319,319);
//		face2.setBounds(635,-25,319,319);
		/*
		 * ��� 0,-50,319,319
		 * ������ 635,-50,319,319
		 */
		
		
//		scriptGUI.addMouseListener(this);
//		script.addMouseListener(this);
		
		add(panel);
		panel.add(ch2);
		panel.add(ch);
		
//		panel.add(face);
//		panel.add(face2);
//		panel.add(nickName);
//		panel.add(name3);
//		panel.add(name);
//		panel.add(script);
//		panel.add(scriptGUI2);
//		panel.add(scriptGUI);
		
		panel.add(back);
		
		
		
		setVisible(true);
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			YuushaStatus.setHp(YuushaStatus.getHp()-8);
			YuushaStatus.setMaxHp(YuushaStatus.getMaxHp()+10);
			
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClickScriptPass click = new ClickScriptPass();
		Thread star = new Thread(click,"����");
		star.start();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
//		scriptGP=new ImageIcon("src\\Source\\Script\\St11\\���"+Integer.toString(scTh)+".png");
//		script.setIcon(scriptGP);
		scTh++;
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
