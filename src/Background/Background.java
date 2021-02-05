package Background;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import Main.*;
import Test.Test;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Background extends JLabel{
	private ImageIcon YuushaImg = new ImageIcon("src\\Source\\Character\\���ΰ�_normal_1.png");
	private ImageIcon imgIcon;
	public Background() {
		setBounds(0, -10, 960, 560);
	}


	public void setImg(int stage) {
		this.imgIcon = null;
		switch(Main.getStage()) {
		case 1:
			this.imgIcon = new ImageIcon("src\\Source\\BackGround\\����ȭ��-1.png");
			break;
		case 2:
			this.imgIcon = new ImageIcon("src\\Source\\BackGround\\���_��.png");
			break;
		case 3:
			this.imgIcon = new ImageIcon("src\\Source\\BackGround\\�ձ�_��.png");
			break;
		case 4:
			this.imgIcon = new ImageIcon("src\\Source\\BackGround\\����1.png");
			break;
		case 5:
			this.imgIcon = new ImageIcon("src\\Source\\BackGround\\����2.png");
			break;
		case 6:
			this.imgIcon = new ImageIcon("src\\Source\\BackGround\\���ռ�_��.png");
			break;
		case 7:
			this.imgIcon = new ImageIcon("src\\Source\\BackGround\\��õ��1.png");
			break;
		case 8:
			this.imgIcon = new ImageIcon("src\\Source\\BackGround\\��õ��2.png");
			break;
		case 9:
			this.imgIcon = new ImageIcon("src\\Source\\BackGround\\��õ��3.png");
			break;
		case 10:
			this.imgIcon = new ImageIcon("src\\Source\\BackGround\\��õ��4.png");
			break;
		case 11:
			this.imgIcon = new ImageIcon("src\\Source\\BackGround\\���չ�.png");
			break;
		case 12:
			this.imgIcon = new ImageIcon("src\\Source\\BackGround\\�Ȱ����.png");
			break;
		case 13:
			this.imgIcon = new ImageIcon("src\\Source\\BackGround\\���_��.png");
			break;
		case 14:
			this.imgIcon = new ImageIcon("src\\Source\\BackGround\\���ӿ���.png");
		}
		
		
		this.setIcon(imgIcon);
	}
}
/*
public class Background extends JPanel implements Runnable{
	private BufferedImage img = null;
	public Background(){
		setBounds(0, -10, 960, 560);
		try {
			img = ImageIO.read(new File("src\\Source\\BackGround\\����ȭ��-1.png"));
		}catch(IOException e) {			
			System.exit(1);
		}
	}
	@Override
	public void run() {
		try {
			switch(Main.getStage()) {
			case 1:
				img = ImageIO.read(new File("src\\Source\\BackGround\\����ȭ��-1.png"));
				break;
			case 2:
				img = ImageIO.read(new File("src\\Source\\BackGround\\���_��.png"));
				break;
			case 3:
				img = ImageIO.read(new File("src\\Source\\BackGround\\�ձ�_��.png"));
				break;
			case 4:
				img = ImageIO.read(new File("src\\Source\\BackGround\\����1.png"));
				break;
			case 5:
				img = ImageIO.read(new File("src\\Source\\BackGround\\����2.png"));
				break;
			case 6:
				img = ImageIO.read(new File("src\\Source\\BackGround\\���ռ�_��.png"));
				break;
			case 7:
				img = ImageIO.read(new File("src\\Source\\BackGround\\��õ��1.png"));
				break;
			case 8:
				img = ImageIO.read(new File("src\\Source\\BackGround\\��õ��2.png"));
				break;
			case 9:
				img = ImageIO.read(new File("src\\Source\\BackGround\\��õ��3.png"));
				break;
			case 10:
				img = ImageIO.read(new File("src\\Source\\BackGround\\��õ��4.png"));
				break;
			case 11:
				img = ImageIO.read(new File("src\\Source\\BackGround\\���չ�.png"));
				break;
			case 12:
				img = ImageIO.read(new File("src\\Source\\BackGround\\�Ȱ����.png"));
				break;
			case 13:
				img = ImageIO.read(new File("src\\Source\\BackGround\\���_��.png"));
				break;
			case 14:
				img = ImageIO.read(new File("src\\Source\\BackGround\\���ӿ���.png"));
			}
			
		}catch(IOException e) {			
			System.exit(1);
		}
		
		repaint();
		// TODO Auto-generated method stub
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		g.drawImage(img,0,-10,null);
	}
}*/
