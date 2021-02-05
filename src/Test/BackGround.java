package Test;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
public class BackGround implements Runnable{
//public class BackGround extends YuushaMove{
	
	@Override
	public void run() {
		JLabel label = new JLabel();
		ImageIcon backG = new ImageIcon("src\\Source\\BackGround\\ø’±√_ø’.png");
//		label.setIcon(backG);
		label.setBounds(0, 0, 940, 560);
//		getPanel().add(label);
//		setVisible(true);
		YuushaStaticMove.panel.add(label);
		System.out.println("bbb");
	}
//	@Override
//	protected void paintComponent(Graphics g) {
//		// TODO Auto-generated method stub
//		imgX+=5;
//		super.paintComponent(g);
//		g.drawImage(img,imgX,0,null);
//		
//		System.out.println("component");
//	}
//	public void redraw() {
//		try {
//			img = ImageIO.read(new File("src\\Source\\BackGround\\GIF\\∏ﬁ¿Œ»≠∏È-øÎªÁ"+times+".png"));
//		}catch(IOException e) {			
//			System.exit(1);
//		}
//		repaint();
//	}
}
