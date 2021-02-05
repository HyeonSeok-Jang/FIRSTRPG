package GUI;
import javax.swing.ImageIcon;

import Main.superOfImg;

public class Face extends superOfImg{
	private String name = "���";
	private int yuushaFace = 1;
	private int karlFace = 1;
	public Face(){
		setBounds(795,245,120,30);
		setImg(" ");
	}
	@Override
	public void setImg(String name) {
		if(name.equals("���"))
			this.name = name+yuushaFace;
		else if(name.equals("ī��"))
			this.name = name+karlFace;
		else
			this.name = name;
		super.setImg("src\\Source\\Face\\"+this.name+".png");
		if(name.equals("���")) {
			setBounds(0,-25,319,319);
			this.name = name+yuushaFace;
		}else if(name.equals("ī��")) {
			setBounds(635,-25,319,319);
			this.name = name+karlFace;
		}else {
			setBounds(635,-50,319,319);
			this.name = name;
		}
			
		
		
		
	}
	@Override
	public void moveOpaque(String fileFirst,String fileSecond, int MoveX, int sleepTime) {
		if(name.equals("���")) {
			setBounds(0-66,-50,319,319);
		}else {
			setBounds(635+66,-50,319,319);
			
		}
		super.moveOpaque(fileFirst, fileSecond, MoveX, sleepTime);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setYuushaFace(int yuushaFace) {
		this.yuushaFace = yuushaFace;
	}
	public void setKarlFace(int karlFace) {
		this.karlFace = karlFace;
	}
	
}
