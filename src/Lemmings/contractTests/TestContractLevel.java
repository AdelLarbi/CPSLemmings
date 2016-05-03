package Lemmings.contractTests;

import org.junit.Before;
import org.junit.Test;

import Lemmings.contract.LevelContract;
import Lemmings.error.PreConditionError;
import Lemmings.implementations.LevelImpl;
import Lemmings.tools.Nature;

public class TestContractLevel extends AbstractLevelTest {

	@Override
	@Before
	public void beforeTesting() {
		level = new LevelContract(new LevelImpl(100, 80));		
	}

	/**
	 * Init --------------------------------------------------------------------
	 * @param width
	 * @param height
	 */	
	@Test(expected=PreConditionError.class)
	public void level_Init_5() {						
		level.init(4, 80);		
	}
	
	@Test(expected=PreConditionError.class)
	public void level_Init_6() {						
		level.init(20, 4);		
	}
	
	@Test(expected=PreConditionError.class)
	public void level_Init_7() {						
		level.init(-1, 80);		
	}
	
	@Test(expected=PreConditionError.class)
	public void level_Init_8() {						
		level.init(20, -3);		
	}
	
	/**
	 * setNature ---------------------------------------------------------------
	 * @param x
	 * @param y
	 * @param nature
	 */	
	@Test(expected=PreConditionError.class)
	public void level_SetNature_10() {						
		level.setNature(-1, 50, Nature.DIRT);	
	}
	
	@Test(expected=PreConditionError.class)
	public void level_SetNature_11() {						
		level.setNature(50, -1, Nature.DIRT);	
	}
	
	@Test(expected=PreConditionError.class)
	public void level_SetNature_12() {						
		level.setNature(-99, 50, Nature.DIRT);	
	}
	
	@Test(expected=PreConditionError.class)
	public void level_SetNature_13() {						
		level.setNature(50, -99, Nature.DIRT);	
	}
	
	@Test(expected=PreConditionError.class)
	public void level_SetNature_14() {						
		level.setNature(100, 50, Nature.DIRT);	
	}
	
	@Test(expected=PreConditionError.class)
	public void level_SetNature_15() {						
		level.setNature(50, 80, Nature.DIRT);	
	}
	
	@Test(expected=PreConditionError.class)
	public void level_SetNature_16() {						
		level.setNature(999, 50, Nature.DIRT);	
	}
	
	@Test(expected=PreConditionError.class)
	public void level_SetNature_17() {						
		level.setNature(50, 999, Nature.DIRT);	
	}
	
	@Test(expected=PreConditionError.class)
	public void level_SetNature_18() {						
		level.setNature(-1, 50, Nature.METAL);	
	}
	
	@Test(expected=PreConditionError.class)
	public void level_SetNature_19() {						
		level.setNature(50, -1, Nature.METAL);	
	}
	
	@Test(expected=PreConditionError.class)
	public void level_SetNature_20() {						
		level.setNature(-99, 50, Nature.METAL);	
	}
	
	@Test(expected=PreConditionError.class)
	public void level_SetNature_21() {						
		level.setNature(50, -99, Nature.METAL);	
	}
	
	@Test(expected=PreConditionError.class)
	public void level_SetNature_22() {						
		level.setNature(100, 50, Nature.METAL);	
	}
	
	@Test(expected=PreConditionError.class)
	public void level_SetNature_23() {						
		level.setNature(50, 80, Nature.METAL);	
	}
	
	@Test(expected=PreConditionError.class)
	public void level_SetNature_24() {						
		level.setNature(999, 50, Nature.METAL);	
	}
	
	@Test(expected=PreConditionError.class)
	public void level_SetNature_25() {						
		level.setNature(50, 999, Nature.METAL);	
	}
	
	
	/**
	 * setNature ---------------------------------------------------------------
	 * @param xEntrance
	 * @param yEntrance
	 * @param xExit
	 * @param yExit
	 */	
	@Test(expected=PreConditionError.class)
	public void level_getPlay_16() {
		prepareGoPlayTest(Nature.DIRT);
		level.goPlay(8, 11, 91, 77);	
	}
	
	@Test(expected=PreConditionError.class)
	public void level_getPlay_17() {
		prepareGoPlayTest(Nature.METAL);
		level.goPlay(8, 11, 91, 77);
		level.goPlay(8, 11, 91, 77);
	}
	
	@Test(expected=PreConditionError.class)
	public void level_getPlay_18() {
		prepareGoPlayTest(Nature.METAL);
		level.goPlay(0, 11, 91, 77);
	}
	
	@Test(expected=PreConditionError.class)
	public void level_getPlay_19() {
		prepareGoPlayTest(Nature.METAL);
		level.goPlay(99, 11, 91, 77);
	}
	
	@Test(expected=PreConditionError.class)
	public void level_getPlay_20() {
		prepareGoPlayTest(Nature.METAL);
		level.goPlay(8, 0, 91, 77);
	}
	
	@Test(expected=PreConditionError.class)
	public void level_getPlay_21() {
		prepareGoPlayTest(Nature.METAL);
		level.goPlay(8, 79, 91, 77);
	}
	
	@Test(expected=PreConditionError.class)
	public void level_getPlay_22() {
		prepareGoPlayTest(Nature.METAL);
		level.goPlay(8, 11, 0, 77);
	}
	
	@Test(expected=PreConditionError.class)
	public void level_getPlay_23() {
		prepareGoPlayTest(Nature.METAL);
		level.goPlay(8, 79, 91, 77);
	}
	
	@Test(expected=PreConditionError.class)
	public void level_getPlay_24() {
		prepareGoPlayTest(Nature.METAL);
		level.goPlay(8, 11, 91, 0);
	}
	
	@Test(expected=PreConditionError.class)
	public void level_getPlay_25() {
		prepareGoPlayTest(Nature.METAL);
		level.goPlay(8, 11, 91, 79);
	}
	
	@Test(expected=PreConditionError.class)
	public void level_getPlay_26() {
		prepareGoPlayTest(Nature.METAL);
		level.goPlay(8, 11, 8, 11);
	}
	
	@Test(expected=PreConditionError.class)
	public void level_getPlay_27() {
		prepareGoPlayTest(Nature.METAL);
		level.setNature(8,10,Nature.DIRT);
		level.goPlay(8, 11, 91, 77);
	}
	
	@Test(expected=PreConditionError.class)
	public void level_getPlay_28() {
		prepareGoPlayTest(Nature.METAL);
		level.setNature(8,11,Nature.DIRT);
		level.goPlay(8, 11, 91, 77);
	}
	
	@Test(expected=PreConditionError.class)
	public void level_getPlay_29() {
		prepareGoPlayTest(Nature.METAL);
		level.setNature(8,12,Nature.DIRT);
		level.goPlay(8, 11, 91, 77);
	}
	
	@Test(expected=PreConditionError.class)
	public void level_getPlay_30() {
		prepareGoPlayTest(Nature.METAL);
		level.setNature(91,76,Nature.DIRT);
		level.goPlay(8, 11, 91, 77);
	}
	
	@Test(expected=PreConditionError.class)
	public void level_getPlay_31() {
		prepareGoPlayTest(Nature.METAL);
		level.setNature(91,77,Nature.DIRT);
		level.goPlay(8, 11, 91, 77);
	}
	
	@Test(expected=PreConditionError.class)
	public void level_getPlay_32() {
		prepareGoPlayTest(Nature.METAL);
		level.setNature(91,78,Nature.DIRT);
		level.goPlay(8, 11, 91, 77);
	}
	
	private void prepareGoPlayTest(Nature nature) {
		
		level.init(100, 80);
		
		for (int j = 0; j < level.getHeight(); j++) {	
			for (int i = 0; i < level.getWidth(); i++) {
				if (i == 0 || j == level.getHeight() -1 || i == level.getWidth() -1 || j == 0) {
					level.setNature(i, j, nature);
				}
			}
		}
		
		level.goEditing();
		
		level.setNature(8, 10, Nature.EMPTY);
		level.setNature(8, 11, Nature.EMPTY);
		level.setNature(8, 12, Nature.EMPTY);
		
		level.setNature(91, 76, Nature.METAL);
		level.setNature(91, 77, Nature.EMPTY);
		level.setNature(91, 78, Nature.EMPTY);
	}
	
	/**
	 * goEditing ---------------------------------------------------------------
	 * @no @param
	 */	
	@Test(expected=PreConditionError.class)
	public void level_getEditing_2() {
		level.goEditing();
		level.goEditing();	
	}
}
