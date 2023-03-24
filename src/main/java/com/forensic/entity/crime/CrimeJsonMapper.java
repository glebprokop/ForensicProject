package com.forensic.entity.crime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;

/**
 * The JSON mapper using to parse JSON objects to the entity {@link Crime}
 *
 */
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class CrimeJsonMapper {

    private Long id;

    private Long policeRegNumber;

    private Long caseInvestigationNumber;

    private Long criminalCodeArticleNumber;

    private String description;

    private Timestamp crimeDate;
}
