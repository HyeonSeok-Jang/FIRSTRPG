package GUI;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import GUI.*;
import Main.*;
public class TerminateGame extends JFrame implements Runnable{
	private int[] enemyHp = new int[3];
	private JLabel[] enemy = new JLabel[3];
	private JLabel backG = new JLabel();
	public TerminateGame(int stage, int x, int y) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\Source\\Icon.png"));
		setTitle("������ �����Ķ�!");
		setSize(500,500);
		setResizable(false);
		setLocation(x, y);
		setLayout(null);
		backG.setIcon(new ImageIcon("src\\Source\\GUI\\�����_���.png"));
		backG.setBounds(-100, -100, 1000, 1000);
		for(int i=0; i<3;i++) {
			enemy[i] = new JLabel();
			enemyHp[i] = 0;
			
			add(enemy[i]);
		}
		enemy[0].addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				enemyHp[0]-=1;
				boolean hitting = true;
				if(hitting) {
					hitting=false;
					if(enemyHp[0]<=0) {
						YuushaStatus.setMaxHp(YuushaStatus.getMaxHp()+10);
						YuushaStatus.setHp(YuushaStatus.getHp()+10);
						enemy[0].setVisible(false);
					}
					try {
						switch(Main.getStage()) {
						case 4:
							for(int i = 1;i<=4;i++) {
								enemy[0].setIcon(new ImageIcon("src\\Source\\Character\\������_1_hit_"+i+".png"));
								Thread.sleep(100);
							}
							Main.effect("������ �ǰ�");
							enemy[0].setIcon(new ImageIcon("src\\Source\\Character\\������_1_normal.png"));
							break;
						case 5:
							for(int i = 1;i<=4;i++) {
								enemy[0].setIcon(new ImageIcon("src\\Source\\Character\\������_3_hit_"+i+".png"));
								Thread.sleep(100);
							}
							enemy[0].setIcon(new ImageIcon("src\\Source\\Character\\������_3_normal.png"));
							Main.effect("������ �ǰ�");
							break;
						case 11:
							enemy[0].setIcon(new ImageIcon("src\\Source\\Character\\����_hit.png"));
							Thread.sleep(150);
							enemy[0].setIcon(new ImageIcon("src\\Source\\Character\\����_normal.png"));
							Main.effect("���� �ǰ�");
							break;
						}
					}catch(InterruptedException e2) {
						
					}
					hitting = true;
				}
				
			}
		});
		enemy[1].addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				enemyHp[1]-=1;
				boolean hitting = true;
				if(hitting) {
					hitting = false;
					if(enemyHp[1]<=0) {
						YuushaStatus.setMaxHp(YuushaStatus.getMaxHp()+10);
						YuushaStatus.setHp(YuushaStatus.getHp()+10);
						enemy[1].setVisible(false);
					}
					try {
						switch(Main.getStage()) {
						case 4:
							for(int i = 1;i<=4;i++) {
								enemy[1].setIcon(new ImageIcon("src\\Source\\Character\\������_2_hit_"+i+".png"));
								Thread.sleep(100);
							}
							Main.effect("������ �ǰ�");
							enemy[1].setIcon(new ImageIcon("src\\Source\\Character\\������_2_normal.png"));
							break;
						case 5:
							for(int i = 1;i<=4;i++) {
								enemy[1].setIcon(new ImageIcon("src\\Source\\Character\\������_4_hit_"+i+".png"));
								Thread.sleep(100);
							}
							Main.effect("������ �ǰ�");
							enemy[1].setIcon(new ImageIcon("src\\Source\\Character\\������_4_normal.png"));
							break;
						}
					}catch(InterruptedException e2) {
						
					}
					hitting = true;
				}
			}
		});
		enemy[2].addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				enemyHp[2]-=1;
				boolean hitting = true;
				if(hitting) {
					hitting = false;
					if(enemyHp[2]<=0) {
						YuushaStatus.setMaxHp(YuushaStatus.getMaxHp()+10);
						YuushaStatus.setHp(YuushaStatus.getHp()+10);
						enemy[2].setVisible(false);
					}
					try {
						for(int i = 1;i<=4;i++) {
							enemy[2].setIcon(new ImageIcon("src\\Source\\Character\\������_5_hit_"+i+".png"));
							Thread.sleep(100);
						}
						Main.effect("������ �ǰ�");
						enemy[2].setIcon(new ImageIcon("src\\Source\\Character\\������_5_normal.png"));
						
					}catch(InterruptedException e2) {
						
					}
					hitting = true;
				}
			}
		});
		switch(Main.getStage()) {
		case 4:
			enemyHp[0]=1;
			enemyHp[1]=2;
			enemy[0].setIcon(new ImageIcon("src\\Source\\Character\\������_1_normal.png"));
			enemy[0].setBounds((int)(Math.random()*400), (int)(Math.random()*400), 99, 73);
			enemy[1].setIcon(new ImageIcon("src\\Source\\Character\\������_2_normal.png"));
			enemy[1].setBounds((int)(Math.random()*400), (int)(Math.random()*400), 99, 73);
			break;
		case 5:
			enemyHp[0]=3;
			enemyHp[1]=4;
			enemyHp[2]=5;
			enemy[0].setIcon(new ImageIcon("src\\Source\\Character\\������_3_normal.png"));
			enemy[0].setBounds((int)(Math.random()*400), (int)(Math.random()*400), 99, 73);
			enemy[1].setIcon(new ImageIcon("src\\Source\\Character\\������_4_normal.png"));
			enemy[1].setBounds((int)(Math.random()*400), (int)(Math.random()*400), 99, 73);
			enemy[2].setIcon(new ImageIcon("src\\Source\\Character\\������_5_normal.png"));
			enemy[2].setBounds((int)(Math.random()*400), (int)(Math.random()*400), 99, 73);
			break;
		case 11:
			enemyHp[0]=10;
			enemy[0].setIcon(new ImageIcon("src\\Source\\Character\\����_normal.png.png"));
			enemy[0].setBounds((int)(Math.random()*350), (int)(Math.random()*350), 132, 182);
			break;
			
		}
		add(backG);
		setVisible(true);
		
	}
	@Override
	public void run() {
		setVisible(true);
		// TODO Auto-generated method stub
		int i = 1;
		while(!(enemyHp[0]<=0&&enemyHp[1]<=0&&enemyHp[2]<=0)) {
			switch(Main.getStage()) {
			case 4:
				if(i%10==0)
					YuushaStatus.setHp(YuushaStatus.getHp()-3);
				break;
			case 5:
				if(i%4==0)
					YuushaStatus.setHp(YuushaStatus.getHp()-3);
				break;
			case 11:
				if(i%5==0)
					YuushaStatus.setHp(YuushaStatus.getHp()-10);
				break;
			}
			
			
			try {
				Thread.sleep(400);
			}catch(InterruptedException e) {
				
			}
			i++;
		}
		Main.setAnswerClickChoose(true);
		setVisible(false);
	}

}
