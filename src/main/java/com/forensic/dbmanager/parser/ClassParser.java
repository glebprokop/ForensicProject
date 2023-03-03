package com.forensic.dbmanager.parser;

import com.forensic.entity.crime.Crime;

import java.sql.ResultSet;

/**
 * Parser interface to describe group of parsers for {@link ResultSet} instance, returned from data base.
 * Every entity need use personal implementation of this interface.
 *
 */
public interface ClassParser<T> {

    T parseResultSet(ResultSet rs);
}
