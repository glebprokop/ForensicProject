package com.forensic.dbmanager.manager;

import com.forensic.dbmanager.parser.ClassParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Component
public class DataBaseManagerImpl<T> implements DataBaseManager<T>{

    @Autowired
    DataSource dataSource;

    @Override
    public void executeQuery(String query) {
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void executeQuery(String query, T object) {
        try {
            Connection connection = dataSource.getConnection();

            PreparedStatement statement = connection.prepareStatement(query);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<T> executeQuery(String query, ClassParser classParser) {
        return null;
    }

    @Override
    public T executeQueryObject(String query, ClassParser classParser) {
        return null;
    }
}
