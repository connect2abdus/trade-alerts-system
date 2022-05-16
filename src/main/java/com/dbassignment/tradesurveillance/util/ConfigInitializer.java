package com.dbassignment.tradesurveillance.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigInitializer {
	@Bean
    public RestTemplate restTesmplate() {
        return new RestTemplate();
    }
	
	@Bean
	  public RetryTemplate retryTemplate() {

	    int maxAttempt = Integer.parseInt("5");//env.getProperty("maxAttempt")
	    int retryTimeInterval = Integer.parseInt("5000");//env.getProperty("retryTimeInterval")

	    SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy();
	    retryPolicy.setMaxAttempts(maxAttempt);

	    FixedBackOffPolicy backOffPolicy = new FixedBackOffPolicy();
	    backOffPolicy.setBackOffPeriod(retryTimeInterval); // 1.5 seconds

	    RetryTemplate template = new RetryTemplate();
	    template.setRetryPolicy(retryPolicy);
	    template.setBackOffPolicy(backOffPolicy);

	    return template;
	  }
	
/*	@Bean
	  public RetryTemplate retryTemplate() {

	    int maxAttempt = Integer.parseInt("5");//env.getProperty("maxAttempt")
	    int retryTimeInterval = Integer.parseInt("2000");//env.getProperty("retryTimeInterval")

	    SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy();
	    retryPolicy.setMaxAttempts(maxAttempt);

	    FixedBackOffPolicy backOffPolicy = new FixedBackOffPolicy();
	    backOffPolicy.setBackOffPeriod(retryTimeInterval); // 1.5 seconds

	    RetryTemplate template = new RetryTemplate();
	    template.setRetryPolicy(retryPolicy);
	    template.setBackOffPolicy(backOffPolicy);

	    return template;
	  }*/
}
