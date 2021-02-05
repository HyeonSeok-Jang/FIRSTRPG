package GUI;

import Main.superOfImg;

public class NickName extends superOfImg implements Runnable{
	private String fileFirst, fileSecond;
	private int MoveX, sleepTime;
//	public NickName(String fileFirst, String fileSecond, int MoveX, int sleepTime){
	public NickName(){
//		this.fileFirst = fileFirst;
//		this.fileSecond = fileSecond;
//		this.MoveX = MoveX;
//		this.sleepTime = sleepTime;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.setVisible(true);
		moveOpaque(fileFirst, fileSecond, MoveX, sleepTime);
		try {
			Thread.sleep(2000);
		}catch(InterruptedException e) {
			
		}
		moveOpaqueReverse(fileFirst, fileSecond, MoveX, sleepTime);
		this.setVisible(false);
	}
	public void setMoveOpaque(String fileFirst, String fileSecond, int MoveX, int sleepTime) {
		this.fileFirst = fileFirst;
		this.fileSecond = fileSecond;
		this.MoveX = MoveX;
		this.sleepTime = sleepTime;
	}
	public void setPosition(int x, int y, int w, int h) {
		this.setBounds(x, y, w, h);
	}
}
