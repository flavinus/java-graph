package fr.flavinus.graph;

public class Samples {
	

	
	public static Graph empty() {
        return new Graph(0);
	}

	public static Graph sample1() {
        
        Graph graph = new Graph(4);
                
		graph.addLink(1, 3);
		graph.addLink(2, 3);
		graph.addLink(0, 2);
		graph.addLink(0, 1);
 
        return graph;
	}

	public static Graph sampleSmallNotConnexe() {
        
        Graph graph = new Graph(6);
                
		graph.addLink(0, 1);
		graph.addLink(1, 2);

		graph.addLink(3, 4);
		graph.addLink(4, 5);
 
        return graph;
	}

	// Samples from
	// https://www.codingame.com/ide/puzzle/death-first-search-episode-1
	public static Graph sample2() {
        
        Graph graph = new Graph(12);
                
		graph.addLink(11, 6);
		graph.addLink(0, 9);
		graph.addLink(1, 2);
		graph.addLink(0, 1);
		graph.addLink(10, 1);
		graph.addLink(11, 5);
		graph.addLink(2, 3);
		graph.addLink(4, 5);
		graph.addLink(8, 9);
		graph.addLink(6, 7);
		graph.addLink(7, 8);
		graph.addLink(0, 6);
		graph.addLink(3, 4);
		graph.addLink(0, 2);
		graph.addLink(11, 7);
		graph.addLink(0, 8);
		graph.addLink(0, 4);
		graph.addLink(9, 10);
		graph.addLink(0, 5);
		graph.addLink(0, 7);
		graph.addLink(0, 3);
		graph.addLink(0, 10);
		graph.addLink(5, 6);
 
        return graph;
	}

		
/* Triple étoile
 * 
Add link 28 to 36
Add link 0 to 2
Add link 3 to 34
Add link 29 to 21
Add link 37 to 35
Add link 28 to 32
Add link 0 to 10
Add link 37 to 2
Add link 4 to 5
Add link 13 to 14
Add link 34 to 35
Add link 27 to 19
Add link 28 to 34
Add link 30 to 31
Add link 18 to 26
Add link 0 to 9
Add link 7 to 8
Add link 18 to 24
Add link 18 to 23
Add link 0 to 5
Add link 16 to 17
Add link 29 to 30
Add link 10 to 11
Add link 0 to 12
Add link 15 to 16
Add link 0 to 11
Add link 0 to 17
Add link 18 to 22
Add link 23 to 24
Add link 0 to 7
Add link 35 to 23
Add link 22 to 23
Add link 1 to 2
Add link 0 to 13
Add link 18 to 27
Add link 25 to 26
Add link 32 to 33
Add link 28 to 31
Add link 24 to 25
Add link 28 to 35
Add link 21 to 22
Add link 4 to 33
Add link 28 to 29
Add link 36 to 22
Add link 18 to 25
Add link 37 to 23
Add link 18 to 21
Add link 5 to 6
Add link 19 to 20
Add link 0 to 14
Add link 35 to 36
Add link 9 to 10
Add link 0 to 6
Add link 20 to 21
Add link 0 to 3
Add link 33 to 34
Add link 14 to 15
Add link 28 to 33
Add link 11 to 12
Add link 12 to 13
Add link 17 to 1
Add link 18 to 19
Add link 36 to 29
Add link 0 to 4
Add link 0 to 15
Add link 0 to 1
Add link 18 to 20
Add link 2 to 3
Add link 0 to 16
Add link 8 to 9
Add link 0 to 8
Add link 26 to 27
Add link 28 to 30
Add link 3 to 4
Add link 31 to 32
Add link 6 to 7
Add link 37 to 1
Add link 37 to 24
Add link 35 to 2
Add exit 0
Add exit 18
Add exit 28
*/	
}
