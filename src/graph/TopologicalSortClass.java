package graph;

import java.util.*;

public class TopologicalSortClass<T> extends AdjacencyGraph<T> implements TopologicalSort<T> {

    Stack<T> sort;
    private int noOfNodes;
    private int noOfEdges;
    private Hashtable<T,Set<T>> adjacencyList = new Hashtable<T, Set<T>>();
    public List<T> traversalList = new ArrayList<>();

    public void getSuccessors(T node) throws GraphError{
    }

    public Set<T> getNeighbours(T node) throws GraphError{
        Set<T> a = new HashSet<T>(); //Create a new hashset to store the nodes in
        for (T nodes: adjacencyList.get(node)){ //For all the nodes currently in the adjacency list
            a.add(nodes); //Add the current node to the hashset of neighbours.
        }
        return a; //Return the hashset of neighbours
    }
    @Override
    public List<T> getSort() throws GraphError {
        return null;
    }

    public int getNumberOfEdges (){ //Return the number of edges
        return noOfEdges;
    }

    public int getNumberOfNodes (){ //Return the number of nodes
        return noOfNodes;
    }
}
