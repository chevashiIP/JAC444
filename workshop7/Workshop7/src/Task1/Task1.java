package Task1;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Set;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Task1 extends Application{
	public void herewego(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		int num1 = (int)Math.ceil(Math.random() * 10);
		int num2 = (int)Math.ceil(Math.random() * 10);
		
		Task1 quizPanel = new Task1();
		quizPanel.start(primaryStage, num1, num2);
	}
	
	public void start(Stage primaryStage, double num1, double num2) throws Exception{
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
	    pane.setPadding(new Insets(11.5, 120, 11.5, 120));
	    pane.setHgap(5.5);
	    pane.setVgap(5.5);
	    
	    Label NumShow = new Label("Two randomly generated numbers are: " + String.format("%.0f", num1) + " and " + String.format("%.0f", num2));
	    GridPane.setHalignment(NumShow, HPos.CENTER);
	    pane.add(NumShow, 0, 0);
	    
	    Label Add = new Label("What is addition of " + String.format("%.0f", num1) + " and " + String.format("%.0f", num2) + ": ");
	    GridPane.setHalignment(Add, HPos.CENTER);
	    pane.add(Add, 0, 1);
	    
	    TextField txtAdd = new TextField();
	    GridPane.setHalignment(txtAdd, HPos.CENTER);
	    pane.add(txtAdd, 1, 1);
	    
	    Label Sub = new Label("What is substraction of " + String.format("%.0f", num1) + " and " + String.format("%.0f", num2)  + ": ");
	    GridPane.setHalignment(Sub, HPos.CENTER);
	    pane.add(Sub, 0, 2);
	    
	    TextField txtSub = new TextField();
	    GridPane.setHalignment(txtSub, HPos.CENTER);
	    pane.add(txtSub, 1, 2);
	    
	    Label Mul = new Label("What is multiplication of " + String.format("%.0f", num1) + " and " + String.format("%.0f", num2)  + ": ");
	    GridPane.setHalignment(Mul, HPos.CENTER);
	    pane.add(Mul, 0, 3);
	    
	    TextField txtMul = new TextField();
	    GridPane.setHalignment(txtMul, HPos.CENTER);
	    pane.add(txtMul, 1, 3);
	    
	    Label Div = new Label("What is division of " + String.format("%.0f", num1) + " and " + String.format("%.0f", num2)  + ": ");
	    GridPane.setHalignment(Div, HPos.CENTER);
	    pane.add(Div, 0, 4);
	    
	    TextField txtDiv = new TextField();
	    GridPane.setHalignment(txtDiv, HPos.CENTER);
	    pane.add(txtDiv, 1, 4);
	    
	    Label CorrectAnsw = new Label("Number of Correct Answers: ");
	    GridPane.setHalignment(CorrectAnsw, HPos.CENTER);
	    pane.add(CorrectAnsw, 0, 5);
	    
	    Label WrngAnsw = new Label("Number of Wrong Answers: ");
	    GridPane.setHalignment(WrngAnsw, HPos.CENTER);
	    pane.add(WrngAnsw, 0, 6);
	    
	    Button btnSubmit = new Button("Submit Answers");
	    pane.add(btnSubmit, 0, 7);
	    GridPane.setHalignment(btnSubmit, HPos.CENTER);
	    
	    Button btnReset = new Button("Reset the Quiz");
	    pane.add(btnReset, 1, 7);
	    GridPane.setHalignment(btnReset, HPos.CENTER);
	    
	    Scene scene = new Scene(pane);
	    primaryStage.setTitle("Quiz Application");
	    primaryStage.setScene(scene);
	    primaryStage.show();
	    
	    btnSubmit.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
			public void handle(ActionEvent event) {
	    		boolean isEmpty = txtAdd.getText().isEmpty() || txtSub.getText().isEmpty() || txtMul.getText().isEmpty() || txtDiv.getText().isEmpty();
	    		Set<Double> answers = new HashSet<Double>();
	 
	    		answers.add(Double.parseDouble(txtAdd.getText()));
	    		answers.add(Double.parseDouble(txtSub.getText()));
	    		answers.add(Double.parseDouble(txtMul.getText()));
	    		
	    		double answdiv = Double.parseDouble(txtDiv.getText());
	    		int countrightanswers = 0;
	    		int countwronganswers = 0;
	    		
	    		double actdiv = num1 / num2;
	    		Set<Double> rightansw = new HashSet<Double>();
	    		rightansw.add(num1 + num2);
	    		rightansw.add(num1 - num2);
	    		rightansw.add(num1 * num2);
	    		
	    		
	    		try {
	    		if(isEmpty) {
					showAlert(Alert.AlertType.ERROR, pane.getScene().getWindow(), "Form Error!", "Please fill in the blank");
	    		} else {
	    			for(Double s : rightansw) {
	    				if(answers.contains(s)) {
	    					countrightanswers++;
	    					System.out.println("Found it");
	    				} else {
	    					countwronganswers++;
	    					System.out.println("game over man game over");
	    				}
	    				System.out.println(s);
	    				
	    			}
	    			System.out.println(answdiv + " " + actdiv);
	    			if((int)(answdiv*100) == (int)(actdiv*100)) {
	    				countrightanswers++;
	    			} else {
	    				countwronganswers++;
	    			}
	    			
	    			CorrectAnsw.setText("Number of Correct Answers: " + countrightanswers);
	    			WrngAnsw.setText("Number of Wrong Answers: " + countwronganswers);
	    		}
	    		answers.add(answdiv);
	    		rightansw.add(num1 / num2);
	    		} catch (NumberFormatException e) {
					showAlert(Alert.AlertType.ERROR, pane.getScene().getWindow(), "Form Error!", "Wrong input in year field, enter a number");
				}
	    	}
	    });
	    
	    btnReset.setOnAction(new EventHandler<ActionEvent>(){
	    	Task1 quizPanel = new Task1();
	    	
			@Override
			public void handle(ActionEvent event) {
				int num1 = (int)Math.ceil(Math.random() * 10);
				int num2 = (int)Math.ceil(Math.random() * 10);
				try {
					quizPanel.start(primaryStage, num1, num2);
				} catch (Exception e) {
					System.err.println("Exception: " + e);
				}
			}
	    });
	}
	private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
	  	Alert alert = new Alert(alertType);
	  	alert.setTitle(title);
	  	alert.setHeaderText(null);
	  	alert.setContentText(message);
	  	alert.initOwner(owner);
	  	alert.show();
	  }
}
