package GUI;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import Main.superOfImg;

public class St1STARTButton extends superOfImg implements MouseListener{
	
	public St1STARTButton(){
		setBounds(244, 300, 472, 156);
		setImg(" ");
	}
	public void setImg(String str) {
		ImageIcon icon = super.getImg();
		icon = null;
		icon = new ImageIcon(str);
		this.setIcon(icon);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
//		Main.Main.setSt1startpressed(false);
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
//		Main.Main.setSt1startpressed(false);
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		Main.Main.setSt1startpressed(true);
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		this.setImg("src\\Source\\GUI\\START.png");
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		this.setImg("src\\Source\\GUI\\START-CLICK.png");
	}
	
}
