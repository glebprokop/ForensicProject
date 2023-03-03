package com.forensic.entity.crime;

import java.sql.Timestamp;

/**
 * Old class for description the crime. Contains the general info about crime
 * such as date, registration numbers, address etc.
 *
 * Now we use {@link lombok.Lombok} project to have more clear and readable code
 *
 * @see Crime
 */
@Deprecated
public class CrimeOld {

    /**
     * Var used for identification of crime. Analog of field "id" in data source for ORM.
     * Usually it`s primary key
     */
    private long id;

    /**
     * Var used for police registration number. This number is individual for every police department, but may
     * be repeated in diff departments, so this var don`t used for primary key
     */
    private long policeRegNumber;

    /**
     * Var used for number of criminal case registered in investigation units. This number is individual, but not every crime have criminal case
     */
    private long caseInvestigationNumber;

    /**
     * Var used for number of article in Criminal Code. This position approve to sort crimes by severity (serious, lesser etc crimes)
     */
    private long criminalCodeArticleNumber;

    /**
     * Var used for short description of crime. We can use this field to write all interesting information about crime
     */
    private String description;

    /**
     * Var used for short description of crime. We can use this field to write all interesting information about crime
     */
    private Timestamp crimeDate;

    public CrimeOld() {
        super();
    }

    public CrimeOld(long policeRegNumber, long caseInvestigationNumber,
                 long criminalCodeArticleNumber, String description, Timestamp crimeDate) {
        this.policeRegNumber = policeRegNumber;
        this.caseInvestigationNumber = caseInvestigationNumber;
        this.criminalCodeArticleNumber = criminalCodeArticleNumber;
        this.description = description;
        this.crimeDate = crimeDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPoliceRegNumber() {
        return policeRegNumber;
    }

    public void setPoliceRegNumber(long policeRegNumber) {
        this.policeRegNumber = policeRegNumber;
    }

    public long getCaseInvestigationNumber() {
        return caseInvestigationNumber;
    }

    public void setCaseInvestigationNumber(long caseInvestigationNumber) {
        this.caseInvestigationNumber = caseInvestigationNumber;
    }

    public long getCriminalCodeArticleNumber() {
        return criminalCodeArticleNumber;
    }

    public void setCriminalCodeArticleNumber(long criminalCodeArticleNumber) {
        this.criminalCodeArticleNumber = criminalCodeArticleNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCrimeDate() {
        return crimeDate;
    }

    public void setCrimeDate(Timestamp crimeDate) {
        this.crimeDate = crimeDate;
    }

    @Override
    public String toString() {
        return "Crime{" +
                "id=" + id +
                ", policeRegNumber=" + policeRegNumber +
                ", caseInvestigationNumber=" + caseInvestigationNumber +
                ", criminalCodeArticleNumber=" + criminalCodeArticleNumber +
                ", description='" + description + '\'' +
                ", crimeDate=" + crimeDate +
                '}';
    }
}
