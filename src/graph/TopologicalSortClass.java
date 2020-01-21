package graph;

import java.util.*;

public class TopologicalSortClass<T> extends AdjacencyGraph<T> implements TopologicalSort<T> {

    Stack<T> sort;
    private int noOfNodes;
    private int noOfEdges;
    private Hashtable<T,Set<T>> adjacencyList = new Hashtable<T, Set<T>>();
    private HashMap<T, Integer> nodeReferenceCount = new HashMap<T, Integer>(); //Creates a hashmap to store the reference count of all the nodes
    public List<T> traversalList = new ArrayList<>();

    public void createReferenceCounting() throws GraphError{
        for (T givenNode: getNodes()){
            nodeReferenceCount.put(givenNode, 0); //Get the neighbours for the nodes and put them in the hashmap
        }
        for (T givenNode: getNodes()){
            for (T neighbourNode: getNeighbours(givenNode)){
                increaseReferenceCount(neighbourNode); //Increase the reference count of the node if it has any successors.
            }
        }
    }

    private void increaseReferenceCount(T neighbourNode){
        Integer nodeCount = nodeReferenceCount.get(neighbourNode);
            if (nodeCount == null){
                nodeCount = 1;
            }
            else {
                nodeCount ++; //Increment the count if the count is not already 0
            }
            nodeReferenceCount.put(neighbourNode, nodeCount);
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

    public static void main(String[] args) throws GraphError {
        TopologicalSortClass<Integer> tsg = new TopologicalSortClass<Integer>();
        for (int i = 0; i < 6; i++){
            tsg.add(i);
        }
        tsg.add(0,1);
        tsg.add(1,2);
        tsg.add(2,3);
        tsg.add(0,2);
        tsg.add(4,5);
        tsg.add(3,5);

    }
}
