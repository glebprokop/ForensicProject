package com.forensic.dbmanager.converter.basemapper;

import java.sql.ResultSet;

/**
 * Util interface sed for the converting (or mapping)) of the {@link java.sql.ResultSet},
 * getting from the {@link java.sql.Statement} after connection to data source.
 * The implementation of interface used to convert ResultSet to entities in application,
 * similar to {@link org.springframework.jdbc.core.RowMapper} interface in general
 * <P>
 * Examples of implementation: <P>
 * {@link CrimeMapper} - mapper for {@link com.forensic.entity.crime.Crime} entity class
 */
public interface ClassMapper<T> {

    T parseResultSet(ResultSet rs);
}
