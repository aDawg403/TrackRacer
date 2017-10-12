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
		int newPosition = mySport.getDistanceTravelled() + 3;
		mySport.performAction(action, gc);
		assertEquals(mySport.getDistanceTravelled(), newPosition); //Assert the position for the sport vehicle has changed
	}
	@Test
	public void testPerformActionSportDebug() {
		GameController gc = new GameController();  
		Sports mySport = new Sports();
		String action = "c";
		Debug.on = false;
		mySport.performAction(action, gc);
		assertEquals(Debug.on, true); //Assert that debug has changed
	}
	
	
	
	//TESTING SUV PERFORM ACTIONS
	@Test
	public void testPerformActionSUVDrive(){
		GameController gc = new GameController();  
		SUV mySUV = new SUV();
		String action = "d";
		int newPosition = mySUV.getDistanceTravelled() + 2;
		mySUV.performAction(action, gc);
		assertEquals(mySUV.getDistanceTravelled(), newPosition); //Assert the position for the sport vehicle has changed
	}
	@Test
	public void testPerformActionSUVAWD(){
		GameController gc = new GameController();  
		SUV mySUV = new SUV();
		String action = "a";
		int newPosition = mySUV.getDistanceTravelled() + 2;
		mySUV.performAction(action, gc);
		assertEquals(mySUV.getDistanceTravelled(), newPosition); //Assert the position for the sport vehicle has changed
	}
	@Test
	public void testPerformActionSUVDebug(){
		GameController gc = new GameController();  
		SUV mySUV = new SUV();
		String action = "c";
		Debug.on = false;
		mySUV.performAction(action, gc);
		assertEquals(Debug.on, true); //Assert that debug has changed
	}
	
	

}
