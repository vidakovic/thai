package com.somestartup.app.configuration;

import com.somestartup.app.service.DefaultLoanService;
import com.somestartup.app.service.LoanService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoanConfiguration {

    @Bean
    @ConditionalOnMissingBean(LoanService.class)
    public LoanService loanService() {
        return new DefaultLoanService();
    }
}
