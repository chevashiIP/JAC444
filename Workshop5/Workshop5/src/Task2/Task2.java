package Task2;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import java.io.*;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class Task2 extends Application{
	
	Layout pane = new Layout();
	protected int count = 0;
	int NAME = 32; 
	int LNAME = 32; 
	int CITY = 20; 
	int STATE = 20; 
	int ZIP = 20; 
	public void address(String[] args) {
		
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		pane.btAdd.setOnAction(e -> add());
		pane.btFirst.setOnAction(e -> first());
		pane.btNext.setOnAction(e -> next());
		pane.btPrevious.setOnAction(e -> previous());
		pane.btLast.setOnAction(e -> last());
		pane.btUpdate.setOnAction(e -> update());
		
		Scene scene = new Scene(pane, 320, 200);
		primaryStage.setTitle("Address Book");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private void add() {
		try (
				RandomAccessFile inout = 
					new RandomAccessFile("AddressBook.dat", "rw");
			) {
				inout.seek(inout.length());
			 	write(inout);
			}
			catch (FileNotFoundException ex) {}
			catch (IOException ex) {}
			catch (IndexOutOfBoundsException ex) {}
	}
	private void first() {
		try ( // Create a random access file
				RandomAccessFile inout = 
					new RandomAccessFile("AddressBook.dat", "rw");
			) {
				if (inout.length() > 0) {
					inout.seek(0);
					read(inout);
					System.out.println("Reading address #1");
					count = 1;
				}
				else {
					System.out.println("Address is empty!");
				}
			}
			catch (IOException ex) {}
	}
	private void next() {
		try ( // Create a random access file
				RandomAccessFile inout = 
					new RandomAccessFile("AddressBook.dat", "rw");
			) {
				if (count * 124 < inout.length()) {
					inout.seek(count * 124);
					read(inout);
					count++;
					System.out.println("Reading address #" + count);
				}
				else {
					System.out.println("End of file!");
				}
			}
			catch (IOException ex) {}
	}
	private void previous() {
		try ( // Create a random access file
				RandomAccessFile inout = 
					new RandomAccessFile("AddressBook.dat", "rw");
			) {
				if (count > 1) 
					count--;
				else
					count = 1;
				inout.seek((count * 124) - 124);
				read(inout);
				System.out.println("Reading address #" + count);
			}
			catch (IOException ex) {}
	}
	private void last() {
		try ( // Create a random access file
				RandomAccessFile inout = 
					new RandomAccessFile("AddressBook.dat", "rw");
			) {
				count = ((int)inout.length()) / 124;
				inout.seek((count * 124) - 124);
				read(inout);
				System.out.println("Reading address #" + count);
			}
			catch (IOException ex) {}
	}
	private void update() {
		try ( // Create a random access file
				RandomAccessFile inout = 
					new RandomAccessFile("AddressBook.dat", "rw");
			) {
			 	inout.seek(count * 124 - 124);
			 	write(inout);
			}
			catch (FileNotFoundException ex) {}
			catch (IOException ex) {}
	}
	private void read(RandomAccessFile inout) throws IOException {
		int pos;
		byte[] name = new byte[NAME];	
		pos = inout.read(name);
		pane.tfFName.setText(new String(name));

		byte[] street = new byte[LNAME];	
		pos += inout.read(street);
		pane.tfLName.setText(new String(street));

		byte[] city = new byte[CITY];	
		pos += inout.read(city);
		pane.tfCity.setText(new String(city));

		byte[] state = new byte[STATE];	
		pos += inout.read(state);
		pane.tfState.setValue(new String(state));

		byte[] zip = new byte[ZIP];	
		pos += inout.read(zip);
		pane.tfZip.setText(new String(zip));
	}
	private void write(RandomAccessFile inout) throws IOException {
		inout.write(fixedLength(pane.tfFName.getText().getBytes(), NAME)); 
		inout.write(fixedLength(pane.tfLName.getText().getBytes(), LNAME));
		inout.write(fixedLength(pane.tfCity.getText().getBytes(), CITY));
		inout.write(fixedLength(pane.tfState.getValue().getBytes(), STATE));
		inout.write(fixedLength(pane.tfZip.getText().getBytes(), ZIP));
		System.out.println("Address #" + count + " saved!");
	}
	private byte[] fixedLength(byte[] x, int n) {
		byte[] b = new byte[n];
		for (int i = 0; i < x.length; i++) {
			b[i] = x[i];
		}
		return b;
	}
}

class Layout extends BorderPane{
	
	ObservableList<String> options = 
		    FXCollections.observableArrayList(
		    		"Nunavut", "Quebec", "NWT", "Ontario", "BC", "Alberta","SK","Manitoba","Yukon","NL","LD","NB","NS","PEI"
		    );
	
	TextField tfFName = new TextField();
	TextField tfLName = new TextField(); 
	TextField tfCity = new TextField(); 
	ComboBox<String> tfState = new ComboBox<String>(options);
	TextField tfZip = new TextField(); 
	Button btAdd = new Button("Add");
	Button btFirst = new Button("First");
	Button btNext = new Button("Next");
	Button btPrevious = new Button("Previous");
	Button btLast = new Button("Last");
	Button btUpdate = new Button("Update");
	private FlowPane paneForInfo = new FlowPane(5, 5);
	private HBox paneForButtons = new HBox(5);
	
	public Layout() {
		addrespane();
	}
	
	private void addrespane() {
		tfFName.setPrefColumnCount(23);
		tfLName.setPrefColumnCount(23);
		tfCity.setPrefColumnCount(8);
		
		tfZip.setPrefColumnCount(4);

		
		paneForInfo.setPadding(new Insets(10, 10, 0, 10));
		paneForInfo.getChildren().addAll(new Label("First Name"), tfFName, 
			new Label("Last Name"), tfLName, new Label("City   "), tfCity,
			new Label("State"), tfState, new Label("Postal Code"), tfZip);

		
		paneForButtons.getChildren().addAll(btAdd, btFirst, 
			btNext, btPrevious, btLast, btUpdate);
		paneForButtons.setAlignment(Pos.CENTER);

	
		setCenter(paneForInfo);
		setBottom(paneForButtons);
	}
}
