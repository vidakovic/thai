package com.somestartup.app.service;

import com.somestartup.app.model.Loan;

public interface LoanService {
    Loan create(Loan loan);

    Loan getById(String id);

    Loan calculateInstallments(Loan loan);

    Loan calculateInterest(Loan loan);
}
