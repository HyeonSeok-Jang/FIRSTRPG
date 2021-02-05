package Test;

import java.awt.*;
import java.awt.Graphics;
import java.awt.image.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Opening2 extends JFrame{
	public Opening2(){
		setSize(960,560);
		setTitle("오프닝 테스트2");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Op2panel opp = new Op2panel();
//		opp.setBackground(new Color(0,0,0,0));
		add(opp);
		setVisible(true);
		try {
			for(int i = 0;i<34;i++) {
				opp.redraw();
				Thread.sleep(100);
			}
		}catch(InterruptedException e) {
			
		}
//		opp.setOpaque(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Opening2 op = new Opening2();
	}

}
class Op2panel extends JPanel {
	private BufferedImage img = null;
	private int imgX =100, imgY = 100;
	private static int times = 1;
	public Op2panel() {
		try {
			img = ImageIO.read(new File("src\\Source\\BackGround\\GIF\\메인화면-용사.png"));
		}catch(IOException e) {			
			System.exit(1);
		}
		
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		imgX+=5;
		super.paintComponent(g);
		g.drawImage(img,imgX,0,null);
		
		System.out.println("component");
	}
	public void redraw() {
		try {
			System.out.println(times);
			img = ImageIO.read(new File("src\\Source\\BackGround\\GIF\\메인화면-용사"+times+".png"));
		}catch(IOException e) {			
			System.exit(1);
		}
		times++;
		repaint();
	}
}