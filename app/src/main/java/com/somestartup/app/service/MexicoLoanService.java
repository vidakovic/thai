package com.somestartup.app.service;

import com.somestartup.app.model.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(value="thai.country", havingValue="mexico")
public class MexicoLoanService extends AbstractLoanService {

    @Autowired
    private LoanFeatureTwo featureTwo;

    @Value("${mexico.interest}")
    private double baseInterest;

    @Value("${thai.city}")
    private String city;

    @Autowired
    private CalculateInterest calc;

    public Loan create(Loan loan){
        loan.setCountry("Mexico");

        loan = loanRepository.save(loan);

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
