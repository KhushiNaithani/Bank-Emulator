package BankManSys;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;

	class signin3 extends JFrame implements ActionListener{
		JRadioButton rSav, rCur,rFd,rRec;
		JCheckBox c1,c2,c3,c4,c5,c6,c7;
		JButton submit,cancel;
		String formno;
	
	signin3(String formno){
		this.formno=formno;
		setLayout(null);
		setSize(650,600);
		setVisible(true);
		getContentPane().setBackground(Color.WHITE);
		
		JLabel l1=new JLabel("Account Details");
		l1.setFont(new Font("Raleway",Font.BOLD,20));
		l1.setBounds(280,40,400,40);
		add(l1);
		
		JLabel type=new JLabel("Account Type");
		type.setFont(new Font("Raleway",Font.BOLD,20));
		type.setBounds(100,100,400,20);
		add(type);	
		
		rSav =new JRadioButton("Saving Account");
		rSav.setFont(new Font("Raleway",Font.BOLD,15));
		rSav.setBounds(100,140,200,20);
		add(rSav);
		
		rCur =new JRadioButton("Current Account");
		rCur.setFont(new Font("Raleway",Font.BOLD,15));
		rCur.setBounds(300,140,220,20);
		add(rCur);
		
		rFd =new JRadioButton("Fixed Deposit Account");
		rFd.setFont(new Font("Raleway",Font.BOLD,15));
		rFd.setBounds(100,180,200,20);
		add(rFd);
		
		rRec =new JRadioButton("Recurring Deposit Account");
		rRec.setFont(new Font("Raleway",Font.BOLD,15));
		rRec.setBounds(300,180,220,20);
		add(rRec);
		
		ButtonGroup btn=new ButtonGroup();
		btn.add(rSav);
		btn.add(rCur);
		btn.add(rFd);
		btn.add(rRec);
		
		JLabel card=new JLabel("Card Number");
		card.setFont(new Font("Raleway",Font.BOLD,20));
		card.setBounds(100,220,200,20);
		add(card);
		
		JLabel cDet=new JLabel("Your 16 digit card number");
		cDet.setFont(new Font("Raleway",Font.BOLD,10));
		cDet.setBounds(100,240,400,20);
		add(cDet);
		
		JLabel cardNo=new JLabel("XXX-XXXX-XXXX-6576");
		cardNo.setFont(new Font("Raleway",Font.BOLD,20));
		cardNo.setBounds(300,220,400,20);
		add(cardNo);
		
		JLabel pinN=new JLabel("Pin Number");
		pinN.setFont(new Font("Raleway",Font.BOLD,20));
		pinN.setBounds(100,270,200,20);
		add(pinN);
		
		JLabel pin=new JLabel("XXXX");
		pin.setFont(new Font("Raleway",Font.BOLD,20));
		pin.setBounds(300,270,400,20);
		add(pin);
		
		JLabel pinDet=new JLabel("Your Four digit password");
		pinDet.setFont(new Font("Raleway",Font.BOLD,10));
		pinDet.setBounds(100,290,400,20);
		add(pinDet);
		
		JLabel service=new JLabel("Services");
		service.setFont(new Font("Raleway",Font.BOLD,20));
		service.setBounds(100,320,200,20);
		add(service);	
		
		c1=new JCheckBox("ATM Card");
		c1.setFont(new Font("Raleway",Font.BOLD,15));
		c1.setBounds(100, 350,200,20);
		add(c1);
		
		c2=new JCheckBox("Internet Banking");
		c2.setFont(new Font("Raleway",Font.BOLD,15));
		c2.setBounds(300, 350,200,20);
		add(c2);
		
		c3=new JCheckBox("Email Alert");
		c3.setFont(new Font("Raleway",Font.BOLD,15));
		c3.setBounds(100, 380,200,20);
		add(c3);
		
		c6=new JCheckBox("Check Book");
		c6.setFont(new Font("Raleway",Font.BOLD,15));
		c6.setBounds(300, 380,200,20);
		add(c6);
		
		c4=new JCheckBox("E-statement");
		c4.setFont(new Font("Raleway",Font.BOLD,15));
		c4.setBounds(100, 410,200,20);
		add(c4);
		
		c5=new JCheckBox("Mobile Banking");
		c5.setFont(new Font("Raleway",Font.BOLD,15));
		c5.setBounds(300, 410,200,20);
		add(c5);
		
		c7=new JCheckBox("I hereby declare that all the information provided are correct upto my knowledge");
		c7.setFont(new Font("Raleway",Font.BOLD,10));
		c7.setBounds(100, 450,500,20);
		add(c7);
		
		submit=new JButton("Submit");
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.setFont(new Font("Raleway",Font.BOLD,15));
		submit.setBounds(140, 490,100,20);
		add(submit);
		submit.addActionListener(this);
		
		cancel=new JButton("Cancel");
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.setFont(new Font("Raleway",Font.BOLD,15));
		cancel.setBounds(290, 490,100,20);
		add(cancel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==submit)
		{
			String accountType=null;
			if(rSav.isSelected())
				accountType="Saving";
			else if(rCur.isSelected())
				accountType="Current Saving";
			else if(rFd.isSelected())
				accountType="Fixed Deposit";
			else if(rRec.isSelected())
				accountType="Recurring Account";
			
			Random random=new Random();
			String cardNumber=Math.abs(random.nextLong() % 90000000L)+5040936000000000L+"";
			String pin=Math.abs(random.nextLong()%9000)+1000L+"";
			
			String facility="";
			
			if(c1.isSelected())
				facility+=" ATM Card";

			if(c2.isSelected())
				facility+=" Internet Banking";

			if(c3.isSelected())
				facility+=" Mobile Banking";

			if(c4.isSelected())
				facility+=" Email Alert";

			if(c5.isSelected())
				facility+=" CheckBox";

			if(c6.isSelected())
				facility+=" E-statement";
			
			try
			{
				if(accountType==null)
					JOptionPane.showMessageDialog(null,"Account Type required");
				else
				{
					Conn con=new Conn();
					String str="INSERT INTO signupthree values('"+formno+"','"+accountType+"','"+facility+"','"+cardNumber+"','"+pin+"')";
					con.stmt.executeUpdate(str);
					
					str=""+"INSERT INTO login values('"+cardNumber+"','"+pin+"')";
					con.stmt.executeUpdate(str);
					JOptionPane.showMessageDialog(null,"Card number: "+cardNumber+"\nPin:"+pin);
					setVisible(false);
					new Login().setVisible(true);
				}
				
			}
			
			catch(Exception e)
			{
				System.out.println(e);
			}
			
			
			
		}
			
		
	}
	
	public static void  main(String args[])
	{
		new signin3("1");
	}

}
