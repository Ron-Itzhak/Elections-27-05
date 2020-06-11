package Model;

public class SickSoldier extends Soldier implements Sickable {

	public SickSoldier(String name, String id, int yearOfBorn, boolean inQuarantine,
			boolean carryWeapon) throws Exception {
		super(name, id, yearOfBorn, inQuarantine, carryWeapon);
		this.sickDays = sickDays;
		isSick = true;
	}
	
	public SickSoldier(Citizen c, boolean carryWeapon) {
		super (c, carryWeapon);
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
