package rs.ac.uns.ftn.projekat.dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
		eval = SelectCases.selectTopKRR(eval, 3);
		String result = "";
		//System.out.println("Retrieved cases:");

		for (RetrievalResult nse : eval) {
			//System.out.println(nse.get_case().getDescription() + " -> " + nse.getEval());
		    result  = (nse.get_case().getDescription().toString());
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
			
			
			
			//String val2 = values2[1];
			
			CBRCase cbrCase = new CBRCase();
			Attack attack = new Attack();
			attack.setName(val2);
			//System.out.println(val2);
			
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
		
		Box box1=Box.createHorizontalBox();
		jb_likelihood.addItem("Low");
		jb_likelihood.addItem("Medium");
		jb_likelihood.addItem("High");
		jb_likelihood.addItem("Very_high");
		jb_likelihood.setMaximumSize(jb_likelihood.getPreferredSize());
		box1.add(likelihood_jl);
		box1.add(jb_likelihood);
		box1.setAlignmentX(CENTER_ALIGNMENT);
		box.add(box1);
		
		
		Box box2=Box.createHorizontalBox();
		jb_severity.addItem("Low");
		jb_severity.addItem("Medium");
		jb_severity.addItem("High");
		jb_severity.addItem("Very_high");
		jb_severity.setMaximumSize(jb_severity.getPreferredSize());
		box2.add(severity_jl);
		box2.add(jb_severity);
		box2.setAlignmentX(CENTER_ALIGNMENT);
		box.add(box2);
		
		
		Box box3=Box.createHorizontalBox();
		jb_weaknesses.addItem("Improper_zeroization");
		jb_weaknesses.addItem("Incorrect_permissions");
		jb_weaknesses.addItem("Improper_access_control");
		jb_weaknesses.addItem("Sensitive_information");
		jb_weaknesses.setMaximumSize(jb_weaknesses.getPreferredSize());
		box3.add(weaknesses_jl);
		box3.add(jb_weaknesses);
		box3.setAlignmentX(CENTER_ALIGNMENT);
		
		box.add(box3);
		
		//findButton = new JButton("Find");
		box.add(findButton);
		Box box5 = Box.createHorizontalBox();
		box5.add(result);
		box.add(box5);
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
		
		
		
	}

	
}
