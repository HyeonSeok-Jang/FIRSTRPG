package Test;
import javax.swing.*;
public class Tick extends JFrame{
	private JLabel label = new JLabel();
	public Tick() {
		setSize(600,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		label.setText("�ƾƾƾƾ�");
		label.repaint();
		this.add(label);
		setVisible(true);
	}
	public static void main(String[] args) {
		Tick tick = new Tick();
		tick.label.setText("�ƴϾ�");
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			
		}
		tick.label.setText("�ٲ�����ϴ�");
	}
}
