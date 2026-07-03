package com.CodingNinjas.TaxEase.model;

/*
    This is the entity class, complete this class by doing the following:

    a. Add the required annotations for making this class an entity.
    b. Add the required lombok annotations for getter, setter and constructors
 */

public class TaxRecord {

    private Long id;
    private String userName;
    private String taxYear;
    private int Income;
    private int deductions;
    private boolean isFilingApproved;

}
