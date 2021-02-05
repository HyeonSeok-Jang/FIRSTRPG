package Test;

public class BackUp {

}
/*//20210202, Main.Main
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
import GUI.*;
import Script.*;
public class Main extends JFrame implements Runnable, ActionListener{
	private static int stage = 1;
	private static int script = 1;
	private static boolean talking = true;
	private boolean scriptIng = true;
	private String nowName = "ø’";
	private Image img = Toolkit.getDefaultToolkit().getImage("src\\Source\\Icon.png");
	private Background stageBackground = new Background();
	private MainPanel mainPanel = new MainPanel();
//	private Thread backChangeThread = new Thread(stageBackground,"Background");
	private St1WBackground st1WB = new St1WBackground();
	private St1Frontground st1FB = new St1Frontground();
//	private St1Yuusha st1Yuusha = new St1Yuusha();
//	private St1Slime st1Slime = new St1Slime();
	private Image st1Yuusha;
	private Image st1Slime;
	private Timer timer;
	private St1STARTButton st1start = new St1STARTButton();
	private static boolean st1startpressed = true;
	private St1Tuto st1Tuto = new St1Tuto();
	private St1St2St13SkipNext skipNext = new St1St2St13SkipNext();
	private boolean sk = false;
	private TalkingBox talkingBox = new TalkingBox();
	private Script scriptContents = new Script();
	private float alpha = 0.0f;
	public Main(){
		st1Yuusha = (new ImageIcon("src\\Source\\Face\\∏∂ø’_face_1.png")).getImage();
		st1Slime = (new ImageIcon("src\\Source\\Face\\∏∂ø’_face_1.png")).getImage();
		timer = new Timer(20, this);
		setTitle("¡˝µÈ¿Ã ≥™∞£ ∞¯¡÷ ±∏«œ±‚");
		setSize(975,560);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setIconImage(img);
		skipNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
//				System.out.println("asdasd");
				if(sk) {
					skipNext.setImg("src\\Source\\GUI\\Ω∫≈µ-2.png");
				}else {
					skipNext.setImg("src\\Source\\GUI\\¥Ÿ¿Ω-2.png");
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				st1startpressed = false;
//				Main.setSt1startpressed(true);
				skipNext.setImg("src\\Source\\GUI\\");
				Main.setStage(Main.getStage()+1);
			}
		});
		st1start.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("¥≠∑¡¡¸");
				st1startpressed = false;
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				st1start.setImg("src\\Source\\GUI\\START.png");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				st1start.setImg("src\\Source\\GUI\\START-CLICK.png");
			}
		});
//		skipNext.addMouseListener(skipNext);
//		st1start.addMouseListener(st1start);
		scriptContents.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
//					super.mousePressed(e);
				scriptContents.setImg(stage,script);
				talkingBox.setImg(talking);
				scriptIng=false;
			}
		});
		talkingBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
//					super.mousePressed(e);
				scriptContents.setImg(stage,script);
				talkingBox.setImg(talking);
				scriptIng=false;
			}
		});
		add(mainPanel);
		mainPanel.add(scriptContents);
		mainPanel.add(talkingBox);
		mainPanel.add(skipNext);
		mainPanel.add(st1Tuto);
		mainPanel.add(st1start);
		mainPanel.add(st1WB);
		mainPanel.add(st1FB);
//		mainPanel.add(st1Yuusha);
//		mainPanel.add(st1Slime);
		mainPanel.add(stageBackground);
		setVisible(true);
		scriptContents.setVisible(false);
		talkingBox.setVisible(false);
		skipNext.setVisible(false);
		st1start.setVisible(false);
	}
	
	@Override
	public void run() {
		stageBackground.setImg(stage);
		mainPanel.setImg("src\\Source\\BackGround\\∏ﬁ¿Œ»≠∏È-øÎªÁ - ∫πªÁ∫ª.png");
		mainPanel.setPosition(673, -10, 398, 560, false);
		mainPanel.timer.start();
		try {
			Thread.currentThread().sleep(3000);
		}catch(Exception e) {
			
		}
		mainPanel.setImg("src\\Source\\BackGround\\∏ﬁ¿Œ»≠∏È-ΩΩ∂Û¿”.png");
		mainPanel.setPosition(-53, 148, 349, 217, true);
		mainPanel.timer.start();
	}
	
	/*
	@Override
	public void run() {
		while(stage<15) {
				stageBackground.setImg(stage);
			switch(stage){
			case 1:
				// TODO Auto-generated method stub
				st1Yuusha.moveOpaque("src\\Source\\BackGround\\GIF\\∏ﬁ¿Œ»≠∏È-øÎªÁ", ".png", -3, 5);
//				for(int i =1;i<34;i++) {
//					st1Yuusha.setImg("src\\Source\\BackGround\\GIF\\∏ﬁ¿Œ»≠∏È-øÎªÁ"+i+".png");
//					st1Yuusha.setBounds(st1Yuusha.getX()-3,st1Yuusha.getY(),st1Yuusha.getWidth(),st1Yuusha.getHeight());
//					try {
//						Thread.sleep(5);
//					}catch(InterruptedException e) {
//					}
//				}
				st1Slime.moveOpaque("src\\Source\\BackGround\\GIF_SLIME\\∏ﬁ¿Œ»≠∏È-ΩΩ∂Û¿”", ".png", 2, 5);
//				for(int i =1;i<34;i++) {
//					st1Slime.setImg("src\\Source\\BackGround\\GIF_SLIME\\∏ﬁ¿Œ»≠∏È-ΩΩ∂Û¿”"+i+".png");
//					st1Slime.setBounds(st1Slime.getX()+2,st1Slime.getY(),st1Slime.getWidth(),st1Slime.getHeight());
//					try {
//						Thread.sleep(5);
//					}catch(InterruptedException e) {
//					}
//				}
				
				for(int i = 2;i<=4;i++) {
					try {
						Thread.sleep(50);
					}catch(InterruptedException e) {
						
					}
					st1WB.setImg("src\\Source\\BackGround\\πË∞Ê_πÈ.png");
					try {
						Thread.sleep(50);
						st1FB.setImg("src\\Source\\BackGround\\∏ﬁ¿Œ»≠∏È-"+i+".png");
					}catch(InterruptedException e) {
						
					}
					st1WB.setImg(" ");
				}
				st1start.setImg("src\\Source\\GUI\\START-CLICK.png");
//				st1start.addMouseListener(st1start);
				st1start.setVisible(true);
				try {
					while(st1startpressed) {
						
						Thread.sleep(500);
					}
				}catch(InterruptedException e) {
					
				}
				st1startpressed = true;
				st1start.setVisible(false);
//				st1startpressed = false;
//				st1start.removeMouseListener(st1start);
				
				st1Tuto.setBounds(0, -10, 960, 560);
				st1Tuto.setImg("src\\Source\\BackGround\\∏ﬁ¿Œ»≠∏È-5.png");
				skipNext.setImg("src\\Source\\GUI\\¥Ÿ¿Ω-1.png");
				skipNext.setVisible(true);
//				skipNext.addMouseListener(skipNext);
				try {
					while(st1startpressed) {
						Thread.sleep(500);
					}
				}catch(InterruptedException e) {
					
				}
				st1startpressed = true;
//				st1startpressed=false;
				skipNext.setVisible(false);
//				skipNext.removeMouseListener(skipNext);
				
//				skipNext.setEnabled(false);
				
				
				break;

			case 2:
				// TODO Auto-generated method stub
				st1WB.setImg("src\\Source\\BackGround\\¿Œ∆Æ∑Œ-1.png");
				st1WB.setBounds(0,-10,960,300);
				st1FB.setImg("src\\Source\\Script\\¿Œ∆Æ∑Œ.png");
				st1FB.setBounds(104, 550, 753, 497);
				skipNext.setBounds(700, 50, 157, 49);
				sk = true;
				skipNext.setImg("src\\Source\\GUI\\Ω∫≈µ-1.png");
//				skipNext.addMouseListener(skipNext);
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
					skipNext.setImg("src\\Source\\GUI\\¥Ÿ¿Ω-1.png");
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
				
				break;
			case 3://script 16EA
				// TODO Auto-generated method stub
				talking = false;
				scriptContents.setVisible(true);
				talkingBox.setVisible(true);
				scriptContents.setImg(stage,script);
				script++;
				startIng("ø’");
				startIng("ø’");
				startIng("ø’");
				startIng("ø’");
				
				startIng("ø’");
				startIng("ø’");
				startIng("ø’");
				startIng("ø’");
				startIng("ø’");

				startIng("ø’");
				startIng("ø’");
				startIng("ø’");
				startIng("ø’");
				startIng("ø’");
				
				startIng("ø’");
				scriptContents.setVisible(false);
				talkingBox.setVisible(false);
				stage++;
				script=1;
				
				break;
			case 4://script 9EA
				// TODO Auto-generated method stub
				scriptContents.setVisible(true);
				talkingBox.setVisible(true);
				scriptContents.setImg(stage,script);
				script++;
				startIng();
				startIng();
				startIng();
				startIng();
				
				startIng();
				startIng();
				startIng();
				startIng();
				scriptContents.setVisible(false);
				talkingBox.setVisible(false);
				script=1;
				stage++;
				break;
			case 5://script 10EA
				// TODO Auto-generated method stub
				scriptContents.setVisible(true);
				talkingBox.setVisible(true);
				scriptContents.setImg(stage,script);
				script++;
				startIng();
				startIng();
				startIng();
				startIng();
				
				startIng();
				startIng();
				startIng();
				startIng();
				startIng();
				scriptContents.setVisible(false);
				talkingBox.setVisible(false);
				script=1;
				stage++;
				break;
			case 6://script 2EA
				// TODO Auto-generated method stub
				scriptContents.setVisible(true);
				talkingBox.setVisible(true);
				scriptContents.setImg(stage,script);
				script++;
				startIng();
				scriptContents.setVisible(false);
				talkingBox.setVisible(false);
				script=1;
				stage++;
				break;
			case 7://script 18EA
				// TODO Auto-generated method stub
				scriptContents.setVisible(true);
				talkingBox.setVisible(true);
				scriptContents.setImg(stage,script);
				script++;
				startIng();
				startIng();
				startIng();
				startIng();
				
				startIng();
				startIng();
				startIng();
				startIng();
				startIng();				
				
				startIng();
				startIng();
				startIng();
				startIng();
				startIng();
				
				startIng();
				startIng();
				startIng();

				scriptContents.setVisible(false);
				talkingBox.setVisible(false);
				script=1;
				stage++;
				break;
			case 8://script 29EA
				// TODO Auto-generated method stub
				scriptContents.setVisible(true);
				talkingBox.setVisible(true);
				scriptContents.setImg(stage,script);
				script++;
				startIng();
				startIng();
				startIng();
				startIng();
				
				startIng();
				startIng();
				startIng();
				startIng();
				startIng();
				
				startIng();
				startIng();
				startIng();
				startIng();
				startIng();
				
				startIng();
				startIng();
				startIng();
				startIng();
				startIng();
				
				startIng();
				startIng();
				startIng();
				startIng();
				startIng();
				
				startIng();
				startIng();
				startIng();
				startIng();
				scriptContents.setVisible(false);
				talkingBox.setVisible(false);
				script=1;
				stage++;
				break;
			case 9://script 25EA
				// TODO Auto-generated method stub
				scriptContents.setVisible(true);
				talkingBox.setVisible(true);
				scriptContents.setImg(stage,script);
				script++;
				startIng();
				startIng();
				startIng();
				startIng();
				
				startIng();
				startIng();
				startIng();
				startIng();
				startIng();
				
				startIng();
				startIng();
				startIng();
				startIng();
				startIng();
				
				startIng();
				startIng();
				startIng();
				startIng();
				startIng();
				
				startIng();
				startIng();
				startIng();
				startIng();
				startIng();
				scriptContents.setVisible(false);
				talkingBox.setVisible(false);
				script=1;
				stage++;
				break;
			case 10://script 36EA
				// TODO Auto-generated method stub
				scriptContents.setVisible(true);
				talkingBox.setVisible(true);
				scriptContents.setImg(stage,script);
				script++;
				startIng();
				startIng();
				startIng();
				startIng();
				
				startIng();
				startIng();
				startIng();
				startIng();
				startIng();
				
				startIng();
				startIng();
				startIng();
				startIng();
				startIng();
				
				startIng();
				startIng();
				startIng();
				startIng();
				startIng();
				
				startIng();
				startIng();
				startIng();
				startIng();
				startIng();
				
				startIng();
				startIng();
				startIng();
				startIng();
				startIng();
				
				startIng();
				startIng();
				startIng();
				startIng();
				startIng();
				
				startIng();
				scriptContents.setVisible(false);
				talkingBox.setVisible(false);
				script=1;
				stage++;
				break;
			case 11://script 20EA
				// TODO Auto-generated method stub
				scriptContents.setVisible(true);
				talkingBox.setVisible(true);
				scriptContents.setImg(stage,script);
				script++;
				startIng();
				startIng();
				startIng();
				startIng();
				
				startIng();
				startIng();
				startIng();
				startIng();
				startIng();
				
				startIng();
				startIng();
				startIng();
				startIng();
				startIng();
				
				startIng();
				startIng();
				startIng();
				startIng();
				startIng();
				scriptContents.setVisible(false);
				talkingBox.setVisible(false);
				script=1;
				stage++;
				break;
			case 12://script 3∞≥
				// TODO Auto-generated method stub
				scriptContents.setVisible(true);
				talkingBox.setVisible(true);
				scriptContents.setImg(stage,script);
				script++;
				startIng();
				startIng();
				scriptContents.setVisible(false);
				talkingBox.setVisible(false);
				script=1;
				stage++;
				break;
			case 13:
				// TODO Auto-generated method stub
			case 14:
				// TODO Auto-generated method stub
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
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main main = new Main();
		Thread thread = new Thread(main,"Main");
		thread.start();
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

//	public void setNowName(String nowName) {
//		this.nowName = nowName;
//	}

	public void startIng(String name) {
		this.nowName = name;
		try {
			while(scriptIng) {
				Thread.sleep(300);
			}
		}catch(InterruptedException e) {
			
		}
		System.out.println(script);
		script++;
		scriptIng=true;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	    alpha += 0.01f;
	    if (alpha > 1) {
	        alpha = 0;
	        timer.stop();
	        return;
	    }
	    repaint();
	}
}
*/