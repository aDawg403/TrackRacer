import java.util.Scanner;

/*
Author:  James Tam
Version: April 1, 2013

Features:
* Tracks and manages information for appearance and fuel capacity.


*/

abstract public class Car
{
  public static final int STARTING_FUEL = 40;
  public static final int STANDARD_DISTANCE = 2;
  public static final int CONSUMPTION_RATE = 2;

  protected char appearance;
  protected int currentPosition;
  protected int fuelLevel;
  protected int fuel;
  protected int consumptionRate;
  protected int speed;

  
  

	public int getFuelUse()//returns fuel consumption
	{
		return consumptionRate;
	}
	public int getDistanceTravelled()//returns the distance travelled
	{
		return currentPosition;
	}
  
	public void setDistanceTravelled(int newDistance) {
		this.currentPosition = newDistance;
	}
  
  public Car()
  {
	setAppearance('c');
	fuelLevel = STARTING_FUEL;
	currentPosition = 0;
  }

  // As the car moves, this class or child classes can specify for that type of car
  // how much fuel to consume.
  protected void consumeFuel(int amount)
  {
	if (amount < 0)
	    fuel = 0;
	else
	    fuel = fuel - amount;
  }

  public int getFuel()
  {
	return fuelLevel;
  }

  // Allows external queries of the fuel state of a particular car.
  public boolean isEmpty()
  {
	if (fuel <= 0)
	    return true;
	else
	    return false;
  }

  // Car internally knows how much fuel to use and how far to move. However the 
  // actual movement in the virtual track must be done by another class hence
  // this method must communicate to the caller how far it moves.


  // If this method is overriden then all child class methods must also display
  // the same debugging messages shown below.
  public int move ()
  {
	consumeFuel(CONSUMPTION_RATE);
	System.out.println("Current fuel: " + fuel);
	System.out.println("Fuel use: " + CONSUMPTION_RATE);
	//System.out.println("Distance traveled: " + STANDARD_DISTANCE);
	return STANDARD_DISTANCE;
  }

  public void setAppearance (char anAppearance)
  {
	appearance = anAppearance;
  }

  public void setFuel (int newFuel)
  {
	if (fuelLevel < 0)
	    System.out.println("Fuel cannot be set to a negative value");
	else
	    fuelLevel = newFuel;
  }

  public String toString() 
  {
	String s = "";
	s = s + appearance;
	return s;
  }
  public void turn(GameController gc) {//displays suv menu and uses input to see what to do next
		displayOptions();
		String userAction = getInput();
		this.performAction(userAction, gc);
  }
  public String getInput() {
	  Scanner in = new Scanner(System.in);
	  String input =in.next();
	  return input;
  }
  
  
  abstract void displayOptions();
  
  abstract void performAction(String userAction, GameController gc);
  
  
  
  
  
}
