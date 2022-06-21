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
        loan.setStart(new Date());
        loan.setEnd(new Date());
        loan.setAmount(100.0);

        loan = loanService.create(loan);

        System.out.println(">>> Loan ID: " + loan.getId());

        loan = loanService.calculateInstallments(loan);

        System.out.println(">>> Loan installments: " + loan.getInstallments());
    }
}
