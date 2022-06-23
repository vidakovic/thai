package com.somestartup.app.service;

import com.somestartup.app.model.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
@ConditionalOnProperty(value = "thai.country", havingValue = "estonia")
public class EstoniaLoanService implements LoanService {

    @Autowired
    private LoanFeatureOne featureOne;

    @Autowired
    private LoanFeatureThree featureThree;

    @Autowired
    private CalculateInterest calc;

    @Value("${estonia.interest}")
    private double baseInterest;

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
    public Loan calculateInterest(Loan loan) {

        loan = featureThree.doSomethingWithit(loan);

        calc.calculateInterest(loan, baseInterest);

        return loan;

    }
}
