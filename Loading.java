package HomeWork;

import java.awt.Color;






import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class Loading extends JPanel implements Runnable{
private int x,y;
private int xvelocity=3;
private Thread myThread1;
private JPanel panel;
private JFrame frame;	

@Override
public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.setColor(Color.GREEN);
		g.fillOval(x, y, 30, 30);
	}
	

public Loading() {
		
	
	
setLayout(null);	
setSize(400,200);	
setBackground(Color.lightGray);
setVisible(true);
panel = new JPanel();
panel.setBounds(0, 60, 400, 30);
panel.setBackground(Color.WHITE);
panel.setVisible(true);
add(panel);

frame();	

myThread1 = new Thread(this);
//myThread1.start();
x=359;
y=60;

	
}
public void frame() {
 frame = new JFrame();
frame.setSize(getSize());
frame.setVisible(true);
frame.setTitle("Loading...");
//frame.getContentPane().setBackground(getBackground());
frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
frame.setLocationRelativeTo(null);
frame.add(this);
}




public void move() {
	int m=0;
  while(m<=700) {
	try {
		Thread.currentThread().sleep(5);
	if(x>=360 || x<0) {
		xvelocity*= -1;
		
		
		repaint();
	} 
	x-=xvelocity;
	
	repaint();
	
	}catch(InterruptedException e){
		
	
	}
	
	++m;
	}
 frame.dispose();
}
	
	
	
public static void main(String[] args) {
		
	Loading l1 =new Loading();
	Thread t1 = new Thread(l1);
	t1.start();
	}









@Override
public void run() {
	
	
	move();
	
	}










}
