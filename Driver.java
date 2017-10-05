


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
  public static void main(String [] args)
  {
	GameController aGameController = new GameController();
	SUV anSUV = new SUV();
	Sports aSport = new Sports();
	int result = aGameController.playGame(aGameController, anSUV, aSport);
	if(result ==1)
		System.out.println("The SUV has won");
	else if (result ==2)
		System.out.println("The sports car has won");
	else
		System.out.println();
	}
  }

