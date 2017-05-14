package com.tbp.mdl.controller;

import com.tbp.mdl.facade.AnalysisFacade;
import com.tbp.mdl.model.graph.GraphDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("analysis")
public class AnalysisController {

    @Autowired
    AnalysisFacade analysisFacade;

    @RequestMapping(value = "{courseId}", method = RequestMethod.GET)
    public GraphDto perform(@PathVariable  Long courseId) {
        return analysisFacade.makeAnalysis(courseId);
    }

}
