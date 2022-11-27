package fr.flavinus.graph;

public class App 
{
    public static void main( String[] args )
    {
        Graph graph = Samples.sample2();

        graph.getShorterPath(11, 0);

        graph.getShorterPath(11, 1);        

    }
}
