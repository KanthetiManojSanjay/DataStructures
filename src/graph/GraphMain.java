package graph;

/**
 * @author kansanja on 10/03/24.
 */
public class GraphMain {
    public static void main(String[] args) {
/*        GraphUsingEdgeList edgeList = new GraphUsingEdgeList(4);

        edgeList.addEdge(0, 1, 10);
        edgeList.addEdge(0, 2, 20);
        edgeList.addEdge(1, 2, 30);
        edgeList.addEdge(2, 0, 40);
        edgeList.addEdge(2, 3, 50);
        edgeList.addEdge(3, 3, 60);

        System.out.println(edgeList);*/

/*        GraphUsingAdjacencyMatrix adjacencyMatrix = new GraphUsingAdjacencyMatrix(4);
        adjacencyMatrix.addEdge(1, 2);
        adjacencyMatrix.addEdge(0, 3);
        adjacencyMatrix.addEdge(1, 3);
        adjacencyMatrix.addEdge(2, 3);

        System.out.println(adjacencyMatrix);*/

   /*     GraphusingAdjacencyList adjacencyList = new GraphusingAdjacencyList(4);
        adjacencyList.addEdge(1, 2, true);
        adjacencyList.addEdge(0, 3, true);
        adjacencyList.addEdge(1, 3, true);
        adjacencyList.addEdge(2, 3, true);

        System.out.println(adjacencyList);*/


       /* Graph g = new Graph(7);
        g.addEdge(0, 1, true);
        g.addEdge(0, 2, true);
        g.addEdge(2, 3, true);
        g.addEdge(3, 6, true);
        g.addEdge(2, 4, true);
        g.addEdge(4, 6, true);
        g.addEdge(1, 4, true);
        g.addEdge(4, 5, true);

        System.out.println(g);

        //g.BFS(0,5);
        //g.DFS(0);
        if (g.detectCycle(0)) {
            System.out.println("yes there is a cycle");
        } else {
            System.out.println("there is no cycle");
        }
*/


        Graph g = new Graph(3);
        g.addEdge(0, 1, false);
        g.addEdge(1, 2, false);
        g.addEdge(2, 0, false);

        if(g.detectCycle_DirectedGraph(0)){
            System.out.println("yes there is a cycle");
        }else{
            System.out.println("there is no cycle");
        }
    }
}
