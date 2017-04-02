package com.tbp.mdl.model.graph.stats;


import com.tbp.mdl.model.graph.Node;

import java.util.Collection;

public class NodeMetricsFactory {

    public NodeMetrics create(Collection<Node> nodes) {
        return new NodeMetrics(nodes);
    }

}
