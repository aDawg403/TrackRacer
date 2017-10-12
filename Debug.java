

import java.util.Scanner;


/*
Author:  James Tam
Version: April 1, 2013

The sole purpose of this class is track if the program is in debugging mode.

*/
public class Debug
{
  
  public static boolean on = false;
  public static int cheatChoice;
  public static int newSportFuel; 


	  
  public static void displayMenu(SUV mySUV, Sports mySport, DesertTrack aDes, ArcticTrack arcTrack){//prints the cheat menu and asks for user input. this does not work. 
	  System.out.println("CHEAT MENU SELECTION");
	  System.out.println("(0) Toggle debugging messages on/off");
	  System.out.println("(1) Change fuel of sports car");
	  System.out.println("(2) Change fuel of SUV car");
	  System.out.println("(3) Change location of sports car");
	  System.out.println("(4) Change location of SUV car");
	  System.out.println("(5) Make a blizzard on the arctic track");
	  System.out.println("(6) Make a heat wave on the desert track");
	  Scanner in = new Scanner(System.in);
	  cheatChoice = in.nextInt();

	  
	  
  }
  public static void cheatChoice1(){ //changes vlaue for fuel of sports car. this does not work 
	  System.out.println("Set new fuel value (non negative number)");
	  Scanner in = new Scanner(System.in);
	  newSportFuel = in.nextInt();
	  
  }
	  
	  
  }
  




