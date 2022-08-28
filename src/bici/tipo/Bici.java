package bici.tipo;

import static bici.sim.GeneratoreCasuale.posizioneCasuale;

import java.awt.Image;
import java.util.Set;

import bici.sim.Coordinate;
import bici.sim.Direzione;
import bici.sim.Zona;

public abstract class Bici {
	private Zona zona;

	private Coordinate posizione; // posizione corrente

	private Direzione direzione;  // direzione corrente

	
	public Bici(Zona zona) {		
		this.zona = zona;
		final Coordinate posizioneIniziale = posizioneCasuale();
		this.posizione = posizioneIniziale;
		this.direzione = null;
	}
	
	public Zona getZona() {
		return this.zona;
	}

	protected void setPosizione(Coordinate nuova) {
		this.posizione = nuova;
	}

	public Coordinate getPosizione() {
		return this.posizione;
	}

	public Direzione getDirezione() {
		return this.direzione;
	}

	protected void setDirezione(Direzione nuova) {
		this.direzione = nuova;
	}
	
	protected void eseguiSpostamento() {
		this.setPosizione(this.getPosizione().trasla(this.getDirezione()));
	}

	protected Set<Direzione> getPossibiliDirezioni() {
		return this.getZona().getPossibiliDirezioni(this.getPosizione());
	}
	
	public abstract Image getImmagine();
	
	public abstract void simula(int passo);
	

}
