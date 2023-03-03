package com.forensic.entity.crime;

/**
 * Enum class to store the values of the crime table attributes.
 */
@Deprecated
public enum CrimeDBFields {
    ID("id"),
    POLICEREGNUMBER("police_reg_number"),
    CASEINVESTIGATIONNUMBER("case_investigation_number"),
    CRIMINALCODEARTICLENUMBER("criminal_code_article_number"),
    DESCRIPTION("description"),
    CRIMEDATE("crime_date");

    private String tableAttributeName;

    CrimeDBFields(String tableAttributeName){
        this.tableAttributeName = tableAttributeName;
    }

    public String getTableAttributeName(){
        return this.tableAttributeName;
    }

}
