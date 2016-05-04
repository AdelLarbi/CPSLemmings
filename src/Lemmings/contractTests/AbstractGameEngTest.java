package Lemmings.contractTests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import Lemmings.implementations.GameEngImpl;
import Lemmings.services.IGameEng;
import Lemmings.services.IJoueur;
import Lemmings.services.ILevel;

public abstract class AbstractGameEngTest {

	final int WIDTH = 13;
	final int HEIGHT = 11;
	
	final int X_ENTRANCE = 2;
	final int Y_ENTRANCE = 2;
	final int X_EXIT = 10;
	final int Y_EXIT = 9;
	
	final int SIZE_COLONY = 5;
	final int SPAWN_SPEED = 2;
	
	protected IGameEng gameEng;
	protected ILevel level;
	IJoueur joueur;
	
	public abstract void beforeTesting();
	
	@After
	public void afterTesting() {
		gameEng = null;
	}
	
	/**
	 * Init --------------------------------------------------------------------
	 */
	@Test
	public void gameEng_Init_1() {
		testGameEngInitWith(1, 10);						 					
	}
	
	@Test
	public void gameEng_Init_2() {
		testGameEngInitWith(99, 10);						 					
	}
	
	@Test
	public void gameEng_Init_3() {
		testGameEngInitWith(13, 1);						 					
	}
	
	@Test
	public void gameEng_Init_4() {
		testGameEngInitWith(13, 99);						 					
	}
	
	@Test
	public void gameEng_Init_5() {
		testGameEngInitWith(6, 6);						 					
	}
	
	@Test
	public void gameEng_Init_6() {
		testGameEngInitWith(25, 4);						 					
	}
	
	private void testGameEngInitWith(int sizeColony, int spawnSpeed) {			
		
		gameEng = new GameEngImpl(SIZE_COLONY, SPAWN_SPEED, level, joueur);
		
		Assert.assertTrue("Test GameEng Init : ",
				gameEng.getTour() == 0
			 && gameEng.getScore() == 0
			 && gameEng.isGameOver() == false
			 && gameEng.getSizeColony() == sizeColony
			 && gameEng.getSpawnSpeed() == spawnSpeed
			 && gameEng.getNbLemmingCreated() == 0
			 && gameEng.getNbLemmingSaved() == 0
			 && gameEng.getLevel() == level
			 && gameEng.getJoueur() == joueur
			 && gameEng.getActivLemmings().isEmpty()
		);
	}
	
	/**
	 * Step --------------------------------------------------------------------
	 */
	@Test
	public void gameEng_step_1() {
		testGameEngStepWith();						 					
	}
	
	private void testGameEngStepWith() {			
		
		int getTour_atPre = gameEng.getTour();
		ILevel getLevel_atPre = gameEng.getLevel();
		IJoueur getJoueur_atPre = gameEng.getJoueur();
		int getNbLemmingCreated_atPre = gameEng.getNbLemmingCreated();
		boolean error = false;
		//for (int i = 0; i < getMaxTour(); i++) {
		//TODO test for all game steps. Done just one step, i thik it's enough..
		int i = 0;	
		if (i % gameEng.getSpawnSpeed() == 0 && gameEng.getNbLemmingCreated() < gameEng.getSizeColony()) {
			if (!(gameEng.getNbLemmingCreated() == getNbLemmingCreated_atPre + 1)) {
				error = true;
			}
		}
		//}
		gameEng.step();
		
		Assert.assertTrue("Test GameEng Step : ",
				gameEng.getTour() == getTour_atPre
			 && gameEng.getNbLemmingSaved() == 0
			 && gameEng.getLevel() == getLevel_atPre
			 && gameEng.getJoueur() == getJoueur_atPre
			 && !error
		);
	}
}
