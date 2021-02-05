package GUI;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import GUI.*;
import Main.*;
import Object.*;
import java.util.*;
import java.util.List;
public class AvoidGame extends JFrame implements Runnable{
	private JLabel backG = new JLabel();
	private JPanel panel = new JPanel();
	public AvoidGame(int x, int y){
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\Source\\Icon.png"));
		setTitle("피해라!");
		setSize(750,750);
		setResizable(false);
		setLayout(null);
		panel.setLayout(null);
		panel.setBounds(0,-10,1000,1000);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(x,y);
		backG.setIcon(new ImageIcon("src\\Source\\GUI\\노라조_배경.png"));
		backG.setBounds(-200, -210, 1500, 1500);
		add(panel);
		panel.add(backG);
		setVisible(true);
	}
//	public static void main(String[] args) {
//		AvoidGame ag = new AvoidGame();
//		Thread agdrop = new Thread(ag,"알떨어진다");
//		agdrop.start();
//	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		setVisible(true);
//		ArrayList<JLabel> list = new ArrayList<>();
		for(int i = 0; i<600;i++) {
			try {
				if((int)(Math.random()*10)>7) {
					BlueEgg be = new BlueEgg((int)(Math.random()*750)-15,-50-(int)(Math.random()*20),33,39,"src\\Source\\Object\\Egg_B_1.png");
					Thread Begg = new Thread(be, "");
					Begg.start();
					panel.add(be);
				}
				if(i>200&&(int)(Math.random()*10)>5&&i%2==0) {
					GreenEgg ge = new GreenEgg();
					Thread Gegg = new Thread(ge,"");
					Gegg.start();
					panel.add(ge);
				}
				if(i>400&&(int)(Math.random()*10)>3&&i%10==0) {
					RedEgg re = new RedEgg();
					Thread Regg = new Thread(re,"");
					Regg.start();
					panel.add(re);
				}
				if(i>550) {
					BlueEgg be2 = new BlueEgg((int)(Math.random()*750)-15,-50-(int)(Math.random()*20),33,39,"src\\Source\\Object\\Egg_B_1.png");
					Thread Begg2 = new Thread(be2, "");
					Begg2.start();
					panel.add(be2);
					GreenEgg ge2 = new GreenEgg();
					Thread Gegg2 = new Thread(ge2,"");
					Gegg2.start();
					panel.add(ge2);
					RedEgg re2 = new RedEgg();
					Thread Regg2 = new Thread(re2,"");
					Regg2.start();
					panel.add(re2);
				}
				
				
				
//				for(int j = list.size()-1;j>=0;j--) {
////					if(list.get(j).getY()>500) {
////						list.remove(j);
////						continue;
////					}
//					panel.add(list.get(j));
//				}
				panel.add(backG);
				Thread.sleep(150);
				
				
				
			}catch(InterruptedException e) {
				
			}
		}
		Main.setAnswerClickChoose(true);
		setVisible(false);
	}
	
}

