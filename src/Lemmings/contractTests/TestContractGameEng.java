package Lemmings.contractTests;

import org.junit.Before;
import org.junit.Test;

import Lemmings.contract.GameEngContract;
import Lemmings.contract.JoueurContract;
import Lemmings.contract.LevelContract;
import Lemmings.error.PreConditionError;
import Lemmings.implementations.GameEngImpl;
import Lemmings.implementations.JoueurImpl;
import Lemmings.implementations.LevelImpl;
import Lemmings.tools.Nature;

public class TestContractGameEng extends AbstractGameEngTest {
	
	@Override
	@Before
	public void beforeTesting() {
		
		level = new LevelImpl(WIDTH, HEIGHT);
		level = new LevelContract(level);
		
		if (level.isEditing()) {
			level.setNature(1, 4, Nature.METAL);
			level.setNature(2, 4, Nature.METAL);
			level.setNature(3, 4, Nature.METAL);
			level.setNature(4, 4, Nature.METAL);
			level.setNature(5, 4, Nature.METAL);
			level.setNature(6, 4, Nature.METAL);
			level.setNature(7, 4, Nature.METAL);
			level.setNature(8, 4, Nature.METAL);
			level.setNature(9, 4, Nature.METAL);
			level.setNature(10, 4, Nature.METAL);
			
			level.setNature(2, 7, Nature.METAL);
			level.setNature(3, 7, Nature.METAL);
			level.setNature(4, 7, Nature.METAL);
			level.setNature(5, 7, Nature.METAL);
			level.setNature(6, 7, Nature.METAL);
			level.setNature(7, 7, Nature.METAL);
			level.setNature(8, 7, Nature.METAL);
			level.setNature(9, 7, Nature.METAL);
			level.setNature(10, 7, Nature.METAL);
			level.setNature(11, 7, Nature.METAL);
		}
		
		level.goPlay(X_ENTRANCE, Y_ENTRANCE, X_EXIT, Y_EXIT);
		
		joueur  = new JoueurImpl("PlayerLambda", 8);
		joueur = new JoueurContract(joueur);
	}
	
	/**
	 * init -------------------------------------------------------------
	 * @no @param
	 */		
	@Test(expected=NegativeArraySizeException.class)
	public void gameEng_init_7() {
		gameEng  = new GameEngContract(new GameEngImpl(-1, 10, level, joueur));
	}
	
	@Test(expected=NegativeArraySizeException.class)
	public void gameEng_init_8() {
		gameEng  = new GameEngContract(new GameEngImpl(6, -2, level, joueur));
	}
	
	@Test(expected=PreConditionError.class)
	public void gameEng_init_9() {
		gameEng  = new GameEngContract(new GameEngImpl(0, 10, level, joueur));
	}
	
	@Test(expected=PreConditionError.class)
	public void gameEng_init_10() {
		gameEng  = new GameEngContract(new GameEngImpl(24, 0, level, joueur));
	}
	
	/**
	 * step -------------------------------------------------------------
	 * @no @param
	 */		
	@Test(expected=PreConditionError.class)
	public void gameEng_step_2() {
		gameEng = new GameEngImpl(SIZE_COLONY, SPAWN_SPEED, level, joueur);
		gameEng.step();
	}
	
}
