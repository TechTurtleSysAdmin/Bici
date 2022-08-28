package bici.sim;

import bici.tipo.Bianca;
import bici.tipo.Bici;

/**
 * Modella un percorso da un'origine ad una destinazione,
 * entrambe modellate da un oggetto {@link Coordinate} da parte di
 * una generica bici, ad es. (ma non solo!) di tipo {@link Bianca}
 */
public class Percorso {

	/* DA CAMBIARE: VEDI DOMANDA 2 */
	private Bici bici;
	
	private Coordinate origine;

	private Coordinate destinazione;
	
	private int passoIniziale; // passo della simulazione in cui il percorso e' stato iniziato
	
	private int passoFinale;   // passo della simulazione in cui il percorso e' stato completato
	
	public Percorso(Bici bici, Coordinate origine, Coordinate destinazione) {
		this.bici = bici;
		this.origine = origine;
		this.destinazione = destinazione;
	}

	public Bici getBici() {
		return this.bici;
	}

	public Coordinate getOrigine() {
		return this.origine;
	}

	public Coordinate getDestinazione() {
		return this.destinazione;
	}
	
	public int getPassoIniziale() {
		return this.passoIniziale;
	}

	public void setPassoIniziale(int passoIniziale) {
		this.passoIniziale = passoIniziale;
	}

	public int getPassoFinale() {
		return this.passoFinale;
	}

	public void setPassoFinale(int passoFinale) {
		this.passoFinale = passoFinale;
	}

	// SUGG.: VEDI DOMANDA 3
	@Override
	public int hashCode() {
		return this.getOrigine().hashCode()+this.getDestinazione().hashCode();
	}

	@Override
	public boolean equals(Object o) {
		final Percorso that = (Percorso)o;
		return this.getOrigine().equals(that.getOrigine()) && this.getDestinazione().equals(that.getDestinazione());
	}
	
	@Override
	public String toString() {
		return this.getOrigine()+"->"+this.getDestinazione();
	}

}
