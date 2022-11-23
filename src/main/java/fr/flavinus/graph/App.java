package fr.flavinus.graph;

public class App 
{
    public static void main( String[] args )
    {
        Graph graph = Samples.sample2();

        System.out.println(GraphRenderer.render(graph));

        graph.findPath(11, 0);
        // Found path for 11 to 0 : 11 6 0
        // ok
        
        graph.findPath(11, 1);        
        // Found path for 11 to 1 : 11 6 7 8 9 0 1
        // not the best

        //graph.delLink(0, 1);
    }
}
