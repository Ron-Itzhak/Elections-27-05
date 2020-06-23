package Model;

import java.util.ArrayList;

import Controller.Controller;
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

}
