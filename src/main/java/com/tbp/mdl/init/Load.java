package com.tbp.mdl.init;

import com.tbp.mdl.model.moodle.*;
import com.tbp.mdl.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.UUID;

@Component
@Profile("h2")
public class Load {


    @Autowired
    public Load(DataSource dataSource) throws SQLException {
        ResourceDatabasePopulator rdp = new ResourceDatabasePopulator();
      //  rdp.addScript(new ClassPathResource("data-h2.sql"));
        rdp.addScript(new ClassPathResource("data-h2.sql"));
        Connection connection = dataSource.getConnection();
        rdp.populate(connection);
        connection.close();
    }

   /* public Load(UserRepository userRepository, PostRepository postRepository,
                ForumRepository forumRepository, DiscussionRepository discussionRepository,
                CourseRepository courseRepository) throws IOException {
        File f = new File("data-h2.sql");
        if(f.exists()) {
            f.delete();
        }
        f.createNewFile();

        Iterable<User> all = userRepository.findAll();
        String sql = "INSERT INTO mdl_user (id, username, firstname, lastname) VALUES (%s , '%s' , '%s' , '%s' );\n";
        StringBuilder builder = new StringBuilder();
        for (User u: all) {
          String s = String.format(sql, u.getId().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString());
          builder.append(s);
        }

        Iterable<Post> all1 = postRepository.findAll();
        sql = "INSERT INTO mdl_forum_posts (id, parent, discussion, userid) VALUES (%d , %d , %d , %d );\n";
        for(Post p: all1) {
            String s = String.format(sql, p.getId(), p.getParentPost(), p.getDiscussionId(), p.getUserId());
            builder.append(s);
        }
        Iterable<Forum> all2 = forumRepository.findAll();
        sql = "INSERT INTO mdl_forum (id, course, name, type) VALUES (%d , %d , '%s' , '%s' );\n";
        for(Forum forum: all2) {
            String s = String.format(sql, forum.getId(), forum.getCourseId(), UUID.randomUUID(), forum.getType());
            builder.append(s);
        }
        Iterable<Discussion> all3 = discussionRepository.findAll();
        sql = "INSERT INTO mdl_forum_discussions (id, name, forum, userId) VALUES (%d , '%s' , %d , %d );\n";
        for(Discussion d: all3) {
            String s = String.format(sql, d.getId(), UUID.randomUUID(), d.getForumId(), d.getUserId());
            builder.append(s);
        }
        Iterable<Course> all4 = courseRepository.findAll();
        sql = "INSERT INTO mdl_course (id, shortname, fullname) VALUES (%d , '%s' , '%s');\n";
        for(Course c: all4) {
            String s = String.format(sql, c.getId(), UUID.randomUUID(),  UUID.randomUUID());
            builder.append(s);
        }
        Files.write(Paths.get(f.toURI()), builder.toString().getBytes());


    }
*/
}
