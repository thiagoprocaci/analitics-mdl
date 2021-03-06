package com.tbp.mdl.facade;


import org.gephi.graph.api.*;
import org.gephi.project.api.ProjectController;
import org.gephi.statistics.plugin.Degree;
import org.gephi.statistics.plugin.EigenvectorCentrality;
import org.gephi.statistics.plugin.GraphDistance;
import org.gephi.statistics.plugin.PageRank;
import org.openide.util.Lookup;
import org.springframework.stereotype.Component;

@Component
public class GephiFacade {



    public void executeAlgorithm(com.tbp.mdl.model.graph.Graph graphApp) {
        if(graphApp != null && graphApp.getEdgeMap() != null && graphApp.getNodeMap() != null
                && !graphApp.getNodeMap().isEmpty() && !graphApp.getEdgeMap().isEmpty()) {
            // needs to create the gephi workspace ...
            ProjectController pc = Lookup.getDefault().lookup(ProjectController.class);
            pc.newProject();
            pc.getCurrentWorkspace();

            GraphModel graphModel = Lookup.getDefault().lookup(GraphController.class).getGraphModel();

            DirectedGraph directedGraph = graphModel.getDirectedGraph();
            for(com.tbp.mdl.model.graph.Node n : graphApp.getNodeMap().values()) {
                Node node = graphModel.factory().newNode(n.getId().toString());
                directedGraph.addNode(node);
            }

            for(com.tbp.mdl.model.graph.Edge e : graphApp.getEdgeMap().values()) {
                Node source = graphModel.getGraph().getNode(e.getSource().getId().toString());
                Node dest = graphModel.getGraph().getNode(e.getDest().getId().toString());
                Edge e1 = graphModel.factory().newEdge(source, dest, e.getWeight(), true);
                directedGraph.addEdge(e1);
            }

            //GraphDistance
            GraphDistance distance = new GraphDistance();
            distance.setDirected(true);
            distance.execute(graphModel);

            // page rank
            PageRank pageRankAlg = new PageRank();
            pageRankAlg.setDirected(true);
            pageRankAlg.execute(graphModel);

            // degree distribution
            Degree degreeCalc = new Degree();
            degreeCalc.execute(graphModel);

            // eigenvector
            EigenvectorCentrality eigenvectorCentrality = new EigenvectorCentrality();
            eigenvectorCentrality.execute(graphModel);


            Column columnBetweenness = graphModel.getNodeTable().getColumn(GraphDistance.BETWEENNESS);
            Column columnCloseness = graphModel.getNodeTable().getColumn(GraphDistance.CLOSENESS);
            Column columnEccentricity = graphModel.getNodeTable().getColumn(GraphDistance.ECCENTRICITY);
            Column columnHarmonicCloseness = graphModel.getNodeTable().getColumn(GraphDistance.HARMONIC_CLOSENESS);
            Column columnPagerank = graphModel.getNodeTable().getColumn(PageRank.PAGERANK);
            Column columnIndegree = graphModel.getNodeTable().getColumn(Degree.INDEGREE);
            Column columnOutdegree = graphModel.getNodeTable().getColumn(Degree.OUTDEGREE);
            Column columnDegree = graphModel.getNodeTable().getColumn(Degree.DEGREE);
            Column columnEigenvector = graphModel.getNodeTable().getColumn(EigenvectorCentrality.EIGENVECTOR);

            for(Node n: graphModel.getGraph().getNodes()) {
                Double betweenness = (Double) n.getAttribute(columnBetweenness);
                Double closeness = (Double) n.getAttribute(columnCloseness);
                Double eccentricity = (Double) n.getAttribute(columnEccentricity);
                Double harmonicCloseness = (Double) n.getAttribute(columnHarmonicCloseness);
                Double pageRank = (Double) n.getAttribute(columnPagerank);
                Integer indegree = (Integer) n.getAttribute(columnIndegree);
                Integer outdegree = (Integer) n.getAttribute(columnOutdegree);
                Integer degree = (Integer) n.getAttribute(columnDegree);
                Double eigenvector = (Double) n.getAttribute(columnEigenvector);

                com.tbp.mdl.model.graph.Node node = graphApp.getNodeMap().get(Long.parseLong(n.getId().toString()));
                node.setBetweenness(betweenness);
                node.setCloseness(closeness);
                node.setEccentricity(eccentricity);
                node.setHarmonicCloseness(harmonicCloseness);
                node.setPageRank(pageRank);
                node.setIndegree(indegree);
                node.setOutdegree(outdegree);
                node.setDegree(degree);
                node.setEigenvector(eigenvector);
            }
        }
    }


}
