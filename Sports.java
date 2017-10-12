import java.util.Scanner;

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
		return currentPosition;
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

	
	public  void performActionSport(String sportsInput, Sports mySport, GameController gc){
		if (sportsInput.equals("c"))
			Debug.on=true; 
		if (sportsInput.equals("d")){
			mySport.currentPosition=mySport.currentPosition+3;
		}
		if(sportsInput.equals("q"))	{
			System.out.println("Quitting game...");
			System.exit(1);
		}
		if (gc.generateHeat==false){
			mySport.setFuel(2); 
			mySport.fuelLevel = mySport.getFuel(); 
			System.out.println("Current fuel: " + mySport.fuelLevel);
			int fuelUse = mySport.getFuelUse();
			System.out.println("Fuel Use: " + fuelUse);
		}
		else{
			System.out.println("A heatwave hammers the desert track!!!!");
			mySport.setFuel(4);
			mySport.fuelLevel = mySport.getFuel(); 
			System.out.println("Current fuel: " + mySport.fuelLevel);
			System.out.println("Fuel Use: " + 4);
			gc.generateHeat=false; 
		}
		int distanceTravelled = mySport.getDistanceTravelled();
		System.out.println("Distance Travelled: " + distanceTravelled); 
		System.out.println(); 
	}
	
	
	public void turn(Sports mySport, GameController gc) {//displays suv menu and uses input to see what to do next
		displayMoveOptions();
		String userAction = getInput();
		performActionSport(userAction, mySport, gc);
	}
	
	
	public String getInput() {
		Scanner in = new Scanner(System.in);
		String input =in.next();
		return input;
	}
	
	public void displayMoveOptions() {
		System.out.println("Sportscar driving options:");
		System.out.println("(d)rive normally");
		System.out.println("(q)uit simulation");
		System.out.print("Enter selection: ");
	}
	
	
}

