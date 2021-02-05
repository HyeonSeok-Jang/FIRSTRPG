package Test;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MainPanel extends JPanel implements ActionListener{
	private int x, y, w, h;
	private Image image;
	public Timer timer;
	private float alpha = 0f;
	private boolean rightLeft;
	
	public MainPanel() {
		setBounds(0,-10,965,560);
		setLayout(null);
        image = (new ImageIcon("src\\Source\\Face\\마왕_face_1.png")).getImage();
        timer = new Timer(20, this);
//	    timer.start();
	}
	public void setPosition(int x, int y, int w, int h, boolean rightLeft) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.rightLeft = rightLeft;//참이면 +(오른쪽으로 감) 거짓이면 -
	}
	// here you define alpha 0f to 1f
	public void setImg(String str) {
		image = (new ImageIcon(str)).getImage();
	}
	@Override
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    Graphics2D g2d = (Graphics2D) g;
	    g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,alpha));
	    g2d.drawImage(image, x, y, w, h, null);
	    if(rightLeft) {
	    	x++;
	    }else {
	    	x--;
	    }
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		alpha += 0.01f;
	    if (alpha > 1) {
	        alpha = 0;
	        timer.stop();
	        return;
	    }
	    repaint();
	}
}
