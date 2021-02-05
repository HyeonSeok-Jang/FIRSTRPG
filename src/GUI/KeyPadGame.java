package GUI;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import GUI.*;
import Main.*;
public class KeyPadGame extends JFrame implements Runnable{
	private JLabel backG = new JLabel();
	private boolean[] btnOnOff = new boolean[9];
	private JLabel[] btn = new JLabel[9];
	private JPanel panel = new JPanel();
	private int numth = 1;
//	public KeyPadGame() {
//		this(1,500,500);
//	}
	public KeyPadGame(int num, int x, int y) {
//		numth = 1;
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		numth=num;
		for(int i = 0;i<btn.length;i++) {
			btnOnOff[i]=false;
			btn[i]=new JLabel();
			btn[i].setIcon(new ImageIcon("src\\Source\\Object\\Door_Rock_B_Off.png"));
			int btnX = 0;
			int btnY = 0;
			switch(i) {//가로 107간격 세로 91간격
			case 0:
				btnX = 26;
				btnY = 49;
				break;
			case 1:
				btnX = 133;
				btnY = 49;
				break;
			case 2:
				btnX = 240;
				btnY = 49;
				break;
			case 3:
				btnX = 26;
				btnY = 141;
				break;
			case 4:
				btnX = 133;
				btnY = 141;
				break;
			case 5:
				btnX = 240;
				btnY = 141;
				break;
			case 6:
				btnX = 26;
				btnY = 233;
				break;
			case 7:
				btnX = 133;
				btnY = 233;
				break;
			case 8:
				btnX = 240;
				btnY = 233;
				break;
			}
			btn[i].setBounds(btnX,btnY, 100, 70);
			btn[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					Main.effect("플래시 효과음");
					// TODO Auto-generated method stub
					/*
					 * 2 3 4 6 7 8 한줄씩
					 * 2 4 십자
					 */
					super.mousePressed(e);
					int position = 0;
					for(int j = 0;j<btn.length;j++) {
						if((e.getSource()).equals(btn[j]))
							position = j;
					}
					if(numth==1) {

						for(int j = -6;j<=6;j++) {
							if(j == -5||j==5||j==-4||j==4||(j==-2&&!(position==2||position==5||position==8))||(j==-1&&(position==0||position==3||position==6))||(j==1&&(position==2||position==5||position==8))||(j==2&&!(position==0||position==3||position==6)))
								continue;
							
							
							try {
								if(btnOnOff[position+j])
									btnOnOff[position+j]=false;
								else
									btnOnOff[position+j]=true;
								
							}catch(ArrayIndexOutOfBoundsException e2) {
								System.out.println("범위를 벗어남");
							}
						}
						
					}else {
						for(int j = -3;j<=3;j++) {
							try {
								if(j==-2||j==2||(position==2||position==5)&&(j==1)||(position==3||position==6)&&(j==-1))
									continue;
								if(btnOnOff[position+j])
									btnOnOff[position+j]=false;
								else
									btnOnOff[position+j]=true;
							}catch(ArrayIndexOutOfBoundsException e2) {
								System.out.println("범위를 벗어남");
							}
						}
						
					}
					for(int j = 0;j<btn.length;j++) {
						if(btnOnOff[j])
							btn[j].setIcon(new ImageIcon("src\\Source\\Object\\Door_Rock_B_On.png"));
						else
							btn[j].setIcon(new ImageIcon("src\\Source\\Object\\Door_Rock_B_Off.png"));
					}
					
					
					
//					for(int j = 0;j<btn.length;j++) {
//					}
//					try {
//						
//					}catch(ArrayIndexOutOfBoundsException e2) {
//						
//					}
				}
				
			});
			panel.add(btn[i]);
		}
		if(numth==1) {
			btnOnOff[1]=true;
			btnOnOff[2]=true;
			btnOnOff[3]=true;
			btnOnOff[5]=true;
			btnOnOff[6]=true;
			btnOnOff[7]=true;
			btn[1].setIcon(new ImageIcon("src\\Source\\Object\\Door_Rock_B_On.png"));
			btn[2].setIcon(new ImageIcon("src\\Source\\Object\\Door_Rock_B_On.png"));
			btn[3].setIcon(new ImageIcon("src\\Source\\Object\\Door_Rock_B_On.png"));
			btn[5].setIcon(new ImageIcon("src\\Source\\Object\\Door_Rock_B_On.png"));
			btn[6].setIcon(new ImageIcon("src\\Source\\Object\\Door_Rock_B_On.png"));
			btn[7].setIcon(new ImageIcon("src\\Source\\Object\\Door_Rock_B_On.png"));
		}else {
			btnOnOff[1]=true;
			btnOnOff[3]=true;
			btn[1].setIcon(new ImageIcon("src\\Source\\Object\\Door_Rock_B_On.png"));
			btn[3].setIcon(new ImageIcon("src\\Source\\Object\\Door_Rock_B_On.png"));
		}
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\Source\\Icon.png"));
		setTitle("모두 다 켜라!");
		setSize(382,385);
		setResizable(false);
		setLayout(null);
		panel.setLayout(null);
		panel.setBounds(0,-10,366,369);
//		setLocation(x, y);
		setLocationRelativeTo(null);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		backG.setIcon(new ImageIcon("src\\Source\\Object\\Door_Rock1.png"));
		backG.setBounds(0, -10, 366, 369);
		
		
		add(panel);
//		panel.add(btn[0]);
		panel.add(backG);
		setVisible(true);
	}
	@Override
	public void run() {
		setVisible(true);
		while(!(btnOnOff[0]&&btnOnOff[1]&&btnOnOff[2]&&btnOnOff[3]&&btnOnOff[4]&&btnOnOff[5]&&btnOnOff[6]&&btnOnOff[7]&&btnOnOff[8])) {
			System.out.println("하나라도 거짓");
			try {
				Thread.sleep(400);
			}catch(InterruptedException e) {
				
			}
		}
		Main.setAnswerClickChoose(true);
		setVisible(false);
		// TODO Auto-generated method stub
		
	}
//	public static void main(String[] args) {
//		KeyPadGame kpg = new KeyPadGame();
//		Thread kpg2 = new Thread(kpg,"");
//		kpg2.start();
//	}
}
