import java.util.Arrays;


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
	private static int[] skillScores;
	
	
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
		skillScores = new int[26];
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
		skillScores = inputSkillScores;
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
	public void setSkillScoresAt(int inputSkill, int index){
		skillScores[index] = inputSkill;
	}
	public void setSkillScores(int[] inputSkillScores){
		skillScores = inputSkillScores;
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
	public int[] getSkillScores(){
		return skillScores;
	}

	public int statBonus(int index) {
		return (statScores[index]-10)/2;
	}
	
	public void printAll(){
		System.out.println("Gender:  "+gender+"Class:  "+characterClass+" Description:  "+description+" Race:  "+race+" Name:  "+name+"\n Level:  "+level+" Xp:  "+xp+" Age:  "+age+" HP:  "+hitpoints+"\n Abilities:  ");
		System.out.println(Arrays.toString(statScores));
	
		
	}
}
