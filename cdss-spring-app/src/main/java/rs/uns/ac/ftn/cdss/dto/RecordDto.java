package rs.uns.ac.ftn.cdss.dto;

import java.util.List;

import rs.uns.ac.ftn.cdss.model.Disease;

public class RecordDto {

	private Disease disease;
	private List<String> medicnie;
	private List<SymptomDto> symptoms;

	public RecordDto() {
	}

	public RecordDto(Disease disease, List<String> medicnie, List<SymptomDto> symptoms) {
		this.disease = disease;
		this.medicnie = medicnie;
		this.symptoms = symptoms;
	}

	public Disease getDisease() {
		return disease;
	}

	public void setDisease(Disease disease) {
		this.disease = disease;
	}

	public List<String> getMedicnie() {
		return medicnie;
	}

	public void setMedicnie(List<String> medicnie) {
		this.medicnie = medicnie;
	}

	public List<SymptomDto> getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(List<SymptomDto> symptoms) {
		this.symptoms = symptoms;
	}

}
