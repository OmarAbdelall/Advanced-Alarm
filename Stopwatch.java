package HomeWork;

import java.awt.*;

import javax.sound.sampled.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;

public class Stopwatch  implements ActionListener, Runnable{
private JButton btnStart,btnReset,btnExit;
private JLabel lbltime;
private JFrame frame;


private int elapsedTime=0;	
private int seconds =0;		
private int minutes =0;		
private int hours =0;		
private boolean started = false;


private String seconds_string = String.format("%02d", seconds);
private String minutes_string = String.format("%02d", minutes);	// here to make the seconds 00 : 
private String hours_string = String.format("%02d", hours);	

// this variable i will save on it the value of the input of the constructor that the user input
private int x=0; // this for hours
private int y=0;// this for minutes 
private int z=0;// this for elapsed time
private int s=0;// this for seconds time

// for the ring 
private File file;


// Timer 

Timer timer = new Timer(1000, new ActionListener() {
// here is a little bit confusing i know but it is logical here everything between curly braces that the 
	//timer will do after the 1000 mile second

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		elapsedTime-=1000;
		hours=(elapsedTime/3600000);
		minutes= (elapsedTime/60000) % 60;
		seconds= (elapsedTime/1000) % 60;
		seconds_string = String.format("%02d", seconds);
		minutes_string = String.format("%02d", minutes);
		hours_string = String.format("%02d", hours);
		lbltime.setText(hours_string + ":" +minutes_string+ ":" +seconds_string);
		
	
           if(elapsedTime==0) {
			
			// this method is working only here if i did this in the other actionPerformed
        	   // will not work
			lbltime.setText(hours_string + ":" +minutes_string+ ":" +seconds_string);
			btnStart.setText("Start");
			stop();
			started = true;
			
		
			
			Ring();
			
           }
	}
});

public Stopwatch( int hours, int minutes, int seconds) {

	

	if(hours>0) {
		
		for(int i=0 ;i<hours; i++) {
	this.elapsedTime = (elapsedTime +3600000 ) ;} 
	}
    
		if(minutes > 0) {
	for(int i=0 ;i<minutes; i++) { 
    this.elapsedTime = (elapsedTime +60000 );}
    }

       if(seconds > 0) {
	for(int i=0 ;i<seconds; i++) { 
    this.elapsedTime = (elapsedTime +1000 );}
		    }

		
	
	x = hours;
	y= minutes;
	s= seconds;
	z=this.elapsedTime;
}


public void Stopwatch2( ) {

	

// time label
	
	lbltime = new JLabel();
	lbltime.setText(hours_string + ":" +minutes_string+ ":" +seconds_string);
	lbltime.setBounds(100, 100,200,100);
	lbltime.setFont( new Font("Verdana", Font.PLAIN, 35));
	lbltime.setBorder(BorderFactory.createBevelBorder(1));
	lbltime.setOpaque(true);
	lbltime.setHorizontalAlignment(JTextField.CENTER);
	
	

// JButton start
	
	btnStart = new JButton("Stop");
	btnStart.setBounds(50, 200, 100, 50);
	btnStart.setFont( new Font("Ink Free", Font.PLAIN, 20));
	btnStart.setFocusable(false);
	btnStart.addActionListener(this);
	
// JButton reset.	
	btnReset = new JButton("Reset");
	btnReset.setBounds(150, 200, 100, 50);
	btnReset.setFont( new Font("Ink Free", Font.PLAIN, 20));
	btnReset.setFocusable(false);
	btnReset.addActionListener(this);

	// JButto Exit
	
	btnExit = new JButton("Exit");
	btnExit.setBounds(250, 200, 100, 50);
	btnExit.setFont( new Font("Ink Free", Font.PLAIN, 20));
	btnExit.setFocusable(false);
	btnExit.addActionListener(this);
	
//here to make the time start, so i don't have to click start to work it just will 
	// work automatic
timer.start();	
	
frame = new JFrame();
frame.add(lbltime);
frame.add(btnReset);
frame.add(btnStart);
frame.add(btnExit);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(420, 420);
frame.setLayout(null);	
frame.getContentPane().setBackground(new Color(230,100,0));
frame.setLocationRelativeTo(null);
frame.setVisible(true);// make sure you have this syntax last cause if you did it more advanced maybe some
// component will not appear.



	
}

@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()== btnStart) {
		
		if( started == false ) {
			started = true;
			btnStart.setText("Start");
			stop();
		}

		else if(elapsedTime==0) {
			
				JOptionPane.showMessageDialog(null, "The Timer is up, You have to Exit and set new"
						+ "Timer if you want" + JOptionPane.INFORMATION_MESSAGE);
				
				
				
				
				
				
				
				
				
				
		}
		else{
			started = false;
			btnStart.setText("Stop");
			start();
		}
		
 
	}// end of the main if
	
 if(e.getSource()== btnReset) {
	 started = false;
	 btnStart.setText("Start");
	 reset();
 }
	
	if(e.getSource()==btnExit) {
		exit();
	}
	
	
}
	
public void start() {
	timer.start();
}

public void stop() {
	timer.stop();
}


public void reset() {
	timer.stop();
	started = true;
	elapsedTime = z;
	minutes=y;
	hours=x;
	seconds=s;

	seconds_string = String.format("%02d", seconds);
	minutes_string = String.format("%02d", minutes);
	hours_string = String.format("%02d", hours);
	lbltime.setText(hours_string + ":" +minutes_string+ ":" +seconds_string);
}
public void exit() {
timer.stop();
btnStart.setText("stop");
started =true;
int sure = JOptionPane.showConfirmDialog(null, "Do you want to Exit? " , "Confirmation", 
		JOptionPane.YES_NO_OPTION);
if(sure == 0) {
	frame.dispose();
}
else if(sure == -1) {
	frame.dispose();
}
else {
	btnStart.setText("Start");
	
}
}

@Override
public void run() {
	
	try {
		
		Thread.currentThread().sleep(3000);
	 Stopwatch2();
		 
	}catch(Exception e) {
		
	}
}


public void Ring() {
	
	file = new File("TimeUp.wav");
	
	try {
		AudioInputStream audiostream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audiostream);
		clip.start();
		
	}catch (Exception e) {
		
	}
	
}




}
