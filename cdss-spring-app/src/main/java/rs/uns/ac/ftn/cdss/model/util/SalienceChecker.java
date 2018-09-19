package rs.uns.ac.ftn.cdss.model.util;

public class SalienceChecker {

	public int salience = 0;
	protected int maxSymptomNum = 0;
	protected boolean allSatisfied = false;

	public SalienceChecker() {
	}

	public SalienceChecker(int maxSymptomNum) {
		this.salience = 0;
		this.maxSymptomNum = maxSymptomNum;
		this.allSatisfied = false;
	}

	public void addSymptom() {
		if (this.allSatisfied)
			return;

		this.salience++;

		if (this.salience == this.maxSymptomNum) {
			this.allSatisfied = true;
		}
	}

	public void removeSymptom() {
		this.salience--;
	}

	public int getSalience() {
		return salience;
	}

	public void setSalience(int salience) {
		this.salience = salience;
	}

	public int getMaxSymptomNum() {
		return maxSymptomNum;
	}

	public void setMaxSymptomNum(int maxSymptomNum) {
		this.maxSymptomNum = maxSymptomNum;
	}

	public boolean isAllSatisfied() {
		return allSatisfied;
	}

}
