package rs.ac.uns.ftn.projekat.dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import rs.ac.uns.ftn.projekat.connector.CsvConnector;
import rs.ac.uns.ftn.projekat.main.MyApp;
import rs.ac.uns.ftn.projekat.model.Attack;
import ucm.gaia.jcolibri.casebase.LinealCaseBase;
import ucm.gaia.jcolibri.cbraplications.StandardCBRApplication;
import ucm.gaia.jcolibri.cbrcore.Attribute;
import ucm.gaia.jcolibri.cbrcore.CBRCase;
import ucm.gaia.jcolibri.cbrcore.CBRCaseBase;
import ucm.gaia.jcolibri.cbrcore.CBRQuery;
import ucm.gaia.jcolibri.cbrcore.Connector;
import ucm.gaia.jcolibri.exception.ExecutionException;
import ucm.gaia.jcolibri.method.retrieve.RetrievalResult;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.NNConfig;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.NNScoringMethod;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.similarity.global.Average;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.similarity.local.Equal;
import ucm.gaia.jcolibri.method.retrieve.selection.SelectCases;


public class CaseBaseReasoningDialog extends JDialog implements StandardCBRApplication {
	
	private static final long serialVersionUID = 1L;

//	static JLabel likelihood_jl=new JLabel("Likelihood");
//	static JLabel severity_jl=new JLabel("Severity");
//	static JLabel weaknesses_jl=new JLabel("Weaknesses");
//
//	static JComboBox<String> jb_likelihood=new JComboBox<String>();
//	static JComboBox<String> jb_severity=new JComboBox<String>();
//	static JComboBox<String> jb_weaknesses=new JComboBox<String>();
//	static JButton findButton = new JButton("Find");
	public String result_likelihood;
	public String result_severity;
	public String result_weaknesses;
	static String val2 = "";
	static String val11 = "";
	
	
	
	Connector _connector;  /** Connector object */
	CBRCaseBase _caseBase;  /** CaseBase object */

	NNConfig simConfig;  /** KNN configuration */
	
	public void configure() throws ExecutionException {
		_connector =  new CsvConnector();
		
		_caseBase = new LinealCaseBase();  // Create a Lineal case base for in-memory organization
		
		simConfig = new NNConfig(); // KNN configuration
		simConfig.setDescriptionSimFunction(new Average());  // global similarity function = average
		
		simConfig.addMapping(new Attribute("likelihood", Attack.class), new Equal());
		// simConfig.addMapping(new Attribute("price", TransactionDescription.class), new Interval(100));
		simConfig.addMapping(new Attribute("severity", Attack.class), new Equal());
		simConfig.addMapping(new Attribute("weaknesses", Attack.class), new Equal());
	
	}

	
	public void cycle(CBRQuery query) throws ExecutionException {
		Collection<RetrievalResult> eval = NNScoringMethod.evaluateSimilarity(_caseBase.getCases(), query, simConfig);
		eval = SelectCases.selectTopKRR(eval, 1);
		String result = "";
		//System.out.println("Retrieved cases:");

		for (RetrievalResult nse : eval) {
			//System.out.println(nse.get_case().getDescription() + " -> " + nse.getEval());
		    result  = (nse.get_case().getDescription().toString());
		    //System.out.println(result);
			String line = "";
			line = result;
				if (line.length() == 0)
					continue;
			
			String[] values8 = line.split("\\]");
			String val8 = values8[0];
			String[] values = line.split("\\[");
			String val = values[1];
			String[] values1 = val.split(",");
			String val1 = values1[0];
			String[] values2 = val1.split("=");
			val2 += values2[1] + "    ";
			
			String[] values7 = line.split("\\]");
			String val7 = values7[0];
			String[] values6 = line.split("\\[");
			String val6 = values6[1];
			String[] values10 = val.split(",");
     		String val10 = values10[4];
			String[] values12 = val10.split("=");
			val11 += values12[1] + "    ";
			
			
			
			//String val2 = values2[1];
			
			CBRCase cbrCase = new CBRCase();
			Attack attack = new Attack();
			attack.setName(val2);
			//System.out.println(val11);
			
		    //System.out.println(result);
		    
		}
		
	
	
			
		}
	
	
	

	public void postCycle() throws ExecutionException {
		
	}

	public CBRCaseBase preCycle() throws ExecutionException {
		_caseBase.init(_connector);
		java.util.Collection<CBRCase> cases = _caseBase.getCases();
		//for (CBRCase c: cases)
			//System.out.println(c.getDescription());
		return _caseBase;
	}

	private static final String UPDATE_URL = "http://localhost:3030/IZ_ZNANJA/update";
	private static final String PREFIX = "PREFIX na: <https://dbpedia.org/fct/> PREFIX xsd: <http://w3.org/2001/XMLSchema#>";
	
	
	
	
	public CaseBaseReasoningDialog() {
		
		
		 JLabel likelihood_jl=new JLabel("Likelihood");
		 JLabel severity_jl=new JLabel("Severity");
		 JLabel weaknesses_jl=new JLabel("Weaknesses");
	
		 JComboBox<String> jb_likelihood=new JComboBox<String>();
		 JComboBox<String> jb_severity=new JComboBox<String>();
		 JComboBox<String> jb_weaknesses=new JComboBox<String>();
		 JButton findButton = new JButton("Find");
		 JLabel result = new JLabel();
		 JButton rbrButton = new JButton("Rule Base Reasoning");
		 JLabel result1 = new JLabel();
		 
		 
		 
		setBackground(Color.GREEN);
		setModal(true);
		setTitle("Case Base Reasoning");
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double height=screenSize.getHeight();
		double width=screenSize.getWidth();
		height=height*0.3;
		width=width*0.5;
		setBounds(200, 200, (int)width, (int)height);
		setLocationRelativeTo(null);

		Box box=Box.createVerticalBox();
		this.add(box,BorderLayout.CENTER);
		
		//Box box1=Box.createHorizontalBox();
		JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jb_likelihood.addItem("Low");
		jb_likelihood.addItem("Medium");
		jb_likelihood.addItem("High");
		jb_likelihood.addItem("Very high");
		jb_likelihood.setMaximumSize(jb_likelihood.getPreferredSize());
		panel1.add(likelihood_jl);
		panel1.add(jb_likelihood);
		//panel1.setAlignmentX(LEFT_ALIGNMENT);
		box.add(panel1);
		
		
		//Box box2=Box.createHorizontalBox();
		JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jb_severity.addItem("Low");
		jb_severity.addItem("Medium");
		jb_severity.addItem("High");
		jb_severity.addItem("Very high");
		jb_severity.setMaximumSize(jb_severity.getPreferredSize());
		panel2.add(severity_jl);
		panel2.add(jb_severity);
		//box2.setAlignmentX(LEFT_ALIGNMENT);
		box.add(panel2);
		
		
		//Box box3=Box.createHorizontalBox();
		JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jb_weaknesses.addItem("Improper zeroization");
		jb_weaknesses.addItem("Incorrect permissions");
		jb_weaknesses.addItem("Improper access control");
		jb_weaknesses.addItem("Sensitive information");
		jb_weaknesses.addItem("Files accessible to external parties");
		jb_weaknesses.addItem("Missing encryption of sensitive data");
		jb_weaknesses.addItem("Exposure of sensitive system information");
		jb_weaknesses.addItem("Poor data encryption");
		jb_weaknesses.addItem("Missing cryptographic step");
		jb_weaknesses.addItem("Use of single factor authentication");		
		jb_weaknesses.setMaximumSize(jb_weaknesses.getPreferredSize());
		panel3.add(weaknesses_jl);
		panel3.add(jb_weaknesses);
		//panel3.setAlignmentX(LEFT_ALIGNMENT);
		
		box.add(panel3);
		
		//findButton = new JButton("Find");
		//Box box10 = Box.createHorizontalBox();
		JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel4.add(findButton);
		//Box box5 = Box.createHorizontalBox();
		panel4.add(result);
		box.add(panel4);
		//Box box11 = Box.createHorizontalBox();
		JPanel panel5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel5.add(rbrButton);
		//Box box6 = Box.createHorizontalBox();
		panel5.add(result1);
		box.add(panel5);
		//box.add(box10);
		// result_likelihood = jb_likelihood.getSelectedItem().toString();
		// result_severity = jb_severity.getSelectedItem().toString();
		// result_weaknesses = jb_weaknesses.getSelectedItem().toString();
		
		
			findButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
						
				StandardCBRApplication recommender = new CaseBaseReasoningDialog();
				try {
					recommender.configure();

					recommender.preCycle();

					CBRQuery query = new CBRQuery();
					
					Attack attack = new Attack();
					attack.setLikelihood(jb_likelihood.getSelectedItem().toString());
					attack.setSeverity(jb_severity.getSelectedItem().toString());
					attack.setWeaknesses(jb_weaknesses.getSelectedItem().toString());
					

					
					query.setDescription( attack );
					recommender.cycle(query);

					
					recommender.postCycle();
					//System.out.println(val2);
					result.setSize(200, 100);
					result.setText(val2);
				} catch (Exception a) {
					a.printStackTrace();
				}
					return;
				}
		});
		
			rbrButton.addActionListener(new ActionListener() {
				
			@Override
			public void actionPerformed(ActionEvent e) {
				
						
				result1.setSize(200, 100);
				result1.setText(val11);
					return;
				}
		});
		
		
		
	}
	
	

	
}
