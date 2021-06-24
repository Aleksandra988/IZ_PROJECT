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

import rs.ac.uns.ftn.projekat.database.GetAttack;
import rs.ac.uns.ftn.projekat.database.UpdateAttack;
import rs.ac.uns.ftn.projekat.model.Attack;

public class EditAttack extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static JTextField txtName = new JTextField();
	static JTextField txtPrerequisites = new JTextField();
	static JTextField txtMitigations= new JTextField();
	static JTextField txtWeaknesses=new JTextField();
	static JComboBox<String> txtLikelihood=new JComboBox<String>();
	static JComboBox<String> txtSeverity=new JComboBox<String>();
	
	

	public EditAttack(Attack attack) {
		

		txtName.setText(attack.getName());
		txtMitigations.setText(attack.getMitigations());
		txtPrerequisites.setText(attack.getPrerequisites());
		txtWeaknesses.setText(attack.getWeaknesses());
		
		txtName.setPreferredSize(new Dimension(200,20));
		txtLikelihood.setPreferredSize(new Dimension(160,20));
		txtSeverity.setPreferredSize(new Dimension(160,20));
		txtPrerequisites.setPreferredSize(new Dimension(200,20));
		txtMitigations.setPreferredSize(new Dimension(200,20));
		txtWeaknesses.setPreferredSize(new Dimension(200,20));

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
		
		if(attack.getLikelihood().equals("None"))
			txtLikelihood.setSelectedIndex(0);
		else if(attack.getLikelihood().equals("Low"))
			txtLikelihood.setSelectedIndex(1);
		else if(attack.getLikelihood().equals("Medium"))
			txtLikelihood.setSelectedIndex(2);
		else if(attack.getLikelihood().equals("High"))
			txtLikelihood.setSelectedIndex(3);
		else
			txtLikelihood.setSelectedIndex(4);
		
		if(attack.getSeverity().equals("None"))
			txtSeverity.setSelectedIndex(0);
		else if(attack.getSeverity().equals("Low"))
			txtSeverity.setSelectedIndex(1);
		else if(attack.getSeverity().equals("Medium"))
			txtSeverity.setSelectedIndex(2);
		else if(attack.getSeverity().equals("High"))
			txtSeverity.setSelectedIndex(3);
		else
			txtSeverity.setSelectedIndex(4);
		
		setBackground(Color.GREEN);
		setModal(true);
		setTitle("Edit attack");
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double height=screenSize.getHeight();
		double width=screenSize.getWidth();
		height=height*0.7;
		width=width*0.3;
		setBounds(150, 150, (int)width, (int)height);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JLabel name = new JLabel("Name*");
		JLabel likelihood = new JLabel("Likelihood");
		JLabel severity = new JLabel("Severity");
		JLabel prerequisites = new JLabel("Prerequisites");
		JLabel mitigations = new JLabel("Mitigations");
		JLabel weaknesses = new JLabel("Weaknesses");
		
		JPanel panelN = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelL = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelS = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelM = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelW = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		
		
		
		Box box=Box.createVerticalBox();
		this.add(box,BorderLayout.CENTER);
		
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

		JPanel btn= new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton no=new JButton("Cancel");
		btn.add(no);
		JButton ed=new JButton("Edit");
		btn.add(ed);
		box.add(btn);

		JLabel jer=new JLabel("The attack already exists!");
		jer.setForeground(Color.RED);
		jer.setVisible(false);
		box.add(jer);
		
		ed.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!txtName.getText().equals(attack.getName())) {
					GetAttack ga=new GetAttack();
					if((ga.GetAttackByName(txtName.getText())).getName()!=null) {
						jer.setVisible(true);
						return;
					}
				}
				if(!txtName.getText().trim().equals("")) {
					name.setForeground(Color.RED);
					Attack a=new Attack();
					a.setId(attack.getId());
					a.setName(txtName.getText());
					a.setLikelihood(txtLikelihood.getSelectedItem().toString());
					a.setSeverity(txtSeverity.getSelectedItem().toString());
					a.setMitigations(txtMitigations.getText());
					a.setPrerequisites(txtPrerequisites.getText());
					a.setWeaknesses(txtWeaknesses.getText());
					UpdateAttack ua=new UpdateAttack();
					ua.Update(attack,a);
					
					dispose();
					return;
				}else {
					name.setForeground(Color.RED);
				}
			}
		});
		
		no.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				return;
			}
		});
		
}}