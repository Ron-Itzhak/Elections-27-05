package mvc_starter;

import Controller.Controller;
import Model.Management;
import Model.Model;
import View.View;
import javafx.application.*;
import javafx.stage.Stage;

public class Program extends Application{

	public static void main(String[] args) throws Exception {
		launch(args);
		Management m = new Management();

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Model theModel = new Model();
		View theView1 = new View(primaryStage);
		Controller controller1 = new Controller(theModel, theView1);
		
	}

}
