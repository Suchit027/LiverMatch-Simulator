package patient_data;

public class ListOfPatients extends Patient {
	ListOfPatients link; // link to next patient

// default constructor
	public ListOfPatients() {
		super();
		link = null;
	}

	public ListOfPatients(String name, String hos, String pa) {
		super(name, hos, pa);
		link = null;
	}

// adding new patient to the list
//	this function is always to be called from the header node
//	header node will be created with the default constructor
	synchronized public void add(ListOfPatients ob) {

		ListOfPatients head = this; // header node of the list
		// if list is empty
		if (head.link == null) {
			head.link = ob;
			ob.link = null;
			return;
		}
		ListOfPatients pre = head; // to denote the previous node in the list
		for (ListOfPatients first = head.link; first != null; first = first.link, pre = pre.link) {
			if (first.meld_score > ob.meld_score) {
				continue;
			} else if (first.meld_score < ob.meld_score) {
				pre.link = ob;
				ob.link = first;
				break;
			} else {
				if (ob.rank < first.rank) {
					pre.link = ob;
					ob.link = first;
				} else {
					ob.link = first.link;
					first.link = ob;
				}
				break;
			}
		}
	}

// removing a patient from the list if his blood type matches with the liver
	synchronized public ListOfPatients pop(String liver_blood) {
		ListOfPatients head = this;
		if (head.link == null) {
			resetCount(); // if list is empty; then setting no. of patients to zero
			return null;
		}
		ListOfPatients first = head.link;
		for (; first != null; first = first.link, head = head.link) {
			if (first.blood_type.equals(liver_blood)) {
				ListOfPatients ans = first;
				head.link = first.link;
				return ans;
			}
		}
		return null;
	}

	public boolean peek() {
		if (link == null) {
			return true;
		} else {
			return false;
		}
	}

	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hos) {
		hospital = hos;
		return;
	}
}
