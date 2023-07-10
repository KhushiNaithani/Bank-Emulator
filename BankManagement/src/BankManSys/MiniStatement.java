package BankManSys;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame {
	String pin;
	JButton back;
	MiniStatement(String pin)
	{
		this.pin=pin;
		
		
		JLabel text=new JLabel("BANK STATEMENT");
		text.setBounds(150,30,400,35);
		text.setFont(new Font("System",Font.BOLD,35));
		add(text);
		
		JLabel card=new JLabel("Card No:");
		card.setBounds(10,150,400,20);
		card.setFont(new Font("System",Font.BOLD,19));
		add(card);
		
		JLabel name=new JLabel("Name:");
		name.setBounds(10,180,400,20);
		name.setFont(new Font("System",Font.BOLD,19));
		add(name);
		
		JLabel balance=new JLabel("Name:");
		balance.setBounds(10,200,400,20);
		balance.setFont(new Font("System",Font.BOLD,19));
		add(balance);
		
		JLabel mini=new JLabel();
		mini.setBounds(10,240,800,200);
//		mini.setHorizontalAlignment(JLabel.LEFT);
//		mini.setVerticalAlignment(JLabel.TOP);
		mini.setFont(new Font("System",Font.BOLD,19));
		add(mini);
		
//		back=new JButton("BACK");
//		back.setBounds(410,450,100,30);
//		add(back);
//		back.addActionListener(this);
		
		try {
			Conn con=new Conn();
			ResultSet rs=con.stmt.executeQuery("select * from login where pin='"+pin+"'");
			while(rs.next())
			{
				card.setText("Card No: XXXXXXXXXX"+rs.getString("cardNumber").substring(0,8));
			}
			
			String formNo="";
			rs=con.stmt.executeQuery("select * from signupthree where pin='"+pin+"'");
			while(rs.next())
			{
				formNo=rs.getString("formNo");
			}
			
			rs=con.stmt.executeQuery("select * from signup where formno='"+formNo+"'");
			while(rs.next())
			{
				name.setText("Name:  "+rs.getString("name"));
			}
			
			rs=con.stmt.executeQuery("select * from deposit where pin ='"+pin+"'");
		       mini.setText("<html>");
		       int balanceAmt=0;
		        while (rs.next()) {
		            mini.setText(mini.getText() + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br>");
		            
		           
		            if(rs.getString("type").equals("Deposit"))
		            {
		            	balanceAmt+=Integer.parseInt(rs.getString("amount"));
		            }
		            else
		            {
		            	balanceAmt-=Integer.parseInt(rs.getString("amount"));
		            	
		            }
		            
		            
		        }

		        mini.setText(mini.getText() + "</html>");
		        balance.setText("Balance:    "+balanceAmt);
		        
		        
		        
		   
		}
		catch(Exception er)
		{
			System.out.println(er);
		}
		
		setLayout(null);
		setSize(600,900);
		setLocation(300,0);

		setTitle("Mini Statement");		
		setVisible(true);
		
	}


}
