package main;

public interface Graph {
    // Get number of nodes
    int getV();

    // Get number of edges
    int getE();

    // Get adjacents
    Iterable<AirlineNode> adjacents(AirlineNode node);

    // Add edge
    void addEdge(AirlineNode from, AirlineNode to, String airline_code, double distance, double time);
}