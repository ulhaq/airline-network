package main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static main.Main.addEdges;
import static main.Main.addVertices;

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

    public static void main(String[] args) throws FileNotFoundException {
        Scanner nodes = new Scanner(new FileReader("src\\resources\\airports_test.txt"));
        Scanner edges = new Scanner(new FileReader("src\\resources\\test.txt"));
        List<AirlineNode> vertices = new ArrayList();

        addVertices(nodes, vertices);

        Graph adjacency = new AdjacencyGraph(vertices);

        addEdges(edges, adjacency, vertices);
        BreadthFirstSearch bfs = new BreadthFirstSearch(adjacency, vertices);

        bfs.searchFrom(vertices.get(0), vertices.get(1));
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

    public void searchFrom(AirlineNode fromNode, AirlineNode toNode) {
        register(new AirlineEdge(fromNode, fromNode, 0, 0, fromNode.getCode())); //to enter the queue

//        List<AirlineEdge> e = edges(fromNode);
//        for (AirlineEdge edge : e) {
//            register(edge);
//        }

        while (!edges.isEmpty()) {
            for (AirlineEdge edge : edges) {
                AirlineEdge step = edges.dequeue();
                System.out.println("Dequeued");


                Iterable<AirlineNode> nodes = graph.adjacents(fromNode);

                for (AirlineNode node : nodes) {
                    register(new AirlineEdge(node, edge.getTo(), edge.getDistance(), edge.getTime(), edge.getAirline_code()));
//                    System.out.println("A route from " + fromNode.getCode() + " to " + toNode.getCode() + "");
                }
            }
//            System.out.println("ToNode not founded");
        }
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
