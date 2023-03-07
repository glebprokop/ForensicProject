package com.forensic.dbmanager.converter.rowmapper;

import com.forensic.entity.crime.Crime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Realisation of interface {@link RowMapper} using for the JDBCTemplate data source
 * manager. <P>
 * This is the realisation for {@link Crime} entity class
 */
@Component
public class CrimeRowMapper implements RowMapper<Crime> {

    @Value("${db.crime.id}")
    private String id;

    @Value("${db.crime.policeNumber}")
    private String policeRegNumber;

    @Value("${db.crime.caseNumber}")
    private String caseInvestigationNumber;

    @Value("${db.crime.criminalCodeArticle}")
    private String criminalCodeArticleNumber;

    @Value("${db.crime.description}")
    private String description;

    @Value("${db.crime.crimeDate}")
    private String crimeDate;

    @Override
    public Crime mapRow(ResultSet rs, int rowNum) {

        Crime crime;

        try {
            crime = Crime.builder()
                    .id(rs.getLong(id))
                    .crimeDate(rs.getTimestamp(crimeDate))
                    .caseInvestigationNumber(rs.getLong(caseInvestigationNumber))
                    .description(rs.getString(description))
                    .policeRegNumber(rs.getLong(policeRegNumber))
                    .criminalCodeArticleNumber(rs.getLong(criminalCodeArticleNumber))
                    .build();

        } catch (SQLException e) {
            throw new RuntimeException("Exception during the getting crime from data source");
        }

        return crime;
    }
}
