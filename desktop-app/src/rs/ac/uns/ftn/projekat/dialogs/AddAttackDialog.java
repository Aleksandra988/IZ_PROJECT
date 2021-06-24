package rs.ac.uns.ftn.projekat.dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import rs.ac.uns.ftn.projekat.database.AtteckInsert;
import rs.ac.uns.ftn.projekat.database.GetAttack;
import rs.ac.uns.ftn.projekat.model.Attack;

public class AddAttackDialog extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static JTextField txtId = new JTextField();
	static JTextField txtName = new JTextField();
	static JTextField txtPrerequisites = new JTextField();
	static JTextField txtMitigations= new JTextField();
	static JTextField txtWeaknesses=new JTextField();
	static JComboBox<String> txtLikelihood=new JComboBox<String>();
	static JComboBox<String> txtSeverity=new JComboBox<String>();
	
	

	public AddAttackDialog() {

		//layout

		txtId.setPreferredSize(new Dimension(160,20));
		txtName.setPreferredSize(new Dimension(160,20));
		txtLikelihood.setPreferredSize(new Dimension(160,20));
		txtSeverity.setPreferredSize(new Dimension(160,20));
		txtPrerequisites.setPreferredSize(new Dimension(160,20));
		txtMitigations.setPreferredSize(new Dimension(160,20));
		txtWeaknesses.setPreferredSize(new Dimension(160,20));

		txtLikelihood.addItem("None");
		txtLikelihood.addItem("Low");
		txtLikelihood.addItem("Medium");
		txtLikelihood.addItem("High");
		txtLikelihood.addItem("Very high");
		
		txtSeverity.addItem("None");
		txtSeverity.addItem("Low");
		txtSeverity.addItem("Medium");
		txtSeverity.addItem("High");
		txtSeverity.addItem("Very high");
		
		setBackground(Color.GREEN);
		setModal(true);
		setTitle("Attack");
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double height=screenSize.getHeight();
		double width=screenSize.getWidth();
		height=height*0.7;
		width=width*0.3;
		setBounds(150, 150, (int)width, (int)height);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JLabel id = new JLabel("Attack identification*");
		JLabel name = new JLabel("Name*");
		JLabel likelihood = new JLabel("Likelihood");
		JLabel severity = new JLabel("Severity");
		JLabel prerequisites = new JLabel("Prerequisites");
		JLabel mitigations = new JLabel("Mitigations");
		JLabel weaknesses = new JLabel("Weaknesses");
		
		JPanel panelI = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelN = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelL = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelS = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelM = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelW = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		
		
		
		Box box=Box.createVerticalBox();
		this.add(box,BorderLayout.CENTER);
		
		panelI.add(id);
		panelI.add(txtId);
		box.add(panelI);
		
		panelN.add(name);
		panelN.add(txtName);
		box.add(panelN);
		
		panelL.add(likelihood);
		panelL.add(txtLikelihood);
		box.add(panelL);
		
		panelS.add(severity);
		panelS.add(txtSeverity);
		box.add(panelS);
		
		panelP.add(prerequisites);
		panelP.add(txtPrerequisites);
		box.add(panelP);
		
		panelM.add(mitigations);
		panelM.add(txtMitigations);
		box.add(panelM);		
		
		panelW.add(weaknesses);
		panelW.add(txtWeaknesses);
		box.add(panelW);	
		
		JButton add=new JButton("Add");
		box.add(add);
		JLabel jer=new JLabel("The attack already exists!");
		jer.setForeground(Color.RED);
		jer.setVisible(false);
		box.add(jer);
		
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				id.setForeground(Color.BLACK);
				name.setForeground(Color.BLACK);
				
					jer.setVisible(false);				
					if(!txtId.getText().trim().equals("") && !txtName.getText().trim().equals("")) {
						
						GetAttack ga=new GetAttack();
						if((ga.GetAttackByName(txtName.getText())).getName()!=null) {
							jer.setVisible(true);
							return;
						}
						Attack a=new Attack();
						a.setId(txtId.getText());
						a.setName(txtName.getText());
						a.setLikelihood(txtLikelihood.getSelectedItem().toString());
						a.setSeverity(txtSeverity.getSelectedItem().toString());
						a.setMitigations(txtMitigations.getText());
						a.setPrerequisites(txtPrerequisites.getText());
						a.setWeaknesses(txtWeaknesses.getText());
						txtId.setText("");
						txtName.setText("");
						txtMitigations.setText("");
						txtPrerequisites.setText("");
						txtWeaknesses.setText("");
						txtLikelihood = new JComboBox<String>();
						txtSeverity = new JComboBox<String>();
						
						AtteckInsert ai=new AtteckInsert();
						ai.AddAttack(a);
						dispose();
					}else {
						if(txtId.getText().trim().equals(""))
							id.setForeground(Color.RED);
						if(txtName.getText().trim().equals(""))
							name.setForeground(Color.RED);				
					}
				
				return;
			}
		});
		
}}