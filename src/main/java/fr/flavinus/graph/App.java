package fr.flavinus.graph;

public class App 
{
    public static void main( String[] args )
    {
        Graph graph = Samples.sample2();

        graph.findPath(11, 0);
        // Found path for 11 to 0 : 11 6 0
        // ok
        
        graph.findPath(11, 1);        
        // Found path for 11 to 1 : 11 6 0 1

        //graph.delLink(0, 1);
    }
}
