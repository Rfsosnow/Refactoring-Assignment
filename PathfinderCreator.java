import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JTextField;




public class PathfinderCreator {
	
	private final String[] skills = {"acrobatics","appraise","bluff","climb","craft","diplomacy","disable device","disguise","escape artist","fly","handle animal","heal","intimidate","knowledge","linguistics","perception","perform","profession","ride","sense motive","sleight of hand","spellcraft","stealth","survival","swim","use magic device"};
	
	private final static String[] randomBeginning = {"Letta","Beo","Haru","Gar","Ever","Tom","Bal","Cra","Iop","Lop","Yu","Hill","Gren","Alas","Acer","Win","Win","Corr","Quel","Imo","Plo","Hur","Fran","Brit"};
	
	private final static String[] randomEnd = {"fast","wine","phie","ca","wise","ret","dor","red","lin","ray","li","dul","syth","sen","stray","lao","tin","met","ny","gorn","tun","ker","rris","lial","son","seph"};

	private final static String[] classes = {"Fighter","Cleric","Rogue","Wizard"};
	
	private final static String[] races = {"Dwarf","Elf","Gnome","Half-Elf","Half-Orc","Halfling","Human"};
	
	private final static String[] stats = {"Strength","Dexterity","Constitution","Intelligence","Wisdom","Charisma"};
	
	private static String characterClass;
	
	/*
	 * 

	 */
	
	public static void main(String[] Args){
		
		
		//create a new character object, and create popup window asking for basic details (Name, Gender, Age, Description)
		
		playerCharacter holder = new playerCharacter();
		
		//Starting with class
		holder.setCharacterClass((String)JOptionPane.showInputDialog(null, "Testing","Title",JOptionPane.PLAIN_MESSAGE,null,classes,"Fighter"));
		String tempClass = holder.getCharacterClass();
		nSidedDie characterHitDie = new nSidedDie();
		switch(tempClass){
		case "Fighter": tempClass = "Fighter";
			characterHitDie.setSides(10);
			break;
		case "Rogue": tempClass = "Rogue";
		 	characterHitDie.setSides(8);
			break;
		case "Cleric": tempClass = "Cleric";
			characterHitDie.setSides(6);
			break;
		case "Wizard": tempClass = "Wizard";
			characterHitDie.setSides(4);
			break;
		}
		
		//create new dice object that will roll out the 6 stats of the player, displaying them in a text box, with prompt to reroll or
		//accept and assign the stats

		nSidedDie sixSided = new nSidedDie(6);
		int confirmChoice = 1;
		while(confirmChoice == 1){
			for (int x = 0; x<6;x++){
				int[] rollHolder = new int[4];
				int min = 7;
				int minLocation = 0;
				for (int y = 0; y<4; y++){
					rollHolder[y] = sixSided.roll();
					if (rollHolder[y] < min){
						min = rollHolder[y];
						minLocation = y;
					}
				}
				rollHolder[minLocation] = 0;
				holder.setStatScoreAt(sumArray(rollHolder),x);
			}
			confirmChoice = JOptionPane.showConfirmDialog(null, "Rolled stats: \nStr:"+holder.getStatScoresAt(0)+"\n Dex:"+holder.getStatScoresAt(1)+"\n Con"+holder.getStatScoresAt(2)+"\n Int"+holder.getStatScoresAt(3)+"\n Wis:"+holder.getStatScoresAt(4)+"\n Cha"+holder.getStatScoresAt(5)+"\n Are these skills acceptable? (Racial bonuses yet to be applied)");
			if(confirmChoice == 2){
				System.exit(0);
			}
		}
		
		//Give user option of races to pick
		holder.setRace((String)JOptionPane.showInputDialog(null,"Choose Race","Choose your race",JOptionPane.PLAIN_MESSAGE,null,races,"Dwarf"));
		String tempRace = holder.getRace();
		int statChoice;
		switch(tempRace){
		case "Dwarf": tempRace = "Dwarf";
			holder.setStatScoreAt(holder.getStatScoresAt(2)+2,2);					///FIX THIS
			holder.setStatScoreAt(holder.getStatScoresAt(4)+2,4);
			holder.setStatScoreAt(holder.getStatScoresAt(5)-2,5);
			break;
		case "Elf": tempRace = "Elf";
			holder.setStatScoreAt(holder.getStatScoresAt(1)+2,1);					
			holder.setStatScoreAt(holder.getStatScoresAt(3)+2,3);
			holder.setStatScoreAt(holder.getStatScoresAt(2)-2,2);
			break;
		case "Gnome": tempRace = "Gnome";
			holder.setStatScoreAt(holder.getStatScoresAt(2)+2,2);					
			holder.setStatScoreAt(holder.getStatScoresAt(5)+2,5);
			holder.setStatScoreAt(holder.getStatScoresAt(0)-2,0);
			break;
		case "Half-Elf": tempRace= "Half-Elf";
			statChoice = JOptionPane.showOptionDialog(null, 
					"Select which Ability you would like to increase by two:",
					"Special Race Ability Increase",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null,
					stats,
					stats[0]);
			holder.setStatScoreAt(holder.getStatScoresAt(statChoice)+2, statChoice);
			break;
		case "Half-Orc": tempRace = "Half-Orc";
			statChoice = JOptionPane.showOptionDialog(null, 
					"Select which Ability you would like to increase by two:",
					"Special Race Ability Increase",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null,
					stats,
					stats[0]);
			holder.setStatScoreAt(holder.getStatScoresAt(statChoice)+2, statChoice);
			break;
		case "Halfling": tempRace = "Halfling";
			holder.setStatScoreAt(holder.getStatScoresAt(1)+2,1);					
			holder.setStatScoreAt(holder.getStatScoresAt(5)+2,5);
			holder.setStatScoreAt(holder.getStatScoresAt(0)-2,0);
			break;
		case "Human": tempRace = "Human";
			statChoice = JOptionPane.showOptionDialog(null, 
						"Select which Ability you would like to increase by two:",
						"Special Race Ability Increase",
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null,
						stats,
						stats[0]);
				holder.setStatScoreAt(holder.getStatScoresAt(statChoice)+2, statChoice);
				break;
		}
		
		
		//Allow user to randomize name or write their own
		String[] options = {"Write own name","Randomize name","Exit"};

		int nameChoice = JOptionPane.showOptionDialog(null, 
				"Would you like to write your own name?",
				"Character Name Choice",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				options,
				options[0]);
		if(nameChoice == 2){
			System.exit(0);
		}else if(nameChoice == 1){
			confirmChoice = 1;
			while(confirmChoice == 1){
				nSidedDie randomizeName = new nSidedDie(randomBeginning.length);
				String randomName;
				randomName = randomBeginning[randomizeName.roll()-1];
				randomizeName.setSides(randomEnd.length);
				randomName = randomName.concat(randomEnd[randomizeName.roll()-1]);
				confirmChoice = JOptionPane.showConfirmDialog(null, "Your randomized name is:"+randomName);
				if(confirmChoice == 2){
					System.exit(0);
				}
				holder.setName(randomName);
			}
		}else{
	
			holder.setName(JOptionPane.showInputDialog(null,"Enter your name"));
			JOptionPane.showMessageDialog(null, "Your name is "+holder.getName());
		}
		
		//ask user for gender
		holder.setGender(JOptionPane.showInputDialog(null,"Enter your gender"));
		//ask user for description
		holder.setDescription(JOptionPane.showInputDialog("Please enter your characters description"));
		
		//ask for level and age
		
		JTextField levelField = new JTextField();
		JTextField ageField = new JTextField();
		Object[] fields = {
				"Please enter your level(1-20):",levelField,
				"Please enter  your age:",ageField
		};
		int ageOption = JOptionPane.showConfirmDialog(null, fields, "Age and level entry", JOptionPane.OK_CANCEL_OPTION);
		if (ageOption == 1){
			System.exit(0);
		}else{
			try{
				holder.setLevel(Integer.parseInt(levelField.getText()));
				holder.setAge(Integer.parseInt(ageField.getText()));
			}catch(NumberFormatException e){
				System.err.println("Number Format Exception "+e.getMessage());
			}
			for (int x = 0; x < holder.getLevel();x++){
				holder.setHitpoints(holder.getHitpoints()+characterHitDie.roll()+holder.statBonus(2));
			}
		}
		
		holder.printAll();
		
		System.out.println("Exiting");
		System.exit(0);
	}
	
	
	public static int sumArray(int[] array){
		int returnInt = 0;
		for (int x = 0; x < array.length;x++){
			returnInt += array[x];
		}
		return returnInt;
	}
	 
	
	 
	
	
}
