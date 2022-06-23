package com.somestartup.app.service;

import com.somestartup.app.model.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Random;

@Component
public class CalculateInterest {

    @Autowired
    private Random rand;

    public Loan calculateInterest(Loan loan, double baseInterest){
        //Generates random interest based on +-0.01 average interest
        double random = rand.nextDouble() * 0.01;
        double interest = (baseInterest - 0.01) + (random * (0.02));

        loan.setInterest(interest);
        return loan;
    }
}
