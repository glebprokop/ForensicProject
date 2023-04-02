package com.forensic.dbmanager.query;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;

/**
 * Class used for generating the text SQL queries. <P>
 * WARNING: This realisation approve to create only "select"
 * queries according to added params for searching and mapping of column names in database.
 *
 */
@Component
public class QueryCreator {

    /**
     * Method used for create the "select" SQL query to database. You need take the table name, the {@link Map}
     * of params, and the {@link List} of database columns names. <p>
     * For example: <p>
     * if you have the table "user", HTTP or other request params as Map("id" : 1, "name" : "Hleb"), and
     * the database has columns "id" and "name" (which described and contains in the {@link List} of
     * values such as List("id", "name")), this method create the next SQL query:<p>
     * "select * from user where id = '1' and name = 'Hleb'"
     *
     *
     * @param table the table name
     * @param requestParams the {@link Map} of params for creating the query (and searcing)
     * @param dbColumns the {@link List} of names of
     * @return the String with SQL query
     */
    public String createSelectQueryByParam(String table, Map<String, String> requestParams, List<String> dbColumns) {

        StringBuilder queryBuilder = new StringBuilder("select * from ").append(table);

        if (requestParams.isEmpty()) {
            return queryBuilder.toString();
        }

        queryBuilder.append(" where ");

        for (String paramKey : requestParams.keySet()) {
            if (dbColumns.contains(paramKey)) {
                String paramValue = requestParams.get(paramKey); //-> value of param of http or other request

                queryBuilder.append(paramKey)
                        .append(" = '")
                        .append(paramValue)
                        .append("' ")
                        .append("and ");
            }
        }
        String query = queryBuilder.substring(0, queryBuilder.length() - 4);

        return query;
    }
}
