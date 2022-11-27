package fr.flavinus.graph;

import java.util.*;

// Graph is not oriented
// Linls are represented twice (better while searching paths)
public class Graph {

	protected HashMap<Integer, HashSet<Integer>> nodes = new HashMap<>();
	protected ArrayList<Integer> exits = new ArrayList<>();

	public Graph(int n) {
		for (int i = 0; i < n; i++) addNode(i);
	}

	public void addNode(int index) {
		nodes.put(index, new HashSet<>());
	}

	public Graph addLink(int n1, int n2) {
		nodes.get(n1).add(n2);
		nodes.get(n2).add(n1);
		return this;
	}

	public void delLink(int n1, int n2) {
		nodes.get(n1).remove(n2);
		nodes.get(n2).remove(n1);
	}

	public Graph addExit(int i) {
		exits.add(i);
		return this;
	}

	public boolean hasLink(int n1, int n2) {
		return nodes.get(n1).contains(n2);
	}

	public boolean isExit(int n) {
		return exits.contains(n);
	}

	public ArrayList<Integer> getPathToNearestExit(int start) {

		HashMap<Integer, Integer> distances = getDistances(start);

		// find nearest exit (index of min)
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

	public ArrayList<Integer> getShorterPath(int start, int end) {
		HashMap<Integer, Integer> distances = getDistances(start);
		return getShorterPath(start, end, distances);
	}

	private ArrayList<Integer> getShorterPath(int start, int end, HashMap<Integer, Integer> distances) {

		ArrayList<Integer> path = new ArrayList<>();

		if(distances.containsKey(end)) {
			path.add(end);			
			int current = end;
			int currentDist= distances.get(end);
			
			while(currentDist > 0) {
				int next = -1;// bof
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
		}
		return path;
	}

	// BFS: eval distances of all reachable nodes
	private HashMap<Integer, Integer> getDistances(int start) {

		HashMap<Integer, Integer> distances = new HashMap<>();
		LinkedList<Integer> queue = new LinkedList<>();

		distances.put(start, 0);
		queue.add(start);

		while(!queue.isEmpty()) {
			int current = queue.poll();			
			for (int child : nodes.get(current)) {
				if(distances.containsKey(child)) continue;
				distances.put(child, distances.get(current) + 1);
				queue.add(child);
			}
		}
		return distances;
	}
}