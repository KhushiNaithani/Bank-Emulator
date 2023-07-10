package BankManSys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.*;
public class signup1 extends JFrame implements ActionListener{
	
	static boolean checked=false;
	JTextField nametxt,fnametxt,statetxt,citytxt,dobtxt,emailtxt,maritaltxt,gendertxt,addresstxt;
	int random;
	JButton next;
	JRadioButton male,female,unmar,otherm,other,mar;
	
	signup1()
	{
		getContentPane().setBackground(Color.white);
		setLayout(null);		
		setVisible(true);
		
		random=(int)(Math.random()*(9999-1000+1));
		
		JLabel formno=new JLabel("Application Form number:"+random);
		formno.setFont(new Font("Raleway",Font.BOLD,38));
		formno.setBounds(140,20,600,40);
		setSize(850,800);
		add(formno);
		
		JLabel personDetails=new JLabel("Personal Details");
		personDetails.setFont(new Font("Raleway",Font.BOLD,20));
		personDetails.setBounds(300,80,400,30);
		add(personDetails);
		
		JLabel name=new JLabel("Name:");
		name.setFont(new Font("Raleway",Font.BOLD,20));
		name.setBounds(100,140,100,30);
		add(name);
		
		JLabel fname=new JLabel("Father's Name:");
		fname.setFont(new Font("Raleway",Font.BOLD,20));
		fname.setBounds(100,190,200,30);
		add(fname);
		
		JLabel dob=new JLabel("Date of birth:");
		dob.setFont(new Font("Raleway",Font.BOLD,20));
		dob.setBounds(100,240,200,30);
		add(dob);
		
				
		JLabel email=new JLabel("Email:");
		email.setFont(new Font("Raleway",Font.BOLD,20));
		email.setBounds(100,290,200,30);
		add(email);
		
		JLabel marital=new JLabel("Marital Status");
		marital.setFont(new Font("Raleway",Font.BOLD,20));
		marital.setBounds(100,340,200,30);
		add(marital);
		
		JLabel city=new JLabel("City:");
		city.setFont(new Font("Raleway",Font.BOLD,20));
		city.setBounds(100,390,200,30);
		add(city);
		
		JLabel state=new JLabel("State:");
		state.setFont(new Font("Raleway",Font.BOLD,20));
		state.setBounds(100,440,200,30);
		add(state);
		
		JLabel address=new JLabel("Address;");
		address.setFont(new Font("Raleway",Font.BOLD,20));
		address.setBounds(100,490,200,30);
		add(address);
		
		JLabel gender=new JLabel("Gender;");
		gender.setFont(new Font("Raleway",Font.BOLD,20));
		gender.setBounds(100,540,200,30);
		add(gender);
		
		nametxt=new JTextField();
		nametxt.setFont(new Font("Raleway",Font.BOLD,15));
		nametxt.setBounds(250,140,300,30);
		add(nametxt);
		
		fnametxt=new JTextField();
		fnametxt.setFont(new Font("Raleway",Font.BOLD,15));
		fnametxt.setBounds(250,190,300,30);
		add(fnametxt);
		
		emailtxt=new JTextField();
		emailtxt.setFont(new Font("Raleway",Font.BOLD,15));
		emailtxt.setBounds(250,290,300,30);
		add(emailtxt);
		
//		JDateChooser dateChoser=new JDateChooser();
//		dateChoser.setBounds(250,240,300,30);
		
		dobtxt=new JTextField();
		dobtxt.setFont(new Font("Raleway",Font.BOLD,15));
		dobtxt.setBounds(250,240,300,30);
		add(dobtxt);
		
		//Radio Button for Marriage status
		mar=new JRadioButton("Married");
		mar.setBounds(250,340,100,30);
		mar.setBackground(Color.WHITE);
		add(mar);
		
		unmar=new JRadioButton("Unmarried");
		unmar.setBounds(370,340,120,30);
		add(unmar);
		unmar.setBackground(Color.WHITE);
		
		otherm=new JRadioButton("other");
		otherm.setBounds(500,340,120,30);
		otherm.setBackground(Color.WHITE);
		add(otherm);
		
		ButtonGroup margrp=new ButtonGroup();
		margrp.add(mar);
		margrp.add(unmar);
		margrp.add(otherm);
		
		citytxt=new JTextField();
		citytxt.setFont(new Font("Raleway",Font.BOLD,15));
		citytxt.setBounds(250,390,300,30);
		add(citytxt);
		
		statetxt=new JTextField();
		statetxt.setFont(new Font("Raleway",Font.BOLD,15));
		statetxt.setBounds(250,440,300,30);
		add(statetxt);
		
		//Radio Button for gender
		male=new JRadioButton("Male");
		male.setBounds(250,540,60,30);
		male.setBackground(Color.WHITE);
		add(male);
		
		 female=new JRadioButton("Female");
		female.setBounds(370,540,120,30);
		add(female);
		female.setBackground(Color.WHITE);
		
		other=new JRadioButton("other");
		other.setBounds(500,540,120,30);
		other.setBackground(Color.WHITE);
		add(other);
		
		ButtonGroup gendergrp=new ButtonGroup();
		gendergrp.add(female);
		gendergrp.add(male);
		gendergrp.add(other);

		
		
		addresstxt=new JTextField();
		addresstxt.setFont(new Font("Raleway",Font.BOLD,15));
		addresstxt.setBounds(250,490,300,30);
		add(addresstxt);
		
		JButton next=new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setFont(new Font("Raleway",Font.BOLD,14));
		next.setBounds(550,660,120,40);
		add(next);
		next.addActionListener(this);
		
		
		
		
	}
	
	public void actionPerformed(ActionEvent Ae)
	{
		String formno=""+random;
		String name=nametxt.getText();
		String fname=fnametxt.getText();
		String dob=dobtxt.getText();
		String gender=null;
		if(male.isSelected())
		{
			gender="Male";
		}
		else if(female.isSelected())
		{
			gender="Female";
		}
		else
		{
			gender="Other";
		}
		
		String marital=null;
		if(mar.isSelected())
		{
			marital="Married";
		}
		else if(unmar.isSelected())
		{
			marital="Unmarried";
		}
		else
		{
			marital="Other";
		}
		
		String state=statetxt.getText();
		String city=citytxt.getText();
		String email=emailtxt.getText();
		String add=addresstxt.getText();
		
		
		try
		{
			if(fname.equals("")||name.equals("")||city.equals("")||state.equals("")||add.equals("")||email.equals("")||gender.equals(null)||marital.equals(null))
			{
				JOptionPane.showMessageDialog(null,"All Feilds should be filled Required");
			}
			else if(!checked)
			{
				try
				{
					if((dob.length()!=8)||dob.charAt(2)!='-'||dob.charAt(5)!='-')
					{
						throw new Exception();
					}
							
					checked=true;
				}
				catch(Exception er)
				{
					JOptionPane.showMessageDialog(null, "Date should be in the format DD-MM-YY");
				}
			}
			else
			{
				System.out.println("Done");
				Conn c=new Conn();
				String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+email+"','"+city+"','"+state+"','"+add+"','"+gender+"','"+marital+"')";
				c.stmt.executeUpdate(query);//DML command
				setVisible(false);
				new signup2(""+random).setVisible(true);
				
				 
				
						
				
			}
		}
		catch(Exception er)
		{
			System.out.println("Error");
		}
	}
	

}
