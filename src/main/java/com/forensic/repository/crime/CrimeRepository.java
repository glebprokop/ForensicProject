package com.forensic.repository.crime;

import com.forensic.entity.crime.Crime;
import com.forensic.repository.CRUDRepository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * Interface for access to data source for {@link Crime} com.forensic.entity.
 * Implementation need to execute all CRUD request to data source, and special methods are described below
 */
public interface CrimeRepository extends CRUDRepository<Long, Crime> {

    /**
     * Method for founding all crimes for interested year and month. Primarily in goals of statistic work
     *
     * @param year needed year
     * @param month needed month
     * @return List of {@link Crime} for chosen year and month
     */
    List<Crime> getCrimesForMonth(Integer year, Integer month);

    /**
     * Method for founding all crimes for interested article of CriminalCode.
     * Primarily in goals of statistic work
     *
      * @param criminalCodeArticle the article of the Criminal Code
     * @return List of {@link Crime} for chosen article
     */
    List<Crime> getCrimesForArticle(Long criminalCodeArticle);

    /**
     * Method for deleting all crimes before interested date. You may use it for
     * control crimes with the statute of limitations
     *
     * @param deleteDate {@link Timestamp} class object of the date
     */
    void deleteCrimesBeforeDate(Timestamp deleteDate);

    /**
     * Method for searching crimes by chosen parameters (you may use all params described
     * in {@link com.forensic.dbmanager.entityconverter.columnmapper.CrimeDBColumnMapper} class.
     *
     * @param requestParams the {@link Map} of params (key and value are Strings - key is the name
     *                      of param according to the database columns names)
     * @return List of {@link Crime} filtered by chosen params
     *
     * @see com.forensic.dbmanager.query.QueryCreator
     */
    List<Crime> searchByParams(Map<String, String> requestParams);
}
