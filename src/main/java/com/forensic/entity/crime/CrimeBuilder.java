package com.forensic.entity.crime;

import java.sql.Timestamp;
import java.time.LocalDate;

/**
 * The builder interface for creating the {@link Crime} com.forensic.entity instance.
 * All method return the CrimeBuilder instance to approve the link of methods.
 *
 */
@Deprecated
public interface CrimeBuilder {

    /**
     * Add police registration number for builder
     */
    CrimeBuilder policeRegNumber(long policeRegNumber);

    /**
     * Add number of criminal case for builder
     */
    CrimeBuilder caseInvestigationNumber(long caseInvestigationNumber);

    /**
     * Add number of Criminal Code article for builder
     */
    CrimeBuilder criminalCodeArticleNumber(int criminalCodeArticleNumber);

    /**
     * Add short description of crime for builder
     */
    CrimeBuilder description(String description);

    /**
     * Add date of crime for builder
     */
    CrimeBuilder crimeDate(Timestamp crimeDate);

    /**
     * Builder method, creating new crime.
     *
     * @return new instance of {@link Crime} class
     */
    Crime buildCrime();
}
