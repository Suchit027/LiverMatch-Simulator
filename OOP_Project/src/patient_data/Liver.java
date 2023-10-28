package patient_data;

public class Liver extends Medical_data {
	protected String Hospital; // Hospital Name

	public Liver() // Default Constructor
	{
		super();
		Hospital = "none";
	}

	public Liver(String B, String H) {
		super(B);
		Hospital = H;
	}

	// Returning BloodType
	public String getBloodType() {
		return blood_type;
	}

	// Returning Hospital Name
	public String getHospital() {
		return Hospital;
	}

	public void setHospital(String hos) {
		Hospital = hos;
		return;
	}
}
