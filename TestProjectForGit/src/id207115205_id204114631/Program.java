package id207115205_id204114631;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.omg.CORBA.BAD_CONTEXT;

public class Program {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int choice;
		boolean exist;
		Managment m = new Managment();
		do {
			choice = getChoice(scan);
			switch (choice) {
			case 1:
				addBallotBox(scan, m);
				break;
			case 2:
				addCitizen(scan, m);
				break;
			case 3:
				addParty(scan, m);
				break;
			case 4:
				System.out
				.println("You chose to add a new contender to a party\nIs it already an existing citizen? Y/N");
				String ch;
				ch = scan.next();
				if (ch.charAt(0) == 'Y' || ch.charAt(0) == 'y') {
					System.out.println("Please enter his id and what party is he contending to");
					int id;
					String party;
					id = scan.nextInt();
					party = scan.next();
					for (int i = 0; i < m.getCitizens().size(); i++) {
						if (m.getCitizens().get(i).getId() == id) {
							Contender con = new Contender(m.getCitizens().get(i), party);
							int location = m.getCitizens().indexOf(m.getCitizens().get(i));
							m.getCitizens().remove(location);
							m.getCitizens().add(location, con);
							for (int j = 0; j < m.getParties().size(); j++) {
								if (m.getParties().get(j).getName().equals(party)) {
									m.getParties().get(j).getContenders().add(con);
									System.out.println("Citizen added succesfully and now he is contending");
								}
							}
						}
					}
				} else if (ch.charAt(0) == 'N' || ch.charAt(0) == 'n') {
					System.out.println(
							"Please enter his name, id, year of born, if he is in quarantine (true/false), number of ballot box and what party is he contending to");
					Contender co = new Contender(scan.next(), scan.next(), scan.nextInt(), scan.nextBoolean(), scan.next(), true);
					do {
						exist = false;
						for (int i = 0; i < m.getCitizens().size(); i++) {
							if (m.getCitizens().get(i).equals(co))
								exist = true;
						}
						if (exist) {
							System.out.println("Already an existing citizen, please enter his details again");
							co = new Contender(scan.next(), scan.next(), scan.nextInt(), scan.nextBoolean(),
									scan.next(), true);
						}
					} while (exist);
					m.getCitizens().add(co);
					for (int i = 0; i < m.getParties().size(); i++) {
						if (m.getParties().get(i).getName().equals(co.getPartyBelonging())) {
							m.getParties().get(i).getContenders().add(co);
							System.out.println("Contender added succesfully");
						}
					}
				} else {
					System.out.println("Invalid input");
				}
				break;
			case 5:
				System.out.println("You chose to see the ballot boxes results-");
				for (int i = 0; i < m.getBoxes().size(); i++)
					System.out.print(m.getBoxes().get(i).toString());
				break;
			case 6:
				System.out.println("You chose to see all the citizens-");
				for (int i = 0; i < m.getCitizens().size(); i++)
					System.out.print(m.getCitizens().get(i).toString());
				break;
			case 7:
				showParties(m);
				break;
				//			case 8:
				//				System.out.println("You chose to set a new election\nPlease enter month and year of the election");
				//				Election e = new Election(scan.nextInt(), scan.nextInt(), m.getCitizens(), m.getParties(),
				//						m.getBoxes());
				//				do {
				//					exist = false;
				//					for (int i = 0; i < m.getElections().size(); i++) {
				//						if (m.getElections().get(i).equals(e))
				//							exist = true;
				//					}
				//					if (exist) {
				//						System.out.println("Election already exist in thath date\nPlease enter details again");
				//						e = new Election(scan.nextInt(), scan.nextInt(), m.getCitizens(), m.getParties(), m.getBoxes());
				//					}
				//				} while (exist);
				//				m.addElection(e);
				//				System.out.println("Please enter for every citizen his vote - true/false");
				//				String vote;
				//				for (int i = 0; i < m.getCitizens().size(); i++) {
				//					System.out.println("is " + m.getCitizens().get(i).toString() + " want to vote?");
				//					m.getCitizens().get(i).setIsVoting(scan.nextBoolean());
				//					if (m.getCitizens().get(i).getIsVoting()) {
				//						System.out.println("Which party is the citizen voting for? enter a party name");
				//						for (int j = 0; j < m.getParties().size(); j++)
				//							System.out.print(m.getParties().get(j).toString());
				//						vote = scan.next();
				//						m.getCitizens().get(i).setLastVote(vote);
				//					}
				//				}
				//				for (int i = 0; i < m.getCitizens().size(); i++) {
				//					for (int j = 0; j < m.getParties().size(); j++) {
				//						if (m.getCitizens().get(i).getLastVote() != null) {
				//							if (m.getCitizens().get(i).getLastVote().equals(m.getParties().get(j).getName()))
				//								m.getParties().get(j).addVote();
				//						}
				//					}
				//				}
				//				m.getElections().get((m.getElections().size() - 1)).saveResults();
				//				break;
			case 9:
				System.out.println(
						"You chose to see the election result\nPlease enter month and year of the requested election");
				int month = 1, year = 1;
				do {
					exist = false;
					for (int i = 0; i < m.getElections().size(); i++) {
						if (!m.getElections().get(i).exist(month, year))
							exist = true;
					}
					if (exist) {
						System.out.println("There is no election in that date, please enter details again");
						month = scan.nextInt();
						year = scan.nextInt();
					}
				} while (exist);
				for (int i = 0; i < m.getElections().size(); i++) {
					if (m.getElections().get(i).getMonth() == month && m.getElections().get(i).getYear() == year)
						System.out.println(m.getElections().get(i).getResult());
				}
				break;
			case 10:
				System.out.println("Bye Bye");
				break;
			default:
				System.out.println("Invalid choice, please try again");
				break;
			}
		} while (choice != 10);
		scan.close();
	}

	public static int getChoice(Scanner s) {
		int choice = 0;
		boolean isOK = false;
		do {
			isOK = false;
			System.out.println("Hello!\nWelcome to the election program");
			System.out.println("enter a number to pick your choice for one of the following options:");
			System.out.println("1 - Adding Ballot Box");
			System.out.println("2 - Adding Citizen");
			System.out.println("3 - Adding Party");
			System.out.println("4 - Adding Contender to Party");
			System.out.println("5 - Showing Ballot Boxes results");
			System.out.println("6 - Showing all the Citizens");
			System.out.println("7 - Showing all the Parties");
			System.out.println("8 - Setting New Election");
			System.out.println("9 - Showing The last Election results");
			System.out.println("10 - Exit");
			try {
				choice = Integer.parseInt(s.next());			
			} catch (InputMismatchException ime) {
				System.out.println("Exception has been thrown - please enter right arguments");
				isOK = true;
				s.nextLine();
			} catch (NumberFormatException nfe) {
				System.out.println("Exception has been thrown - please enter a number");
				isOK = true;
				s.nextLine();
			} catch (Exception e) {
				System.out.println("Exception has been thrown - " + e.getMessage() + " please try again");
				isOK = true;
				s.nextLine();
			}
		} while (isOK);
		return choice;
	}

	public static void addBallotBox(Scanner s, Managment m) {
		int ballotBox = 0;
		do {
			System.out.println("You chose to add a new ballot box\nWhich Ballot box would you like to add?");
			System.out.println("1 - sick citizens ballot box\n2 - soldiers ballot box\n3 - sick soldiers ballot box\n4 - regular ballot box");
			ballotBox = s.nextInt();
			switch (ballotBox) {
			case 1:
				System.out.println("What is the city that the ballot box will be in?");
				BallotBox<SickCitizen> sickCitizensBox = new BallotBox<SickCitizen>(s.next(), m.getParties(), m.getParties().size(), "SickCitizen");
				m.addBallotBox(sickCitizensBox);
				break;
			case 2:
				System.out.println("What is the city that the ballot box will be in?");
				BallotBox<Soldier> soldiersBox = new BallotBox<Soldier>(s.next(), m.getParties(), m.getParties().size(), "Soldier");
				m.addBallotBox(soldiersBox);
				break;
			case 3:
				System.out.println("What is the city that the ballot box will be in?");
				BallotBox<SickSoldier> sickSoldiersBoxes = new BallotBox<SickSoldier>(s.next(), m.getParties(), m.getParties().size(), "SickSoldier");
				m.addBallotBox(sickSoldiersBoxes);
				break;
			case 4:
				System.out.println("What is the city that the ballot box will be in?");
				BallotBox<Citizen> citizensBox = new BallotBox<Citizen>(s.next(), m.getParties(), m.getParties().size(), "Citizen");
				m.addBallotBox(citizensBox);
				break;
			default:
				System.out.println("Invalid choice, please try again");
				ballotBox = 0;
			}
		} while (ballotBox == 0);
		int lastBoxNum = m.getBoxes().size() - 1;
		System.out.println("Ballot Box number " + m.getBoxes().get(lastBoxNum).getId() + " added succesfully ");
	}

	public static void addCitizen(Scanner s, Managment m) throws Exception {
		boolean exist;
		System.out.println("You chose to add a new citizen");
		System.out.println("Please enter his name, id, year of born and if he is in quarantine (true/false)");
		do {
			try {
				Citizen c = new Citizen(s.next(), s.next(), s.nextInt(), s.nextBoolean());
				do {
					exist = false;
					for (int i = 0; i < m.getCitizens().size(); i++) {
						if (m.getCitizens().get(i).equals(c))
							exist = true;
					}
					if (exist) {
						System.out.println("Citizen already exist, please enter all details again");
						c = new Citizen(s.next(), s.next(), s.nextInt(), s.nextBoolean());
					}
				} while (exist);
				System.out.println("Does he sick? (true/false)");
				c.setIsSick(s.nextBoolean());
				if (c.getIsSick() && c.age() <= Soldier.AGE_FOR_SOLDIER) {
					System.out.println("please enter the following details\nis he carrying a weapon (true/false) and how many days does he sick");
					c = new SickSoldier(c, s.nextBoolean());
					((SickSoldier) c).setSickDays(s.nextInt());
				} else if (c.getIsSick()) {
					System.out.println("how many days does he sick?");
					c = new SickCitizen(c);
					((SickCitizen) c).setSickDays(s.nextInt());
				} else if (c.age() <= Soldier.AGE_FOR_SOLDIER) {
					System.out.println("Does he carrying a weapon? (true/false)");
					c = new Soldier(c, s.nextBoolean());
				}
				m.addCitizen(c);
				c.setBallotBoxNum(m.addVoterToBox(c, c.getClass().getSimpleName()));
			} catch (InputMismatchException ime) {
				System.out.println("Exception has been thrown - please enter the right arguments, please enter all details again (name, id, year of born, if he is in quarantine)");
				s.nextLine();
				exist = true;
			} catch (IllegalArgumentException iae) {
				System.out.println("Exception has been thrown - please enter numbers in the citizen id, please enter all details again (name, id, year of born, if he is in quarantine)");
				s.nextLine();
				exist = true;
			} catch (Exception e) {
				System.out.println("Exception has been thrown - " + e.getMessage() + ", please enter all details again (name, id, year of born, if he is in quarantine)");
				s.nextLine();
				exist = true;
			}
		} while (exist);
		System.out.println("Citizen added successfully");
	}

	public static void addParty(Scanner s, Managment m) {
		boolean exist;
		System.out.println("You chose to add a new party\nPlease enter the name, flow and date of creation");
		ArrayList<Contender> pContenders = new ArrayList<Contender>();
		Party p = new Party(s.next(), s.next(), s.next(), pContenders);
		do {
			exist = false;
			for (int i = 0; i < m.getParties().size(); i++) {
				if (m.getParties().get(i).equals(p))
					exist = true;
			}
			if (exist) {
				System.out.println("Party already exist");
				p = new Party(s.next(), s.next(), s.next(), pContenders);
			}
		} while (exist);
		m.addParty(p);
		System.out.println("Party added succesfully");
	}

	public static void showParties(Managment m) {
		System.out.print("You chose to see all the parties-");
		for (int i = 0; i < m.getParties().size(); i++)
			System.out.println(m.getParties().get(i).toString());
	}

}
