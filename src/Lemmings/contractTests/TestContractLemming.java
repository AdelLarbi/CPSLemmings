package Lemmings.contractTests;

import org.junit.Before;
import org.junit.Test;

import Lemmings.error.PreConditionError;

public class TestContractLemming extends AbstractLemmingTest {

	@Override
	@Before
	public void beforeTesting() {
	}

	/**
	 * init -------------------------------------------------------------
	 * @no @param
	 */		
	@Test(expected=PreConditionError.class)
	public void gameEng_init_() {
//		gameEng  = new GameEngContract(new GameEngImpl(0, 10, level, joueur));
	}
}
