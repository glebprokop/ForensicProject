package com.forensic.dbmanager.entityconverter.columnmapper;

import java.util.List;

/**
 * Interface described the mapping of the parameters for searching in database to entities.
 * You need use one implementation for every entity class. This classes used to generate text query
 * using the {@link com.forensic.dbmanager.query.QueryCreator} class.
 *
 */
public interface AbstractDBColumnMapper {

    /**
     * Method gets the {@link List} of names of database columns
     *
     * @return {@link List} of columns
     */
    List<String> allColumns();
}
