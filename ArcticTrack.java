import java.util.Random;

public class ArcticTrack extends Track {
	private String trackType;

	
	
		public ArcticTrack(){
			super();
			trackType = ("ARCTIC TRACK");
		}
		
		public void display(){//displays the track
			System.out.println(this.trackType);
			super.display();
		}

		public void setNewPlace(SUV mySUV){// sets the new place and erases the place behind the car, determines when the car reaches the end and wins
			mySUV.setAppearance('V'); 

			int moveForward = mySUV.getDistanceTravelled();
			this.aTrack[0+moveForward]= mySUV;
			if (moveForward>=2){
				this.aTrack[moveForward-2]=null;
				this.aTrack[moveForward-1]=null;
			}
			if (this.aTrack[24]==mySUV){
				Driver.sportWon = false;
				Driver.suvWon = true;
				Driver.setStarter(2); 
			}

		}
		public String getTrackType(){//returns value for the track type
			return trackType; 
		}
		
		public static boolean generateBlizzard(){//10% chance of generating a blizzard 
			Random randomGenerator = new Random(); 
			int randomInt = randomGenerator.nextInt(10)+1;
			if (randomInt==5) {
				return true;
			}
			return false;
			
		}
		
		
		
		
		
}

