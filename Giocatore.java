import java.util.InputMismatchException;
import java.util.Scanner;

public class Giocatore {


    private String nomeGiocatore; 
    private int ficheIniziali; 
    private int fichesPuntata;


    public Giocatore() {
    	
    }

	public String getNomeGiocatore() {
		return nomeGiocatore;
	}


	public void setNomeGiocatore(String nomeGiocatore) {
		this.nomeGiocatore = nomeGiocatore;
	}


	public int getFicheIniziali() {
		return ficheIniziali;
	}


	public void setFicheIniziali(int ficheIniziali) {
		this.ficheIniziali = ficheIniziali;
	}


	public int getFichesPuntata() {
		return fichesPuntata;
	}


	public void setFichesPuntata(int fichesPuntata) {
		this.fichesPuntata = fichesPuntata;
	}

    

















// incapsulamento nome e fisch disponibili 
/* // Il giocatore non potrà puntare più di quante fiches possiede: se ne ha 10, puntandone 20,
un messaggio lo avvertirà che la sua puntata è stata modificata alla sua disponibilità
massima (10 fiches). */


}