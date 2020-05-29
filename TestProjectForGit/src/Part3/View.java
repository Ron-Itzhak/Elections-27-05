package Part3;

import java.awt.Button;
import java.beans.EventHandler;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class View extends Application {
	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root,500,500);
		Label lblEnterName = new Label("Enter Name: ");
		StackPane spRoot = new StackPane();
		Button btn = new Button ();
		btn.setLabel("aa");
		btn.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "hi to you ");
				}});
			
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("hello");
		primaryStage.show();
/// blablas

		}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
