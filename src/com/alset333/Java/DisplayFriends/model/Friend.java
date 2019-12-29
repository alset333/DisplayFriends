package com.alset333.Java.DisplayFriends.model;

public class Friend {

	// Directions
	public static final int SOUTH = 0;
	public static final int WEST  = 1;
	public static final int EAST  = 2;
	public static final int NORTH = 3;
	
	/** Number of steps in the walk cycle */
	public static final int STEPS = 4;

	private String name;
	private String filename;
	private int direction;
	private int step;

	public Friend(String name, String filename, int initialDirection) {
		this.name = name;
		this.filename = filename;
		this.direction = initialDirection;
		this.step = 0;

	}
	
	/**
	 * Advances the walk cycle by one (loops as needed)
	 * @return The new step value (walk cycle position)
	 */
	public int takeStep() {
		setStep(
					( getStep() + 1 ) 	// One more than the current step
					% STEPS				// Modulo by total steps in cycle so it wraps
				);
		
		// Also return the new step number
		return getStep();
	}

	// Getters
	public int getDirection()	{	return direction;	}
	public int getStep()		{	return step;		}
	public String getName()		{	return name;		}
	public String getFilename() {	return filename;	}

	// Setters
	public void setDirection(int direction) {	this.direction = direction;	}
	public void setStep(int step)			{	this.step = step;	}


}
