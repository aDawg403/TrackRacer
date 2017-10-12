import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class testCases {
	
	//TESTING SPORT PERFORM ACTIONS	 
	@Test
	public void testPerformActionSportDrive() {
		GameController gc = new GameController();  
		Sports mySport = new Sports();
		String action = "d";
		int newPosition = gc.sportsUserInput + 3;
		gc.performActionSport(action, mySport);
		assertEquals(gc.sportsUserInput, newPosition); //Assert the position for the sport vehicle has changed
	}
	@Test
	public void testPerformActionSportDebug() {
		GameController gc = new GameController();  
		Sports mySport = new Sports();
		String action = "c";
		Debug.on = false;
		gc.performActionSport(action, mySport);
		assertEquals(Debug.on, true); //Assert that debug has changed
	}
	
	
	
	//TESTING SUV PERFORM ACTIONS
	@Test
	public void testPerformActionSUVDrive(){
		GameController gc = new GameController();  
		SUV mySUV = new SUV();
		String action = "d";
		int newPosition = gc.suvUserInput + 2;
		gc.performActionSUV(action, mySUV);
		assertEquals(gc.suvUserInput, newPosition); //Assert the position for the sport vehicle has changed
	}
	@Test
	public void testPerformActionSUVAWD(){
		GameController gc = new GameController();  
		SUV mySUV = new SUV();
		String action = "a";
		int newPosition = gc.suvUserInput + 2;
		gc.performActionSUV(action, mySUV);
		assertEquals(gc.suvUserInput, newPosition); //Assert the position for the sport vehicle has changed
	}
	@Test
	public void testPerformActionSUVDebug(){
		GameController gc = new GameController();  
		SUV mySUV = new SUV();
		String action = "c";
		Debug.on = false;
		gc.performActionSUV(action, mySUV);
		assertEquals(Debug.on, true); //Assert that debug has changed
	}
	
	

}
