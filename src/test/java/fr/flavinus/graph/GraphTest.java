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
        //tmp = graph.findPath(0, 0); // TODO: choose beavior => null ?
        //assertNull(tmp);

        // Small not connexe graph
        graph = Samples.sampleSmallNotConnexe();

        tmp = graph.findPath(0, 2);
        assertNotNull(tmp);
        assertEquals(3, tmp.size());

        tmp = graph.findPath(3, 5);
        assertNotNull(tmp);
        assertEquals(3, tmp.size());

        tmp = graph.findPath(1, 5);
        assertNull(tmp);

        // name
        graph = Samples.sample2();

        tmp = graph.findPath(11, 0);
        assertNotNull(tmp);
        tmp.stream().forEach(i -> {System.out.println(i);}); 
        assertEquals(3, tmp.size());

        tmp = graph.findPath(11, 1);     
        assertNotNull(tmp);
        tmp.stream().forEach(i -> {System.out.println(i);}); 
        assertEquals(4, tmp.size());
    }
}
