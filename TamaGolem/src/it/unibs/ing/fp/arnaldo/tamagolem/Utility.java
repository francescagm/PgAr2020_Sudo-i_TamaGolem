package it.unibs.ing.fp.arnaldo.tamagolem;

import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;

public class Utility {

	public static ElementRock chooseRock() {
		System.out.println("Scegli una roccia fra quelle disponibili.\n");
		Battle.printDisposableRocks();
		String voci[] = Elements.getElementsArray();
		MyMenu menu = new MyMenu("Digita il numero corrispondente alla roccia da scegliere", voci);
		int chosen = -1;
		do {
			chosen = menu.scegli();
		} while (chosen == 0);
		return new ElementRock(Elements.getElement(chosen - 1));
	}

	public static void chooseAnotherRock() { // avvisa utente che la roccia scelta non è disponibile
		System.out.println("Roccia non piu' disponibile\n");
		
	}

	public static void addRocksIntro() { // avvisa utente che sta per scegliere le rocce da dare al golem
		System.out.println("Scegli le rocce da dare al tuo TamaGolem\n");
		
	}

	public static void evocateGolemIntro() { // avvisa utente che sta per evocare un golem
		System.out.println("Evoca un nuovo TamaGolem:\n");
		
	}

	public static void battleIntro() { // avvisa utenti che stanno per iniziare una partita
		System.out.println("Sta per iniziare una nuova battaglia!\n");
		
	}

	public static void throwRockIntro(ElementRock elementRock, Player player) { // avvisa utente che sta per lanciare una roccia
		System.out.println(player.getName() + " lancia una roccia di tipo " + elementRock.toString().toUpperCase());
		
	}

	public static void finishedRocks() { // avvisa che le rocce a disposizione sono finite
		System.out.println("Le rocce presenti nella scorta sono terminate\n");
		
	}

	public static void winner(Player player) { // stampa il vincitore
		System.out.println(player.getName() + " ha vinto la partita!\n");
		
	}

	public static boolean newPlay() {
		return InputDati.yesOrNo("Vuoi fare un'altra partita? ");
	}

	public static void setPlayer(Player player) { // fa aggiungere un nome al giocatore
		player.setName(InputDati.leggiStringa("Inserisci il nome del giocatore: "));
		
	}

	public static void printDemage(int result, ElementRock rockOne, ElementRock rockTwo) {
		if (result < 0) {
			System.out.println(rockTwo.toString() + " infligge " + Math.abs(result) + " danni a " + rockOne.toString());
		} else {
			System.out.println(rockOne.toString() + " infligge " + Math.abs(result) + " danni a " + rockTwo.toString());
		}
	}

	public static void printStatus(Player playerOne, Player playerTwo) {
		System.out.println(playerOne.getName() + "\t-->\tVita TamaGolem: " + playerOne.getMyGolem().getLife());
		System.out.println(playerTwo.getName() + "\t-->\tVita TamaGolem: " + playerTwo.getMyGolem().getLife());
	}

	// interazione con utente
}
