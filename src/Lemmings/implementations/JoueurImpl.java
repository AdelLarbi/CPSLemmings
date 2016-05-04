package Lemmings.implementations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import Lemmings.services.IJoueur;
import Lemmings.services.ILemming;
import Lemmings.tools.Comportement;

public class JoueurImpl implements IJoueur {
	
	HashMap<Comportement, Integer> jetons;
	String name;
	final int maxComportement = 8;
	public static final List<Comportement> liste_a_afficher = Collections.unmodifiableList(
		    new ArrayList<Comportement>() {
				private static final long serialVersionUID = 1L;
			{
		        add(Comportement.WALKER);
		        add(Comportement.DIGGER);
		        add(Comportement.CLIMBER);
		        add(Comportement.BUILDER);
		        add(Comportement.FLOATER);
		        add(Comportement.BOMBER);
		        add(Comportement.STOPPER);
		        add(Comportement.BASHER);
		    }});

	public JoueurImpl(String name , int nb) {
		this.init(name, nb);
	}

	@Override
	public HashMap<Comportement, Integer> getJetons() {
		return jetons;
	}

	@Override
	public int getNbJetons() {
		int res = 0;
		Comportement[] comp = { Comportement.WALKER , Comportement.DIGGER , Comportement.CLIMBER , Comportement.BUILDER , Comportement.FLOATER , Comportement.BOMBER , Comportement.STOPPER , Comportement.BASHER };
		
		for (int i = 0; i < jetons.size(); i++)
			res = res + jetons.get(comp[i]);
	
		return res;
	}

	@Override
	public int getNbJetonsByComportement(Comportement c) {
		return jetons.get(c);
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int maxComportement() {
		return this.maxComportement;
	}

	@Override
	public void init(String name, int nb) {
		this.name = name;
		this.jetons = new HashMap<Comportement, Integer>(maxComportement);
		Comportement[] comp = { Comportement.WALKER , Comportement.DIGGER , Comportement.CLIMBER , Comportement.BUILDER , Comportement.FLOATER , Comportement.BOMBER , Comportement.STOPPER , Comportement.BASHER };
		
		for (int i = 0; i < comp.length; i++)
			jetons.put(comp[i], nb);
	}

	@Override
	public void depenserJeton(Comportement c) {
		jetons.put(c, jetons.get(c)-1);
	}

	@Override
	public void faireAction(ILemming l, Comportement instantComportement) {
		l.changeComportement(instantComportement);
	}
	
	@Override
	public void doPause(ArrayList<ILemming> lemming) {
		
		System.out.println("Game Paused.");
		String chaine = "Inventaire ";

		Set cles = jetons.keySet();
		Iterator it = cles.iterator();
		
		while (it.hasNext()) {
		   Comportement cle = (Comportement) it.next();
		   Integer valeur = jetons.get(cle); 
		   chaine = chaine + " Comportement : " + cle + " jetons : " + valeur; 
		}

		System.out.println(chaine);
		System.out.println("Changement de comportement :  entrer x lemming");
		Scanner keyboard = new Scanner(System.in);
		int x = keyboard.nextInt();
		System.out.println("Changement de comportement :  entrer y lemming");
		int y = keyboard.nextInt();
		System.out.println("Changement de comportement :  entrer le numero du Comportement parmis ceux la");
		liste_a_afficher.toString();
		int c = keyboard.nextInt();

		for (ILemming l : lemming) {
			if (l.getX() == x && l.getY() == y) {
				System.out.println(x +"ca marche "+y);
				faireAction(l, liste_a_afficher.get(c));
			}
		}
	}





}
