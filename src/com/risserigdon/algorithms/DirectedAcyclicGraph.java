package com.risserigdon.algorithms;
import java.util.ArrayList;

public class DirectedAcyclicGraph {

    private DAGNode root;

    public DirectedAcyclicGraph(String rootName){
        root = new DAGNode(rootName);
    } 

    /**
     * Add an edge from {@code source} to {@code destination} and return
     * {@code true} if the edge is added as a result of this function. If
     * either {@code source} or {@code destination} does not exist, create
     * them before adding the edge.
     * @param source the name of the source node
     * @param destination the name of the destination edge
     * @return {@code true} if the edge is added as a result of this 
     * method call
     */
    public boolean addEdge(String source, String destination){
        //search for source and destination
        DAGNode sourceNode = root.find(source);
        DAGNode destNode = root.find(destination);

        //if source is not found but destination is, create source
        if (sourceNode == null && destNode != null)
            sourceNode = new DAGNode(source);
        //if destination is not found but source is, create destination
        else if (destNode == null && sourceNode != null)
            destNode = new DAGNode(destination);
        //if neither is found, return false
        else if (sourceNode == null && destNode == null) {
            return false;
        }

        //prevent creating a cycle
        if (cycleExists(sourceNode, destNode)) {      
            return false;
        }

        //add destination to the source's children list
        sourceNode.addChild(destNode);
        return true;  
    }

    private boolean cycleExists(DAGNode source, DAGNode destination){
        return (destination.find(source.getName()) != null);
    }

    public DAGNode getRoot() {
        return root;
    }

    /**
     * Represents a single node of a directed acyclic graph
     */
    public static class DAGNode {
        ArrayList<DAGNode> children;
        String name;

        public DAGNode(String _name){
            children = new ArrayList<DAGNode>();
            name = _name;
        }

        /**
         * Add a node to this node's children list.
         * 
         * @param child The node to be added
         */
        public void addChild(DAGNode child){
            children.add(child);
        }

        /**
         * Depth-first search through the graph for the target String
         * 
         * @param target the String to be found in the name field of a node
         * @return the node where the target is found, or null if it is not
         */
        public DAGNode find(String target){
            if (name.equals(target))
                return this;
            else if (children.isEmpty())
                return null;
            else {
                DAGNode found = null;
                int i = 0;
                while (found == null && i < children.size()) {
                    found = children.get(i).find(target);
                    i++;
                }
                return found;
            }
        }

        public String getName(){
            return name;
        }

        public ArrayList<DAGNode> getChildren() {
            return children;
        }

    }
}