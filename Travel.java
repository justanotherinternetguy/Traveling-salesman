import java.io.*;
import java.util.*;

public class Travel {
    public static void main(String[] args) {
        Map<Integer, List<Edge>> adjacencyList = new HashMap<>();
        // Home = 1, Aldo = 2, Butch = 3, Cassidy = 4

        int numVertices = 4;
        for (int i = 1; i <= numVertices; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }

        adjacencyList.get(1).add(new Edge(2, 6));
        adjacencyList.get(1).add(new Edge(3, 12));
        adjacencyList.get(1).add(new Edge(4, 5));

        adjacencyList.get(2).add(new Edge(3, 8));
        adjacencyList.get(2).add(new Edge(4, 9));

        adjacencyList.get(3).add(new Edge(4, 13));

        // display(adjacencyList);
        // getDist(adjacencyList, 2, 4);
        bruteForce(adjacencyList, 1);
    }

    static void display(Map<Integer, List<Edge>> adjacencyList) {
        for (int vertex : adjacencyList.keySet()) {
            System.out.print(vertex + ": ");
            for (Edge edge : adjacencyList.get(vertex)) {
                System.out.print("(" + edge.destination + ", " + edge.weight + ") ");
            }
            System.out.println();
        }
    }

    static void getDist(Map<Integer, List<Edge>> adjacencyList, int i, int j) {
        Edge e = adjacencyList.get(i).get(j-i-1);
        System.out.println(e.weight);
    }
    
    static void bruteForce(Map<Integer, List<Edge>> adjacencyList, int start) {
        int len = 9999999;
    }
}

public class Edge {
    int destination;
    int weight;

    public Edge(int destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}

public class WeightedGraph {
    private Map<Integer, List<Edge>> adjacencyList;

    public WeightedGraph() {
        adjacencyList = new HashMap<>();
    }

    public void addVertex(int vertex) {
        adjacencyList.put(vertex, new ArrayList<>());
    }

    public void addEdge(int source, int destination, int weight) {
        Edge edge = new Edge(destination, weight);
        adjacencyList.get(source).add(edge);
    }

    public List<Edge> getEdges(int vertex) {
        return adjacencyList.get(vertex);
    }

    public int getWeight(int source, int destination) {
        List<Edge> edges = adjacencyList.get(source);
        for (Edge edge : edges) {
            if (edge.destination == destination) {
                return edge.weight;
            }
        }
        return -1;
    }
}

