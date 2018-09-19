package rs.uns.ac.ftn.cdss.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="patient_record")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Record {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	private Disease disease;

	@ManyToMany()
	private Collection<Symptom> symptoms = new ArrayList<>();

	@ManyToMany()
	private Collection<Medicine> medicine = new ArrayList<>();

	@ManyToOne
	private User doctor;

	@Column
	private Date date;

	public Record() {
	}

	public Record(Disease disease, ArrayList<Symptom> symptoms) {
		this.disease = disease;
		this.symptoms = symptoms;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Disease getDisease() {
		return disease;
	}

	public void setDisease(Disease disease) {
		this.disease = disease;
	}

	public Collection<Symptom> getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(Collection<Symptom> symptoms) {
		this.symptoms = symptoms;
	}

	public Collection<Medicine> getMedicine() {
		return medicine;
	}

	public void setMedicine(Collection<Medicine> medicine) {
		this.medicine = medicine;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getDoctor() {
		return doctor;
	}

	public void setDoctor(User doctor) {
		this.doctor = doctor;
	}

	public boolean last60Days() {
		Date now = new Date();
		Calendar cal = new GregorianCalendar();
		cal.setTime(now);
		cal.add(Calendar.DAY_OF_MONTH, -60);
		Date res = cal.getTime();

		if (this.date != null) {
			if (res.before(this.date)) {
				return true;
			}
		}
		return false;
	}

	public boolean last6Months() {
		Date now = new Date();
		Calendar cal = new GregorianCalendar();
		cal.setTime(now);
		cal.add(Calendar.MONTH, -6);
		Date res = cal.getTime();

		if (this.date != null) {
			if (res.before(this.date)) {
				return true;
			}
		}
		return false;
	}

	public boolean moreThan6Months() {
		Date now = new Date();
		Calendar cal = new GregorianCalendar();
		cal.setTime(now);
		cal.add(Calendar.MONTH, -6);
		Date res = cal.getTime();

		if (this.date != null) {
			if (res.after(this.date)) {
				return true;
			}
		}
		return false;
	}

	public boolean last21Days() {
		Date now = new Date();
		Calendar cal = new GregorianCalendar();
		cal.setTime(now);
		cal.add(Calendar.DAY_OF_MONTH, -21);
		Date res = cal.getTime();

		if (this.date != null) {
			if (res.before(this.date)) {
				return true;
			}
		}
		return false;
	}

	public boolean last14Days() {
		Date now = new Date();
		Calendar cal = new GregorianCalendar();
		cal.setTime(now);
		cal.add(Calendar.DAY_OF_MONTH, -14);
		Date res = cal.getTime();

		if (this.date != null) {
			if (res.before(this.date)) {
				return true;
			}
		}
		return false;
	}

	public boolean last2Years() {
		Date now = new Date();
		Calendar cal = new GregorianCalendar();
		cal.setTime(now);
		cal.add(Calendar.YEAR, -2);
		Date res = cal.getTime();

		if (this.date != null) {
			if (res.before(this.date)) {
				return true;
			}
		}
		return false;
	}


	
	public boolean containsAnalgetics() {
		for(Medicine m:this.medicine){
			if(m.getMedicineType().equals(MedicineType.ANALGETIC))
				return true;
		}
		return false;

	}
	
	
	
	
	

}
