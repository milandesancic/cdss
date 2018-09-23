package rs.uns.ac.ftn.cdss.dto;

import java.util.ArrayList;

public class AllergiesDto {
	private boolean succes;
	private ArrayList<String> allergies = new ArrayList<>();

	public AllergiesDto() {
	}

	public boolean isSucces() {
		return succes;
	}

	public void setSucces(boolean succes) {
		this.succes = succes;
	}

	public ArrayList<String> getAllergies() {
		return allergies;
	}

	public void setAllergies(ArrayList<String> allergies) {
		this.allergies = allergies;
	}

}
