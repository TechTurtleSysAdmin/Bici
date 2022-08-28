package bici.sim;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Questa classe modella un direzione (incrementale) sul piano cartesiano
 * come coppia di interi in {-1,0,+1}. Solo direzioni orizzontali e verticali
 * sono supportate.
 * <B>(DA COMPLETARE VEDI DOMANDA 1)</B>
 */
public enum Direzione {

	   NORD(0,-1) {
		@Override public Direzione opposta() { return SUD; }
	}, EST(+1,0) {
		@Override public Direzione opposta() { return OVEST; }
	}, SUD(0,+1) {
		@Override public Direzione opposta() { return NORD; }
	}, OVEST(-1,0) {
		@Override public Direzione opposta() { return EST; }
	};
	
	static private final Random rnd = new Random();
		
	static public List<Direzione> tutteAcaso() {
		final List<Direzione> risultato = new ArrayList<>(Arrays.asList(values()));
		Collections.shuffle(risultato);
		return risultato;
	}

	
	static public Direzione casuale() {
		final int indiceDirezioneAcaso = rnd.nextInt(values().length);
		return values()[indiceDirezioneAcaso];
	}

	static public Direzione scegliAcasoTra(Collection<Direzione> possibili) {
		if (possibili.isEmpty()) throw new IllegalArgumentException();
		
		final int chosenIndex = rnd.nextInt(possibili.size());
		final Iterator<Direzione> it = possibili.iterator();
		for(int i=0; i<chosenIndex-1; i++) it.next();
		return it.next();
	}

	/* direzione di uno spostamento; un
	 * delta puo' essere -1 , 0 , +1 */
	private int dx;
	
	private int dy;
	
	private Direzione(int dx, int dy) {
		this.dx = dx;
		this.dy = dy;
	}

	/**
	 * Trova la {@link Direzione} per spostarsi da una
	 * posizione ad un'altra
	 * @param src posizione di partenza
	 * @param dest posizione di arrivo
	 */
	static public Direzione verso(Coordinate src, Coordinate dest) {
		final int dx = dest.getX()-src.getX();
		final int dy = dest.getY()-src.getY();
		
		if (dx!=0) return ( dx>0 ? EST : OVEST );
		if (dy!=0) return ( dy>0 ? SUD : NORD  );
		return ( dx==0 && dy==0 ? null : Direzione.casuale() );
	}
	
	
	public int getDx() {
		return this.dx;
	}

	public int getDy() {
		return this.dy;
	}
	
	/**
	 * @return la direzione opposta alla presente
	 */
	public abstract Direzione opposta();


}
