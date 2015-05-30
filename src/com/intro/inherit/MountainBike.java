package com.intro.inherit;

public class MountainBike extends Bicycle {

	private String suspension;

	// default / empty constructor
	public MountainBike() {

	}

	// Constructor with parameters
	public MountainBike(int startCadence, int startSpeed, int startGear,
			String suspensionType) {
		super(startCadence, startSpeed, startGear);
		this.setSuspension(suspensionType);
	}

	public String getSuspension() {
		return this.suspension;
	}

	public void setSuspension(String suspensionType) {
		this.suspension = suspensionType;
	}

	// overridden method
	public void printDescription() {
		super.printDescription();
		System.out.println("The " + "MountainBike has a" + getSuspension()
				+ " suspension.");
	}

}
