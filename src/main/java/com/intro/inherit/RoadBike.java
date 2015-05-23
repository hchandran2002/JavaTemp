package com.intro.inherit;

// subclass
public class RoadBike extends Bicycle {

	private int tireWidth;

	public RoadBike() {

	}

	public RoadBike(int startCadence, int startSpeed, int startGear,
			int newTireWidth) {
		super(startCadence, startSpeed, startGear);
		this.setTireWidth(newTireWidth);
	}

	public int getTireWidth() {
		return this.tireWidth;
	}

	public void setTireWidth(int newTireWidth) {
		this.tireWidth = newTireWidth;
	}

	// overridden method
	public void printDescription() {
		super.printDescription();
		System.out.println("The RoadBike" + " has " + getTireWidth()
				+ " MM tires.");
	}

}
