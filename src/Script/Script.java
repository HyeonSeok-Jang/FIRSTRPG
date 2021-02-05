package Script;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Main.superOfImg;
import Main.Main;
public class Script extends superOfImg{
	public Script(){
		setBounds(10, 285, 940, 240);
		setImg(0,0);
//		addMouseListener(new MouseAdapter() {
//			@Override
//			public void mousePressed(MouseEvent e) {
//				// TODO Auto-generated method stub
////				super.mousePressed(e);
//				setImg(Main.getStage(),Main.getScript()+1);
//				Main.setScript(Main.getScript()+1);
//			}
//		});
	}
	public void setImg(int stage, int script) {
		ImageIcon icon = super.getImg();
		icon = null;
		icon = new ImageIcon("src\\Source\\Script\\St"+stage+"\\ด๋ป็"+script+".png");
		setIcon(icon);
	}
}
