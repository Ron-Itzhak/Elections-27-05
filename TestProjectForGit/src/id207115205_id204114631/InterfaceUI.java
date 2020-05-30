package id207115205_id204114631;

import java.util.Scanner;

public interface InterfaceUI {
	 void UIgetChoise(Scanner s);
	 void UIaddBallotBox(Scanner s, Management m);
	 void UIaddCitizen(Scanner s, Management m);
	 void UIaddParty(Scanner s, Management m);
	 void UIaddContender(Scanner scan, Management m);
	 void UIshowBallotResults(Management m);
	 void UIshowCitizens(Management m);
	 void UIshowParties(Management m);
	 void UICreateNewElection(Scanner scan,Management m);
	 void UIshowLastresults(Management m, Scanner scan);

}
