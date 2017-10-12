import java.util.Scanner;

public class SUV extends Car {
	private int fuelLevel; 
	private int consumptionRate;
	private int speed;
	private int currentPosition;
	
	public SUV(){
		super();
		this.fuelLevel=50;
		this.consumptionRate =3;
		this.speed=2;
		this.currentPosition = 0;
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
		return currentPosition;
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

	public void performActionSUV(String action, SUV mySUV, GameController gc) {
		if (action.equals("c"))
			Debug.on=true;
		if(action.equals("q"))	{
			System.out.println("Quitting game...");
			System.exit(1);
		}
		if (((action.equals("a") || (action.equals("d"))) && (gc.generateBlizzard==false))){
			mySUV.currentPosition=mySUV.currentPosition+2;
			mySUV.setFuel(3);				
			System.out.println("Current fuel: " + mySUV.getFuel());
			int fuelUse = mySUV.getFuelUse();
			System.out.println("Fuel Use: " + fuelUse);
			int distanceTravelled = mySUV.getDistanceTravelled();
			System.out.println("Distance Travelled: " + distanceTravelled); 
			System.out.println(); 
			}
		else if((action.equals("a") && (gc.generateBlizzard==true))){
			System.out.println("Blizzard hits and SUV moves slowly but surely in AWD mode!!");
			mySUV.currentPosition=mySUV.currentPosition+1;
			mySUV.setFuel(3);
			System.out.println("Current fuel: " + mySUV.getFuel());
			int fuelUse = mySUV.getFuelUse();
			System.out.println("Fuel Use: " + fuelUse);
			int distanceTravelled = mySUV.getDistanceTravelled();
			System.out.println("Distance Travelled: " + 1); 
			System.out.println(); 
			gc.generateBlizzard=false;
		}
		else if((action.equals("d") && (gc.generateBlizzard==true))){
			mySUV.setFuel(3);
			System.out.println("Current fuel: " + mySUV.getFuel());
			int fuelUse = mySUV.getFuelUse();
			System.out.println("Fuel Use: " + fuelUse);
			int distanceTravelled = mySUV.getDistanceTravelled();
			System.out.println("Distance Travelled: " + distanceTravelled); 
			System.out.println(); 
			gc.generateBlizzard=false;
		}
	}
	
	public void turn(SUV mySUV, GameController gc) {//displays suv menu and uses input to see what to do next
		displaySUVOptions();
		String userAction = getInput();
		performActionSUV(userAction, mySUV, gc);
	}
	
	public static void displaySUVOptions(){
		System.out.println("SUV driving options:");
		System.out.println("(a)ll wheel drive mode");
		System.out.println("(d)rive normally");
		System.out.println("(q)uit simulation");
		System.out.print("Enter selection: ");
	}
	
	public String getInput() {
		Scanner in = new Scanner(System.in);
		String input =in.next();
		return input;
	}
	
	
	
	
	
	
	
	
	
	
}

