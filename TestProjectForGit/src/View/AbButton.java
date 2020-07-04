package View;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class AbButton extends Button{

	public AbButton() {
		super();
		this.setMaxWidth(250);
		this.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
		this.setBackground(new Background (new BackgroundFill(Color.WHITE, null, null )));
	}

	public AbButton(String arg0, Node arg1) {
		super(arg0, arg1);
		this.setMaxWidth(250);
		this.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
		this.setBackground(new Background (new BackgroundFill(Color.WHITE, null, null )));

	}

	public AbButton(String arg0) {
		super(arg0);
		this.setMaxWidth(250);
		this.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
		this.setBackground(new Background (new BackgroundFill(Color.WHITE, null, null )));

	}



}
