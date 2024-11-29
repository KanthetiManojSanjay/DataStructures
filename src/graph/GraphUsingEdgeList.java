package graph;

import java.util.LinkedList;
import java.util.List;

/**
 * @author kansanja on 10/03/24.
 * Adv of edgeList
 * 1) incase of weighted graph then we sort the edgeList in O(ELogE) and then pick edges based on weight
 * this can be helpful if we are building minimum spanning tree algo

 * This is not efficient bcz
 * 1) lets say if we have to check if there is any edge then we have to do linear search to identify
 * 2) Similarly if we need to identify neighbours of a vertex then also we need to check the complete edgeList to identify which takes O(E)
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
