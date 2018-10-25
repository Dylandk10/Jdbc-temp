import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class App extends Application {
	//public buttons 
	Button buttonPrime = new Button("find prime");
	Button buttonDeriv = new Button("Find Derivative");
	
	Label label = new Label();
	Label label2 = new Label();
	Label primeResult = new Label();
	Label derivResult = new Label();
	
	TextField txtField = new TextField();
	TextField derivField = new TextField();
	
	public static void main(String[] args)  {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		//add event for buttons
		buttonPrime.setOnAction(e -> buttonPressed(e));
		buttonDeriv.setOnAction(e -> buttonPressed(e));
		
		//set up rest of app
		primaryStage.setTitle("Application");
		label.setText("Enter the number");
		label2.setText("Enter quadratic form polly");
		GridPane root = new GridPane();
		root.add(buttonPrime, 0, 0);
		root.add(buttonDeriv, 1, 0);
		root.add(label, 0, 2);
		root.add(label2, 1, 2);
		root.add(txtField, 0, 3);
		root.add(primeResult, 0, 4);
		root.add(derivField, 1, 3);
		root.add(derivResult, 1, 4);
		primaryStage.setScene(new Scene(root, 500,500));
		primaryStage.show();
		
	}
	public void buttonPressed(ActionEvent e) {
		DerivativeLogic user = new DerivativeLogic();
		PrimeLogic primeLogic = new PrimeLogic();
		if(e.getSource() == buttonPrime) {
			String value = "";
			value = txtField.getText();
			
			if(isInteger(value)) {
				int sendValue = Integer.parseInt(value);
				primeResult.setText(primeLogic.isPrime(sendValue));
			} else {
				primeResult.setText("Enter a Integer");
			}
		//this is for taking quadratic derivatives need toad poly derivatives 
		} else if(e.getSource() == buttonDeriv) {
			String value = "";
			String showValue = "";
			value = derivField.getText();
			showValue = user.takeDerivative(value);
			derivResult.setText(showValue);
		}
	}
	//connect to button pressed to check if string is integer 
	public boolean isInteger( String input ) { //Pass in string
	    try { //Try to make the input into an integer
	        Integer.parseInt( input );
	        return true; //Return true if it works
	    }
	    catch( Exception e ) { 
	        return false; //If it doesn't work return false
	    }
	}

}
