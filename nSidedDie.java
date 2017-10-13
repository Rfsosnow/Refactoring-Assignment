import java.util.Random;


public class nSidedDie {
	public Random diceRoller;
	
	public nSidedDie(){
		diceRoller = new Random();
	}
	
	public nSidedDie(long seed){
		diceRoller = new Random(seed);
	}
	
	public int roll(int sides){
		if(sides<1){
			throw new IllegalArgumentException();
		}
		return (diceRoller.nextInt(sides)+1);
	}
	
	public int rollFourDropLowest(int sides){
		int[] rollArray = new int[4];
		int lowestRoll = sides+1;
		int lowestRollLocation = 0;
		for(int x = 0;x<4;x++){
			rollArray[x] = (diceRoller.nextInt(sides)+1);
			if(rollArray[x] < lowestRoll){
				lowestRoll = rollArray[x];
				lowestRollLocation = x;
			}
		}
		rollArray[lowestRollLocation] = 0;
		return sumArray(rollArray);
	}
	
	public static int sumArray(int[] array){
		int returnInt = 0;
		for (int x = 0; x < array.length;x++){
			returnInt += array[x];
		}
		return returnInt;
	}
	 
}
