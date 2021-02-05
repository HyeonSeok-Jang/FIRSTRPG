package Main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import GUI.*;
import Main.*;

public class YesOrNo extends JFrame implements Runnable{
	private JLabel yes = new JLabel();
	private JLabel no = new JLabel();
	private JLabel save = new JLabel();
	private JLabel kill = new JLabel();
	private JLabel[] mondai = new JLabel[4];
	private JLabel backG = new JLabel();
	public YesOrNo(int yongdo,int script, int x, int y){
		//용도에 따라 들어가는 값이 다름
		//용도가 0이면 네, 아니오
		//용도가 2이면 10스테이지 문제들
		//용도가 1이면 12스테이지 있는 엔딩 관련...
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\Source\\Icon.png"));
		yes.setIcon(new ImageIcon("src\\Source\\GUI\\네.png"));
		no.setIcon(new ImageIcon("src\\Source\\GUI\\아니오.png"));
		save.setIcon(new ImageIcon("src\\Source\\Script\\St12\\대사3_1.png"));
		kill.setIcon(new ImageIcon("src\\Source\\Script\\St12\\대사3_2.png"));
		backG.setIcon(new ImageIcon("src\\Source\\GUI\\노라조_배경.png"));
		for(int i =0;i<mondai.length;i++) {
			mondai[i]=new JLabel();
			switch(i) {
			case 0:
				mondai[i].setIcon(new ImageIcon("src\\Source\\Script\\St10\\대사"+script+"_A.png"));
				mondai[i].setBounds(0, 0, 470, 94);
				break;
			case 1:
				mondai[i].setIcon(new ImageIcon("src\\Source\\Script\\St10\\대사"+script+"_B.png"));
				mondai[i].setBounds(470, 0, 470, 94);
				break;
			case 2:
				mondai[i].setIcon(new ImageIcon("src\\Source\\Script\\St10\\대사"+script+"_C.png"));
				mondai[i].setBounds(0, 94, 470, 94);
				break;
			case 3:
				mondai[i].setIcon(new ImageIcon("src\\Source\\Script\\St10\\대사"+script+"_D.png"));
				mondai[i].setBounds(470, 94, 470, 94);
				break;
			}
		}
		setTitle("선택중...");
		setResizable(false);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setLocation(x,y);
		setLayout(null);
		yes.setBounds(0, 0, 480, 300);
		no.setBounds(480, 0, 480, 300);
		save.setBounds(0,0,470,250);
		kill.setBounds(470,0,470,250);
		backG.setBounds(-250,-250,1500,1500);
		switch(yongdo) {
		case 0:
			setSize(960,300);
			yes.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Yes
					super.mousePressed(e);
					Main.setAnswer(0);
					setVisible(false);
					Main.setAnswerClickChoose(true);
				}
			});
			no.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO no
					super.mousePressed(e);
					Main.setAnswer(1);
					setVisible(false);
					Main.setAnswerClickChoose(true);
				}
			});
			add(yes);
			add(no);
			break;
		case 1:
			setSize(940,250);
			save.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO save
					super.mousePressed(e);
					Main.setAnswer(0);
					setVisible(false);
					Main.setAnswerClickChoose(true);
				}
			});
			kill.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO kill
					try {
						Main.effect("Metal Sound by Daphne_in_Wonderland Id-127152");
						Thread.sleep(250);
						Main.effect("Metal Sound by Daphne_in_Wonderland Id-127152");
						Thread.sleep(500);
						Main.effect("Clean Fast Swoosh by Danjocross Id-507466");
						Thread.sleep(300);
						Main.effect("Sword Fast Unsheath by ethanchase7744 Id-468695");
						Thread.sleep(450);
						Main.effect("Buffer Spell by deleted_user_3277771 Id-176741");
						
					}catch(InterruptedException e1) {
						
					}
					super.mousePressed(e);
					Main.setAnswer(1);
					setVisible(false);
					YuushaStatus.setPrincessLive(false);
					Main.setAnswerClickChoose(true);
				}
			});
			add(save);
			add(kill);
			break;
		case 2:
			setSize(940,230);
			mondai[0].addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO 1
						super.mousePressed(e);
						Main.setAnswer(0);
						setVisible(false);
						Main.setAnswerClickChoose(true);
					}
				});
			mondai[1].addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO 2
					super.mousePressed(e);
					Main.setAnswer(1);
					setVisible(false);
					Main.setAnswerClickChoose(true);
				}
			});
			mondai[2].addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO 3
					super.mousePressed(e);
					Main.setAnswer(2);
					setVisible(false);
					Main.setAnswerClickChoose(true);
				}
			});
			mondai[3].addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO 4
					super.mousePressed(e);
					Main.setAnswer(3);
					setVisible(false);
					Main.setAnswerClickChoose(true);
				}
			});
			for(int i = 0;i<mondai.length;i++) {
				add(mondai[i]);
			}
			break;
		}
		
		this.add(backG);
		setVisible(true);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
	}
	public static boolean munjae() {
		switch(Main.getScript()) {
		case 18:
			if(Main.getAnswer()==1)
				return true;
			else
				return false;
		case 19:
			if(Main.getAnswer()==2)
				return true;
			else
				return false;
		case 20:
			if(Main.getAnswer()==3)
				return true;
			else
				return false;
		case 21:
			if(Main.getAnswer()==2)
				return true;
			else
				return false;
		case 22:
			if(Main.getAnswer()==0||Main.getAnswer()==3)
				return true;
			else
				return false;
		case 23:
			if(Main.getAnswer()==0)
				return true;
			else
				return false;
		case 24:
			if(Main.getAnswer()==1)
				return true;
			else
				return false;
		case 25:
			if(Main.getAnswer()==1)
				return true;
			else
				return false;
		case 26:
			if(Main.getAnswer()==0)
				return true;
			else
				return false;
		case 27:
			if(Main.getAnswer()==0||Main.getAnswer()==3)
				return true;
			else
				return false;
		case 28:
			if(Main.getAnswer()==0)
				return true;
			else
				return false;
		case 29:
			if(Main.getAnswer()==2)
				return true;
			else
				return false;
		case 30:
			if(Main.getAnswer()==3)
				return true;
			else
				return false;
		case 31:
			if(Main.getAnswer()==1)
				return true;
			else
				return false;
		case 32:
			return true;
			
		}
		return true;
	}
	
}
