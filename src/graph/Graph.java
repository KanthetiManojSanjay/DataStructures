package graph;

import java.util.*;

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


    // Implementation of BFS - TimeComplexity is O(V+E)
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
            temp = parent[temp];
        }
    }

    // DFS implementation
    void DFS(int src) {
        boolean visited[] = new boolean[V];
        DFSHelper(src, visited);

    }

    void DFSHelper(int node, boolean visited[]) {
        System.out.println(node);
        visited[node] = true;
        Iterator<Integer> it = adjList[node].listIterator();
        while (it.hasNext()) {
            int nbr = it.next();
            if (!visited[nbr]) {
                DFSHelper(nbr, visited);
            }
        }
    }


    // Cycle detection in undirected graph using DFS
    boolean detectCycle(int src) {
        boolean visited[] = new boolean[V];
        return detectCycleHelper(src, visited, -1);
    }

    boolean detectCycleHelper(int node, boolean[] visited, int parent) {
        visited[node] = true;
        Iterator<Integer> it = adjList[node].listIterator();
        while (it.hasNext()) {
            int nbr = it.next();
            //recursive case
            if (!visited[nbr]) {
                boolean cycleFound = detectCycleHelper(nbr, visited, node);
                if (cycleFound) {
                    return true;
                }
            }
            // detecting the backedge (base case)
            else if (nbr != parent) {
                return true;
            }
        }
        return false;
    }


    // Cycle detection in directed graph using DFS
    boolean detectCycle_DirectedGraph(int src) {
        boolean visited[] = new boolean[V];
        boolean stack[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (detectCycle_DirectedGraphHelper(i, visited, stack)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean detectCycle_DirectedGraphHelper(int node, boolean[] visited, boolean[] stack) {
        //arrive at node
        visited[node] = true;
        stack[node] = true;

        // do some work at node, return true if backedge is found
        Iterator<Integer> it = adjList[node].listIterator();
        while (it.hasNext()) {
            int nbr = it.next();
            if (stack[nbr]) {
                return true;
            } else if (!visited[nbr]) {
                boolean cycleFound = detectCycle_DirectedGraphHelper(nbr, visited, stack);
                if (cycleFound) {
                    return true;
                }
            }
        }
        //going back
        stack[node] = false;
        return false;
    }

    // Topological sort using DFS
    List<Integer> topologicalSort() {
        boolean visited[] = new boolean[V];
        Arrays.fill(visited, false);
        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topologicalSortHelper(i, visited, output);
            }
        }
        Collections.reverse(output);
        return output;
    }

    void topologicalSortHelper(int node, boolean[] visited, List<Integer> output) {
        //mark the node as visited
        visited[node] = true;

        //traverse the non visited nbr recursively
        Iterator<Integer> it = adjList[node].listIterator();
        while (it.hasNext()) {
            int nbr = it.next();
            //recursive case
            if (!visited[nbr]) {
                topologicalSortHelper(nbr, visited, output);
            }
        }
        output.add(node);
    }

    // kahn's algorithm(Modified BFS) for topological sort
    List<Integer> topologicalSortBFS() {
        int indegree[] = new int[V];
        Arrays.fill(indegree, 0);

        LinkedList<Integer> queue = new LinkedList<>();
        List<Integer> output = new ArrayList<>();

        // update the indegree array
        for (int i = 0; i < V; i++) {
            Iterator<Integer> it = adjList[i].listIterator();
            while (it.hasNext()) {
                int nbr = it.next();
                indegree[nbr]++;
            }
        }

        // traverse indegree and add nodes with 0 indegree to queue
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            output.add(node);
            Iterator<Integer> it = adjList[node].listIterator();
            while (it.hasNext()) {
                int nbr = it.next();
                indegree[nbr]--;
                if (indegree[nbr] == 0) {
                    queue.add(nbr);
                }
            }
        }
        return output;
    }



}
