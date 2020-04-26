package main;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyGraph implements Graph {
    List<AirlineNode> vertices;
    List<AirlineEdge> edges;

    public AdjacencyGraph(List<AirlineNode> vertices) {
        this.vertices = vertices;
        this.edges = new ArrayList<>();
    }

    @Override
    public int getV() {
        return this.vertices.size();
    }

    @Override
    public int getE() {
        return this.edges.size();
    }

    @Override
    public Iterable<AirlineNode> adjacents(AirlineNode node) {
        List<AirlineNode> adjacients = new ArrayList<AirlineNode>();

        for (AirlineEdge edge : this.edges) { // O(n)
            if (node.getCode() == edge.getFrom().getCode() || node.getCode() == edge.getTo().getCode()) {
                adjacients.add(node); // O(1)
            }
        }

        return adjacients;
    }

    @Override
    public void addEdge(AirlineNode from, AirlineNode to, String airline_code, double distance, double time) {
        boolean result = this.edges.add(new AirlineEdge(from, to, distance, time, airline_code));

        if (result) {
            System.out.println("Added edge: " + from.getCode() + " -> " + to.getCode());
        } else {
            System.out.println("Could not add the edge");
        }
    }

    @Override
    public String toString() {
        return "main.AdjacenyGraph{" +
                "vertices=" + vertices +
                ", edges=" + edges +
                '}';
    }
}