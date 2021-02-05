package Object;
import java.awt.event.*;

import Main.*;
public class RedEgg extends superOfImg implements Runnable{
	private MouseAdapter ma=new MouseAdapter() {

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mouseEntered(e);
			System.out.println("데미지 입습니다!");
			YuushaStatus.setHp(YuushaStatus.getHp()-1);
			System.out.println(YuushaStatus.getHp());
			Main.effect("주인공 피격");
		}
		
	};
	public RedEgg(){
		super();
		this.addMouseListener(ma);
		this.setImg("src\\Source\\Object\\Egg_R_1.png");
		this.setBounds((int)(Math.random()*680)-80,-200-(int)(Math.random()*30),163,194);
	}
	@Override
	public void run() {
		int ranDown = (int)(Math.random()*5)+5;
		// TODO Auto-generated method stub
		int ranNum = (int)(Math.random()*50);
		while(getY()<480+ranNum) {//500~530
			setBounds(getX(),getY()+ranDown,getWidth(),getHeight());
			try {
				Thread.sleep(100);
			}catch(InterruptedException e){
				
			}
		}
		try {
			setImg("src\\Source\\Object\\Egg_R_Break_1.png");
			Thread.sleep(100);
			setBounds(getX()-20, getY()+30, 200, 166);
			setImg("src\\Source\\Object\\Egg_R_Break_2.png");
			Thread.sleep(100);
			setBounds(getX()+20, getY()+50, 168, 116);
			setImg("src\\Source\\Object\\Egg_R_Break_3.png");
			Thread.sleep(100);
			setBounds(getX()+20, getY()+50, 131, 57);
			setImg("src\\Source\\Object\\Egg_R_Break_4.png");
//			setImg("src\\Source\\Object\\Egg_B_Break_1.png");
//			Thread.sleep(100);
//			setBounds(getX()-20, getY()+30, 200, 166);
//			setImg("src\\Source\\Object\\Egg_B_Break_2.png");
//			Thread.sleep(100);
//			setBounds(getX()+20, getY()+50, 168, 116);
//			setImg("src\\Source\\Object\\Egg_B_Break_3.png");
//			Thread.sleep(100);
//			setBounds(getX()+20, getY()+50, 131, 57);
//			setImg("src\\Source\\Object\\Egg_B_Break_4.png");
		}catch(InterruptedException e){
			
		}
		removeMouseListener(ma);
	}
}
