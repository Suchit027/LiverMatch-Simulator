package Medical_data;

public class Medical_data {
    String blood_type;

    Medical_data() {
        blood_type = "none";
    }// this is a default constructor

    Medical_data(String blood_type) {
        this.blood_type = blood_type;
    }// this is a parameterized constructor

    public static boolean compatibility(Liver liver, Patient patient) {
        if (liver.blood_type == patient.blood_type) {
            return true;
        } else {
            return false;
        }
    }
}
