package Object;

import Main.*;

public class OXcorrect extends superOfImg implements Runnable{
	private boolean truefalse = false;
	
	public OXcorrect(boolean ox) {
		this.truefalse = ox;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		setVisible(true);
		if(truefalse) {
			setBounds(0,0,200,200);
			Main.effect("화살표 성공");
			for(int i = 1;i<=6;i++) {
				try {
					setImg("src\\Source\\Object\\O_"+i+".png");
					Thread.sleep(150);
				}catch(InterruptedException e) {
					
				}
			}
		}else {
			setBounds(15,40,173,122);
			Main.effect("화살표 실패");
			for(int i = 1;i<=4;i++) {
				try {
					setImg("src\\Source\\Object\\X_"+i+".png");
					Thread.sleep(150);
				}catch(InterruptedException e) {
					
				}
			}
		}
		remove(this);
	}
	
}
