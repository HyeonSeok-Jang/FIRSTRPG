package Test;
import javax.swing.*;
public class Tick extends JFrame{
	private JLabel label = new JLabel();
	public Tick() {
		setSize(600,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		label.setText("아아아아아");
		label.repaint();
		this.add(label);
		setVisible(true);
	}
	public static void main(String[] args) {
		Tick tick = new Tick();
		tick.label.setText("아니야");
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			
		}
		tick.label.setText("바뀌었습니다");
	}
}
