package com.somestartup.app.service;

import com.somestartup.app.model.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;

@Service
public class ClientService {
    @Autowired
    private LoanService loanService;

    @PostConstruct
    public void init() {
        Loan loan = new Loan();
        loan.setStartDate(new Date());
        loan.setEndDate(new Date());
        loan.setAmount(100.0);

        loan = loanService.create(loan);

        System.out.println(">>> Loan ID: " + loan.getId());

        loan = loanService.getById(loan.getId());

        System.out.println(">>> Loan found: " + (loan!=null));

        loan = loanService.calculateInstallments(loan);
        loan = loanService.calculateInterest(loan);

        System.out.println(">>> Loan installments: " + loan.getInstallments());
        System.out.println(">>> Loan country: " + loan.getCountry());
        System.out.println(">>> Loan interest: " + loan.getInterest());
    }
}
