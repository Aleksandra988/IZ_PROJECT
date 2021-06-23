package rs.ac.uns.ftn.projekat.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;

import unbbayes.prs.Node;
import rs.ac.uns.ftn.projekat.dialogs.BayesDialog;
import rs.ac.uns.ftn.projekat.izgled.MainFrame;
import unbbayes.io.BaseIO;
import unbbayes.io.NetIO;
import unbbayes.io.XMLBIFIO;
import unbbayes.io.exception.LoadException;
import unbbayes.prs.bn.JunctionTreeAlgorithm;
import unbbayes.prs.bn.ProbabilisticNetwork;
import unbbayes.prs.bn.ProbabilisticNode;
import unbbayes.util.extension.bn.inference.IInferenceAlgorithm;


public class MyApp { 
	private static final String UPDATE_URL = "http://localhost:3030/IZ_ZNANJA/update";
	private static final String PREFIX = "PREFIX na: <https://dbpedia.org/fct/> PREFIX xsd: <http://w3.org/2001/XMLSchema#>";

	public static void main(String[] args) throws LoadException, IOException {
		
		String insertString = PREFIX + " INSERT DATA { ";

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
		
		
		MainFrame mf=MainFrame.getInstance();
		mf.setVisible(true);
	}

}
