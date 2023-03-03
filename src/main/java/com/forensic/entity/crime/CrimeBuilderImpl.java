package com.forensic.entity.crime;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDate;

/**
 * Main implementation of {@link CrimeBuilder} interface. Approve to create the
 * new instance of {@link Crime} class.
 *
 * @see Crime
 */
@Deprecated
public class CrimeBuilderImpl implements CrimeBuilder{

    private long policeRegNumber;

    private long caseInvestigationNumber;

    private int criminalCodeArticleNumber;

    private String description;

    private Timestamp crimeDate;

    public CrimeBuilder policeRegNumber(long policeRegNumber) {
        this.policeRegNumber = policeRegNumber;
        return this;
    }

    public CrimeBuilder caseInvestigationNumber(long caseInvestigationNumber) {
        this.caseInvestigationNumber = caseInvestigationNumber;
        return this;
    }

    public CrimeBuilder criminalCodeArticleNumber(int criminalCodeArticleNumber) {
        this.criminalCodeArticleNumber = criminalCodeArticleNumber;
        return this;
    }

    public CrimeBuilder description(String description) {
        this.description = description;
        return this;
    }

    public CrimeBuilder crimeDate(Timestamp crimeDate) {
        this.crimeDate = crimeDate;
        return this;
    }

    public Crime buildCrime(){
        Crime crime = Crime.builder().build(); //Can not use no-args constructor under Lombok. Don`t use this class, please

        crime.setCrimeDate(this.crimeDate);
        crime.setDescription(this.description);
        crime.setCriminalCodeArticleNumber(this.criminalCodeArticleNumber);
        crime.setCaseInvestigationNumber(this.caseInvestigationNumber);
        crime.setPoliceRegNumber(this.policeRegNumber);

        return crime;
    }
}
