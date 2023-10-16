package patient_data;

public class LiverClass extends Medical_data {
	protected String Hospital; // Hospital Name

	public LiverClass() // Default Constructor
	{
		super();
		Hospital = "none";
	}

	public LiverClass(String B, String H) {
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
}
