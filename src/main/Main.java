package main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        List<AirlineNode> vertices = new ArrayList();
        List<AirlineEdge> edges = new ArrayList<>();

        Scanner sc = new Scanner(new FileReader("src\\resources\\airports_test.txt"));

        while (sc.hasNextLine()) {
            String airport = sc.nextLine();
            String[] nodeData = airport.split(";");

            vertices.add(new AirlineNode(nodeData[0], nodeData[1], nodeData[2], nodeData[3]));
        }

        AdjacenyGraph adjaceny = new AdjacenyGraph(vertices, edges);

        adjaceny.toString();
    }
}
