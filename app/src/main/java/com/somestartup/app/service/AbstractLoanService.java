package com.somestartup.app.service;

import com.somestartup.app.model.Loan;
import com.somestartup.app.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractLoanService implements LoanService {

    @Autowired
    protected LoanRepository loanRepository;

    @Override
    public Loan getById(String id) {
        return loanRepository.findById(id).orElse(null);
    }
}
