package bici.sim;

import static bici.sim.CostantiSimulazione.DIMENSIONE;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneratoreCasuale {

	static final private Random random = new Random();
	
	/**
	 * @return le coordinate di una posizione scelta a caso tra quelle
	 *         all'interno della zona 
	 */
	static public Coordinate posizioneCasuale() {
		final int x = 1 + random.nextInt(DIMENSIONE-2);
		final int y = 1 + random.nextInt(DIMENSIONE-2);
		return new Coordinate(x,y);
	}
	

	static final public List<Coordinate> generaNposizioniCasuali(int n) {
		final List<Coordinate> posizioni = new ArrayList<>(n);
		for(int i=0; i<n; i++)
			posizioni.add(posizioneCasuale());
		return posizioni;
	}
	
}
