package rs.uns.ac.ftn.cdss.event;

import java.util.Date;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;

import rs.uns.ac.ftn.cdss.model.Patient;

@Role(Role.Type.EVENT)
@Timestamp("executionTime")
@Expires("2m")
public class HeartbeatEvent {

	private Date executionTime;
	private Patient patient;

	public HeartbeatEvent() {
		this.executionTime = new Date();
	}

	public HeartbeatEvent(Patient p) {
		this.executionTime = new Date();
		this.patient = p;
	}

	public Date getExecutionTime() {
		return executionTime;
	}

	public void setExecutionTime(Date executionTime) {
		this.executionTime = executionTime;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	

}
