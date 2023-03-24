package com.forensic.entity.address;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {

    /**
     * Var used for identification of address. Analog of field "id" in data source for ORM.
     * Usually it`s primary key
     */
    private Long addressId;

    /**
     * Var used for description of region in country
     */
    private String region;

    /**
     * Var used for description of district in region
     */
    private String district;

    /**
     * Var used for description of locality in district
     */
    private String locality;

    /**
     * Var used for description of building number in locality
     */
    private String building;

    /**
     * Var used for description of the number of corps for building (if exist)
     */
    private String corps;

    /**
     * Var used for description of the number of apartment for building (if exist)
     */
    private String apartment;

    /**
     * Var used for any commentary of address. May be used for add more info about address (such as number of the road,
     * distance to the destination and so on)
     */
    private String comment;

}
