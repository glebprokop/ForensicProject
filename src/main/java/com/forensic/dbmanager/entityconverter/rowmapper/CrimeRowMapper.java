package com.forensic.dbmanager.entityconverter.rowmapper;

import com.forensic.dbmanager.entityconverter.columnmapper.CrimeDBColumnMapper;
import com.forensic.entity.crime.Crime;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Realisation of interface {@link RowMapper} using for the JDBCTemplate data source
 * manager. <P>
 * This is the realisation for {@link Crime} entity class, and used the {@link CrimeDBColumnMapper} class
 * for mapping the database columns names
 */
@Component
public class CrimeRowMapper implements RowMapper<Crime> {

    CrimeDBColumnMapper dbColumnMapper;

    public CrimeRowMapper(CrimeDBColumnMapper dbColumn) {
        this.dbColumnMapper = dbColumn;
    }

    @Override
    public Crime mapRow(ResultSet rs, int rowNum) {

        Crime crime;

        try {
            crime = Crime.builder()
                    .id(rs.getLong(dbColumnMapper.getId()))
                    .crimeDate(rs.getTimestamp(dbColumnMapper.getCrimeDate()))
                    .caseInvestigationNumber(rs.getLong(dbColumnMapper.getCaseInvestigationNumber()))
                    .description(rs.getString(dbColumnMapper.getDescription()))
                    .policeRegNumber(rs.getLong(dbColumnMapper.getPoliceRegNumber()))
                    .criminalCodeArticleNumber(rs.getLong(dbColumnMapper.getCriminalCodeArticleNumber()))
                    .build();

        } catch (SQLException e) {
            throw new RuntimeException("Exception during the getting crime from data source");
        }

        return crime;
    }
}
