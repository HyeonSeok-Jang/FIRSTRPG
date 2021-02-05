package Main;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class superOfImg extends JLabel{
	private ImageIcon img;
	public superOfImg() {
		this(0,0,0,0," ");
	}
	public superOfImg(int x, int y, int w, int h) {
		this(x,y,w,h," ");
	}
	public superOfImg(int x, int y, int w, int h, String name) {
		setBounds(x,y,w,h);
		setImg(name);
	}
	public void setImg(String str) {
		this.img = null;
		this.img = new ImageIcon(str);
		this.setIcon(img);
	}
	public ImageIcon getImg() {
		return img;
	}
//	public void setImg(ImageIcon img) {
//		this.img = img;
//	}
	public void moveOpaque(String fileFirst,String fileSecond, int MoveX, int sleepTime) {
		for(int i =1;i<34;i++) {
			this.setImg(fileFirst+i+fileSecond);
			this.setBounds(this.getX()+MoveX,this.getY(),this.getWidth(),this.getHeight());
			try {
				Thread.sleep(sleepTime);
				
			}catch(InterruptedException e) {
				
			}
			
		}
	}
	public void moveOpaqueReverse(String fileFirst,String fileSecond, int MoveX, int sleepTime) {
		for(int i =33;i>0;i--) {
			this.setImg(fileFirst+i+fileSecond);
			this.setBounds(this.getX()+MoveX,this.getY(),this.getWidth(),this.getHeight());
			try {
				Thread.sleep(sleepTime);
				
			}catch(InterruptedException e) {
				
			}
			
		}
	}
}
