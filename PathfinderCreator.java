import javax.swing.JOptionPane;
import javax.swing.JTextField;




public class PathfinderCreator {
		
	private final static String[] randomBeginning = {"Letta","Beo","Haru","Gar","Ever","Tom","Bal","Cra","Iop","Lop","Yu","Hill","Gren","Alas","Acer","Win","Win","Corr","Quel","Imo","Plo","Hur","Fran","Brit"};
	
	private final static String[] randomEnd = {"fast","wine","phie","ca","wise","ret","dor","red","lin","ray","li","dul","syth","sen","stray","lao","tin","met","ny","gorn","tun","ker","rris","lial","son","seph"};

	
	

	
	
	public static void main(String[] Args){
		
		
		//create a new character object, and create popup window asking for basic details (Name, Gender, Age, Description)
		nSidedDie universalDie = new nSidedDie();
		playerCharacter characterToCreate = new playerCharacter();
		
		//Starting with class
		characterToCreate.characterClassPrompt();
		int characterHitDieSides = characterToCreate.getCharacterHitDie();
		
		
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
		String[] nameOptions = {"Write own name","Randomize name","Exit"};

		int nameChoice = JOptionPane.showOptionDialog(null, 
				"Would you like to write your own name?",
				"Character Name Choice",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				nameOptions,
				nameOptions[0]);
		if(nameChoice == 2){
			System.exit(0);
		}else if(nameChoice == 1){
			confirmChoice = 1;
			while(confirmChoice == 1){
				String randomName;
				randomName = randomBeginning[universalDie.roll(randomBeginning.length)-1];
				randomName = randomName.concat(randomEnd[universalDie.roll(randomEnd.length)-1]);
				confirmChoice = JOptionPane.showConfirmDialog(null, "Your randomized name is:"+randomName);
				if(confirmChoice == 2){
					System.exit(0);
				}
				characterToCreate.setName(randomName);
			}
		}else{
	
			characterToCreate.setName(JOptionPane.showInputDialog(null,"Enter your name"));
			JOptionPane.showMessageDialog(null, "Your name is "+characterToCreate.getName());
		}
		
		//ask user for gender
		characterToCreate.setGender(JOptionPane.showInputDialog(null,"Enter your gender"));
		//ask user for description
		characterToCreate.setDescription(JOptionPane.showInputDialog("Please enter your characters description"));
		
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
				characterToCreate.setLevel(Integer.parseInt(levelField.getText()));
				characterToCreate.setAge(Integer.parseInt(ageField.getText()));
			}catch(NumberFormatException e){
				System.err.println("Number Format Exception "+e.getMessage());
			}
			for (int x = 0; x < characterToCreate.getLevel();x++){
				characterToCreate.setHitpoints(characterToCreate.getHitpoints()+universalDie.roll(characterHitDieSides)+characterToCreate.statBonus(2));
			}
		}
		
		characterToCreate.printAll();
		
		System.out.println("Exiting");
		System.exit(0);
	}
	

	
	 
	
	
}
