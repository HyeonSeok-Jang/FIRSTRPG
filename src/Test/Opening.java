package Test;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;

public class Opening extends JFrame{
	private BufferedImage img = null;
	private JFrame test = new JFrame();
	private JPanel panel = new JPanel();
	private static JLabel label = new JLabel();
	private ImageIcon icon = new ImageIcon("src\\Source\\BackGround\\GIF\\메인화면-용사0.png");
//	private ImageIcon icon = new ImageIcon("src\\Source\\BackGround\\GIF\\anigif.gif");
	private static int times = 1;
	public Opening(){
		
		
		setTitle("오프닝 테스트");
		setSize(960,560);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		panel.setBounds(0,-10,960,560);
		
		label.setBounds(100, 0, 398, 560);
		icon.getImageObserver();
		label.setIcon(icon);
//		setUndecorated(true);
//		setBackground(new Color(0,0,0,0));

//		setIconImage(image);
		panel.setBackground(new Color(255,0,0,0));
//		label.setBackground(new Color(255,0,0,122));
//		add(test);
		add(new OPPanel());
		add(panel);
		panel.add(label);
		setVisible(true);
		for(;times<35;times++) {
			try {
				Thread.sleep(150);
				
			}catch(InterruptedException e) {
				
			}
		}
		/*
		for(;times<35;times++) {
			
//			icon = new ImageIcon("src\\Source\\BackGround\\GIF\\메인화면-용사"+times+".png");
//			label.setIcon(icon);
//			label.setLocation(label.getX()+10, label.getY());
			Opening.setImg("src\\Source\\BackGround\\GIF\\메인화면-용사"+times+".png");
//			ImageIcon imgIcon = new ImageIcon("src\\Source\\BackGround\\GIF\\메인화면-용사"+times+".png");
//			label.setIcon(imgIcon);
			label.setLocation(label.getX()+10, label.getY());
			try {
				Thread.sleep(100);
				
			}catch(InterruptedException e) {
				
			}
		}
		*/
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Opening op = new Opening();
	}
//	@Override
//	public void paintComponents(Graphics g) {
//		// TODO Auto-generated method stub
//		super.paintComponents(g);
//	}
	public static void setImg(String str) {
		ImageIcon imgIcon = new ImageIcon(str);
		Opening.label.setIcon(imgIcon);
	}
	public static int getTimes() {
		return times;
	}
	public static void setTimes(int times) {
		Opening.times = times;
	}
	
}



class OPPanel extends JPanel{
	private BufferedImage img = null;
	public OPPanel() {
		setLocation(100, 100);
		try {
			img = ImageIO.read(new File("src\\Source\\BackGround\\GIF\\메인화면-용사1.png"));
		}catch(IOException e) {
			System.exit(1);
		}
		
		
//		this.repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		try {
			if(Opening.getTimes()<35) {
				g.drawImage(ImageIO.read(new File("src\\Source\\BackGround\\GIF\\메인화면-용사"+Opening.getTimes()+".png")),100,100,null);
//			Opening.setTimes(Opening.getTimes()+1);
				this.repaint();
			}
		}catch(IOException e) {
			
		}
//		g.drawImage(img,this.getX()+10,this.getY(),null);
		
	}

	
}
