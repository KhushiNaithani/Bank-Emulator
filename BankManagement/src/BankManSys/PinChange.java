package BankManSys;
import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;



public class PinChange extends JFrame implements ActionListener {
	String pin;
	JLabel lb;
	JPasswordField tf1,tf2;
	JButton ret, enter;
	
	PinChange(String pin)
	{
		ImageIcon i=new ImageIcon(transaction.class.getResource("/icons/atm.jpg"));
		Image icon=i.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
		ImageIcon i2=new ImageIcon(icon);
		JLabel image=new JLabel(i2);
		add(image);
		
		this.pin=pin;
				
		lb=new JLabel("CHANGE YOUR PIN");
		lb.setBounds(260,280,250,35);
		lb.setForeground(Color.WHITE);
		lb.setFont(new Font("System",Font.BOLD,16));
		image.add(lb);
		
		JLabel pintext=new JLabel("New PIN:");
		pintext.setFont(new Font("System",Font.BOLD,16));
		pintext.setForeground(Color.WHITE);
		pintext.setBounds(180,320,100,35);
		image.add(pintext);
		
		tf1 = new JPasswordField();
        tf1.setBounds(290,320,200,25);
        tf1.setFont(new Font("Arial", Font.BOLD, 20));
        image.add(tf1);
        
        JLabel pintext2=new JLabel("Re-Enter PIN:");
		pintext2.setFont(new Font("System",Font.BOLD,16));
		pintext2.setForeground(Color.WHITE);
		pintext2.setBounds(180,360,200,35);
		image.add(pintext2);
		
		tf2 = new JPasswordField();
        tf2.setBounds(290,370,200,25);
        tf2.setFont(new Font("Arial", Font.BOLD, 20));
        image.add(tf2);
        
        ret=new JButton("Return");
        ret.setFont(new Font("System",Font.BOLD,16));
        ret.setBounds(410,470,100,25);
        image.add(ret);
        ret.addActionListener(this);

        enter=new JButton("Change");
        enter.setFont(new Font("System",Font.BOLD,16));
        enter.setBounds(410,440,100,25);
        image.add(enter);
        enter.addActionListener(this);
		
//		setVisible(true);
		image.setBounds(0,0,900,900);
		setSize(900,900);
		setLayout(null);
		setLocation(300,0);
		setUndecorated(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==ret)
		{
			new transaction(pin).setVisible(true);
			setVisible(false);
		}
		
		else
		{
			
			try
			{
				String newPin=tf2.getText();
				String  rpin=tf1.getText();
				if(newPin.equals("")||rpin.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Empty fields");
					
				}
				else if(newPin.equals(pin))
				{
					JOptionPane.showMessageDialog(null,"New Pin can't be same as old pin");
				}
				else if(newPin.length()>4||newPin.length()<4)
				{
					JOptionPane.showMessageDialog(null, "Invalid Pin");
				}
				else if(rpin.equals(newPin))
				{
					Conn con=new Conn();
					String query1="update signupthree set pin='"+rpin+"' where pin ='"+pin+"'";
					String query2="update login set pin='"+rpin+"' where pin='"+pin+"'";
					String query3="update deposit set pin='"+rpin+"' where pin ='"+pin+"'";
					con.stmt.executeUpdate(query1);
					con.stmt.executeUpdate(query2);
					con.stmt.executeUpdate(query3);
					
					JOptionPane.showMessageDialog(null,"Pin Change SuccessFull");
					
				}
				else
				{
					tf2.setText("");
					JOptionPane.showMessageDialog(null,"Entered pin does'nt match");
					return;					
				}
				
				
			}
			catch(Exception er)
			{
				System.out.println(er);
			}
		}
		
	}
	
}
