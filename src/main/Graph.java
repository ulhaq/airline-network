package main;

public interface Graph {
    // Get number of nodes
    int getV();

    // Get number of edges
    int getE();

    // Get adjacients
    Iterable<AirlineNode> adjacients(AirlineNode node);

    // Add edge
    void addEdge(AirlineNode from, AirlineNode to, String airline_code, double distance, double time);
}