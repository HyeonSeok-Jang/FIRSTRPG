package Test;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MouseClickTest extends JFrame implements MouseListener{
	JPanel panel = new JPanel();
	JButton button1 = new JButton("������ Ƚ�� ����");
	JTextField tf1 = new JTextField(30);
	JButton button2 = new JButton("��ư �ø��°� �̺�Ʈ Ȯ��");
	JLabel label = new JLabel();
	ImageIcon icon = new ImageIcon("src\\Source\\BackGround\\����ȭ��-������.png");
	public MouseClickTest() {
		setSize(940,560);
		setTitle("���콺 Ŭ�� �̺�Ʈ");
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
		System.out.println("�������� �ֽ��ϴ�.");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("�������ϴ�.");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("���ɴϴ�.");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("�����ϴ�.");
	}

}
