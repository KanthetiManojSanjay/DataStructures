package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author kansanja on 10/03/24.
 * <p>
 * Adv:
 * 1) Effiicent storage - As we only store the value of the edges in linked list hence efficient even for sparse graph(Graph with less edges)
 * 2) Efficient retrival of neighbours - used widely in BFS, DFS traversal
 */
public class GraphusingAdjacencyList {

    int V;

    // Array of linkedlist. we can use this representation if vertex are 0, 1, 2 .. as array implicitly has index starting from 0
    // but if they are String or anything complex then we can use HashMap with key as vertex and value as List of neighbouring vertex
    List<Integer> adjList[];

    public GraphusingAdjacencyList(int V) {
        this.V = V;
        this.adjList = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // this method has boolean field to signify if it is directed or undirected graph
    void addEdge(int u, int v, boolean undirected) {
        adjList[u].add(v);
        // If edge is undirected then do bidirection mapping
        if (undirected) {
            adjList[v].add(u);
        }
    }

    @Override
    public String toString() {
        return "GraphusingAdjacencyList{" +
                "V=" + V +
                ", adjList=" + Arrays.deepToString(adjList) +
                '}';
    }
}
