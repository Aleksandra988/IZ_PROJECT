package rs.ac.uns.ftn.projekat.database;

import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;

import rs.ac.uns.ftn.projekat.model.Attack;

public class AtteckInsert {
	private static final String UPDATE_URL = "http://localhost:3030/IZ_ZNANJA/update";
	private static final String PREFIX = "PREFIX na: <https://dbpedia.org/fct/> PREFIX xsd: <http://w3.org/2001/XMLSchema#>";

	public void AddAttack(Attack attack) {
		String insertString = PREFIX + " INSERT DATA { ";
	
		insertString += " na:" + "attack222" + " a na:Attack; ";
		insertString += " na:name" + "\"" + attack.getName() + "\" ; ";
		insertString += " na:likelihood" + " \"" + attack.getLikelihood() + "\" ; ";
		insertString += " na:severity" + " \"" + attack.getSeverity() +"\" ; ";
		insertString += " na:prerequisites" + "\"" + attack.getPrerequisites() +"\" ; ";
		insertString += " na:mitigations" + "\"" + attack.getMitigations() +"\" ; ";
		insertString += " na:weaknesses" + "\"" + attack.getMitigations() +"\" . }";
	
		UpdateRequest updateRequest = UpdateFactory.create(insertString);
		UpdateProcessor updateProcessor = UpdateExecutionFactory.createRemote(updateRequest, UPDATE_URL);
		updateProcessor.execute();
	}
}
