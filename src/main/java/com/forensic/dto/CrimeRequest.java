package com.forensic.dto;

import com.forensic.entity.crime.Crime;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

/**
 * Data transfer object for {@link Crime} entity class.
 * WARNING: NOT USED YET!
 *
 */
@Data
@Builder
public class CrimeRequest {

    private Long id;

    private Long policeRegNumber;

    private Long caseInvestigationNumber;

    private Long criminalCodeArticleNumber;

    private String description;

    private Timestamp crimeDate;

    public Crime buildCrime(){
        return Crime.builder()
                .id(this.id)
                .crimeDate(this.crimeDate)
                .policeRegNumber(this.policeRegNumber)
                .caseInvestigationNumber(this.caseInvestigationNumber)
                .criminalCodeArticleNumber(this.criminalCodeArticleNumber)
                .description(this.description)
                .build();
    }

    public static CrimeRequest buildCrimeRequest(Crime crime){
        return CrimeRequest.builder()
                .id(crime.getId())
                .crimeDate(crime.getCrimeDate())
                .policeRegNumber(crime.getPoliceRegNumber())
                .caseInvestigationNumber(crime.getCaseInvestigationNumber())
                .criminalCodeArticleNumber(crime.getCriminalCodeArticleNumber())
                .description(crime.getDescription())
                .build();
    }
}
