package Lemmings.contractTests;

import org.junit.Before;
import org.junit.Test;

import Lemmings.contract.GameEngContract;
import Lemmings.contract.JoueurContract;
import Lemmings.contract.LemmingContract;
import Lemmings.contract.LevelContract;
import Lemmings.error.PreConditionError;
import Lemmings.implementations.GameEngImpl;
import Lemmings.implementations.JoueurImpl;
import Lemmings.implementations.LemmingImpl;
import Lemmings.implementations.LevelImpl;
import Lemmings.tools.Comportement;
import Lemmings.tools.Nature;

public class TestContractLemming extends AbstractLemmingTest {

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

		gameEng = new GameEngImpl(SIZE_COLONY, SPAWN_SPEED, level, joueur);
		gameEng = new GameEngContract(gameEng);
	}

	/**
	 * init -------------------------------------------------------------
	 * @no @param
	 */		
	@Test(expected=PreConditionError.class)
	public void gameEng_init23_() {
		c = null;
		lemming  = new LemmingContract(new LemmingImpl(c, gameEng));
	}
	
	@Test(expected=PreConditionError.class)
	public void gameEng_init24_() {
		c.add(Comportement.DIGGER);
		c.add(Comportement.FALLER);
		lemming  = new LemmingContract(new LemmingImpl(c, gameEng));
	}

	@Test(expected=PreConditionError.class)
	public void gameEng_init25_() {
		c.add(Comportement.DIGGER);
		c.add(Comportement.BUILDER);
		lemming  = new LemmingContract(new LemmingImpl(c, gameEng));
	}
	
	@Test(expected=PreConditionError.class)
	public void gameEng_init26_() {
		c.add(Comportement.WALKER);
		c.add(Comportement.BASHER);
		c.add(Comportement.FALLER);
		lemming  = new LemmingContract(new LemmingImpl(c, gameEng));
	}
	
	@Test(expected=PreConditionError.class)
	public void gameEng_init27_() {
		c.add(Comportement.WALKER);
		c.add(Comportement.BASHER);
		c.add(Comportement.CLIMBER);
		lemming  = new LemmingContract(new LemmingImpl(c, gameEng));
	}
}
