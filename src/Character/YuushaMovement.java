package Character;

import java.awt.event.*;
import javax.swing.*;

import Main.Main;
import Main.YuushaStatus;
import Test.Test;
import Test.YuushaStaticMove;

import java.awt.*;


public class YuushaMovement implements Runnable{

	public void run() {
		// TODO Auto-generated method stub
		/*
		while(Main.isMove()) {
			try {
				for(int i = 1;i<=3;i++) {
					Thread.sleep(400);
				}
			}catch(InterruptedException e) {
				if(YuushaStatus.getCondition()==1) {
					try {
						Thread.sleep(700);
					}catch(InterruptedException e1) {
					}
				}
				while(YuushaStatus.getCondition()==1) {
					for(int i = 2;i<=3;i++) {
						if(!(YuushaStatus.getCondition()==1))
							break;
						try {
							Thread.sleep(500);
						}catch(InterruptedException e2) {
						}
					}
					for(int i = 3;i<=4;i++) {
						if(!(YuushaStatus.getCondition()==1))
							break;
						try {
							Thread.sleep(500);
						}catch(InterruptedException e2) {
						}
					}
					if(!(YuushaStatus.getCondition()==1))
						break;
				}
				while(YuushaStatus.getCondition()==2) {
					if(YuushaStatus.getCondition()>2)
						break;
					for(int i = 1;i<=4;i++) {
						if(YuushaStatus.getCondition()>2)
							break;
						try {
							Thread.sleep(300);
						}catch(InterruptedException e2) {
						}
					}
					if(YuushaStatus.getCondition()>2)
						break;
				}
				while(YuushaStatus.getCondition()==3) {
					for(int i = 1;i<=3;i++) {
						try {
							Thread.sleep(400);
						}catch(InterruptedException e2) {
						}
					}
				}
				while(YuushaStatus.getCondition()==4) {
					for(int i = 1;i<=4;i++) {
						try {
							Thread.sleep(300);
						}catch(InterruptedException e2) {
						}
					}
				}
			}
		}
		*/
//		private Thread rest= new Thread(new TestNormal(),"통상");
		/*
			while(Main.isMove()) {
				try {
					Thread.sleep(1000);
				}catch(InterruptedException e) {
					System.out.println("ASB");
					if(code==88) {
						for(int i = 1;i<=4;i++) {
							Test.setImg("src\\Source\\Character\\주인공_attack_"+i+".png");
							try {
								switch(i) {
								case 1:
									Thread.sleep(200);
									break;
								case 2:
									Thread.sleep(200);
									break;
								case 3:
									Thread.sleep(250);
									break;
								case 4:
									Thread.sleep(500);
									break;
								}
								
							}catch(InterruptedException e1) {
								
							}
						}
						
					}
					if(code==67) {
						for(int i = 18;i>=0;i--) {
							if(i==6||i==18) {
								Test.setImg("src\\Source\\Character\\주인공_jump_2.png");
							}else if(i==0||i==12){
								Test.setImg("src\\Source\\Character\\주인공_jump_3.png");	
							}

							
							Test.Yuusha.setBounds(Test.Yuusha.getX(), (int)(Test.Yuusha.getY()-(Math.sin(Math.toRadians(i*5))*5)), 182, 182);
							
							try {
								Thread.sleep(50);
							}catch(InterruptedException e1) {
								
							}
						}
						
					}
					for(int i = 1;i<=4;i++) {
						Test.setImg("src\\Source\\Character\\주인공_run_"+i+".png");
//						Test.getYuusha().setIcon(new ImageIcon("src\\Source\\Character\\주인공_run_"+i+".png"));
						switch(code) {
						case KeyEvent.VK_LEFT:
							Test.getYuusha().setBounds(Test.getYuusha().getX()-10, Test.getYuusha().getY(), Test.getYuusha().getWidth(), Test.getYuusha().getHeight());
							break;
						case KeyEvent.VK_KP_LEFT:
							Test.getYuusha().setBounds(Test.getYuusha().getX()-10, Test.getYuusha().getY(), Test.getYuusha().getWidth(), Test.getYuusha().getHeight());
							break;
						case KeyEvent.VK_RIGHT:
							Test.getYuusha().setBounds(Test.getYuusha().getX()+10, Test.getYuusha().getY(), Test.getYuusha().getWidth(), Test.getYuusha().getHeight());
							break;
						case KeyEvent.VK_KP_RIGHT:
							Test.getYuusha().setBounds(Test.getYuusha().getX()+10, Test.getYuusha().getY(), Test.getYuusha().getWidth(), Test.getYuusha().getHeight());
							break;
						}
						try {
							Thread.sleep(150);
						}catch(InterruptedException e1) {
							
						}
						
					}
					int i = 0;
					while(Yuusha.getY()<300) {
						if(i==25||i==80) {
							Test.setImg("src\\Source\\Character\\주인공_jump_2.png");
						}else if(i==0||i==50){
							Test.setImg("src\\Source\\Character\\주인공_jump_3.png");	
						}
						Yuusha.setBounds(Test.Yuusha.getX(), (int)(Test.Yuusha.getY()+(Math.sin(Math.toRadians(i*5))*5)), 182, 182);
//						Test.Yuusha.setBounds(Test.Yuusha.getX(), (int)(Test.Yuusha.getY()+(Math.cos((double)i*Math.PI/180))), 182, 182);
						try {
							Thread.sleep(50);
						}catch(InterruptedException e1) {
							
						}
						if(i<90) {
							i++;
						}
					}
					YuushaStaticMove.setPressed(false);
				}

			}
		Main.setAnswerClickChoose(true);*/
	}
	
}
