import static org.junit.Assert.*;

import org.junit.Test;


public class creatorTester {

	@Test
	public void nSidedDieTest() {
		boolean pass = true;
		nSidedDie testDie = new nSidedDie();
		for (int x = 0; x<200;x++){
			int result = testDie.roll(6);
			if (result < 1 || result > 6){
				pass = false;
			}
		}
		assertTrue(pass);
	}
	@Test
	public void nSidedDieNegativeTest() {
		boolean pass = false;
		try{
			nSidedDie testDie = new nSidedDie();
			testDie.roll(-1);
		}catch(IllegalArgumentException e){
			pass = true;
		}
		assertTrue(pass);
	}
	@Test
	public void playerCharacterSetTestRace(){
		playerCharacter testCharacter = new playerCharacter();
		testCharacter.setRace("Test");
		assertEquals(testCharacter.getRace(), "Test");
	}
	@Test
	public void playerCharacterSetTestGender(){
		playerCharacter testCharacter = new playerCharacter();
		testCharacter.setGender("Test");
		assertEquals(testCharacter.getGender(), "Test");
	}
	@Test
	public void playerCharacterSetTestcharacterClass(){
		playerCharacter testCharacter = new playerCharacter();
		testCharacter.setCharacterClass("Test");
		assertEquals(testCharacter.getCharacterClass(), "Test");
	}
	@Test
	public void playerCharacterSetTestDescription(){
		playerCharacter testCharacter = new playerCharacter();
		testCharacter.setDescription("Test");
		assertEquals(testCharacter.getDescription(), "Test");
	}
	@Test
	public void playerCharacterSetTestName(){
		playerCharacter testCharacter = new playerCharacter();
		testCharacter.setName("Test");
		assertEquals(testCharacter.getName(), "Test");
	}
	@Test
	public void playerCharacterSetTestNumericValues(){
		playerCharacter testCharacter = new playerCharacter();
		testCharacter.setAge(22);
		testCharacter.setHitpoints(30);
		testCharacter.setXp(5000);
		testCharacter.setLevel(3);
		assertEquals(testCharacter.getAge(), 22);
		assertEquals(testCharacter.getHitpoints(), 30);
		assertEquals(testCharacter.getXp(), 5000);
		assertEquals(testCharacter.getLevel(), 3);
	}
	
	@Test
	public void sumArrayTest(){
		int[] testArray = {1,2,3,4,5};
		assertEquals(nSidedDie.sumArray(testArray),15);
	}
	@Test
	public void sumArrayTestNegative(){
		int[] testArray = {1,2,-3,4,5};
		assertEquals(nSidedDie.sumArray(testArray),9);
	}
	@Test
	public void rollFourDropLowestTest(){
		boolean pass = true;
		nSidedDie testDie = new nSidedDie();
		for (int x = 0; x<200;x++){
			int result = testDie.rollFourDropLowest(6);
			if (result < 3 || result > 18){
				pass = false;
			}
		}
		assertTrue(pass);
	}
}
