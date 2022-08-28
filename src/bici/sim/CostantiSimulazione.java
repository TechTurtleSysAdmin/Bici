package bici.sim;

public class CostantiSimulazione {

	/**
	 * La {@link Zona} è un quadrato di queste dimensioni (incluso i bordi)
	 */
	static final public int DIMENSIONE = 30;

	/**
	 * Numero di formiche per ogni tipologia
	 */
	static final public int NUMERO_BICI_PER_TIPOLOGIA = 3;

	/**
	 * Durata (in passi) totale della simulazione
	 */
	static final public int DURATA_SIMULAZIONE = 500;

	/**
	 * Pausa (in millisecondi) tra due passi consecutivi della simulazione
	 */
	static final public int RITMO  = 25; // millis

	/**
	 * Il numero totale di destinazioni coperte
	 */
	static final public int N_DESTINAZIONI = 3;

}
