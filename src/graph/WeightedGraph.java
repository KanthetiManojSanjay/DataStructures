package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

/**
 * @author kansanja on 04/04/24.
 */

class PairW {
    int dist;
    int node;

    public PairW(int d, int n) {
        dist = d;
        node = n;
    }

    @Override
    public String toString() {
        return "PairW{" +
                "dist=" + dist +
                ", node=" + node +
                '}';
    }
}

public class WeightedGraph {
    int V;
    List<PairW> adjList[];

    public WeightedGraph(int V) {
        this.V = V;
        this.adjList = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    void addEdge(int u, int v, int wt) {
        adjList[u].add(new PairW(wt, v));
        adjList[v].add(new PairW(wt, u));
    }

    @Override
    public String toString() {
        return "WeightedGraph{" +
                "V=" + V +
                ", adjList=" + Arrays.deepToString(adjList) +
                '}';
    }

    // Shortest path in weighted graph(SSSP - Single Source Shortest Path).
    // Dijkstra's Algorithm - It is a greedy algorithm to find the shortest path from source node
    // to all other nodes in weighted graph. It works only for positive weights.
    // It uses minHeap to identify the minimum weight edge from the active edges.
    // Time Complexity - O(E logV)
    void dijkstras(int src) {

        TreeSet<PairW> set = new TreeSet<>((PairW p1, PairW p2) -> (p1.dist - p2.dist));
        int dist[] = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;
        set.add(new PairW(0, src));

        while (!set.isEmpty()) {
            PairW p = set.pollFirst();
            int cnode = p.node;
            int cdist = dist[cnode];

            for (PairW nbrP : adjList[cnode]) {
                int nbr = nbrP.node;
                int edge = nbrP.dist;
                if (cdist + edge < dist[nbr]) {
                    // remove existing pair if exists. Even if the pair doesnt exist it is not going to have any affect
                    set.remove(new PairW(dist[nbr], nbr));
                    // calc new shortest dist and update dist array
                    dist[nbr] = cdist + edge;
                    // Add the updated node pair to set
                    set.add(new PairW(dist[nbr], nbr));

                }
            }
        }
        System.out.println(Arrays.toString(dist));
    }

    /*
        MSP - Minimum Spanning Tree
        Incase of Connected weighted undirected graph we need to find subset of edges such that graph is connected and sum of weights of edges is minimum
     */

    /*Kruskal's Algorithm
        1. Sort all edges in non-decreasing order of their weight.
        2. Pick the smallest edge. Check if it forms a cycle with the spanning tree formed so far using Disjoint Set Union(DSU).If cycle is not formed, include this edge. Else, discard it.
        3. Repeat step#2 until there are (V-1) edges in the

    Prims Algorithm
        Start from any node and identify the active edges from the node and pick the edge with minimum weight and add it to MST.
        Now we have 2 nodes in MST and we need to identify the active edges from these 2 nodes and pick the edge with minimum weight and add it to MST.
        Repeat this process until all nodes are included in MST. We can use MinHeap to identify the minimum weight edge from the active edges.
    * */

    /**
     * SSSP - Single Source Shortest Path
     * 1. BFS - Unweighted Graph
     * 2. Dijkstra's Algorithm - It is a greedy algorithm to find the shortest path from source node to all other nodes in weighted graph. It works only for positive weights.
     * 3. Bellman-Ford Algorithm - It is a dynamic programming algorithm to find the shortest path from source node to all other nodes in weighted graph. It works for both positive and negative weights.
     * <p>
     * APSP - All Pair Shortest Path
     * 1. Floyd-Warshall Algorithm - It is a dynamic programming algorithm to find the shortest path from all nodes to all other nodes in weighted graph. It works for both positive and negative weights.
     *
     */

    public static void main(String[] args) {
        WeightedGraph g = new WeightedGraph(6);
        g.addEdge(0, 1, 4);
        g.addEdge(0, 2, 5);
        g.addEdge(1, 3, 9);
        g.addEdge(1, 4, 7);
        g.addEdge(2, 4, 3);
        g.addEdge(3, 5, 2);
        g.addEdge(3, 4, 13);
        g.addEdge(4, 5, 6);

        g.dijkstras(0);
    }
}
