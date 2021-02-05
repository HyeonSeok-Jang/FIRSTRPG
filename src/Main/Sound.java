package Main;
import java.io.File;

import javax.sound.sampled.*;
import javax.swing.*;

public class Sound implements Runnable{
	Clip clip;
	public Sound(String name) {
		try{
	        clip = AudioSystem.getClip();
    		clip.open(AudioSystem.getAudioInputStream(new File("src\\Source\\Sound\\"+name+".wav")));
	    }catch (Exception exc){
	    }
	}
	@Override
	public void run() {
		clip.start();
	}
}