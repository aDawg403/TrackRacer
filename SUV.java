public class SUV extends Car {
	
	public SUV(){
		super();
		this.fuelLevel=50;
		this.consumptionRate =3;
		this.speed=2;
		this.currentPosition = 0;
		setAppearance('V');
	}

	public void setPosition(int newPosition, ArcticTrack anArc, SUV mySUV){//sets the new position 
		anArc.aTrack[newPosition] = mySUV;
		for(int z = 24; z >= 0; z--){
			if (anArc.aTrack[z] != mySUV){
				anArc.aTrack[z] = null;
			}
		}
	}

	public void performAction(String action, GameController gc) {
		if (action.equals("c"))
			Debug.on=true;
		if(action.equals("q"))	{
			System.out.println("Quitting game...");
			System.exit(1);
		}
		if (ArcticTrack.generateBlizzard() == true) {
			if (action.equals("d")) {
				this.setFuel(this.getFuel() - this.getFuelUse());	
			}
			else if (action.equals("a")) {
				System.out.println("Blizzard hits and SUV moves slowly but surely in AWD mode!!");
				this.setDistanceTravelled(this.getDistanceTravelled() + 1);
			}
		}
		else {
			this.setDistanceTravelled(this.getDistanceTravelled() + 2);
			this.setFuel(this.getFuel() - this.getFuelUse());				
		}
		System.out.println("Current fuel: " + this.getFuel()); 
		int fuelUse = this.getFuelUse();
		System.out.println("Fuel Use: " + fuelUse);
		int distanceTravelled = this.getDistanceTravelled() + 1;
		System.out.println("Distance Travelled: " + distanceTravelled); 
		System.out.println(); 
	}
	
	
	public void displayOptions(){
		System.out.println("SUV driving options:");
		System.out.println("(a)ll wheel drive mode");
		System.out.println("(d)rive normally");
		System.out.println("(q)uit simulation");
		System.out.print("Enter selection: ");
	}
	
	
	
	
	
	
	
	
	
	
	
}

