package Model;

import java.util.ArrayList;

import Controller.Controller;
import Model.Party.eFlow;
import listeners.ElectionsListenable;

public class Model {
	private Management m;
	private ArrayList<ElectionsListenable> listeners = new ArrayList<ElectionsListenable>();

	public Model() throws Exception {
		m = new Management();	
	}

	public void addBallotBox(String adress,String type) {
		m.addBallotBoxMVC(adress,type);
		
	}

	public void registerListener(ElectionsListenable listener) {
		listeners.add(listener);
	}

	public void addCitizen(String name, int id, int year, boolean qurantine, String type) {
		m.addCitizen(name, id, year, qurantine, type);
	}
	
	public void addParty(String name, eFlow flow, Date dateOfCreation) {
		m.addParty(name, flow, dateOfCreation);
	}
	
	public void addExistingContenderToParty(int id, String partyBelonging, boolean isExist) throws Exception {
		m.addContender(id, partyBelonging, isExist);
	}

}
