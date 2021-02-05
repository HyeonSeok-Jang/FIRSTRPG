package Test;

import java.awt.*;
import java.awt.image.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Opening3 extends JFrame{
	private Image img;
	private AlphaComposite alphaComposite;
	private JPanel panel;
	private JPanel panel2= new JPanel();
	private static int times = 0;
	public Opening3() {
		img = Toolkit.getDefaultToolkit().getImage("src\\Source\\BackGround\\GIF\\메인화면-용사.png");
		setSize(960,560);
		setTitle("오프닝 테스트2");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel2.setBackground(Color.YELLOW);

		panel = new JPanel(){
			public void paintComponent(Graphics g) {   
				alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)times/250*5); //alpha값
				
				Graphics2D g2 = (Graphics2D)g;
				
				g2.setComposite(alphaComposite);
				g2.drawImage(img, 0, 0, this);
				
			}
		};
		panel.setBackground(new Color(0,0,0,0));
		JLabel label = new JLabel(){
			public void paintComponent(Graphics g) {   
				alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)times/250*5); //alpha값
				
				Graphics2D g2 = (Graphics2D)g;
				
				g2.setComposite(alphaComposite);
				g2.drawImage(img, 0, 0, this);
				
			}
		};
		label.setBackground(Color.BLUE);
		label.setOpaque(true);
		label.setSize(500,500);
		
		add(label);
		add(panel2);
//		add(panel);
		times=50;
		label.repaint();
		setVisible(true);
//		for(int i = 0;i<51;i++) {
//			times++;
//			
//			panel.repaint();
//			try {
//				Thread.currentThread().sleep(50);
//			}catch(InterruptedException e) {
//				
//			}
//		}
		panel.setBackground(new Color(0,0,0,0));
		times=1;
		panel.repaint();
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Opening3 op = new Opening3();
	}

}
