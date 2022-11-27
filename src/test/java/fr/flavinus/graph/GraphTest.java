package fr.flavinus.graph;

import java.util.ArrayList;
import junit.framework.TestCase;

public class GraphTest extends TestCase {


    public void testLinksBasic() {
        
        Graph graph = new Graph(2);

        graph.addLink(0, 1);
        assertTrue(graph.hasLink(0, 1));
        assertTrue(graph.hasLink(1, 0));

        graph.delLink(0, 1);
        assertFalse(graph.hasLink(0, 1));
        assertFalse(graph.hasLink(1, 0));

    }

    public void testFindPath() {

        ArrayList<Integer> tmp;
        Graph graph;

        //graph = Samples.empty();
        //tmp = graph.getShorterPath(0, 0); // TODO: choose beavior => null ?
        //assertEquals(0, tmp.size());

        // Small not connexe graph
        graph = Samples.sampleSmallNotConnexe();

        tmp = graph.getShorterPath(0, 2);
        assertEquals(3, tmp.size());

        tmp = graph.getShorterPath(3, 5);
        assertEquals(3, tmp.size());

        tmp = graph.getShorterPath(1, 5);
        assertEquals(0, tmp.size());

        // name
        graph = Samples.sample2();

        tmp = graph.getShorterPath(11, 0);
        assertEquals(3, tmp.size());

        tmp = graph.getShorterPath(11, 1);     
        assertEquals(4, tmp.size());
    }
}
