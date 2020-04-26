package main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
    List<AirlineNode> vertices = new ArrayList();

        Scanner nodes = new Scanner(new FileReader("src\\resources\\airports.txt"));
        Scanner edges = new Scanner(new FileReader("src\\resources\\routes.txt"));

        addVertices(nodes, vertices);

        AdjacencyGraph adjacency = new AdjacencyGraph(vertices);

        addEdges(edges, adjacency, vertices);

        adjacency.toString();
    }

   public static void addVertices(Scanner sc, List<AirlineNode> vertices) {
        while (sc.hasNextLine()) {
            String airport = sc.nextLine();
            String[] nodeData = airport.split(";");

            vertices.add(new AirlineNode(nodeData[0], nodeData[1], nodeData[2], nodeData[3]));
        }
    }

    public static void addEdges(Scanner sc, Graph graph, List<AirlineNode> vertices) {
        while (sc.hasNextLine()) {
            String routes = sc.nextLine();
            String[] nodeData = routes.split(";");

            String airline_code = nodeData[0];
            String from = nodeData[1];
            String to = nodeData[2];
            double distance = Double.parseDouble(nodeData[3]);
            double time = Double.parseDouble(nodeData[4]);

            AirlineNode fromNode = new AirlineNode();
            AirlineNode toNode = new AirlineNode();

            for (AirlineNode n : vertices) {
                if (n.getCode().equals(from)) {
                    fromNode = n;
                }

                if (n.getCode().equals(to)) {
                    toNode = n;
                }
            }

            graph.addEdge(fromNode, toNode, airline_code, distance, time);
        }
    }

}
