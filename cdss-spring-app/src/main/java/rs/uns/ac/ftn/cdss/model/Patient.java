package rs.uns.ac.ftn.cdss.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import rs.uns.ac.ftn.cdss.dto.PatientDto;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false,name="first_name")
	private String name;
	@Column(nullable = false,name="last_name")
	private String lastName;

	@OneToMany(fetch = FetchType.EAGER)
	private Set<Record> patientHistory = new HashSet<>();

	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Medicine> medicineAllergies = new HashSet<>();

	@ManyToMany(fetch = FetchType.EAGER)
	private Set<MedicineComponent> componentAllergies = new HashSet<>();

	public Patient() {

	}
	
	public Patient(PatientDto p) {
		this.name = p.getFirstName();
		this.lastName = p.getLastName();
		this.patientHistory = new HashSet<>();
		this.componentAllergies = new HashSet<>();
		this.medicineAllergies = new HashSet<>();
		
	}

	public Patient(long l, String name) {
		this.id = l;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Record> getPatientHistory() {
		return patientHistory;
	}

	public void setPatientHistory(Set<Record> patientHistory) {
		this.patientHistory = patientHistory;
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

	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", lastName=" + lastName + ", patientHistory=" + patientHistory
				+ ", medicineAllergies=" + medicineAllergies + ", componentAllergies=" + componentAllergies + "]";
	}
	
	

}
