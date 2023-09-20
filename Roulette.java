import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Roulette {

    int[] rosso = {1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36};
    int[] nero = {2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35};
    
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String nomeGiocatore;
    int fichesIniz;
    int fichesPuntate;
    int sceltaRitiro;

    public void play() throws IOException, InterruptedException {

        System.out.println("Inserire il nome giocatore: ");
        
        nomeGiocatore = reader.readLine();
        if (nomeGiocatore.length() < 2 ) {
        	System.out.println("il nome deve essere almeno di 2 lettere");
        	play();
        }
        
        while (true) {
            System.out.println("Inserire la quantità di soldi da cambiare: ");
            try {
                fichesIniz = Integer.parseInt(reader.readLine());
                if (fichesIniz < 1)
                	System.out.println("Il numero di fiches da cambiare deve essere maggiore di zero");
                else 
                	break;
                
            } catch (NumberFormatException excone) {
                System.out.println("Input immesso non compatibile, devi inserire un numero!");
            }
        }

        while (true) {
            System.out.println("Quante fiches vuoi puntare ? ");
            try {
                fichesPuntate = Integer.parseInt(reader.readLine());
                break;
            } catch (NumberFormatException exctwo) {
                System.out.println("Input immesso non compatibile, devi inserire un numero!");
            }
        }
        
        Giocatore myGiocatore = new Giocatore(nomeGiocatore,fichesIniz,fichesPuntate);

        if (myGiocatore.getFichesPuntata() > myGiocatore.getFicheIniziali()) {
            
        	myGiocatore.setFichesPuntata(myGiocatore.getFicheIniziali());
            System.out.println("Hai puntato più fiches di quelle che possiedi.");
            System.out.println("La puntata è stata modificata alla tua disponibilità di fiches.");
        }

        
        boolean ancora = true;

        while (ancora) {
            System.out.println("Che tipo di giocata vuoi effettuare?");
            System.out.println("1.Rosso o Nero (si vince il doppio della puntata)");
            System.out.println("2.Pari o Dispari (si vince il doppio della puntata)");
            System.out.println("3.Numero Secco (si vince 36 volte la puntata)");

            int scelta;
            try {
                scelta = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException exctwo) {
                System.out.println("Input immesso non compatibile");
                continue;
            }

            
            switch (scelta) {
            
                case 1:
                	int sceltaRossoNero;
                	
                	while (true) {
                        System.out.println("Digita 1 per scegliere nero, 2 per scegliere rosso ");
                        try {
                            sceltaRossoNero = Integer.parseInt(reader.readLine());
                            
                            if (sceltaRossoNero != 1 && sceltaRossoNero != 2) 
                            	System.out.println("Numero immesso diverso da quelli proposti");
                            else 
                            	break;
   		
                        } catch (NumberFormatException exc) {
                            System.out.println("Input immesso non compatibile, devi inserire un numero!");
                        }
                    }
 
                    System.out.println("Giocata in corso...");
                    Thread.sleep(1000);
                    int risultatoNumeroSecco = (int) (Math.random() * 37);
                    System.out.println("Il numero uscito è : " + risultatoNumeroSecco);

                    if (sceltaRossoNero == 2) {

                        boolean isRosso = false;
                        for (int i = 0; i < rosso.length; i++) {
                            if (rosso[i] == risultatoNumeroSecco) {
                                isRosso = true;
                                break;
                            }
                        }

                        if (isRosso) {
                            System.out.println("È uscito rosso!");
                            System.out.println("Hai vinto " + myGiocatore.getNomeGiocatore());
                            myGiocatore.setFicheIniziali(myGiocatore.getFicheIniziali()+ myGiocatore.getFichesPuntata());
                            System.out.println(myGiocatore.getNomeGiocatore() + " Adesso hai: " + myGiocatore.getFicheIniziali() + " fiches");
                        } else {
                            System.out.println("È uscito nero!");
                            System.out.println("Hai perso " + myGiocatore.getNomeGiocatore());
                            myGiocatore.setFicheIniziali(myGiocatore.getFicheIniziali()- myGiocatore.getFichesPuntata());
                            System.out.println(myGiocatore.getNomeGiocatore() + " Adesso hai: " + myGiocatore.getFicheIniziali() + " fiches");
                        }
                    } else if (sceltaRossoNero == 1) {

                        boolean isNero = false;
                        for (int i = 0; i < nero.length; i++) {
                            if (nero[i] == risultatoNumeroSecco) {
                                isNero = true;
                                break;
                            }
                        }

                        if (isNero) {
                            System.out.println("È uscito nero!");
                            System.out.println("Hai vinto " + myGiocatore.getNomeGiocatore());
                            myGiocatore.setFicheIniziali(myGiocatore.getFicheIniziali()+ myGiocatore.getFichesPuntata());
                            System.out.println(myGiocatore.getNomeGiocatore() + " adesso hai: " + myGiocatore.getFicheIniziali() + " fiches");

                        } else {
                            System.out.println("È uscito rosso!");
                            System.out.println("Hai perso " + myGiocatore.getNomeGiocatore());
                            myGiocatore.setFicheIniziali(myGiocatore.getFicheIniziali()- myGiocatore.getFichesPuntata());
                            System.out.println(myGiocatore.getNomeGiocatore() + " adesso hai: " + myGiocatore.getFicheIniziali() + " fiches");
                        }
                    } 
                    break;

                case 2:
                	int sceltaPariDispari;
                	
                	while (true) {
                        System.out.println("Digita 1 per scegliere pari, 2 per scegliere dispari ");
                        try {
                        	sceltaPariDispari= Integer.parseInt(reader.readLine());
                        	
                            if (sceltaPariDispari != 1 && sceltaPariDispari != 2)
                            	System.out.println("Numero immesso diverso da quelli proposti");
                            else 
                            	break;
   		
                        } catch (NumberFormatException exc) {
                            System.out.println("Input immesso non compatibile, devi inserire un numero!");
                        }
                    }
                	
                    
                    System.out.println("Giocata in corso...");
                    Thread.sleep(1000);
                    risultatoNumeroSecco = (int) (Math.random() * 37);
                    System.out.println("Il numero uscito è : " + risultatoNumeroSecco);

                    if (risultatoNumeroSecco % 2 == 0 && sceltaPariDispari == 1) {
                        System.out.println("È uscito pari!");
                        System.out.println("Hai vinto " + myGiocatore.getNomeGiocatore());
                        myGiocatore.setFicheIniziali(myGiocatore.getFicheIniziali()+ myGiocatore.getFichesPuntata());
                        System.out.println(myGiocatore.getNomeGiocatore() + " Adesso hai: " + myGiocatore.getFicheIniziali() + " fiches");

                    } else if (risultatoNumeroSecco % 2 != 0 && sceltaPariDispari == 2) {
                        System.out.println("È uscito dispari!");
                        System.out.println("Hai vinto " + myGiocatore.getNomeGiocatore());
                        myGiocatore.setFicheIniziali(myGiocatore.getFicheIniziali()+ myGiocatore.getFichesPuntata());
                        System.out.println(myGiocatore.getNomeGiocatore() + " Adesso hai: " + myGiocatore.getFicheIniziali() + " fiches");
                    } else if (risultatoNumeroSecco == 0 ) {
                        System.out.println("Hai perso " + myGiocatore.getNomeGiocatore());
                        myGiocatore.setFicheIniziali(myGiocatore.getFicheIniziali()- myGiocatore.getFichesPuntata());
                        System.out.println(myGiocatore.getNomeGiocatore() + " Adesso hai: " + myGiocatore.getFicheIniziali() + " fiches");
                    } else {
                    	System.out.println("Hai perso " + myGiocatore.getNomeGiocatore());
                    	myGiocatore.setFicheIniziali(myGiocatore.getFicheIniziali()- myGiocatore.getFichesPuntata());
                        System.out.println(myGiocatore.getNomeGiocatore() + " Adesso hai: " + myGiocatore.getFicheIniziali() + " fiches");
                    }
                    break;

                case 3:
                    int sceltaNumeroSecco = 0;

                    while (true) {
                        System.out.println("Scegli un numero compreso tra 1 e 36");
                        try {
                            sceltaNumeroSecco = Integer.parseInt(reader.readLine());
                            break;
                        } catch (NumberFormatException excthree) {
                            System.out.println("Input immesso non compatibile");
                        }
                    }

                    System.out.println("Giocata in corso...");
                    Thread.sleep(1000);
                    risultatoNumeroSecco = (int) (Math.random() * 37);

                    if (sceltaNumeroSecco == risultatoNumeroSecco) {
                        System.out.println("Numero uscito: " + risultatoNumeroSecco);
                        System.out.println("Hai vinto " + myGiocatore.getNomeGiocatore());
                        myGiocatore.setFicheIniziali(myGiocatore.getFicheIniziali()- myGiocatore.getFichesPuntata() + (myGiocatore.getFichesPuntata() * 36));
                        System.out.println(myGiocatore.getNomeGiocatore() + " Adesso hai: " + myGiocatore.getFicheIniziali() + " fiches");
                    } else if (sceltaNumeroSecco > 36 || sceltaNumeroSecco < 1) {
                        System.out.println("Non puoi scommettere su questi numeri!");
                    } else {
                        System.out.println("Numero uscito: " + risultatoNumeroSecco);
                        System.out.println("Hai perso " + myGiocatore.getNomeGiocatore());
                        myGiocatore.setFicheIniziali(myGiocatore.getFicheIniziali()- myGiocatore.getFichesPuntata());
                        System.out.println(myGiocatore.getNomeGiocatore() + " Adesso hai: " + myGiocatore.getFicheIniziali() + " fiches");
                    }
                    break;

                default:
                    System.out.println("Scelta inserita non valida");
            }
            
            if (myGiocatore.getFicheIniziali() <= 0) {
            	System.out.println("Game Over, non ti sono rimaste piu fiches!");
            	System.out.println("Spegnimento in corso...");
            	System.exit(0);
            	
            }

            System.out.println("Premi 1 per ritirarti o 2 per continuare");
            try {
                sceltaRitiro = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException excthree) {
                System.out.println("Input immesso non compatibile");
                continue;
            }

            if (sceltaRitiro == 1) {
                System.out.println("Hai scelto di ritirarti");
                System.out.println("Il tuo saldo totale in fiches è: " + myGiocatore.getFicheIniziali() + " fiches");
                System.out.println("che corrisponde a: " + myGiocatore.getFicheIniziali() + " euro");
                System.out.println("Passa dalla cassa per ritirare le vincite");
                System.exit(0);
                ancora = false;
            } else {
                ancora = true;
            }
        }
    }
}

