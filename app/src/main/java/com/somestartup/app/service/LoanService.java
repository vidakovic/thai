package com.somestartup.app.service;

import com.somestartup.app.model.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoanService {

    @Autowired
    private LoanFeatureOne featureOne;
    @Autowired
    private LoanFeatureTwo featureTwo;
    @Autowired
    private LoanFeatureThree featureThree;

    public Loan create(Loan loan) {
        // TODO: implement this!
        loan.setId(UUID.randomUUID().toString());

        return loan;
    }

    public Loan calculateInstallments(Loan loan) {
        loan = featureOne.doSomethingWithit(loan);
        loan = featureTwo.doSomethingWithit(loan);
        loan = featureThree.doSomethingWithit(loan);

        // TODO: implement this
        loan.setInstallments(12);

        return loan;
    }

    // ... more functions
}
