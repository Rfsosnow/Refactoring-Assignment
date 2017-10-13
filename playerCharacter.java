import java.util.Arrays;

import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class playerCharacter {

	private static String gender;
	private static String characterClass;
	private static String description;
	private static String race;
	private static String name;
	
	private static int level;
	private static int xp;
	private static int age;
	private static int hitpoints;
	
	private static int[] statScores;
	
	private final static String[] classes = {"Wizard","Cleric","Rogue","Fighter"};
	private final static String[] races = {"Dwarf","Elf","Gnome","Half-Elf","Half-Orc","Halfling","Human"};
	private final static String[] stats = {"Strength","Dexterity","Constitution","Intelligence","Wisdom","Charisma"};
	private final static String[] nameFragmentStart = {"Letta","Beo","Haru","Gar","Ever","Tom","Bal","Cra","Iop","Lop","Yu","Hill","Gren","Alas","Acer","Win","Win","Corr","Quel","Imo","Plo","Hur","Fran","Brit"};
	private final static String[] nameFragmentEnd = {"fast","wine","phie","ca","wise","ret","dor","red","lin","ray","li","dul","syth","sen","stray","lao","tin","met","ny","gorn","tun","ker","rris","lial","son","seph"};

	/*
	 * DEFAULT AND FULL CONSTRUCTORS
	 */
	public playerCharacter(){	
		gender = "";
		characterClass = "";
		description = "";
		race = "";
		name = "";
		
		
		level = 0;
		xp = 0;
		age = 0;
		hitpoints = 0;
		
		statScores = new int[6];
	}
	
	public playerCharacter(String inputGender, String inputCharacterClass, String inputDescription, String inputRace, String inputName, int inputLevel, int inputXp, int inputAge, int inputHitpoints,int[] inputStatScores,int[] inputSkillScores){
		gender = inputGender;
		characterClass = inputCharacterClass;
		description = inputDescription;
		race = inputRace;
		name = inputName;
		
		level = inputLevel;
		xp = inputXp;
		age = inputAge;
		hitpoints = inputHitpoints;
		
		statScores = inputStatScores;
	}


	/*
	 * SETTER FUNCTIONS
	 */
	
	
	public void setGender(String inputGender){
		gender = inputGender;
	}
	public void setCharacterClass(String inputCharacterClass){
		characterClass = inputCharacterClass;
	}
	public void setDescription(String inputDescription){
		description = inputDescription;
	}
	public void setRace(String inputRace){
		race = inputRace;
	}
	public void setName(String inputName){
		name = inputName;
	}
	public void setLevel(int inputLevel){
		level = inputLevel;
	}
	public void setXp(int inputXp){
		xp = inputXp;
	}
	public void setAge(int inputAge){
		age = inputAge;
	}
	public void setHitpoints(int inputHitpoints){
		hitpoints = inputHitpoints;
	}
	public void setStatScores(int[] inputStatScores){
		statScores = inputStatScores;
	}
	public void setStatScoreAt(int inputStat,int index){
		statScores[index] = inputStat;
	}
	
	/*
	 * GETTER FUNCTIONS
	 */
	
	
	public String getGender(){
		return gender;
	}
	public String getCharacterClass(){
		return characterClass;
	}
	public String getDescription(){
		return description;
	}
	public String getRace(){
		return race;
	}
	public String getName(){
		return name;
	}
	public int getLevel(){
		return level;
	}
	public int getXp(){
		return xp;
	}
	public int getAge(){
		return age;
	}
	public int getHitpoints(){
		return hitpoints;
	}
	public int[] getStatScores(){
		return statScores;
	}
	public int getStatScoresAt(int index){
		return statScores[index];
	}

	public int statBonus(int index) {
		return (statScores[index]-10)/2;
	}
	//Output all values to the console
	public void printAll(){
		System.out.println("Gender:  "+gender+" Class:  "+characterClass+" Description:  "+description+" Race:  "+race+" Name:  "+name+"\n Level:  "+level+" Xp:  "+xp+" Age:  "+age+" HP:  "+hitpoints+"\n Abilities:  ");
		System.out.println(Arrays.toString(statScores));
	}

	public void characterClassPrompt() {
		characterClass = (String)JOptionPane.showInputDialog(null, "Testing","Title",JOptionPane.PLAIN_MESSAGE,null,classes,"Wizard");
	}
	public int getCharacterHitDie(){
		for(int x = 0;x<classes.length;x++){
			if(characterClass == classes[x]){
				return ((x+4)+(x*2));
			}
		}
		return 0;
	}
	//present pop-up with race options,saving choice to race variable and make appropriate edits to the stats for each race
	public void racePrompt() {
		race = (String)JOptionPane.showInputDialog(null,"Choose Race","Choose your race",JOptionPane.PLAIN_MESSAGE,null,races,"Dwarf");
		if(race == "Dwarf"){
			statScores[2] = statScores[2]+2;
			statScores[4] = statScores[4]+2;
			statScores[5] = statScores[5]-2;
		} else if(race == "Elf"){
			statScores[1] = statScores[1]+2;
			statScores[3] = statScores[3]+2;
			statScores[2] = statScores[2]-2;
		} else if(race == "Gnome"){
			statScores[2] = statScores[2]+2;
			statScores[5] = statScores[5]+2;
			statScores[0] = statScores[0]-2;
		} else if(race == "Halfling"){
			statScores[1] = statScores[1]+2;
			statScores[5] = statScores[5]+2;
			statScores[0] = statScores[0]-2;
		} else {
			int statChoice = JOptionPane.showOptionDialog(null, 
					"Select which Ability you would like to increase by two:",
					"Special Race Ability Increase",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null,
					stats,
					stats[0]);
			statScores[statChoice] = statScores[statChoice]+2;
		}
	}
	
	//Present pop-up to user, asking them to either write their own name, or randomize one. Followup pop-up based off
	//their choice, prompting them to type out name or giving them a generated name respectively, and saving them to name variable
	//with loop until they are satisfied with random name
	public void namePrompt() {
		String[] nameOptions = {"Write own name","Randomize name","Exit"};
		int continueRepeatOrCancel;
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
			continueRepeatOrCancel = 1;
			while(continueRepeatOrCancel == 1){
				name = randomName();
				continueRepeatOrCancel = JOptionPane.showConfirmDialog(null, "Your randomized name is:"+name+"\n Is that acceptable?");
				if(continueRepeatOrCancel == 2){
					System.exit(0);
				}
			}
		}else{
	
			name = JOptionPane.showInputDialog(null,"Enter your name:");
			JOptionPane.showMessageDialog(null, "Your name is "+name);
		}		
	}

	//
	//Random name function, simply rolls number from 0 to length of each name fragment section
	//and attach them together, and return
	//
	public String randomName(){
		nSidedDie randomRoll = new nSidedDie();
		String returnName = nameFragmentStart[randomRoll.rollFromOneTo(nameFragmentStart.length)-1];
		returnName = returnName.concat(nameFragmentEnd[randomRoll.rollFromOneTo(nameFragmentEnd.length)-1]);
		return returnName;
	}

	//
	//Ask user to type in two fields, with text describing what each is. Store the values if they are not innapropriate values
	//int level and age respectively, and calculate their HP and XP based off the level they responded with. 
	//
	public void numericValuePrompt() {
		nSidedDie hitPointDie = new nSidedDie();
		JTextField levelField = new JTextField();
		JTextField ageField = new JTextField();
		Object[] fields = {
				"Please enter your level(1-20):",levelField,
				"Please enter  your age:",ageField
		};
		int ageOptionOkCancel = JOptionPane.showConfirmDialog(null, fields, "Age and level entry", JOptionPane.OK_CANCEL_OPTION);
		if (ageOptionOkCancel == 1){
			System.exit(0);
		}else{
			try{
				level = Integer.parseInt(levelField.getText());
				age = (Integer.parseInt(ageField.getText()));
				if (level < 0 || age <0){
					throw new IllegalArgumentException();
				}
			}catch(NumberFormatException e){
				System.err.println("Number Format Exception "+e.getMessage());
				System.exit(0);
			}
			for (int x = 0; x < level;x++){
				hitpoints = hitpoints+hitPointDie.rollFromOneTo(getCharacterHitDie())+statBonus(2);
			}
			xp = level*1000;
		}
		
	}
}
