import java.util.InputMismatchException;
import java.util.Scanner;

public class Giocatore {

    Scanner input = new Scanner(System.in);

    private String nomeGiocatore; 
    private int ficheIniziali; 
    private int fichesPuntata;

    public void setNomeGiocatore(String nomeGiocatore) {
        boolean ancora = true;
        do {
            if(nomeGiocatore.length() > 1) {
                this.nomeGiocatore = nomeGiocatore;
                ancora = false;
            } else {
                System.out.println("Il nome deve essere di almeno 2 caratteri, prego ridigitare.");
                nomeGiocatore = input.nextLine();
            }
        } while(ancora);
    }

    public String getNomeGiocatore() {
        return nomeGiocatore;
    }

    public void setFicheIniziali(int ficheIniziali) {
        boolean ancora = true;
        do {
            if (ficheIniziali > 0) {
                this.ficheIniziali = ficheIniziali;
                ancora = false;
            } else {
                try {
                    System.out.println("Digita il numero di fiche iniziali corretto, maggiore di zero.");
                    ficheIniziali = input.nextInt();
                } catch (InputMismatchException exc) {
                    System.out.println("Input immesso non compatibile, reinserisci l'importo da convertire in fiches iniziali.");
                    input.nextLine(); // Consuma l'input errato
                    
                }
            }
        } while (ancora);
    }

    public int getFicheIniziali() {
        return ficheIniziali;
    }

    public void setFichesPuntata(int fichesPuntata) {

        boolean ancora = true;
        do {
            if(fichesPuntata > 0) {
                this.fichesPuntata = fichesPuntata;
                ancora = false;
            } else {
                try {
                System.out.println("Devi per forza puntare almeno una fiche.");
                fichesPuntata = input.nextInt();
            } catch (InputMismatchException exc) {
                System.out.println("Input immesso non compatibile, reinserisci l'importo da puntare.");
                input.nextLine(); // Consuma l'input errato
                fichesPuntata = input.nextInt();
            }
        }

        } while(ancora);
    }


    public int getFichesPuntata() {
        return fichesPuntata;
    }



















// incapsulamento nome e fisch disponibili 
/* // Il giocatore non potrà puntare più di quante fiches possiede: se ne ha 10, puntandone 20,
un messaggio lo avvertirà che la sua puntata è stata modificata alla sua disponibilità
massima (10 fiches). */


}