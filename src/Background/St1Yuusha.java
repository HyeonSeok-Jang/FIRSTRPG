package Background;

import java.awt.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import Main.superOfImg;

public class St1Yuusha extends superOfImg{
	public St1Yuusha() {
		setBounds(673, -10, 500, 560);
//		ImageIcon img = new ImageIcon();
		setImg(" ");
	}
}
/*
public class St1Yuusha extends JPanel{
	private BufferedImage img = null;
	private int imgX =730;
	private int times = 1;

	public St1Yuusha() {
		try {
			img = ImageIO.read(new File("src\\Source\\BackGround\\GIF\\메인화면-용사.png"));
		}catch(IOException e) {			
			System.exit(1);
		}
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		imgX-=5;
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
		this.times++;
		repaint();
	}
	public int getTimes() {
		return times;
	}
	public void setTimes(int times) {
		this.times = times;
	}
	public BufferedImage getImg() {
		return img;
	}
	public void setImg(BufferedImage img) {
		this.img = img;
	}
	
}
*/
