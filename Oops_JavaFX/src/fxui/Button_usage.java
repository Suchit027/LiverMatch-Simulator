package fxui;

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.*;
import javafx.geometry.Pos;

public class Button_usage extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	public void init() {
		System.out.println("inside init method");
	}

	public void start(Stage mystage) {
		var rootnode = new FlowPane(10, 10);
		var myscene = new Scene(rootnode, 300, 300);
		mystage.setScene(myscene);
		var but1 = new Button("Alpha");
		var but2 = new Button("Beta");
		var response = new Label();
		rootnode.setAlignment(Pos.CENTER);
		but1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				response.setText("Alpha selected");
			}
		});
		but2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				response.setText("Beta selected");
			}
		});
		rootnode.getChildren().addAll(but1, but2, response);
		mystage.show();
	}

	public void stop() {
		System.out.println("inside stop method");
	}

}
