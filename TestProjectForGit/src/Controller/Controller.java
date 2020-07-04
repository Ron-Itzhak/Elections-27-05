package Controller;

import javafx.event.ActionEvent;
import listeners.ElectionsListenable;
import listeners.ViewListenable;
import Model.Date;
import Model.Management;
import Model.Model;
import Model.Party.eFlow;
import View.View;

public class Controller implements ViewListenable,ElectionsListenable {
	private Model theModel;
	private View theView;

	public	Controller(Model m, View v) throws Exception {
		theModel = m;
		theView = v;


		theModel.registerListener(this);
		theView.registerListener(this);	}



	//	public void addBallotBox(){
	//		//theView.getAdressfromui();
	//		theModel.addBallotBox(theView.getAdressfromui(), theView.getType());
	//		
	//		
	//				
	//		
	//	}



	@Override
	public void addBallotBox(String adress,String type) {
		theModel.addBallotBox(adress, type);

	}



	@Override
	public void addCitizen(String name, int id, int year, boolean qurantine) {
		theModel.addCitizen(name, id, year, qurantine);		
	}



	@Override
	public void addParty(String name, eFlow flow, Date dateOfCreation) {
		theModel.addParty(name, flow, dateOfCreation);

	}



	@Override
	public void addContender() {
		// TODO Auto-generated method stub

	}

}