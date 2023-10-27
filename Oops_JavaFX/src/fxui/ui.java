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
import patient_data.LiverClass;
import patient_data.Patient_list;

public class ui extends Application implements Hospital {

	Patient_list p1, p2, p3, head_A, head_B, head_C, head_D;
	LiverClass l1, l2, l3;
	String res1;
	String res2;
	String res3;

	public void create_list(Patient_list p) {
		switch (p.getHospital()) {
		case "A":
			head_A.add(p);
			break;
		case "B":
			head_B.add(p);
			break;
		case "C":
			head_C.add(p);
			break;
		case "D":
			head_D.add(p);
			break;
		}
	}

	public Patient_list nearby_hos(String hos) {
		switch (hos) {
		case "A":
			return head_B;
		case "B":
			return head_C;
		case "C":
			return head_D;
		case "D":
			return head_A;
		}
		return null;
	}

	public String driver(LiverClass ob) {
		var res = new String();
		String ori_hos = "";
		Patient_list temp = new Patient_list();
		switch (ob.getHospital()) {
		case "A":
			temp = head_A;
			ori_hos = "A";
			break;
		case "B":
			temp = head_B;
			ori_hos = "B";
			break;
		case "C":
			temp = head_C;
			ori_hos = "C";
			break;
		case "D":
			temp = head_D;
			ori_hos = "D";
			break;
		}
		for (int check = 0; check <= 3; ++check) {
			if (temp.peek(ob.getBloodType()) == null) {
				temp = this.nearby_hos(ob.getHospital());
				continue;
			} else {
				temp = temp.pop(ob.getBloodType());
				res = "Patient " + temp.getName() + " gets liver from hospital " + ori_hos;
				return res;
			}
		}
		res = "No patient matched with liver blood type";
		return res;
	}

	public static void main(String[] args) {

		launch(args);
	}

	String name1, name2, name3, hos3, b3, hos1, hos2, b1, b2;
	int c1, tb1, i1, c2, tb2, i2, c3, tb3, i3;

	public void start(Stage mystage) {
		head_A = new Patient_list();
		head_B = new Patient_list();
		head_C = new Patient_list();
		head_D = new Patient_list();
		res1 = new String();
		res2 = new String();
		res3 = new String();
		var rootnode = new GridPane();
		rootnode.setMinSize(400, 400);
		rootnode.setPadding(new Insets(10, 10, 10, 10));
		rootnode.setVgap(5);
		rootnode.setHgap(5);
		rootnode.setAlignment(Pos.CENTER);
		var myscene = new Scene(rootnode, 600, 600);
		rootnode.setAlignment(Pos.CENTER);
		mystage.setScene(myscene);
		ObservableList<String> p_blood = FXCollections.observableArrayList("AB+", "AB-", "B+", "B-", "O+", "O-", "A-",
				"A+");
		ObservableList<String> p_hos = FXCollections.observableArrayList("A", "B", "C", "D");

		var lab1 = new Label("S.No.");
		var lab2 = new Label("Patient Name");
		var lab3 = new Label("Hospital");
		var lab4 = new Label("Blood Group");
		var lab5 = new Label("Creatinine");
		var lab6 = new Label("Total Bilirubin");
		var lab7 = new Label("INR");

		var tx1_1 = new TextField();
		tx1_1.setPrefColumnCount(15);
		tx1_1.setText("1");
		name1 = tx1_1.getText();
		tx1_1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				name1 = tx1_1.getText();
			}
		});

		var cb1_1 = new ComboBox<String>(p_hos);
		cb1_1.setValue("A");
		hos1 = cb1_1.getValue();
		cb1_1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				hos1 = cb1_1.getValue();
			}
		});

		var cb1_2 = new ComboBox<String>(p_blood);
		cb1_2.setValue("A");
		b1 = cb1_2.getValue();
		cb1_2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				b1 = cb1_2.getValue();
			}
		});

		var tx1_2 = new TextField();
		tx1_2.setPrefColumnCount(5);
		tx1_2.setText("1");
		c1 = 1;
		tx1_2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				c1 = Integer.parseInt(tx1_2.getText());
			}
		});

		var tx1_3 = new TextField();
		tx1_3.setPrefColumnCount(5);
		tx1_3.setText("1");
		tb1 = 1;
		tx1_3.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				tb1 = Integer.parseInt(tx1_3.getText());
			}
		});

		var tx1_4 = new TextField();
		tx1_4.setPrefColumnCount(5);
		tx1_4.setText("1");
		i1 = 1;
		tx1_4.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				i1 = Integer.parseInt(tx1_4.getText());
			}
		});

		var tx2_1 = new TextField();
		tx2_1.setPrefColumnCount(15);
		tx2_1.setText("2");
		name2 = tx2_1.getText();
		tx2_1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				name2 = tx2_1.getText();
			}
		});

		var cb2_1 = new ComboBox<String>(p_hos);
		cb2_1.setValue("A");
		hos2 = cb2_1.getValue();
		cb2_1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				hos2 = cb2_1.getValue();
			}
		});

		var cb2_2 = new ComboBox<String>(p_blood);
		cb2_2.setValue("A");
		b2 = cb2_2.getValue();
		cb2_2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				b2 = cb2_2.getValue();
			}
		});

		var tx2_2 = new TextField();
		tx2_2.setPrefColumnCount(5);
		tx2_2.setText("2");
		c2 = 2;
		tx2_2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				c2 = Integer.parseInt(tx2_2.getText());
			}
		});

		var tx2_3 = new TextField();
		tx2_3.setPrefColumnCount(5);
		tx2_3.setText("2");
		tb2 = 1;
		tx2_3.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				tb2 = Integer.parseInt(tx2_3.getText());
			}
		});

		var tx2_4 = new TextField();
		tx2_4.setPrefColumnCount(5);
		tx2_4.setText("2");
		i2 = 2;
		tx2_4.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				i2 = Integer.parseInt(tx2_4.getText());
			}
		});

		var tx3_1 = new TextField();
		tx3_1.setPrefColumnCount(15);
		tx3_1.setText("3");
		name3 = tx3_1.getText();
		tx3_1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				name3 = tx3_1.getText();
			}
		});

		var cb3_1 = new ComboBox<String>(p_hos);
		cb3_1.setValue("A");
		hos3 = cb3_1.getValue();
		cb3_1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				hos3 = cb3_1.getValue();
			}
		});

		var cb3_2 = new ComboBox<String>(p_blood);
		cb3_2.setValue("A");
		b3 = cb3_2.getValue();
		cb3_2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				b3 = cb3_2.getValue();
			}
		});

		var tx3_2 = new TextField();
		tx3_2.setPrefColumnCount(5);
		tx3_2.setText("3");
		c3 = 3;
		tx3_2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				c3 = Integer.parseInt(tx3_2.getText());
			}
		});

		var tx3_3 = new TextField();
		tx3_3.setPrefColumnCount(5);
		tx3_3.setText("3");
		tb3 = 3;
		tx3_3.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				tb3 = Integer.parseInt(tx3_3.getText());
			}
		});

		var tx3_4 = new TextField();
		tx3_4.setPrefColumnCount(5);
		tx3_4.setText("3");
		i3 = 3;
		tx3_4.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				i3 = Integer.parseInt(tx3_4.getText());
			}
		});

		var lab8 = new Label("S.No.");
		var lab9 = new Label("Blood Type");
		var lab10 = new Label("Hospital");

		var cbl1_1 = new ComboBox<String>(p_blood);
		cbl1_1.setValue("A");
		b1 = cbl1_1.getValue();
		cbl1_1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				b1 = cbl1_1.getValue();
			}
		});

		var cbl1_2 = new ComboBox<String>(p_hos);
		cbl1_2.setValue("A");
		hos1 = cbl1_2.getValue();
		cbl1_2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				hos1 = cbl1_2.getValue();
			}
		});

		var cbl2_1 = new ComboBox<String>(p_blood);
		cbl2_1.setValue("A");
		b2 = cbl2_1.getValue();
		cbl2_1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				b2 = cbl2_1.getValue();
			}
		});

		var cbl2_2 = new ComboBox<String>(p_hos);
		cbl2_2.setValue("A");
		hos2 = cbl2_2.getValue();
		cbl2_2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				hos2 = cbl2_2.getValue();
			}
		});

		var cbl3_1 = new ComboBox<String>(p_blood);
		cbl3_1.setValue("A");
		b3 = cbl3_1.getValue();
		cbl3_1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				b3 = cbl3_1.getValue();
			}
		});

		var cbl3_2 = new ComboBox<String>(p_hos);
		cbl3_2.setValue("A");
		hos3 = cbl3_2.getValue();
		cbl3_2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				hos3 = cbl3_2.getValue();
			}
		});

		var but = new Button("Calculate");
		var ob = this;
		but.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				p1 = new Patient_list(name1, hos1, b1);
				p1.setScore(c1, tb1, i1);
				ob.create_list(p1);
				p2 = new Patient_list(name2, hos2, b2);
				p2.setScore(c2, tb2, i2);
				ob.create_list(p2);
				p3 = new Patient_list(name3, hos3, b3);
				p3.setScore(c3, tb3, i3);
				ob.create_list(p3);
				l1 = new LiverClass(b1, hos1);
				l2 = new LiverClass(b2, hos2);
				l3 = new LiverClass(b3, hos3);
				res1 = ob.driver(l1);
				res2 = ob.driver(l2);
				res3 = ob.driver(l3);
			}
		});

		lab1.setAlignment(Pos.CENTER);
		lab2.setAlignment(Pos.CENTER);
		lab3.setAlignment(Pos.CENTER);
		lab4.setAlignment(Pos.CENTER);
		lab5.setAlignment(Pos.CENTER);
		lab6.setAlignment(Pos.CENTER);
		lab7.setAlignment(Pos.CENTER);
		lab8.setAlignment(Pos.CENTER);
		lab9.setAlignment(Pos.CENTER);
		lab10.setAlignment(Pos.CENTER);

		rootnode.add(lab1, 0, 0);
		rootnode.add(lab2, 1, 0);
		rootnode.add(lab3, 2, 0);
		rootnode.add(lab4, 3, 0);
		rootnode.add(lab5, 4, 0);
		rootnode.add(lab6, 5, 0);
		rootnode.add(lab7, 6, 0);
		rootnode.add(tx1_1, 1, 1);
		rootnode.add(tx1_2, 4, 1);
		rootnode.add(tx1_3, 5, 1);
		rootnode.add(tx1_4, 6, 1);
		rootnode.add(cb1_1, 2, 1);
		rootnode.add(cb1_2, 3, 1);
		rootnode.add(tx2_1, 1, 2);
		rootnode.add(tx2_2, 4, 2);
		rootnode.add(tx2_3, 5, 2);
		rootnode.add(tx2_4, 6, 2);
		rootnode.add(cb2_1, 2, 2);
		rootnode.add(cb2_2, 3, 2);
		rootnode.add(tx3_1, 1, 3);
		rootnode.add(tx3_2, 4, 3);
		rootnode.add(tx3_3, 5, 3);
		rootnode.add(tx3_4, 6, 3);
		rootnode.add(cb3_1, 2, 3);
		rootnode.add(cb3_2, 3, 3);
		rootnode.add(lab8, 0, 4);
		rootnode.add(lab9, 1, 4);
		rootnode.add(lab10, 2, 4);
		rootnode.add(cbl1_1, 1, 5);
		rootnode.add(cbl1_2, 2, 5);
		rootnode.add(cbl2_1, 1, 6);
		rootnode.add(cbl2_2, 2, 6);
		rootnode.add(cbl3_1, 1, 7);
		rootnode.add(cbl3_2, 2, 7);
		rootnode.add(but, 0, 8);

		mystage.show();
	}

	/**
	 *
	 */
	public void stop() {

		System.out.println(res1);
		System.out.println(res2);
		System.out.println(res3);
	}
}
