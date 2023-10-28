package patient_data;

public class Medical_data {
	String blood_type;	// blood type for liver and patient

	// this is a default constructor
	protected Medical_data() {
		blood_type = "none";
	}

	// this is a parameterized constructor
	protected Medical_data(String blood_type) {
		this.blood_type = blood_type;
	}

	public static boolean compatibility(Liver liver, Patient patient) {
		if (liver.blood_type == patient.blood_type) {
			return true;
		} else {
			return false;
		}
	}
}
