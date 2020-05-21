package it.unibs.ing.fp.arnaldo.tamagolem;
import java.util.*;

public class Equilibrium {
	
	private static final int N = 5;// oppure far scegliere all'utente il numero di elementi (tra 3 e 10)
	private Graph equilibrio=newEquilibrium();
	public static int getN() {
		return N;
	}

	//private static int equilibrium[][] = new int[N][N]; // usare elements id come indici

	/*
	 * Creates a randomly generated node
	 */
	public static Node generateRandomNode() {
		Random rand = new Random();
		
		int casualRock = rand.nextInt(N);
		int power = rand.nextInt(3) + 1;
		
		return new Node(Elements.values()[casualRock].toString(),power);	
	}
	/*
	 * Generates the random equilibirum of the game at the beginning of it
	 * @return Graph: the graph that maps out the balance of the game
	 */
	private Graph newEquilibrium() {
		Map<Node,List<Node>> newAdjacentList = new HashMap<>();
		
		//Starts by creating in an orderly manner the various key nodes
		for (int i=0;i<N;i++) {
			List<Node> objList= new LinkedList<>();
			Node nodo = new Node(Elements.values()[i].toString(),0);
			
			/*
			 * This is the part where the value of the map is put in place, which
			 * is a list of nodes, and checks that the List has correct values
			 */
			while(objList.size()<3) {
				Node newNode = generateRandomNode();
				
				if (!(newNode.keyNode().equals(nodo.keyNode()))) {
						objList.add(newNode);
				}
				//Checks if there are any duplicates
				for (int k=0;k<objList.size();k++) {
					for (int l=0;l<objList.size()-1 && k!=l;l++)
						if (objList.get(k).keyNode().equals(objList.get(l).keyNode())) {
							objList.remove(k);
						}
					}
					
			}
			//After all the controls the final products are put inside the map and the cycle repeats
			newAdjacentList.put(nodo, objList);
		}
		
		return new Graph(newAdjacentList);
	}
	
	public Graph getGraph() {
		return equilibrio;
	}


}
