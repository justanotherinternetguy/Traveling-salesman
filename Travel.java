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

        System.out.println("BRUTE FORCE: ");
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

    static int getWeight(Map<Integer, List<Edge>> adjacencyList, int i, int j) {
        Edge e;
        if (j < i) {
            int temp = i;
            i = j;
            j = temp;
        }
        else if (j == i) System.err.println("BRUH MOMENT");
        e = adjacencyList.get(i).get(j-i-1);
        return e.weight;
    }
    
    static void bruteForce(Map<Integer, List<Edge>> adjacencyList, int start) {
        int n = adjacencyList.size();
        int shortestDist = Integer.MAX_VALUE;
        int[] arr = {2, 3, 4};

        ArrayList<int[]> allPossiblePaths = new ArrayList<>();

        permute(arr, 0, allPossiblePaths);

        // now that we have all the possible paths, we can just start summing up the path lengths (remember to close off)
        for (int i = 0; i < allPossiblePaths.size(); i++) {
            int currDist = 0;
            int prev = 1;
            for (int j = 0; j < allPossiblePaths.get(i).length; j++) {
                currDist += (getWeight(adjacencyList, prev, allPossiblePaths.get(i)[j]));
                prev = allPossiblePaths.get(i)[j];
            }
            currDist += getWeight(adjacencyList, prev, 1);
            System.out.println(currDist);
        }
    }
    static void permute(int[] arr, int start, ArrayList<int[]> permutations) {
        if (start == arr.length - 1) {
            // Add the current permutation to the list
            permutations.add(arr.clone());
        } else {
            for (int i = start; i < arr.length; i++) {
                // Swap the current element with the next element
                swap(arr, start, i);
                // Recursively generate permutations for the remaining elements
                permute(arr, start + 1, permutations);
                // Swap back the elements to restore the original array
                swap(arr, start, i);
            }
        }
    }
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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

