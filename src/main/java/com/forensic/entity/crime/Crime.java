package com.forensic.entity.crime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;

/**
 * Class for description the crime entity. Contains the general info about crime
 * such as date, registration numbers, address etc.
 *
 * We use {@link lombok.Lombok} project to have more clear and readable code
 */
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Crime {

    /**
     * Var used for identification of crime. Analog of field "id" in data source for ORM.
     * Usually it`s primary key
     */
    private Long id;

    /**
     * Var used for police registration number. This number is individual for every police department, but may
     * be repeated in diff departments, so this var don`t used for primary key
     */
    private Long policeRegNumber;

    /**
     * Var used for number of criminal case registered in investigation units. This number is individual, but not every crime have criminal case
     */
    private Long caseInvestigationNumber;

    /**
     * Var used for number of article in Criminal Code. This position approve to sort crimes by severity (serious, lesser etc crimes)
     */
    private Long criminalCodeArticleNumber;

    /**
     * Var used for short description of crime. We can use this field to write all interesting information about crime
     */
    private String description;

    /**
     * Var used for description of crime date
     */
    private Timestamp crimeDate;
}
