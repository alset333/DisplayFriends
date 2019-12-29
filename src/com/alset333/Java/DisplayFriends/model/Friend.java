package com.alset333.Java.DisplayFriends.model;

public class Friend {

	// Directions
	public static final int SOUTH = 0;
	public static final int WEST  = 1;
	public static final int EAST  = 2;
	public static final int NORTH = 3;
	
	/** Number of steps in the walk cycle */
	public static final int STEPS = 4;

	private final String name;
	private final String imagePath;
	private int direction;
	private int step;

	/**
	 * Create a "Friend" with name and imagePath. Assumes facing SOUTH.
	 * @param name Friend's name (e.g. Niko).
	 * @param imagePath Path to the image with sprites (e.g. "X:\folder\niko.png").
	 */
	public Friend(String name, String imagePath) {
		this(name, imagePath, SOUTH);
	}
	
	/**
	 * Create a "Friend" with name, imagePath, and initialDirection.
	 * @param name Friend's name (e.g. Niko).
	 * @param imagePath Path to the image with sprites (e.g. "X:\folder\niko.png").
	 * @param initialDirection The direction for the character to face initially (e.g. Friend.NORTH).
	 */
	public Friend(String name, String imagePath, int initialDirection) {
		this.name = name;
		this.imagePath = imagePath;
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
	public String getImagePath() {	return imagePath;	}

	// Setters
	public void setDirection(int direction) {	this.direction = direction;	}
	public void setStep(int step)			{	this.step = step;	}


}
