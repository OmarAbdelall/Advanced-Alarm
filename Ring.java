package HomeWork;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.*;
public class Ring {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		File file = new File("TimeUp.wav");
		
		try {
			AudioInputStream audiostream = AudioSystem.getAudioInputStream(file);
			Clip clip = AudioSystem.getClip();
			clip.open(audiostream);
			clip.start();
			String response = scanner.next();
		} 
		catch (Exception e) {
			
		}
		
		
	}
	
}
