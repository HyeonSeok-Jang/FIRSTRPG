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
	private ImageIcon YuushaImg = new ImageIcon("src\\Source\\Character\\¡÷¿Œ∞¯_normal_1.png");
	private ImageIcon imgIcon;
	public Background() {
		setBounds(0, -10, 960, 560);
	}


	public void setImg(int stage) {
		this.imgIcon = null;
		switch(Main.getStage()) {
		case 1:
			this.imgIcon = new ImageIcon("src\\Source\\BackGround\\∏ﬁ¿Œ»≠∏È-1.png");
			break;
		case 2:
			this.imgIcon = new ImageIcon("src\\Source\\BackGround\\πË∞Ê_»Ê.png");
			break;
		case 3:
			this.imgIcon = new ImageIcon("src\\Source\\BackGround\\ø’±√_ø’.png");
			break;
		case 4:
			this.imgIcon = new ImageIcon("src\\Source\\BackGround\\∆Û«„1.png");
			break;
		case 5:
			this.imgIcon = new ImageIcon("src\\Source\\BackGround\\∆Û«„2.png");
			break;
		case 6:
			this.imgIcon = new ImageIcon("src\\Source\\BackGround\\∏∂ø’º∫_æ’.png");
			break;
		case 7:
			this.imgIcon = new ImageIcon("src\\Source\\BackGround\\ªÁ√µø’1.png");
			break;
		case 8:
			this.imgIcon = new ImageIcon("src\\Source\\BackGround\\ªÁ√µø’2.png");
			break;
		case 9:
			this.imgIcon = new ImageIcon("src\\Source\\BackGround\\ªÁ√µø’3.png");
			break;
		case 10:
			this.imgIcon = new ImageIcon("src\\Source\\BackGround\\ªÁ√µø’4.png");
			break;
		case 11:
			this.imgIcon = new ImageIcon("src\\Source\\BackGround\\∏∂ø’πÊ.png");
			break;
		case 12:
			this.imgIcon = new ImageIcon("src\\Source\\BackGround\\æ»∞≥πË∞Ê.png");
			break;
		case 13:
			this.imgIcon = new ImageIcon("src\\Source\\BackGround\\πË∞Ê_»Ê.png");
			break;
		case 14:
			this.imgIcon = new ImageIcon("src\\Source\\BackGround\\∞‘¿”ø¿πˆ.png");
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
			img = ImageIO.read(new File("src\\Source\\BackGround\\∏ﬁ¿Œ»≠∏È-1.png"));
		}catch(IOException e) {			
			System.exit(1);
		}
	}
	@Override
	public void run() {
		try {
			switch(Main.getStage()) {
			case 1:
				img = ImageIO.read(new File("src\\Source\\BackGround\\∏ﬁ¿Œ»≠∏È-1.png"));
				break;
			case 2:
				img = ImageIO.read(new File("src\\Source\\BackGround\\πË∞Ê_»Ê.png"));
				break;
			case 3:
				img = ImageIO.read(new File("src\\Source\\BackGround\\ø’±√_ø’.png"));
				break;
			case 4:
				img = ImageIO.read(new File("src\\Source\\BackGround\\∆Û«„1.png"));
				break;
			case 5:
				img = ImageIO.read(new File("src\\Source\\BackGround\\∆Û«„2.png"));
				break;
			case 6:
				img = ImageIO.read(new File("src\\Source\\BackGround\\∏∂ø’º∫_æ’.png"));
				break;
			case 7:
				img = ImageIO.read(new File("src\\Source\\BackGround\\ªÁ√µø’1.png"));
				break;
			case 8:
				img = ImageIO.read(new File("src\\Source\\BackGround\\ªÁ√µø’2.png"));
				break;
			case 9:
				img = ImageIO.read(new File("src\\Source\\BackGround\\ªÁ√µø’3.png"));
				break;
			case 10:
				img = ImageIO.read(new File("src\\Source\\BackGround\\ªÁ√µø’4.png"));
				break;
			case 11:
				img = ImageIO.read(new File("src\\Source\\BackGround\\∏∂ø’πÊ.png"));
				break;
			case 12:
				img = ImageIO.read(new File("src\\Source\\BackGround\\æ»∞≥πË∞Ê.png"));
				break;
			case 13:
				img = ImageIO.read(new File("src\\Source\\BackGround\\πË∞Ê_»Ê.png"));
				break;
			case 14:
				img = ImageIO.read(new File("src\\Source\\BackGround\\∞‘¿”ø¿πˆ.png"));
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
