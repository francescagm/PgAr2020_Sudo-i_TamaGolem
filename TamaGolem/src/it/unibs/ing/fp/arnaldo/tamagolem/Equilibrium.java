package it.unibs.ing.fp.arnaldo.tamagolem;
import java.util.*;

public class Equilibrium {
	
	private static final int N = 6; //oppure far scegliere all'utente il numero di elementi (tra 3 e 10)
	private Graph equilibrio=newEquilibrium();
	public static int getN() {
		return N;
	}

	//private static int equilibrium[][] = new int[N][N]; // usare elements id come indici

	/*
	 * Creates a randomly generated node
	 */
	private static Node generateRandomNode() {
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
			while(objList.size()<Math.floor(N/2)) {
				Node newNode = generateRandomNode();
				
				if (!(newNode.keyNode().equals(nodo.keyNode()))) {
						objList.add(newNode);
				}
				//Checks if there are any duplicates
				objList = removeDuplicates(objList);
			}
			//Unidirectionality
			if(!newAdjacentList.keySet().equals(null))
				objList = unidirectionalityControl(newAdjacentList, objList, nodo);
			
			/*Should balance the sum
			 * for (Node node : newAdjacentList.keySet()) {
					int sumA = 0;
					int sumB = 0;
					for (int l=0;l<newAdjacentList.get(node).size();l++) {
						sumA += newAdjacentList.get(node).get(l).getWeight();
					}
					for (Node nu : newAdjacentList.keySet()) {
						for (int k=0;k<newAdjacentList.get(nu).size();k++) {
						if (node.keyNode().equals(newAdjacentList.get(nu).get(k).keyNode()) && !(node.keyNode().equals(nu.keyNode()))) {
								sumB += newAdjacentList.get(nu).get(k).getWeight();
							}
						}

					}
					
					//Codice inutilizzabile, please fix
					if (sumA>sumB) {
							//Riadattare il punteggio
						}
						
					if (sumA<sumB && newAdjacentList.get(node).size()>0) {
							//Aggiungere i punti mancanti
						}
					}
			 */
			//After all the controls the final products are put inside the map and the cycle repeats
			newAdjacentList.put(nodo, objList);
			}
			//Fundamental rule of balance : The sum of the damage dealt is equal to the damage received
		return new Graph(newAdjacentList);
	}
	
	/*
	 * Uses a node as a pivot, and checks whether it appears in the others' list
	 */
	private List<Node> unidirectionalityControl(Map<Node, List<Node>> newAdjacentList, List<Node> objList, Node nodo) {
		for (Node node : newAdjacentList.keySet()) {
			for (int k=0;k<newAdjacentList.get(node).size();k++) {
				if (newAdjacentList.get(node).get(k).keyNode().equals(nodo.keyNode())) {
					for (int l=0;l<objList.size();l++) {
						if (objList.get(l).keyNode().equals(node.keyNode()))
							objList.remove(l);
					}
				}
			}
		}
		return objList;
	}
	
	/*
	 * Scans the current list in order to find any duplicate
	 */
	private List<Node> removeDuplicates(List<Node> objList) {
		for (int k=0;k<objList.size();k++) {
			for (int l=0;l<(objList.size()-1) && l!=k;l++)
				try {
				if (objList.get(k).keyNode().equals(objList.get(l).keyNode())) {
					objList.remove(k);
				}
			} catch (IndexOutOfBoundsException e) {}
		}
		return objList;
	}
	
	public Graph getGraph() {
		return equilibrio;
	}


}
