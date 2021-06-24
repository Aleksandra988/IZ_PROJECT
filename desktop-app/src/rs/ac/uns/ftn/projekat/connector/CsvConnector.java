package rs.ac.uns.ftn.projekat.connector;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Collection;
import java.util.LinkedList;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFactory;
import org.apache.jena.query.ResultSetRewindable;
import org.apache.jena.rdf.model.Literal;

import rs.ac.uns.ftn.projekat.model.Attack;
import ucm.gaia.jcolibri.cbrcore.CBRCase;
import ucm.gaia.jcolibri.cbrcore.CaseBaseFilter;
import ucm.gaia.jcolibri.cbrcore.Connector;
import ucm.gaia.jcolibri.exception.InitializingException;
import ucm.gaia.jcolibri.util.FileIO;

public class CsvConnector implements Connector {
	
	private static final String QUERY_URL = "http://localhost:3030/IZ_ZNANJA/sparql";
	private static final String UPDATE_URL = "http://localhost:3030/IZ_ZNANJA/update";
	private static final String PREFIX = "PREFIX na: <https://dbpedia.org/fct/> PREFIX xsd: <http://w3.org/2001/XMLSchema#>";		

	@Override
	public Collection<CBRCase> retrieveAllCases() {
		LinkedList<CBRCase> cases = new LinkedList<CBRCase>();
		
		String selectString = PREFIX + " SELECT * " + "WHERE {"
				+ "	?attack a na:Attack;" + "           na:name ?name; "+ "           na:likelihood ?likelihood; "
				+"           na:severity ?severity; "+"           na:prerequisites ?prerequisites; "
				+"           na:mitigations ?mitigations; "+"           na:weaknesses ?weaknesses; "+ ". }";
		Query query = QueryFactory.create(selectString);
		try {
			QueryExecution qexec = QueryExecutionFactory.sparqlService(QUERY_URL, query);
			ResultSet results = qexec.execSelect();

			ResultSetRewindable resultSetRewindble = ResultSetFactory.copyResults(results);

			qexec.close();
			while (resultSetRewindble.hasNext()) {
				CBRCase cbrCase = new CBRCase();
				QuerySolution solution = resultSetRewindble.nextSolution();

				Attack attack = new Attack();
				attack.setName(solution.getLiteral("name").getString());
				attack.setLikelihood(solution.getLiteral("likelihood").getString());
				attack.setSeverity(solution.getLiteral("severity").getString());
				attack.setPrerequisites(solution.getLiteral("prerequisites").getString());
				attack.setMitigations(solution.getLiteral("mitigations").getString());
				attack.setWeaknesses(solution.getLiteral("weaknesses").getString());				
		       	cbrCase.setDescription(attack);
				cases.add(cbrCase);				
			}
		}
	    catch (Exception e) {
	    	System.out.println("GRESKA SELECT NAREDBA ZA GET!");
	    	e.printStackTrace();
	    }
		return cases;
	}

	@Override
	public Collection<CBRCase> retrieveSomeCases(CaseBaseFilter arg0) {
		return null;
	}

	@Override
	public void storeCases(Collection<CBRCase> arg0) {
	}
	
	@Override
	public void close() {
	}

	@Override
	public void deleteCases(Collection<CBRCase> arg0) {
	}

	@Override
	public void initFromXMLfile(URL arg0) throws InitializingException {
	}
}
