package com.forensic.service;

import com.forensic.exception.custom.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

/**
 * Proxy interface for {@link com.forensic.repository.CRUDRepository} interface. This interface
 * gets opportunity loading data from data source and approve all CRUD operations <p>
 * @see com.forensic.repository.CRUDRepository
 *
 */
public interface CRUDService<K, T> {

    /**
     * Method for founding all entities in data source
     *
     * @return List of {@link T} type entities
     */
    List<T> findAll();

    /**
     * Method for founding entity by id in data source
     *
     * @param id primary kew for entity of the {@link K} type
     * @return {@link T} type entity object
     * @throws EntityNotFoundException in case then
     */
    T findById(K id);

    /**
     * One else method for founding entity by id in data source
     *
     * @param id primary kew for entity of the {@link K} type
     * @return {@link Optional} object contains the {@link T} type entity object (or null)
     */
    Optional<T> findOne(K id);

    /**
     * Method for deleting entity by id in data source
     *
     * @param id id primary kew for entity of the {@link K} type
     * @return deleted {@link T} type entity object
     */
    T delete(K id);

    /**
     * Method for creating entity in data source
     *
     * @param object {@link T} type entity object
     * @return {@link T} type entity object configured and added in datasource
     */
    T create(T object);

    /**
     * Method for updating entity in data source
     *
     * @param object {@link T} type entity object
     * @return {@link T} type entity object configured and updated in datasource
     */
    T update(T object);
}
