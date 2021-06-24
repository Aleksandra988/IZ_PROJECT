package rs.ac.uns.ftn.projekat.dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import rs.ac.uns.ftn.projekat.database.UpdateAttack;
import rs.ac.uns.ftn.projekat.model.Attack;
import unbbayes.prs.Node;
import unbbayes.prs.bn.JunctionTreeAlgorithm;
import unbbayes.prs.bn.PotentialTable;
import unbbayes.prs.bn.ProbabilisticNetwork;
import unbbayes.prs.bn.ProbabilisticNode;
import unbbayes.util.extension.bn.inference.IInferenceAlgorithm;
import unbbayes.io.BaseIO;
import unbbayes.io.NetIO;
import unbbayes.io.exception.LoadException;
import unbbayes.prs.bn.ProbabilisticNetwork;

import javax.swing.JRadioButton;

public class BayesDialog extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		static JRadioButton vulnerable_functions = new JRadioButton("Vulnerable functions");
		static JRadioButton scrubbing_of_sensitive_data = new JRadioButton("Scrubbing of sensitive data");
		static JRadioButton authorization = new JRadioButton("Authorization");
		static JRadioButton encryption = new JRadioButton("Encryption");
		static JRadioButton zeroization_of_hardware_register = new JRadioButton("Zeroization of hardware register");
		static JRadioButton interacting_with_system = new JRadioButton("Interacting with system");
		static JRadioButton authentication = new JRadioButton("Authentication");
		static JRadioButton permission_assignment_for_critical_resource = new JRadioButton("Permission assignment for critical resource");
		static JRadioButton code_book = new JRadioButton("Code book");
		static JRadioButton input_validationl = new JRadioButton("Input validation");
		static JRadioButton covert_timing_channel = new JRadioButton("Covert timing channel");
		static JRadioButton forgery_protection = new JRadioButton("Forgery protection");
		static JRadioButton  likelihood = new JRadioButton("Likelihood");
		static JRadioButton  typical_severity = new JRadioButton("Typical severity");
		static JRadioButton  code_obfuscation_techniques = new JRadioButton("Code obfuscation techniques");
		static JRadioButton  white_box_analysis_techniques = new JRadioButton("White box analysis techniques");
		static JRadioButton  black_box_analysis_techniques = new JRadioButton("Black box analysis techniques");
		static JRadioButton  communication_paths = new JRadioButton("Communication paths");
		static JRadioButton  configuration = new JRadioButton("Configuration");
		static JRadioButton  privilege_management = new JRadioButton("Privilege management");
		static JRadioButton  security_checks = new JRadioButton("Security checks");
		static JRadioButton  signal_level_alerts = new JRadioButton("Signal level alerts");
		static JRadioButton  server_version = new JRadioButton("Server version");
		static JRadioButton  hardware = new JRadioButton("Hardware");
		static JRadioButton  expiration = new JRadioButton("Expiration");
		static JRadioButton  password_policy = new JRadioButton("Password policy");
		
	static JComboBox<String> jb_vulnerable_functions=new JComboBox<String>();
	static JComboBox<String> jb_scrubbing_of_sensitive_data=new JComboBox<String>();
	static JComboBox<String> jb_authorization=new JComboBox<String>();
	static JComboBox<String> jb_encryption=new JComboBox<String>();
	static JComboBox<String> jb_zeroization_of_hardware_register=new JComboBox<String>();
	static JComboBox<String> jb_interacting_with_system=new JComboBox<String>();
	static JComboBox<String> jb_authentication=new JComboBox<String>();
	static JComboBox<String> jb_permission_assignment_for_critical_resource=new JComboBox<String>();
	static JComboBox<String> jb_code_book=new JComboBox<String>();
	static JComboBox<String> jb_input_validation=new JComboBox<String>();
	static JComboBox<String> jb_covert_timing_channel=new JComboBox<String>();
	static JComboBox<String> jb_forgery_protection=new JComboBox<String>();
	static JComboBox<String> jb_likelihood=new JComboBox<String>();
	static JComboBox<String> jb_typical_severity=new JComboBox<String>();
	static JComboBox<String> jb_code_obfuscation_techniques=new JComboBox<String>();
	static JComboBox<String> jb_white_box_analysis_techniques=new JComboBox<String>();
	static JComboBox<String> jb_black_box_analysis_techniques=new JComboBox<String>();
	static JComboBox<String> jb_communication_paths=new JComboBox<String>();
	static JComboBox<String> jb_configuration=new JComboBox<String>();
	static JComboBox<String> jb_privilege_management=new JComboBox<String>();
	static JComboBox<String> jb_security_checks=new JComboBox<String>();
	static JComboBox<String> jb_signal_level_alerts=new JComboBox<String>();
	static JComboBox<String> jb_server_version=new JComboBox<String>();
	static JComboBox<String> jb_hardware=new JComboBox<String>();
	static JComboBox<String> jb_expiration=new JComboBox<String>();
	static JComboBox<String> jb_password_policy=new JComboBox<String>();
	
	static ProbabilisticNetwork net;
	static IInferenceAlgorithm algorithm = new JunctionTreeAlgorithm();
	static List<Node> nodeList;
	
	static JLabel res=new JLabel();
	public BayesDialog() throws LoadException, IOException {
		
			BaseIO io = new NetIO();
			net= (ProbabilisticNetwork)io.load(new File("bayes.net"));
		 	algorithm.setNetwork(net);
			algorithm.run();			
			nodeList = net.getNodes();
			
		///
		
		setBackground(Color.GREEN);
		setModal(true);
		setTitle("Incident classification");
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double height=screenSize.getHeight();
		double width=screenSize.getWidth();
		height=height*0.85;
		width=width*0.3;
		setBounds(150, 150, (int)width, (int)height);
		setLocationRelativeTo(null);

		Box box=Box.createVerticalBox();
		this.add(box,BorderLayout.CENTER);
		
		Box box1=Box.createHorizontalBox();
		jb_vulnerable_functions.addItem("Exposed");
		jb_vulnerable_functions.addItem("Not exposed");
		jb_vulnerable_functions.setMaximumSize(jb_vulnerable_functions.getPreferredSize());
		jb_vulnerable_functions.setEnabled(false);
		box1.add(vulnerable_functions);
		box1.add(jb_vulnerable_functions);
		box1.setAlignmentX(LEFT_ALIGNMENT);
		box.add(box1);

		Box box2=Box.createHorizontalBox();
		jb_scrubbing_of_sensitive_data.addItem("Yes");
		jb_scrubbing_of_sensitive_data.addItem("No");
		jb_scrubbing_of_sensitive_data.setMaximumSize(jb_scrubbing_of_sensitive_data.getPreferredSize());
		jb_scrubbing_of_sensitive_data.setEnabled(false);
		box2.add(scrubbing_of_sensitive_data);
		box2.add(jb_scrubbing_of_sensitive_data);
		box2.setAlignmentX(LEFT_ALIGNMENT);
		box.add(box2);
		
		Box box33=Box.createHorizontalBox();
		jb_authorization.addItem("Proper");
		jb_authorization.addItem("Improper");
		jb_authorization.setMaximumSize(jb_authorization.getPreferredSize());
		jb_authorization.setEnabled(false);
		box33.add(authorization);
		box33.add(jb_authorization);
		box33.setAlignmentX(LEFT_ALIGNMENT);
		box.add(box33);
		
		Box box3=Box.createHorizontalBox();
		jb_encryption.addItem("Yes");
		jb_encryption.addItem("No");
		jb_encryption.setMaximumSize(jb_encryption.getPreferredSize());
		jb_encryption.setEnabled(false);
		box3.add(encryption);
		box3.add(jb_encryption);
		box3.setAlignmentX(LEFT_ALIGNMENT);
		box.add(box3);
			
		Box box34=Box.createHorizontalBox();
		jb_zeroization_of_hardware_register.addItem("Proper");
		jb_zeroization_of_hardware_register.addItem("Improper");
		jb_zeroization_of_hardware_register.setMaximumSize(jb_zeroization_of_hardware_register.getPreferredSize());
		jb_zeroization_of_hardware_register.setEnabled(false);
		box34.add(zeroization_of_hardware_register);
		box34.add(jb_zeroization_of_hardware_register);
		box34.setAlignmentX(LEFT_ALIGNMENT);
		box.add(box34);
		
		Box box4=Box.createHorizontalBox();
		jb_interacting_with_system.addItem("Yes");
		jb_interacting_with_system.addItem("No");
		jb_interacting_with_system.setMaximumSize(jb_interacting_with_system.getPreferredSize());
		jb_interacting_with_system.setEnabled(false);
		box4.add(interacting_with_system);
		box4.add(jb_interacting_with_system);
		box4.setAlignmentX(LEFT_ALIGNMENT);
		box.add(box4);
			
		Box box35=Box.createHorizontalBox();
		jb_authentication.addItem("Proper");
		jb_authentication.addItem("Improper");
		jb_authentication.setMaximumSize(jb_authentication.getPreferredSize());
		jb_authentication.setEnabled(false);
		box35.add(authentication);
		box35.add(jb_authentication);
		box35.setAlignmentX(LEFT_ALIGNMENT);
		box.add(box35);
			
		Box box55=Box.createHorizontalBox();
		jb_permission_assignment_for_critical_resource.addItem("Correct");
		jb_permission_assignment_for_critical_resource.addItem("Incorrect");
		jb_permission_assignment_for_critical_resource.setMaximumSize(jb_permission_assignment_for_critical_resource.getPreferredSize());
		jb_permission_assignment_for_critical_resource.setEnabled(false);
		box55.add(permission_assignment_for_critical_resource);
		box55.add(jb_permission_assignment_for_critical_resource);
		box55.setAlignmentX(LEFT_ALIGNMENT);
		box.add(box55);
		
		Box box66=Box.createHorizontalBox();
		jb_code_book.addItem("In use");
		jb_code_book.addItem("Not in use");
		jb_code_book.setMaximumSize(jb_code_book.getPreferredSize());
		jb_code_book.setEnabled(false);
		box66.add(code_book);
		box66.add(jb_code_book);
		box66.setAlignmentX(LEFT_ALIGNMENT);
		box.add(box66);

		Box box36=Box.createHorizontalBox();
		jb_input_validation.addItem("Proper");
		jb_input_validation.addItem("Improper");
		jb_input_validation.setMaximumSize(jb_input_validation.getPreferredSize());
		jb_input_validation.setEnabled(false);
		box36.add(input_validationl);
		box36.add(jb_input_validation);
		box36.setAlignmentX(LEFT_ALIGNMENT);
		box.add(box36);
		
		Box box67=Box.createHorizontalBox();
		jb_covert_timing_channel.addItem("In use");
		jb_covert_timing_channel.addItem("Not in use");
		jb_covert_timing_channel.setMaximumSize(jb_covert_timing_channel.getPreferredSize());
		jb_covert_timing_channel.setEnabled(false);
		box67.add(covert_timing_channel);
		box67.add(jb_covert_timing_channel);
		box67.setAlignmentX(LEFT_ALIGNMENT);
		box.add(box67);

		Box box77=Box.createHorizontalBox();
		jb_forgery_protection.addItem("Exist");
		jb_forgery_protection.addItem("Not exist");
		jb_forgery_protection.setMaximumSize(jb_forgery_protection.getPreferredSize());
		jb_forgery_protection.setEnabled(false);
		box77.add(forgery_protection);
		box77.add(jb_forgery_protection);
		box77.setAlignmentX(LEFT_ALIGNMENT);
		box.add(box77);
		
		Box box88=Box.createHorizontalBox();
		jb_likelihood.addItem("Low");
		jb_likelihood.addItem("Medium");
		jb_likelihood.addItem("High");
		jb_likelihood.addItem("Very_high");
		jb_likelihood.setMaximumSize(jb_likelihood.getPreferredSize());
		jb_likelihood.setEnabled(false);
		box88.add(likelihood);
		box88.add(jb_likelihood);
		box88.setAlignmentX(LEFT_ALIGNMENT);
		box.add(box88);

		Box box89=Box.createHorizontalBox();
		jb_typical_severity.addItem("Low");
		jb_typical_severity.addItem("Medium");
		jb_typical_severity.addItem("High");
		jb_typical_severity.addItem("Very_high");
		jb_typical_severity.setMaximumSize(jb_typical_severity.getPreferredSize());
		jb_typical_severity.setEnabled(false);
		box89.add(typical_severity);
		box89.add(jb_typical_severity);
		box89.setAlignmentX(LEFT_ALIGNMENT);
		box.add(box89);
		
		Box box68=Box.createHorizontalBox();
		jb_code_obfuscation_techniques.addItem("In use");
		jb_code_obfuscation_techniques.addItem("Not in use");
		jb_code_obfuscation_techniques.setMaximumSize(jb_code_obfuscation_techniques.getPreferredSize());
		jb_code_obfuscation_techniques.setEnabled(false);
		box68.add(code_obfuscation_techniques);
		box68.add(jb_code_obfuscation_techniques);
		box68.setAlignmentX(LEFT_ALIGNMENT);
		box.add(box68);
		
		Box box5=Box.createHorizontalBox();
		jb_white_box_analysis_techniques.addItem("Yes");
		jb_white_box_analysis_techniques.addItem("No");
		jb_white_box_analysis_techniques.setMaximumSize(jb_white_box_analysis_techniques.getPreferredSize());
		jb_white_box_analysis_techniques.setEnabled(false);
		box5.add(white_box_analysis_techniques);
		box5.add(jb_white_box_analysis_techniques);
		box5.setAlignmentX(LEFT_ALIGNMENT);
		box.add(box5);
			
		Box box6=Box.createHorizontalBox();
		jb_black_box_analysis_techniques.addItem("Yes");
		jb_black_box_analysis_techniques.addItem("No");
		jb_black_box_analysis_techniques.setMaximumSize(jb_black_box_analysis_techniques.getPreferredSize());
		jb_black_box_analysis_techniques.setEnabled(false);
		box6.add(black_box_analysis_techniques);
		box6.add(jb_black_box_analysis_techniques);
		box6.setAlignmentX(LEFT_ALIGNMENT);
		box.add(box6);
		
		Box box99=Box.createHorizontalBox();
		jb_communication_paths.addItem("Trusted");
		jb_communication_paths.addItem("Untrusted");
		jb_communication_paths.setMaximumSize(jb_communication_paths.getPreferredSize());
		jb_communication_paths.setEnabled(false);
		box99.add(communication_paths);
		box99.add(jb_communication_paths);
		box99.setAlignmentX(LEFT_ALIGNMENT);
		box.add(box99);

		Box box100=Box.createHorizontalBox();
		jb_configuration.addItem("Good");
		jb_configuration.addItem("Bad");
		jb_configuration.setMaximumSize(jb_configuration.getPreferredSize());
		jb_configuration.setEnabled(false);
		box100.add(configuration);
		box100.add(jb_configuration);
		box100.setAlignmentX(LEFT_ALIGNMENT);
		box.add(box100);
		
		Box box37=Box.createHorizontalBox();
		jb_privilege_management.addItem("Proper");
		jb_privilege_management.addItem("Improper");
		jb_privilege_management.setMaximumSize(jb_privilege_management.getPreferredSize());
		jb_privilege_management.setEnabled(false);
		box37.add(privilege_management);
		box37.add(jb_privilege_management);
		box37.setAlignmentX(LEFT_ALIGNMENT);
		box.add(box37);
				
		Box box7=Box.createHorizontalBox();
		jb_security_checks.addItem("Yes");
		jb_security_checks.addItem("No");
		jb_security_checks.setMaximumSize(jb_security_checks.getPreferredSize());
		jb_security_checks.setEnabled(false);
		box7.add(security_checks);
		box7.add(jb_security_checks);
		box7.setAlignmentX(LEFT_ALIGNMENT);
		box.add(box7);
		
		Box box8=Box.createHorizontalBox();
		jb_signal_level_alerts.addItem("Yes");
		jb_signal_level_alerts.addItem("No");
		jb_signal_level_alerts.setMaximumSize(jb_signal_level_alerts.getPreferredSize());
		jb_signal_level_alerts.setEnabled(false);
		box8.add(signal_level_alerts);
		box8.add(jb_signal_level_alerts);
		box8.setAlignmentX(LEFT_ALIGNMENT);
		box.add(box8);
		
		Box box22=Box.createHorizontalBox();
		jb_server_version.addItem("New");
		jb_server_version.addItem("Old");
		jb_server_version.setMaximumSize(jb_server_version.getPreferredSize());
		jb_server_version.setEnabled(false);
		box22.add(server_version);
		box22.add(jb_server_version);
		box22.setAlignmentX(LEFT_ALIGNMENT);
		box.add(box22);
		
		Box box91=Box.createHorizontalBox();
		jb_hardware.addItem("Trusted");
		jb_hardware.addItem("Untrusted");
		jb_hardware.setMaximumSize(jb_hardware.getPreferredSize());
		jb_hardware.setEnabled(false);
		box91.add(hardware);
		box91.add(jb_hardware);
		box91.setAlignmentX(LEFT_ALIGNMENT);
		box.add(box91);

		Box box23=Box.createHorizontalBox();
		jb_expiration.addItem("New");
		jb_expiration.addItem("Old");
		jb_expiration.setMaximumSize(jb_expiration.getPreferredSize());
		jb_expiration.setEnabled(false);
		box23.add(expiration);
		box23.add(jb_expiration);
		box23.setAlignmentX(LEFT_ALIGNMENT);
		box.add(box23);

		Box box11=Box.createHorizontalBox();
		jb_password_policy.addItem("Strong");
		jb_password_policy.addItem("Week");
		jb_password_policy.setMaximumSize(jb_password_policy.getPreferredSize());
		jb_password_policy.setEnabled(false);
		box11.add(password_policy);
		box11.add(jb_password_policy);
		box11.setAlignmentX(LEFT_ALIGNMENT);
		box.add(box11);
		
		
		JButton btn1 = new JButton("Find");
		box.add(btn1);
		box.add(res);
		
		btn1.addActionListener(new ActionListener() {

			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Boolean selected=false;
				List<Node> properties=new ArrayList();
				
				if(vulnerable_functions.isSelected()) {
					ProbabilisticNode factNode = (ProbabilisticNode)net.getNode("Vulnerable_functions");
					factNode.addFinding(jb_vulnerable_functions.getSelectedIndex());
					selected=true;
				}
				properties.add(net.getNode("Vulnerable_functions"));
				
				if(scrubbing_of_sensitive_data.isSelected()) {
					ProbabilisticNode factNode = (ProbabilisticNode)net.getNode("Scrubbing_of_sensitive_data");
					factNode.addFinding(jb_scrubbing_of_sensitive_data.getSelectedIndex());
					selected=true;
				}
				properties.add(net.getNode("Scrubbing_of_sensitive_data"));
				
				if(authorization.isSelected()) {
					ProbabilisticNode factNode = (ProbabilisticNode)net.getNode("Authorization");
					factNode.addFinding(jb_authorization.getSelectedIndex());
					selected=true;
				}
				properties.add(net.getNode("Authorization"));
				
				if(encryption.isSelected()) {
					ProbabilisticNode factNode = (ProbabilisticNode)net.getNode("Encryption");
					factNode.addFinding(jb_encryption.getSelectedIndex());
					selected=true;
				}
				properties.add(net.getNode("Encryption"));
				
				if(zeroization_of_hardware_register.isSelected()) {
					ProbabilisticNode factNode = (ProbabilisticNode)net.getNode("Zeroization_of_hardware_register");
					factNode.addFinding(jb_zeroization_of_hardware_register.getSelectedIndex());
					selected=true;
				}
				properties.add(net.getNode("Zeroization_of_hardware_register"));

				if(interacting_with_system.isSelected()) {
					ProbabilisticNode factNode = (ProbabilisticNode)net.getNode("Interacting_with_system");
					factNode.addFinding(jb_interacting_with_system.getSelectedIndex());
					selected=true;
				}
				properties.add(net.getNode("Interacting_with_system"));

				if(authentication.isSelected()) {
					ProbabilisticNode factNode = (ProbabilisticNode)net.getNode("Authentication");
					factNode.addFinding(jb_authentication.getSelectedIndex());
					selected=true;
				}
				properties.add(net.getNode("Authentication"));

				if(permission_assignment_for_critical_resource.isSelected()) {
					ProbabilisticNode factNode = (ProbabilisticNode)net.getNode("Permission_assignment_for_critical_resource");
					factNode.addFinding(jb_permission_assignment_for_critical_resource.getSelectedIndex());
					selected=true;
				}
				properties.add(net.getNode("Permission_assignment_for_critical_resource"));
				
				if(code_book.isSelected()) {
					ProbabilisticNode factNode = (ProbabilisticNode)net.getNode("Code_book");
					factNode.addFinding(jb_code_book.getSelectedIndex());
					selected=true;
				}
				properties.add(net.getNode("Code_book"));

				if(input_validationl.isSelected()) {
					ProbabilisticNode factNode = (ProbabilisticNode)net.getNode("Input_validation");
					factNode.addFinding(jb_input_validation.getSelectedIndex());
					selected=true;
				}
				properties.add(net.getNode("Input_validation"));

				if(covert_timing_channel.isSelected()) {
					ProbabilisticNode factNode = (ProbabilisticNode)net.getNode("Covert_timing_channel");
					factNode.addFinding(jb_covert_timing_channel.getSelectedIndex());
					selected=true;
				}
				properties.add(net.getNode("Covert_timing_channel"));

				if(forgery_protection.isSelected()) {
					ProbabilisticNode factNode = (ProbabilisticNode)net.getNode("Forgery_protection");
					factNode.addFinding(jb_forgery_protection.getSelectedIndex());
					selected=true;
				}
				properties.add(net.getNode("Forgery_protection"));

				if(likelihood.isSelected()) {
					ProbabilisticNode factNode = (ProbabilisticNode)net.getNode("Likelihood");
					factNode.addFinding(jb_likelihood.getSelectedIndex());
					selected=true;
				}
				properties.add(net.getNode("Likelihood"));

				if(typical_severity.isSelected()) {
					ProbabilisticNode factNode = (ProbabilisticNode)net.getNode("Typical_severity");
					factNode.addFinding(jb_typical_severity.getSelectedIndex());
					selected=true;
				}
				properties.add(net.getNode("Typical_severity"));

				if(code_obfuscation_techniques.isSelected()) {
					ProbabilisticNode factNode = (ProbabilisticNode)net.getNode("Code_obfuscation_techniques");
					factNode.addFinding(jb_code_obfuscation_techniques.getSelectedIndex());
					selected=true;
				}
				properties.add(net.getNode("Code_obfuscation_techniques"));

				if(white_box_analysis_techniques.isSelected()) {
					ProbabilisticNode factNode = (ProbabilisticNode)net.getNode("White_box_analysis_techniques");
					factNode.addFinding(jb_white_box_analysis_techniques.getSelectedIndex());
					selected=true;
				}
				properties.add(net.getNode("White_box_analysis_techniques"));

				if(black_box_analysis_techniques.isSelected()) {
					ProbabilisticNode factNode = (ProbabilisticNode)net.getNode("Black_box_analysis_techniques");
					factNode.addFinding(jb_black_box_analysis_techniques.getSelectedIndex());
					selected=true;
				}
				properties.add(net.getNode("Black_box_analysis_techniques"));

				if(communication_paths.isSelected()) {
					ProbabilisticNode factNode = (ProbabilisticNode)net.getNode("Communication_paths");
					factNode.addFinding(jb_communication_paths.getSelectedIndex());
					selected=true;
				}
				properties.add(net.getNode("Communication_paths"));

				if(configuration.isSelected()) {
					ProbabilisticNode factNode = (ProbabilisticNode)net.getNode("Configuration");
					factNode.addFinding(jb_configuration.getSelectedIndex());
					selected=true;
				}
				properties.add(net.getNode("Configuration"));

				if(privilege_management.isSelected()) {
					ProbabilisticNode factNode = (ProbabilisticNode)net.getNode("Privilege_management");
					factNode.addFinding(jb_privilege_management.getSelectedIndex());
					selected=true;
				}
				properties.add(net.getNode("Privilege_management"));

				if(security_checks.isSelected()) {
					ProbabilisticNode factNode = (ProbabilisticNode)net.getNode("Security_checks");
					factNode.addFinding(jb_security_checks.getSelectedIndex());
					selected=true;
				}
				properties.add(net.getNode("Security_checks"));

				if(signal_level_alerts.isSelected()) {
					ProbabilisticNode factNode = (ProbabilisticNode)net.getNode("Signal_level_alerts");
					factNode.addFinding(jb_signal_level_alerts.getSelectedIndex());
					selected=true;
				}
				properties.add(net.getNode("Signal_level_alerts"));

				if(server_version.isSelected()) {
					ProbabilisticNode factNode = (ProbabilisticNode)net.getNode("Server_version");
					factNode.addFinding(jb_server_version.getSelectedIndex());
					selected=true;
				}
				properties.add(net.getNode("Server_version"));
				
				if(hardware.isSelected()) {
					ProbabilisticNode factNode = (ProbabilisticNode)net.getNode("Hardware");
					factNode.addFinding(jb_hardware.getSelectedIndex());
					selected=true;
				}
				properties.add(net.getNode("Hardware"));

				if(expiration.isSelected()) {
					ProbabilisticNode factNode = (ProbabilisticNode)net.getNode("Expiration");
					factNode.addFinding(jb_expiration.getSelectedIndex());
					selected=true;
				}
				properties.add(net.getNode("Expiration"));

				if(password_policy.isSelected()) {
					ProbabilisticNode factNode = (ProbabilisticNode)net.getNode("Password_policy");
					factNode.addFinding(jb_password_policy.getSelectedIndex());
					selected=true;
				}
				properties.add(net.getNode("Password_policy"));
				properties.add(net.getNode("Sensitive_information"));
				
				try {
					res.setText("");
					if(selected) {
			        	net.updateEvidences();
			        	
			        	Node best=null;
			        	for (Node node : nodeList) {
			    			if(!properties.contains(node)) {
			    				if(best==null)
			    					best=node;
			    				if(((ProbabilisticNode)node).getMarginalAt(1)>((ProbabilisticNode)best).getMarginalAt(1))
			    					best=node;
			    			}
			    		}
			        	res.setText(best.getName());
					}
		        } catch (Exception es) {
		        	System.out.println(es.getMessage());               	
		        }
			}
		});
		
		authentication.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jb_authentication.setEnabled(authentication.isSelected());
			}
		});	
		
		authorization.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jb_authorization.setEnabled(authorization.isSelected());
			}
		});	

		black_box_analysis_techniques.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				jb_black_box_analysis_techniques.setEnabled(black_box_analysis_techniques.isSelected());
			}
		});

		
		code_book.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				jb_code_book.setEnabled(code_book.isSelected());
			}
		});	
		
		code_obfuscation_techniques.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				jb_code_obfuscation_techniques.setEnabled(code_obfuscation_techniques.isSelected());
			}
		});	
		
		communication_paths.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				jb_communication_paths.setEnabled(communication_paths.isSelected());
			}
		});	
		
		configuration.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				jb_configuration.setEnabled(configuration.isSelected());
			}
		});

		
		covert_timing_channel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				jb_covert_timing_channel.setEnabled(covert_timing_channel.isSelected());
			}
		});	
		
		encryption.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				jb_encryption.setEnabled(encryption.isSelected());
			}
		});	
		
		expiration.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				jb_expiration.setEnabled(expiration.isSelected());
			}
		});	
		
		forgery_protection.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				jb_forgery_protection.setEnabled(forgery_protection.isSelected());
			}
		});	
		
		hardware.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				jb_hardware.setEnabled(hardware.isSelected());
			}
		});	
		
		input_validationl.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				jb_input_validation.setEnabled(input_validationl.isSelected());
			}
		});	
		
		interacting_with_system.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				jb_interacting_with_system.setEnabled(interacting_with_system.isSelected());
			}
		});	
		
		likelihood.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				jb_likelihood.setEnabled(likelihood.isSelected());
			}
		});	
		
		password_policy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				jb_password_policy.setEnabled(password_policy.isSelected());
			}
		});	
		
		permission_assignment_for_critical_resource.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				jb_permission_assignment_for_critical_resource.setEnabled(permission_assignment_for_critical_resource.isSelected());
			}
		});	
		
		privilege_management.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				jb_privilege_management.setEnabled(privilege_management.isSelected());
			}
		});	
		
		scrubbing_of_sensitive_data.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				jb_scrubbing_of_sensitive_data.setEnabled(scrubbing_of_sensitive_data.isSelected());
			}
		});	
		
		security_checks.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				jb_security_checks.setEnabled(security_checks.isSelected());
			}
		});	
		
		server_version.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				jb_server_version.setEnabled(server_version.isSelected());
			}
		});	
		
		signal_level_alerts.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				jb_signal_level_alerts.setEnabled(signal_level_alerts.isSelected());
			}
		});	
		
		typical_severity.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				jb_typical_severity.setEnabled(typical_severity.isSelected());
			}
		});	
		
		vulnerable_functions.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				jb_vulnerable_functions.setEnabled(vulnerable_functions.isSelected());
			}
		});	
		
		white_box_analysis_techniques.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				jb_white_box_analysis_techniques.setEnabled(white_box_analysis_techniques.isSelected());
			}
		});	
		
		zeroization_of_hardware_register.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				jb_zeroization_of_hardware_register.setEnabled(zeroization_of_hardware_register.isSelected());
			}
		});	
	}

}