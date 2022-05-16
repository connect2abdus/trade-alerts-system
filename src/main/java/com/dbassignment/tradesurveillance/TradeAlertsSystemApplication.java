package com.dbassignment.tradesurveillance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

import com.dbassignment.tradesurveillance.activemq.MessageSender;

@EnableRetry
@SpringBootApplication

public class TradeAlertsSystemApplication {
	
	private static Logger log = LoggerFactory.getLogger(MessageSender.class);

	public static void main(String[] args) {
		SpringApplication.run(TradeAlertsSystemApplication.class, args);
		
		log.info("------------***************Trade Alert System Started Successfully!!!***************-------------");
		
	}

}
