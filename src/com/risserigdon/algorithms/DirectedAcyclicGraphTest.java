package com.risserigdon.algorithms;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.risserigdon.algorithms.DirectedAcyclicGraph.DAGNode;

public class DirectedAcyclicGraphTest {
    DirectedAcyclicGraph graph;
    DAGNode nodeA;
    DAGNode nodeB;
    DAGNode nodeC;
    DAGNode nodeD;
    DAGNode nodeE;
    DAGNode nodeF;
    
    @Before
    public void setUp() throws Exception {
    	graph = new DirectedAcyclicGraph("A");
    	nodeA = graph.getRoot();
        nodeB = new DAGNode("B");
        nodeC = new DAGNode("C");
        nodeD = new DAGNode("D");
        nodeE = new DAGNode("E");
        nodeF = new DAGNode("F");
        
        nodeA.addChild(nodeB);
        nodeA.addChild(nodeC);
        nodeB.addChild(nodeD);
        nodeB.addChild(nodeE);
        nodeC.addChild(nodeE);
        nodeD.addChild(nodeF);
        nodeE.addChild(nodeF);
    }

    @Test
    public void shouldAllowCreationOfValidEdges() {
        assertTrue(graph.addEdge("B", "E"));        
        assertTrue(nodeB.children.contains(nodeD));
    }
    
    @Test
    public void shouldNotAllowCycleCreation() {
        assertFalse(graph.addEdge("F", "A"));
        assertFalse(nodeF.children.contains(nodeA));
    }

}