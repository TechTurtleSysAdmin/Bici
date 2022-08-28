package bici.sim;

import static bici.sim.CostantiSimulazione.DURATA_SIMULAZIONE;
import static bici.sim.CostantiSimulazione.NUMERO_BICI_PER_TIPOLOGIA;
import static bici.sim.CostantiSimulazione.RITMO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.SwingUtilities;

import bici.gui.GUI;
import bici.stats.Statistiche;
import bici.tipo.Bianca;
import bici.tipo.Bici;
import bici.tipo.Gialla;

public class Simulatore {

	final private Zona zona;

	final private List<Bici> bici;

	private int passo;

	private GUI gui;
	
	volatile boolean fineTerminazioneRichiesta;
	
	public Simulatore() {
		this.zona = new Zona();
		this.passo = 0;
		this.bici = new ArrayList<>();
		creaBiciclette();
		this.fineTerminazioneRichiesta = false;
	}

	private void creaBiciclette() {
		/* DA AGGIORNARE (VEDI DOMANDA 2) */
		for(int i=0; i<NUMERO_BICI_PER_TIPOLOGIA; i++) {
			this.bici.add(creaBianca());
			this.bici.add(creaGialla());
		}
	}
	
	public Bianca creaBianca() {
		return new Bianca(this.getZona());
	}
	
	public Gialla creaGialla() {
		return new Gialla(this.getZona());
	}


	public List<Bici> getBiciclette() {
		return this.bici;
	}

	public void setGUI(GUI gui) {
		this.gui = gui;
	}

	public Zona getZona() {
		return this.zona;
	}

	public int getPasso() {
		return this.passo;
	}

	public void simula() {

		for(this.passo=0; this.passo<DURATA_SIMULAZIONE; this.passo++) {

			eseguiPassoDellaSimulazione();

			aggiornaStatistiche();

			pausa();
			
			if (fineSimulazioneRichiesta()) {
				System.out.println("Simulazione interrotta al passo "+passo);
				System.out.println();
				break;
			}
		}
		

		/* VEDI DOMANDA 6 */
		
		System.out.println("Simulazione terminata.");
		
		/**
		 * Termina la simulazione corrente stampando le statistiche finali
		 */
		new Statistiche().stampaFinale(this.getZona());

		terminaSimulazioneBrutalmente();
	}

	private boolean fineSimulazioneRichiesta() {
		return this.fineTerminazioneRichiesta;
	}

	private void eseguiPassoDellaSimulazione() {
		Collections.shuffle(this.bici);
		/* DA CAMBIARE ( VEDI DOMANDA 2 )*/
		for(Bici bici : this.bici) {
			bici.simula(this.getPasso());
		}
	}

	private void aggiornaStatistiche() {
		/* stampa passo simulazione */
		this.gui.riportaNelTitolo(this.passo, this.getZona());
	}

	private void pausa() {
		try {
			this.updateGui();
			Thread.sleep(RITMO);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void updateGui() {
		SwingUtilities.invokeLater( new Runnable() {			
			@Override
			public void run() {
				Simulatore.this.gui.repaint();
			}
		});
	}

	/**
	 * Termina la simulazione corrente arrestando l'intera JVM!!!
	 */
	public void terminaSimulazioneBrutalmente() {
		System.exit(-1);
	}

	public void richiediTerminazione() {
		this.fineTerminazioneRichiesta = true;
	}
	
}
