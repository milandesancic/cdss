package rs.uns.ac.ftn.cdss.dto;

import java.util.List;

public class Symptoms {

	private List<SymptomDto> symptoms;

	public Symptoms() {
	}

	public Symptoms(List<SymptomDto> symptoms) {
		super();
		this.symptoms = symptoms;
	}

	public List<SymptomDto> getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(List<SymptomDto> symptoms) {
		this.symptoms = symptoms;
	}

}
