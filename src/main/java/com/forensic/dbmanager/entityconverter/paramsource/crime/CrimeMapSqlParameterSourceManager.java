package com.forensic.dbmanager.entityconverter.paramsource.crime;

import com.forensic.dbmanager.entityconverter.columnmapper.CrimeDBColumnMapper;
import com.forensic.dbmanager.entityconverter.paramsource.MapSqlParameterSourceManager;
import com.forensic.entity.crime.Crime;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class CrimeMapSqlParameterSourceManager implements MapSqlParameterSourceManager<Crime> {

    CrimeDBColumnMapper dbColumnMapper;

    public CrimeMapSqlParameterSourceManager(CrimeDBColumnMapper dbColumnMapper) {
        this.dbColumnMapper = dbColumnMapper;
    }

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
