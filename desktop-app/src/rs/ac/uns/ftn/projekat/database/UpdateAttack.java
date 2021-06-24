package rs.ac.uns.ftn.projekat.database;

import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;

import rs.ac.uns.ftn.projekat.model.Attack;

public class UpdateAttack {
	private static final String UPDATE_URL = "http://localhost:3030/IZ_ZNANJA/update";
	private static final String PREFIX = "PREFIX na: <https://dbpedia.org/fct/> PREFIX xsd: <http://w3.org/2001/XMLSchema#>";

	public void Update(Attack attack,Attack updates) {
		String insertString = PREFIX + " DELETE{ ?attack  a                     na:Attack ;"
								+"    		na:name               ?name ;"
								+"             na:name               '"+ attack.getName()+"';"
								+"             na:likelihood         '"+ attack.getLikelihood() +"';"
								+"             na:severity           '"+ attack.getSeverity()+"';"
								+"             na:prerequisites      '"+ attack.getPrerequisites() +"';"
								+"             na:mitigations        '"+ attack.getMitigations()+"';"
								+"             na:weaknesses         '"+ attack.getWeaknesses() +"'. }"
								+"INSERT"
								+"{?attack  a                     na:Attack ;"
								+"             na:name               '"+ updates.getName()+"';"
								+"             na:likelihood         '"+ updates.getLikelihood() +"';"
								+"             na:severity           '"+ updates.getSeverity()+"';"
								+"             na:prerequisites      '"+ updates.getPrerequisites() +"';"
								+"             na:mitigations        '"+ updates.getMitigations()+"';"
								+"             na:weaknesses         '"+ updates.getWeaknesses() +"'. }" 
								+"WHERE"
								+"{ ?attack  a                     na:Attack ;"
								+"             na:name               ?name ."
								+"FILTER regex(?name, '"+attack.getName()+"')"
								+ "}";
	
		UpdateRequest updateRequest = UpdateFactory.create(insertString);
		UpdateProcessor updateProcessor = UpdateExecutionFactory.createRemote(updateRequest, UPDATE_URL);
		updateProcessor.execute();
	}
}

//DELETE DATA FROM <http://example/bookStore>
//{ <http://example/book3>  dc:title  "Fundamentals of Compiler Desing" }
//
//INSERT DATA INTO <http://example/bookStore>
//{ <http://example/book3>  dc:title  "Fundamentals of Compiler Design" }