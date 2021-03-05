package Task1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Task1b extends Application{
	Stage window;
	Scene accountnum, pin, mainscene, balance, withdraw, deposit;
	Button buttonacc, buttonpin;
	public static void main(String [] args) {
		
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		window = primaryStage;
		window.setTitle("ATM");
		TextField accnum = new TextField();
		String accnumber = null;
		//layout for enter window
		
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		pane.setHgap(5.5);
	    pane.setVgap(5.5);
		
		pane.add(new Label("Enter an Account number:"), 0, 0);
		pane.add(accnum, 1, 0);
		
		buttonacc = new Button();
		buttonacc.setText("Submit");
		pane.add(buttonacc,1,3);
		GridPane.setHalignment(buttonacc, HPos.LEFT);
		
		accountnum = new Scene(pane);
		
		
		
		//layout for pin window
		
		GridPane pinpane = new GridPane();
		
		pinpane.setAlignment(Pos.CENTER);
		pinpane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		pinpane.setHgap(5.5);
	    pinpane.setVgap(5.5);
		pinpane.add(new Label("Enter PIN:"), 0, 0);
		pinpane.add(new TextField(), 1, 0);
		buttonpin = new Button();
		buttonpin.setText("Submit PIN");
		pinpane.add(buttonpin,1,3);
		GridPane.setHalignment(buttonpin, HPos.LEFT);
		pin = new Scene(pinpane);
		
		buttonpin.setOnAction(e -> check(accnum.getText()));
		
		//layout for mainscene
		
		//Window show
		window.setScene(accountnum);
		window.show();
		
	}
	private void check(String accnumber) {
			try {
				int accnumberloc = Integer.parseInt(accnumber);
				for(int i = 0; i < )
				if(accnumberloc = ) {
					window.setScene(pin);
				}
				
			} catch(NumberFormatException e) {
				System.out.println("Error " + accnumber + " is not an number");
			}
	}
	private boolean isInt(TextField input, String message) {
		System.out.println("Called boolen");
		try {
			int accnumber = Integer.parseInt(input.getText());
			System.out.println("went through");
			return true;
		} catch(NumberFormatException e) {
			System.out.println("Error " + message + " is not an number");
			return false;
		}
	}
	
	public void openfile() throws FileNotFoundException{
		File file = new File("account.dat");
		Scanner inputFile = new Scanner  
		Account[] account = new Account[10];
		
		
	}
}