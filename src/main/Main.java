package main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
       static List<AirlineNode> vertices = new ArrayList();
    public static void main(String[] args) throws FileNotFoundException {

        Scanner nodes = new Scanner(new FileReader("src\\resources\\airports.txt"));
        Scanner edges = new Scanner(new FileReader("src\\resources\\routes.txt"));

        addVertices(nodes);

        AdjacenyGraph adjaceny = new AdjacenyGraph(vertices);

        addEdges(edges, adjaceny);

        adjaceny.toString();
    }
    static List<AirlineNode> addVertices(Scanner sc){
        while (sc.hasNextLine()) {
            String airport = sc.nextLine();
            String[] nodeData = airport.split(";");

            vertices.add(new AirlineNode(nodeData[0], nodeData[1], nodeData[2], nodeData[3]));
        }
        return vertices;
    }
    static void addEdges(Scanner sc, Graph graph){
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

            for(AirlineNode n: vertices){
                if(n.getCode().equals(from)){
                    fromNode = n;
                }
            }

            for(AirlineNode n: vertices){
                if(n.getCode().equals(to)){
                    toNode = n;
                }
            }

            graph.addEdge(fromNode, toNode, airline_code, distance, time);
        }
    }
}
