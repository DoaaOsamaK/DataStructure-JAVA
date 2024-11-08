package datastructure;

import java.util.*;

public class MyGraph {

    private Map<Integer, List<Integer>> adjList;

    // Constructor: Initializes the graph
    public MyGraph() {
        adjList = new HashMap<>();
    }

    // Adds an edge between two nodes
    public void addEdge(int src, int dest) {
        adjList.putIfAbsent(src, new ArrayList<>());
        adjList.putIfAbsent(dest, new ArrayList<>());
        adjList.get(src).add(dest);
        adjList.get(dest).add(src); // If the graph is undirected
    }

    // Returns the adjacency list
    public Map<Integer, List<Integer>> getAdjList() {
        return adjList;
    }

    // Displays the graph
    public void printGraph() {
        for (Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            for (int neighbor : entry.getValue()) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    // Returns the size of the graph (number of nodes)
    public int size() {
        return adjList.size();
    }

    // Checks if the graph contains a specific node
    public boolean containsNode(int node) {
        return adjList.containsKey(node);
    }
}
