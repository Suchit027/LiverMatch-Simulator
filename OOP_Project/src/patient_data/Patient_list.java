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
//	this function is always to be called from the header node
//	header node will be created with the default constructor
	public void add(Patient_list ob) {

		Patient_list head = this; // header node of the list
		// if list is empty
		if (head.link == null) {
			head.link = ob;
			return;
		}
		Patient_list pre = head; // to denote the previous node in the list
		for (Patient_list first = head.link; first != null; first = first.link, pre = pre.link) {
			if (first.meld_score > ob.meld_score) {
				continue;
			} else if (first.meld_score < ob.meld_score) {
				pre.link = ob;
				ob.link = first;
			} else {
				if (ob.rank < first.rank) {
					pre.link = ob;
					ob.link = first;
				} else {
					ob.link = first.link;
					first.link = ob;
				}
			}
		}
	}

// removing a patient from the list if his blood type matches with the liver
	public Patient_list pop(String liver_blood) {
		Patient_list head = this;
		if (head.link == null) {
			resetCount(); // if list is empty; then setting no. of patients to zero
			return null;
		}
		Patient_list pre = head;
		for (Patient_list first = head.link; first != null; first = first.link, pre = pre.link) {
			if (first.blood_type == liver_blood) {
				Patient_list ans = first;
				pre.link = first.link;
				return ans;
			}
		}
		return null;
	}
}
