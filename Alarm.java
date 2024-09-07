package HomeWork;

import java.io.File;


import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class Alarm extends JFrame implements ActionListener{

//pass the attributes by Objects  
private JLabel lblName,lblbetween;
private JTextField txtName,txtCountry;
private JButton  btncountry, btnwhy1,btnwhy2,btnwhy3;
private JPanel pnlCountry;	
private Image imgAlarm;
private JComboBox jcbCountry;
private JTextArea txtWelcome,txtbtn1,txtbtn2,txtbtn3;
static FileWriter Fwriter;
public static File File;
private JFrame frame;
private Loading load;
private Thread myThread;
private ReentrantLock reen;

@Override
	public void paint(Graphics g) {
		
		super.paint(g);
		g.drawImage(imgAlarm, 700, 20, 100, 100, this);
		g.drawImage(imgAlarm, 490, 235, 40 ,40, this);
	}

public  Alarm() {

// 2) set the layout. *************
setLayout(null);
	
//3) a) initialize the Labels ***********
	lblName = new JLabel();
	lblName.setText("User Name:");
	lblName.setBackground(new Color(255,80,0));
	lblName.setForeground(Color.BLACK);
	lblName.setOpaque(true);
	lblName.setFont(new Font(null, Font.BOLD, 20));
	lblName.setBounds(0, 0, 120, 100);
	add(lblName);
	// b)initialize its text-field for the lblName; ~~~~~~~~~~
	txtName = new JTextField();
	//txtName.setEditable(false);
	//txtName.setBounds(0,200, 300, 30);
	txtName.setBackground(Color.white);
	txtName.setBounds(121,30,300,50);
	txtName.setFont(new Font(null,Font.BOLD,20));
	
	add(txtName);

    //c) initialize label-between ~~~~~~~~~~~~~~~~~~~
	
	lblbetween = new JLabel();
	
	lblbetween.setText("Choose Your Country:");
	lblbetween.setBackground(new Color(255,80,0));
	lblbetween.setForeground(Color.BLACK);
	lblbetween.setOpaque(true);
	lblbetween.setFont(new Font(null, Font.BOLD, 20));
	lblbetween.setBounds(0, 110, 300, 80);
	add(lblbetween);
	
	
	
	
	
   //d) add JComboBox and Button-country  to the Panel ~~~~~~~~~~
			
	btncountry = new JButton("My Country:");
	btncountry.setFont(new Font(null, Font.BOLD, 20));
	
	jcbCountry = new JComboBox();
	jcbCountry.addItem("Choose A Country: ");
	jcbCountry.addItem("Turkey");
	jcbCountry.addItem("Egypt");
	jcbCountry.setFont(new Font(null, Font.BOLD, 20));
	
	pnlCountry = new JPanel();
	pnlCountry.setBackground(new Color(255,80,0));
	pnlCountry.setBounds(0, 200, 600, 50);
	pnlCountry.add(jcbCountry);
	pnlCountry.add(btncountry);
	add(pnlCountry);

	
	// e) add txtField to ensure the country did i choose.
	txtCountry = new JTextField();
	txtCountry.setBackground(Color.white);
	txtCountry.setBounds(0, 250, 600, 50);
    txtCountry.setFont(new Font(null, Font.BOLD, 20));
    txtCountry.setEditable(false);
	add(txtCountry);

		
//4) initialize Image
	
	imgAlarm = new ImageIcon("alarm2.png").getImage();
				
		
		
		
		
// 5) initialize welcome JTextArea;
		txtWelcome = new JTextArea();
		txtWelcome.setText("Welcome!");
		txtWelcome.setBackground(Color.WHITE);
		txtWelcome.setForeground(Color.black);
		txtWelcome.setBounds(0, 325, 600, 150);
		//txtWelcome.setOpaque(true);
		txtWelcome.setEditable(false);
		txtWelcome.setFont(new Font(null, Font.BOLD,30));
		add(txtWelcome);
		

		
		
//6) here i started to add buttons
	//a)
	btnwhy1 = new JButton("Normal Alarm        >");
	btnwhy1.setBounds(0	, 480, 580, 70);
	btnwhy1.setFont(new Font(null, Font.BOLD,20));
	add(btnwhy1);

	
	//b)
	btnwhy2 = new JButton(" Alarm with Mathematical problem!    >");
	btnwhy2.setBounds(0	, 550, 580, 70);
	btnwhy2.setFont(new Font(null, Font.BOLD,20));
	add(btnwhy2);

	// C) 
	btnwhy3 = new JButton("  Free From Technology  >");
	btnwhy3.setBounds(0	, 620, 580, 70);
	btnwhy3.setFont(new Font(null, Font.BOLD,20));
	add(btnwhy3);
	
	
// 7) txtArea to  explain the functionality for the 3 button;
//a)
	txtbtn1 = new JTextArea();
	txtbtn1.setText("This button to set up alarm\n at specific time \n"
			+ " and you will be alarmed ");
	txtbtn1.setBackground(Color.WHITE);
	txtbtn1.setForeground(Color.black);
	txtbtn1.setBounds(580, 480, 220, 65);
	//txtWelcome.setOpaque(true);
	txtbtn1.setEditable(false);
	txtbtn1.setFont(new Font(null, Font.BOLD,13));
	add(txtbtn1);

	//b)
	txtbtn2 = new JTextArea();
	txtbtn2.setText("This button will make you \n not able to end the alarm "
			+ "\n until you solve \n the mathematical equation");
	txtbtn2.setBackground(Color.WHITE);
	txtbtn2.setForeground(Color.black);
	txtbtn2.setBounds(580, 550, 220, 70);
	//txtWelcome.setOpaque(true);
	txtbtn2.setEditable(false);
	txtbtn2.setFont(new Font(null, Font.BOLD,13));
	add(txtbtn2);
	
	// c) 
	txtbtn3 = new JTextArea();
	txtbtn3.setText("This button will make you\n not able to use the PC  \n  "
			+ "for time did you choose! ");
	txtbtn3.setBackground(Color.WHITE);
	txtbtn3.setForeground(Color.black);
	txtbtn3.setBounds(580, 622, 220, 70);
	//txtWelcome.setOpaque(true);
	txtbtn3.setEditable(false);
	txtbtn3.setFont(new Font(null, Font.BOLD,13));
	add(txtbtn3);
	
//9) ActionListener Assign:
	btncountry.addActionListener(this);
	txtName.addActionListener(this);
	btnwhy1.addActionListener(this);
	btnwhy2.addActionListener(this);
	btnwhy3.addActionListener(this);

	


	
//10) initialize my Thread 
	myThread = new Thread();
//11)intialize the file will write the data of user
	
		
	
	 File = new File("User's_Data.txt");
	
	try {
		Fwriter = new FileWriter(File);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	

	
// 1) initialize and design the JFrame.
 setSize(800,800);
 setResizable(true);
 setVisible(true);
 getContentPane().setBackground(new Color(255,100,0));
 setDefaultCloseOperation(EXIT_ON_CLOSE);
 setLocationRelativeTo(null);
 setTitle("Timer-Ti");
 setResizable(false);
 ImageIcon image = new ImageIcon("alarm2.png");
 setIconImage(image.getImage()); 
 
 
 

 
}






	public static void main(String[] args) {
		 new Alarm(); // the reference of the Alarm2();
		
		// initialize the Fwriter and assign the file name to it.
		//System.out.println("Omar");
		
	}


	
	
/**
 * 	the action-performed method , it is the Implemented method came from the class Action-listener
 * and i use it to determine which component i used and according for that i could also determine the functionality
 * of this component
 */
	@Override
public void actionPerformed(ActionEvent e) {
		
		
if( e.getSource()== btncountry) {
			Mcountry();
			
			String x =txtName.getText();
			txtWelcome.setText("Welcome " + x +  "!, in our App"
					+ " \n you have the advantage of trying \n different types of alarm set up"
					+ "\n So you Can choose one of the Three types below ");
			txtWelcome.setFont(new Font(null, Font.BOLD,25));	
			
			
			
		}
		
else if(e.getSource()==txtName) {
		
	String x =txtName.getText();
	JOptionPane.showMessageDialog(this, "Hello " + x);
	try {
		Fwriter.write("The User's Name is: " + x);
		Fwriter.flush();
	} catch (IOException e1) {
		
	}
		}


else if(e.getSource()==btnwhy1) {
		 int x =	JOptionPane.showConfirmDialog(this, "You chose normal alarm", 
					"Confirmation",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
		 if(x==1 || x==-1) {
			 JOptionPane.showMessageDialog(this, "You Exit from normal alarm");
		    }
		 
		 else {
	     	Man();
	     	
	  
	  
			}        
          
         
}		
		
		
else if(e.getSource()==btnwhy2) {
			 int x =	JOptionPane.showConfirmDialog(this, "You chose Mathematical Alarm", 
						"Confirmation",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.INFORMATION_MESSAGE);
			 if(x==1 || x==-1) {
				 JOptionPane.showMessageDialog(this, "You Exit from Mathematical Alarm");
			 } 
			 else { 
			Man();
			}
}
		
else if(e.getSource()==btnwhy3) {
			 int x =	JOptionPane.showConfirmDialog(this, "You chose Feel Free Alarm", 
						"Confirmation",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.INFORMATION_MESSAGE);
			 if(x==1|| x==-1) {
				 JOptionPane.showMessageDialog(this, "You Exit form Feel Free Alarm");}
			 else {
				 Man();}
		 
}
			 
			 
			 
		
	}// end of the implemented method [ActionListener];

/**
 * 	this method is Called Mcountry and it is void.Also, it takes the text of JCombobox and recognize which 
 *  country i chose and add it to the TxtCountry.
 *  Moreover, it add the user information into a outer file.
 */
public void Mcountry() {
	String x = (String) jcbCountry.getItemAt(jcbCountry.getSelectedIndex());
	String E="Egypt";
	String T = "Turkey";
	if(5 == x.length()) {
		txtCountry.setText("(GMT +2) Time in Egypt.");
		try {
			Fwriter.write("\nThe User's Country is: " + x);
			Fwriter.flush();
			
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
	}// end of if
	
	
	if (6 == x.length()){
		txtCountry.setText("(GMT +3) Time in Turkey.");
	      try {
		Fwriter.write("\nThe User's Country is: " + x);
		Fwriter.flush();
		
		
	} catch (IOException e1) {
		
		e1.printStackTrace(); 
	}
	    }//end of second condition if


 }// end of the method





public synchronized void Man() {
	dispose();
	  load=  new Loading();
	 Thread t1 = new Thread(load);
	  
	 
	 t1.start();
	   
	 
	   
	   
	   Window window = new Window();
	   Thread t2 = new Thread(window);
	   t2.start();
	   
	   
	   
	 
}


}
