package GUI;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import Main.*;
import Character.*;
public class Potion extends superOfImg{
	public Potion(){
		setBounds(820,0,135,130);
		setIcon(new ImageIcon(new ImageIcon("src\\Source\\GUI\\Potion.png").getImage().getScaledInstance(135, 130, Image.SCALE_SMOOTH)));
		addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mousePressed(e);
				if(YuushaStatus.isPotion()) {
					YuushaStatus.setHp(YuushaStatus.getMaxHp());
					YuushaStatus.setPotion(false);
					setIcon(new ImageIcon(new ImageIcon("src\\Source\\GUI\\Potion_used.png").getImage().getScaledInstance(135, 130, Image.SCALE_SMOOTH)));
				}else {
					System.out.println("이미 사용");
				}
			}
			 
		});
	}
}
