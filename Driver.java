


/*
Author:  Lillian Iwaniszyn T01
Version: March 26, 2015
Program Features include:
Displays an introduction to the program that describes the rules. It only displays these instructions right after the program is run. The exact content of the instructions are left to your discretion but it should be sufficient to instruct the user how to run the program.
Displays an appropriate status message when the program ends e.g., "SUV reached the end first", "quitting before the simulation ended" etc.
Displays the appropriate menu for the SUV and sports car movement.
Gets user input for the SUV and sports car menu and repeats prompts until valid input is entered.
Program runs until the user quits.
Each track is properly initialized and displayed at the appropriate time when the program runs.
SUV can move and consume fuel as specified in the class description (non-AWD mode).
Sports car can move and consume fuel as specified in the class description.
Arctic track can randomly generate and properly handle the effects of a blizzard on the SUV (regular mode).
AWD mode working properly during a blizzard 
Desert track can randomly generate and properly handle the effects of a heat wave on the sports car
Program can determine when one or both cars have reached the end

Program limitations include:
Not having the cheat menu invoked
The Sports Car will always win, especially since the cheat menu doesnt work and we cannot change the location or fuel of any car. 

Starting execution point.

*/


public class Driver//main function that determines if the SUV or sports car has won 
{
	static int starter=0;
	static DesertTrack aDes = new DesertTrack();
	static ArcticTrack anArc = new ArcticTrack(); 
	
	
	
	
  public static void main(String [] args)
  {
	SUV anSUV = new SUV();
	Sports aSport = new Sports();
	int result = playGame(anSUV, aSport);
	if(result ==1)
		System.out.println("The SUV has won");
	else if (result ==2)
		System.out.println("The sports car has won");
	else
		System.out.println();
	}
  
	public static void printInstructions(){//prints overview of the game 
		System.out.println("This is racing simulation with two separate driving tracks: arctic and desert. For this version of the program the arctic track contains");
		System.out.println("an SUV (Sport Utility Vehicle) and the desert track contains a sports car. Each car will try to reach the end of its respective track without");
		System.out.println("running out of fuel and prior to the other car (see Figure 1). If either or both cars reach the end of the track then the simulation ends: ");
		System.out.println("draw (if both reach it during the same turn), win (for the car that reached it first), and loss (for the car that didn't reach it first). ");
		System.out.println("If one car runs out of fuel then the simulation continues until: both cars run out fuel (tie) or the other car reaches the end (win for that car).");
		System.out.println("The simulation is also a 'draw' if the user quits the program early.");
	}
	
	public static int playGame(SUV mySUV, Sports mySport)// plays the game, determines when the car runs out of fuel 
	{ 
		  boolean sportsWon=false;
		  boolean suvWon=false;
		  printInstructions();
		  while (starter==0)
		  {
			  anArc.setNewPlace(mySUV);
			  aDes.setNewPlace(mySport);
			  anArc.display();
			  aDes.display();
			  if (starter==2){
				  break; 
			  }
			  mySUV.turn();
			  mySport.turn(); 
			  if (mySport.getFuel() <= 1){
				  starter=1;
				  return 1; }
			  if (mySUV.getFuel() <= 2){
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
	
	
	public static void setStarter(int start){//changes the starter to break out of loop when needed
		starter=start;
	}
	
	
  
  
  
  
  
 }

