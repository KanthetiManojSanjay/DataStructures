package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author kansanja on 10/03/24.
 */
public class GraphusingAdjacencyList {
    int V;
    List<Integer> adjList[];

    public GraphusingAdjacencyList(int V) {
        this.V = V;
        this.adjList = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    void addEdge(int u, int v, boolean undirected) {
        adjList[u].add(v);
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
