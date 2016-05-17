package com.risserigdon.algorithms;

import java.util.ArrayList;

public class DirectedAcyclicGraph {
	
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
		//search for source
    	//if source is not found, create a new node
    	//search for destination
    	//if destination is not found, create a new node
    	
    	//add destination to the source's children list
    	return false;
    }
    
    public static void runTests(){
    	DAGNode root = new DAGNode("root node");
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
    }
    
    public static void main(String args[]){
    	runTests();	
    }

}
