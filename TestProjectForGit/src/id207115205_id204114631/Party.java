package id207115205_id204114631;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Party {
	public enum eFlow {
		Left, Center, Right
	};

	public static int num = 0;

	private int numofVoices, id;
	private String name;
	private eFlow flow;
	private Date dateOfCreation;
	private ArrayList<Contender> contenders;

	public Party(String name, String flow, String dateOfCreation, ArrayList<Contender> contenders) {
		id = num++;
		this.name = name;
		this.flow = eFlow.valueOf(flow);
		String[] str = dateOfCreation.split("/");
		this.dateOfCreation = new Date(Integer.parseInt(str[2]), (Integer.parseInt(str[1]) - 1),
				Integer.parseInt(str[0]));
		this.contenders = contenders;
		partyElecetion();
		sortByPartyElection();
	}

	public ArrayList<Contender> getContenders() {
		return contenders;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public int getNumOfVoices() {
		return numofVoices;
	}

	public void partyElecetion() {
		Random rd = new Random();
		int quantityOfVoices = 0;
		int[] voices = new int[contenders.size()];
		for (int i = 0; i < contenders.size(); i++)
			voices[i] = rd.nextInt(contenders.size());
		for (int i = 0; i < voices.length; i++) {
			for (int j = 0; j < voices.length; j++) {
				if (i == voices[j])
					quantityOfVoices++;
			}
			contenders.get(i).setNumOfVoices(quantityOfVoices);
			quantityOfVoices = 0;
		}
	}

	public void sortByPartyElection() {
		Comparator<Contender> compareByVoices = new Comparator<Contender>() {

			public int compare(Contender c1, Contender c2) {
				if (c1.getNumOfVoices() < c2.getNumOfVoices())
					return 1;
				else if (c1.getNumOfVoices() == c2.getNumOfVoices())
					return 0;
				else
					return -1;
			}
		};
		Collections.sort(contenders, compareByVoices);
	}

	public void addingContender(Contender c) {
		contenders.add(c);
	}

	public void addVote() {
		numofVoices++;
	}

	public boolean equals(Party other) {
		return (name.equals(other.name) && dateOfCreation.equals(other.dateOfCreation));
	}

	public String toString() {
		return "Party: " + name + ", flow - " + flow.name() + ", that creates in date - " + dateOfCreation.toString()
				+ " has " + numofVoices + " voices in the last election\n";
	}

}
