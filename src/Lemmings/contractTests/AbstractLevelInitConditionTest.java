package Lemmings.contractTests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import Lemmings.contract.LevelContract;
import Lemmings.implementations.LevelImpl;
import Lemmings.services.ILevel;
import Lemmings.tools.Nature;

public abstract class AbstractLevelInitConditionTest {

	protected ILevel level;
	
	@After
	public void afterTesting() {
		level = null;
	}
	
	/**
	 * Init --------------------------------------------------------------------
	 */
	@Test
	public void level_Init_1() {
		testLevelInitWith(5, 10);						 					
	}
	
	@Test
	public void level_Init_2() {
		testLevelInitWith(10, 5);						 					
	}
	
	@Test
	public void level_Init_3() {
		testLevelInitWith(999, 999);						 					
	}
	
	@Test
	public void level_Init_4() {
		testLevelInitWith(100, 80);						 					
	}
	
	private void testLevelInitWith(int x, int y) {			
		
		level = new LevelContract(new LevelImpl(x, y));
		
		boolean error = false;
		
		for (int j = 0; j < level.getHeight(); j++) {	
			for (int i = 0; i < level.getWidth(); i++) {
				if (i == 0 || j == level.getHeight() -1 || i == level.getWidth() -1 || j == 0) {
					if (level.getNature(i, j) != Nature.METAL) {
						error = true;
						break;
					}
				} else {  
					if (level.getNature(i, j) != Nature.EMPTY) {
						error = true;
						break;
					}
				}
			}
		}
		
		Assert.assertTrue("Test Level Init : ",
				level.getHeight() ==  y
			 && level.getWidth() ==  x
			 && level.isEditing() ==  true
			 && level.getXEntrance() == -1
			 && level.getYEntrance() == -1
			 && level.getXExit() == -1
			 && level.getYExit() == -1 
			 && !error
		);
	}
}
