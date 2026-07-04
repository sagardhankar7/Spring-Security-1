package com.CodingNinjas.TaxEase.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

/*
    This is the entity class, complete this class by doing the following:

    a. Add the required annotations for making this class an entity.
    b. Add the required lombok annotations for getter, setter and constructors
 */
@Entity
@Data
@Builder
@AllArgsConstructor
public class TaxRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String userName;
    @Column
    private String taxYear;
    @Column
    private int Income;
    @Column
    private int deductions;
    @Column
    private boolean isFilingApproved;

    public TaxRecord() {
    }

    public TaxRecord(String userName, String taxYear, int income, int deductions) {
        this.userName = userName;
        this.taxYear = taxYear;
        Income = income;
        this.deductions = deductions;
    }

    public TaxRecord(String userName, String taxYear, int income, int deductions, boolean isFilingApproved) {
        this.userName = userName;
        this.taxYear = taxYear;
        Income = income;
        this.deductions = deductions;
        this.isFilingApproved = isFilingApproved;
    }
}
