package rs.uns.ac.ftn.cdss.dto;

import java.util.HashSet;
import java.util.Set;

import rs.uns.ac.ftn.cdss.model.Medicine;
import rs.uns.ac.ftn.cdss.model.MedicineComponent;

public class PatientDto {

	private String firstName;
	private String lastName;

	private Set<Medicine> medicineAllergies = new HashSet<>();
	private Set<MedicineComponent> componentAllergies = new HashSet<>();

	public PatientDto() {

		medicineAllergies = new HashSet<>();
		componentAllergies = new HashSet<>();
	}

	public PatientDto(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		medicineAllergies = new HashSet<>();
		componentAllergies = new HashSet<>();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Medicine> getMedicineAllergies() {
		return medicineAllergies;
	}

	public void setMedicineAllergies(Set<Medicine> medicineAllergies) {
		this.medicineAllergies = medicineAllergies;
	}

	public Set<MedicineComponent> getComponentAllergies() {
		return componentAllergies;
	}

	public void setComponentAllergies(Set<MedicineComponent> componentAllergies) {
		this.componentAllergies = componentAllergies;
	}

}
