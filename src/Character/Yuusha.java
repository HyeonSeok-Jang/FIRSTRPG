package Character;
import Main.*;
public class Yuusha extends superOfImg implements Runnable{
	
	/*
	 * condition에 따라 행동이 달라짐
	 * 1이면 점프 67
	 * 2이면 걷기 좌37    우39
	 * 3이면 맞기
	 * 4이면 공격 88
	 * 우선순위는 공격>맞기>걷기>점프
	 */
	public Yuusha(){
		setBounds(100, 300, 224, 198);
		setImg("src\\Source\\Character\\주인공_normal_1.png");
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(Main.isMove()) {
			if(Main.isAnswerClickChoose())break;
			while(Main.isMovePress()&&YuushaStatus.getCondition()==0) {
				if(Main.isAnswerClickChoose())break;
				try {
					Thread.sleep(250);
				}catch(InterruptedException e) {
					
				}
				if(!(Main.isMovePress()&&YuushaStatus.getCondition()==0))break;
				if(Main.isAnswerClickChoose())break;
				for(int i = 1;i<=3;i++) {
					if(!(Main.isMovePress()&&YuushaStatus.getCondition()==0))break;
					if(YuushaStatus.isDirection())
						setImg("src\\Source\\Character\\주인공_normal_"+i+".png");
					else {
						setImg("src\\Source\\Character\\좌우반전\\주인공_normal_"+i+".png");
					}
					if(!(Main.isMovePress()&&YuushaStatus.getCondition()==0))break;
					try {
						Thread.sleep(150);
						
					}catch(InterruptedException e) {
						
					}
					if(!(Main.isMovePress()&&YuushaStatus.getCondition()==0))break;
					if(Main.isAnswerClickChoose())break;
				}
				if(YuushaStatus.isDirection())
					setImg("src\\Source\\Character\\주인공_normal_2.png");
				else {
					setImg("src\\Source\\Character\\좌우반전\\주인공_normal_2.png");
				}
				if(Main.isAnswerClickChoose())break;
			}
			if(YuushaStatus.getCondition()==67) {
				setImg("src\\Source\\Character\\주인공_jump_1.png");
				try {
					Thread.sleep(700);
				}catch(InterruptedException e1) {
					
				}
			}
			if(YuushaStatus.getCondition()==67) {
				for(int j = 9;j>=0;j--) {
					for(int i = 2;i<=3;i++) {
						if(Main.isAnswerClickChoose())break;
						setImg("src\\Source\\Character\\주인공_jump_"+i+".png");
						setBounds(getX(), (int)(getY()-(Math.sin(Math.toRadians(j*10))*5)), getWidth(), getHeight());
						try {
							Thread.sleep(100);
						}catch(InterruptedException e2) {
						}
						if(Main.isAnswerClickChoose())break;
					}
					if(Main.isAnswerClickChoose())break;
				}
				if(Main.isAnswerClickChoose())break;
				for(int j = 0;j<=9;j++) {
					for(int i = 4;i<=5;i++) {
						setImg("src\\Source\\Character\\주인공_jump_"+i+".png");
						setBounds(getX(), (int)(getY()+(Math.sin(Math.toRadians(j*10))*5)), getWidth(), getHeight());
						try {
							Thread.sleep(100);
						}catch(InterruptedException e2) {
						}
					}
				}
				YuushaStatus.setCondition(0);
				Main.setMovePress(true);
			}
			while(YuushaStatus.getCondition()==37&&!Main.isMovePress()&&getX()>0) {
				if(Main.isAnswerClickChoose())break;
				YuushaStatus.setDirection(false);
				for(int i = 1;i<=4;i++) {
					if(Main.isAnswerClickChoose())break;
					setImg("src\\Source\\Character\\좌우반전\\주인공_run_"+i+".png");
					setBounds(getX()-20, getY(), getWidth(), getHeight());
					waitSecond(150);
				}
				YuushaStatus.setCondition(0);
				Main.setMovePress(true);
			}
			
			while(YuushaStatus.getCondition()==39&&!Main.isMovePress()&&getX()<1000) {
				if(Main.isAnswerClickChoose())break;
				YuushaStatus.setDirection(true);
				for(int i = 1;i<=4;i++) {
					if(Main.isAnswerClickChoose())break;
					setImg("src\\Source\\Character\\주인공_run_"+i+".png");
					setBounds(getX()+20, getY(), getWidth(), getHeight());
					waitSecond(150);
				}
				Main.setMovePress(true);
				YuushaStatus.setCondition(0);
			}
			if(YuushaStatus.getCondition()==88) {
				if(Main.isAnswerClickChoose())break;
				if(YuushaStatus.isDirection()) {
					for(int i = 1;i<=4;i++) {
						if(Main.isAnswerClickChoose())break;
						setImg("src\\Source\\Character\\주인공_attack_"+i+".png");
						try {
							Thread.sleep(300);
						}catch(InterruptedException e2) {
						}
					}
				}else {
					setBounds(getX()-80,getY(),getWidth(),getHeight());
					for(int i = 1;i<=4;i++) {
						if(Main.isAnswerClickChoose())break;
						setImg("src\\Source\\Character\\좌우반전\\주인공_attack_"+i+".png");
						try {
							Thread.sleep(300);
						}catch(InterruptedException e2) {
						}
					}
					setBounds(getX()+80,getY(),getWidth(),getHeight());
					if(Main.isAnswerClickChoose())break;
				}
				Main.setMovePress(true);
				YuushaStatus.setCondition(0);
				if(Main.isAnswerClickChoose())break;
			}
		}
		Main.setAnswerClickChoose(true);
	}
	public void waitSecond(int i) {
		try {
			Thread.sleep(i);
		}catch(InterruptedException e2) {
		}
	}
}
