package rs.ac.uns.ftn.projekat.database;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFactory;
import org.apache.jena.query.ResultSetRewindable;

import rs.ac.uns.ftn.projekat.model.Attack;

public class GetAttack {
	private static final String QUERY_URL = "http://localhost:3030/IZ_ZNANJA/sparql";
	private static final String PREFIX = "PREFIX na: <https://dbpedia.org/fct/> PREFIX xsd: <http://w3.org/2001/XMLSchema#>";

	public Attack GetAttackByName(String name) {
		Attack attack=new Attack();
		String selectString = PREFIX + " SELECT * " + "WHERE {"
				+ "	?attack a na:Attack;" + "           na:name ?name; "+ "           na:likelihood ?likelihood; "
				+"           na:severity ?severity; "+"           na:prerequisites ?prerequisites; "
				+"           na:mitigations ?mitigations; "+"           na:weaknesses ?weaknesses; "+ ". FILTER regex(?name, '"+name+"') }";
		Query query = QueryFactory.create(selectString);
		try {
			QueryExecution qexec = QueryExecutionFactory.sparqlService(QUERY_URL, query);
			ResultSet results = qexec.execSelect();

			ResultSetRewindable resultSetRewindble = ResultSetFactory.copyResults(results);

			qexec.close();
			while (resultSetRewindble.hasNext()) {
				QuerySolution solution = resultSetRewindble.nextSolution();
				attack.setName(solution.getLiteral("name").getString());
				attack.setLikelihood(solution.getLiteral("likelihood").getString());
				attack.setSeverity(solution.getLiteral("severity").getString());
				attack.setMitigations(solution.getLiteral("mitigations").getString());
				attack.setWeaknesses(solution.getLiteral("weaknesses").getString());
				attack.setPrerequisites(solution.getLiteral("prerequisites").getString());
			}
		}
	    catch (Exception e) {
		System.out.println("GRESKA SELECT NAREDBA ZA GET!");
		e.printStackTrace();
	    }
		return attack;
	}
}
