package View;

import java.util.ArrayList;

import javax.swing.JOptionPane;


import Model.Model;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
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
import listeners.ViewListenable;

public class View {

	private ArrayList<ViewListenable> listeners = new ArrayList<ViewListenable>();

	protected Label TopLable,Citizen;
	protected TextField Textt;
	protected BorderPane bpRoot;
	protected Image ima = new Image("file:Files/Toplabel.jpg");
	protected ImageView imgv = new ImageView(ima);
	protected VBox vbRoot,VBoxAddBallot,VboxAddCitizen;

	private AbButton Button1, Button2, Button3, Button4, Button5, Button6, Button7, Button8, Button9, Button10;
	private Label lblEnterName;
	private Text text0;
	private String type;
	private String adresss;

	private TextField adresstext;
	private ComboBox<String> BallotBoxType;

	public View(Stage primaryStage) {
		primaryStage.setTitle("Elections");
		BorderPane bpRoot = new BorderPane();
		bpRoot.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		TopLable = new Label();
		TopLable.setGraphic(imgv);

		bpRoot.setTop(TopLable);
		// primaryStage.setResizable(false);
		vbRoot = new VBox();
		vbRoot.setPadding(new Insets(10));
		vbRoot.setSpacing(10);
		bpRoot.setLeft(vbRoot);

		Scene scene = new Scene(bpRoot, 500, 555);
		primaryStage.setScene(scene);
		primaryStage.show();

		//////////////////Images///////////////////////////
		Image ballot = new Image("file:Files/ballot.jpg");
		ImageView imgv1 = new ImageView(ballot);
		ImageView imgv2 = new ImageView("file:Files/person.jpg");
		ImageView imgv3 = new ImageView("file:Files/Party.jpg");

		ImageView imgv4 = new ImageView("file:Files/person.jpg");
		ImageView imgv6 = new ImageView("file:Files/person.jpg");
		ImageView imgv7 = new ImageView("file:Files/Party.jpg");
		ImageView imgv8 = new ImageView("file:Files/Vote.jpg");

		ImageView imgv5 = new ImageView("file:Files/ElectionResult.jpg");
		ImageView imgv9 = new ImageView("file:Files/ElectionResult.jpg");



	
		/////// 1 Add Ballot /////////////////////////
		Button1 = new AbButton("Adding Ballot Box",imgv1);
        Button1.setStyle("-fx-border-color: black; -fx-border-width: 1px;");

		Button1.setMaxWidth(250.0);
		Button1.setBackground(new Background (new BackgroundFill(Color.WHITE, null, null )));


		Label SelectedBallot = new Label("You chose to add a new ballot Box"); 
		Label SelectedBallot2 = new Label("Which Ballot box would you like to add?");
		BallotBoxType = new ComboBox<String>();
		BallotBoxType.getItems().addAll("SickCitizen", "Soldier", "SickSoldier", "Citizen");
		Label address = new Label("Enter city:");
		adresstext = new TextField();
		AbButton SubmitButton = new AbButton("Submit");
		HBox adressBox = new HBox(address, adresstext, SubmitButton);
		// VBox AddBallotVbox = new VBox(adressBox);
		// Label address = new Label();
		VBoxAddBallot = new VBox(SelectedBallot,SelectedBallot2,BallotBoxType);
		Button1.setOnAction(e -> bpRoot.setCenter(VBoxAddBallot));

//		BallotBoxType.setOnAction(new EventHandler<ActionEvent>() {
//			@Override
//			public void handle(ActionEvent action) { 
//		for (ViewListenable l : listeners)
//			l.addBallotBox(BallotBoxType.getValue().toString(),adresstext.getText());
//				}
//		});
		
		
		
//		if(adresstext.getText().isEmpty()) {
//		JOptionPane.showMessageDialog(null,
//				" Please fill the blank textfield ");
//
//	}
//	else {}
		
		
		
		SubmitButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent action) {

				JOptionPane.showMessageDialog(null,
						" The Ballot Box Of " + adresstext.getText() + " Added Successfully  ");

//				for (ViewListenable l : listeners)
//					l.addBallotBox(BallotBoxType.getValue().toString(), adresstext.getText());
			}
		});
		VBoxAddBallot.getChildren().add(adressBox);

		//	.setOnAction(e -> JOptionPane.showMessageDialog(null,
		//	" The Ballot Box Of " + adresstext.getText() + " Added Successfully  "));
		// setOnAction(e -> JOptionPane.showMessageDialog(null, " Bibi Is the King !"));

		// JOptionPane.showMessageDialog(null, " Bibi Is the King !")
		
		
		
		///// try of picture in button
		//Image image = new Image(getClass().getResourceAsStream("play3.jpg"));

//		Button3.setOnAction(new EventHandler<ActionEvent>() {
//		    @Override public void handle(ActionEvent e) {
//		        Button button = (Button) e.getSource();
//		        button.setGraphic(imgv1);
//		    }
//		});

		
		//////2  add citizen //////////
		Button2 = new AbButton("Adding Citizen",imgv2);
		Citizen= new Label("You chose to add a new citizen");
		Label lblCitizenType = new Label("What is the type of citizen");
		ComboBox cmbCitizenType = new ComboBox<String>();
		cmbCitizenType.getItems().addAll("SickCitizen", "Soldier", "SickSoldier", "Citizen");
		Label name = new Label("Enter Name:");
		TextField nametext = new TextField();
		nametext.setMaxWidth(250.0);
		Label idlbl = new Label("Enter Id:");
		TextField idtext = new TextField();
		idtext.setMaxWidth(250.0);
		Label yearlbl = new Label("Enter year of born:");
		TextField yeartext = new TextField();
		yeartext.setMaxWidth(250.0);
		Label quarntinelbl = new Label("Enter quarntine true or false:");
		TextField quarntinetext = new TextField();
		quarntinetext.setMaxWidth(250.0);


		AbButton SubmitButton2 = new AbButton("Submit");

		VboxAddCitizen = new VBox(Citizen,lblCitizenType,cmbCitizenType,name,nametext,idlbl,idtext,yearlbl,yeartext,quarntinelbl,quarntinetext,SubmitButton2);
		Button2.setOnAction(e -> bpRoot.setCenter(VboxAddCitizen));
		//VboxAddCitizen.setAlignment(Pos.CENTER_LEFT);
		
		SubmitButton2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent action) {
				JOptionPane.showMessageDialog(null,
						" The Citizen  " + nametext.getText() + " Added Successfully  ");

				for (ViewListenable l : listeners)
					l.addCitizen(nametext.getText(), Integer.parseInt(idtext.getText()),Integer.parseInt(yeartext.getText()),Boolean.parseBoolean(quarntinetext.getText()),cmbCitizenType.getValue());
			}
		});

		/////

		///////3//////
		Button3 = new AbButton("Adding Party",imgv3);
		Label lblFaction = new Label("Faction:");
		ComboBox<String> cmbFactionChoice = new ComboBox<String>();
		cmbFactionChoice.getItems().addAll("Center", "Left", "Right");
		AbButton btConfirm = new AbButton("Submit");
		Label lblDetails = new Label("please enter party details:");
		Label lblNameParty = new Label("party name:");
		TextField tfName = new TextField();
		VBox VboxAddParty = new VBox(lblFaction,cmbFactionChoice,lblDetails,lblNameParty,tfName,btConfirm);
		Button3.setOnAction(e -> bpRoot.setCenter(VboxAddParty));

		cmbFactionChoice.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
						
				lblFaction.setText("Faction:" + cmbFactionChoice.getValue());

			}

		});
		
		btConfirm.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
			//	for (ViewListenable l : listeners)
				//	l.addParty(tfName.getText(), cmbFactionChoice.getValue());
				JOptionPane.showMessageDialog(null, "Party added successfuly!");
			}
		});
		
		
		
		
		
		
		
////4///////
		
		Button4 = new AbButton("Adding Contender to Party",imgv4);
		Label lblCitizen = new Label("Is He Already Citizen ?");
		TextField tfCitizen= new TextField();
		Label lblName = new Label("Name:");
		TextField tfConName = new TextField();
		Label lblID = new Label("ID:");
		TextField tfID = new TextField();
		Label lblYear = new Label("year of birth:");
		TextField tfYear = new TextField();
		//Label lblNumP = new Label("number in the party:");
		//TextField tfNumP = new TextField();
		Label lblNameP = new Label("party name:");
		TextField tfNameP = new TextField();
	  	Label lblSickDays = new Label("How many sick days -if you are not sick you will record 0:");
		TextField tfSickDays = new TextField();
		AbButton btSubmit4 = new AbButton("Submit");
		VBox VboxAddContender = new VBox(lblName,tfConName,lblID,tfID,lblYear,tfYear,lblNameP,tfNameP,lblSickDays,tfSickDays,btSubmit4);
		Button4.setOnAction(e -> bpRoot.setCenter(VboxAddContender));

		btSubmit4.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
			//	for (ViewListenable l : listeners)
				//	l.addnewcontendor(tfName.getText(), cmbFactionChoice.getValue());
				JOptionPane.showMessageDialog(null, "Party added successfuly!");
			}
		});

		
		

		
		
		

		
////////5//////
		Button5 = new AbButton("Showing Ballot Boxes results",imgv5);
		
		Text allBallots = new Text();
		allBallots.setText(listeners.get(0).viewAllBallots());

///////////////
		Button6 = new AbButton("Showing all the Citizens",imgv6);


        AbButton Button7 = new AbButton("Showing all the Parties",imgv7);
		Button8 = new AbButton("Setting New Election",imgv8);
		Button9 = new AbButton("Showing The last Election results",imgv9);

        
        
        
        //// 10///
		Button10 = new AbButton("exit");
		Button10.setOnAction(e -> Platform.exit());
		/////////
	
		vbRoot.getChildren().addAll(Button1, Button2, Button3, Button4, Button5, Button6, Button7, Button8, Button9,
				Button10);

		text0 = new Text("Welcome To Aviad And Ron Project ");
		text0.setFill(Color.WHEAT);
		text0.setFont(new Font("Times New Roman", 20));
		lblEnterName = new Label("Enter Name: ");

	}

	public void registerListener(ViewListenable newListener) {
		listeners.add(newListener);
	}
}
