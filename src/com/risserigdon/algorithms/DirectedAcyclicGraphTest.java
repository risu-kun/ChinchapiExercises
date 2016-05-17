package com.risserigdon.algorithms;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.risserigdon.algorithms.DirectedAcyclicGraph.DAGNode;

public class DirectedAcyclicGraphTest {

    @Test
    public void testAddEdge() {
        DirectedAcyclicGraph graph = new DirectedAcyclicGraph("A");
        DAGNode nodeB = new DAGNode("B");
        DAGNode nodeC = new DAGNode("C");
        
        graph.getRoot().addChild(nodeB);
        graph.getRoot().addChild(nodeC);
        
        graph.addEdge("B", "C");
        
        assertTrue(nodeB.children.contains(nodeC));
    }

}
