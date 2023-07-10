package BankManSys;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
	JButton btn1,btn2,btn3,btn4,btn5,exit;
	String pin;
	FastCash(String pin)
	{
		this.pin=pin;
		ImageIcon i=new ImageIcon(transaction.class.getResource("/icons/atm.jpg"));
		Image icon=i.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
		ImageIcon i2=new ImageIcon(icon);
		JLabel image=new JLabel(i2);
		add(image);
		
		JLabel text=new JLabel("SELECT WITHDRAWAL AMOUNT");
		text.setBounds(215,300,250,35);
		text.setFont(new Font("System",Font.BOLD,16));
		text.setForeground(Color.WHITE);
		image.add(text);
		
		btn1=new JButton("Rs 500");
		btn1.setBounds(160,418,150,28);
		btn1.addActionListener((ActionListener) this);
		add(btn1);
	
		
		btn2=new JButton("Rs 1000");
		btn2.setBounds(160,450,150,28);
		btn2.addActionListener((ActionListener) this);
		add(btn2);
		
		btn3=new JButton("Rs 2000");
		btn3.setBounds(160,480,150,28);
		btn3.addActionListener((ActionListener) this);
		add(btn3);
		
		btn4=new JButton("Rs 5000");
		btn4.setBounds(350,418,150,28);
		btn4.addActionListener((ActionListener) this);
		add(btn4);
		
		btn5=new JButton("Rs 10000");
		btn5.setBounds(350,450,150,28);
		btn5.addActionListener((ActionListener) this);
		add(btn5);
		
		exit=new JButton("Exit");
		exit.setBounds(350,480,150,28);
		exit.addActionListener((ActionListener) this);
		add(exit);
		
		
		
		
		setLayout(null);
		image.setBounds(0,0,900,900);
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
		
		
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==exit)
		{
			new transaction(pin).setVisible(true);
			setVisible(false);
		}
		else
		{
			int amt=Integer.parseInt(((JButton)ae.getSource()).getText().substring(3));
			Conn con=new Conn();
			int balance=0;
			try
			{
				ResultSet rs=con.stmt.executeQuery("select * from deposit where pin='"+pin+"' ");
				
				while(rs.next())
				{
					if(rs.getString("type").equals("Deposit"))
					{
						balance+=Integer.parseInt(rs.getString("amount"));
					}
					else
					{
						balance-=Integer.parseInt(rs.getString("amount"));
					}
				}
				
				if(balance >= amt)
				{
					Date date=new Date();
					String query="insert into deposit values('"+pin+"','"+date+"','Withdraw','"+amt+"')";
					con.stmt.executeUpdate(query);
					JOptionPane.showMessageDialog(null,"Rs '"+amt+"' have been withdrawn");
					new transaction(pin).setVisible(true);
					setVisible(false);
				}
				
				else
				{
					JOptionPane.showMessageDialog(null,"Insufficient Balance");
				}
			}
			catch(Exception er)
			{
				System.out.println(er);
			}
		}
		
			
	}
	
	public static void main(String args[])
	{
		new FastCash("1234");
	}

}
