package patient_data;

public class Patient_list extends Patient {
	Patient_list link; // link to next patient

// default constructor
	public Patient_list() {
		super();
		link = null;
	}
	protected Patient_list(String name, String hos, String pa) {
		super(name, hos, pa);
		link = null;
	}

// adding new patient to the list
	public Patient_list add(Patient_list ob) {

		Patient_list temp = this;
		if (temp.link == null) {
			if (temp.meld_score >= ob.meld_score) {	// first meld score is used to sort
				if (temp.meld_score == ob.meld_score) {
					if (temp.rank > ob.rank) {// then rank is used if meld score is same
						ob.link = temp;
						return ob;
					} else {
						temp.link = ob;
						return temp;
					}
				}
				temp.link = ob;
				return temp;
			}
			ob.link = temp;
			return ob;
		}
		while (temp.link != null && temp.link.meld_score > ob.meld_score) {
			temp = temp.link;
		}
		ob.link = temp.link;
		temp.link = ob;
		return this;
	}

// removing a patient from the list if his blood type matches with the liver
	public Patient_list pop(String liver_blood) {
		if(this == null) {
			resetCount();	// if list is empty; then setting no. of patients to zero
			return null;
		}
		Patient_list head = new Patient_list();
		head.link = this;
		while(head.link != null) {
			if(head.link.blood_type == liver_blood) {
				Patient_list ans = head.link;
				head.link = head.link.link;
				return ans;
			}
			head = head.link;
		}
		return null;
	}
}
