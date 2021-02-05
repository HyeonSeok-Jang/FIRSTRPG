package Test;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Smile implements Runnable{
//public class Smile extends YuushaMove{
	private static int SHP = 100;
	@Override
	public void run() {
		ImageIcon SlimeImg = new ImageIcon("src\\Source\\Character\\ΩΩ∂Û¿”_1_normal.png");
		JLabel Slime = new JLabel();
		Slime.setIcon(SlimeImg);
		Slime.setBounds(200, 100, 680, 600);
//		getPanel().setBounds(150, 50, 400, 400);
		YuushaStaticMove.getPanel().add(Slime);
//		setVisible(true);
		while(true) {
			try {
				Thread.sleep(500);
				if(Test.getYuusha().getX()+150<Slime.getX())
					Slime.setBounds(Slime.getX()-10,Slime.getY(),Slime.getWidth(),Slime.getHeight());
				else if(Test.getYuusha().getX()-30>Slime.getX())
//				else
					Slime.setBounds(Slime.getX()+10,Slime.getY(),Slime.getWidth(),Slime.getHeight());
				else
					Thread.interrupted();
				
			}catch(InterruptedException e) {
				
			}
		}
	}
}
