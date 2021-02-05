package GUI;

import Main.*;

public class MovingScript extends superOfImg implements Runnable{
	public MovingScript() {
		setBounds(0,550,520,2155);
		setImg("src\\Source\\Script\\St13\\¿£µù1-2.png");
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0;(i<1400)&&Main.isSt1startpressed();i++) {
			this.setBounds(0,this.getY()-2,520,2155);
			try {
				Thread.sleep(50);
			}catch(InterruptedException e) {
				
			}
		}
		
	}
}
