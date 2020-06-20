package View;

import javax.swing.JOptionPane;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class View  {
	protected Label TopLable;
	protected TextField Textt;
	protected  BorderPane bpRoot;
	protected Image ima = new Image("file:Files/Toplabel.jpg");
	protected ImageView imgv = new ImageView(ima);
	protected VBox vbRoot;

	
	
	
	
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
		//////////////////////
		primaryStage.setTitle("Elections");
		BorderPane bpRoot =  new BorderPane();
		bpRoot.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY,Insets.EMPTY)));
		TopLable = new Label() ;
		TopLable.setGraphic(imgv);
		//Button1 = new Button("hello");
		bpRoot.setTop(TopLable);
		//primaryStage.setResizable(false);
		vbRoot =  new VBox();
		vbRoot.setSpacing(10);
		vbRoot.setPadding(new Insets(10));
		vbRoot.setSpacing(10);
		bpRoot.setLeft(vbRoot);

		Scene scene = new Scene(bpRoot, 1000, 800);
		primaryStage.setScene(scene);
		primaryStage.show();		
		/////////////////////////////////////////////		
		 Image ballot = new Image("file:Files/ballot.jpg");
		 ImageView imgv1 = new ImageView(ballot);
		 ImageView imgv2 = new ImageView("file:Files/a.jpg");
		 
		 
		 
		 /////// 1 Add Ballot /////////////////////////
		 
		Button1 = new Button("Adding Ballot Box");
		HBox hbRoot1 = new HBox(imgv1,Button1);
		
		
		Label SelectedBallot = new Label ("You chose to add a new ballot box Which Ballot box would you like to add?");
		ComboBox<String> BallotBoxType = new ComboBox<String>();
		BallotBoxType.getItems().addAll("sick citizens ballot box","soldiers ballot box","sick soldiers ballot box","regular ballot box");
		 Label address = new Label("Enter city:");
		 TextField adresstext = new TextField();
		 Button Addressshow =  new Button("City Name ");
		 HBox adressBox = new HBox(address,adresstext,Addressshow);
		// VBox AddBallotVbox = new VBox(adressBox);
		// Label address = new Label();
		// Label address = new Label();
		 VBox VBoxAddBallot = new VBox(SelectedBallot,BallotBoxType);
		 
			Button1.setOnAction(e -> bpRoot.setCenter(VBoxAddBallot));
			
			
			BallotBoxType.setOnAction(e -> SelectedBallot.setText("The selected Ballot is " + BallotBoxType.getValue())
			);
			Addressshow.setOnAction(e -> JOptionPane.showMessageDialog(null, " The Ballot Box Of "+adresstext.getText()+" Added Successfully  "  ) );
			VBoxAddBallot.getChildren().add(adressBox);
			System.out.println(adresstext.getText());
						//setOnAction(e -> JOptionPane.showMessageDialog(null, " Bibi Is the King !"));
		
		
						
				//JOptionPane.showMessageDialog(null, " Bibi Is the King !")
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
