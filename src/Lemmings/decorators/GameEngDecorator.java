package Lemmings.decorators;

import java.util.ArrayList;

import Lemmings.services.IGameEng;
import Lemmings.services.IJoueur;
import Lemmings.services.ILemming;
import Lemmings.services.ILevel;

public abstract class GameEngDecorator implements IGameEng {

	private final IGameEng delegate;

	public GameEngDecorator(IGameEng delegate) {
		this.delegate = delegate;
	}

	@Override
	public boolean isObstacle(int x, int y) {
		return delegate.isObstacle(x, y);
	}

	@Override
	public int getTour() {
		return delegate.getTour();
	}

	@Override
	public int getScore() {
		return delegate.getScore();
	}

	@Override
	public boolean isGameOver() {
		return delegate.isGameOver();
	}

	@Override
	public int getSizeColony() {
		return delegate.getSizeColony();
	}

	@Override
	public int getSpawnSpeed() {
		return delegate.getSpawnSpeed();
	}

	@Override
	public int getNbLemmingCreated() {
		return delegate.getNbLemmingCreated();
	}

	@Override
	public int getNbLemmingSaved() {
		return delegate.getNbLemmingSaved();
	}

	@Override
	public ILevel getLevel() {
		return delegate.getLevel();
	}
	
	@Override
	public IJoueur getJoueur() {
		return delegate.getJoueur();
	}

	@Override
	public ArrayList<ILemming> getActivLemmings() {
		return delegate.getActivLemmings();
	}

	@Override
	public void init(int x, int y, ILevel l, IJoueur j) {
		delegate.init(x, y, l, j);
	}

	@Override
	public void step() {
		delegate.step();
	}
}