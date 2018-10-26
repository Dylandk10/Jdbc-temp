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
	Label label3 = new Label();
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
		label3.setText(" or \"num\"-\"num\"");
		label2.setText("Enter quadratic form polly");
		GridPane root = new GridPane();
		root.add(buttonPrime, 0, 0);
		root.add(buttonDeriv, 2, 0);
		root.add(label, 0, 2);
		root.add(label2, 2, 2);
		root.add(label3, 0, 3);
		root.add(txtField, 0, 4);
		root.add(primeResult, 0, 4);
		root.add(derivField, 2, 3);
		root.add(derivResult, 2, 4);
		primaryStage.setScene(new Scene(root, 500,500));
		primaryStage.show();
		
	}
	public void buttonPressed(ActionEvent e) {
		DerivativeLogic user = new DerivativeLogic();
		PrimeLogic primeLogic = new PrimeLogic();
		if(e.getSource() == buttonPrime) {
			String value = "";
			String showValue = "";
			value = txtField.getText();
			showValue = primeLogic.checkIfListOfNumbers(value);
			primeResult.setText(showValue);
		//this is for taking quadratic derivatives need toad poly derivatives 
		} else if(e.getSource() == buttonDeriv) {
			String value = "";
			String showValue = "";
			value = derivField.getText();
			showValue = user.takeDerivative(value);
			derivResult.setText(showValue);
		}
	}

}
