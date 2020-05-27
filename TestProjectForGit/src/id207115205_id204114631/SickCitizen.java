package id207115205_id204114631;

public class SickCitizen extends Citizen implements Sickable {

	public SickCitizen(String name, String id, int yearOfBorn, boolean inQuarantine) throws Exception {
		super(name, id, yearOfBorn, inQuarantine);
		isSick = true;
	}
	public SickCitizen(Citizen c) {
		 super (c.name, c.id, c.yearOfBorn, c.inQuarantine);
		isSick = true;
	}

	@Override
	public int getSickDays() {
		return sickDays;
	}
	@Override
	public void setSickDays(int sickDays) {
		this.sickDays = sickDays; 
	}
	
} 
