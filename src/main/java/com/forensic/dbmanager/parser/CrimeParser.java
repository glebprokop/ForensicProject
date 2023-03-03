package com.forensic.dbmanager.parser;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.forensic.entity.crime.Crime;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

/**
 * Parser class for {@link Crime} com.forensic.entity class. It`s used the builder constructed
 * by {@link lombok.Lombok} for creating new instance of crime.
 *
 * Actually, this class is analog of RowMap interface in JDBCTemplate
 */
@Data
@Component
public class CrimeParser implements ClassParser{

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

    public Crime parseResultSet(ResultSet rs) {

        Crime crime;

        try {
            crime = Crime.builder()
                    .id(rs.getInt(id))
                    .crimeDate(rs.getTimestamp(crimeDate))
                    .caseInvestigationNumber(rs.getInt(caseInvestigationNumber))
                    .description(rs.getString(description))
                    .policeRegNumber(rs.getInt(policeRegNumber))
                    .criminalCodeArticleNumber(rs.getInt(criminalCodeArticleNumber))
                    .build();

        } catch (SQLException e) {
            throw new RuntimeException("Exception during the getting crime from data source");
        }

        return crime;
    }
}
