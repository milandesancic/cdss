package rs.uns.ac.ftn.cdss.event;

import java.util.Date;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;

import rs.uns.ac.ftn.cdss.model.Patient;

@Role(Role.Type.EVENT)
@Timestamp("executionTime")
@Expires("15m")
public class OxygenEvent {

	private Date executionTime;
	private Integer oxygenLevel;
	private Patient patient;

	public OxygenEvent() {
		this.executionTime = new Date();
	}

	public OxygenEvent(Patient p, Integer oxLevel) {
		this.executionTime = new Date();
		this.oxygenLevel = oxLevel;
		this.patient = p;
	}

	public Date getExecutionTime() {
		return executionTime;
	}

	public void setExecutionTime(Date executionTime) {
		this.executionTime = executionTime;
	}

	public Integer getOxygenLevel() {
		return oxygenLevel;
	}

	public void setOxygenLevel(Integer oxygenLevel) {
		this.oxygenLevel = oxygenLevel;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}
