package com.somestartup.app.service;

import com.somestartup.app.model.Loan;
import org.springframework.beans.factory.annotation.Value;

import java.util.UUID;

public class DefaultLoanService implements LoanService {

    @Value("${thai.country}")
    private String country;

    public Loan create(Loan loan) {
        // TODO: implement this!
        loan.setId(UUID.randomUUID().toString());
        loan.setCountry(country);

        return loan;
    }

    public Loan calculateInstallments(Loan loan) {
        // TODO: implement this
        loan.setInstallments(10);

        return loan;
    }

    public Loan calculateInterest(Loan loan){
        loan.setInterest(0.05);

        return loan;
    }
}
