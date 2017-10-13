import javax.swing.JOptionPane;

public class PathfinderCreator {
		
	public static void main(String[] Args){
		
		//create a new character object, and create popup window asking for basic details (Name, Gender, Age, Description)
		nSidedDie universalDie = new nSidedDie();
		playerCharacter characterToCreate = new playerCharacter();
		
		//Starting with class
		characterToCreate.characterClassPrompt();
		
		int confirmChoice = 1;
		while(confirmChoice == 1){
			for (int x = 0; x<6;x++){
				characterToCreate.setStatScoreAt(universalDie.rollFourDropLowest(6),x);
			}
			confirmChoice = JOptionPane.showConfirmDialog(null, "Rolled stats: \nStr:"+characterToCreate.getStatScoresAt(0)+"\n Dex:"+characterToCreate.getStatScoresAt(1)+"\n Con"+characterToCreate.getStatScoresAt(2)+"\n Int"+characterToCreate.getStatScoresAt(3)+"\n Wis:"+characterToCreate.getStatScoresAt(4)+"\n Cha"+characterToCreate.getStatScoresAt(5)+"\n Are these skills acceptable? (Racial bonuses yet to be applied)");
			if(confirmChoice == 2){
				System.exit(0);
			}
		}
		
		//Give user option of races to pick
		characterToCreate.racePrompt();
		
		
		//Allow user to randomize name or write their own
		characterToCreate.namePrompt();
		
		//ask user for gender
		characterToCreate.setGender(JOptionPane.showInputDialog(null,"Enter your gender"));
		//ask user for description
		characterToCreate.setDescription(JOptionPane.showInputDialog("Please enter your characters description"));
		
		//ask for level and age
		characterToCreate.numericValuePrompt();
		
		characterToCreate.printAll();
		
		System.out.println("Exiting");
		System.exit(0);
	}
}
