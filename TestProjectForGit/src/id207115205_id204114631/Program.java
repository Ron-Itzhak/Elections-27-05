package id207115205_id204114631;

import java.util.Scanner;

public class Program {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		Management m = new Management();
		int choice;
		do {
			choice = Methods.getChoice(scan);
			switch (choice) {
			case 1:
				Methods.addBallotBox(scan, m);
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

		
}
