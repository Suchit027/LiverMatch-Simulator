package fxui;

import Hospitals.Hospital;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import patient_data.Liver;
import patient_data.ListOfPatients;

public class ui extends Application implements Hospital {

	ListOfPatients pat1, pat2, pat3, hosA_list, hosB_list, hosC_list, hosD_list;
	Liver liver1, liver2, liver3;
	String result1;
	String result2;
	String result3;

	public void create_list(ListOfPatients p) {
		switch (p.getHospital()) {
		case "A":
			hosA_list.add(p);
			break;
		case "B":
			hosB_list.add(p);
			break;
		case "C":
			hosC_list.add(p);
			break;
		case "D":
			hosD_list.add(p);
			break;
		}
	}

	public ListOfPatients nearby_hos(String hos) {
		switch (hos) {
		case "A":
			return hosB_list;
		case "B":
			return hosC_list;
		case "C":
			return hosD_list;
		case "D":
			return hosA_list;
		}
		return null;
	}

	public String driver(Liver ob) {
		var res = new String();
		String ori_hos = ob.getHospital();
		ListOfPatients temp = null;
		switch (ob.getHospital()) {
		case "A":
			temp = hosA_list;
			break;
		case "B":
			temp = hosB_list;
			break;
		case "C":
			temp = hosC_list;
			break;
		case "D":
			temp = hosD_list;
			break;
		}
		for (int check = 0; check <= 3; ++check) {
			if (temp.peek() == true) {
				temp = this.nearby_hos(ob.getHospital());
				ob.setHospital(temp.getHospital());
				continue;
			} else {
				ListOfPatients temp1 = temp.pop(ob.getBloodType());
				if (temp1 == null) {
					temp = this.nearby_hos(ob.getHospital());
					ob.setHospital(temp.getHospital());
					continue;
				}
				res = "Patient " + temp1.getName() + " gets liver from hospital " + ori_hos;
				return res;
			}
		}
		res = "No patient matched with liver blood type";
		return res;
	}

	public static void main(String[] args) {

		launch(args);
	}

	String name1, name2, name3, hos_pat3, blood_pat3, hos_pat1, hos_pat2, blood_pat1, blood_pat2, hos_liv1, hos_liv2,
			hos_liv3, blood_liv1, blood_liv2, blood_liv3;
	int creatinine1, t_bilirubin1, inr1, creatinine2, t_bilirubin2, inr2, creatinine3, t_bilirubin3, inr3;

	public void start(Stage mystage) {
		hosA_list = new ListOfPatients();
		hosA_list.setHospital("A");
		hosB_list = new ListOfPatients();
		hosB_list.setHospital("B");
		hosC_list = new ListOfPatients();
		hosC_list.setHospital("C");
		hosD_list = new ListOfPatients();
		hosD_list.setHospital("D");
		result1 = new String();
		result2 = new String();
		result3 = new String();
		var rootnode = new GridPane();
		rootnode.setMinSize(400, 400);
		rootnode.setPadding(new Insets(10, 10, 10, 10));
		rootnode.setVgap(10);
		rootnode.setHgap(10);
		rootnode.setAlignment(Pos.CENTER);
		var myscene = new Scene(rootnode, 600, 600);
		rootnode.setAlignment(Pos.CENTER);
		mystage.setScene(myscene);
		ObservableList<String> patient_blood = FXCollections.observableArrayList("AB+", "AB-", "B+", "B-", "O+", "O-",
				"A-", "A+");
		ObservableList<String> patient_hos = FXCollections.observableArrayList("A", "B", "C", "D");

		var lab_pat1 = new Label("1");
		var lab_pat2 = new Label("2");
		var lab_pat3 = new Label("3");
		var lab_liv1 = new Label("1");
		var lab_liv2 = new Label("2");
		var lab_liv3 = new Label("3");
		var lab_patientName = new Label("Patient Name");
		var lab_patientHos = new Label("Hospital");
		var lab_patientBlood = new Label("Blood Group");
		var lab_creatinine = new Label("Creatinine");
		var lab_totalBilirubin = new Label("Total Bilirubin");
		var lab_inr = new Label("INR");

		var tx_pat1_name = new TextField();
		tx_pat1_name.setPrefColumnCount(15);
		tx_pat1_name.setText("1");
		name1 = tx_pat1_name.getText();
		tx_pat1_name.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				name1 = tx_pat1_name.getText();
			}
		});

		var cb_pat1_hos = new ComboBox<String>(patient_hos);
		cb_pat1_hos.setValue("A");
		hos_pat1 = cb_pat1_hos.getValue();
		cb_pat1_hos.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				hos_pat1 = cb_pat1_hos.getValue();
			}
		});

		var cb_pat1_blood = new ComboBox<String>(patient_blood);
		cb_pat1_blood.setValue("AB+");
		blood_pat1 = cb_pat1_blood.getValue();
		cb_pat1_blood.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				blood_pat1 = cb_pat1_blood.getValue();
			}
		});

		var tx_pat1_creatinine = new TextField();
		tx_pat1_creatinine.setPrefColumnCount(5);
		tx_pat1_creatinine.setText("1");
		creatinine1 = 1;
		tx_pat1_creatinine.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				creatinine1 = Integer.parseInt(tx_pat1_creatinine.getText());
			}
		});

		var tx_pat1_totalBilirubin = new TextField();
		tx_pat1_totalBilirubin.setPrefColumnCount(5);
		tx_pat1_totalBilirubin.setText("1");
		t_bilirubin1 = 1;
		tx_pat1_totalBilirubin.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				t_bilirubin1 = Integer.parseInt(tx_pat1_totalBilirubin.getText());
			}
		});

		var tx_pat1_inr = new TextField();
		tx_pat1_inr.setPrefColumnCount(5);
		tx_pat1_inr.setText("1");
		inr1 = 1;
		tx_pat1_inr.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				inr1 = Integer.parseInt(tx_pat1_inr.getText());
			}
		});

		var tx_pat2_name = new TextField();
		tx_pat2_name.setPrefColumnCount(15);
		tx_pat2_name.setText("2");
		name2 = tx_pat2_name.getText();
		tx_pat2_name.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				name2 = tx_pat2_name.getText();
			}
		});

		var cb_pat2_hos = new ComboBox<String>(patient_hos);
		cb_pat2_hos.setValue("A");
		hos_pat2 = cb_pat2_hos.getValue();
		cb_pat2_hos.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				hos_pat2 = cb_pat2_hos.getValue();
			}
		});

		var cb_pat2_blood = new ComboBox<String>(patient_blood);
		cb_pat2_blood.setValue("AB+");
		blood_pat2 = cb_pat2_blood.getValue();
		cb_pat2_blood.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				blood_pat2 = cb_pat2_blood.getValue();
			}
		});

		var tx_pat2_creatinine = new TextField();
		tx_pat2_creatinine.setPrefColumnCount(5);
		tx_pat2_creatinine.setText("2");
		creatinine2 = 2;
		tx_pat2_creatinine.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				creatinine2 = Integer.parseInt(tx_pat2_creatinine.getText());
			}
		});

		var tx_pat2_totalbilirubin = new TextField();
		tx_pat2_totalbilirubin.setPrefColumnCount(5);
		tx_pat2_totalbilirubin.setText("2");
		t_bilirubin2 = 1;
		tx_pat2_totalbilirubin.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				t_bilirubin2 = Integer.parseInt(tx_pat2_totalbilirubin.getText());
			}
		});

		var tx_pat2_inr = new TextField();
		tx_pat2_inr.setPrefColumnCount(5);
		tx_pat2_inr.setText("2");
		inr2 = 2;
		tx_pat2_inr.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				inr2 = Integer.parseInt(tx_pat2_inr.getText());
			}
		});

		var tx_pat3_name = new TextField();
		tx_pat3_name.setPrefColumnCount(15);
		tx_pat3_name.setText("3");
		name3 = tx_pat3_name.getText();
		tx_pat3_name.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				name3 = tx_pat3_name.getText();
			}
		});

		var cb_pat3_hos = new ComboBox<String>(patient_hos);
		cb_pat3_hos.setValue("A");
		hos_pat3 = cb_pat3_hos.getValue();
		cb_pat3_hos.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				hos_pat3 = cb_pat3_hos.getValue();
			}
		});

		var cb_pat3_blood = new ComboBox<String>(patient_blood);
		cb_pat3_blood.setValue("AB+");
		blood_pat3 = cb_pat3_blood.getValue();
		cb_pat3_blood.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				blood_pat3 = cb_pat3_blood.getValue();
			}
		});

		var tx_pat3_creatinine = new TextField();
		tx_pat3_creatinine.setPrefColumnCount(5);
		tx_pat3_creatinine.setText("3");
		creatinine3 = 3;
		tx_pat3_creatinine.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				creatinine3 = Integer.parseInt(tx_pat3_creatinine.getText());
			}
		});

		var tx_pat3_totalbilirubin = new TextField();
		tx_pat3_totalbilirubin.setPrefColumnCount(5);
		tx_pat3_totalbilirubin.setText("3");
		t_bilirubin3 = 3;
		tx_pat3_totalbilirubin.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				t_bilirubin3 = Integer.parseInt(tx_pat3_totalbilirubin.getText());
			}
		});

		var tx_pat3_inr = new TextField();
		tx_pat3_inr.setPrefColumnCount(5);
		tx_pat3_inr.setText("3");
		inr3 = 3;
		tx_pat3_inr.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				inr3 = Integer.parseInt(tx_pat3_inr.getText());
			}
		});

		var lab_liver_blood = new Label("Liver Blood Type");
		var lab_liver_hos = new Label("Liver Hospital");

		var cb_liv1_blood = new ComboBox<String>(patient_blood);
		cb_liv1_blood.setValue("AB+");
		blood_liv1 = cb_liv1_blood.getValue();
		cb_liv1_blood.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				blood_liv1 = cb_liv1_blood.getValue();
			}
		});

		var cb_liv1_hos = new ComboBox<String>(patient_hos);
		cb_liv1_hos.setValue("A");
		hos_liv1 = cb_liv1_hos.getValue();
		cb_liv1_hos.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				hos_liv1 = cb_liv1_hos.getValue();
			}
		});

		var cb_liv2_blood = new ComboBox<String>(patient_blood);
		cb_liv2_blood.setValue("AB+");
		blood_liv2 = cb_liv2_blood.getValue();
		cb_liv2_blood.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				blood_liv2 = cb_liv2_blood.getValue();
			}
		});

		var cb_liv2_hos = new ComboBox<String>(patient_hos);
		cb_liv2_hos.setValue("A");
		hos_liv2 = cb_liv2_hos.getValue();
		cb_liv2_hos.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				hos_liv2 = cb_liv2_hos.getValue();
			}
		});

		var cb_liv3_blood = new ComboBox<String>(patient_blood);
		cb_liv3_blood.setValue("AB+");
		blood_liv3 = cb_liv3_blood.getValue();
		cb_liv3_blood.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				blood_liv3 = cb_liv3_blood.getValue();
			}
		});

		var cb_liv3_hos = new ComboBox<String>(patient_hos);
		cb_liv3_hos.setValue("A");
		hos_liv3 = cb_liv3_hos.getValue();
		cb_liv3_hos.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				hos_liv3 = cb_liv3_hos.getValue();
			}
		});

		var but_cal = new Button("Compute");
		var ob = this;
		but_cal.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				pat1 = new ListOfPatients(name1, hos_pat1, blood_pat1);
				pat1.setScore(creatinine1, t_bilirubin1, inr1);
				ob.create_list(pat1);
				pat2 = new ListOfPatients(name2, hos_pat2, blood_pat2);
				pat2.setScore(creatinine2, t_bilirubin2, inr2);
				ob.create_list(pat2);
				pat3 = new ListOfPatients(name3, hos_pat3, blood_pat3);
				pat3.setScore(creatinine3, t_bilirubin3, inr3);
				ob.create_list(pat3);
				liver1 = new Liver(blood_liv1, hos_liv1);
				liver2 = new Liver(blood_liv2, hos_liv2);
				liver3 = new Liver(blood_liv3, hos_liv3);
				result1 = ob.driver(liver1);
				result2 = ob.driver(liver2);
				result3 = ob.driver(liver3);
			}
		});

		lab_patientName.setAlignment(Pos.CENTER);
		lab_patientHos.setAlignment(Pos.CENTER);
		lab_patientBlood.setAlignment(Pos.CENTER);
		lab_creatinine.setAlignment(Pos.CENTER);
		lab_totalBilirubin.setAlignment(Pos.CENTER);
		lab_inr.setAlignment(Pos.CENTER);
		lab_liver_blood.setAlignment(Pos.CENTER);
		lab_liver_hos.setAlignment(Pos.CENTER);

		var lab_res1 = new Label();
		lab_res1.setText(result1);
		var lab_res2 = new Label(result2);
		lab_res2.setText(result2);
		var lab_res3 = new Label(result3);
		lab_res3.setText(result3);
		var lab_pat = new Label("For Patients -");
		var lab_liv = new Label("For Liver -");

		rootnode.add(lab_pat, 0, 0);
		rootnode.add(lab_pat1, 0, 1);
		rootnode.add(lab_pat2, 0, 2);
		rootnode.add(lab_pat3, 0, 3);
		rootnode.add(lab_patientName, 1, 0);
		rootnode.add(lab_patientHos, 2, 0);
		rootnode.add(lab_patientBlood, 3, 0);
		rootnode.add(lab_creatinine, 4, 0);
		rootnode.add(lab_totalBilirubin, 5, 0);
		rootnode.add(lab_inr, 6, 0);
		rootnode.add(tx_pat1_name, 1, 1);
		rootnode.add(tx_pat1_creatinine, 4, 1);
		rootnode.add(tx_pat1_totalBilirubin, 5, 1);
		rootnode.add(tx_pat1_inr, 6, 1);
		rootnode.add(cb_pat1_hos, 2, 1);
		rootnode.add(cb_pat1_blood, 3, 1);
		rootnode.add(tx_pat2_name, 1, 2);
		rootnode.add(tx_pat2_creatinine, 4, 2);
		rootnode.add(tx_pat2_totalbilirubin, 5, 2);
		rootnode.add(tx_pat2_inr, 6, 2);
		rootnode.add(cb_pat2_hos, 2, 2);
		rootnode.add(cb_pat2_blood, 3, 2);
		rootnode.add(tx_pat3_name, 1, 3);
		rootnode.add(tx_pat3_creatinine, 4, 3);
		rootnode.add(tx_pat3_totalbilirubin, 5, 3);
		rootnode.add(tx_pat3_inr, 6, 3);
		rootnode.add(cb_pat3_hos, 2, 3);
		rootnode.add(cb_pat3_blood, 3, 3);
		rootnode.add(lab_liv, 0, 4);
		rootnode.add(lab_liv1, 0, 5);
		rootnode.add(lab_liv2, 0, 6);
		rootnode.add(lab_liv3, 0, 7);
		rootnode.add(lab_liver_blood, 1, 4);
		rootnode.add(lab_liver_hos, 2, 4);
		rootnode.add(cb_liv1_blood, 1, 5);
		rootnode.add(cb_liv1_hos, 2, 5);
		rootnode.add(cb_liv2_blood, 1, 6);
		rootnode.add(cb_liv2_hos, 2, 6);
		rootnode.add(cb_liv3_blood, 1, 7);
		rootnode.add(cb_liv3_hos, 2, 7);
		rootnode.add(but_cal, 0, 8);
//		rootnode.add(lab_res1, 0, 9);
//		rootnode.add(lab_res2, 0, 10);
//		rootnode.add(lab_res3, 0, 11);

		mystage.show();
	}

	public void stop() {

		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
	}
}
