package Lemmings.contractTests;

import org.junit.Test;

import Lemmings.contract.LevelContract;
import Lemmings.implementations.LevelImpl;

public class TestContractLevelInitCondition extends AbstractLevelInitConditionTest {
	
	/**
	 * Constructor -------------------------------------------------------------
	 * @param width
	 * @param height
	 */	
	
	@Test(expected=NegativeArraySizeException.class)
	public void level_Init_5() {		
		level = new LevelContract(new LevelImpl(-1, 80));
	}
	
	@Test(expected=NegativeArraySizeException.class)
	public void level_Init_6() {
		level = new LevelContract(new LevelImpl(20, -3));
	}
}
