package bici.sim;


import static bici.sim.CostantiSimulazione.DIMENSIONE;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;


/**
 * DA MIGLIORARE PER LA TESTABILITA'
 * (VEDI DOMANDA 5)
 */
public class Zona {

	final private int dimensione;
	
	final private Set<Coordinate> ostacoli;

	final private Set<Percorso> percorsi;
	
	/**
	 * Crea un ambiente (quadrato) delle dimensioni prefissate
	 */
	public Zona() {
		this.dimensione = DIMENSIONE;
		this.ostacoli = new HashSet<>();
		this.inizializzaBordi(this.dimensione);
		this.percorsi = new LinkedHashSet<>();
	}
	
	private void inizializzaBordi(int dim) {
		for(int i=0; i<dim; i++) {
			addOstacolo(0,i);
			addOstacolo(i,0);
			addOstacolo(dim-1,i);
			addOstacolo(i,dim-1);
		}
	}

	public int getDimensione() {
		return this.dimensione;
	}
	
	public void addOstacolo(int x, int y) {
		this.ostacoli.add(new Coordinate(x, y));
	}

	public Set<Coordinate> getOstacoli() {
		return this.ostacoli;
	}

	public boolean collideConOstacolo(Coordinate pos) {
		return this.getOstacoli().contains(pos);
	}

	/**
	 * Restituisce l'insieme degli oggetti {@link Direzione} che possono
	 * essere seguite a partire dalla posizione passata come riferimento,
	 * oppure l'insieme vuoto se nessuna direzione e' possibile.<BR/>
	 * <B> VEDI DOMANDA 5 </B>
	 * @param riferimento - la posizione di partenza
	 * @return l'insieme delle direzioni lecite (senza colpire ostacoli)
	 */
	public Set<Direzione> getPossibiliDirezioni(Coordinate riferimento) {
		/* seleziona solo direzioni verso posizioni adiacenti 
		 * al riferimento che non siano occupate da un ostoacolo */		
		final Set<Direzione> possibili = new HashSet<>();
		possibili.addAll(Arrays.asList(Direzione.values()));
		final Iterator<Direzione> it = possibili.iterator();
		while (it.hasNext()) {
			final Coordinate destinazione = riferimento.trasla(it.next());
			if (this.collideConOstacolo(destinazione))
				it.remove();
		}
		return possibili;
	}

	public boolean add(Percorso t) {
		return this.percorsi.add(t);
	}
	
	public Set<Percorso> getPercorsi() {
		return this.percorsi;
	}
	
}
