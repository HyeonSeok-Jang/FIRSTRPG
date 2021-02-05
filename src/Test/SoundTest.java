package Test;
import java.awt.*;
import java.io.File;

import javax.sound.sampled.*;
import javax.swing.*;
public class SoundTest extends JFrame{

	//음악 재생 메서드
	public void Play(String fileName){
	        try{
	            AudioInputStream ais = AudioSystem.getAudioInputStream(new File(fileName));
	            Clip clip = AudioSystem.getClip();
//	            clip.stop();
	            clip.open(ais);
	            clip.start();
	        } catch (Exception ex){
	        }
	    }
	 
	 
	 //생성자
	 public SoundTest() {
		 Play("src\\Source\\Sound\\1, 14. castle-music-loop-1.mp3");
		 setDefaultCloseOperation(EXIT_ON_CLOSE);
		 setSize(500,500);
		 setLocationRelativeTo(null);
		 setVisible(true);
	 }

	 public static void main(String[] args) {
		 SoundTest sd = new SoundTest();
	 }
}
