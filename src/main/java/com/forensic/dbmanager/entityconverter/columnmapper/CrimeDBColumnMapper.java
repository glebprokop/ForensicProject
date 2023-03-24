package com.forensic.dbmanager.entityconverter.columnmapper;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
