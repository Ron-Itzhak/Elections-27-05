package View;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
//not in use 
public abstract class AbstractView {
protected Label TopLable;
protected TextField Textt;
protected  BorderPane bpRoot;
protected Image ima = new Image("file:Files/Toplabel.jpg");
protected ImageView imgv = new ImageView(ima);
protected VBox vbRoot;

public AbstractView (Stage primaryStage) {
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

	Scene scene = new Scene(bpRoot, 500, 400);
	primaryStage.setScene(scene);
	primaryStage.show();
	
	
	
	
}

}
