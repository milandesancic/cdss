package rs.uns.ac.ftn.cdss.dto;

public class SymptomDto {

	private String name;
	private int value;

	public SymptomDto() {
	}

	public SymptomDto(String name, int value) {
		super();
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
