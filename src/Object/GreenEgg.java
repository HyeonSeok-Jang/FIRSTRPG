package Object;
import java.awt.event.*;

import Main.*;
public class GreenEgg extends superOfImg implements Runnable{

	private MouseAdapter ma=new MouseAdapter() {

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mouseEntered(e);
			System.out.println("데미지 입습니다!");
			YuushaStatus.setHp(YuushaStatus.getHp()-2);
			System.out.println(YuushaStatus.getHp());
			Main.effect("주인공 피격");
		}
		
	};
	public GreenEgg(){
		super();
		this.addMouseListener(ma);
		this.setImg("src\\Source\\Object\\Egg_G_1.png");
		this.setBounds((int)(Math.random()*710)-40,-100-(int)(Math.random()*30),82,97);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int ranDown = (int)(Math.random()*15)+5;
		int ranNum = (int)(Math.random()*70);
		while(getY()<550+ranNum) {//500~530
			setBounds(getX(),getY()+ranDown,getWidth(),getHeight());
			try {
				Thread.sleep(100);
			}catch(InterruptedException e){
				
			}
		}
		try {
			setImg("src\\Source\\Object\\Egg_G_Break_1.png");
			Thread.sleep(100);
			setBounds(getX()-10, getY()+15, 100, 83);
			setImg("src\\Source\\Object\\Egg_G_Break_2.png");
			Thread.sleep(100);
			setBounds(getX()+10, getY()+25, 84, 58);
			setImg("src\\Source\\Object\\Egg_G_Break_3.png");
			Thread.sleep(100);
			setBounds(getX()+10, getY()+25, 66, 29);
			setImg("src\\Source\\Object\\Egg_G_Break_4.png");
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
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setVisible(false);
		getParent().remove(this);
	}

}
