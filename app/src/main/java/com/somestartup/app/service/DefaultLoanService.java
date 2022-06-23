package com.somestartup.app.service;

import com.somestartup.app.model.Loan;
import org.springframework.beans.factory.annotation.Value;

public class DefaultLoanService extends AbstractLoanService {

    @Value("${thai.country}")
    private String country;

    public Loan create(Loan loan) {
        loan.setCountry(country);

        loan = loanRepository.save(loan);

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
