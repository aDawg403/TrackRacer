


public class SUV extends Car {
	private int fuelLevel; 
	private int consumptionRate;
	private int speed;
	
	public SUV(){
		super();
		this.fuelLevel=50;
		this.consumptionRate =3;
		this.speed=2;
		setAppearance('V');
	}
	public int getFuel()//returns amount of fuel 
	{
		return fuelLevel;
	}
	public int getFuelUse()//returns fuel consumption
	{
		return consumptionRate;
	}
	public int getDistanceTravelled()//returns the distance traveled
	{
		return speed;
	}
	public void setFuel(int newFuel){//changes the amount of fuel by subtracting amount passed in as parameter
		fuelLevel=fuelLevel-newFuel;
	}
	public void setPosition(int newPosition, ArcticTrack anArc, SUV mySUV){//sets the new position 
		anArc.aTrack[newPosition] = mySUV;
		for(int z = 24; z >= 0; z--){
			if (anArc.aTrack[z] != mySUV){
				anArc.aTrack[z] = null;
			}
		}
	}

}

