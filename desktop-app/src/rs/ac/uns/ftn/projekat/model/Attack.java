package rs.ac.uns.ftn.projekat.model;

import ucm.gaia.jcolibri.cbrcore.Attribute;
import ucm.gaia.jcolibri.cbrcore.CaseComponent;

public class Attack  implements CaseComponent {
	private String id;
	private String name;
	private String likelihood;
	private String severity;
	private String prerequisites;
	private String mitigations;
	private String weaknesses;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Attack [name=" + name + ", likelihood=" + likelihood + ", severity=" + severity + ", prerequisites="
				+ prerequisites + ", mitigations=" + mitigations + ", weaknesses=" + weaknesses + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLikelihood() {
		return likelihood;
	}
	public void setLikelihood(String likelihood) {
		this.likelihood = likelihood;
	}
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	public String getPrerequisites() {
		return prerequisites;
	}
	public void setPrerequisites(String prerequisites) {
		this.prerequisites = prerequisites;
	}
	public String getMitigations() {
		return mitigations;
	}
	public void setMitigations(String mitigations) {
		this.mitigations = mitigations;
	}
	public String getWeaknesses() {
		return weaknesses;
	}
	public void setWeaknesses(String weaknesses) {
		this.weaknesses = weaknesses;
	}
	@Override
	public Attribute getIdAttribute() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
