package com.somestartup.app.repository;

import com.somestartup.app.model.Loan;
import org.springframework.data.repository.CrudRepository;

public interface LoanRepository extends CrudRepository<Loan, String> {
}
