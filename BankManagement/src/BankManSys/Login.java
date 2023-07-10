package BankManSys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField tf1;
    JPasswordField pf2;
    JButton login,clear,signup;
    
    Login() {
        setTitle("ATM");
        setSize(800, 500);
        setVisible(true);
        setLocation(350, 200);
        setLayout(null);

        ImageIcon il = new ImageIcon(Login.class.getResource("/icons/logo.jpg"));
        Image i2=il.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel l1 = new JLabel("WELCOME TO ATM");
        l1.setFont(new Font("Osward", Font.BOLD, 38));
        l1.setBounds(200,40,450,40);
        add(l1);
        
        JLabel l2 = new JLabel("Card No:");
        l2.setFont(new Font("Raleway", Font.BOLD, 28));
        l2.setBounds(125,150,375,30);
        add(l2);
        
        tf1 = new JTextField(15);
        tf1.setBounds(300,150,230,30);
        tf1.setFont(new Font("Arial", Font.BOLD, 14));
        add(tf1);
        
        JLabel l3 = new JLabel("PIN:");
        l3.setFont(new Font("Raleway", Font.BOLD, 28));
        l3.setBounds(125,220,375,30);
        add(l3);
        
        pf2 = new JPasswordField(15);
        pf2.setFont(new Font("Arial", Font.BOLD, 14));
        pf2.setBounds(300,220,230,30);
        add(pf2);
                
        login = new JButton("SIGN IN");
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.setBounds(300,300,100,30);
        login.addActionListener(this);
        add(login);
        
        clear = new JButton("CLEAR");
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.setBounds(430,300,100,30);
        clear.addActionListener(this);
        add(clear);
        
        signup = new JButton("SIGN UP");
        signup.addActionListener(this);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.setBounds(300,350,230,30);
        add(signup);
        
        
        setLayout(null);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
    	if(ae.getSource()==clear)
    	{
    		tf1.setText("");
    		pf2.setText("");
    	}
    	
    	else if(ae.getSource()==login)
    	{
    		Conn conn=new Conn();
    		String cardnumber=tf1.getText();
    		String pin=pf2.getText();
    		String query="Select * from login where cardNumber='"+cardnumber+"' and pin ='"+pin+"'";
    		try
    		{
    			ResultSet rs=conn.stmt.executeQuery(query);
    			if(rs.next())
    			{
    				setVisible(false);
    				new transaction(pin).setVisible(true);
    				  				
    			}
    			else
				{
					JOptionPane.showMessageDialog(null,"No Such User found");
				}
    		}
    		catch(Exception er)
    		{
    			System.out.println(er);
    		}
    	}
    	
    	else if(ae.getSource()==signup) {
    		setVisible(false);
    		new signup1().setVisible(true);    		
    	}
    }

    public static void main(String args[]) {
        new Login();
    }
}
