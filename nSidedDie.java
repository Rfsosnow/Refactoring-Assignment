import java.util.Random;


public class nSidedDie {
	private int sides;
	public Random diceRoller;
	
	public nSidedDie() {
		this(6);		//default to six sided die if no other die given
	}
	
	public nSidedDie(int inputSides){
		if (inputSides < 1){
			throw new IllegalArgumentException("not enough sides");
		} else{
			sides = inputSides;
			diceRoller = new Random();
		}
	}
	
	public nSidedDie(int inputSides, long seed){
		if (inputSides < 1){
			throw new IllegalArgumentException("not enough sides");
		} else{
			sides = inputSides;
			diceRoller = new Random(seed);
		}
	}
	
	public void setSides(int inputSides){
		if (inputSides < 1){
			throw new IllegalArgumentException("not enough sides");
		} else{
			sides = inputSides;
		}
	}
	
	public int getSides(){
		return sides;
	}
	
	public int roll(){
		return (diceRoller.nextInt(sides)+1);
	}
	
}
