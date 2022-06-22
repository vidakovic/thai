package com.somestartup.app.service;

import com.somestartup.app.model.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@ConditionalOnProperty(value = "thai.country", havingValue = "estonia")
public class EstoniaLoanService implements LoanService {

    @Autowired
    private LoanFeatureOne featureOne;

    public Loan create(Loan loan) {
        // TODO: implement this!
        loan.setId(UUID.randomUUID().toString());
        loan.setCountry("Estonia");

        return loan;
    }

    public Loan calculateInstallments(Loan loan) {
        loan = featureOne.doSomethingWithit(loan);

        // TODO: implement this
        loan.setInstallments(14);

        return loan;
    }
}
