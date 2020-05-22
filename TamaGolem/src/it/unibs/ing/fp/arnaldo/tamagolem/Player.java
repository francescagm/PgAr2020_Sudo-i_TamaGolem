package it.unibs.ing.fp.arnaldo.tamagolem;

public class Player {
	
	private static final int MAX_GOLEMS = (int) Math.ceil((Equilibrium.getN() - 1)*(Equilibrium.getN() - 2)/(2 * Battle.getP()));
	
	private String name;
	private boolean defeated = false;
	private int evocatedGolems = 0;
	private Golem myGolem;
	
	
	public boolean isDefeated() {
		return defeated;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDefeated(boolean defeated) {
		this.defeated = defeated;
	}

	public Golem evocateGolem() {
		
		Utility.evocateGolemIntro();
		
		while (evocatedGolems < MAX_GOLEMS) {
			myGolem = new Golem();
			myGolem.addRocks();
			evocatedGolems++;
		}
		if (evocatedGolems == MAX_GOLEMS) setDefeated(true);
		return myGolem;
		
	}

	public static int getMaxGolems() {
		return MAX_GOLEMS;
	}
	
	

}
