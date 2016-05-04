package Lemmings.implementations;

import java.util.ArrayList;
import java.util.Scanner;

import Lemmings.ihm.Ihm;
import Lemmings.services.IGameEng;
import Lemmings.services.IJoueur;
import Lemmings.services.ILemming;
import Lemmings.services.ILevel;
import Lemmings.tools.Comportement;
import Lemmings.tools.Nature;

public class GameEngImpl implements IGameEng {

	private int tour;
	private int sizeColony;
	private int spawnSpeed;
	private int nbLemmingCreated;
	private int nbLemmingSaved;
	private ILevel level;
	private ArrayList<ILemming> activLemmings;
	private IJoueur joueur;
	
	public GameEngImpl(int sc, int sp, ILevel level, IJoueur joueur) {
		this.init(sc, sp, level, joueur); 
		this.step();	
	}
	
	@Override
	public void init(int sc, int sp, ILevel level, IJoueur joueur) {
		this.tour = 0;
		this.sizeColony = sc;
		this.spawnSpeed = sp;
		this.nbLemmingCreated = 0;
		this.nbLemmingSaved = 0;
		this.level = level;
		this.joueur = joueur;
		this.activLemmings = new ArrayList<ILemming>();
	}
	
	@Override
	public void step() {
		Ihm ihm = new Ihm();
		
		while (!isGameOver()) {
		
			if (tour % spawnSpeed == 0 && nbLemmingCreated < getSizeColony()) {
				ArrayList<Comportement> comportements = new ArrayList<Comportement>();
				comportements.add(Comportement.FALLER);
				activLemmings.add(new LemmingImpl(comportements, this));
				nbLemmingCreated++;
			}
			applyLemmingStep();
			tour++;
			ihm.updatedraw(getLevel(), getActivLemmings());
			
			System.out.println("p pour pause");
			System.out.println("n pour continuer");
			Scanner keyboard = new Scanner(System.in);
			char mykey = '~';
			mykey = keyboard.next(".").charAt(0);
			if (mykey == 'p') {
				joueur.doPause(getActivLemmings());
			}
		}
		
		System.out.println("\n-----------------End of game-----------------");
		System.out.println("Created: " + getNbLemmingCreated());
		System.out.println("Saved: " + getNbLemmingSaved());
		System.out.println("Score: " + getScore());
		System.out.println("---------------------------------------------");
	}

	private void applyLemmingStep() {
		for (ILemming lem : (ArrayList<ILemming>)activLemmings.clone()) {
			lem.step();
			if (lem.isDead()) {
				System.out.println("Removing lemm...");
				this.activLemmings.remove(lem);
				System.out.println("activLemmings.size(): " + activLemmings.size());
			}
			if (lem.isSaved()) { 
				nbLemmingSaved++ ; 
				this.activLemmings.remove(lem);
			}
		}
	}
	
	@Override
	public boolean isObstacle(int x, int y) {
		return (getLevel().getNature(x, y) == Nature.DIRT || getLevel().getNature(x, y) == Nature.METAL);
	}

	@Override
	public int getTour() {
		return this.tour;
	}
	
	@Override
	public int getScore() {
		return (getNbLemmingSaved() / getNbLemmingCreated()) * 100 + getTour();
	}

	@Override
	public boolean isGameOver() {
		return (getNbLemmingCreated() == getSizeColony() && activLemmings.size() == 0); 
	}

	@Override
	public int getSizeColony() { 
		return this.sizeColony;
	}

	@Override
	public int getSpawnSpeed() {
		return this.spawnSpeed;
	}

	@Override
	public int getNbLemmingCreated() {
		return nbLemmingCreated;
	}

	@Override
	public int getNbLemmingSaved() {
		return nbLemmingSaved;
	}

	@Override
	public ILevel getLevel() {
		return this.level;
	}
	
	@Override
	public IJoueur getJoueur() {
		return this.joueur;
	}

	@Override
	public ArrayList<ILemming> getActivLemmings() {
		return this.activLemmings;
	}
}
