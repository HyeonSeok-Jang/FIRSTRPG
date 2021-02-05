package GUI;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Main.Main;
import Main.superOfImg;
public class TalkingBox extends superOfImg{
	public TalkingBox(){
		setBounds(10, 195, 940, 360);
		setImg(true);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
//				super.mousePressed(e);
				setImg(Main.isTalking());
				Main.setScript(Main.getScript()+1);
			}
		});
	}
	public void setImg(boolean nameYuushaTalking) {
		ImageIcon icon = super.getImg();
		icon = null;
		if(nameYuushaTalking) {
			icon = new ImageIcon("src\\Source\\GUI\\Text_P_2.png");
		}else {
			icon = new ImageIcon("src\\Source\\GUI\\Text_A_2.png");
		}
		
		this.setIcon(icon);
	}
	
}
