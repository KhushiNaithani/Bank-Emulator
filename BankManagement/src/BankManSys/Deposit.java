package BankManSys;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;

public class Deposit extends JFrame implements ActionListener{
	JLabel lb;
	JTextField tf1;
	JButton ret,deposit;
	String pin;
	
	Deposit(String j)
	{
		this.pin=j;
		
		ImageIcon i=new ImageIcon(transaction.class.getResource("/icons/atm.jpg"));
		Image icon=i.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
		ImageIcon i2=new ImageIcon(icon);
		JLabel image=new JLabel(i2);
		add(image);
				
		lb=new JLabel("Enter the Amount");
		lb.setBounds(250,300,250,35);
		lb.setForeground(Color.WHITE);
		lb.setFont(new Font("System",Font.BOLD,16));
		image.add(lb);
		
		tf1 = new JTextField();
        tf1.setBounds(220,350,250,35);
        tf1.setFont(new Font("Arial", Font.BOLD, 14));
        image.add(tf1);
        
        ret=new JButton("Return");
        ret.setFont(new Font("System",Font.BOLD,16));
        ret.setBounds(410,450,100,25);
        image.add(ret);
        ret.addActionListener(this);

        deposit=new JButton("Deposit");
        deposit.setFont(new Font("System",Font.BOLD,16));
        deposit.setBounds(410,420,100,25);
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
					String query="insert into deposit values('"+pin+"','"+date+"','Deposit','"+amt+"')";
					con.stmt.executeUpdate(query);
					JOptionPane.showMessageDialog(null,"Rs"+amt+" Deposit successfully");
					new transaction(pin).setVisible(true);
					setVisible(false);
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
		new Deposit("1234");
	}

}
