package com.forensic.dbmanager.entityconverter.paramsource.crime;

import com.forensic.dbmanager.entityconverter.columnmapper.CrimeDBColumnMapper;
import com.forensic.dbmanager.entityconverter.paramsource.MapSqlParameterSourceManager;
import com.forensic.entity.crime.Crime;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

/**
 * Class generating the {@link MapSqlParameterSource} object, used for working with
 * NamedJDBCTemplate data source manager. This class use {@link CrimeDBColumnMapper} to collect and generate
 * all needed fields in SQL request
 *
 */
@Component
public class CrimeMapSqlParameterSourceManager implements MapSqlParameterSourceManager<Crime> {

    CrimeDBColumnMapper dbColumnMapper;

    public CrimeMapSqlParameterSourceManager(CrimeDBColumnMapper dbColumnMapper) {
        this.dbColumnMapper = dbColumnMapper;
    }

    /**
     * Creating the {@link MapSqlParameterSource} map after parsing the {@link Crime} object.
     * Use the {@link CrimeDBColumnMapper} object to generate parameter map<p>
     * For example: for {@link Crime} object we generate map ("id": crime.getId,
     * "police_reg_number": crime.getPoliceRegNumber ...) and so on. This map used in
     * {@link com.forensic.repository.crime.CrimeRepositoryJdbcTemplateImpl} class
     *
     * @param object
     * @return
     */
    @Override
    public MapSqlParameterSource createMapSqlParameterSource(Crime object) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();

        parameterSource.addValue(dbColumnMapper.getId(), object.getId());
        parameterSource.addValue(dbColumnMapper.getPoliceRegNumber(), object.getPoliceRegNumber());
        parameterSource.addValue(dbColumnMapper.getCaseInvestigationNumber(), object.getCaseInvestigationNumber());
        parameterSource.addValue(dbColumnMapper.getDescription(), object.getDescription());
        parameterSource.addValue(dbColumnMapper.getCriminalCodeArticleNumber(), object.getCriminalCodeArticleNumber());
        parameterSource.addValue(dbColumnMapper.getCrimeDate(), object.getCrimeDate());

        return parameterSource;
    }
}
