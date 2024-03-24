package graph;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author kansanja on 10/03/24.
 */
public class Graph {
    int V;
    List<Integer> adjList[];

    public Graph(int V) {
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


    // Implementation of BFS
    void BFS(int src, int dest) {
        boolean visited[] = new boolean[V];
        int parent[] = new int[V];
        int dist[] = new int[V];
        LinkedList<Integer> queue = new LinkedList<>();

        parent[src] = -1;
        dist[src] = 0;
        queue.addLast(src);
        visited[src] = true;

        while (!queue.isEmpty()) {
            int node = queue.removeFirst();
            System.out.println(node);
            Iterator<Integer> it = adjList[node].listIterator();
            while (it.hasNext()) {
                int nbr = it.next();
                if (!visited[nbr]) {
                    visited[nbr] = true;
                    parent[nbr] = node; // To store the nodes for shortest path from source to destination
                    dist[nbr] = 1 + dist[node]; // To identify distance from source(shortest path from source)
                    queue.addLast(nbr);
                }
            }
        }

        // To display the distance of each Node from source
        for (int i = 0; i < V; i++) {
            System.out.println("Node " + i + " Dist " + dist[i]);
        }

        // To display the shortest path nodes
        int temp = dest;
        while (temp != -1) {
            System.out.println(temp);
            temp=parent[temp];
        }
    }
}
