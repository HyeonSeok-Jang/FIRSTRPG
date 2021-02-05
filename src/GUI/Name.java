package GUI;
import javax.swing.ImageIcon;

import Main.superOfImg;

public class Name extends superOfImg{
	public Name(){
		setBounds(795,245,120,30);
		setImg(" ");
	}
	public void setName(String name) {
		
		if(name.equals("공주"))
			setBounds(785,245,120,30);
		else if(name.equals("용사"))
			setBounds(120,245,120,30);
		else
			switch(name.length()) {
			case 1:
				setBounds(795,245,120,30);
				break;
			case 2:
				setBounds(775,245,120,30);
				break;
			case 3:
				setBounds(765,245,120,30);
				break;
			default:
				setBounds(745,245,120,30);
				break;
			}
		super.setImg("src\\Source\\GUI\\Name\\"+name+".png");
	}
}
