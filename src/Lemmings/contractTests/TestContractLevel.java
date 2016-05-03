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
}
