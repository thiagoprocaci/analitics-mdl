package com.tbp.mdl.model.graph;


import java.util.HashMap;
import java.util.Map;


public class Graph {

    Map<Long, Node> nodeMap;
    Map<String, Edge> edgeMap;


    public Graph() {
        nodeMap = new HashMap();
        edgeMap = new HashMap();
    }

    public void addEdge(Long sourceId, Long destId) {
        Node source = new Node(sourceId);
        Node dest = new Node(destId);
        if(!nodeMap.containsKey(source.getId())) {
            nodeMap.put(source.getId(), source);
        } else {
            source = nodeMap.get(sourceId);
        }
        if(!nodeMap.containsKey(dest.getId())) {
            nodeMap.put(dest.getId(), dest);
        } else {
            dest = nodeMap.get(destId);
        }
        Edge e = new Edge(source, dest);
        if(edgeMap.containsKey(e.getId())) {
            edgeMap.get(e.getId()).addWeight();
        } else {
            edgeMap.put(e.getId(), e);
        }
    }

    public Map<Long, Node> getNodeMap() {
        return nodeMap;
    }

    public Map<String, Edge> getEdgeMap() {
        return edgeMap;
    }
}
