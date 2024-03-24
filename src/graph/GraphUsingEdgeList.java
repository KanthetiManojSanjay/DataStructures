package graph;

import java.util.LinkedList;
import java.util.List;

/**
 * @author kansanja on 10/03/24.
 */

class Edge {
    int u;
    int v;
    int wt;

    Edge(int u, int v, int wt) {
        this.u = u;
        this.v = v;
        this.wt = wt;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "u=" + u +
                ", v=" + v +
                ", wt=" + wt +
                '}';
    }
}

public class GraphUsingEdgeList {

    int V;
    List<Edge> l;

    GraphUsingEdgeList(int V) {
        this.V = V;
        this.l = new LinkedList<>();
    }

    void addEdge(int u, int v, int wt) {
        l.add(new Edge(u, v, wt));
    }

    @Override
    public String toString() {
        return "GraphUsingEdgeList{" +
                "V=" + V +
                ", l=" + l +
                '}';
    }
}
