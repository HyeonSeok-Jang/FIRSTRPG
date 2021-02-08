package Main;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.*;
import Background.*;
import Character.*;
import GUI.*;
import Script.*;
import Object.*;

public class Main extends JFrame implements Runnable, KeyListener{
	private static boolean answerClickChoose = false;//
	private static boolean BGMIng = true;
	private static boolean hpIng = true;
	private static boolean move = false;
	private static boolean movePress = true;
	private static boolean st1startpressed = true;
	private static boolean scriptIng = true; //true값을 가져서 반복문을 돌게해서 스크립트 막 지나가지 않게 하는 용도
	private static boolean talking = true;//GUI 대화창 좌우반전 효과 적용하는거임...
	private static int answer = -1;
	private static int script = 1;
	private static int stage = 1;
	private static String nowName = "왕";
	private static Yuusha yuusha = new Yuusha();
	
	private AvoidGame avoidEgg = null;
	private Background stageBackground = new Background();
	private BGM bgm = null;
	private boolean sk = false;
	
	private DDRGame ddr = null;
	private Face face = new Face();
	private Hp_Bar hp = new Hp_Bar();
	private Hp_Bucket hpTong = new Hp_Bucket();
	
	private Image img = Toolkit.getDefaultToolkit().getImage("src\\Source\\Icon.png");
	private InsaneChar salamander = new InsaneChar(570,330,132,182);
	private KeyPadGame doorLock = null;
	private long time;
	
	private MovingScript ms = new MovingScript();
	private Name name = new Name();
	private NickName[] nickName = new NickName[3];
	
	private Portal portal = new Portal();
	private Potion potion = new Potion();
	private returnButton rtnBtn = new returnButton();
	
	private Script scriptContents = new Script();
	private St1Frontground st1FB = new St1Frontground();
	private St1Slime st1Slime = new St1Slime();
	private St1St2St13SkipNext skipNext = new St1St2St13SkipNext();
	private St1STARTButton st1start = new St1STARTButton();
	private St1Tuto st1Tuto = new St1Tuto();
	private St1WBackground st1WB = new St1WBackground();
	private St1Yuusha st1Yuusha = new St1Yuusha();
	private superOfImg panelCh1 = new superOfImg();
	private superOfImg panelCh2 = new superOfImg();
	
	private thisStageButton tStgBtn = new thisStageButton();
	private TalkingBox talkingBox = new TalkingBox();
	private TerminateGame terminate = null;
	private Thread yuushaMove;
	
	private MouseAdapter scriptContentsListener= new MouseAdapter() {
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO script
			if(nowName.equals("용사"))
				talking=true;
			else
				talking=false;
			scriptContents.setImg(stage,script);
			talkingBox.setImg(talking);
			face.setImg(nowName);
			name.setName(nowName);
			scriptIng=false;
		}
	};
	private MouseAdapter scriptMunjae = new MouseAdapter() {
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO script
			if(nowName.equals("용사"))
				talking=true;
			else
				talking=false;
			if(YesOrNo.munjae())
				scriptContents.setImg(stage,16);
			else
				scriptContents.setImg(stage,17);
			talkingBox.setImg(talking);
			face.setImg(nowName);
			name.setName(nowName);
			scriptIng=false;
		}
	};
	public Main(){
		setTitle("집들이 나간 공주 구하기");
		setSize(975,560);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setIconImage(img);
		rtnBtn.setImg("src\\Source\\GUI\\처음으로-1.png");
		rtnBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO st1start
				st1startpressed = false;
				stage=1;
				
			}
		});
		scriptContents.addMouseListener(scriptContentsListener);
		skipNext.addMouseListener(new MouseAdapter() {
			// TODO skipNext
			@Override
			public void mousePressed(MouseEvent e) {
				if(sk) {
					skipNext.setImg("src\\Source\\GUI\\스킵-2.png");
				}else {
					skipNext.setImg("src\\Source\\GUI\\다음-2.png");
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				st1startpressed = false;
				skipNext.setImg("src\\Source\\GUI\\");
				Main.setStage(Main.getStage()+1);
			}
		});
		st1start.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO st1start
				st1startpressed = false;
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				st1start.setImg("src\\Source\\GUI\\START.png");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				st1start.setImg("src\\Source\\GUI\\START-CLICK.png");
			}
		});
		tStgBtn.setImg("src\\Source\\GUI\\이번스테이지 다시하기.png");
		tStgBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO st1start
				st1startpressed = false;
				stage=YuushaStatus.getStage();
				time = 0;
				YuushaStatus.setHp(YuushaStatus.getStageHp());
				YuushaStatus.setMaxHp(YuushaStatus.getStageMaxHp());
				YuushaStatus.setTime(0);
			}
		});
		
		
		//TODO 순서
		//이미지 순서기 때문에 절대로 바꾸지 말 것.
		for(int i = 0;i<nickName.length;i++) {
			nickName[i]=new NickName();
			add(nickName[i]);
		}
		add(ms);
		add(skipNext);
		add(rtnBtn);
		add(tStgBtn);
		add(st1Tuto);
		add(st1start);
		
		add(st1WB);
		add(st1FB);
		add(portal);
		add(name);
		add(scriptContents);
		
		add(talkingBox);
		add(yuusha);
		add(panelCh1);
		add(panelCh2);
		add(salamander);
		
		add(face);
		add(hp);
		add(hpTong);
		add(potion);
		

		add(st1Yuusha);
		add(st1Slime);
		add(stageBackground);
		

		
		setVisible(true);
		
		for(int i = 0;i<nickName.length;i++) 
			nickName[i].setVisible(false);
		face.setVisible(false);
		hp.setVisible(false);
		hpTong.setVisible(false);
		ms.setVisible(false);
		name.setVisible(false);
		
		panelCh1.setVisible(false);
		panelCh2.setVisible(false);
		portal.setVisible(false);
		potion.setVisible(false);
		rtnBtn.setVisible(false);
		
		salamander.setVisible(false);
		scriptContents.setVisible(false);
		skipNext.setVisible(false);
		st1start.setVisible(false);
		talkingBox.setVisible(false);
		
		tStgBtn.setVisible(false);
		yuusha.setVisible(false);
	}
	
	@Override
	public void run() {
		while(stage<15) {
			bgm = new BGM(stage);
			Thread bgmThread = new Thread(bgm, "배경음악");
			YuushaStatus.setStage(stage);
			stageBackground.setImg(stage);
			switch(stage){
			case 1:
				bgmThread.start();
				// TODO St1
				YuushaStatus.setPotion(true);
				YuushaStatus.setHp(100);
				YuushaStatus.setMaxHp(100);
				YuushaStatus.setTime(0);
				YuushaStatus.setPrincessLive(true);
				YuushaStatus.setCondition(0);
				
				st1Yuusha.setBounds(673, -10, 500, 560);
				st1Slime.setBounds(-48, 143, 398, 560);
				st1Yuusha.moveOpaque("src\\Source\\BackGround\\GIF\\메인화면-용사", ".png", -3, 50);
				st1Slime.moveOpaque("src\\Source\\BackGround\\GIF_SLIME\\메인화면-슬라임", ".png", 2, 50);
				for(int i = 2;i<=4;i++) {
					try {
						Thread.sleep(300);
						st1WB.setVisible(true);
						st1WB.setImg("src\\Source\\BackGround\\배경_백.png");
					}catch(InterruptedException e) {
						
					}
					if(i!=4)
						effect("Swords Clash   High Quality #2 by Christopherderp Id-364530-1");
					else
						effect("Sword Fast Unsheath by ethanchase7744 Id-468695-2");
					try {
						Thread.sleep(300);
						st1FB.setImg("src\\Source\\BackGround\\메인화면-"+i+".png");
					}catch(InterruptedException e) {
						
					}
					
					st1WB.setVisible(false);
				}
				
				st1start.setImg("src\\Source\\GUI\\START-CLICK.png");
				st1start.setVisible(true);
				try {
					while(st1startpressed) {
						
						Thread.sleep(500);
					}
				}catch(InterruptedException e) {
					
				}
				st1startpressed = true;
				st1start.setVisible(false);
				
				st1Tuto.setBounds(0, -10, 960, 560);
				st1Tuto.setImg("src\\Source\\BackGround\\메인화면-5.png");
				skipNext.setImg("src\\Source\\GUI\\다음-1.png");
				skipNext.setVisible(true);
				try {
					while(st1startpressed) {
						Thread.sleep(500);
					}
				}catch(InterruptedException e) {
					
				}
				st1startpressed = true;
				skipNext.setVisible(false);
				BGMIng = false;
				Thread.interrupted();
				break;
				
			case 2:
				// TODO St2
				bgmThread.start();
				st1WB.setVisible(true);
				st1WB.setImg("src\\Source\\BackGround\\인트로-1.png");
				st1WB.setBounds(0,-10,960,300);
				st1FB.setImg("src\\Source\\Script\\인트로.png");
				st1FB.setBounds(104, 550, 753, 497);
				skipNext.setBounds(700, 50, 157, 49);
				sk = true;
				skipNext.setImg("src\\Source\\GUI\\스킵-1.png");
				skipNext.setVisible(true);
				for(int i = 0; i<840;i++) {
					st1FB.setBounds(st1FB.getX(), st1FB.getY()-1, 753, 497);
					if(!st1startpressed)
						break;
					try {
						Thread.sleep(50);
					}catch(InterruptedException e) {
					}
				}
				sk = false;
				if(st1startpressed) {
					skipNext.setImg("src\\Source\\GUI\\다음-1.png");
					try {
						while(true) {
							if(st1startpressed)
								break;
							Thread.sleep(500);
						}
					}catch(InterruptedException e) {
					}
				}
				skipNext.setVisible(false);
				st1startpressed=false;
				BGMIng = false;
				stage = 8;
				break;
			case 3://script 16EA
				// TODO St3
				bgmThread.start();
				nickName[0].setPosition(700,195,160,30);
				nickName[0].setMoveOpaque("src\\Source\\GUI\\Name\\왕\\", ".png", -2, 50);
				Thread nickKing = new Thread(nickName[0], "왕 닉네임");
				nickKing.start();
				firstIng("왕");
				startIng("왕");
				startIng("왕");
				startIng("왕");
				this.yesOrNoKing("왕");
				startIng("왕");
				yesOrNo("왕","왕");
				if(answer == 1)
					startIng("왕");
				yesOrNo("왕","왕");
				if(answer == 1)
					startIng("왕");
				yesOrNo("왕","왕");
				if(answer == 1)
					startIng("왕");
				yesOrNo("왕","왕");
				if(answer == 1)
					startIng("왕");
				yesOrNo("왕","왕");
				if(answer == 1) {
					startIng("왕");
				}
				endIng();
				break;
			case 4://script 9EA
				// TODO St4
				bgmThread.start();
				nickName[0].setPosition(700,195,160,30);
				nickName[0].setMoveOpaque("src\\Source\\GUI\\Name\\말랑이\\", ".png", -2, 50);
				Thread nickSlime1 = new Thread(nickName[0], "말랑이");
				nickSlime1.start();
				firstIng("말랑이");
				startIng("찰팍이");
				nickName[1].setPosition(600,145,160,30);
				nickName[1].setMoveOpaque("src\\Source\\GUI\\Name\\찰팍이\\찰팍이", ".png", -2, 50);
				Thread nickSlime2 = new Thread(nickName[1], "찰팍이");
				nickSlime2.start();
				
				face.setYuushaFace(1);
				startIng("용사");
				nickName[2].setPosition(190,195,180,30);
				nickName[2].setMoveOpaque("src\\Source\\GUI\\Name\\용사\\", ".png", 2, 50);
				Thread nickYuusha = new Thread(nickName[2], "용사");
				nickYuusha.start();
				startIng("찰팍이");
				startIng("말랑이");
				
				startIng("찰팍이");
				startIng("말랑이");
				startIng("나레이션");
				
				miniGame("용사",4);
				
				
				endIng();
				yuushaEndMove();
				break;
			case 5://script 10EA
				// TODO St5
				bgmThread.start();
				firstIng("뿌용이");
				nickName[0].setPosition(700,195,160,30);
				nickName[0].setMoveOpaque("src\\Source\\GUI\\Name\\뿌용이\\", ".png", -2, 50);
				Thread nickSlime3 = new Thread(nickName[0], "뿌용이");
				nickSlime3.start();
				startIng("쭈욱이");
				nickName[1].setPosition(770,145,160,30);
				nickName[1].setMoveOpaque("src\\Source\\GUI\\Name\\쭈욱이\\쭈욱이", ".png", -2, 50);
				Thread nickSlime4 = new Thread(nickName[1], "쭈욱이");
				nickSlime4.start();
				face.setYuushaFace(2);
				startIng("용사");
				startIng("쭈욱이");
				face.setYuushaFace(1);
				startIng("용사");
				
				startIng("쫀득이");
				nickName[2].setPosition(840,195,160,30);
				nickName[2].setMoveOpaque("src\\Source\\GUI\\Name\\쫀득이\\쫀득이", ".png", -2, 50);
				Thread nickSlime5 = new Thread(nickName[2], "쫀득이");
				nickSlime5.start();
				startIng("뿌용이");
				startIng("쭈욱이");
				startIng("나레이션");
				miniGame("용사",4);
				endIng();
				yuushaEndMove();
				break;
			case 6://script 2EA
				// TODO St6
				bgmThread.start();
				face.setYuushaFace(1);
				firstIng("용사");
				startIng("나레이션");
				endIng();
				yuushaEndMove();
				break;
			case 7://script 18EA
				// TODO St7
				bgmThread.start();
				firstIng("용사");
				face.setYuushaFace(5);
				startIng("용사");
				startIng("컨트롤러");
				nickName[0].setPosition(700,195,160,30);
				nickName[0].setMoveOpaque("src\\Source\\GUI\\Name\\컨트롤러\\컨트롤러", ".png", -2, 50);
				Thread nickSa1 = new Thread(nickName[0], "컨트롤러");
				nickSa1.start();
				face.setYuushaFace(5);
				startIng("용사");
				startIng("컨트롤러");
				
				face.setYuushaFace(3);
				startIng("용사");
				startIng("컨트롤러");
				startIng("컨트롤러");
				face.setYuushaFace(4);
				startIng("용사");
				startIng("컨트롤러");
				yesOrNo("컨트롤러","컨트롤러");
				if(answer == 1)
					startIng("컨트롤러");
				startIng("나레이션");
				miniGameDoor("용사",3,1);
				startIng("컨트롤러");
				
				startIng("나레이션");
				miniGameDoor("용사",5,2);
				script = 17;
				startIng("컨트롤러");
				endIng();
				
				panelCh1.setImg("src\\Source\\Character\\사천왕_1_normal.png");
				panelCh1.setBounds(570,230,200,275);
				panelCh1.setVisible(true);
				yuushaEndMove();
				panelCh1.setVisible(false);
				break;
			case 8://script 29EA
				// TODO St8
				face.setYuushaFace(3);
				firstIng("용사");
				face.setYuushaFace(4);
				effect("Eagle Owl by greither Id-115608");
				startIng("용사");
				
				startIng("용사");
				startIng("살라만다");
				face.setYuushaFace(1);
				startIng("용사");
				
				startIng("살라만다");
				nickName[0].setPosition(700,195,160,30);
				nickName[0].setMoveOpaque("src\\Source\\GUI\\Name\\살라만다\\", ".png", -2, 50);
				startIng("용사");
				startIng("살라만다");
				startIng("살라만다");
				face.setYuushaFace(3);
				startIng("용사");
				flash();
				startIng("살라만다");
				face.setYuushaFace(6);
				startIng("용사");
				startIng("살라만다");
				face.setYuushaFace(3);
				startIng("용사");
				startIng("살라만다");
				startIng("살라만다");
				face.setYuushaFace(4);
				startIng("용사");
				startIng("살라만다");
				face.setYuushaFace(3);
				startIng("용사");
				startIng("살라만다");
				face.setYuushaFace(6);
				startIng("용사");
				startIng("살라만다");
				face.setYuushaFace(4);
				startIng("용사");
				startIng("살라만다");
				bgmThread.start();
				yesOrNo("살라만다","용사");
				face.setYuushaFace(3);
				if(answer == 1) {
					startIng("용사");
				}
				startIng("살라만다");
				startIng("나레이션");
				
				if(YuushaStatus.getHp()<=0) {
					death();
					break;
				}
				miniGameAvoid("살라만다",1);
				endIng();
				Thread insane = new Thread(salamander, "광란의 파티");
				answerClickChoose = false;
				insane.start();
				salamander.setVisible(true);
				yuushaEndMove();
				salamander.setVisible(false);
				break;
			case 9://script 25EA
				// TODO St9
				bgmThread.start();
				face.setYuushaFace(3);
				firstIng("용사");
				startIng("연화");
				nickName[0].setPosition(700,195,160,30);
				nickName[0].setMoveOpaque("src\\Source\\GUI\\Name\\연화\\", ".png", -2, 50);
				Thread nickSa3 = new Thread(nickName[0], "연화");
				nickSa3.start();
				face.setYuushaFace(1);
				startIng("용사");
				startIng("연화");
				face.setYuushaFace(3);
				startIng("용사");
				
				startIng("연화");
				face.setYuushaFace(2);
				startIng("용사");
				startIng("연화");
				face.setYuushaFace(3);
				startIng("용사");
				startIng("연화");
				
				startIng("용사");
				startIng("연화");
				startIng("용사");
				startIng("연화");
				startIng("연화");
				
				flash();
				face.setYuushaFace(6);
				startIng("용사");
				startIng("연화");
				startIng("연화");
				face.setYuushaFace(3);
				yesOrNoDouble("연화","연화","나레이션");
				if(answer == 1) {
					startIng("연화");
					startIng("나레이션");
				}else {
				}
				
				miniGameDDR("연화",3,5);
				face.setYuushaFace(3);
				startIng("용사");
				startIng("나레이션");
				miniGameDDR("연화",3,10);
				endIng();
				panelCh1=new superOfImg(420,250,148,198,"src\\Source\\Character\\사천왕_3_normal.png");
				panelCh1.setVisible(true);
				yuushaEndMove();
				panelCh1.setVisible(false);
				break;
			case 10://script 36EA
				// TODO St10
				bgmThread.start();
				nickName[0].setPosition(700,195,160,30);
				nickName[0].setMoveOpaque("src\\Source\\GUI\\Name\\로드\\", ".png", -2, 50);
				Thread nickSa4 = new Thread(nickName[0], "로드");
				nickSa4.start();
				if(YuushaStatus.getTime()>500) {
					firstIng("로드");
					endIng();
					stage = 11;
					break;
				}else if(YuushaStatus.getTime()>400) {
					script=2;
					firstIng("로드");
				}else {
					script=3;
					firstIng("로드");
				}
				
				if(script >= 3) {
//					startIng("로드");
//					startIng("로드");
					face.setYuushaFace(3);
					startIng("용사");
					startIng("용사");
					
					face.setYuushaFace(4);
					startIng("용사");
					startIng("로드");
					face.setYuushaFace(5);
					startIng("용사");
					startIng("로드");
					face.setYuushaFace(3);
					startIng("용사");
					startIng("로드");
				}
				script = 11;
				startIng("로드");
				yesOrNoDouble("로드","로드","나레이션");
				if(answer == 1) {
					startIng("로드");
					startIng("나레이션");
				}
				script = 17;
				
				this.nowName = "로드";
				//str = 다음에 이야기 할 캐릭터 이름...
				script++;
				while(scriptIng) {
					try {
						Thread.sleep(500);
					}catch(InterruptedException e) {
						
					}
				}
				scriptIng=false;
//				if(answer == 0)
//					script++;
				startIng("로드");
				script = 18;
				{
				if(nowName.equals("용사"))
					talking=true;
				else
					talking=false;
				scriptContents.setImg(stage,script);
				talkingBox.setImg(talking);
				face.setImg(nowName);
				name.setName(nowName);
				
				}
				scriptContents.addMouseListener(scriptContentsListener);
				
				
				
				mondai();
				mondai();
				mondai();
				
				mondai();
				mondai();
				mondai();
				mondai();
				mondai();
				
				mondai();
				mondai();
				mondai();
				mondai();
				mondai();
				
				mondai();
				mondai();
//				mondai();
				startIng("로드");
				face.setYuushaFace(3);
				startIng("용사");
				
				startIng("로드");
				endIng();
				panelCh1=new superOfImg(650,320,182,182,"src\\Source\\Character\\사천왕_4_normal.png");
				panelCh1.setVisible(true);
				yuushaEndMove();
				panelCh1.setVisible(false);
				break;
			case 11://script 20EA
				// TODO Auto-generated method stub
				
				nickName[0].setPosition(700,195,160,30);
				nickName[0].setMoveOpaque("src\\Source\\GUI\\Name\\카를\\카를", ".png", -2, 50);
				Thread nickKa = new Thread(nickName[0], "카를");
				nickKa.start();
				face.setKarlFace(1);
				firstIng("카를");
				face.setYuushaFace(5);
				startIng("용사");
				face.setKarlFace(5);
				if(YuushaStatus.getTime()>500) {
					startIng("카를");
					face.setYuushaFace(3);
					startIng("용사");
					face.setKarlFace(1);
					startIng("카를");
					endIng();
					break;
				}
				script=5;
				face.setKarlFace(5);
				startIng("카를");
				face.setYuushaFace(5);
				startIng("용사");
				startIng("카를");
				startIng("용사");
				face.setKarlFace(4);
				startIng("카를");
				
				face.setKarlFace(3);
				startIng("카를");
				bgmThread.start();
				startIng("용사");
				startIng("나레이션");
				face.setKarlFace(2);
				miniGame("카를",5);
//				face.setKarlFace(2);
//				startIng("카를");
				startIng("용사");
				flash();
				face.setYuushaFace(6);
				startIng("용사");
				startIng("로드");
				startIng("카를");
				startIng("로드");
				face.setYuushaFace(3);
				startIng("용사");
				endIng();
				panelCh1=new superOfImg(500,320,182,182,"src\\Source\\Character\\사천왕_4_normal.png");
				panelCh1.setVisible(true);
				panelCh2=new superOfImg(570,310,132,182,"src\\Source\\Character\\마왕_hit.png");
				panelCh2.setVisible(true);
				yuushaEndMove();
				panelCh1.setVisible(false);
				panelCh2.setVisible(false);
				break;
			case 12://script 3개
				System.out.println(YuushaStatus.getTime());
				// TODO Auto-generated method stub
				bgmThread.start();
				firstIng("용사");
				startIng("공주");
				startIng("용사");
				scriptContents.removeMouseListener(scriptContentsListener);
				YesOrNo ynn = new YesOrNo(1,script, this.getX(), this.getY());
				Thread ynnSel = new Thread(ynn, "선택창...");
				ynnSel.start();
				answerClickChoose=false;
				while(!answerClickChoose) {
					try {
						Thread.sleep(500);
					}catch(InterruptedException e) {
					}
				}
				if(answer == 0) {
					YuushaStatus.setPrincessLive(true);
				}else {
					YuushaStatus.setPrincessLive(false);
				}
				
				ynn.setVisible(false);
				endIng();
				break;
			case 13:
				System.out.println(YuushaStatus.getTime());
				System.out.println(YuushaStatus.isPrincessLive());
				hp.setVisible(false);
				hpTong.setVisible(false);
				potion.setVisible(false);
				bgmThread.start();
				skipNext.setImg("src\\Source\\GUI\\다음-1.png");
				st1startpressed=true;
				// TODO Auto-generated method stub
				st1WB.setVisible(true);
				if(YuushaStatus.isPrincessLive()) {
					if(YuushaStatus.getTime()>500) {
						scriptContents.addMouseListener(scriptContentsListener);
						st1WB.setImg("src\\Source\\Script\\St13\\엔딩2.png");
						st1WB.setBounds(0,-10,960,300);
						scriptContents.setVisible(true);
						scriptContents.setImg("src\\Source\\Script\\St13\\대사1.png");
						while(scriptIng) {
							try {
								Thread.sleep(300);
							}catch(InterruptedException e) {
								
							}
						}
						script = 2;
						scriptContents.setImg("src\\Source\\Script\\St13\\대사2.png");
						scriptContents.removeMouseListener(scriptContentsListener);
						scriptContents.removeMouseListener(scriptMunjae);
						skipNext.setVisible(true);
						while(st1startpressed) {
							try {
								Thread.sleep(300);
							}catch(InterruptedException e) {

							}
						}
					}else {
						ms.setVisible(true);
						Thread msThread = new Thread(ms,"진엔딩");
						msThread.start();
						scriptContents.removeMouseListener(scriptContentsListener);
						scriptContents.removeMouseListener(scriptMunjae);
						st1FB.setVisible(true);
						st1WB.setBounds(0,-10,960,560);
						st1FB.setBounds(480, -10, 417, 560);
						st1FB.setImg("src\\Source\\BackGround\\엔딩1-1.png");
						st1WB.moveOpaqueReverse("src\\Source\\BackGround\\배경흑잔상\\", ".png", 0, 50);
						wait(60,50);
						st1WB.moveOpaque("src\\Source\\BackGround\\배경흑잔상\\", ".png", 0, 50);
						st1FB.setImg("src\\Source\\BackGround\\엔딩1-2.png");
						wait(30,50);
						st1WB.moveOpaqueReverse("src\\Source\\BackGround\\배경흑잔상\\", ".png", 0, 50);
						wait(60,50);
						st1WB.moveOpaque("src\\Source\\BackGround\\배경흑잔상\\", ".png", 0, 50);
						wait(30,50);
						scriptIng = true;
						skipNext.setVisible(true);
						while(scriptIng) {
							script=(int)(Math.random()*11+1);
							switch(script) {
							case 1:
								st1FB.setBounds(650, 170, 165, 165);
								st1FB.setImg("src\\Source\\Character\\주인공_normal_1.png");
								break;
							case 2:
								st1FB.setBounds(650, 170, 138, 182);
								st1FB.setImg("src\\Source\\Character\\마왕_normal.png");
								break;
							case 3:
								st1FB.setBounds(650, 170, 138, 182);
								st1FB.setImg("src\\Source\\Character\\사천왕_1_normal.png");
								break;
							case 4:
								st1FB.setBounds(650, 170, 138, 182);
								st1FB.setImg("src\\Source\\Character\\사천왕_2_normal.png");
								break;
							case 5:
								st1FB.setBounds(650, 170, 149, 198);
								st1FB.setImg("src\\Source\\Character\\사천왕_3_normal.png");
								break;
							case 6:
								st1FB.setBounds(650, 170, 182, 182);
								st1FB.setImg("src\\Source\\Character\\사천왕_4_normal.png");
								break;
							case 7:
								st1FB.setBounds(650, 170, 99, 73);
								st1FB.setImg("src\\Source\\Character\\슬라임_1_normal.png");
								break;
							case 8:
								st1FB.setBounds(650, 170, 99, 73);
								st1FB.setImg("src\\Source\\Character\\슬라임_2_normal.png");
								break;
							case 9:
								st1FB.setBounds(650, 170, 99, 73);
								st1FB.setImg("src\\Source\\Character\\슬라임_3_normal.png");
								break;
							case 10:
								st1FB.setBounds(650, 170, 99, 73);
								st1FB.setImg("src\\Source\\Character\\슬라임_4_normal.png");
								break;
							case 11:
								st1FB.setBounds(650, 170, 99, 73);
								st1FB.setImg("src\\Source\\Character\\슬라임_5_normal.png");
								break;
							}
							
							st1WB.moveOpaqueReverse("src\\Source\\BackGround\\배경흑잔상\\", ".png", 0, 50);
							wait(60,50);
							st1WB.moveOpaque("src\\Source\\BackGround\\배경흑잔상\\", ".png", 0, 50);
							wait(30,50);
						}
					}
				}else {
					scriptContents.addMouseListener(scriptContentsListener);
					st1WB.setImg("src\\Source\\Script\\St13\\엔딩3.png");
					st1WB.setBounds(0,-10,960,300);
					scriptContents.setVisible(true);
					scriptContents.setImg("src\\Source\\Script\\St13\\대사3.png");
					script = 4;
					scriptIng=true;
					while(scriptIng) {
						try {
							Thread.sleep(300);
						}catch(InterruptedException e) {
							
						}
					}
					skipNext.setVisible(true);
					scriptContents.setImg("src\\Source\\Script\\St13\\대사4.png");
					scriptContents.removeMouseListener(scriptContentsListener);
					scriptContents.removeMouseListener(scriptMunjae);
					while(st1startpressed) {
						try {
							Thread.sleep(300);
						}catch(InterruptedException e) {
							
						}
					}
				}
				scriptContents.removeMouseListener(scriptContentsListener);
				skipNext.setVisible(false);
				scriptContents.setVisible(false);
				st1FB.setVisible(false);
				st1WB.setVisible(false);
				st1Yuusha.setBounds(653, -10, 500, 560);
				st1Slime.setBounds(-48, 143, 398, 560);
				st1startpressed=true;
				script = 1;
				stage = 1;
				break;
			case 14:
				bgmThread.start();
				tStgBtn.setVisible(true);
				rtnBtn.setVisible(true);
				// TODO Auto-generated method stub
				while(st1startpressed) {
					try {
						Thread.sleep(300);
					}catch(InterruptedException e) {
						
					}
				}
				st1startpressed=true;
				script = 1;
				tStgBtn.setVisible(false);
				rtnBtn.setVisible(false);
			}
			
			st1start.setImg(" ");
			st1Yuusha.setImg(" ");
			st1Slime.setImg(" ");
			st1FB.setImg(" ");
			st1WB.setImg(" ");
			st1Tuto.setImg(" ");
			skipNext.setImg(" ");
			skipNext.setBounds(700, 420, 157, 49);
			st1FB.setBounds(0, -10, 960, 560);
			st1WB.setBounds(0, -10, 960, 560);
			if(YuushaStatus.getHp()<=0) {
				stage = 14;
			}else {
			}
			BGMIng = true;
			BGM.clip.stop();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main main = new Main();
		Thread thread = new Thread(main,"Main");
		thread.start();
	}

	
	public void firstIng(String str) {
		//TODO firstIng
		
		YuushaStatus.setStageHp(YuushaStatus.getHp());
		YuushaStatus.setStageMaxHp(YuushaStatus.getStageHp());
		YuushaStatus.setStage(YuushaStatus.getStage());
		time = System.currentTimeMillis();
		hpIng = true;
		nowName = str;
		if(nowName.equals("용사"))
			talking=true;
		else
			talking=false;
		name.setName(nowName);
		face.setImg(nowName);
		scriptContents.setImg(stage,script);
		talkingBox.setImg(talking);
		scriptContents.setVisible(true);
		talkingBox.setVisible(true);
		name.setVisible(true);
		face.setVisible(true);
		hp.setVisible(true);
		hpTong.setVisible(true);
		potion.setVisible(true);
		scriptContents.addMouseListener(scriptContentsListener);
		scriptIng=true;
		BGMIng = true;
	}
	public void startIng(String name) {
		//TODO startIng
		script++;
		this.nowName = name;
		try {
			while(scriptIng) {
				Thread.sleep(300);
			}
		}catch(InterruptedException e) {
			
		}
		scriptIng=true;
	}
	public void endIng(){
		//TODO endIng
		scriptIng = true;
		try {
			while(scriptIng) {
				Thread.sleep(300);
				if(YuushaStatus.getHp()<=0)
					break;
			}
		}catch(InterruptedException e) {
			
		}
		scriptContents.setVisible(false);
		talkingBox.setVisible(false);
		name.setVisible(false);
		face.setVisible(false);
		yuusha.setVisible(false);
		
		scriptContents.removeMouseListener(scriptContentsListener);
		YuushaStatus.setTime(YuushaStatus.getTime()+(int)((System.currentTimeMillis()-time)/1000));
		time = 0;
		BGMIng = false;
		script=1;
		stage++;
		
	}
	
	private void yesOrNoKing(String str) {
		//str = 다음에 이야기 할 캐릭터 이름...
		YesOrNo ynn;
		scriptContents.removeMouseListener(scriptContentsListener);
		while(!(Main.answer == 0)) {
			ynn = new YesOrNo(0,script,this.getX(),this.getY());
			Thread ynnSel = new Thread(ynn, "선택창...");
			ynnSel.start();
			answerClickChoose=false;
			while(!Main.answerClickChoose) {
				try {
					Thread.sleep(500);
				}catch(InterruptedException e) {
					
				}
			}
			scriptIng=false;
			if(answer == 0)
				script++;
			startIng(str);
			{
			if(nowName.equals("용사"))
				talking=true;
			else
				talking=false;
			scriptContents.setImg(stage,script);
			talkingBox.setImg(talking);
			face.setImg(nowName);
			name.setName(nowName);
			scriptIng=false;
			}
			script--;
		}
		scriptContents.addMouseListener(scriptContentsListener);
	}
	private void yesOrNo(String str, String next) {
//		scriptIng=false;
		this.nowName = str;
		face.setImg(nowName);
		//str = 다음에 이야기 할 캐릭터 이름...
		scriptContents.removeMouseListener(scriptContentsListener);
		YesOrNo ynn = new YesOrNo(0,script,this.getX(),this.getY());
		Thread ynnSel = new Thread(ynn, "선택창...");
		ynnSel.start();
		answerClickChoose=false;
		while(!Main.answerClickChoose) {
			try {
				Thread.sleep(500);
			}catch(InterruptedException e) {
				
			}
		}
		scriptIng=false;
		startIng(str);
		if(answer == 0) {
			nowName = next;
			script++;
		}
		{
		if(nowName.equals("용사"))
			talking=true;
		else
			talking=false;
		scriptContents.setImg(stage,script);
		talkingBox.setImg(talking);
		face.setImg(nowName);
		name.setName(nowName);
		
		}
		scriptContents.addMouseListener(scriptContentsListener);
		ynn.setVisible(false);
		scriptIng = true;
	}
	public void yesOrNoDouble(String str, String next,String second) {
		this.nowName = str;
		//str = 다음에 이야기 할 캐릭터 이름...
		scriptContents.removeMouseListener(scriptContentsListener);
		YesOrNo ynn = new YesOrNo(0,script,this.getX(),this.getY());
		Thread ynnSel = new Thread(ynn, "선택창...");
		ynnSel.start();
		answerClickChoose=false;
		while(!Main.answerClickChoose) {
			try {
				Thread.sleep(500);
			}catch(InterruptedException e) {
				
			}
		}
		scriptIng=false;
		startIng(str);
		if(answer == 0) {
			nowName = second;
			script++;
			script++;
		}else{
			nowName = next;
		}
		{
		if(nowName.equals("용사"))
			talking=true;
		else
			talking=false;
		scriptContents.setImg(stage,script);
		talkingBox.setImg(talking);
		face.setImg(nowName);
		name.setName(nowName);
		
		}
		scriptContents.addMouseListener(scriptContentsListener);
		ynn.setVisible(false);
		scriptIng = true;
	}
	public void mondai() {
		
		nowName = "로드";
		scriptContents.removeMouseListener(scriptContentsListener);
		YesOrNo ynn = new YesOrNo(2,script,this.getX(),this.getY());
		Thread ynnSel = new Thread(ynn, "선택창...");
		ynnSel.start();
		answerClickChoose=false;
		while(!Main.answerClickChoose) {
			try {
				Thread.sleep(500);
			}catch(InterruptedException e) {
				
			}
		}
		scriptContents.addMouseListener(scriptMunjae);
		if(YesOrNo.munjae()) {
			scriptContents.setImg(stage,16);
		}else {
			scriptContents.setImg(stage,17);
		}
		while(scriptIng) {
			try {
				Thread.sleep(500);
			}catch(InterruptedException e) {
				
			}
		}
		
		scriptContents.removeMouseListener(scriptMunjae);
		
		scriptIng=false;
		
		startIng("로드");
		{
		if(nowName.equals("용사"))
			talking=true;
		else
			talking=false;
		scriptContents.setImg(stage,script);
		talkingBox.setImg(talking);
		face.setImg(nowName);
		name.setName(nowName);
		
		}
		scriptContents.addMouseListener(scriptContentsListener);
		ynn.setVisible(false);
		scriptIng = true;
	}

	
	
	public void wait(int times,int sleepTime) {
		try {
			for(int i = 0; i<times;i++) {
				Thread.sleep(sleepTime);
			}
		}catch(InterruptedException e) {
		}
	}

	

	@Override
	public void keyPressed(KeyEvent e) {
		if(move&&movePress) {
			yuushaMove.interrupt();
			movePress=false;
			YuushaStatus.setCondition(e.getKeyCode());
		}
	}

	
	public void yuushaEndMove() {
		yuusha.setBounds(100,yuusha.getY(),yuusha.getWidth(),yuusha.getHeight());
		portal.setVisible(true);
		Thread portalthread = new Thread(portal,"포탈");
		
		
		Thread hpCh = new Thread(hp, "체력바");
		Thread hpTongCh = new Thread(hpTong, "체통");
		hpCh.start();
		hpTongCh.start();
		scriptIng=true;
		
		scriptContents.setVisible(false);
		talkingBox.setVisible(false);
		name.setVisible(false);
		face.setVisible(false);
		scriptContents.removeMouseListener(scriptContentsListener);
		yuusha.setVisible(true);
		yuushaMove = new Thread(yuusha, "용사 무빙");
		addKeyListener(this);
		move = true;
		yuushaMove.start();
		answerClickChoose=false;
		portalthread.start();
		
		while(!answerClickChoose) {
			try {
				if(YuushaStatus.getCondition()==38&&portal.getX()-yuusha.getX()<100) {
					YuushaStatus.setCondition(0);
					answerClickChoose=true;
					move = false;
					break;
				}
				Thread.sleep(300);
			}catch(InterruptedException e) {
				
			}
		}
		hpIng = false;
		move = true;
		hp.setVisible(false);
		hpTong.setVisible(false);
		potion.setVisible(false);
		scriptContents.addMouseListener(scriptContentsListener);
		scriptContents.setVisible(true);
		talkingBox.setVisible(true);
		name.setVisible(true);
		face.setVisible(true);
		yuusha.setVisible(false);
		portal.setVisible(false);
		
	}
	public void death() {
		scriptIng = true;
		scriptContents.setVisible(false);
		talkingBox.setVisible(false);
		name.setVisible(false);
		face.setVisible(false);
		yuusha.setVisible(false);
		hp.setVisible(false);
		hpTong.setVisible(false);
		potion.setVisible(false);
		scriptContents.removeMouseListener(scriptContentsListener);
		
		script = 1;
		stage = 14;
		
	}
	public void miniGame(String name, int yuushaFace) {
		terminate=new TerminateGame(stage,getX(),getY());
		Thread miniGame1 = new Thread(terminate,"적 퇴치 미니게임");
		miniGame1.start();
		answerClickChoose=false;
		try {
			while(!answerClickChoose) {
				Thread.sleep(300);
			}
		}catch(InterruptedException e) {
			
		}
		
		script++;
		face.setYuushaFace(yuushaFace);
		nowName=name;
		if(nowName.equals("용사"))
			talking=true;
		else
			talking=false;
		scriptContents.setImg(stage,script);
		talkingBox.setImg(talking);
		face.setImg(nowName);
		this.name.setName(nowName);
		scriptIng=true;
		
	}
	
	public void miniGameDoor(String name, int yuushaFace, int num) {
		//TODO 미니게임
		doorLock = new KeyPadGame(num,getX(),getY());
		Thread miniGame2 = new Thread(doorLock,"도어락 미니게임");
		miniGame2.start();
		answerClickChoose=false;
		try {
			while(!answerClickChoose) {
				Thread.sleep(300);
			}
		}catch(InterruptedException e) {
			
		}
		script++;
		face.setYuushaFace(yuushaFace);
		nowName=name;
		if(nowName.equals("용사"))
			talking=true;
		else
			talking=false;
		scriptContents.setImg(stage,script);
		talkingBox.setImg(talking);
		face.setImg(nowName);
		this.name.setName(nowName);
		scriptIng=true;
		
		
	}
	
	public void miniGameDDR(String name, int yuushaFace, int count) {
		ddr = new DDRGame(count, getX(),getY());
		Thread miniGame4 = new Thread(ddr,"댄스타임!");
		miniGame4.start();
		answerClickChoose=false;
		try {
			while(!answerClickChoose) {
				Thread.sleep(300);
			}
		}catch(InterruptedException e) {
			
		}
		
		script++;
		face.setYuushaFace(yuushaFace);
		nowName=name;
		if(nowName.equals("용사"))
			talking=true;
		else
			talking=false;
		scriptContents.setImg(stage,script);
		talkingBox.setImg(talking);
		face.setImg(nowName);
		this.name.setName(nowName);
		scriptIng=true;
		
		
	}
	private void miniGameAvoid(String name, int yuushaFace) {
		avoidEgg = new AvoidGame(getX(),getY());
		Thread miniGame3 = new Thread(avoidEgg,"알피하기");
		miniGame3.start();
		answerClickChoose=false;
		try {
			while(!answerClickChoose) {
				Thread.sleep(300);
			}
		}catch(InterruptedException e) {
			
		}
		
		script++;
		face.setYuushaFace(yuushaFace);
		nowName=name;
		if(nowName.equals("용사"))
			talking=true;
		else
			talking=false;
		scriptContents.setImg(stage,script);
		talkingBox.setImg(talking);
		face.setImg(nowName);
		this.name.setName(nowName);
		scriptIng=true;
		
	}
	private void flash() {
		for(int i = 1;i<=2;i++) {
			try {
				Thread.sleep(300);
				st1WB.setVisible(true);
				st1WB.setImg("src\\Source\\BackGround\\배경_백.png");
			}catch(InterruptedException e) {
				
			}
			if(i == 1)
				effect("Sword Fast Unsheath by ethanchase7744 Id-468695-2");
			try {
				Thread.sleep(300);
			}catch(InterruptedException e) {
				
			}
			st1WB.setVisible(false);
		}
	}

	public static void effect(String name) {
		Sound sound = new Sound(name);
		Thread soundEffect = new Thread(sound, "배경음악");
		soundEffect.start();
	}
	
	
	
	
	
	
	
	
	
	
	//TODO 여기서부터 gettersetter
	public static void setScriptIng(boolean scriptIng) {
		Main.scriptIng = scriptIng;
	}

	public static void setAnswer(int answer) {
		Main.answer = answer;
	}

	public static boolean isAnswerClickChoose() {
		return answerClickChoose;
	}

	public static void setAnswerClickChoose(boolean answerClickChoose) {
		Main.answerClickChoose = answerClickChoose;
	}
	public static boolean isBGMIng() {
		return Main.BGMIng;
	}

	public static void setBGMIng(boolean bGMIng) {
		Main.BGMIng = bGMIng;
	}
	
	
	
	public static int getStage() {
		return stage;
	}

	public static void setStage(int stage) {
		Main.stage = stage;
	}
	
	public static int getScript() {
		return script;
	}

	public static boolean isTalking() {
		return talking;
	}

	public static void setTalking(boolean talking) {
		Main.talking = talking;
	}

	public static void setScript(int script) {
		Main.script = script;
	}

	public static void setSt1startpressed(boolean st1startpressed) {
		Main.st1startpressed = st1startpressed;
	}
	
	public String getNowName() {
		return nowName;
	}
	@Override
	public void keyReleased(KeyEvent e) {
		movePress=true;
	}

	public static boolean isMove() {
		return Main.move;
	}

	public static void setMove(boolean move) {
		Main.move = move;
	}

	public static Yuusha getYuusha() {
		return yuusha;
	}

	public static void setYuusha(Yuusha yuusha) {
		Main.yuusha = yuusha;
	}

	public static boolean isMovePress() {
		return movePress;
	}

	public static void setMovePress(boolean movePress) {
		Main.movePress = movePress;
	}
	public static boolean isSt1startpressed() {
		return st1startpressed;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	public static int getAnswer() {
		return answer;
	}

	public static boolean isHpIng() {
		return hpIng;
	}

	public static void setHpIng(boolean hpIng) {
		Main.hpIng = hpIng;
	}
	
}


