package Object;
import java.awt.event.*;

import Main.*;
public class BlueEgg extends superOfImg implements Runnable{
	private MouseAdapter ma=new MouseAdapter() {

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mouseEntered(e);
			System.out.println("데미지 입습니다!");
			YuushaStatus.setHp(YuushaStatus.getHp()-5);
			System.out.println(YuushaStatus.getHp());
			Main.effect("주인공 피격");
		}
		
	};
	public BlueEgg(){
		
		this(0,0,0,0,"");
	}
	public BlueEgg(int x, int y, int w, int h) {
		this(x,y,w,h,"");
	}
	public BlueEgg(int x, int y, int w, int h, String name) {
		
		super(x,y,w,h,name);
		addMouseListener(ma);
	}
	@Override
	public void run() {
		int ranDown = (int)(Math.random()*20)+5;
		// TODO Auto-generated method stub
		int ranNum = (int)(Math.random()*90);
		while(getY()<580+ranNum) {//500~530
			setBounds(getX(),getY()+ranDown,getWidth(),getHeight());
			try {
				Thread.sleep(100);
			}catch(InterruptedException e){
				
			}
		}
		try {
			setImg("src\\Source\\Object\\Egg_B_Break_1.png");
			Thread.sleep(100);
			setBounds(getX()-4, getY()+8, 40, 33);
			setImg("src\\Source\\Object\\Egg_B_Break_2.png");
			Thread.sleep(100);
			setBounds(getX()+4, getY()+12, 34, 23);
			setImg("src\\Source\\Object\\Egg_B_Break_3.png");
			Thread.sleep(100);
			setBounds(getX()+4, getY()+12, 26, 11);
			setImg("src\\Source\\Object\\Egg_B_Break_4.png");
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
