import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class PTIFacultyHelpDesk extends JPanel implements ActionListener{
	
	private JLabel heading;
	private JLabel name;
	private JLabel dept;
	private JLabel request;
	
	private JRadioButton software;
	private JRadioButton hardware;
	private JRadioButton accountAssistancce;
	
	private JLabel requestDescription;
	private JTextField nameTextfield;
	private JTextField deptTextfield;
	private JTextField requestDescriptionTextfield;
	private JLabel urgency;
	
	private JRadioButton urgent;
	private JRadioButton High;
	private JRadioButton medium;
	private JRadioButton low;
	private JRadioButton noHurry;
	
	private JButton clear;
	private JButton submit;
	
	private String uname;
	private String udept;
	private String resType;
	private String resDesp;
	private String urgencyType;
	
	public PTIFacultyHelpDesk(){
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(8,1));
		
		JPanel headingPanel = new JPanel();
		headingPanel.setLayout(new GridLayout(5,1));
		
		heading = new JLabel("PTI Help Desk Request Form");
		name = new JLabel("User Name:");
		nameTextfield = new JTextField(4);
		dept = new JLabel("User Department:");
		deptTextfield = new JTextField(4);
		
		headingPanel.add(heading);
		headingPanel.add(name);
		headingPanel.add(nameTextfield);
		headingPanel.add(dept);
		headingPanel.add(deptTextfield);
	
		
		JPanel requestSelectionPanel = new JPanel();
		requestSelectionPanel.setLayout(new GridLayout(4,1));
		
		request = new JLabel("Type of Request:");
		software = new JRadioButton("Software(new install or updrade");
		hardware = new JRadioButton("Hardware(repair or upgrade)");
		accountAssistancce = new JRadioButton("Account assistancce(New account needed or login problem)");
		
		ButtonGroup group1 = new ButtonGroup();
		
		group1.add(software);
		group1.add(hardware);
		group1.add(accountAssistancce);
		
		requestSelectionPanel.add(request);
		requestSelectionPanel.add(software);
		requestSelectionPanel.add(hardware);
		requestSelectionPanel.add(accountAssistancce);
		
		JPanel requestDescriptionPanel = new JPanel();
		requestDescriptionPanel.setLayout(new GridLayout(2,1));
		
		requestDescription = new JLabel("Request Description:");
		requestDescriptionTextfield = new JTextField(6);
		
		requestDescriptionPanel.add(requestDescription);
		requestDescriptionPanel.add(requestDescriptionTextfield);
		
		JPanel urgentSelectionPanel = new JPanel();
		urgentSelectionPanel.setLayout(new GridLayout(6,1));
		
		urgency = new JLabel("Urgency:");
		urgent = new JRadioButton("Urgent(0-4 hours completion)");
		High = new JRadioButton("High(1-2 days completion)");
		medium = new JRadioButton("Medium(3-5 days completion)");
		low = new JRadioButton("Low(6+ days completion)");
		noHurry = new JRadioButton("No Hurry");
		
        ButtonGroup group2 = new ButtonGroup();
        group2.add(urgent);
        group2.add(High);
        group2.add(medium);
        group2.add(low);
        group2.add(noHurry);
		
		
		urgentSelectionPanel.add(urgency);
		urgentSelectionPanel.add(urgent);
		urgentSelectionPanel.add(High);
		urgentSelectionPanel.add(medium);
		urgentSelectionPanel.add(low);
		urgentSelectionPanel.add(noHurry);
		
		JPanel clearSubmitPanel = new JPanel();
		clearSubmitPanel.setLayout(new GridLayout(1,2));
		
	    clear = new JButton("Clear");
	    clear.setActionCommand("1");
	    clear.addActionListener(this);
	    
	    submit = new JButton("Submit");
	    submit.setActionCommand("2");
	    submit.addActionListener(this);
	    
	    clearSubmitPanel.add(clear);
	    clearSubmitPanel.add(submit);
		
		mainPanel.add(headingPanel);
		mainPanel.add(requestSelectionPanel);
		mainPanel.add(requestDescriptionPanel);
		mainPanel.add(urgentSelectionPanel);
		mainPanel.add(clearSubmitPanel);
		
		this.add(mainPanel);
	}
	
	public static void main(String[] args) {
		//Create the java window 
        JFrame frame = new JFrame("PTI Help Desk");
        frame.setSize(600, 800);
		
       //now go and populate 
		frame.setContentPane(new PTIFacultyHelpDesk());
		
		//add the behavior to terminate this JFrame when were finished with it
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Seting the app so that it cannot be resized
		//frame.setResizable(false);
		
		//let it be seen
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(software.isSelected()){
			resType ="Software(new install or updrade)";
		}else if(software.isSelected()){
			resType ="Hardware(repair or upgrade)";
		}else{
			resType ="Account assistancce(New account needed or login problem)";
		}
		
		
		if(urgent.isSelected()){
			urgencyType = "Urgent(0-4 hours completion)";
		}else if(High.isSelected()){
			urgencyType = "High(1-2 days completion)";
		 }
	    else if(medium.isSelected()){
	    	urgencyType = "Medium(3-5 days completion)";
        }else if(low.isSelected()){
        	urgencyType = "Low(6+ days completion)";
        }else{
        	urgencyType = "No Hurry";
        }

		switch(e.getActionCommand()){
		
		case "1":
			System.out.println("I am clear button");
			
			nameTextfield.setText("");
			deptTextfield.setText("");
			requestDescriptionTextfield.setText("");
		
			software.setSelected(false);
			hardware.setSelected(false);
			accountAssistancce.setSelected(false);
			
			urgent.setSelected(false);
			High.setSelected(false);
			medium.setSelected(false);
			low.setSelected(false);
			noHurry.setSelected(false);
			
			break;
			
		case "2":
			
			System.out.println("I am submit button");
			
			try {
				
				File file = new File("requestForm.txt");
				
				FileOutputStream  outputStream = new FileOutputStream (file);
				
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
				
				bw.write("Your Request Informaton");
				bw.newLine();
				bw.write("User Name:" + nameTextfield.getText());
				bw.newLine();
				bw.write("User Department:" + deptTextfield.getText());
				bw.newLine();
				bw.write("Request type:" + resType);
				bw.newLine();
				bw.write("Request Description:" + requestDescriptionTextfield.getText());
				bw.newLine();
				bw.write("Urgency : " + urgencyType);
				bw.newLine();
				bw.newLine();
				bw.write("Your ticket Number for follow up is : " + randomNumber());
				
				bw.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			break;
	}
	
	}
	
	public static int randomNumber(){
		   
		   Random random = new Random();
		   
		   int randomInt = random.nextInt(1000000);
		   
		   return randomInt;
	   }

}
