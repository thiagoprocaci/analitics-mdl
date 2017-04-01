package com.tbp.mdl.facade;


import com.tbp.mdl.model.graph.Graph;
import com.tbp.mdl.model.graph.GraphDto;
import com.tbp.mdl.model.moodle.Post;
import com.tbp.mdl.repository.CourseRepository;
import com.tbp.mdl.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AnalysisFacade {

    @Autowired
    PostRepository postRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    GephiFacade gephiFacade;

    // TODO aplicar a mesma regra para todos os cursos...
    // fazer um grafo global.

    public GraphDto makeAnalysis(Long courseId) {
        List<Post> postList = postRepository.findByCourseId(courseId);
        if(postList != null && !postList.isEmpty()) {
            Graph graph = new Graph();
            for(Post post : postList) {
                if(post.getParentPost() != 0L) {
                    Post parent = postRepository.findOne(post.getParentPost());
                    graph.addEdge(post.getUserId(), parent.getUserId());
                }
            }
            gephiFacade.executeAlgorithm(graph);
            return new GraphDto(graph, courseRepository.findOne(courseId));
        }
        return null;
    }


}
