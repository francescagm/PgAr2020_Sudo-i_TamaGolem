package it.unibs.ing.fp.arnaldo.tamagolem;

import java.util.ArrayList;
import java.util.Map;

public class Golem {
	
	private boolean dead = false;

	ArrayList<ElementRock> rocks = new ArrayList<ElementRock>();
	
	private static final int MAX_ROCKS = (int) (Math.ceil((Equilibrium.getN() + 1) / 3) + 1);
	
	private int life = 10;
	
	private int rockThrown = 0;
	
	public boolean isDead() {
		return dead;
		
	}
	
	public ElementRock throwRock() {
		
		if (rockThrown == rocks.size()) {
			rockThrown = 0;
		}
		
		rockThrown++;
		
		Utility.throwRockIntro(rockThrown - 1);
		
		return rocks.get(rockThrown - 1);
		
	}
	
	public void addRocks() {
		
		Utility.addRocksIntro();
		
		Map<ElementRock, Integer> map = Battle.getDisposableRocks();
		
		if (Battle.areThereStillRocks()) {
			for (int i = 0; i < MAX_ROCKS; i++) {
				ElementRock rock = Utility.chooseRock();
				if (map.get(rock) > 0) {
					rocks.add(rock);
					map.replace(rock, map.get(rock) - 1);
				} else {
					i--;
					Utility.chooseAnotherRock();
				}
			} 
		} else {
			return;
		}
		
		Battle.setDisposableRocks(map);
	}

	public int getLife() {
		return this.life;
	}

	public void setLife(int life) {
		this.life = life;
		if (life <= 0) dead = true;
	}

	public static int getMaxRocks() {
		return MAX_ROCKS;
	}
}
