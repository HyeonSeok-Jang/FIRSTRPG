package Character;

import Main.*;

public class InsaneChar extends superOfImg implements Runnable{
	public InsaneChar(int x, int y, int w, int h) {
		super(x,y,w,h,"src\\Source\\Character\\ªÁ√µø’_2_normal.png");
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i = 0;
		while(!Main.isAnswerClickChoose()) {
			if(i%2==0) {
				setImg("src\\Source\\Character\\ªÁ√µø’_2_normal.png");
			}else {
				setImg("src\\Source\\Character\\ªÁ√µø’_2_abnormal.png");
			}
			try {
				
				Thread.sleep(100+(int)(Math.random()*100));
			}catch(InterruptedException e) {
				
			}
			i++;
		}
	}
}
