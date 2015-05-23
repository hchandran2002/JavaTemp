package com.intro.inherit;

// super class
public class Bicycle {

	// state
	protected int cadence;
	protected int speed;
	protected int gear;

	public Bicycle() {

	}

	public Bicycle(int cadence, int speed, int gear) {

		this.cadence = cadence;
		this.speed = speed;
		this.gear = gear;
	}

	// behavior

	protected void changeCadence(int newValue) {
		cadence = newValue;
		System.out.println("super changeCadence");
	}

	protected void changeGear(int newValue) {
		gear = newValue;
		System.out.println("super changeGear");
	}

	protected void speedUp(int increment) {
		speed = speed + increment;
		System.out.println("super speedUp");
	}

	protected void applyBrakes(int decrement) {
		speed = speed - decrement;
		System.out.println("super applyBrakes");
	}

	public void printDescription() {
		System.out.println("\nBike is " + "in gear " + this.gear
				+ " with a cadence of " + this.cadence
				+ " and travelling at a speed of " + this.speed + ". ");
	}

}
