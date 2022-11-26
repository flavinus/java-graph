package fr.flavinus.graph;

import java.util.*;

// Graph non orienté
// Les liens sont doublement représentés (tampis pour la mémoire, ca couterait trop de ne pas l'avoir pour les recherches de chemins)
public class Graph {

	protected HashMap<Integer, HashSet<Integer>> nodes = new HashMap<>();
	protected ArrayList<Integer> exits = new ArrayList<>();

	public Graph(int n) {
		for (int i = 0; i < n; i++) addNode(i);
	}

	public Graph addNode(int index) {
		nodes.put(index, new HashSet<>());
		return this;
	}

	public Graph addLink(int n1, int n2) {
		nodes.get(n1).add(n2);
		nodes.get(n2).add(n1);
		return this;
	}

	public Graph delLink(int n1, int n2) {
		nodes.get(n1).remove(n2);
		nodes.get(n2).remove(n1);
		return this;
	}

	public Graph addExit(int i) {
		exits.add(i);
		return this;
	}

	public boolean hasLink(int n1, int n2) {
		return nodes.get(n1).contains(n2);
	}

	public int countLinks(int n) {
		return nodes.get(n).size();
	}

	public boolean isExit(int n) {
		return exits.contains(n);
	}

	public ArrayList<Integer> getPathToNearestExit(int start) {

		HashMap<Integer, Integer> distances = getDistances(start);

		// find nearest exit
		int exit = start;
		int exitDist = Integer.MAX_VALUE;
		for (int e : exits) {
			Integer dist = distances.get(e);
			if(dist != null && dist < exitDist) {
				exit = e;
				exitDist = dist;
			}
		}

		return getShorterPath(start, exit, distances);
	}

	public ArrayList<Integer> findPath(int start, int end) {
		return getShorterPath(start, end, getDistances(start));
	}

	public ArrayList<Integer> getShorterPath(int start, int end, HashMap<Integer, Integer> distances) {

		if(!distances.containsKey(end)) return null;

		int current = end;
		int currentDist= distances.get(end);

		ArrayList<Integer> path = new ArrayList<>();
		path.add(current);
		while(currentDist > 0) {
			int next = -1;
			int nextDist = currentDist;
			for (int child : nodes.get(current)) {
				if(distances.get(child) < nextDist) {
					next = child;
					nextDist = distances.get(child);
				}
			}
			path.add(0, next);
			current = next;
			currentDist = nextDist;
		}
		return path;
	}

	// eval distances of all reachable nodes
	public HashMap<Integer, Integer> getDistances(int start) {

		HashMap<Integer, Integer> distances = new HashMap<>();
		distances.put(start, 0);

		ArrayList<Integer> queue = new ArrayList<>();
		queue.add(start);

		while(!queue.isEmpty()) {
			// TODO: look for better pile
			// get last and remove it from queue
			Integer current = queue.get(queue.size() - 1);
			queue.remove(queue.size() - 1);

			for (int child : nodes.get(current)) {
				if(distances.containsKey(child)) continue;
				distances.put(child, distances.get(current) + 1);
				queue.add(child);
			}
		}
		return distances;
	}
}