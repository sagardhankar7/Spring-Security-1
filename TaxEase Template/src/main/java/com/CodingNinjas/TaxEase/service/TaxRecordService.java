package com.CodingNinjas.TaxEase.service;

import com.CodingNinjas.TaxEase.dto.TaxRecordDto;
import com.CodingNinjas.TaxEase.exception.TaxRecordNotFoundException;
import com.CodingNinjas.TaxEase.model.TaxRecord;
import com.CodingNinjas.TaxEase.repository.TaxRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxRecordService {

    /*
        This is the service class for TaxRecord, you need to complete the class by doing the following:

            a. Use appropriate annotations.
            b. Complete the methods given below.
            c. Autowire the necessary dependencies.
     */
    @Autowired
    TaxRecordRepository taxRecordRepository;


    public TaxRecord getTaxRecordById(Long id) {
        return taxRecordRepository.findById(id).orElseThrow(()->new TaxRecordNotFoundException("No Tax Record Found with id: "+ id));
    }


    public List<TaxRecord> getAllRecords() {
        return taxRecordRepository.findAll();
    }


    public void createTaxRecord(TaxRecordDto taxRecordDto) {
//        TaxRecord record = new TaxRecord(taxRecordDto.getUserName(), taxRecordDto.getTaxYear(), taxRecordDto.getIncome(), taxRecordDto.getDeductions(), false);
        TaxRecord record = TaxRecord.builder().userName(taxRecordDto.getUserName())
                        .Income(taxRecordDto.getIncome())
                                .taxYear(taxRecordDto.getTaxYear())
                                        .deductions(taxRecordDto.getDeductions())
                                                .build();
        taxRecordRepository.save(record);
    }


    // This is the service method for the api which allows user to update a tax Record by sending the record id as a pathVariable and TaxRecordDto as a RequestBody
    public void updateTaxRecord(TaxRecordDto taxRecordDto, Long id) {
        TaxRecord record = taxRecordRepository.findById(id).orElseThrow(()-> new TaxRecordNotFoundException("No Tax record found with id: "+ id));
        record.setTaxYear(taxRecordDto.getTaxYear());
        record.setIncome(taxRecordDto.getIncome());
        record.setDeductions(taxRecordDto.getDeductions());
        record.setUserName(taxRecordDto.getUserName());
        taxRecordRepository.save(record);
    }


    public void deleteTaxRecord(Long id) {
        TaxRecord record = taxRecordRepository.findById(id).orElseThrow(()->new TaxRecordNotFoundException("No Tax record with id {} is found"+ id));
        taxRecordRepository.deleteById(id);
    }


    public List<TaxRecord> getRecordsByName(String userName) {
        return taxRecordRepository.findByUserName(userName);
    }


    // This is the service method for the api which allows user to approve a tax Record by sending the record id as a pathVariable
    public void approveTaxFiling(Long id) {
        TaxRecord record = taxRecordRepository.findById(id).orElseThrow(()->new TaxRecordNotFoundException("No Tax is found with id"+ id));
        record.setFilingApproved(true);
        taxRecordRepository.save(record);
    }


    // This is the service method for the api which allows user to reject a tax Record by sending the record id as a pathVariable
    public void rejectTaxFiling(Long id) {
        TaxRecord record = taxRecordRepository.findById(id).orElseThrow(()->new TaxRecordNotFoundException("No Tax is found with id "+id));
        record.setFilingApproved(false);
        taxRecordRepository.save(record);
    }
}
