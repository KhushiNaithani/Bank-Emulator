package BankManSys;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;
import java.util.*;
import java.awt.*;

public class Withdraw extends JFrame implements ActionListener{
	JLabel lb;
	JTextField tf1;
	JButton ret,deposit;
	String pin;
	
	Withdraw(String j)
	{
		this.pin=j;
		
		ImageIcon i=new ImageIcon(transaction.class.getResource("/icons/atm.jpg"));
		Image icon=i.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
		ImageIcon i2=new ImageIcon(icon);
		JLabel image=new JLabel(i2);
		add(image);
				
		lb=new JLabel("Enter the Amount you want to withdraw");
		lb.setBounds(190,300,350,35);
		lb.setForeground(Color.WHITE);
		lb.setFont(new Font("System",Font.BOLD,16));
		image.add(lb);
		
		tf1 = new JTextField();
        tf1.setBounds(220,350,250,35);
        tf1.setFont(new Font("Arial", Font.BOLD, 14));
        image.add(tf1);
        
        ret=new JButton("Return");
        ret.setFont(new Font("System",Font.BOLD,16));
        ret.setBounds(410,450,110,25);
        image.add(ret);
        ret.addActionListener(this);

        deposit=new JButton("Withdraw");
        deposit.setFont(new Font("System",Font.BOLD,16));
        deposit.setBounds(410,420,110,25);
        image.add(deposit);
        deposit.addActionListener(this);
		

		
		setLayout(null);
		image.setBounds(0,0,900,900);
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
		
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==ret)
		{
			setVisible(false);
			new transaction(pin).setVisible(true);
		}
		else
		{
			String amt=tf1.getText();
			if(amt.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Feild Can't be empty ");
			}
			else
			{
				Date date=new Date();
				Conn con=new Conn();
				try
				{
					ResultSet rs=con.stmt.executeQuery("select * from deposit where pin='"+pin+"' ");
					int balance=0;
					
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
					
					if(balance >= Integer.parseInt(amt))
					{
						String query="insert into deposit values('"+pin+"','"+date+"','Withdraw','"+amt+"')";
						con.stmt.executeUpdate(query);
						JOptionPane.showMessageDialog(null,"Rs"+amt+" withdraw successfully");
						new transaction(pin).setVisible(true);
						setVisible(false);
						
					}
					
					else
					{
						JOptionPane.showMessageDialog(null,"Not sufficient Balance");
					}
					
				}
				catch(Exception er)
				{
					System.out.println(er);
				}
				
			}
//			if(amt.hasNumeric())
//			
			
		}
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String args[])
	{
		new Withdraw("1234");
	}

}
