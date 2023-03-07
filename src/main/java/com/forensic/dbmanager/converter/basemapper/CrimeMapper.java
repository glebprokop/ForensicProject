package com.forensic.dbmanager.converter.basemapper;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.forensic.entity.crime.Crime;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Mapper class for {@link Crime} com.forensic.entity class. It`s used the builder constructed
 * by {@link lombok.Lombok} for creating new instance of crime.
 *
 * Actually, this class is analog of RowMap interface in JDBCTemplate
 */
@Data
@Component
public class CrimeMapper implements ClassMapper {

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
