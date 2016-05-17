package com.risserigdon.algorithms;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.risserigdon.algorithms.DirectedAcyclicGraph.DAGNode;

public class DirectedAcyclicGraphTest {
    DirectedAcyclicGraph graph;
    DAGNode nodeB;
    DAGNode nodeC;
    
    @Before
    public void setUp() throws Exception {
        graph = new DirectedAcyclicGraph("A");
        nodeB = new DAGNode("B");
        nodeC = new DAGNode("C");
        
        graph.getRoot().addChild(nodeB);
        graph.getRoot().addChild(nodeC);
    }

    @Test
    public void testAddEdge() {         
        assertTrue(graph.addEdge("B", "C"));        
        assertTrue(nodeB.children.contains(nodeC));
    }
    
    @Test
    public void shouldNotAllowCycleCreation() {
        DAGNode nodeD = new DAGNode("D");
        nodeB.addChild(nodeD);
        assertFalse(graph.addEdge("D", "A"));
    }

}
