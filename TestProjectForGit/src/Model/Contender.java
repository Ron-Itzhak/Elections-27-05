package Model;

public class Contender extends Citizen {
	private String partyBelonging;
	private boolean isContending;
	private int numOfVoices;

	public Contender(String name, String id, int yearOfBorn, boolean inQuarantine, String partyBelonging,
			boolean isContending) throws Exception {
		super(name, id, yearOfBorn, inQuarantine);
		this.partyBelonging = partyBelonging;
		this.isContending = isContending;
	}

	public Contender(Citizen other, String partyBelonging) throws Exception {
		this(other.name, other.id + "", other.yearOfBorn, other.inQuarantine, partyBelonging, true);
	}

	public String getPartyBelonging() {
		return partyBelonging;
	}

	public boolean setNumOfVoices(int voices) {
		numOfVoices = voices;
		return true;
	}

	public int getNumOfVoices() {
		return numOfVoices;
	}

	public boolean equals(Contender other) {
		return super.equals(other);
	}

	public String toString() {
		StringBuffer sb = new StringBuffer(super.toString());
		if (isContending)
			sb.append(", is contending to " + partyBelonging + " party\n");
		return sb.toString();

	}

}
