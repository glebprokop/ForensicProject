package com.forensic.repository.crime;

import com.forensic.entity.crime.Crime;

import java.util.List;
import java.util.Optional;

/**
 * Interface for access to data source for {@link Crime} com.forensic.entity. Implementation need to execute all CRUD request
 * to data source
 */
public interface CrimeRepository {

    /**
     * Method for founding all crimes in data source
     *
     * @return List of {@link Crime}
     */
    List<Crime> findAll();

    /**
     * Method for founding {@link Crime} by it`s id in data source
     *
     * @param id primary kew of the {@link Crime} in data source
     * @return {@link Optional} contains the founded crime (or contains null according to
     * the docs of Optional class
     */
    Crime findById(Long id); //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    /**
     * Method for founding {@link Crime} by it`s id in data source
     *
     * @param id primary kew of the {@link Crime} in data source
     * @return {@link Optional} contains the founded crime (or contains null according to
     * the docs of Optional class
     */
    Optional<Crime> findOne(Long id);

    /**
     * Method for deleting {@link Crime} by it`s id in data source
     *
     * @param id primary kew of the {@link Crime} in data source
     * @return boolean value for checking the delete status
     */
    Crime delete(Long id);

    /**
     * Method for adding {@link Crime} in data source
     *
     * @param crime the new instance of {@link Crime} adding in data source
     * @return boolean value for checking the adding status
     */
    Crime add(Crime crime);

    /**
     * Method for updating {@link Crime} in data source by it`s id
     *
     * @param id primary kew of the {@link Crime} in data source
     * @param newCrime the new instance of {@link Crime} for updating
     * @return
     */
    Optional<Crime> update(Long id, Crime newCrime);

    /**
     * Method for founding all id-attributes in data source, actually in test aim
     *
     * @return List of long values contains all id in data source
     */
    List<Long> getAllId();


    /**
     * Method for founding all crimes for interested year and month. Primarily in goals of statistic work
     *
     * @param year needed year
     * @param month needed month
     * @return List of {@link Crime} for chosen year and month
     */
    List<Crime> getCrimesForMonth(Integer year, Integer month);

    /**
     * Method for founding all crimes for interested article of CriminalCode. Primarily in goals of statistic work
     *
      * @param criminalCodeArticle the article of the Criminal Code
     * @return List of {@link Crime} for chosen article
     */
    List<Crime> getCrimesForArticle(Long criminalCodeArticle);
}
