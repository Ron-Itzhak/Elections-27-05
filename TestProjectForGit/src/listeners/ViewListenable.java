package listeners;

import Model.Date;
import Model.Party.eFlow;

public interface ViewListenable {
	 void addBallotBox(String adress,String type);
	 void addCitizen(String name,int id,int year,boolean qurantine, String type);
	 void addParty(String name, eFlow flow, Date dateOfCreation);
	 void addExistingContenderToParty(int id, String partyBelonging, boolean isExist) throws Exception;
	 void addContenderToParty(String name,int id,int year,boolean qurantine, String partyBelonging) throws Exception;
	 String viewAllBallots();
	 
}
