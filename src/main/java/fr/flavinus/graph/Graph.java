package fr.flavinus.graph;

import java.util.*;

// Graph non orienté
// Les liens sont doublement représentés (tampis pour la mémoire, ca couterait trop de ne pas l'avoir pour les recherches de chemins)
public class Graph {

	protected HashMap<Integer, HashSet<Integer>> nodes = new HashMap<>();

	public Graph(int n) {
		for (int i = 0; i < n; i++) addNode(i);
	}

	public void addNode(int index) {
		nodes.put(index, new HashSet<>());
	}

	public void addLink(int n1, int n2) {
		nodes.get(n1).add(n2);
		nodes.get(n2).add(n1);
	}

	public void delLink(int n1, int n2) {
		nodes.get(n1).remove(n2);
		nodes.get(n2).remove(n1);
	}

	public boolean hasLink(int n1, int n2) {
		return nodes.get(n1).contains(n2);// || nodes.get(n1).contains(n2)
	}

	public ArrayList<Integer> findPath(int start, int target) {
		return findPath(start, target, new HashSet<>());
	}

	private ArrayList<Integer> findPath(int current, int target,  HashSet<Integer> known) {
		ArrayList<Integer> path = null;
		if(current == target) {
			path = new ArrayList<Integer>();
			path.add(current);
		} else if(!known.contains(current)) {
			known.add(current);
			for (int child : nodes.get(current)) {
				ArrayList<Integer> tmp = findPath(child, target, new HashSet<Integer>(known));
				if(tmp != null) {
					tmp.add(0, current);
					if(path == null || tmp.size() < path.size()) {
						path = tmp;
					}							
				}
			}
		}
		return path;
	}
}
