package Lemmings.contractTests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Lemmings.services.ILevel;
import Lemmings.tools.Nature;

public abstract class AbstractLevelTest {

	protected ILevel level;
	
	@Before
	public abstract void beforeTesting();
	
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
		
		level.init(x, y);
		
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
	
	/**
	 * setNature ---------------------------------------------------------------
	 */
	@Test
	public void level_setNature_1() {
		testLevelSetNatureWith(0, 0, Nature.DIRT);						 					
	}
	
	@Test
	public void level_setNature_2() {
		testLevelSetNatureWith(0, 0, Nature.METAL);						 					
	}
	
	@Test
	public void level_setNature_3() {
		testLevelSetNatureWith(0, 0, Nature.EMPTY);						 					
	}
	
	@Test
	public void level_setNature_4() {
		testLevelSetNatureWith(99, 78, Nature.DIRT);						 					
	}
	
	@Test
	public void level_setNature_5() {
		testLevelSetNatureWith(99, 78, Nature.METAL);						 					
	}
	
	@Test
	public void level_setNature_6() {
		testLevelSetNatureWith(99, 78, Nature.EMPTY);						 					
	}
	
	@Test
	public void level_setNature_7() {
		testLevelSetNatureWith(50, 50, Nature.DIRT);						 					
	}
	
	@Test
	public void level_setNature_8() {
		testLevelSetNatureWith(50, 50, Nature.METAL);						 					
	}
	
	@Test
	public void level_setNature_9() {
		testLevelSetNatureWith(50, 50, Nature.EMPTY);						 					
	}
	
	private void testLevelSetNatureWith(int x, int y, Nature n) {			
		
		boolean isEditing_atPre = level.isEditing();
		int getXEntrance_atPre = level.getXEntrance();
		int getYEntrance_atPre = level.getYEntrance();
		int getXExit_atPre = level.getXExit();
		int getYExit_atPre = level.getYExit();
		
		level.init(100, 80);
		
		level.setNature(x, y, n);		
				
		Assert.assertTrue("Test Level SetNature : ",
				level.getNature(x, y) == n
			 &&	level.isEditing() == isEditing_atPre
			 && level.getXEntrance() == getXEntrance_atPre
			 && level.getYEntrance() == getYEntrance_atPre
			 && level.getXExit() == getXExit_atPre
			 && level.getYExit() == getYExit_atPre
		);
	}
	
	/**
	 * goPlay ------------------------------------------------------------------
	 */
	@Test
	public void level_getPlay_1() {
		testLevelGoPlayWith(1, 42, 78, 55);						 					
	}

	private void testLevelGoPlayWith(int xEntrance, int yEntrance, int xExit, int yExit) {
		
		level.init(100, 80);
		
		for (int j = 0; j < level.getHeight(); j++) {	
			for (int i = 0; i < level.getWidth(); i++) {
				if (i == 0 || j == level.getHeight() -1 || i == level.getWidth() -1 || j == 0) {
					level.setNature(i, j, Nature.METAL);
				}
			}
		}
		
		level.goEditing();
			
		level.setNature(1, 41, Nature.EMPTY);
		level.setNature(1, 42, Nature.EMPTY);
		level.setNature(1, 43, Nature.EMPTY);
		
		level.setNature(78, 54, Nature.EMPTY);
		level.setNature(78, 55, Nature.EMPTY);
		level.setNature(78, 56, Nature.EMPTY);
		
		level.goPlay(xEntrance, yEntrance, xExit, yExit);
		
		Assert.assertTrue("Test Level GoPlay : ",
				level.getNature(x, y) == n // FIXME
			 &&	level.isEditing() == false
			 && level.getXEntrance() == xEntrance
			 && level.getYEntrance() == yEntrance
			 && level.getXExit() == xEntrance
			 && level.getYExit() == yEntrance
		);
	}
}
