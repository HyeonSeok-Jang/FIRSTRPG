package GUI;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import Main.superOfImg;
public class St1St2St13SkipNext extends superOfImg implements MouseListener{
	public St1St2St13SkipNext() {
		super();
		setBounds(700, 420, 157, 49);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
//		System.out.println("asdasd");
		if(this.getIcon()==new ImageIcon("src\\Source\\GUI\\다음-2.png")) {
			this.setImg("src\\Source\\GUI\\스킵-2.png");
		}else {
			this.setImg("src\\Source\\GUI\\다음-2.png");
		}
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		Main.Main.setSt1startpressed(true);
		this.setImg("src\\Source\\GUI\\");
		Main.Main.setStage(Main.Main.getStage()+1);
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}
}
