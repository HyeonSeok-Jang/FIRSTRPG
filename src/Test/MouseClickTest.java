package Test;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MouseClickTest extends JFrame implements MouseListener{
	JPanel panel = new JPanel();
	JButton button1 = new JButton("누른거 횟수 세기");
	JTextField tf1 = new JTextField(30);
	JButton button2 = new JButton("버튼 올리는거 이벤트 확인");
	JLabel label = new JLabel();
	ImageIcon icon = new ImageIcon("src\\Source\\BackGround\\메인화면-슬라임.png");
	public MouseClickTest() {
		setSize(940,560);
		setTitle("마우스 클릭 이벤트");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		label.setIcon(icon);
		label.addMouseListener(this);
		button1.addMouseListener(this);
		button2.addMouseListener(this);
		
		tf1.setEnabled(false);
		tf1.setText("0");
		
		this.add(panel);
		panel.add(button1);
		panel.add(tf1);
		panel.add(button2);
		panel.add(label);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MouseClickTest clike = new MouseClickTest();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int code = e.getButton();
		
		System.out.println(code);
		tf1.setText(Integer.toString((Integer.parseInt(tf1.getText())+1)));
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("눌러지고 있습니다.");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("떼졌습니다.");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("들어옵니다.");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("나갑니다.");
	}

}
