package main;


import java.util.ArrayList;
import java.util.List;

public class BreadthFirstSearch {
    private final Graph graph;
    private List<AirlineNode> visitedFrom;
    private Queue<AirlineEdge> edges;

    public BreadthFirstSearch(Graph graph) {
        this.graph = graph;
        this.visitedFrom = new ArrayList<>();
        for(AirlineNode v : visitedFrom){
            v.setVisited(false);
        }
        this.edges = new ArrayQueue<>(70_000);
    }

public void register(AirlineEdge edge){
    edges.enqueue(edge);
}


}
