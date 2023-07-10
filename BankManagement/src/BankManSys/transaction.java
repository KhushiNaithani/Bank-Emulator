package BankManSys;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class transaction extends JFrame implements ActionListener{
	JButton deposit,tran, enq,pinChange,fastCash,mini,exit;
	String pin;
	transaction(String pin)
	{
		this.pin=pin;
		ImageIcon i=new ImageIcon(transaction.class.getResource("/icons/atm.jpg"));
		Image icon=i.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
		ImageIcon i2=new ImageIcon(icon);
		JLabel image=new JLabel(i2);
		add(image);
		
		JLabel text=new JLabel("Please select your transaction");
		text.setBounds(215,300,250,35);
		text.setFont(new Font("System",Font.BOLD,16));
		text.setForeground(Color.WHITE);
		image.add(text);
		
		deposit=new JButton("Deposit");
		deposit.setBounds(160,418,150,28);
		deposit.addActionListener((ActionListener) this);
		add(deposit);
	
		
		tran=new JButton("Withdraw");
		tran.setBounds(160,450,150,28);
		tran.addActionListener((ActionListener) this);
		add(tran);
		
		enq=new JButton("Mini Statement");
		enq.setBounds(160,480,150,28);
		enq.addActionListener((ActionListener) this);
		add(enq);
		
		pinChange=new JButton("Pin Change");
		pinChange.setBounds(350,418,150,28);
		pinChange.addActionListener((ActionListener) this);
		add(pinChange);
		
		fastCash=new JButton("Fast Cash");
		fastCash.setBounds(350,450,150,28);
		fastCash.addActionListener((ActionListener) this);
		add(fastCash);
		
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
			System.exit(0);
		}
		else if(ae.getSource()==fastCash)
		{
			new FastCash(pin).setVisible(true);
			setVisible(false);
		}
		else if(ae.getSource()==pinChange)
		{
			new PinChange(pin).setVisible(true);
			setVisible(false);
		}
		else if(ae.getSource()==deposit)
		{
			new Deposit(pin).setVisible(true);
			setVisible(false);
		}
		
		else if(ae.getSource()==tran)
		{
			new Withdraw(pin).setVisible(true);
			setVisible(false);
			
		}
		else
		{
			new MiniStatement(pin).setVisible(true);
			
		}
		
	}

}
