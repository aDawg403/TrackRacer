
import java.util.Scanner;
import java.util.Random;

public class GameController {
	
	int sportsUserInput=0;
	int suvUserInput=0; 
	int starter=0;
	boolean generateBlizzard=false; 
	boolean generateHeat=false;
	int sportsFuel;
	int suvFuel; 
	DesertTrack aDes = new DesertTrack();
	ArcticTrack anArc = new ArcticTrack(); 
	public GameController(){

		
	}

	public int playGame(GameController aGameController, SUV mySUV, Sports mySport)// plays the game, determines when the car runs out of fuel 
	{ 
		  boolean sportsWon=false;
		  boolean suvWon=false;
		  printInstructions();
		  while (starter==0)
		  {
			  anArc.setNewPlace(mySUV, aGameController);
			  aDes.setNewPlace(mySport, aGameController);
			  anArc.display();
			  aDes.display();
			  if (starter==2){
				  break; 
			  }
			  displaySUVOption(mySUV, mySport, aDes, anArc, aGameController);
			  displaySportOptions(mySport); 
			  generateBlizzard();
			  generateHeat(); 
			  if (sportsFuel <= 1){
				  starter=1;
				  return 1; }
			  if (suvFuel <= 2){
				  starter=1;
				  return 2;
			  }
		  }
	     if ((suvWon)&& (sportsWon==false)){
	    	  return 1;
	      }
	      else if ((sportsWon)&&(suvWon==false)){
	    	  return 2;
	      }
	      else{
	    	  return 3; 
	      }
	}
	public int displaySUVOption(SUV mySUV, Sports mySports, DesertTrack aDes, ArcticTrack anArc, GameController aGameController) {//displays suv menu and uses input to see what to do next
		int retInt = 0;
		System.out.println("SUV driving options:");
		System.out.println("(a)ll wheel drive mode");
		System.out.println("(d)rive normally");
		System.out.println("(q)uit simulation");
		System.out.print("Enter selection: ");
		Scanner in = new Scanner(System.in);
		String suvInput =in.next();
		if (suvInput.equals("c"))
			Debug.on=true; 
		if(suvInput.equals("q"))	{
			System.out.println("Quitting game...");
			System.exit(1);
		}

		if (((suvInput.equals("a") || (suvInput.equals("d"))) && (generateBlizzard==false))){
			retInt=2; 
			suvUserInput=suvUserInput+2;
			mySUV.setFuel(3);				
			suvFuel = mySUV.getFuel();
			System.out.println("Current fuel: " + suvFuel);
			int fuelUse = mySUV.getFuelUse();
			System.out.println("Fuel Use: " + fuelUse);
			int distanceTravelled = mySUV.getDistanceTravelled();
			System.out.println("Distance Travelled: " + distanceTravelled); 
			System.out.println(); 
			}
		else if((suvInput.equals("a") && (generateBlizzard==true))){
			System.out.println("Blizzard hits and SUV moves slowly but surely in AWD mode!!");
			retInt=1; 
			suvUserInput=suvUserInput+1;
			mySUV.setFuel(3);
			suvFuel = mySUV.getFuel();
			System.out.println("Current fuel: " + suvFuel);
			int fuelUse = mySUV.getFuelUse();
			System.out.println("Fuel Use: " + fuelUse);
			int distanceTravelled = mySUV.getDistanceTravelled();
			System.out.println("Distance Travelled: " + 1); 
			System.out.println(); 
			generateBlizzard=false;
		}
		else if((suvInput.equals("d") && (generateBlizzard==true))){
			System.out.println("Blizzard hits and car spins its wheels!!");
			retInt=0; 
			suvUserInput=suvUserInput+0;
			mySUV.setFuel(3);
			suvFuel = mySUV.getFuel(); 
			System.out.println("Current fuel: " + suvFuel);
			int fuelUse = mySUV.getFuelUse();
			System.out.println("Fuel Use: " + fuelUse);
			int distanceTravelled = mySUV.getDistanceTravelled();
			System.out.println("Distance Travelled: " + 0); 
			System.out.println(); 
			generateBlizzard=false;
		}

		return retInt; 
		
		
		
	}
	public int displaySportOptions(Sports mySport) {//displays suv menu and uses input to see what to do next
		int retInt=0;
		System.out.println("Sportscar driving options:");
		System.out.println("(d)rive normally");
		System.out.println("(q)uit simulation");
		System.out.print("Enter selection: ");
		Scanner in = new Scanner(System.in);
		String sportsInput =in.next();
		if (sportsInput.equals("c"))
			Debug.on=true; 
		if (sportsInput.equals("d")){
			retInt=3; 
			sportsUserInput=sportsUserInput+3;}
		if(sportsInput.equals("q"))	{
			System.out.println("Quitting game...");
			System.exit(1);
		}
		if (generateHeat==false){
		mySport.setFuel(2); 
		sportsFuel = mySport.getFuel(); 
		System.out.println("Current fuel: " + sportsFuel);
		int fuelUse = mySport.getFuelUse();
		System.out.println("Fuel Use: " + fuelUse);
		}
		else{
			System.out.println("A heatwave hammers the desert track!!!!");
			mySport.setFuel(4);
			sportsFuel=mySport.getFuel();
			System.out.println("Current fuel: " + sportsFuel);
			System.out.println("Fuel Use: " + 4);
			generateHeat=false; 
		}
		int distanceTravelled = mySport.getDistanceTravelled();
		System.out.println("Distance Travelled: " + distanceTravelled); 
		System.out.println(); 
		return retInt;
				
	}
	public int getsuvUserInput(){ //returns the user input from suv menu
		return suvUserInput;
	}
	public int getsportsUserInput(){//returns user input from sports car menu
		return sportsUserInput;
	}
	public void generateBlizzard(){//10% chance of generating a blizzard 
		Random randomGenerator = new Random(); 
		int randomInt = randomGenerator.nextInt(10)+1;
		if (randomInt==5)
			generateBlizzard=true;
		
	}
	public void generateHeat(){// 10% chance of generating a heat wave 
		Random randomGenerator = new Random(); 
		int randomInt = randomGenerator.nextInt(10)+1;
		if (randomInt==5)
			generateHeat=true;
		
	}
	public void setStarter(int start){//changes the starter to break out of loop when needed
		starter=start;
	}
	public void printInstructions(){//prints overview of the game 
		System.out.println("This is racing simulation with two separate driving tracks: arctic and desert. For this version of the program the arctic track contains");
		System.out.println("an SUV (Sport Utility Vehicle) and the desert track contains a sports car. Each car will try to reach the end of its respective track without");
		System.out.println("running out of fuel and prior to the other car (see Figure 1). If either or both cars reach the end of the track then the simulation ends: ");
		System.out.println("draw (if both reach it during the same turn), win (for the car that reached it first), and loss (for the car that didn't reach it first). ");
		System.out.println("If one car runs out of fuel then the simulation continues until: both cars run out fuel (tie) or the other car reaches the end (win for that car).");
		System.out.println("The simulation is also a 'draw' if the user quits the program early.");
	}

}



