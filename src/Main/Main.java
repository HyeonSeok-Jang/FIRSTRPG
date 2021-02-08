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
	private static boolean scriptIng = true; //true���� ������ �ݺ����� �����ؼ� ��ũ��Ʈ �� �������� �ʰ� �ϴ� �뵵
	private static boolean talking = true;//GUI ��ȭâ �¿���� ȿ�� �����ϴ°���...
	private static int answer = -1;
	private static int script = 1;
	private static int stage = 1;
	private static String nowName = "��";
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
			if(nowName.equals("���"))
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
			if(nowName.equals("���"))
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
		setTitle("������ ���� ���� ���ϱ�");
		setSize(975,560);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setIconImage(img);
		rtnBtn.setImg("src\\Source\\GUI\\ó������-1.png");
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
					skipNext.setImg("src\\Source\\GUI\\��ŵ-2.png");
				}else {
					skipNext.setImg("src\\Source\\GUI\\����-2.png");
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
		tStgBtn.setImg("src\\Source\\GUI\\�̹��������� �ٽ��ϱ�.png");
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
		
		
		//TODO ����
		//�̹��� ������ ������ ����� �ٲ��� �� ��.
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
			Thread bgmThread = new Thread(bgm, "�������");
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
				st1Yuusha.moveOpaque("src\\Source\\BackGround\\GIF\\����ȭ��-���", ".png", -3, 50);
				st1Slime.moveOpaque("src\\Source\\BackGround\\GIF_SLIME\\����ȭ��-������", ".png", 2, 50);
				for(int i = 2;i<=4;i++) {
					try {
						Thread.sleep(300);
						st1WB.setVisible(true);
						st1WB.setImg("src\\Source\\BackGround\\���_��.png");
					}catch(InterruptedException e) {
						
					}
					if(i!=4)
						effect("Swords Clash   High Quality #2 by Christopherderp Id-364530-1");
					else
						effect("Sword Fast Unsheath by ethanchase7744 Id-468695-2");
					try {
						Thread.sleep(300);
						st1FB.setImg("src\\Source\\BackGround\\����ȭ��-"+i+".png");
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
				st1Tuto.setImg("src\\Source\\BackGround\\����ȭ��-5.png");
				skipNext.setImg("src\\Source\\GUI\\����-1.png");
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
				st1WB.setImg("src\\Source\\BackGround\\��Ʈ��-1.png");
				st1WB.setBounds(0,-10,960,300);
				st1FB.setImg("src\\Source\\Script\\��Ʈ��.png");
				st1FB.setBounds(104, 550, 753, 497);
				skipNext.setBounds(700, 50, 157, 49);
				sk = true;
				skipNext.setImg("src\\Source\\GUI\\��ŵ-1.png");
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
					skipNext.setImg("src\\Source\\GUI\\����-1.png");
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
				nickName[0].setMoveOpaque("src\\Source\\GUI\\Name\\��\\", ".png", -2, 50);
				Thread nickKing = new Thread(nickName[0], "�� �г���");
				nickKing.start();
				firstIng("��");
				startIng("��");
				startIng("��");
				startIng("��");
				this.yesOrNoKing("��");
				startIng("��");
				yesOrNo("��","��");
				if(answer == 1)
					startIng("��");
				yesOrNo("��","��");
				if(answer == 1)
					startIng("��");
				yesOrNo("��","��");
				if(answer == 1)
					startIng("��");
				yesOrNo("��","��");
				if(answer == 1)
					startIng("��");
				yesOrNo("��","��");
				if(answer == 1) {
					startIng("��");
				}
				endIng();
				break;
			case 4://script 9EA
				// TODO St4
				bgmThread.start();
				nickName[0].setPosition(700,195,160,30);
				nickName[0].setMoveOpaque("src\\Source\\GUI\\Name\\������\\", ".png", -2, 50);
				Thread nickSlime1 = new Thread(nickName[0], "������");
				nickSlime1.start();
				firstIng("������");
				startIng("������");
				nickName[1].setPosition(600,145,160,30);
				nickName[1].setMoveOpaque("src\\Source\\GUI\\Name\\������\\������", ".png", -2, 50);
				Thread nickSlime2 = new Thread(nickName[1], "������");
				nickSlime2.start();
				
				face.setYuushaFace(1);
				startIng("���");
				nickName[2].setPosition(190,195,180,30);
				nickName[2].setMoveOpaque("src\\Source\\GUI\\Name\\���\\", ".png", 2, 50);
				Thread nickYuusha = new Thread(nickName[2], "���");
				nickYuusha.start();
				startIng("������");
				startIng("������");
				
				startIng("������");
				startIng("������");
				startIng("�����̼�");
				
				miniGame("���",4);
				
				
				endIng();
				yuushaEndMove();
				break;
			case 5://script 10EA
				// TODO St5
				bgmThread.start();
				firstIng("�ѿ���");
				nickName[0].setPosition(700,195,160,30);
				nickName[0].setMoveOpaque("src\\Source\\GUI\\Name\\�ѿ���\\", ".png", -2, 50);
				Thread nickSlime3 = new Thread(nickName[0], "�ѿ���");
				nickSlime3.start();
				startIng("�޿���");
				nickName[1].setPosition(770,145,160,30);
				nickName[1].setMoveOpaque("src\\Source\\GUI\\Name\\�޿���\\�޿���", ".png", -2, 50);
				Thread nickSlime4 = new Thread(nickName[1], "�޿���");
				nickSlime4.start();
				face.setYuushaFace(2);
				startIng("���");
				startIng("�޿���");
				face.setYuushaFace(1);
				startIng("���");
				
				startIng("�˵���");
				nickName[2].setPosition(840,195,160,30);
				nickName[2].setMoveOpaque("src\\Source\\GUI\\Name\\�˵���\\�˵���", ".png", -2, 50);
				Thread nickSlime5 = new Thread(nickName[2], "�˵���");
				nickSlime5.start();
				startIng("�ѿ���");
				startIng("�޿���");
				startIng("�����̼�");
				miniGame("���",4);
				endIng();
				yuushaEndMove();
				break;
			case 6://script 2EA
				// TODO St6
				bgmThread.start();
				face.setYuushaFace(1);
				firstIng("���");
				startIng("�����̼�");
				endIng();
				yuushaEndMove();
				break;
			case 7://script 18EA
				// TODO St7
				bgmThread.start();
				firstIng("���");
				face.setYuushaFace(5);
				startIng("���");
				startIng("��Ʈ�ѷ�");
				nickName[0].setPosition(700,195,160,30);
				nickName[0].setMoveOpaque("src\\Source\\GUI\\Name\\��Ʈ�ѷ�\\��Ʈ�ѷ�", ".png", -2, 50);
				Thread nickSa1 = new Thread(nickName[0], "��Ʈ�ѷ�");
				nickSa1.start();
				face.setYuushaFace(5);
				startIng("���");
				startIng("��Ʈ�ѷ�");
				
				face.setYuushaFace(3);
				startIng("���");
				startIng("��Ʈ�ѷ�");
				startIng("��Ʈ�ѷ�");
				face.setYuushaFace(4);
				startIng("���");
				startIng("��Ʈ�ѷ�");
				yesOrNo("��Ʈ�ѷ�","��Ʈ�ѷ�");
				if(answer == 1)
					startIng("��Ʈ�ѷ�");
				startIng("�����̼�");
				miniGameDoor("���",3,1);
				startIng("��Ʈ�ѷ�");
				
				startIng("�����̼�");
				miniGameDoor("���",5,2);
				script = 17;
				startIng("��Ʈ�ѷ�");
				endIng();
				
				panelCh1.setImg("src\\Source\\Character\\��õ��_1_normal.png");
				panelCh1.setBounds(570,230,200,275);
				panelCh1.setVisible(true);
				yuushaEndMove();
				panelCh1.setVisible(false);
				break;
			case 8://script 29EA
				// TODO St8
				face.setYuushaFace(3);
				firstIng("���");
				face.setYuushaFace(4);
				effect("Eagle Owl by greither Id-115608");
				startIng("���");
				
				startIng("���");
				startIng("��󸸴�");
				face.setYuushaFace(1);
				startIng("���");
				
				startIng("��󸸴�");
				nickName[0].setPosition(700,195,160,30);
				nickName[0].setMoveOpaque("src\\Source\\GUI\\Name\\��󸸴�\\", ".png", -2, 50);
				startIng("���");
				startIng("��󸸴�");
				startIng("��󸸴�");
				face.setYuushaFace(3);
				startIng("���");
				flash();
				startIng("��󸸴�");
				face.setYuushaFace(6);
				startIng("���");
				startIng("��󸸴�");
				face.setYuushaFace(3);
				startIng("���");
				startIng("��󸸴�");
				startIng("��󸸴�");
				face.setYuushaFace(4);
				startIng("���");
				startIng("��󸸴�");
				face.setYuushaFace(3);
				startIng("���");
				startIng("��󸸴�");
				face.setYuushaFace(6);
				startIng("���");
				startIng("��󸸴�");
				face.setYuushaFace(4);
				startIng("���");
				startIng("��󸸴�");
				bgmThread.start();
				yesOrNo("��󸸴�","���");
				face.setYuushaFace(3);
				if(answer == 1) {
					startIng("���");
				}
				startIng("��󸸴�");
				startIng("�����̼�");
				
				if(YuushaStatus.getHp()<=0) {
					death();
					break;
				}
				miniGameAvoid("��󸸴�",1);
				endIng();
				Thread insane = new Thread(salamander, "������ ��Ƽ");
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
				firstIng("���");
				startIng("��ȭ");
				nickName[0].setPosition(700,195,160,30);
				nickName[0].setMoveOpaque("src\\Source\\GUI\\Name\\��ȭ\\", ".png", -2, 50);
				Thread nickSa3 = new Thread(nickName[0], "��ȭ");
				nickSa3.start();
				face.setYuushaFace(1);
				startIng("���");
				startIng("��ȭ");
				face.setYuushaFace(3);
				startIng("���");
				
				startIng("��ȭ");
				face.setYuushaFace(2);
				startIng("���");
				startIng("��ȭ");
				face.setYuushaFace(3);
				startIng("���");
				startIng("��ȭ");
				
				startIng("���");
				startIng("��ȭ");
				startIng("���");
				startIng("��ȭ");
				startIng("��ȭ");
				
				flash();
				face.setYuushaFace(6);
				startIng("���");
				startIng("��ȭ");
				startIng("��ȭ");
				face.setYuushaFace(3);
				yesOrNoDouble("��ȭ","��ȭ","�����̼�");
				if(answer == 1) {
					startIng("��ȭ");
					startIng("�����̼�");
				}else {
				}
				
				miniGameDDR("��ȭ",3,5);
				face.setYuushaFace(3);
				startIng("���");
				startIng("�����̼�");
				miniGameDDR("��ȭ",3,10);
				endIng();
				panelCh1=new superOfImg(420,250,148,198,"src\\Source\\Character\\��õ��_3_normal.png");
				panelCh1.setVisible(true);
				yuushaEndMove();
				panelCh1.setVisible(false);
				break;
			case 10://script 36EA
				// TODO St10
				bgmThread.start();
				nickName[0].setPosition(700,195,160,30);
				nickName[0].setMoveOpaque("src\\Source\\GUI\\Name\\�ε�\\", ".png", -2, 50);
				Thread nickSa4 = new Thread(nickName[0], "�ε�");
				nickSa4.start();
				if(YuushaStatus.getTime()>500) {
					firstIng("�ε�");
					endIng();
					stage = 11;
					break;
				}else if(YuushaStatus.getTime()>400) {
					script=2;
					firstIng("�ε�");
				}else {
					script=3;
					firstIng("�ε�");
				}
				
				if(script >= 3) {
//					startIng("�ε�");
//					startIng("�ε�");
					face.setYuushaFace(3);
					startIng("���");
					startIng("���");
					
					face.setYuushaFace(4);
					startIng("���");
					startIng("�ε�");
					face.setYuushaFace(5);
					startIng("���");
					startIng("�ε�");
					face.setYuushaFace(3);
					startIng("���");
					startIng("�ε�");
				}
				script = 11;
				startIng("�ε�");
				yesOrNoDouble("�ε�","�ε�","�����̼�");
				if(answer == 1) {
					startIng("�ε�");
					startIng("�����̼�");
				}
				script = 17;
				
				this.nowName = "�ε�";
				//str = ������ �̾߱� �� ĳ���� �̸�...
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
				startIng("�ε�");
				script = 18;
				{
				if(nowName.equals("���"))
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
				startIng("�ε�");
				face.setYuushaFace(3);
				startIng("���");
				
				startIng("�ε�");
				endIng();
				panelCh1=new superOfImg(650,320,182,182,"src\\Source\\Character\\��õ��_4_normal.png");
				panelCh1.setVisible(true);
				yuushaEndMove();
				panelCh1.setVisible(false);
				break;
			case 11://script 20EA
				// TODO Auto-generated method stub
				
				nickName[0].setPosition(700,195,160,30);
				nickName[0].setMoveOpaque("src\\Source\\GUI\\Name\\ī��\\ī��", ".png", -2, 50);
				Thread nickKa = new Thread(nickName[0], "ī��");
				nickKa.start();
				face.setKarlFace(1);
				firstIng("ī��");
				face.setYuushaFace(5);
				startIng("���");
				face.setKarlFace(5);
				if(YuushaStatus.getTime()>500) {
					startIng("ī��");
					face.setYuushaFace(3);
					startIng("���");
					face.setKarlFace(1);
					startIng("ī��");
					endIng();
					break;
				}
				script=5;
				face.setKarlFace(5);
				startIng("ī��");
				face.setYuushaFace(5);
				startIng("���");
				startIng("ī��");
				startIng("���");
				face.setKarlFace(4);
				startIng("ī��");
				
				face.setKarlFace(3);
				startIng("ī��");
				bgmThread.start();
				startIng("���");
				startIng("�����̼�");
				face.setKarlFace(2);
				miniGame("ī��",5);
//				face.setKarlFace(2);
//				startIng("ī��");
				startIng("���");
				flash();
				face.setYuushaFace(6);
				startIng("���");
				startIng("�ε�");
				startIng("ī��");
				startIng("�ε�");
				face.setYuushaFace(3);
				startIng("���");
				endIng();
				panelCh1=new superOfImg(500,320,182,182,"src\\Source\\Character\\��õ��_4_normal.png");
				panelCh1.setVisible(true);
				panelCh2=new superOfImg(570,310,132,182,"src\\Source\\Character\\����_hit.png");
				panelCh2.setVisible(true);
				yuushaEndMove();
				panelCh1.setVisible(false);
				panelCh2.setVisible(false);
				break;
			case 12://script 3��
				System.out.println(YuushaStatus.getTime());
				// TODO Auto-generated method stub
				bgmThread.start();
				firstIng("���");
				startIng("����");
				startIng("���");
				scriptContents.removeMouseListener(scriptContentsListener);
				YesOrNo ynn = new YesOrNo(1,script, this.getX(), this.getY());
				Thread ynnSel = new Thread(ynn, "����â...");
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
				skipNext.setImg("src\\Source\\GUI\\����-1.png");
				st1startpressed=true;
				// TODO Auto-generated method stub
				st1WB.setVisible(true);
				if(YuushaStatus.isPrincessLive()) {
					if(YuushaStatus.getTime()>500) {
						scriptContents.addMouseListener(scriptContentsListener);
						st1WB.setImg("src\\Source\\Script\\St13\\����2.png");
						st1WB.setBounds(0,-10,960,300);
						scriptContents.setVisible(true);
						scriptContents.setImg("src\\Source\\Script\\St13\\���1.png");
						while(scriptIng) {
							try {
								Thread.sleep(300);
							}catch(InterruptedException e) {
								
							}
						}
						script = 2;
						scriptContents.setImg("src\\Source\\Script\\St13\\���2.png");
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
						Thread msThread = new Thread(ms,"������");
						msThread.start();
						scriptContents.removeMouseListener(scriptContentsListener);
						scriptContents.removeMouseListener(scriptMunjae);
						st1FB.setVisible(true);
						st1WB.setBounds(0,-10,960,560);
						st1FB.setBounds(480, -10, 417, 560);
						st1FB.setImg("src\\Source\\BackGround\\����1-1.png");
						st1WB.moveOpaqueReverse("src\\Source\\BackGround\\������ܻ�\\", ".png", 0, 50);
						wait(60,50);
						st1WB.moveOpaque("src\\Source\\BackGround\\������ܻ�\\", ".png", 0, 50);
						st1FB.setImg("src\\Source\\BackGround\\����1-2.png");
						wait(30,50);
						st1WB.moveOpaqueReverse("src\\Source\\BackGround\\������ܻ�\\", ".png", 0, 50);
						wait(60,50);
						st1WB.moveOpaque("src\\Source\\BackGround\\������ܻ�\\", ".png", 0, 50);
						wait(30,50);
						scriptIng = true;
						skipNext.setVisible(true);
						while(scriptIng) {
							script=(int)(Math.random()*11+1);
							switch(script) {
							case 1:
								st1FB.setBounds(650, 170, 165, 165);
								st1FB.setImg("src\\Source\\Character\\���ΰ�_normal_1.png");
								break;
							case 2:
								st1FB.setBounds(650, 170, 138, 182);
								st1FB.setImg("src\\Source\\Character\\����_normal.png");
								break;
							case 3:
								st1FB.setBounds(650, 170, 138, 182);
								st1FB.setImg("src\\Source\\Character\\��õ��_1_normal.png");
								break;
							case 4:
								st1FB.setBounds(650, 170, 138, 182);
								st1FB.setImg("src\\Source\\Character\\��õ��_2_normal.png");
								break;
							case 5:
								st1FB.setBounds(650, 170, 149, 198);
								st1FB.setImg("src\\Source\\Character\\��õ��_3_normal.png");
								break;
							case 6:
								st1FB.setBounds(650, 170, 182, 182);
								st1FB.setImg("src\\Source\\Character\\��õ��_4_normal.png");
								break;
							case 7:
								st1FB.setBounds(650, 170, 99, 73);
								st1FB.setImg("src\\Source\\Character\\������_1_normal.png");
								break;
							case 8:
								st1FB.setBounds(650, 170, 99, 73);
								st1FB.setImg("src\\Source\\Character\\������_2_normal.png");
								break;
							case 9:
								st1FB.setBounds(650, 170, 99, 73);
								st1FB.setImg("src\\Source\\Character\\������_3_normal.png");
								break;
							case 10:
								st1FB.setBounds(650, 170, 99, 73);
								st1FB.setImg("src\\Source\\Character\\������_4_normal.png");
								break;
							case 11:
								st1FB.setBounds(650, 170, 99, 73);
								st1FB.setImg("src\\Source\\Character\\������_5_normal.png");
								break;
							}
							
							st1WB.moveOpaqueReverse("src\\Source\\BackGround\\������ܻ�\\", ".png", 0, 50);
							wait(60,50);
							st1WB.moveOpaque("src\\Source\\BackGround\\������ܻ�\\", ".png", 0, 50);
							wait(30,50);
						}
					}
				}else {
					scriptContents.addMouseListener(scriptContentsListener);
					st1WB.setImg("src\\Source\\Script\\St13\\����3.png");
					st1WB.setBounds(0,-10,960,300);
					scriptContents.setVisible(true);
					scriptContents.setImg("src\\Source\\Script\\St13\\���3.png");
					script = 4;
					scriptIng=true;
					while(scriptIng) {
						try {
							Thread.sleep(300);
						}catch(InterruptedException e) {
							
						}
					}
					skipNext.setVisible(true);
					scriptContents.setImg("src\\Source\\Script\\St13\\���4.png");
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
		if(nowName.equals("���"))
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
		//str = ������ �̾߱� �� ĳ���� �̸�...
		YesOrNo ynn;
		scriptContents.removeMouseListener(scriptContentsListener);
		while(!(Main.answer == 0)) {
			ynn = new YesOrNo(0,script,this.getX(),this.getY());
			Thread ynnSel = new Thread(ynn, "����â...");
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
			if(nowName.equals("���"))
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
		//str = ������ �̾߱� �� ĳ���� �̸�...
		scriptContents.removeMouseListener(scriptContentsListener);
		YesOrNo ynn = new YesOrNo(0,script,this.getX(),this.getY());
		Thread ynnSel = new Thread(ynn, "����â...");
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
		if(nowName.equals("���"))
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
		//str = ������ �̾߱� �� ĳ���� �̸�...
		scriptContents.removeMouseListener(scriptContentsListener);
		YesOrNo ynn = new YesOrNo(0,script,this.getX(),this.getY());
		Thread ynnSel = new Thread(ynn, "����â...");
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
		if(nowName.equals("���"))
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
		
		nowName = "�ε�";
		scriptContents.removeMouseListener(scriptContentsListener);
		YesOrNo ynn = new YesOrNo(2,script,this.getX(),this.getY());
		Thread ynnSel = new Thread(ynn, "����â...");
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
		
		startIng("�ε�");
		{
		if(nowName.equals("���"))
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
		Thread portalthread = new Thread(portal,"��Ż");
		
		
		Thread hpCh = new Thread(hp, "ü�¹�");
		Thread hpTongCh = new Thread(hpTong, "ü��");
		hpCh.start();
		hpTongCh.start();
		scriptIng=true;
		
		scriptContents.setVisible(false);
		talkingBox.setVisible(false);
		name.setVisible(false);
		face.setVisible(false);
		scriptContents.removeMouseListener(scriptContentsListener);
		yuusha.setVisible(true);
		yuushaMove = new Thread(yuusha, "��� ����");
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
		Thread miniGame1 = new Thread(terminate,"�� ��ġ �̴ϰ���");
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
		if(nowName.equals("���"))
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
		//TODO �̴ϰ���
		doorLock = new KeyPadGame(num,getX(),getY());
		Thread miniGame2 = new Thread(doorLock,"����� �̴ϰ���");
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
		if(nowName.equals("���"))
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
		Thread miniGame4 = new Thread(ddr,"��Ÿ��!");
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
		if(nowName.equals("���"))
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
		Thread miniGame3 = new Thread(avoidEgg,"�����ϱ�");
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
		if(nowName.equals("���"))
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
				st1WB.setImg("src\\Source\\BackGround\\���_��.png");
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
		Thread soundEffect = new Thread(sound, "�������");
		soundEffect.start();
	}
	
	
	
	
	
	
	
	
	
	
	//TODO ���⼭���� gettersetter
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


