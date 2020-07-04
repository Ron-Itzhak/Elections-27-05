package listeners;

import Model.Date;
import Model.Party.eFlow;

public interface ViewListenable {
	 void addBallotBox(String adress,String type);
	 void addCitizen(String name,int id,int year,boolean qurantine);
	 void addParty(String name, eFlow flow, Date dateOfCreation);
	 void addContender()
	 
}
