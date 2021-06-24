package rs.ac.uns.ftn.projekat.database;

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

public class GetAttack {
	private static final String QUERY_URL = "http://localhost:3030/IZ_ZNANJA/sparql";
	private static final String PREFIX = "PREFIX na: <https://dbpedia.org/fct/> PREFIX xsd: <http://w3.org/2001/XMLSchema#>";

	public Attack GetAttackByNameAndId(String name, String id) {
		Attack a=new Attack();
		String selectString = PREFIX + " SELECT * " + "WHERE {"
				+ "	?attack a na:Attack;" + "           na:name ?name; FILTER (?name =\\"+name+"\\)"+ "           na:likelihood ?likelihood; "
				+"           na:severity ?severity; "+"           na:prerequisites ?prerequisites; "
				+"           na:mitigations ?mitigations; "+"           na:weaknesses ?weaknesses; "+ ". }";
		Query query = QueryFactory.create(selectString);
		try {
			QueryExecution qexec = QueryExecutionFactory.sparqlService(QUERY_URL, query);
			ResultSet results = qexec.execSelect();

			ResultSetRewindable resultSetRewindble = ResultSetFactory.copyResults(results);

			qexec.close();
			while (resultSetRewindble.hasNext()) {
				QuerySolution solution = resultSetRewindble.nextSolution();
				a.setName(solution.getLiteral("name").getString());
				a.setLikelihood(solution.getLiteral("likelihood").getString());
				a.setSeverity(solution.getLiteral("severity").getString());
				a.setMitigations(solution.getLiteral("mitigations").getString());
				a.setWeaknesses(solution.getLiteral("weaknesses").getString());
				a.setPrerequisites(solution.getLiteral("prerequisites").getString());
			}
		}
	    catch (Exception e) {
		System.out.println("GRESKA SELECT NAREDBA ZA GET!");
		e.printStackTrace();
	    }
		return a;
	}
}
