package com.forensic.dbmanager.manager;

import com.forensic.dbmanager.parser.ClassParser;

import javax.swing.tree.RowMapper;
import java.util.List;

public interface DataBaseManager<T> {
    void executeQuery(String query);

    void executeQuery(String query, T object);

    List<T> executeQuery(String query, ClassParser classParser);

    T executeQueryObject(String query, ClassParser classParser);
}
