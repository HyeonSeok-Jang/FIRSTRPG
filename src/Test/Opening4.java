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

public class Opening4 extends JPanel implements ActionListener{
	private Image imagem;
	private Image image2;
//	private Im
	private Timer timer;
	private float alpha = 0f;
	
	public Opening4() {
//		setBackground(Color.BLACK);
		setBackground(new Color(0,0,0,255));
		
		imagem = (new ImageIcon("src\\Source\\Face\\¸¶¿Õ_face_1.png")).getImage();
        image2 = (new ImageIcon("src\\Source\\Face\\¸¶¿Õ_face_1.png")).getImage();
        timer = new Timer(20, this);
	    timer.start();
	}
	// here you define alpha 0f to 1f
	
	public Opening4(float alpha) {
	    imagem = (new ImageIcon(getClass().getResource("src\\Source\\Face\\¸¶¿Õ_face_1.png"))).getImage();
	    this.alpha = alpha;
	}
	
	@Override
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    Graphics2D g2d = (Graphics2D) g;
//	    g2d.drawImage(imagem, 0, 0, 550, 550, null);
	    g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,alpha));
	    g2d.drawImage(image2, 0, 0, 550, 550, null);
	}
	
	public static void main(String[] args) {
	    JFrame frame = new JFrame("Fade out");
	    frame.add(new Opening4());
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(700, 700);
	    // frame.pack();
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
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
