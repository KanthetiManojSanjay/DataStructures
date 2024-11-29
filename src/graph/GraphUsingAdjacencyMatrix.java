package graph;

import java.util.Arrays;

/**
 * @author kansanja on 10/03/24.
 * <p>
 * Disdavantage:
 * 1) As the no of vertex(V) increases the matrix becomes larger V*V so not possible to be held by memory
 * 2) Even if we used it for small number of vertex/nodes but if there are no edges between most of the vertex then lot of memory is wasted
 * 3) Identifying the neighbours of a vertex is also a disadv bcz we need to traverse O(V)
 * <p>
 * Adv: Incase if we need to check if an edge is present or not then in O(1) we can identify that
 * <p>
 * If the graph is a weighted graph we then instead of boolean matrix we can create integer matrix and store weights in it
 */
public class GraphUsingAdjacencyMatrix {
    int V;
    boolean adjMatrix[][];

    GraphUsingAdjacencyMatrix(int V) {
        this.V = V;
        this.adjMatrix = new boolean[V][V];
    }

    // As it is an undirected graph so bidirection mapping is done b/w source & destination vertex
    void addEdge(int u, int v) {
        adjMatrix[u][v] = true;
        adjMatrix[v][u] = true;
    }

    @Override
    public String toString() {
        return "GraphUsingAdjacencyMatrix{" +
                "V=" + V +
                ", adjMatrix=" + Arrays.deepToString(adjMatrix) +
                '}';
    }
}
