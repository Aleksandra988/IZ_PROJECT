package rs.ac.uns.ftn.projekat.dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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
	
	
	

	public BayesDialog() {
		
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
		box1.add(vulnerable_functions);
		box1.add(jb_vulnerable_functions);
		box1.setAlignmentX(LEFT_ALIGNMENT);
		box.add(box1);

		Box box2=Box.createHorizontalBox();
		jb_scrubbing_of_sensitive_data.addItem("Yes");
		jb_scrubbing_of_sensitive_data.addItem("No");
		jb_scrubbing_of_sensitive_data.setMaximumSize(jb_scrubbing_of_sensitive_data.getPreferredSize());
		box2.add(scrubbing_of_sensitive_data);
		box2.add(jb_scrubbing_of_sensitive_data);
		box2.setAlignmentX(LEFT_ALIGNMENT);
		box.add(box2);
		
		Box box33=Box.createHorizontalBox();
		jb_authorization.addItem("Proper");
		jb_authorization.addItem("Improper");
		jb_authorization.setMaximumSize(jb_authorization.getPreferredSize());
		box33.add(authorization);
		box33.add(jb_authorization);
		box33.setAlignmentX(LEFT_ALIGNMENT);
		box.add(box33);
		
		Box box3=Box.createHorizontalBox();
		jb_encryption.addItem("Yes");
		jb_encryption.addItem("No");
		jb_encryption.setMaximumSize(jb_encryption.getPreferredSize());
		box3.add(encryption);
		box3.add(jb_encryption);
		box3.setAlignmentX(LEFT_ALIGNMENT);
		box.add(box3);
			
		Box box34=Box.createHorizontalBox();
		jb_zeroization_of_hardware_register.addItem("Proper");
		jb_zeroization_of_hardware_register.addItem("Improper");
		jb_zeroization_of_hardware_register.setMaximumSize(jb_zeroization_of_hardware_register.getPreferredSize());
		box34.add(zeroization_of_hardware_register);
		box34.add(jb_zeroization_of_hardware_register);
		box34.setAlignmentX(LEFT_ALIGNMENT);
		box.add(box34);
		
		Box box4=Box.createHorizontalBox();
		jb_interacting_with_system.addItem("Yes");
		jb_interacting_with_system.addItem("No");
		jb_interacting_with_system.setMaximumSize(jb_interacting_with_system.getPreferredSize());
		box4.add(interacting_with_system);
		box4.add(jb_interacting_with_system);
		box4.setAlignmentX(LEFT_ALIGNMENT);
		box.add(box4);
			
		Box box35=Box.createHorizontalBox();
		jb_authentication.addItem("Proper");
		jb_authentication.addItem("Improper");
		jb_authentication.setMaximumSize(jb_authentication.getPreferredSize());
		box35.add(authentication);
		box35.add(jb_authentication);
		box35.setAlignmentX(LEFT_ALIGNMENT);
		box.add(box35);
			
		Box box55=Box.createHorizontalBox();
		jb_permission_assignment_for_critical_resource.addItem("Correct");
		jb_permission_assignment_for_critical_resource.addItem("Incorrect");
		jb_permission_assignment_for_critical_resource.setMaximumSize(jb_permission_assignment_for_critical_resource.getPreferredSize());
		box55.add(permission_assignment_for_critical_resource);
		box55.add(jb_permission_assignment_for_critical_resource);
		box55.setAlignmentX(LEFT_ALIGNMENT);
		box.add(box55);
		
		Box box66=Box.createHorizontalBox();
		jb_code_book.addItem("In use");
		jb_code_book.addItem("Not in use");
		jb_code_book.setMaximumSize(jb_code_book.getPreferredSize());
		box66.add(code_book);
		box66.add(jb_code_book);
		box66.setAlignmentX(LEFT_ALIGNMENT);
		box.add(box66);

		Box box36=Box.createHorizontalBox();
		jb_input_validation.addItem("Proper");
		jb_input_validation.addItem("Improper");
		jb_input_validation.setMaximumSize(jb_input_validation.getPreferredSize());
		box36.add(input_validationl);
		box36.add(jb_input_validation);
		box36.setAlignmentX(LEFT_ALIGNMENT);
		box.add(box36);
		
		Box box67=Box.createHorizontalBox();
		jb_covert_timing_channel.addItem("In use");
		jb_covert_timing_channel.addItem("Not in use");
		jb_covert_timing_channel.setMaximumSize(jb_covert_timing_channel.getPreferredSize());
		box67.add(covert_timing_channel);
		box67.add(jb_covert_timing_channel);
		box67.setAlignmentX(LEFT_ALIGNMENT);
		box.add(box67);

		Box box77=Box.createHorizontalBox();
		jb_forgery_protection.addItem("Exist");
		jb_forgery_protection.addItem("Not exist");
		jb_forgery_protection.setMaximumSize(jb_forgery_protection.getPreferredSize());
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
		box89.add(typical_severity);
		box89.add(jb_typical_severity);
		box89.setAlignmentX(LEFT_ALIGNMENT);
		box.add(box89);
		
		Box box68=Box.createHorizontalBox();
		jb_code_obfuscation_techniques.addItem("In use");
		jb_code_obfuscation_techniques.addItem("Not in use");
		jb_code_obfuscation_techniques.setMaximumSize(jb_code_obfuscation_techniques.getPreferredSize());
		box68.add(code_obfuscation_techniques);
		box68.add(jb_code_obfuscation_techniques);
		box68.setAlignmentX(LEFT_ALIGNMENT);
		box.add(box68);
		
		Box box5=Box.createHorizontalBox();
		jb_white_box_analysis_techniques.addItem("Yes");
		jb_white_box_analysis_techniques.addItem("No");
		jb_white_box_analysis_techniques.setMaximumSize(jb_white_box_analysis_techniques.getPreferredSize());
		box5.add(white_box_analysis_techniques);
		box5.add(jb_white_box_analysis_techniques);
		box5.setAlignmentX(LEFT_ALIGNMENT);
		box.add(box5);
			
		Box box6=Box.createHorizontalBox();
		jb_black_box_analysis_techniques.addItem("Yes");
		jb_black_box_analysis_techniques.addItem("No");
		jb_black_box_analysis_techniques.setMaximumSize(jb_black_box_analysis_techniques.getPreferredSize());
		box6.add(black_box_analysis_techniques);
		box6.add(jb_black_box_analysis_techniques);
		box6.setAlignmentX(LEFT_ALIGNMENT);
		box.add(box6);
		
		Box box99=Box.createHorizontalBox();
		jb_communication_paths.addItem("Trusted");
		jb_communication_paths.addItem("Untrusted");
		jb_communication_paths.setMaximumSize(jb_communication_paths.getPreferredSize());
		box99.add(communication_paths);
		box99.add(jb_communication_paths);
		box99.setAlignmentX(LEFT_ALIGNMENT);
		box.add(box99);

		Box box100=Box.createHorizontalBox();
		jb_configuration.addItem("Good");
		jb_configuration.addItem("Bad");
		jb_configuration.setMaximumSize(jb_configuration.getPreferredSize());
		box100.add(configuration);
		box100.add(jb_configuration);
		box100.setAlignmentX(LEFT_ALIGNMENT);
		box.add(box100);
		
		Box box37=Box.createHorizontalBox();
		jb_privilege_management.addItem("Proper");
		jb_privilege_management.addItem("Improper");
		jb_privilege_management.setMaximumSize(jb_privilege_management.getPreferredSize());
		box37.add(privilege_management);
		box37.add(jb_privilege_management);
		box37.setAlignmentX(LEFT_ALIGNMENT);
		box.add(box37);
				
		Box box7=Box.createHorizontalBox();
		jb_security_checks.addItem("Yes");
		jb_security_checks.addItem("No");
		jb_security_checks.setMaximumSize(jb_security_checks.getPreferredSize());
		box7.add(security_checks);
		box7.add(jb_security_checks);
		box7.setAlignmentX(LEFT_ALIGNMENT);
		box.add(box7);
		
		Box box8=Box.createHorizontalBox();
		jb_signal_level_alerts.addItem("Yes");
		jb_signal_level_alerts.addItem("No");
		jb_signal_level_alerts.setMaximumSize(jb_signal_level_alerts.getPreferredSize());
		box8.add(signal_level_alerts);
		box8.add(jb_signal_level_alerts);
		box8.setAlignmentX(LEFT_ALIGNMENT);
		box.add(box8);
		
		Box box22=Box.createHorizontalBox();
		jb_server_version.addItem("New");
		jb_server_version.addItem("Old");
		jb_server_version.setMaximumSize(jb_server_version.getPreferredSize());
		box22.add(server_version);
		box22.add(jb_server_version);
		box22.setAlignmentX(LEFT_ALIGNMENT);
		box.add(box22);
		
		Box box91=Box.createHorizontalBox();
		jb_hardware.addItem("Trusted");
		jb_hardware.addItem("Untrusted");
		jb_hardware.setMaximumSize(jb_hardware.getPreferredSize());
		box91.add(hardware);
		box91.add(jb_hardware);
		box91.setAlignmentX(LEFT_ALIGNMENT);
		box.add(box91);

		Box box23=Box.createHorizontalBox();
		jb_expiration.addItem("New");
		jb_expiration.addItem("Old");
		jb_expiration.setMaximumSize(jb_expiration.getPreferredSize());
		box23.add(expiration);
		box23.add(jb_expiration);
		box23.setAlignmentX(LEFT_ALIGNMENT);
		box.add(box23);

		Box box11=Box.createHorizontalBox();
		jb_password_policy.addItem("Strong");
		jb_password_policy.addItem("Week");
		jb_password_policy.setMaximumSize(jb_password_policy.getPreferredSize());
		box11.add(password_policy);
		box11.add(jb_password_policy);
		box11.setAlignmentX(LEFT_ALIGNMENT);
		box.add(box11);
		
		
		JButton btn1 = new JButton("Find");
		box.add(btn1);
		
}}