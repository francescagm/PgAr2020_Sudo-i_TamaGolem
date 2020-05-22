package it.unibs.ing.fp.arnaldo.tamagolem;

import java.util.HashMap;
import java.util.Map;

public class Battle {
	
	private static Player playerOne;
	private static Player playerTwo;
	
	private static final int P = (int) (Math.ceil(2*Player.getMaxGolems()*Golem.getMaxRocks()/Equilibrium.getN()) * Equilibrium.getN());
	
	private static Map<ElementRock, Integer> disposableRocks = new HashMap<ElementRock, Integer>();
	
	private static void setDisposableRocks() {
		int rockNumberEachType = P / Equilibrium.getN();
		for (Elements elem : Elements.values()) {
			disposableRocks.put(new ElementRock(elem), rockNumberEachType);
		}
	}
	
	public static boolean areThereStillRocks() {
		
		boolean empthy = true;
		for (ElementRock rock : disposableRocks.keySet()) {
			if (disposableRocks.get(rock) > 0) {
				empthy = false;
				break;
			}
		}
		
		return !empthy;
	}
	
	public static void battle() {
		
		Utility.battleIntro();
		
		setDisposableRocks();
		Golem golemOne = playerOne.evocateGolem();
		Golem golemTwo = playerTwo.evocateGolem();
		while (!playerOne.isDefeated() && !playerTwo.isDefeated() && areThereStillRocks()) {
			
			while (!golemOne.isDead() && !golemTwo.isDead()) {
				ElementRock rockOne = golemOne.throwRock();
				ElementRock rockTwo = golemTwo.throwRock();
				int result = Equilibrium.calculateInteraction(rockOne, rockTwo);
				if (result < 0) {
					golemOne.setLife(golemOne.getLife() + result);
				} else {
					golemTwo.setLife(golemTwo.getLife() - result);
				}
			}
			
			if (golemOne.isDead()) { // sono sicuro che non muoiono mai contemporaneamente
				golemOne = playerOne.evocateGolem();
			} else {
				golemTwo = playerTwo.evocateGolem();
			}
			
			if (!areThereStillRocks()) {
				Utility.finishedRocks();
				return;
			}
			
			if (playerOne.isDefeated()) {
				Utility.winner(playerTwo);
			} else {
				Utility.winner(playerOne);
			}
		}
	}

	public static Map<ElementRock, Integer> getDisposableRocks() {
		return disposableRocks;
	}

	public static void setDisposableRocks(Map<ElementRock, Integer> disposableRocks) {
		Battle.disposableRocks = disposableRocks;
	}

	public static int getP() {
		return P;
	}
	
	

}
