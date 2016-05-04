package Lemmings.contractTests;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import Lemmings.implementations.LemmingImpl;
import Lemmings.services.IGameEng;
import Lemmings.services.IJoueur;
import Lemmings.services.ILemming;
import Lemmings.services.ILevel;
import Lemmings.tools.Comportement;
import Lemmings.tools.Nature;

public abstract class AbstractLemmingTest {

	final int WIDTH = 13;
	final int HEIGHT = 11;

	final int X_ENTRANCE = 2;
	final int Y_ENTRANCE = 2;
	final int X_EXIT = 10;
	final int Y_EXIT = 9;

	final int SIZE_COLONY = 5;
	final int SPAWN_SPEED = 2;

	protected IGameEng gameEng;
	ILevel level;
	IJoueur joueur;
	protected ILemming lemming;

	protected ArrayList<Comportement> c = new ArrayList<Comportement>();
	
	public abstract void beforeTesting();

	@After
	public void afterTesting() {
		lemming = null;
	}


	/**
	 * Init --------------------------------------------------------------------
	 */
	@Test
	public void lemming_Init_1() {
		c.add(Comportement.WALKER);
		testLemmingInitWith(c);						 					
	}

	@Test
	public void lemming_Init_2() {
		c.add(Comportement.FALLER);
		testLemmingInitWith(c);
	}
	
	@Test
	public void lemming_Init_3() {
		c.add(Comportement.DIGGER);
		testLemmingInitWith(c);
	}
	
	@Test
	public void lemming_Init_4() {
		c.add(Comportement.CLIMBER);
		testLemmingInitWith(c);
	}
	
	@Test
	public void lemming_Init_5() {
		c.add(Comportement.BUILDER);
		testLemmingInitWith(c);
	}
	
	@Test
	public void lemming_Init_6() {
		c.add(Comportement.FLOATER);
		testLemmingInitWith(c);
	}
	
	@Test
	public void lemming_Init_7() {
		c.add(Comportement.BOMBER);
		testLemmingInitWith(c);
	}
	
	@Test
	public void lemming_Init_8() {
		c.add(Comportement.STOPPER);
		testLemmingInitWith(c);
	}
	
	@Test
	public void lemming_Init_9() {
		c.add(Comportement.BASHER);
		testLemmingInitWith(c);
	}
	
	@Test
	public void lemming_Init_10() {
		c.add(Comportement.WALKER);
		c.add(Comportement.DIGGER);
		testLemmingInitWith(c);
	}
	
	@Test
	public void lemming_Init_11() {
		c.add(Comportement.WALKER);
		c.add(Comportement.CLIMBER);
		testLemmingInitWith(c);
	}
	
	@Test
	public void lemming_Init_12() {
		c.add(Comportement.WALKER);
		c.add(Comportement.FLOATER);
		testLemmingInitWith(c);
	}
	
	@Test
	public void lemming_Init_13() {
		c.add(Comportement.BUILDER);
		c.add(Comportement.CLIMBER);
		testLemmingInitWith(c);
	}
	
	@Test
	public void lemming_Init_14() {
		c.add(Comportement.DIGGER);
		c.add(Comportement.FLOATER);
		testLemmingInitWith(c);
	}
	
	@Test
	public void lemming_Init_15() {
		c.add(Comportement.BASHER);
		c.add(Comportement.FLOATER);
		testLemmingInitWith(c);
	}
	
	@Test
	public void lemming_Init_16() {
		c.add(Comportement.WALKER);
		c.add(Comportement.CLIMBER);
		c.add(Comportement.FLOATER);
		testLemmingInitWith(c);
	}
	
	@Test
	public void lemming_Init_17() {
		c.add(Comportement.BOMBER);
		c.add(Comportement.CLIMBER);
		c.add(Comportement.FLOATER);
		testLemmingInitWith(c);
	}
	
	@Test
	public void lemming_Init_18() {
		c.add(Comportement.BOMBER);
		c.add(Comportement.CLIMBER);
		c.add(Comportement.FALLER);
		testLemmingInitWith(c);
	}
	
	@Test
	public void lemming_Init_19() {
		c.add(Comportement.DIGGER);
		c.add(Comportement.CLIMBER);
		c.add(Comportement.FLOATER);
		c.add(Comportement.BOMBER);
		testLemmingInitWith(c);
	}
	
	@Test
	public void lemming_Init_20() {
		c.add(Comportement.STOPPER);
		c.add(Comportement.FLOATER);
		c.add(Comportement.BOMBER);
		testLemmingInitWith(c);
	}
	
	@Test
	public void lemming_Init_21() {
		c.add(Comportement.WALKER);
		c.add(Comportement.FLOATER);
		c.add(Comportement.CLIMBER);
		c.add(Comportement.BOMBER);
		testLemmingInitWith(c);
	}


	private void testLemmingInitWith(ArrayList<Comportement> c) {			

		lemming = new LemmingImpl(c, gameEng);

		Assert.assertTrue("Test GameEng Init : ",
				lemming.isDroitier() == true
				&& lemming.getComportement().contains(c)
				&& lemming.getX() == level.getXEntrance()
				&& lemming.getY() == level.getYEntrance()
				&& lemming.getFalling() == 0
				&& lemming.getGameEng() == gameEng
				&& lemming.isDead() == false
				&& lemming.isSaved() == false
				&& lemming.getDalles() == 0
				&& lemming.getBuilderDelay() == 0
				&& lemming.getBomberDelay() == 5
				&& lemming.getBasherDelay() == 20
				);
	}

	/**
	 * Step --------------------------------------------------------------------
	 */
	@Test
	public void lemming_Step_1() {
		c.add(Comportement.WALKER);
		testLemmingStepWith(c);						 					
	}

	@Test
	public void lemming_Step_2() {
		c.add(Comportement.FALLER);
		testLemmingStepWith(c);
	}
	
	@Test
	public void lemming_Step_3() {
		c.add(Comportement.DIGGER);
		testLemmingStepWith(c);
	}
	
	@Test
	public void lemming_Step_4() {
		c.add(Comportement.CLIMBER);
		testLemmingStepWith(c);
	}
	
	@Test
	public void lemming_Step_5() {
		c.add(Comportement.BUILDER);
		testLemmingStepWith(c);
	}
	
	@Test
	public void lemming_Step_6() {
		c.add(Comportement.FLOATER);
		testLemmingStepWith(c);
	}
	
	@Test
	public void lemming_Step_7() {
		c.add(Comportement.BOMBER);
		testLemmingStepWith(c);
	}
	
	@Test
	public void lemming_Step_8() {
		c.add(Comportement.STOPPER);
		testLemmingStepWith(c);
	}
	
	@Test
	public void lemming_Step_9() {
		c.add(Comportement.BASHER);
		testLemmingStepWith(c);
	}
	
	@Test
	public void lemming_Step_10() {
		c.add(Comportement.WALKER);
		c.add(Comportement.BOMBER);
		testLemmingStepWith(c);
	}
	
	@Test
	public void lemming_Step_11() {
		c.add(Comportement.WALKER);
		c.add(Comportement.CLIMBER);
		testLemmingStepWith(c);
	}
	
	@Test
	public void lemming_Step_12() {
		c.add(Comportement.WALKER);
		c.add(Comportement.FLOATER);
		testLemmingStepWith(c);
	}
	
	@Test
	public void lemming_Step_13() {
		c.add(Comportement.BUILDER);
		c.add(Comportement.CLIMBER);
		testLemmingStepWith(c);
	}
	
	@Test
	public void lemming_Step_14() {
		c.add(Comportement.DIGGER);
		c.add(Comportement.FLOATER);
		testLemmingStepWith(c);
	}
	
	@Test
	public void lemming_Step_15() {
		c.add(Comportement.BASHER);
		c.add(Comportement.FLOATER);
		testLemmingStepWith(c);
	}
	
	@Test
	public void lemming_Step_16() {
		c.add(Comportement.WALKER);
		c.add(Comportement.CLIMBER);
		c.add(Comportement.FLOATER);
		testLemmingStepWith(c);
	}
	
	@Test
	public void lemming_Step_17() {
		c.add(Comportement.BOMBER);
		c.add(Comportement.CLIMBER);
		c.add(Comportement.FLOATER);
		testLemmingStepWith(c);
	}
	
	@Test
	public void lemming_Step_18() {
		c.add(Comportement.BOMBER);
		c.add(Comportement.CLIMBER);
		c.add(Comportement.FALLER);
		testLemmingStepWith(c);
	}
	
	@Test
	public void lemming_Step_19() {
		c.add(Comportement.CLIMBER);
		c.add(Comportement.FLOATER);
		c.add(Comportement.BOMBER);
		testLemmingStepWith(c);
	}
	
	@Test
	public void lemming_Step_20() {
		c.add(Comportement.STOPPER);
		c.add(Comportement.FLOATER);
		c.add(Comportement.BOMBER);
		testLemmingStepWith(c);
	}
	
	@Test
	public void lemming_Step_21() {
		c.add(Comportement.WALKER);
		c.add(Comportement.FLOATER);
		c.add(Comportement.CLIMBER);
		c.add(Comportement.BOMBER);
		testLemmingStepWith(c);
	}

	private void testLemmingStepWith(ArrayList<Comportement> c) {			

		lemming = new LemmingImpl(c, gameEng);


		Assert.assertTrue("Test GameEng Init : ",
				lemming.isDroitier() == true
				&& lemming.getComportement().contains(c)
				&& lemming.getX() == level.getXEntrance()
				&& lemming.getY() == level.getYEntrance()
				&& lemming.getFalling() == 0
				&& lemming.getGameEng() == gameEng
				&& lemming.isDead() == false
				&& lemming.isSaved() == false
				&& lemming.getDalles() == 0
				&& lemming.getBuilderDelay() == 0
				&& lemming.getBomberDelay() == 5
				&& lemming.getBasherDelay() == 20
				);

		int getX_atPre = lemming.getX();
		int getY_atPre = lemming.getY();
		boolean isDroitier_atPre = lemming.isDroitier();
		int falling_atPre = lemming.getFalling();
		int xExit = level.getXExit();
		int yExit = level.getYExit();

		if (lemming.getComportement().contains(Comportement.DIGGER) 
				&& level.getNature(lemming.getX(), lemming.getY() + 1) == Nature.EMPTY) {

			Assert.assertTrue("Test GameEng Init : ",
					lemming.getX() == getX_atPre
					&& lemming.getY() == getY_atPre
					&& lemming.getFalling() == 0
					);

		} else if (lemming.getComportement().contains(Comportement.DIGGER)
				&& level.getNature(lemming.getX(), lemming.getY() + 1) == Nature.METAL) {

			Assert.assertTrue("Test GameEng Init : ",
					lemming.getX() == getX_atPre
					&& lemming.getY() == getY_atPre
					&& lemming.getFalling() == 0
					);

		} else if (lemming.getComportement().contains(Comportement.DIGGER)
				&& level.getNature(lemming.getX(), lemming.getY() + 1) == Nature.DIRT) {

			Assert.assertTrue("Test GameEng Init : ",
					lemming.getX() == getX_atPre
					&& lemming.getY() == getY_atPre+1
					&& lemming.getFalling() == 0
					);

		} else if (lemming.getComportement().contains(Comportement.FALLER) && !lemming.getComportement().contains(Comportement.CLIMBER)
				&& (gameEng.isObstacle(lemming.getX(), lemming.getY() + 1) && falling_atPre >= 8)) {

			Assert.assertTrue("Test GameEng Init : ",
					lemming.isDead() == true
					);

		} else if (lemming.getX() == xExit && lemming.getY() == yExit) {
			Assert.assertTrue("Test GameEng Init : ",
					lemming.isSaved() == true
					);
		} else if (lemming.getComportement().contains(Comportement.WALKER)
				&& !(gameEng.isObstacle(lemming.getX(), lemming.getY() + 1))) {

			Assert.assertTrue("Test GameEng Init : ",
					lemming.getX() == getX_atPre
					&& lemming.getY() == getY_atPre
					&& lemming.isDroitier() == isDroitier_atPre
					);

		} else if (lemming.getComportement().contains(Comportement.WALKER)
				&& lemming.isDroitier() == true
				&& (gameEng.isObstacle(lemming.getX(), lemming.getY() + 1) && (gameEng.isObstacle(
						lemming.getX() + 1, lemming.getY() - 1)))) {

			Assert.assertTrue("Test GameEng Init : ",
					lemming.getX() == getX_atPre
					&& lemming.getY() == getY_atPre
					&& lemming.isDroitier() == false
					&& lemming.getFalling() == 0
					);
		}
		else if (lemming.getComportement().contains(Comportement.WALKER)
				&& lemming.isDroitier() == false
				&& (gameEng.isObstacle(lemming.getX(), lemming.getY() + 1) && (gameEng.isObstacle(
						lemming.getX() - 1, lemming.getY() - 1)))) {
			Assert.assertTrue("Test GameEng Init : ",
					lemming.getX() == getX_atPre
					&& lemming.getY() == getY_atPre
					&& lemming.isDroitier() == true
					&& lemming.getFalling() == 0
					);
		} else if (lemming.getComportement().contains(Comportement.WALKER)
				&& lemming.isDroitier() == true
				&& (gameEng.isObstacle(lemming.getX(), lemming.getY() +1)
						&& (gameEng.isObstacle(lemming.getX() + 1, lemming.getY())) && (gameEng
								.isObstacle(lemming.getX() + 1, lemming.getY() - 2)))) {
			Assert.assertTrue("Test GameEng Init : ",
					lemming.getX() == getX_atPre
					&& lemming.getY() == getY_atPre
					&& lemming.isDroitier() == false
					&& lemming.getFalling() == 0
					);
		} else if (lemming.getComportement().contains(Comportement.WALKER)
				&& lemming.isDroitier() == false
				&& (gameEng.isObstacle(lemming.getX(), lemming.getY() + 1)
						&& (gameEng.isObstacle(lemming.getX() - 1, lemming.getY())) && (gameEng
								.isObstacle(lemming.getX() - 1, lemming.getY() - 2)))) {
			Assert.assertTrue("Test GameEng Init : ",
					lemming.getX() == getX_atPre
					&& lemming.getY() == getY_atPre
					&& lemming.isDroitier() == true
					&& lemming.getFalling() == 0
					);
		} else if (lemming.getComportement().contains(Comportement.WALKER)
				&& lemming.isDroitier() == true
				&& (gameEng.isObstacle(lemming.getX(), lemming.getY() + 1)
						&& (gameEng.isObstacle(lemming.getX() + 1, lemming.getY()))
						&& !(gameEng.isObstacle(lemming.getX() + 1, lemming.getY() -1)) && !(gameEng
								.isObstacle(lemming.getX() + 1, lemming.getY() - 2)))) {
			Assert.assertTrue("Test GameEng Init : ",
					lemming.getX() == getX_atPre+1
					&& lemming.getY() == getY_atPre-1
					&& lemming.isDroitier() == true
					&& lemming.getFalling() == 0
					);

		} else if (lemming.getComportement().contains(Comportement.WALKER)
				&& lemming.isDroitier() == false
				&& (gameEng.isObstacle(lemming.getX(), lemming.getY() + 1)
						&& (gameEng.isObstacle(lemming.getX() - 1, lemming.getY()))
						&& !(gameEng.isObstacle(lemming.getX() - 1, lemming.getY() -1)) && !(gameEng
								.isObstacle(lemming.getX() - 1, lemming.getY() - 2)))) {
			Assert.assertTrue("Test GameEng Init : ",
					lemming.getX() == getX_atPre-1
					&& lemming.getY() == getY_atPre-1
					&& lemming.isDroitier() == true
					&& lemming.getFalling() == 0
					);
		} else if (lemming.getComportement().contains(Comportement.WALKER)
				&& lemming.isDroitier() == true
				&& gameEng.isObstacle(lemming.getX(), lemming.getY() +1)
				&& !gameEng.isObstacle(lemming.getX() + 1, lemming.getY()) 
				&& !gameEng.isObstacle(lemming.getX() + 1, lemming.getY() - 1)) {

			Assert.assertTrue("Test GameEng Init : ",
					lemming.getX() == getX_atPre+1
					&& lemming.getY() == getY_atPre
					&& lemming.isDroitier() == true
					&& lemming.getFalling() == 0
					);
		} else if (lemming.getComportement().contains(Comportement.WALKER)
				&& lemming.isDroitier() == false
				&& gameEng.isObstacle(lemming.getX(), lemming.getY() +1)
				&& !gameEng.isObstacle(lemming.getX() - 1, lemming.getY()) 
				&& !gameEng.isObstacle(lemming.getX() - 1, lemming.getY() - 1)) {

			Assert.assertTrue("Test GameEng Init : ",
					lemming.getX() == getX_atPre-1
					&& lemming.getY() == getY_atPre
					&& lemming.isDroitier() == false
					&& lemming.getFalling() == 0
					);
		} else if (lemming.getComportement().contains(Comportement.FALLER) 
				&& !lemming.getComportement().contains(Comportement.CLIMBER)
				&& lemming.isDroitier() == true
				&& !gameEng.isObstacle(lemming.getX(), lemming.getY() + 1)) {

			Assert.assertTrue("Test GameEng Init : ",
					lemming.getX() == getX_atPre
					&& lemming.getY() == getY_atPre+1
					&& lemming.isDroitier() == true
					&& lemming.getFalling() == falling_atPre+1
					);
		} else if (lemming.getComportement().contains(Comportement.FALLER) 
				&& !lemming.getComportement().contains(Comportement.CLIMBER)
				&& lemming.isDroitier() == false
				&& !gameEng.isObstacle(lemming.getX(), lemming.getY() + 1)) {

			Assert.assertTrue("Test GameEng Init : ",
					lemming.getX() == getX_atPre
					&& lemming.getY() == getY_atPre+1
					&& lemming.isDroitier() == true
					&& lemming.getFalling() == falling_atPre+1
					);

		} else if (lemming.getComportement().contains(Comportement.FALLER) && !lemming.getComportement().contains(Comportement.CLIMBER)
				&& lemming.isDroitier() == true
				&& (gameEng.isObstacle(lemming.getX(), lemming.getY() + 1) && falling_atPre < 8)) {
			Assert.assertTrue("Test GameEng Init : ",
					lemming.getX() == getX_atPre
					&& lemming.getY() == getY_atPre
					&& lemming.isDroitier() == true
					&& lemming.getFalling() == 0
					);
		} else if (lemming.getComportement().contains(Comportement.FALLER) && !lemming.getComportement().contains(Comportement.CLIMBER)
				&& lemming.isDroitier() == false
				&& (gameEng.isObstacle(lemming.getX(), lemming.getY() + 1) && falling_atPre < 8)) {
			Assert.assertTrue("Test GameEng Init : ",
					lemming.getX() == getX_atPre
					&& lemming.getY() == getY_atPre
					&& lemming.isDroitier() == false
					&& lemming.getFalling() == 0
					);
		} else if (isDroitier_atPre && lemming.getComportement().contains(Comportement.CLIMBER) 
				&& gameEng.isObstacle(lemming.getX()+1, lemming.getY()) && gameEng.isObstacle(lemming.getX() + 1, lemming.getY() + 1)  
				&& level.getNature(lemming.getX(), lemming.getY()+1) == Nature.EMPTY
				&& level.getNature(lemming.getX(), lemming.getY()+2) == Nature.EMPTY) {
			Assert.assertTrue("Test GameEng Init : ",
					lemming.getX() == getX_atPre
					&& lemming.getY() == getY_atPre+1
					&& lemming.isDroitier() == true
					);
		} else if (!isDroitier_atPre && lemming.getComportement().contains(Comportement.CLIMBER) 
				&& gameEng.isObstacle(lemming.getX()-1, lemming.getY()) && gameEng.isObstacle(lemming.getX() - 1, lemming.getY() + 1)  
				&& level.getNature(lemming.getX(), lemming.getY()+1) == Nature.EMPTY
				&& level.getNature(lemming.getX(), lemming.getY()+2) == Nature.EMPTY) {
			Assert.assertTrue("Test GameEng Init : ",
					lemming.getX() == getX_atPre
					&& lemming.getY() == getY_atPre+1
					&& lemming.isDroitier() == false
					);
		} else if (isDroitier_atPre && lemming.getComportement().contains(Comportement.CLIMBER) 
				&& gameEng.isObstacle(lemming.getX() + 1, lemming.getY()) 
				&& level.getNature(lemming.getX() + 1, lemming.getY() + 1) == Nature.EMPTY
				&& level.getNature(lemming.getX(), lemming.getY() + 1) == Nature.EMPTY
				&& level.getNature(lemming.getX(), lemming.getY() + 2) == Nature.EMPTY) {
			Assert.assertTrue("Test GameEng Init : ",
					lemming.getX() == getX_atPre+1
					&& lemming.getY() == getY_atPre+1
					&& lemming.isDroitier() == true
					);
		} else if (!isDroitier_atPre && lemming.getComportement().contains(Comportement.CLIMBER) 
				&& gameEng.isObstacle(lemming.getX() - 1, lemming.getY()) 
				&& level.getNature(lemming.getX() - 1, lemming.getY() + 1) == Nature.EMPTY
				&& level.getNature(lemming.getX(), lemming.getY() + 1) == Nature.EMPTY
				&& level.getNature(lemming.getX(), lemming.getY() + 2) == Nature.EMPTY) {
			Assert.assertTrue("Test GameEng Init : ",
					lemming.getX() == getX_atPre-1
					&& lemming.getY() == getY_atPre+1
					&& lemming.isDroitier() == false
					);

		} else if (lemming.getComportement().contains(Comportement.STOPPER)) {
			System.out.println("cas 1 stopper");
			level.setNature(getX_atPre, getY_atPre, Nature.DIRT);
			level.setNature(getX_atPre, getY_atPre-1, Nature.DIRT);
		} else if (lemming.getComportement().contains(Comportement.BASHER) && lemming.isDroitier()
				&& lemming.getBasherDelay() > 0 && gameEng.isObstacle(lemming.getX(), lemming.getY() - 1)
				&& level.getNature(lemming.getX() + 1, lemming.getY()) != Nature.METAL
				&& level.getNature(lemming.getX() + 2, lemming.getY()) != Nature.METAL
				&& level.getNature(lemming.getX() + 3, lemming.getY()) != Nature.METAL) {
			Assert.assertTrue("Test GameEng Init : ",
					lemming.getX() == getX_atPre+1
					&& lemming.getY() == getY_atPre
					);
		}
	}
	
	/**
	 * changeComportement ------------------------------------------------------
	 */
	@Test
	public void lemming_changeComportement_1() {
		testLemmingChangeComportementWith(c); 
	}

	@Test
	public void lemming_changeComportement_2() {
		//TODO..........

	}

	private void testLemmingChangeComportementWith(ArrayList<Comportement> c) {			

		boolean isDroitier_atPre = lemming.isDroitier();
		int getX_atPre = lemming.getX();
		int getY_atPre = lemming.getY();
		int getFalling_atPre = lemming.getFalling();
		boolean isDead_atPre = lemming.isDead();
		boolean isSaved_atPre = lemming.isSaved();
		int getDalles_atPre = lemming.getDalles();
		int getBuilderDelay_atPre = lemming.getBuilderDelay();
		int getBomberDelay_atPre = lemming.getBomberDelay();
		int getBasherDelay_atPre = lemming.getBasherDelay();
				
		lemming = new LemmingImpl(c, gameEng);

		Assert.assertTrue("Test GameEng Init : ",
				lemming.isDroitier() == isDroitier_atPre
				&& lemming.getComportement().contains(c)
				&& lemming.getX() == getX_atPre
				&& lemming.getY() == getY_atPre
				&& lemming.getFalling() == getFalling_atPre
				&& lemming.getGameEng() == gameEng
				&& lemming.isDead() == isDead_atPre
				&& lemming.isSaved() == isSaved_atPre
				&& lemming.getDalles() == getDalles_atPre
				&& lemming.getBuilderDelay() == getBuilderDelay_atPre
				&& lemming.getBomberDelay() == getBomberDelay_atPre
				&& lemming.getBasherDelay() == getBasherDelay_atPre
				);
		}

}
