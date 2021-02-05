package Main;

import java.io.File;
import javax.sound.sampled.*;
import javax.swing.*;

public class BGM implements Runnable{
	public static Clip clip;
	public BGM(int stage) {
		try{
	        BGM.clip = AudioSystem.getClip();
	        switch(stage) {
	        case 1:
	        	BGM.clip.open(AudioSystem.getAudioInputStream(new File("src\\Source\\Sound\\1, 14. castle-music-loop-1.wav")));
	        	break;
	        case 2:
	        	BGM.clip.open(AudioSystem.getAudioInputStream(new File("src\\Source\\Sound\\2. lonely-night.wav")));
	        	break;
	        case 3:
	        	BGM.clip.open(AudioSystem.getAudioInputStream(new File("src\\Source\\Sound\\3. uplifting-strings-short-version-tictac9-2.wav")));
	        	break;
	        case 4:
	        	BGM.clip.open(AudioSystem.getAudioInputStream(new File("src\\Source\\Sound\\4,5,6. stormy-wind.wav")));
	        	break;
	        case 5:
	        	BGM.clip.open(AudioSystem.getAudioInputStream(new File("src\\Source\\Sound\\4,5,6. stormy-wind.wav")));
	        	break;
	        case 6:
	        	BGM.clip.open(AudioSystem.getAudioInputStream(new File("src\\Source\\Sound\\4,5,6. stormy-wind.wav")));
	        	break;
	        case 7:
	        	BGM.clip.open(AudioSystem.getAudioInputStream(new File("src\\Source\\Sound\\7. drawbridge.wav")));
	        	break;
	        case 8:
	        	BGM.clip.open(AudioSystem.getAudioInputStream(new File("src\\Source\\Sound\\8. dance-kit-sample-2.wav")));
	        	break;
	        case 9:
	        	BGM.clip.open(AudioSystem.getAudioInputStream(new File("src\\Source\\Sound\\9. dance-2.wav")));
	        	break;
	        case 10:
	        	BGM.clip.open(AudioSystem.getAudioInputStream(new File("src\\Source\\Sound\\10. lonely-castle-2.wav")));
	        	break;
	        case 11:
	        	BGM.clip.open(AudioSystem.getAudioInputStream(new File("src\\Source\\Sound\\11. boss-battle-loop-3.wav")));
	        	break;
	        case 12:
	        	BGM.clip.open(AudioSystem.getAudioInputStream(new File("src\\Source\\Sound\\12. sad-guitar.wav")));
	        	break;
	        case 14:
	        	BGM.clip.open(AudioSystem.getAudioInputStream(new File("src\\Source\\Sound\\1, 14. castle-music-loop-1.wav")));
	        	break;
	        }
	        if(stage == 13) {
	        	if(YuushaStatus.isPrincessLive()) {
	        		if(YuushaStatus.getTime()>500) {
	        			BGM.clip.open(AudioSystem.getAudioInputStream(new File("src\\Source\\Sound\\13. castle-music-loop-1(´Ê).wav")));
	        		}else {
	        			BGM.clip.open(AudioSystem.getAudioInputStream(new File("src\\Source\\Sound\\13. my-love-piano-loop(ºü).wav")));
	        		}
	        	}else {
	        		BGM.clip.open(AudioSystem.getAudioInputStream(new File("src\\Source\\Sound\\13. creepy-strange-music-loop(»ì).wav")));
	        	}
	        }
	        
	    }catch (Exception exc){
	    }
		
	}
	@Override
	public void run() {
		clip.loop(clip.LOOP_CONTINUOUSLY);
		// TODO Auto-generated method stub
		BGM.clip.start();
	}
//	public static void main(String[] args) {
//		BGM bgm = new BGM(8);
//		Thread bg = new Thread(bgm,"dsfsd");
//		bg.start();
//		
//	}
}
