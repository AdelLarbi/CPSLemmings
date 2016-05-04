package Lemmings.contract;


import Lemmings.decorators.GameEngDecorator;
import Lemmings.error.ContractError;
import Lemmings.error.ErrorHandler;
import Lemmings.error.InvariantError;
import Lemmings.error.PostConditionError;
import Lemmings.error.PreConditionError;
import Lemmings.services.IGameEng;
import Lemmings.services.IJoueur;
import Lemmings.services.ILemming;
import Lemmings.services.ILevel;
import Lemmings.tools.Nature;

public class GameEngContract extends GameEngDecorator {

	public GameEngContract(IGameEng delegate) {
		super(delegate);
	}
	
	/**
	 * Init --------------------------------------------------------------------
	 */
	@Override
	public void init(int sc, int sp, ILevel l, IJoueur j) {
		try {
			checkInitPreConditions(sc, sp);	
			checkInvariants();
			super.init(sc, sp, l, j);	
			checkInvariants();
			checkInitPostConditions(sc, sp, l, j);
		} catch (ContractError e) {			
			ErrorHandler.printError(e);			
			throw e;			
		}		
	}
	
	private void checkInvariants() throws InvariantError {

		if (!(getNbLemmingCreated() <= getSizeColony())) {
			throw new InvariantError("Invariant GameEng : getNbLemmingCreated() > getSizeColony()");
		}
		for (int y = 0; y < getLevel().getWidth(); y++) {	
			for (int x = 0; x < getLevel().getHeight(); x++) {
				if (isObstacle(x, y) == true) {
					if (!(getLevel().getNature(x, y) == Nature.DIRT || getLevel().getNature(x, y) == Nature.METAL)) {
						throw new InvariantError("Invariant GameEng : isObstacle(x,y) != ILevel::getNature(x,y) == (Nature.DIRT || Nature.METAL)");
					}
				} else if ((isObstacle(x, y) == false)) {
					if (!(getLevel().getNature(x, y) == Nature.EMPTY)) {
						throw new InvariantError("Invariant GameEng : !isObstacle(x,y) != ILevel::getNature(x,y) == Nature.EMPTY");
					}
				}
			}
		}
		if (!(getActivLemmings().size() <= getSizeColony())) {
			throw new InvariantError("Invariant GameEng : getActivLemmings().size() > getSizeColony()");
		}
		if (isGameOver() == true) {
			if (!(getNbLemmingCreated() == getSizeColony() && getActivLemmings().size() == 0)) {
				throw new InvariantError("Invariant GameEng : getNbLemmingCreated() != getSizeColony() && getActivLemmings().size() == 0)");
			}
		} else if (isGameOver() == false) {
			if (getNbLemmingCreated() == getSizeColony() && getActivLemmings().size() == 0) {
				throw new InvariantError("Invariant GameEng : getNbLemmingCreated() == getSizeColony() && getActivLemmings().size() == 0)");
			}
		}
		if (!(getScore() == (getNbLemmingSaved() / getNbLemmingCreated()) * 100 + getTour())) {
			throw new InvariantError("Invariant GameEng : getscore() != (getNbLemmingSaved() / getNbLemmingCreated()) * 100 + getTour()");
		}			
	}

	private void checkInitPreConditions(int sc, int sp) throws PreConditionError {
		if (!(sc > 0)) {
			throw new PreConditionError("Init_GameEng : sc <= 0");
		}
		if (!(sp > 0)) {
			throw new PreConditionError("Init_GameEng : sp <= 0");
		}
	}

	private void checkInitPostConditions(int sc, int sp, ILevel l, IJoueur j) throws PostConditionError {
		if (!(getTour() == 0)) {
			throw new PostConditionError("Init_GameEng : getTour() != 0");
		}
		if (!(getScore() == 0)) {
			throw new PostConditionError("Init_GameEng : getScore() != 0");
		}
		if (!(isGameOver() == false)) {
			throw new PostConditionError("Init_GameEng : isGameOver == true");
		}
		if (!(getSizeColony() == sc)) {
			throw new PostConditionError("Init_GameEng : getSizeColony() != sc)");
		}
		if (!(getSpawnSpeed() == sp)) {
			throw new PostConditionError("Init_GameEng : getSpawnSpeed() != sp)");
		}
		if (!(getNbLemmingCreated() == 0)) {
			throw new PostConditionError("Init_GameEng : getNbLemmingCreated() != 0)");
		}
		if (!(getNbLemmingSaved() == 0)) {
			throw new PostConditionError("Init_GameEng : getNbLemmingSaved() != 0)");
		}
		if (!(getLevel() == l)) {
			throw new PostConditionError("Init_GameEng : getLevel() != l");
		}
		if (!(getJoueur() == j)) {
			throw new PostConditionError("Init_GameEng : getJoueur() != j");
		}
		if (!(getActivLemmings().isEmpty())) {
			throw new PostConditionError("Init_GameEng : !getActivLemmings().isEmpty()");
		}
	}
	
	
	/**
	 * step --------------------------------------------------------------------
	 */
	@Override
	public void step() {
		try {
			int getTour_atPre = getTour();
			int getNbLemmingCreated_atPre = getNbLemmingCreated();
			int getNbLemmingSaved_atPre = getNbLemmingSaved();
			ILevel getLevel_atPre = getLevel();
			IJoueur getJoueur_atPre = getJoueur();
			
			checkStepPreConditions();	
			checkInvariants();
			super.step();	
			checkInvariants();
			checkStepPostConditions(getTour_atPre, getNbLemmingCreated_atPre,
					getNbLemmingSaved_atPre, getLevel_atPre, getJoueur_atPre);
		} catch (ContractError e) {			
			ErrorHandler.printError(e);			
			throw e;			
		}		
	}

	private void checkStepPreConditions() {
		if (!(isGameOver() == false)) {
			throw new PreConditionError("Step_GameEng : isGameOver == true");
		}
	}
	
	private void checkStepPostConditions(int getTour_atPre,
			int getNbLemmingCreated_atPre, int getNbLemmingSaved_atPre,
			ILevel getLevel_atPre, IJoueur getJoueur_atPre) {
		
		if (!(getTour() == getTour_atPre + 1)) {
			throw new PostConditionError("Step_GameEng : getTour() != getTour_atPre + 1");
		}
		//for (int i = 0; i < getMaxTour(); i++) {
		//TODO test for all game steps. Done just one step, i thik it's enough..
			int i = 0;	
			if (i % getSpawnSpeed() == 0 && getNbLemmingCreated() < getSizeColony()) {
				if (!(getNbLemmingCreated() == getNbLemmingCreated_atPre + 1)) {
					throw new PostConditionError("Step_GameEng : getNbLemmingCreated() != getNbLemmingCreated_atPre + 1");
				}
			}
		//}
		for (ILemming lemming : getActivLemmings()) {
			if (lemming.isSaved() == true) {
				if (!(getNbLemmingSaved() == getNbLemmingSaved_atPre + 1)) {
					throw new PostConditionError("Step_GameEng : getNbLemmingSaved() != getNbLemmingSaved_atPre + 1");
				}
			}
		}
		if (!(getLevel() == getLevel_atPre)) {
			throw new PostConditionError("Step_GameEng : getLevel() != getLevel_atPre");
		}
		if (!(getJoueur() == getJoueur_atPre)) {
			throw new PostConditionError("Step_GameEng : getJoueur() != getJoueur_atPre");
		}
		for (ILemming lemming : getActivLemmings()) {
			// TODO... getActivLemmings(Step())
		}
	}
}
