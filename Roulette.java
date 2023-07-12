import java.util.Scanner;
import java.util.InputMismatchException;


public class Roulette {


    int [] rosso = {1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36}; 
    int [] nero = {2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33,35};
    Scanner input = new Scanner(System.in);
    String nomeGiocator;
    int fichesIniz;
    int fichesPuntate;
    int sceltaRitiro;

    // per verificare l'incapsulamento devo partire con il nome , se il nome me lo prende ugualmente allora devo controllare
    



    public void play() {

    Giocatore myGiocatore = new Giocatore();

    System.out.println("Inserire il nome giocatore: ");  
    // quanti soldi vuoi cambiare ,una sola volta
    nomeGiocator = input.nextLine();
    myGiocatore.setNomeGiocatore(nomeGiocator); 

    /* System.out.println("Quanti soldi vuoi cambiare ? (in euro , 1 euro = 1 fiche) ");
    fichesIniz = input.nextInt();
    myGiocatore.setFicheIniziali(fichesIniz); */

    boolean booleanFichesIniziali = false;

                while (!booleanFichesIniziali) {
                    System.out.println("inserire la quantità di soldi da cambiare: ");
                    try {
                        fichesIniz = input.nextInt();
                        myGiocatore.setFicheIniziali(fichesIniz);
                        booleanFichesIniziali = true;
                    } catch (InputMismatchException excone) {
                        System.out.println("Input immesso non compatibile");
                        input.nextLine();
                    }
                }

    // posso inserire l'eccezione che se l'utente scrive il numero con euro vicino esce il messaggio 

    /* System.out.println("Quante fiches vuoi puntare ? ");
    int fichesPuntate = input.nextInt();
    myGiocatore.setFichesPuntata(fichesPuntate); */

    boolean booleanFichesPuntate = false;

    while (!booleanFichesPuntate) {
        System.out.println("Quante fiches vuoi puntare ? ");
        try {
            fichesPuntate = input.nextInt();
            myGiocatore.setFichesPuntata(fichesPuntate);
            booleanFichesPuntate = true;
        } catch (InputMismatchException exctwo) {
            System.out.println("Input immesso non compatibile");
            input.nextLine();
        }
    }

    if (fichesPuntate > fichesIniz) {
        fichesPuntate = fichesIniz;
        System.out.println("Hai puntato più fiches di quelle che possiedi.");
        System.out.println("La puntata è stata modificata alla tua disponibilità di fiches.");
    }


    // cosa vuoi fare? puntata sui numeri rossi o neri (doppio della puntata)

    

    boolean ancora = true;

    while (ancora) {

        System.out.println("Che tipo di giocata vuoi effettuare?");
        System.out.println("1.Rosso o Nero (si vince il doppio della puntata)");
        System.out.println("2.Pari o Dispari (si vince il doppio della puntata)");
        System.out.println("3.Numero Secco (si vince 36 volte la puntata)");

        int scelta = input.nextInt(); 
        input.nextLine();

        switch (scelta) {

            case 1: 
            System.out.println("Scegli tra rosso o nero");
            String sceltaRossoNero = input.nextLine();
            System.out.println("Giocata in corso...");
            int risultatoNumeroSecco = (int)(Math.random() * 37);
            System.out.println("il numero uscito è : " + risultatoNumeroSecco);

            if (sceltaRossoNero.equals("rosso")){

                boolean isRosso = false;
                for (int i = 0; i < rosso.length; i++) {
                    if (rosso[i] == risultatoNumeroSecco) {    // scansiona tutti i numeri dell'array rosso per vedere se combaciano con il numero estratto
                    isRosso = true;
                    break;
                    }
                }

                if (isRosso) {
                    System.out.println("È uscito rosso!");
                    System.out.println("Hai vinto " + myGiocatore.getNomeGiocatore());
                    fichesIniz = fichesIniz + fichesPuntate;
                    System.out.println(myGiocatore.getNomeGiocatore()+ "Adesso hai: " + fichesIniz + " fiches"); 
                } else {
                    System.out.println("È uscito nero!");
                    System.out.println("Hai perso " + myGiocatore.getNomeGiocatore());
                    fichesIniz = fichesIniz - fichesPuntate;
                    System.out.println(myGiocatore.getNomeGiocatore()+ "Adesso hai: " + fichesIniz + " fiches"); 
                }



            } else if (sceltaRossoNero.equals("nero")) {

                boolean isNero = false;
                for (int i = 0; i < nero.length; i++) {
                    if (nero[i] == risultatoNumeroSecco) {    // scansiona tutti i numeri dell'array nero per vedere se combaciano con il numero estratto
                    isNero = true;
                    break;
                    }
                }

                if (isNero) {
                    System.out.println("È uscito nero!");
                    System.out.println("Hai vinto " + myGiocatore.getNomeGiocatore());
                    fichesIniz = fichesIniz + fichesPuntate;
                    System.out.println(myGiocatore.getNomeGiocatore()+ "adesso hai: " + fichesIniz + " fiches"); 
                    
                } else {
                    System.out.println("È uscito rosso!");
                    System.out.println("Hai perso " + myGiocatore.getNomeGiocatore());
                    fichesIniz = fichesIniz - fichesPuntate;
                    System.out.println(myGiocatore.getNomeGiocatore() + "adesso hai: " + fichesIniz + " fiches"); 
                }


            } else if (!sceltaRossoNero.equals("rosso") || !sceltaRossoNero.equals("nero")) {
                System.out.println("Hai digitato male il colore rosso o nero");
            }


            break; 

            case 2: 
            System.out.println("Scegli tra dispari o pari");
            String sceltaPariDispari = input.nextLine();
            System.out.println("Giocata in corso...");
            risultatoNumeroSecco = (int)(Math.random() * 37);
            System.out.println("il numero uscito è : " + risultatoNumeroSecco);
            
            if (risultatoNumeroSecco % 2 == 0 && sceltaPariDispari.equals("pari")) {

                
                System.out.println("Risultato : " + sceltaPariDispari);
                System.out.println("Hai vinto " + myGiocatore.getNomeGiocatore());
                fichesIniz = fichesIniz + fichesPuntate;
                System.out.println(myGiocatore.getNomeGiocatore() + " Adesso hai: " + fichesIniz + " fiches");

            } else if (risultatoNumeroSecco % 2 != 0 && sceltaPariDispari.equals("dispari")) {

                
                System.out.println("Risultato : " + sceltaPariDispari);
                System.out.println("Hai vinto" + myGiocatore.getNomeGiocatore());
                fichesIniz = fichesIniz + fichesPuntate;
                System.out.println(myGiocatore.getNomeGiocatore() + "Adesso hai: " + fichesIniz + " fiches"); 


                } else if (risultatoNumeroSecco == 0 ) {

                
                System.out.println("Hai perso" + myGiocatore.getNomeGiocatore());
                fichesIniz = fichesIniz - fichesPuntate;
                System.out.println(myGiocatore.getNomeGiocatore() + "Adesso hai: " + fichesIniz + " fiches");

                } else {

                    System.out.println("Non hai scritto bene pari o dispari");

                }
            

            break; 

            case 3: 
            
            int sceltaNumeroSecco = 0;

            boolean booleanNumeroSecco = false;

            while (!booleanNumeroSecco) {
            System.out.println("Scegli un numero compreso tra 1 e 36");
            try {
            sceltaNumeroSecco = input.nextInt();
            myGiocatore.setFicheIniziali(fichesPuntate);
            booleanNumeroSecco = true;
            } catch (InputMismatchException excthree) {
            System.out.println("Input immesso non compatibile");
            input.nextLine();
            }
            }

            System.out.println("Giocata in corso...");
            risultatoNumeroSecco = (int)(Math.random() * 37);



            if ( sceltaNumeroSecco == risultatoNumeroSecco) {

                System.out.println("Numero uscito: " + risultatoNumeroSecco);
                System.out.println("Hai vinto " + myGiocatore.getNomeGiocatore());
                fichesIniz = fichesIniz - fichesPuntate + (fichesPuntate * 36);
                System.out.println(myGiocatore.getNomeGiocatore() + "Adesso hai: " + fichesIniz + " fiches");


            } else if (sceltaNumeroSecco > 36 || sceltaNumeroSecco < 1) {

                System.out.println("Non puoi scommettere su questi numeri!");


            } else  {

                System.out.println("Numero uscito: " + risultatoNumeroSecco);
                System.out.println("Hai perso " + myGiocatore.getNomeGiocatore());
                fichesIniz = fichesIniz - fichesPuntate;
                System.out.println(myGiocatore.getNomeGiocatore() + "adesso hai: " + fichesIniz + " fiches");
            }

            break; 

            default: 
            System.out.println("Scelta inserita non valida");
            

    }   

    System.out.println("Premi 1 per ritirarti o 2 per continuare");
    int sceltaRitiro = input.nextInt(); 

    if (sceltaRitiro == 1) {
        System.out.println("Hai scelto di ritirarti");
        System.out.println("Il tuo saldo totale in fiches è: " + fichesIniz + " fiches");
        System.out.println("che corrisponde a: " + fichesIniz + " euro");
        System.out.println("Passa dalla cassa per ritirare le vincite");
        ancora = false;

    } else {
        
        ancora = true;
    }

    // puntata sui numeri pari o dispari (si vince il doppio della puntata),
    // puntata su un numero secco (si vince 36 volte la puntata).
    // quando le fishe arrivano a zero finisce la partita 
    // dopo ogni giocata , hai vinto o hai perso , cosa vuoi fare? 


    /* in caso di vittoria (rispettivamente di sconfitta) il giocatore sarà aggiornato delle fiches vinte
(perse) e del nuovo totale a sua disposizione; dopo ogni giocata, a meno dell'esaurimento
delle proprie fiches, il giocatore potrà scegliere se continuare o ritirarsi, ricevendo in questo
caso un messaggio riassuntivo delle fiches in suo possesso che potrà cambiare in contate
alla cassa */



}



}

    }

