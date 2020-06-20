package Controller;

import javafx.event.ActionEvent;
import Model.Management;
import Model.Model;
import View.View;

public class Controller {
	private Management ma;

	private Model theModel;
	private View theView;

	public	Controller(Model m, View v) throws Exception {
		theModel = m;
		theView = v;
		Management ma = new Management();

	}
	
	public void addBallotBox(){
		theModel.addBallotBox(ma);
		theView.uiaddBallotBox();
	}

	
	
	
	
	
}