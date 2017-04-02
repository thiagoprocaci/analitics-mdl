package com.tbp.mdl.model.graph.stats;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import com.tbp.mdl.model.graph.Node;
import static org.junit.Assert.*;


public class NodeMetricsFactoryTest {

    @Test
    public void testCreate() {
        List<Node> nodeList = Arrays.asList(new Node(2L));
        NodeMetricsFactory factory = new NodeMetricsFactory();
        assertNotNull(factory.create(nodeList));
    }

}
