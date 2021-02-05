package GUI;

import java.awt.*;

import javax.swing.*;

import Main.*;
import Character.*;
public class Hp_Bar extends superOfImg implements Runnable{
	public Hp_Bar(){
		setBounds(26,26,400,26);
		setIcon(new ImageIcon(new ImageIcon("src\\Source\\GUI\\HP_P_Bar_10.png").getImage().getScaledInstance(400, 26, Image.SCALE_SMOOTH)));
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(Main.isHpIng()) {
//		while(true) {
			System.out.println("회전중 체력바");
//			setImg("src\\Source\\GUI\\HP_P_Bar_10.png");
			setImg("src\\Source\\GUI\\HP_P_Bar_"+(YuushaStatus.getHp()/10)+".png");
//			setIcon(new ImageIcon(new ImageIcon().getImage().getScaledInstance(400, 26, Image.SCALE_SMOOTH)));
			this.repaint();
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				
			}
		}
	}
}
