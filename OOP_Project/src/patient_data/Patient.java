package patient_data;

public class Patient extends MedicalData{
	protected String name, hospital; // name of patient and hospital name
	protected double meld_score; // meld score to calculate liver transplant patient priority
	static int patient_count = 0; // no. of patients in the list
	protected int rank;

	protected Patient(String name, String hos, String b) {
		super(b);
		++patient_count;
		this.name = name;
		hospital = hos;
		setRank();
	}
	
// default constructor
	public Patient() {
		super();
		name = "none";
		hospital = "none";
	}

// for setting meld score of a patient which may change in real time due to medical conditions
	protected void setScore(double creatinine, double total_bilirubin, double inr) {
		meld_score = (9.57 * Math.log(creatinine)) + (3.78 * Math.log(total_bilirubin)) + (11.2 * Math.log(inr)) + 6.43;
	}
	
// synchronizing this method, as with large data call from different threads might give unfair rank to some
	synchronized private void setRank() {
		rank = patient_count;
	}
	
	protected resetCount() {
		patient_count = 0;
	}
}
