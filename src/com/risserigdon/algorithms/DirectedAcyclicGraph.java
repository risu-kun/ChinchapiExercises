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
    
    public static void main(String args[]){
    	DAGNode root = new DAGNode("test parent");
    	DAGNode child = new DAGNode("test child");
    	root.addChild(child);
    	
    	// print True if the test child was added successfully to the root
    	System.out.println(root.getChildren().contains(child));
    }

}
