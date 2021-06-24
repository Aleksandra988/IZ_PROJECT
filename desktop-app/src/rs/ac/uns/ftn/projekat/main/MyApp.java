package rs.ac.uns.ftn.projekat.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;


import unbbayes.prs.Node;
import rs.ac.uns.ftn.projekat.connector.CsvConnector;
import rs.ac.uns.ftn.projekat.database.GetAttack;
import rs.ac.uns.ftn.projekat.database.UpdateAttack;
import rs.ac.uns.ftn.projekat.dialogs.BayesDialog;
import rs.ac.uns.ftn.projekat.izgled.MainFrame;
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
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.similarity.local.Interval;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.similarity.local.Threshold;
import ucm.gaia.jcolibri.method.retrieve.selection.SelectCases;
import unbbayes.io.BaseIO;
import unbbayes.io.NetIO;
import unbbayes.io.XMLBIFIO;
import unbbayes.io.exception.LoadException;
import unbbayes.prs.bn.JunctionTreeAlgorithm;
import unbbayes.prs.bn.ProbabilisticNetwork;
import unbbayes.prs.bn.ProbabilisticNode;
import unbbayes.util.extension.bn.inference.IInferenceAlgorithm;


public class MyApp implements StandardCBRApplication{ 
	
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
		//simConfig.addMapping(new Attribute("distanceToPublicTransportation", RealEstateDescription.class), new Threshold(50));
	//	simConfig.addMapping(new Attribute("localStores", RealEstateDescription.class), new Interval(2));

		// Equal - returns 1 if both individuals are equal, otherwise returns 0
		// Interval - returns the similarity of two number inside an interval: sim(x,y) = 1-(|x-y|/interval)
		// Threshold - returns 1 if the difference between two numbers is less than a threshold, 0 in the other case
		// EqualsStringIgnoreCase - returns 1 if both String are the same despite case letters, 0 in the other case
		// MaxString - returns a similarity value depending of the biggest substring that belong to both strings
		// EnumDistance - returns the similarity of two enum values as the their distance: sim(x,y) = |ord(x) - ord(y)|
		// EnumCyclicDistance - computes the similarity between two enum values as their cyclic distance
		// Table - uses a table to obtain the similarity between two values. Allowed values are Strings or Enums. The table is read from a text file.
		// TableSimilarity(List<String> values).setSimilarity(value1,value2,similarity) 
	}

	public void cycle(CBRQuery query) throws ExecutionException {
		Collection<RetrievalResult> eval = NNScoringMethod.evaluateSimilarity(_caseBase.getCases(), query, simConfig);
		eval = SelectCases.selectTopKRR(eval, 2);
		System.out.println("Retrieved cases:");
		for (RetrievalResult nse : eval)
			System.out.println(nse.get_case().getDescription() + " -> " + nse.getEval());
	}

	public void postCycle() throws ExecutionException {
		
	}

	public CBRCaseBase preCycle() throws ExecutionException {
		_caseBase.init(_connector);
		java.util.Collection<CBRCase> cases = _caseBase.getCases();
		for (CBRCase c: cases)
			System.out.println(c.getDescription());
		return _caseBase;
	}

	private static final String UPDATE_URL = "http://localhost:3030/IZ_ZNANJA/update";
	private static final String PREFIX = "PREFIX na: <https://dbpedia.org/fct/> PREFIX xsd: <http://w3.org/2001/XMLSchema#>";

	public static void main(String[] args) throws LoadException, IOException {
		StandardCBRApplication recommender = new MyApp();
		
		try {
			recommender.configure();

			recommender.preCycle();

			CBRQuery query = new CBRQuery();
			
			Attack attack = new Attack();
			attack.setLikelihood("High");
			attack.setSeverity("High");
			attack.setWeaknesses("Incorrect_permissions");

			
			query.setDescription( attack );
			recommender.cycle(query);

			recommender.postCycle();
		} catch (Exception e) {
			e.printStackTrace();
		}
/*		String insertString = PREFIX + " INSERT DATA { ";

		insertString += " na:" + "attack222" + " a na:Attack; ";

		// id
		insertString += " na:name" + "\"" + "PROBAA" + "\"^^xsd:string; ";
		insertString += " na:likelihood" + " \"" + "PROBAA" + "\"^^xsd:string; ";
		insertString += " na:severity" + " \"" + "PROBAA" +"\"^^xsd:string ; ";
		insertString += " na:prerequisites" + "\"" + "PROBAA" +"\"^^xsd:string ; ";
		insertString += " na:mitigations" + "\"" + "PROBAA" +"\"^^xsd:string ; ";
		insertString += " na:weaknesses" + "\"" + "PROBAA" +"\"^^xsd:string . }";

		UpdateRequest updateRequest = UpdateFactory.create(insertString);
		UpdateProcessor updateProcessor = UpdateExecutionFactory.createRemote(updateRequest, UPDATE_URL);
		updateProcessor.execute();
		
		
		BaseIO io = new NetIO();
		ProbabilisticNetwork net = (ProbabilisticNetwork) io.load(new File("bayes.net"));
		IInferenceAlgorithm algorithm = new JunctionTreeAlgorithm();
		algorithm.setNetwork(net);
		algorithm.run();
		
		List<Node> nodeList = net.getNodes();
		boolean hasAtLeastOne = false;
//		for (Node node : nodeList) {
//			for (Symptom symptom : symptoms) {
//				if (node.getName().equals(symptom.getName())) {
//					hasAtLeastOne = true;
//					break;
//				}
//			}
//		}

//		if (!hasAtLeastOne) {
//			DiagnosisModel dm = new DiagnosisModel();
//			dm.setDiagnosisName("Empty");
//			dm.setDiagnosisPercentage(0);
//			return dm;
//		}

			for (Node node: nodeList) {
				System.out.println(node.getName());
				for (int i = 0; i < node.getStatesSize(); i++) {
					System.out.println(node.getStateAt(i) + ": " + ((ProbabilisticNode)node).getMarginalAt(i));
				}
			}
		*/
		
		
		
		MainFrame mf=MainFrame.getInstance();
		mf.setVisible(true);
	}

}
