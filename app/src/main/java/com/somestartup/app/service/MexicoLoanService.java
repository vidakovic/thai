package com.somestartup.app.service;

import com.somestartup.app.model.Loan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@Service
@ConditionalOnProperty(value="thai.country", havingValue="mexico")
public class MexicoLoanService implements LoanService {

    @Autowired
    private LoanFeatureTwo featureTwo;

    @Value("${mexico.interest}")
    private double baseInterest;

    @Value("${thai.city}")
    private String city;

    @Autowired
    private CalculateInterest calc;

    public Loan create(Loan loan){
        loan.setId(UUID.randomUUID().toString());
        loan.setCountry("Mexico");


        return loan;
    }

    public Loan calculateInstallments(Loan loan){
        loan = featureTwo.doSomethingWithit(loan);

        loan.setInstallments(20);

        return loan;
    }

    public Loan calculateInterest(Loan loan) {
        loan = featureTwo.doSomethingWithit(loan);

        if(city.equals("mexico_city")){
            loan.setInterest(0.04);
        } else {
            calc.calculateInterest(loan, baseInterest);
        }

        return loan;

    }


}
