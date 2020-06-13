package View;

import javax.swing.JOptionPane;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class View extends AbstractView {
	private Button Button1;
	private Button Button2;
	private Button Button3;
	private Button Button4;
	private Button Button5;
	private Button Button6;
	private Button Button7;
	private Button Button8;
	private Button Button9;
	private Button Button10;
	private Label lblEnterName;
	Text text0;

	public View(Stage primaryStage) {
		super(primaryStage);
		
		
		
		
		 Image ballot = new Image("file:Files/ballot.jpg");
		 ImageView imgv1 = new ImageView(ballot);
		 
		 ImageView imgv2 = new ImageView("file:Files/a.jpg");

		Button1 = new Button("Adding Ballot Box");
		HBox hbRoot1 = new HBox(imgv1,Button1);
		Button1.setOnAction(e -> JOptionPane.showMessageDialog(null, " Bibi Is the King !"));
		Button2 = new Button("Adding Citizen");
		Button2.setOnAction(e -> JOptionPane.showMessageDialog(null, " Bibi Is the King !"));
		HBox hbRoot2 = new HBox(imgv2,Button2);

		Button3 = new Button("Adding Party");
		Button4 = new Button("Adding Contender to Party");
		Button5 = new Button("Showing Ballot Boxes results");
		Button6 = new Button("Showing all the Citizens");
		Button7 = new Button("Showing all the Parties");
		Button8 = new Button("Setting New Election");
		Button9 = new Button("Showing The last Election results");
		Button10 = new Button("exit");

		vbRoot.getChildren().addAll(hbRoot1,hbRoot2,Button3,Button4,Button5,Button6,Button7,Button8,Button9,Button10);

		
		
		
		
		
		
		text0 = new Text("Welcome To Aviad And Ron Project ");
		text0.setFill(Color.WHEAT);
		text0.setFont(new Font("Times New Roman", 20));
		lblEnterName = new Label("Enter Name: ");

	}

}
