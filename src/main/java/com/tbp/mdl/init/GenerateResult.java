package com.tbp.mdl.init;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.tbp.mdl.facade.AnalysisFacade;
import com.tbp.mdl.model.graph.GraphDto;
import com.tbp.mdl.model.moodle.Course;
import com.tbp.mdl.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Component
public class GenerateResult {

    @Autowired
    public GenerateResult(AnalysisFacade analysisFacade,
                          CourseRepository courseRepository) throws IOException {

    //    List<Course> courseList = courseRepository.findWithPosts();
      //  for(Course c: courseList) {
        //    System.out.println(c.getShortName());
          //  GraphDto graphDto = analysisFacade.makeAnalysis(c.getId());

         //   ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
         //   String json = ow.writeValueAsString(graphDto);

           /// File file = new File("files/course_" + c.getId());
          //  if(file.exists()) {
           //     file.delete();
         //   }
         //   file.createNewFile();
        //    Files.write(Paths.get(file.toURI()), json.getBytes());
           // System.out.println(json);
          //  break;
      //  }

    }

}
