package com.forensic.repository.crime;

import com.forensic.dbmanager.entityconverter.columnmapper.CrimeDBColumnMapper;
import com.forensic.dbmanager.entityconverter.paramsource.crime.CrimeMapSqlParameterSourceManager;
import com.forensic.dbmanager.entityconverter.rowmapper.CrimeRowMapper;
import com.forensic.entity.crime.Crime;
import com.forensic.exception.custom.EntityNotFoundException;
import com.forensic.dbmanager.query.QueryCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@Primary
public class CrimeRepositoryJdbcTemplateImpl implements CrimeRepository{

    /**
     * Table name used in {@link QueryCreator}
     */
    private final String TABLE_NAME = "crime";

    /**
     * {@link NamedParameterJdbcTemplate} class used for datasource access
     */
    private final NamedParameterJdbcTemplate dataManager;

    /**
     * The realisation of {@link org.springframework.jdbc.core.RowMapper} class used for
     * mapping data from ResultSet to entity
     */
    private final CrimeRowMapper rowMapper;

    /**
     * The {@link QueryCreator} class used for generate of SQL queries
     */
    private final QueryCreator queryCreator;

    /**
     * The {@link com.forensic.dbmanager.entityconverter.columnmapper.AbstractDBColumnMapper}
     * implementation for {@link Crime} entity
     */
    private final CrimeDBColumnMapper dbColumnMapper;

    /**
     *
     */
    private final CrimeMapSqlParameterSourceManager sqlParameterSourceManager;

    public CrimeRepositoryJdbcTemplateImpl(NamedParameterJdbcTemplate dataManager,
                                           CrimeRowMapper rowMapper,
                                           CrimeDBColumnMapper dbColumnMapper,
                                           QueryCreator queryCreator,
                                           CrimeMapSqlParameterSourceManager sqlParameterSourceManager) {
        this.dataManager = dataManager;
        this.rowMapper = rowMapper;
        this.dbColumnMapper = dbColumnMapper;
        this.queryCreator = queryCreator;
        this.sqlParameterSourceManager = sqlParameterSourceManager;
    }

    @Override
    public List<Crime> findAll() {
        String query = queryCreator.createSelectQueryByParam(TABLE_NAME,
                new HashMap<>(), dbColumnMapper.allColumns());

        return dataManager.query(query, rowMapper);
    }

    @Override
    public Crime findById(Long id){
        MapSqlParameterSource parameterSource = new MapSqlParameterSource().addValue("id", id);
        String query = "select * from crime where id = :id";

        try{
            return dataManager.queryForObject(query, parameterSource, rowMapper);
        } catch (EmptyResultDataAccessException e){
            throw new EntityNotFoundException("No entity with such id - " + id, e);
        }
    }

    @Override
    public Optional<Crime> findOne(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource().addValue("id", id);

        String query = "select * from crime where id = :id";
        Crime object = dataManager.queryForObject(query, parameterSource, rowMapper);

        return Optional.of(object);
    }

    @Override
    public Crime delete(Long id) {
        Crime object = findById(id);
        MapSqlParameterSource parameterSource = new MapSqlParameterSource().addValue("id", id);
        String query = "delete from crime where id = :id";

        dataManager.update(query, parameterSource);

        return object;
    }

    @Override
    public Crime create(Crime object) {
        MapSqlParameterSource parameterSource = sqlParameterSourceManager
                .createMapSqlParameterSource(object);
        String query = "insert into crime (police_reg_number, " +
                "case_investigation_number, description, " +
                "criminal_code_article_number, crime_date) " +
                "values (:police_reg_number, :case_investigation_number, :description, " +
                ":criminal_code_article_number, :crime_date)";

        dataManager.update(query, parameterSource);

        // Getting the last added id to configure the object
        String lastIdQuery = "select last_value from crime_id_seq";
        Long lastId = dataManager.query(lastIdQuery, (ResultSet rs, int rowNum) -> rs.getLong("last_value")).get(0);
        object.setId(lastId);

        return object;
    }

    @Override
    public Crime update(Crime object) {
        MapSqlParameterSource parameterSource = sqlParameterSourceManager
                .createMapSqlParameterSource(object);

        String query = "update crime set " +
                "police_reg_number = :police_reg_number," +
                "case_investigation_number = :case_investigation_number," +
                "criminal_code_article_number = :criminal_code_article_number," +
                "description = :description," +
                "crime_date = :crime_date " +
                "where id = :id";

        dataManager.update(query, parameterSource);

        return object;
    }

    @Override
    public List<Crime> getCrimesForMonth(Integer year, Integer month) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("year", year);
        parameterSource.addValue("month", month);

        String query = "select * from get_crimes_by_month(:year, :month)";

        return dataManager.query(query, parameterSource, rowMapper);
    }

    @Override
    public List<Crime> getCrimesForArticle(Long criminalCodeArticle) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("criminal_code_article_number", criminalCodeArticle);
        parameterSource.addValue("article", criminalCodeArticle);

        String query = "select * from crime where criminal_code_article_number = " +
                ":criminal_code_article_number";

        return dataManager.query(query, parameterSource, rowMapper);
    }

    @Override
    public void deleteCrimesBeforeDate(Timestamp deleteDate) {
        String query = "call delete_after_date(:deleteDate)";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource().addValue("deleteDate", deleteDate);

        dataManager.update(query, parameterSource);
    }

    @Override
    public List<Crime> searchByParams(Map<String, String> requestParams) {
        String query = queryCreator.createSelectQueryByParam("crime", requestParams, dbColumnMapper.allColumns());

        return dataManager.query(query, rowMapper);
    }
}
