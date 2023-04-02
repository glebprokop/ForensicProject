package com.forensic.dbmanager.entityconverter.paramsource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

public interface MapSqlParameterSourceManager<T> {

    MapSqlParameterSource createMapSqlParameterSource(T object);
}
