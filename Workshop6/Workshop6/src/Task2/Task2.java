package Task2;

import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.Alert;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Window;

public class Task2 extends Application{
	public void herewego(String[] args) {
		launch(args);
	}
	
	public void start(Stage primaryStage) {
		//check panel
		GridPane check = new GridPane();
		
		check.setAlignment(Pos.CENTER);
		check.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		check.setHgap(5.5);
		check.setVgap(5.5);
		
		Label text = new Label("Do you want to Search for another Name (Y/N):");
	    GridPane.setHalignment(text, HPos.CENTER);
	    check.add(text, 0, 0);
	    
	    TextField answer = new TextField();
	    GridPane.setHalignment(answer, HPos.CENTER);
	    answer.setMaxWidth(28);
	    check.add(answer, 0, 1);
	    
	    Button btnSubmit1 = new Button("Submit");
		check.add(btnSubmit1, 0, 3);
		GridPane.setHalignment(btnSubmit1, HPos.LEFT);
		
		Button btnExit1 = new Button("Exit");
		check.add(btnExit1, 1, 3);
		GridPane.setHalignment(btnExit1, HPos.RIGHT);
		
	    Scene scene1 = new Scene(check);
	    //
	    
		//Main panel
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
	    pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
	    pane.setHgap(5.5);
	    pane.setVgap(5.5);
	    
	    Label lblyear= new Label("Enter the year:");
	    GridPane.setHalignment(lblyear, HPos.CENTER);
	    pane.add(lblyear, 0, 0);
	    
	    TextField txtYear = new TextField();
		GridPane.setHalignment(txtYear, HPos.CENTER);
		pane.add(txtYear, 1, 0);
	    
	    Label lblGender = new Label("Enter the gender:");
	    GridPane.setHalignment(lblGender, HPos.CENTER);
	    pane.add(lblGender, 0, 1);
	    
	    TextField txtGender = new TextField();
		GridPane.setHalignment(txtGender, HPos.LEFT);
		txtGender.setMaxWidth(28);
		pane.add(txtGender, 1, 1);
	    
	    Label lblName = new Label("Enter the Name:");
	    GridPane.setHalignment(lblName, HPos.CENTER);
	    pane.add(lblName, 0, 2);
	    
	    TextField txtName = new TextField();
		GridPane.setHalignment(txtName, HPos.CENTER);
		pane.add(txtName, 1, 2);
		
		Label lblRank = new Label();
	    GridPane.setHalignment(lblRank, HPos.CENTER);
	    pane.add(lblRank, 0, 3);
		
		Button btnSubmit = new Button("Submit");
		pane.add(btnSubmit, 0, 4);
		GridPane.setHalignment(btnSubmit, HPos.LEFT);
		
		Button btnExit = new Button("Exit");
		pane.add(btnExit, 1, 4);
		GridPane.setHalignment(btnExit, HPos.RIGHT);
	    
	    Scene scene = new Scene(pane);
	    primaryStage.setTitle("Search Name Ranking Application");
	    primaryStage.setScene(scene);
	    primaryStage.setHeight(200);
	    primaryStage.setWidth(600);
	    primaryStage.show();
	    //
	    
	    btnSubmit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				boolean isEmpty = txtYear.getText().isEmpty() || txtGender.getText().isEmpty() || txtName.getText().isEmpty();
				String findName = "";
				int check = -1;
				String m_txtfield = txtName.getText();
				String m_txtgender = txtGender.getText();
				String m_txtyear = txtYear.getText();
				try {
				File file = new File("babynamesranking" + m_txtyear + ".txt");
					if(isEmpty) {
						showAlert(Alert.AlertType.ERROR, pane.getScene().getWindow(), "Form Error!", "Please fill in the blank");
					} else {
						int year = Integer.parseInt(m_txtyear);
						if(!m_txtgender.equals("M") && !m_txtgender.equals("F")) {
							if(year < 2001 || year > 2010) {
								showAlert(Alert.AlertType.ERROR, pane.getScene().getWindow(), "Form Error!", "Set right gender, (M)ale or (F)emale");
							} else {
								showAlert(Alert.AlertType.ERROR, pane.getScene().getWindow(), "Form Error!", "Set right gender, (M)ale or (F)emale");
							}
						} else if(year < 2001 || year > 2010){
							showAlert(Alert.AlertType.ERROR, pane.getScene().getWindow(), "Form Error!", "Set right year number, between 2001 and 2010");
						} else {
							int rank = 0;
							String gender = "";
							try {
								Scanner read = new Scanner(file);
								while (read.hasNext()) {
									String s = read.nextLine();
									String[] temp = s.split(" ");
									if(m_txtgender.equalsIgnoreCase("M") && isContain(temp[1], m_txtfield)){
										rank = new Integer(temp[0]);
										gender = " boys ";
									} else if (temp[2].contains(m_txtfield)) {
										rank = new Integer(temp[0]);
										gender = " girls ";
									}
								}
							} catch (FileNotFoundException e) {
								e.printStackTrace();
							}
							if (rank == 0) {
								lblRank.setText("The" + gender + "name " + m_txtfield + " is not ranked in year " + m_txtyear);
							} else {
								lblRank.setText("The" + gender + "name " + m_txtfield +" is ranked #"+ rank +" in year "+ m_txtyear);
							}
						}
					}
				} catch (NumberFormatException e) {
					showAlert(Alert.AlertType.ERROR, pane.getScene().getWindow(), "Form Error!", "Wrong input in year field, enter a number");
				}
			}
	    });
	    
	    btnSubmit1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				boolean isEmpty = answer.getText().isEmpty();
				String stranswer = answer.getText();

				if(isEmpty) {
					showAlert(Alert.AlertType.ERROR, pane.getScene().getWindow(), "Form Error!", "Please fill in the blank");
				} else {
					if(!stranswer.equals("Y") && !stranswer.equals("N")) {
						showAlert(Alert.AlertType.ERROR, pane.getScene().getWindow(), "Form Error!", "Please enter Y or N in the box");	
					} else {
						if(stranswer.equals("Y")) {
							primaryStage.setScene(scene);
						} else {
							primaryStage.close();	
						}
					}
				}
			}
	    });
	    
	    btnExit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				primaryStage.setScene(scene1);
			}
	    });
	    
	    btnExit1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				primaryStage.close();
			}
	    });
	}
	private static boolean isContain(String source, String subItem){
        String pattern = "\\b"+subItem+"\\b";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(source);
        return m.find();
   }
	//temp[1].contains(m_txtfield)
	
	private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
	  	Alert alert = new Alert(alertType);
	  	alert.setTitle(title);
	  	alert.setHeaderText(null);
	  	alert.setContentText(message);
	  	alert.initOwner(owner);
	  	alert.show();
	  }
}
