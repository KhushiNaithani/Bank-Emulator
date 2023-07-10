package BankManSys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class signup2 extends JFrame implements ActionListener{

	JTextField pantxt,Adhaartxt;
	JComboBox relegion,cat,income,Edu,OccuChoice;
	JButton next;
	JRadioButton yesAcc,noAcc;
	String formno;
	
	signup2(String formno)
	{
		this.formno=formno;
		setTitle("NEW ACCOUNT APPLICATION");
		getContentPane().setBackground(Color.white);
		setSize(800,800);
		setLayout(null);		
		setVisible(true);
		
		
		
		
		JLabel addDetails=new JLabel("Additional Details Form no:"+formno);
		addDetails.setFont(new Font("Raleway",Font.BOLD,20));
		addDetails.setBounds(300,80,400,30);
		add(addDetails);
		
		JLabel releg=new JLabel("Relegion:");
		releg.setFont(new Font("Raleway",Font.BOLD,20));
		releg.setBounds(100,140,100,30);
		add(releg);
		
		String[] valRelegion= {"Hindu","Muslim","Christian","Sikh","Parsi","Jain","others"};
		relegion=new JComboBox(valRelegion);
		relegion.setBounds(250,140,300,30);
		add(relegion);
		
		JLabel categ=new JLabel("Category:");
		categ.setFont(new Font("Raleway",Font.BOLD,20));
		categ.setBounds(100,190,200,30);
		add(categ);
		
		String[] valCat= {"General","SC","ST","OBC","others"};
		cat=new JComboBox(valCat);
		cat.setBounds(250,190,300,30);
		add(cat);
		
		JLabel education=new JLabel("Education:");
		education.setFont(new Font("Raleway",Font.BOLD,20));
		education.setBounds(100,240,200,30);
		add(education);
		
		String[] valEdu= {"Non-Graduate","Graduate","Post-Graduate","Doctorate","Others"};
		Edu=new JComboBox(valEdu);
		Edu.setBounds(250,240,300,30);
		add(Edu);
		
				
		JLabel inco=new JLabel("Income:");
		inco.setFont(new Font("Raleway",Font.BOLD,20));
		inco.setBounds(100,290,200,30);
		add(inco);
		
		String[] valincome= {"Null","< 1,50,000","<2,00,000","<5,00,000","Upto 10,00,000"};
		income=new JComboBox(valincome);
		income.setBounds(250,290,300,30);
		add(income);
		
		JLabel panCard =new JLabel("Pan-card");
		panCard.setFont(new Font("Raleway",Font.BOLD,20));
		panCard.setBounds(100,340,200,30);
		add(panCard);
		
		pantxt=new JTextField();
		pantxt.setFont(new Font("Raleway",Font.BOLD,15));
		pantxt.setBounds(250,340,300,30);
		add(pantxt);
		
		JLabel Existing=new JLabel("Existing Acount:");
		Existing.setFont(new Font("Raleway",Font.BOLD,20));
		Existing.setBounds(100,390,200,30);
		add(Existing);
		
		 yesAcc=new JRadioButton("YES");
		yesAcc.setBounds(260,390,100,30);
		yesAcc.setBackground(Color.WHITE);
		add(yesAcc);
		
		noAcc=new JRadioButton("No");
		noAcc.setBounds(380,390,100,30);
		noAcc.setBackground(Color.WHITE);
		add(noAcc);
		
		ButtonGroup ExisChoice=new ButtonGroup();
		ExisChoice.add(noAcc);
		ExisChoice.add(yesAcc);
		
		JLabel Adhar=new JLabel("Adhaar Number");
		Adhar.setFont(new Font("Raleway",Font.BOLD,20));
		Adhar.setBounds(100,440,200,30);
		add(Adhar);
		
		JLabel Occu=new JLabel("Occupation:");
		Occu.setFont(new Font("Raleway",Font.BOLD,20));
		Occu.setBounds(100,490,200,30);
		add(Occu);
		
		String[] valOccup= {"Salaried","Business-Man","Student","Retired","Self-Employed","Other"};
		OccuChoice=new JComboBox(valOccup);
		OccuChoice.setBounds(250,490,300,30);
		add(OccuChoice);
				
		Adhaartxt=new JTextField();
		Adhaartxt.setFont(new Font("Raleway",Font.BOLD,15));
		Adhaartxt.setBounds(250,440,300,30);
		add(Adhaartxt);

		
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
		String srelegion=(String)relegion.getSelectedItem();
		String scategory=(String)cat.getSelectedItem();
		String sincome=(String)income.getSelectedItem();
		String seducation=(String)Edu.getSelectedItem();
		String soccupation=(String)OccuChoice.getSelectedItem();
		String exisAcc=null;
		if(yesAcc.isSelected())
		{
			exisAcc="Yes";
		}
		else
		{
			exisAcc="No";
		}
		
		String sadhaar=Adhaartxt.getText();
		String span=pantxt.getText();

		
		
		try
		{
			if(srelegion.equals("")||scategory.equals("")||sincome.equals("")||soccupation.equals("")||seducation.equals("")||exisAcc.equals(null)||sadhaar.equals("")||span.equals(""))
			{
				JOptionPane.showMessageDialog(null,"All Feilds should be filled Required");
			}
			else
			{
				System.out.println("Done");
				Conn c=new Conn();
				String query = "INSERT INTO signup2 VALUES ('" + srelegion + "','" + scategory + "','" + sincome + "','" + soccupation + "','" + seducation + "','" + exisAcc + "','" + sadhaar + "','"+span+"','"+formno+"')";
				c.stmt.executeUpdate(query);//DML command
				new signin3(formno).setVisible(true);
				setVisible(false);
				
				 
				
						
				
			}
		}
		catch(Exception er)
		{
			System.out.println(er);
		}
	}
	
	public static void main(String args[])
	{
		new signup2("1");
	}

}
