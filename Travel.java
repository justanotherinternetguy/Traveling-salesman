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
        getWeight(adjacencyList, 1, 2);

        // bruteForce(adjacencyList, 1);
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

    static int getWeight(Map<Integer, List<Edge>> adjacencyList, int i, int j) {
        Edge e = adjacencyList.get(i).get(j-i-1);
        System.out.println(e.weight);
        return e.weight;
    }
    
    static void bruteForce(Map<Integer, List<Edge>> adjacencyList, int start) {
        int n = adjacencyList.size() - 1;
        int countPossiblePaths = factorial(n);
        int shortestDist = Integer.MAX_VALUE;
        int[][] allPossiblePaths = new int[countPossiblePaths][5];
    }

    static int factorial(int n) {
        int factorial = 1;
        for(int i = 1; i <= n; ++i)
        {
            factorial *= i;
        }
        return factorial;
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

