package Object;

import Main.*;

public class Portal extends superOfImg implements Runnable{
	public Portal(){
		setBounds(750,400,133,84);
		setImg("src\\Source\\Object\\Æ÷Å»_1.png");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Main.isAnswerClickChoose());
		while(!Main.isAnswerClickChoose()) {
			for(int i = 1;i<=3;i++) {
				setImg("src\\Source\\Object\\Æ÷Å»_"+i+".png");
				try {
					Thread.sleep(500);
				}catch(InterruptedException e) {
					
				}
			}
		}
		
	}
	
}
