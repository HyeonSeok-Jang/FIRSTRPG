package GUI;
import java.awt.*;

import java.awt.event.*;
import javax.swing.*;
import GUI.*;
import Main.*;
import Object.*;
public class DDRGame extends JFrame implements Runnable{
	private JLabel backG = new JLabel();
	private JPanel panel = new JPanel();
	private Arrow arrow = new Arrow();
	private boolean pressOn = true;
	
	private int count;
	public DDRGame(int num,int x, int y) {
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		count = num;
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\Source\\Icon.png"));
		setTitle("댄스타임");
		setSize(216,238);
		setResizable(false);
		setLayout(null);
		panel.setLayout(null);
		panel.setBounds(0,0,1000,1000);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(x,y);
		backG.setIcon(new ImageIcon("src\\Source\\GUI\\노라조_배경.png"));
		backG.setBounds(-200, -210, 1500, 1500);
		addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				switch(e.getKeyCode()) {
				case 37:
					arrow.setRotation(1);
					break;
				case 38:
					arrow.setRotation(2);
					break;
				case 39:
					arrow.setRotation(3);
					break;
				case 40:
					arrow.setRotation(4);
					break;
				};
				pressOn = false;
			}
		});
		
		add(panel);
		
		panel.add(arrow);
		panel.add(backG);
//		arrow.requestFocus();
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		DDRGame ddr = new DDRGame(3, 500, 500);
		Thread ddrPlay = new Thread(ddr,"디디알");
		ddrPlay.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		setVisible(true);
		try {
			for(int i = 0;i<count;i++) {
//			while(!Main.isAnswerClickChoose()) {
				int nansuCo = (int)(Math.random()*3)+1;
//				int nansuCo = 2;
				int nansuRo = (int)(Math.random()*4)+1;
				arrow.setRotation(nansuRo);
				switch(nansuCo) {
				case 1:
					arrow.setImg("src\\Source\\Object\\Arrow_B_"+nansuRo+".png");
					break;
				case 2:
					arrow.setImg("src\\Source\\Object\\Arrow_G_"+nansuRo+".png");
					break;
				case 3:
					arrow.setImg("src\\Source\\Object\\Arrow_R_"+nansuRo+".png");
					break;
				}
				boolean collect = false;
				while(0<nansuCo) {
//				for(int i = 0; i<nansuCo;) {
					while(pressOn) {
						Thread.sleep(300);
					}
					pressOn = true;
					
					
					if(nansuRo == arrow.getRotation()) {
						System.out.println(nansuCo);
						nansuCo--;
						collect = true;
					}else {
						collect = false;
						
					}
					switch(nansuCo) {
					case 1:
						arrow.setImg("src\\Source\\Object\\Arrow_B_"+nansuRo+".png");
						break;
					case 2:
						arrow.setImg("src\\Source\\Object\\Arrow_G_"+nansuRo+".png");
						break;
					case 3:
						arrow.setImg("src\\Source\\Object\\Arrow_R_"+nansuRo+".png");
						break;
					}
					arrow.repaint();
					repaint();
					arrow.setRotation(0);
					
					OXcorrect ox = new OXcorrect(collect);
					Thread oxshine = new Thread(ox, "정답확인");
					panel.add(ox);
					panel.add(arrow);
					panel.add(backG);
					setVisible(true);
					oxshine.start();
					
					if(collect) {
						
					}else {
						Thread.sleep(1500);
					}
				}
				
					
				
				Thread.sleep(300);
			}
		}catch(InterruptedException e) {
			
		}
		Main.setAnswerClickChoose(true);
		setVisible(false);
	}
	
}
