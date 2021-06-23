package rs.ac.uns.ftn.projekat.dialogs;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.crypto.spec.PSource;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.rule.Variable;

import javax.swing.JRadioButton;
//import net.sourceforge.jFuzzyLogic.FIS;
//import net.sourceforge.jFuzzyLogic.JFuzzyLogic;

public class Fuzzy extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static JLabel severity_jl=new JLabel("severity");
	static JLabel likelihood_jl=new JLabel("likelihood");
	static JLabel protection_of_sensitive_information_jl=new JLabel("protectionof sensitive information");
	static JLabel validation_jl=new JLabel("validation");
	static JLabel server_version_jl=new JLabel("server version");
	static JLabel authorization_jl=new JLabel("authorization");
	static JLabel cross_site_request_forgery_jl=new JLabel("cross site request forgery");
	static JLabel password_policy_jl=new JLabel("password policy");
	static JLabel communication_path_jl=new JLabel("communication path");
	static JLabel authentication_jl=new JLabel("authentication");
	static JLabel value=new JLabel("vulnerability : MEDIUM");
	private static final String fclFilename = "template.fcl";
	private Variable tip;
	FunctionBlock functionBlock;
	public Fuzzy() {

		FIS fis = FIS.load(fclFilename,true);
		if( fis == null ) { // Error while loading?
			System.err.println("Can't load file: '" + fclFilename + "'");
		}
		functionBlock = fis.getFunctionBlock("attack");
		//JFuzzyChart.get().chart(functionBlock);
		functionBlock.getRuleBlocks();
		functionBlock.setVariable("validation", 5);
		functionBlock.setVariable("severity", 4);
		functionBlock.setVariable("likelihood", 3);
		functionBlock.setVariable("protection_of_sensitive_information", 4.5);
		functionBlock.setVariable("server_version", 4.5);
		functionBlock.setVariable("authorization", 5);
		functionBlock.setVariable("cross_site_request_forgery", 5);
		functionBlock.setVariable("password_policy", 5.5);
		functionBlock.setVariable("communication_path", 8);
		functionBlock.setVariable("authentication", 1);
		
		// Evaluate 
		functionBlock.evaluate();
		tip= functionBlock.getVariable("vulnerability");
			
		//
		setBackground(Color.GREEN);
		setModal(true);
		setTitle("FUZZY");
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double height=screenSize.getHeight();
		double width=screenSize.getWidth();
		height=height*10;
		width=width*0.45;
		setBounds(150,150, (int)width, (int)height);
		setLocationRelativeTo(null);
		setResizable(false);

		severity_jl.setPreferredSize(new Dimension((int)width,40));
		likelihood_jl.setPreferredSize(new Dimension((int)width,40));
		protection_of_sensitive_information_jl.setPreferredSize(new Dimension((int)width,40));
		validation_jl.setPreferredSize(new Dimension((int)width,40));
		server_version_jl.setPreferredSize(new Dimension((int)width,40));
		authorization_jl.setPreferredSize(new Dimension((int)width,40));
		cross_site_request_forgery_jl.setPreferredSize(new Dimension((int)width,40));
		password_policy_jl.setPreferredSize(new Dimension((int)width,40));
		communication_path_jl.setPreferredSize(new Dimension((int)width,40));
		authentication_jl.setPreferredSize(new Dimension((int)width,40));
		value.setPreferredSize(new Dimension((int)width,40));
		Box box=Box.createVerticalBox();
		this.add(box,BorderLayout.CENTER);
		
		value.setForeground(Color.YELLOW);
		
		//severity
		JPanel sev = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JRadioButton severity_low=new JRadioButton("Low");
		JRadioButton severity_medium=new JRadioButton("Medium");
		severity_medium.setSelected(true);
		JRadioButton severity_high=new JRadioButton("High");
		JRadioButton severity_very_high=new JRadioButton("Very high");
		sev.add(value);
		sev.add(severity_jl);
		sev.add(severity_low);
		sev.add(severity_medium);
		sev.add(severity_high);
		sev.add(severity_very_high);
		box.add(sev);
		
		severity_low.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				severity_low.setSelected(true);					
				severity_medium.setSelected(false);
				severity_high.setSelected(false);
				severity_very_high.setSelected(false);
				functionBlock.setVariable("severity", 1.5);
				Defuzzifier();
					return;
				}
		});
		severity_medium.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				severity_medium.setSelected(true);					
				severity_low.setSelected(false);
				severity_high.setSelected(false);
				severity_very_high.setSelected(false);
				functionBlock.setVariable("severity", 4);
				Defuzzifier();
					return;
				}
		});
		severity_high.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				severity_high.setSelected(true);						
				severity_medium.setSelected(false);
				severity_low.setSelected(false);
				severity_very_high.setSelected(false);
				functionBlock.setVariable("severity", 7);
				Defuzzifier();
					return;
				}
		});
		severity_very_high.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				severity_very_high.setSelected(true);					
				severity_medium.setSelected(false);
				severity_low.setSelected(false);
				severity_high.setSelected(false);
				functionBlock.setVariable("severity", 8);
				Defuzzifier();
					return;
				}
		});
		
		//likelihood
		JPanel lik = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JRadioButton likelihood_low=new JRadioButton("Low");
		JRadioButton likelihood_medium=new JRadioButton("Medium");
		likelihood_medium.setSelected(true);
		JRadioButton likelihood_high=new JRadioButton("High");
		JRadioButton likelihood_very_high=new JRadioButton("Very high");
		sev.add(likelihood_jl);
		sev.add(likelihood_low);
		sev.add(likelihood_medium);
		sev.add(likelihood_high);
		sev.add(likelihood_very_high);
		box.add(lik);
		
		likelihood_low.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				likelihood_low.setSelected(true);							
				likelihood_medium.setSelected(false);
				likelihood_high.setSelected(false);
				likelihood_very_high.setSelected(false);
				functionBlock.setVariable("likelihood", 1.5);
				Defuzzifier();
					return;
				}
		});
		likelihood_medium.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {							
				likelihood_medium.setSelected(true);					
				likelihood_low.setSelected(false);
				likelihood_high.setSelected(false);
				likelihood_very_high.setSelected(false);
				functionBlock.setVariable("likelihood", 3);
				Defuzzifier();
					return;
				}
		});		
		likelihood_high.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				likelihood_high.setSelected(true);						
				likelihood_medium.setSelected(false);
				likelihood_low.setSelected(false);
				likelihood_very_high.setSelected(false);
				functionBlock.setVariable("likelihood", 6);
				Defuzzifier();
					return;
				}
		});		
		likelihood_very_high.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				likelihood_very_high.setSelected(true);							
				likelihood_medium.setSelected(false);
				likelihood_high.setSelected(false);
				likelihood_low.setSelected(false);
				functionBlock.setVariable("likelihood", 8.5);
				Defuzzifier();
					return;
				}
		});		
		
		
		//protection_of_sensitive_information_jl
		JPanel posi = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JRadioButton posi_weak=new JRadioButton("Weak");
		JRadioButton posi_medium=new JRadioButton("Medium");
		posi_medium.setSelected(true);
		JRadioButton posi_strong=new JRadioButton("Strong");
		sev.add(protection_of_sensitive_information_jl);
		sev.add(posi_weak);
		sev.add(posi_medium);
		sev.add(posi_strong);
		box.add(posi);
		
		posi_weak.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				posi_weak.setSelected(true);						
				posi_medium.setSelected(false);
				posi_strong.setSelected(false);
				functionBlock.setVariable("protection_of_sensitive_information", 1.2);
				Defuzzifier();
					return;
				}
		});
		posi_medium.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				posi_medium.setSelected(true);					
				posi_weak.setSelected(false);
				posi_strong.setSelected(false);
				functionBlock.setVariable("protection_of_sensitive_information", 4.5);
				Defuzzifier();
					return;
				}
		});
		posi_strong.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				posi_strong.setSelected(true);						
				posi_medium.setSelected(false);
				posi_weak.setSelected(false);
				functionBlock.setVariable("protection_of_sensitive_information", 7.5);
				Defuzzifier();
					return;
				}
		});
		
		
		//validation
		JPanel val = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JRadioButton validation_weak=new JRadioButton("Weak");
		JRadioButton validation_medium=new JRadioButton("Medium");
		validation_medium.setSelected(true);
		JRadioButton validation_strong=new JRadioButton("Strong");
		sev.add(validation_jl);
		sev.add(validation_weak);
		sev.add(validation_medium);
		sev.add(validation_strong);
		box.add(val);
		
		validation_weak.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				validation_weak.setSelected(true);						
				validation_medium.setSelected(false);
				validation_strong.setSelected(false);
				functionBlock.setVariable("validation", 1.5);
				Defuzzifier();
					return;
				}
		});
		validation_medium.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				validation_medium.setSelected(true);					
				validation_weak.setSelected(false);
				validation_strong.setSelected(false);
				functionBlock.setVariable("validation", 5);
				Defuzzifier();
					return;
				}
		});
		validation_strong.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				validation_strong.setSelected(true);					
				validation_medium.setSelected(false);
				validation_weak.setSelected(false);
				functionBlock.setVariable("validation", 8.5);
				Defuzzifier();
					return;
				}
		});
		
		
		//server_version
		JPanel sv = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JRadioButton server_version_very_old=new JRadioButton("Very  old");
		JRadioButton server_version_old=new JRadioButton("Old");
		server_version_old.setSelected(true);
		JRadioButton server_version_latest=new JRadioButton("Latest");
		sev.add(server_version_jl);
		sev.add(server_version_very_old);
		sev.add(server_version_old);
		sev.add(server_version_latest);
		box.add(sv);
		
		server_version_very_old.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				server_version_very_old.setSelected(true);					
				server_version_old.setSelected(false);
				server_version_latest.setSelected(false);
				functionBlock.setVariable("server_version", 1);
				Defuzzifier();
					return;
				}
		});

		server_version_old.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {			
				server_version_old.setSelected(true);					
				server_version_very_old.setSelected(false);
				server_version_latest.setSelected(false);
				functionBlock.setVariable("server_version", 4.5);
				Defuzzifier();
					return;
				}
		});
		server_version_latest.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				server_version_latest.setSelected(true);							
				server_version_old.setSelected(false);
				server_version_very_old.setSelected(false);
				functionBlock.setVariable("server_version", 8.5);
				Defuzzifier();
					return;
				}
		});
		
		
		//authorization
		JPanel author = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JRadioButton authorization_low=new JRadioButton("Low");
		JRadioButton authorization_medium=new JRadioButton("Medium");
		authorization_medium.setSelected(true);
		JRadioButton authorization_high=new JRadioButton("High");
		sev.add(authorization_jl);
		sev.add(authorization_low);
		sev.add(authorization_medium);
		sev.add(authorization_high);
		box.add(author);

		authorization_low.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				authorization_low.setSelected(true);						
				authorization_medium.setSelected(false);
				authorization_high.setSelected(false);
				functionBlock.setVariable("authorization", 1.2);
				Defuzzifier();
					return;
				}
		});
		authorization_medium.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				authorization_medium.setSelected(true);						
				authorization_low.setSelected(false);
				authorization_high.setSelected(false);
				functionBlock.setVariable("authorization", 5);
				Defuzzifier();
					return;
				}
		});		
		authorization_high.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				authorization_high.setSelected(true);							
				authorization_medium.setSelected(false);
				authorization_low.setSelected(false);
				functionBlock.setVariable("authorization", 8.5);
				Defuzzifier();
					return;
				}
		});		
		
		//cross_site_request_forgery
		JPanel csrf = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JRadioButton csrf_unlikely=new JRadioButton("Unlikely");
		JRadioButton csrf_posible=new JRadioButton("Possible");
		csrf_posible.setSelected(true);
		JRadioButton csrf_almost_certain=new JRadioButton("Almost certain");
		sev.add(cross_site_request_forgery_jl);
		sev.add(csrf_unlikely);
		sev.add(csrf_posible);
		sev.add(csrf_almost_certain);
		box.add(csrf);
		
		csrf_unlikely.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				csrf_unlikely.setSelected(true);						
				csrf_posible.setSelected(false);
				csrf_almost_certain.setSelected(false);
				functionBlock.setVariable("cross_site_request_forgery", 1.2);
				Defuzzifier();
					return;
				}
		});
		
		csrf_posible.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				csrf_posible.setSelected(true);					
				csrf_unlikely.setSelected(false);
				csrf_almost_certain.setSelected(false);
				functionBlock.setVariable("cross_site_request_forgery", 5);
				Defuzzifier();
					return;
				}
		});
		csrf_almost_certain.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				csrf_almost_certain.setSelected(true);						
				csrf_unlikely.setSelected(false);
				csrf_posible.setSelected(false);
				functionBlock.setVariable("cross_site_request_forgery", 8);
				Defuzzifier();
					return;
				}
		});		
		
		//password_policy
		JPanel pp = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JRadioButton password_policy_weak=new JRadioButton("Weak");
		JRadioButton password_policy_medium=new JRadioButton("Medium");
		password_policy_medium.setSelected(true);
		JRadioButton password_policy_strong=new JRadioButton("Strong");
		sev.add(password_policy_jl);
		sev.add(password_policy_weak);
		sev.add(password_policy_medium);
		sev.add(password_policy_strong);
		box.add(pp);
		password_policy_weak.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				password_policy_weak.setSelected(true);					
				password_policy_medium.setSelected(false);
				password_policy_strong.setSelected(false);
				functionBlock.setVariable("password_policy", 1.5);
				Defuzzifier();
					return;
				}
		});	
		password_policy_medium.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				password_policy_medium.setSelected(true);							
				password_policy_weak.setSelected(false);
				password_policy_strong.setSelected(false);
				functionBlock.setVariable("password_policy", 5.5);
				Defuzzifier();
					return;
				}
		});	
		password_policy_strong.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				password_policy_strong.setSelected(true);							
				password_policy_medium.setSelected(false);
				password_policy_weak.setSelected(false);
				functionBlock.setVariable("password_policy", 8.5);
				Defuzzifier();
					return;
				}
		});	
		
		//communication_path
		JPanel cp = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JRadioButton communication_path_untrusted=new JRadioButton("Untrusted");
		JRadioButton communication_path_trusted=new JRadioButton("Trusted");
		communication_path_trusted.setSelected(true);
		sev.add(communication_path_jl);
		sev.add(communication_path_untrusted);
		sev.add(communication_path_trusted);
		box.add(cp);
		communication_path_untrusted.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				communication_path_untrusted.setSelected(true);						
				communication_path_trusted.setSelected(false);
				functionBlock.setVariable("communication_path", 1);
				Defuzzifier();
					return;
				}
		});		
		communication_path_trusted.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				communication_path_trusted.setSelected(true);							
				communication_path_untrusted.setSelected(false);
				functionBlock.setVariable("communication_path", 8);
				Defuzzifier();
					return;
				}
		});	
		
		//authentication
		JPanel authen = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JRadioButton authentication_incorrect=new JRadioButton("Incorrect");
		JRadioButton authentication_correct=new JRadioButton("Correct");
		authentication_incorrect.setSelected(true);
		sev.add(authentication_jl);
		sev.add(authentication_incorrect);
		sev.add(authentication_correct);
		box.add(authen);
		authentication_incorrect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				authentication_incorrect.setSelected(true);						
				authentication_correct.setSelected(false);
				functionBlock.setVariable("authentication", 1);
				Defuzzifier();
					return;
				}
		});	
		authentication_correct.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				authentication_correct.setSelected(true);						
				authentication_incorrect.setSelected(false);
				functionBlock.setVariable("authentication", 7);
				Defuzzifier();
					return;
				}
		});	
	
	}
	public void Defuzzifier() {
		functionBlock.evaluate();
		double res=tip.getDefuzzifier().defuzzify();
		if(res>65.0) {
			value.setText("vulnerability : HIGH");
			value.setForeground(Color.RED);
		}else if(res<35.0) {
			value.setText("vulnerability : LOW");
			value.setForeground(Color.GREEN);
		}else {
			value.setText("vulnerability : MEDIUM");
			value.setForeground(Color.YELLOW);
		}
		System.out.println(res);
	}	

}
