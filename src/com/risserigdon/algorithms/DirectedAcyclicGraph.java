package com.risserigdon.algorithms;

import java.util.ArrayList;

public class DirectedAcyclicGraph {
    
    private DAGNode root;
    
    public DirectedAcyclicGraph(String rootName){
        root = new DAGNode(rootName);
    }

    public DAGNode getRoot() {
        return root;
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
        
        //add destination to the source's children list
        sourceNode.addChild(destNode);
        return true;  
    }

    public static void runTests(){
        
        DirectedAcyclicGraph graph = new DirectedAcyclicGraph("root node");
        DAGNode root = graph.getRoot();
     
        DAGNode firstChild = new DAGNode("root's first child");
        DAGNode secondChild = new DAGNode("root's second child");
        DAGNode thirdChild = new DAGNode("root's third child");

        root.addChild(firstChild);
        root.addChild(secondChild);
        root.addChild(thirdChild);

        DAGNode firstGrandchild = new DAGNode("firstChild's child");
        firstChild.addChild(firstGrandchild);

        DAGNode firstGreatGrandchild = new DAGNode("firstChild's grandchild");
        firstGrandchild.addChild(firstGreatGrandchild);


        // print True if the third child was added successfully to the root
        System.out.println(root.find("root's third child") != null);

        // print True if the grandchild was added successfully to the first child
        System.out.println(root.find("firstChild's child") != null);

        // print True if the grandchild was added successfully to the first child
        System.out.println(root.find("firstChild's grandchild") != null);
        
        // test addEdge() method
        graph.addEdge("firstChild's grandchild", "root's second child");
        // print True if directed edge has been created between secondChild and firstGreatGrandchild
        System.out.println(firstGreatGrandchild.getChildren().contains(secondChild));
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
            if (name == target)
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
    

    public static void main(String args[]){
        runTests();       	
    }

}
