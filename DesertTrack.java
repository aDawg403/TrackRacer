import java.util.Random;

public class DesertTrack extends Track {
	private String trackType;
	
	
		DesertTrack(){
			super(); 
			trackType = ("DESERT TRACK");

		}
		public void display(){//displays the desert track
			System.out.println(this.trackType);
			super.display();
		}
		
		public void setNewPlace(Sports mySport){//sets new location of car and erases old one. Determines when it reaches end of array
			mySport.setAppearance('P'); 

				int moveForward = mySport.getDistanceTravelled();
				this.aTrack[moveForward]= mySport;
				if (moveForward>=3)
				this.aTrack[moveForward-3]=null;
				if (this.aTrack[24]==mySport){
					System.out.println("The sports car has reached the end first!!!! ");
					Driver.setStarter(2); 
				}

				
				}
		public String getTrackType(){//returns the tracktype
			return trackType; 
		}
		
		public static boolean generateHeat(){// 10% chance of generating a heat wave 
			Random randomGenerator = new Random(); 
			int randomInt = randomGenerator.nextInt(10)+1;
			if (randomInt==5)
				return true;
			return false;
			
		}
		
}
		



