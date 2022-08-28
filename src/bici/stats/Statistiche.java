package bici.stats;

import java.util.*;

import bici.sim.Coordinate;
import bici.sim.Percorso;
import bici.sim.Zona;
import bici.tipo.Bianca;

public class Statistiche {

	synchronized public void stampaFinale(Zona zona) {
		final Set<Percorso> percorsi = zona.getPercorsi();

		System.out.println(percorsi.size() + " percorsi collezionati." );
		System.out.println(zona.getPercorsi());
		System.out.println();

		// (VEDI DOMANDA 3)
		System.out.println("Percorsi di ciascuna bicicletta:");
		final Map<Bianca,List<Percorso>> bici2percorsi = percorsiPerBici(percorsi);
		stampaPercorsiPerBici(bici2percorsi);
		System.out.println();

		// (VEDI DOMANDA 4)
		System.out.println("Classifica finale delle posizioni piu' battute:");
		final SortedMap<Coordinate,Integer> pos2utilizzi = utilizzi(bici2percorsi);
		stampaUtilizzi(pos2utilizzi);
		System.out.println();
	}

	/**
	 * <B>DA COMPLETARE (VEDI DOMANDA 3)</B>
	 * @param percorsi - insieme dei percorsi collezionati durante la simulazione
	 * @return una mappa che riporti per ogni bici (di qualsiasi tipo)
	 *         la lista dei percorsi coperti
	 */
	public Map<Bianca, List<Percorso>> percorsiPerBici(Set<Percorso> percorsi) {
		// DA COMPLETARE (VEDI DOMANDA 3)
		return Collections.emptyMap();
	}

	/**
	 * <EM>N.B. UTILE PER STAMPARE RISULTATI DOMANDA 3</EM>
	 * @param bici2percorsi
	 */
	private void stampaPercorsiPerBici(final Map<Bianca, List<Percorso>> bici2percorsi) {
		for(Bianca bici : bici2percorsi.keySet()) {
			List<Percorso> percorsi = bici2percorsi.get(bici);
			System.out.println("La bicicletta "+bici+" ha coperto "+( percorsi!=null ? percorsi.size() : 0 ) +" corse");
		}
	}
	
	/**
	 * <B>DA COMPLETARE (VEDI DOMANDA 4)</B>
	 * 	@param bici2percorsi - insiemi dei percorsi collezionati durante la simulazione
	 *                         e raggruppati per bici
	 * @return una mappa ordinata decrescente in cui figurano come chiavi 
	 *         le posizioni piu' battute come origine o destinazione di un 
	 *         percorso, come valori il numero di tali percorsi
	 */
	public SortedMap<Coordinate,Integer> utilizzi(Map<Bianca, List<Percorso>> bici2percorsi) {
		// DA COMPLETARE (VEDI DOMANDA 4)
		return Collections.emptySortedMap();
	}
	
	/**
	 * <EM>N.B. UTILE PER STAMPARE RISULTATI DOMANDA 4</EM>
	 * @param classifica delle posizioni piu' usate
	 */
	private void stampaUtilizzi(SortedMap<Coordinate,Integer> classifica) {
		int i = 0;
		for(Map.Entry<Coordinate, Integer> entry : classifica.entrySet()) {
			final Coordinate posizione = entry.getKey();
			final Integer numeri = entry.getValue();
			System.out.println(i+") "+posizione+" con "+numeri+" utilizzi");
			i++;
		}
	}

}
