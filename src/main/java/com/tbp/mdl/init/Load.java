package com.tbp.mdl.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component
public class Load {


    @Autowired
    public Load(DataSource dataSource) throws SQLException {
       ResourceDatabasePopulator rdp = new ResourceDatabasePopulator();
      //  rdp.addScript(new ClassPathResource("data-h2-normal.sql"));
        rdp.addScript(new ClassPathResource("data-h2-obfuscated.sql"));
        Connection connection = dataSource.getConnection();
        rdp.populate(connection);
        connection.close();
    }
}
