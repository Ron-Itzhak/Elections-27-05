package id207115205_id204114631;

import java.util.Scanner;

public class Program implements InterfaceUI {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		Management m = new Management();
		int choice;
		do {
			choice = Methods.getChoice(scan);
			switch (choice) {
			case 1:
				break;
			case 2:
				Methods.addCitizen(scan, m);
				break;
			case 3:
				Methods.addParty(scan, m);
				break;
			case 4:
				Methods.addContender(scan, m);
				break;
			case 5:
				Methods.showBallotResults(m);
				break;
			case 6:
				Methods.showCitizens(m);
				break;
			case 7:
				Methods.showParties(m);
				break;
			case 8:
				Methods.CreateNewElection(scan,m);
				break;
			case 9:
				Methods.showLastresults(m, scan);
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

	@Override
	public void UIaddBallotBox(Scanner s, Management m) {
		int ballotBox = 0;
		do {
			System.out.println("You chose to add a new ballot box\nWhich Ballot box would you like to add?");
			System.out.println(
					"1 - sick citizens ballot box\n2 - soldiers ballot box\n3 - sick soldiers ballot box\n4 - regular ballot box");
			ballotBox = s.nextInt();
			switch (ballotBox) {
			case 1:
				System.out.println("What is the city that the ballot box will be in?");
				BallotBox<SickCitizen> sickCitizensBox = new BallotBox<SickCitizen>(s.next(), m.getParties(),
						m.getParties().size(), "SickCitizen");
				m.addBallotBox(sickCitizensBox);
				break;
			case 2:
				System.out.println("What is the city that the ballot box will be in?");
				BallotBox<Soldier> soldiersBox = new BallotBox<Soldier>(s.next(), m.getParties(), m.getParties().size(),
						"Soldier");
				m.addBallotBox(soldiersBox);
				break;
			case 3:
				System.out.println("What is the city that the ballot box will be in?");
				BallotBox<SickSoldier> sickSoldiersBoxes = new BallotBox<SickSoldier>(s.next(), m.getParties(),
						m.getParties().size(), "SickSoldier");
				m.addBallotBox(sickSoldiersBoxes);
				break;
			case 4:
				System.out.println("What is the city that the ballot box will be in?");
				BallotBox<Citizen> citizensBox = new BallotBox<Citizen>(s.next(), m.getParties(), m.getParties().size(),
						"Citizen");
				m.addBallotBox(citizensBox);
				break;
			default:
				System.out.println("Invalid choice, please try again");
				ballotBox = 0;
			}
		} while (ballotBox == 0);
		int lastBoxNum = m.getBoxes().size() - 1;
		System.out.println("Ballot Box number " + m.getBoxes().get(lastBoxNum).getId() + " added succesfully ");
	
	};
	

	@Override
	public void UIaddCitizen(Scanner s, Management m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void UIaddParty(Scanner s, Management m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void UIaddContender(Scanner scan, Management m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void UIshowBallotResults(Management m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void UIshowCitizens(Management m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void UIshowParties(Management m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void UICreateNewElection(Scanner scan, Management m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void UIshowLastresults(Management m, Scanner scan) {
		// TODO Auto-generated method stub
		
	}

		
}
