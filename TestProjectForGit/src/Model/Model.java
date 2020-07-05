package Model;

import java.util.ArrayList;

import Controller.Controller;
import Model.Party.eFlow;
import listeners.ElectionsListenable;
import listeners.ViewListenable;

public class Model {
	private Management m;
	private ArrayList<ViewListenable> listeners; 

	public Model() throws Exception {
		m = new Management();	
		listeners= new ArrayList<ViewListenable>();
	}


	public void registerListener(ViewListenable listener) {
		listeners.add(listener);
	}


	////1//////
	public void addBallotBox(String adress,String type) {
		m.addBallotBoxMVC(adress,type);

	}
	///////////

	////2////////
//	public void addCitizen(String name, int id, int year, boolean qurantine) {
//		Citizen c = new Citizen (name,id,year,qurantine);
//		m.addCitizen(c);
//		c.setBallotBoxNum(m.addVoterToBox(c, c.getClass().getSimpleName()));
//
//	}



	public void addCitizen(String name, int id, int year, boolean qurantine,  int numOfSick, boolean carryWeapon, String type) {
		m.addCitizen(name, id, year, qurantine, numOfSick, carryWeapon, type);
	}

	public void addParty(String name, String flow, Date dateOfCreation) {
		m.addParty(name, flow, dateOfCreation);
	}

	public void addExistingContenderToParty(int id, String partyBelonging, boolean isExist) throws Exception {
		m.addContender(id, partyBelonging, isExist);

	}
	//5////
	public String showBallotResults() {
		return m.showBallotResults();
		

	}
	////


	public String viewAllCitizens() {
		return m.viewAllCitizens();	
	}


	public String showParties() {
		return	m.showParties();
 	}
	
}
