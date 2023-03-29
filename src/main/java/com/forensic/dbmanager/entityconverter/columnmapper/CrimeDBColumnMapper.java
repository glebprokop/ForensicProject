package com.forensic.dbmanager.entityconverter.columnmapper;

import com.forensic.dbmanager.entityconverter.paramsource.crime.CrimeMapSqlParameterSourceManager;
import com.forensic.dbmanager.query.QueryCreator;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Custom data base column mapper, used for generate {@link MapSqlParameterSource} parameters map for
 * NamedJDBCTemplate module. <p>
 * Also this class used for creating custom SQL requests - see {@link QueryCreator} class
 *
 */
@Component
@Data
public class CrimeDBColumnMapper implements AbstractDBColumnMapper{
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
    public List<String> allColumns(){
        List<String> allColumns = new ArrayList<>();
        allColumns.add(id);
        allColumns.add(policeRegNumber);
        allColumns.add(caseInvestigationNumber);
        allColumns.add(criminalCodeArticleNumber);
        allColumns.add(description);
        allColumns.add(crimeDate);

        return allColumns;
    }
}
