package HomeWork;

import java.awt.Color;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
public class Window extends JFrame implements ActionListener,MouseListener,Runnable{
private JButton btnSave,btnBack,btnAorB;
private JTextField txtHour,txtMinute,txtSecond,txtAorB;	
private JLabel  lblHour,lblMinute,lblAorB,lblSecond,lblDot1,lblDot2;
private JPanel pnlAorB;
private JComboBox jcbAorB;
private JTextArea txtFinal_Info, txtServer;
private Thread myThread1;
private Server server,server2;
private Socket Ssocket; 


// special for time 
private int elapsedTime =0;	
private int seconds =0;		
private int minutes =0;		
private int hours =0;		
private boolean started= false;


// this variables are for only the save button.
public  int  IntHour; // for hours
public  int  IntMinute; // for minutes
public  int IntSecond; // for seconds.

// 


private String String_hour = String.format("%02d", hours); //this to make 00 in hours
private String String_minutes = String.format("%02d", minutes);
private String String_seconds = String.format("%02d", seconds);

private String xclient;

// for client 
private Socket socket;
private OutputStream out;
private DataOutputStream dout;
private InputStream in;
private DataInputStream din;




// client


public void Client() {
	
	
	try {
		
		 socket = new Socket("127.0.0.1", 7000);
		
		
		
		 in = socket.getInputStream();
		 din = new DataInputStream(in);
		xclient =  din.readUTF(); 
		
		 out = socket.getOutputStream();
		 dout = new DataOutputStream(out);
		
		
		
		}catch(Exception e) {
			
		}
	
}
/*public void Can() {
	
	 try {
		//out = socket.getOutputStream();
		// dout = new DataOutputStream(out);
		
	} catch (Exception e) {

	}
	
}*/



public void Window2() {
//2) set The layout;	
     setLayout(null);
	

//3)inserting the btn

  btnSave= new JButton("Save");
  btnSave.setBounds(550, 0, 150,70);
  btnSave.setFont(new Font(null, Font.BOLD,30));
  add(btnSave);
   
  btnBack = new JButton("Back");
  btnBack.setBounds(0, 0, 150, 70);
  btnBack.setFont(new Font(null, Font.BOLD,30));
  add(btnBack);

 	
 //4) inserting Text-Field and its J-label 

  //a) Hours   
  lblHour= new JLabel("Hours:");
  lblHour.setBackground(new Color(230,100,0));
  lblHour.setForeground(Color.black);
  lblHour.setFont(new Font(null, Font.BOLD,25));
  lblHour.setBounds(185, 200, 85, 40);
  add(lblHour);
  txtHour= new JTextField();
  txtHour.setText(String_hour); // here to add 00 in the start 
  txtHour.setForeground(Color.black);
  txtHour.setFont(new Font(null, Font.BOLD,70));
  txtHour.setBounds(180,250, 85, 100);
  add(txtHour);

  lblDot1 = new JLabel(":");
  lblDot1.setBackground(new Color(230,100,0));
  lblDot1.setFont(new Font(null, Font.BOLD,70));
  lblDot1.setBounds(280,250, 45, 80);
  add(lblDot1);
  
  
  //b) Minutes
  lblMinute= new JLabel("Minutes:");
  lblMinute.setBackground(new Color(230,100,0));
  lblMinute.setForeground(Color.black);
  lblMinute.setFont(new Font(null, Font.BOLD,20));
  lblMinute.setBounds(310, 200, 90, 40);
  add(lblMinute);
  txtMinute= new JTextField();
  txtMinute.setText(String_minutes);
  txtMinute.setForeground(Color.black);
  txtMinute.setFont(new Font(null, Font.BOLD,70));
  txtMinute.setBounds(310,250, 85, 100);
  add( txtMinute);
 
  lblDot2 = new JLabel(":");
  lblDot2.setBackground(new Color(230,100,0));
  lblDot2.setFont(new Font(null, Font.BOLD,70));
  lblDot2.setBounds(405,250, 45, 80);
  add(lblDot2);	  
 
  //b) second
  lblSecond= new JLabel("Seconds:");
  lblSecond.setBackground(new Color(230,100,0));
  lblSecond.setForeground(Color.black);
  lblSecond.setFont(new Font(null, Font.BOLD,20));
  lblSecond.setBounds(430, 200, 95, 40);
  add(lblSecond);
  txtSecond= new JTextField();
  txtSecond.setText(String_seconds);
  txtSecond.setForeground(Color.black);
  txtSecond.setFont(new Font(null, Font.BOLD,70));
  txtSecond.setBounds(440,250, 85, 100);
  add( txtSecond);
		  
  
  server = new Server();
  server.start();
  Client();
  
  
 //6) insert the Final information for the user
  txtFinal_Info = new JTextArea();
  txtFinal_Info.setBounds(150, 500, 400, 150);
  txtFinal_Info.setFont(new Font(null, Font.BOLD,20));
  add(txtFinal_Info);
  
  // server Text
//the server implementation

  
  txtServer = new JTextArea();
  txtServer.setText( xclient );
  txtServer.setBounds(80, 80, 520, 110);
  txtServer.setBackground(new Color(252,232,232));
  txtServer.setFont(new Font(null, Font.BOLD,25));
  add(txtServer);
 
  
  
  
  
  
  
  
  //7) assign the button to ActionListener
  
  btnBack.addActionListener(this);
  btnSave.addActionListener(this);
  txtHour.addMouseListener(this); //  here to delete the 00 at the beginning
  txtMinute.addMouseListener(this);
  txtSecond.addMouseListener(this);
 
//1) design the  JFrame ;	
setSize(700,700);	
setVisible(true);
setDefaultCloseOperation(EXIT_ON_CLOSE);
getContentPane().setBackground(new Color(230,100,0));
setLocationRelativeTo(null);
setResizable(false);
ImageIcon image = new ImageIcon("alarm2.png");
setIconImage(image.getImage());
}
	
 




	
	
	
	
	
	public static void main(String[] args) {
		
		Window w1 = new Window();
		Thread t1 = new Thread(w1);
		t1.start();
		
	}







	@Override
	public void actionPerformed(ActionEvent e) {
	 
		if(e.getSource()==btnSave) {
			
			// step by step
			//1) our text field
			//  IntHour=0; // for hours
			 //IntMinute=0; // for minutes
			 //IntSecond=0; // for seconds
			boolean thePreventer = true;// this prevent the timer from starting if there is a wrong case
			
			try {
				String StrOne = txtHour.getText().trim();
				IntHour = Integer.parseInt(StrOne);
			      String StrTwo = txtMinute.getText().trim();
			      IntMinute = Integer.parseInt(StrTwo);
			      String StrThree = txtSecond.getText().trim();
			      IntSecond = Integer.parseInt(StrThree);
			      
			} catch(Exception f) {
				 JOptionPane.showMessageDialog(this, "You Must Enter The Number in Integer Form ",
							"Error",JOptionPane.ERROR_MESSAGE);
				 thePreventer = false;
				 
			}
			      
			      
			      
			  if( (IntHour % 1 ) !=0 || (IntMinute % 1) != 0) {
			    	  JOptionPane.showMessageDialog(this, "You Must Enter The Number in Integer Form ",
								"Error",JOptionPane.ERROR_MESSAGE);
				   }
			      
			
			 if(IntHour > 12 || IntMinute > 60 || IntSecond> 60  ) {
				JOptionPane.showMessageDialog(this, "You Must Enter The Number between 0 and 12"
						+ "for Hours and from 0 to 60 for Minutes",
						"Error",JOptionPane.ERROR_MESSAGE);
			}
		if (thePreventer == true) {
			
			try {
				
                   
 			 dout.writeUTF("Client Side:The Timer \n will be end up after,"
						   + IntHour + " Hour \n" +"," +IntMinute
					   	+" Minute, " +IntSecond + " Second.");
			     dout.close();
			
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(this, "Your validity has expired,\n"
						+ "you have to log out and log in again.",
						"Error",JOptionPane.ERROR_MESSAGE);
				thePreventer = false;
			}
			
			if(thePreventer == true) {
			txtFinal_Info.setText(server.y);
			
			Stopwatch s = new Stopwatch(IntHour, IntMinute, IntSecond);
			Thread t1 = new Thread(s);
			t1.start();
			
			
			
			   
				
				try {
					
				Alarm.Fwriter.write("\n The Timer did signed by the user is: ,"
						   + IntHour + " Hour " +"," +IntMinute
					   	+" Minute, " +IntSecond + " Second.");
				Alarm.Fwriter.flush();
					
				} catch (IOException f) {
					
					
				}
			
			
			
			
			
			
			
			
			
			
			}
			
			
			}
			
			
			
			
}// end of the button save
	
   if(e.getSource()==btnBack) {
	 /* txtHour.setText("");
	  txtMinute.setText("");
	  txtSecond.setText("");
	  txtFinal_Info.setText("");*/
	  dispose();
	  
	  
	  try {
		
		  in.close();
		  din.close();
		  out.close();
		dout.close();
		
		 socket.close();
		 
		  
	  
	  } catch (IOException e1) {
		
	}
	  
	  
	  new Alarm();
	  
	 
	  
	   
   }
	
	
	if(e.getSource()==txtHour) {
		txtHour.setText("");
	}
	
	
}







	@Override
	public void run() {
		
		try {	
			Thread.currentThread().sleep(5000);
			Window2();
		}catch(Exception e) {
			
		}
		
	
}







	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(e.getSource()==txtHour) {
			txtHour.setText("");
		}
		if(e.getSource()==txtMinute) {
			txtMinute.setText("");
		}
		if(e.getSource()==txtSecond) {
			txtSecond.setText("");
		}
	}







	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}







	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}







	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}








	}