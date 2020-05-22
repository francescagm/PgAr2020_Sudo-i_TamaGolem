package it.unibs.ing.fp.arnaldo.tamagolem;

public class GoleMain {

	public static void main(String[] args) {
		
		Golem.initializeMaxRocks();
		
		Player.initializeMaxGolems();
		
		Battle.initializeRockStock();

		do {
			Equilibrium.newEquilibrium();
			Battle.battle();
		} while (Utility.newPlay());

	}

}
