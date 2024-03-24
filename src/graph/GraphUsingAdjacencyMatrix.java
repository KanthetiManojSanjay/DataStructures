package graph;

import java.util.Arrays;

/**
 * @author kansanja on 10/03/24.
 */
public class GraphUsingAdjacencyMatrix {
    int V;
    boolean adjMatrix[][];

    GraphUsingAdjacencyMatrix(int V) {
        this.V = V;
        this.adjMatrix = new boolean[V][V];
    }

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
