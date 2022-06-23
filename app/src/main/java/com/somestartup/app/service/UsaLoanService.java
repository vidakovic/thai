package com.somestartup.app.service;

import com.somestartup.app.model.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@ConditionalOnProperty(value = "thai.country", havingValue = "usa")
public class UsaLoanService implements LoanService {

    @Autowired
    private LoanFeatureOne featureOne;
    @Autowired
    private LoanFeatureTwo featureTwo;
    @Autowired
    private LoanFeatureThree featureThree;

    @Autowired
    private CalculateInterest calc;

    @Value("${usa.interest}")
    private double baseInterest;

    public Loan create(Loan loan) {
        // TODO: implement this!
        loan.setId(UUID.randomUUID().toString());
        loan.setCountry("USA");

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

    public Loan calculateInterest(Loan loan) {
        calc.calculateInterest(loan, baseInterest);
        return loan;
    }

    // ... more functions
}
