package Model;

import java.util.ArrayList;
import java.util.Scanner;

import Model.Party.eFlow;

public class Management {
	private ArrayList<Election> elections;
	private Set<Citizen> citizens;
	private ArrayList<Party> parties;
	private ArrayList<BallotBox> boxes;
	private BallotBox<Citizen> citizensBallot;
	private BallotBox<SickCitizen> sickCitizensBallot;
	private BallotBox<Soldier> soldiersBallot;
	private BallotBox<SickSoldier> sickSoldiersBallot;
	public Management() throws Exception {
		

		//		ArrayList<Citizen> c = new ArrayList<Citizen>();
		//		citizens = new Set(c);
		citizens = new Set<Citizen>();
		parties = new ArrayList<Party>();
		boxes = new ArrayList<BallotBox>();
		elections = new ArrayList<Election>();
		citizens.addData(new Citizen("Gogo", "123456789", 1980, false));
		citizens.addData(new Citizen("Momo", "987654321", 1981, true));
		citizens.addData(new Citizen("Zozo", "678912345", 1982, false));
		citizens.addData(new Citizen("Aoao", "456789123", 1983, true));
		citizens.addData(new Citizen("Roro", "891234567", 1984, false));
		citizens.addData(new Citizen("Bobo", "234567891", 2000, false));
		citizens.addData(new Citizen("Toto", "123456780", 2001, false));
		citizens.addData(new Citizen("Soso", "123456790", 1999, false));
		citizens.addData(new Citizen("Gogo", "123456787", 1980, true));
		citizens.addData(new Citizen("Gogo", "123456786", 1999, false));
		citizens.addData(new Citizen("Gogo", "123456785", 1980, true));
		citizens.addData(new Citizen("Gogo", "123456784", 2000, false));
		citizens.addData(new Citizen("Gogo", "123456783", 1980, true));
		citizens.addData(new Citizen("Gogo", "123456782", 2002, false));
		citizens.addData(new Contender("Bibi", "123451234", 1970, false, "Halikud", true));
		citizens.addData(new Contender("Miri", "123451235", 1975, false, "Halikud", true));
		citizens.addData(new Contender("Benny", "123451236", 1972, false, "Kahollavan", true));
		citizens.addData(new Contender("Yair", "123451237", 1973, true, "Kahollavan", true));
		citizens.addData(new Contender("Ahmed", "123451238", 1974, true, "Hareshima", true));
		citizens.addData(new Contender("Aimen", "123451239", 1976, true, "Hareshima", true));
		ArrayList<Contender> halikudList = new ArrayList<Contender>();
		ArrayList<Contender> kaholLavanList = new ArrayList<Contender>();
		ArrayList<Contender> hareshimaList = new ArrayList<Contender>();
		halikudList.add((Contender) citizens.get(14));
		halikudList.add((Contender) citizens.get(15));
		kaholLavanList.add((Contender) citizens.get(16));
		kaholLavanList.add((Contender) citizens.get(17));
		hareshimaList.add((Contender) citizens.get(18));
		hareshimaList.add((Contender) citizens.get(19));
		parties.add(new Party("Halikud", "Right", "1/1/80", halikudList));
		parties.add(new Party("Kahollavan", "Center", "1/1/81", kaholLavanList));
		parties.add(new Party("Hareshima", "Left", "1/1/82", hareshimaList));
		citizensBallot = new BallotBox<Citizen>("NessZiona", parties, parties.size(), "Citizen");
		sickCitizensBallot = new BallotBox<SickCitizen>("RishonLeziyon", parties, parties.size(), "SickCitizen");
		soldiersBallot = new BallotBox<Soldier>("BeerYaakov", parties, parties.size(), "Soldier");
		sickSoldiersBallot = new BallotBox<SickSoldier>("Hadera", parties, parties.size(), "SickSoldier");
		boxes.add(citizensBallot);
		boxes.add(sickCitizensBallot);
		boxes.add(soldiersBallot);
		boxes.add(sickSoldiersBallot);
		
		Election hardcodedelc = new Election(5,2020,citizens,parties,boxes);
		elections.add(hardcodedelc);

		for (int i = 0; i < citizens.size(); i++) {

			if (citizens.get(i).getClass() == Soldier.class)
				soldiersBallot.addVoter(citizens.get(i));
			else if (citizens.get(i).getClass() == SickCitizen.class)
				sickCitizensBallot.addVoter(citizens.get(i));
			else if (citizens.get(i).getClass() == SickSoldier.class)
				sickSoldiersBallot.addVoter(citizens.get(i));
			else
				citizensBallot.addVoter(citizens.get(i));
		}
	}

	//// MVC FUNCS //////
	////1//////
	public void addBallotBoxMVC(String adress, String type) {
		if (type.equals(Soldier.class.getSimpleName())) {
			soldiersBallot = new BallotBox<Soldier>(adress, parties, parties.size(), type);
			addBallotBox(soldiersBallot);
		} else if (type.equals(SickCitizen.class.getSimpleName())) {
			sickCitizensBallot = new BallotBox<SickCitizen>(adress, parties, parties.size(), type);
			addBallotBox(sickCitizensBallot);
		} else if (type.equals(SickSoldier.class.getSimpleName())) {
			sickSoldiersBallot = new BallotBox<SickSoldier>(adress, parties, parties.size(), type);
			addBallotBox(sickSoldiersBallot);
		} else {
			citizensBallot = new BallotBox<Citizen>(adress, parties, parties.size(), type);
			addBallotBox(citizensBallot);

		}
	}

	
	

	
	/////5///
	public String showBallotResults() {
		StringBuffer sb = new StringBuffer("You chose to see the ballot boxes results-\n");
		for (int i = 0; i < boxes.size(); i++) 
			sb.append(boxes.get(i).toString());
		return sb.toString();

	}

	///////////
	
	
	public ArrayList<Citizen> getNewContenderList() {
		ArrayList<Citizen> list = new ArrayList<Citizen>();
		return list;
	}

	public ArrayList<Citizen> getCitizens() {
		return citizens.getAllData();
	}

	public ArrayList<Election> getElections() {
		return elections;
	}

	public void addCitizen(Citizen c) {
		citizens.addData(c);
		if (c.getClass() == Soldier.class)
			boxes.get(2).getVoters().add(c);
		else if (c.getClass() == SickSoldier.class)
			boxes.get(3).getVoters().add(c);
		else if (c.getClass() == SickCitizen.class)
			boxes.get(1).getVoters().add(c);
		else
			boxes.get(0).getVoters().add(c);
	}

	public ArrayList<Party> getParties() {
		return parties;
	}

	public void addParty(Party p) {
		parties.add(p);
	}

	public void addElection(Election e) {
		elections.add(e);
	}

	public ArrayList<BallotBox> getBoxes() {
		return boxes;
	}

	public void addBallotBox(BallotBox b) {
		boxes.add(b);
	}
	
	public void addCitizen(String name, int id, int yearOfBorn, boolean inQuarantine, int numOfSick, boolean carryWeapon, String type) {
		
	}
///aviad
	public void addContender(int id, String partyBelonging, boolean isExist) throws Exception {
		if (isExist) {
			for (int i = 0; i < citizens.size(); i++) {
				if (citizens.get(i).getId() == id) {
					isExist = true;
					Citizen c = citizens.get(i);
					int location = citizens.indexOf(citizens.get(i));
					citizens.remove(location);
					Contender con  = new Contender(c, partyBelonging);
					citizens.addData(location ,con); 
					for (int j = 0; j < parties.size(); j++) {
						if (parties.get(i).getName().equals(partyBelonging))
							parties.get(i).addingContender(con);
					}
				}
			}
		}
		else {
			
		}
	}
	
	public void addParty(String name, String flow, Date dateOfCreation) {
		ArrayList<Contender> contenders = new ArrayList<Contender>();
		Party p = new Party(name, flow, dateOfCreation + "", contenders);
		parties.add(p);
	}

	public BallotBox getBoxById(int id) {
		for (int i = 0; i < boxes.size(); i++) {
			if (boxes.get(i).getId() == id)
				return boxes.get(i);
		}
		return null;
	}

	public int addVoterToBox(Citizen c, String type) {
		for (int i = 0; i < boxes.size(); i++) {
			if (boxes.get(i).getType().equals(type)) {
				boxes.get(i).addVoter(c);
				return boxes.get(i).getId();
			}
		}
		return -1;
	}


	public void election() {
		for (int i = 0; i < boxes.size(); i++)
			boxes.get(i).vote();
	}
	

	
	/////6/////
	public String viewAllCitizens() {
		String str="";
			for (int i = 0; i < citizens.size(); i++)
				str+=(citizens.get(i).toString());
		return str;
	}

	//////
	public  String showParties() {
		String str="";
		for (int i = 0; i < parties.size(); i++)
			str+=(parties.get(i).toString());
		return str;
	}
	///////////
	public void CreateNewElection(int month,int year) {
		 Election e = new Election(month,year,citizens,parties,boxes);
		 elections.add(e);
	}

	public String viewLastResults() {
		return elections.get(elections.size()-1).toString();
	}




}
