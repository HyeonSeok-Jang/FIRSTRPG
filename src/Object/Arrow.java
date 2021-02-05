package Object;

import Main.*;
import java.awt.event.*;

public class Arrow extends superOfImg {
	private int rotation = 0;
	private int count = 0;
	public Arrow () {
		setImg("src\\Source\\Object\\Arrow_B_1.png");
		setBounds(0,0,200,200);
		
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getRotation() {
		return rotation;
	}
	public void setRotation(int rotation) {
		this.rotation = rotation;
	}
	
}
