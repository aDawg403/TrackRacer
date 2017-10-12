


public class Sports extends Car {
	int fuelLevel; 
	int consumptionRate;
	int speed;
	char appearance;
	boolean twoWheelDrive; 
	int currentPosition;
	int currentRound;
	
	public Sports(){
		super();
		this.fuelLevel=30;
		this.consumptionRate =2;
		this.speed=3;
		this.appearance = 'P';
		this.twoWheelDrive=true; 
		this.currentPosition = 0;
		this.currentRound = 0;
	}

	public int getFuel()//retturns fuel level
	{
		return fuelLevel;
	}
	public int getFuelUse()//returns fuel consumption
	{
		return consumptionRate;
	}
	public int getDistanceTravelled()//returns the distance travelled
	{
		return speed; 
	}
	public void setFuel(int newFuel){//changes the amount of fuel to minus the amount passed in 
		fuelLevel=fuelLevel-newFuel;
	}
	public void setPosition(int n, DesertTrack aDes, Sports mySport){// sets the position of the suv 
		aDes.aTrack[n] = mySport;
		for(int z = 24; z >= 0; z--){
			if (aDes.aTrack[z] != mySport){
				aDes.aTrack[z] = null;
			}
		}
	}

}

