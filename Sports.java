
public class Sports extends Car{
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

	public void setPosition(int n, DesertTrack aDes, Sports mySport){// sets the position of the suv 
		aDes.aTrack[n] = mySport;
		for(int z = 24; z >= 0; z--){
			if (aDes.aTrack[z] != mySport){
				aDes.aTrack[z] = null;
			}
		}
	}
	
	public void performAction(String sportsInput){
		if (sportsInput.equals("c"))
			Debug.on=true; 
		if(sportsInput.equals("q"))	{
			System.out.println("Quitting game...");
			System.exit(1);
		}
		if (sportsInput.equals("d")){
			this.setDistanceTravelled(this.getDistanceTravelled() + 3);
		}
		if (DesertTrack.generateHeat()==false){
			this.setFuel(this.getFuel() - this.getFuelUse()); 
			this.fuelLevel = this.getFuel(); 
			System.out.println("Current fuel: " + this.fuelLevel);
			int fuelUse = this.getFuelUse();
			System.out.println("Fuel Use: " + fuelUse);
		}
		else{
			System.out.println("A heatwave hammers the desert track!!!!");
			this.setFuel(this.getFuel() - 4); 
			System.out.println("Current fuel: " + this.getFuel());
			System.out.println("Fuel Use: " + 4);
		}
		int distanceTravelled = this.getDistanceTravelled() + 1;
		System.out.println("Distance Travelled: " + distanceTravelled); 
		System.out.println(); 
	}
	
	
	public void displayOptions() {
		System.out.println("Sportscar driving options:");
		System.out.println("(d)rive normally");
		System.out.println("(q)uit simulation");
		System.out.print("Enter selection: ");
	}
	
	
}

