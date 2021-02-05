package Test;

import javax.swing.*;

public class TestNormal implements Runnable{
	public void run() {
		
		while(true) {
			try {
				Thread.sleep(250);
				if(YuushaStaticMove.isWaitNormal()||!YuushaStaticMove.isPressed()) {
					for(int i = 1;i<=4;i++) {
						if(!YuushaStaticMove.isWaitNormal()||YuushaStaticMove.isPressed())
							break;
						if(i == 4)
							Test.setImg("src\\Source\\Character\\주인공_normal_2.png");
						else
							Test.setImg("src\\Source\\Character\\주인공_normal_"+i+".png");
						if(!YuushaStaticMove.isWaitNormal()||YuushaStaticMove.isPressed())
							break;
						Thread.sleep(250);
						if(!YuushaStaticMove.isWaitNormal()||YuushaStaticMove.isPressed())
							break;
					}
					
				}
			}catch(InterruptedException e) {
				
			}

		}
	}
}
