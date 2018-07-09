package rs.uns.ac.ftn.cdss.dto;

import java.util.List;

public class DiseaseDto {

	private String name;
	private List<SymptomDto> symptoms;

	public DiseaseDto() {
	}

	public DiseaseDto(String name, List<SymptomDto> symptoms) {
		super();
		this.name = name;
		this.symptoms = symptoms;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SymptomDto> getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(List<SymptomDto> symptoms) {
		this.symptoms = symptoms;
	}

}
