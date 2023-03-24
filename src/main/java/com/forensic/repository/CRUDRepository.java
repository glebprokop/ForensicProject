package com.forensic.repository;

import com.forensic.entity.crime.Crime;
import com.forensic.exception.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

/**
 * The main interface described main CRUD-operations for database (create, read, update and delete operations).
 * Implementations are related to every entity class. Every entity also has it`s personal interface to describe
 * all specific database operations
 * <P>
 * Repositories in application:
 * <P>
 * - {@link com.forensic.repository.crime.CrimeRepository} for {@link com.forensic.entity.crime.Crime} entity
 * <P>
 * -
 */
public interface CRUDRepository<K, T> {

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
