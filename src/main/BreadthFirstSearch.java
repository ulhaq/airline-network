package main;

import java.util.ArrayList;
import java.util.List;

public class BreadthFirstSearch {
    private final Graph graph;
    private List<AirlineNode> visitedFrom;
    private Queue<AirlineEdge> edges;

    public BreadthFirstSearch(Graph graph, List<AirlineNode> visitedFrom) {
        this.graph = graph;
        this.visitedFrom = visitedFrom;

        for (AirlineNode v : visitedFrom) {
            v.setVisited(false);
        }

        this.edges = new ArrayQueue<>(70_000);
    }

    public void register(AirlineEdge edge) {
        AirlineNode n = new AirlineNode();
        for (AirlineNode node : visitedFrom) {
            if (edge.getTo() == node) {
                n = node;
                break;
            }
        }

        //if edge already is registered, do nothing.
        if (n.equals(edge.getTo())) {
            return;
        }

        edges.enqueue(edge);
    }

    public List<AirlineNode> searchFrom(AirlineNode fromNode, AirlineNode toNode) {
        List<AirlineEdge> e = edges(fromNode);
        for (AirlineEdge edge : e) {
            register(edge);
        }

        List<AirlineNode> rsNode = new ArrayList<>();
        while (!e.isEmpty()) {
            for (AirlineEdge edge : edges) {
                if (!toNode.equals(edge.getTo())) {
                    edges.dequeue();
                    System.out.println("Dequeued");
                } else {
                    System.out.println("ToNode founded");
                    rsNode.add(edge.getTo());
                }
            }
        }

        return rsNode;
    }

    public List<AirlineEdge> edges(AirlineNode node) {
        List<AirlineEdge> nodeEdges = new ArrayList<AirlineEdge>();
        for (AirlineEdge edge : edges) {
            if (edge.getFrom().equals(node.getCode())) {
                nodeEdges.add(edge);
            }
        }

        return nodeEdges;
    }
}
