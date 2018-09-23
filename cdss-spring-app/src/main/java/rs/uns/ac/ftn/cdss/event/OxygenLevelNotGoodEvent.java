package rs.uns.ac.ftn.cdss.event;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;

import rs.uns.ac.ftn.cdss.model.Patient;

@Role(Role.Type.EVENT)
@Expires("12m")
public class OxygenLevelNotGoodEvent {
	private Patient patient;
	private String message;

	public OxygenLevelNotGoodEvent() {
	}

	public OxygenLevelNotGoodEvent(Patient p, String message) {
		this.patient = p;
		this.message = message;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "OxygenLevelNotGoodEvent\npatient=" + patient.getName() + "\nmessage=" + message;
	}

	
	
}