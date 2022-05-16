package com.dbassignment.tradesurveillance.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbassignment.tradesurveillance.activemq.MessageSender;
import com.dbassignment.tradesurveillance.model.TraderInfo;

@CrossOrigin(origins = "http://localhost:8090")
@RestController
@RequestMapping("/api/regulator")
public class RegulatorReportController {
	private static Logger log = LoggerFactory.getLogger(RegulatorReportController.class);
	

	@Autowired
	MessageSender sender;

	@PostMapping(value = "/v1/report-suspecious-trader", consumes = "application/json")
	public ResponseEntity reportSuspeciousTrader(@RequestBody TraderInfo traderInfo) {
		try {
			System.out.println("-----------In Rest output " + traderInfo.toString());
			log.info("In RegulatorReportController: Received the Suspecious Trader info. Sending it to the regulator queue");
			sender.send(traderInfo);
			log.info("In RegulatorReportController: Trader details is reported to Regulator");

			return ResponseEntity.ok(HttpStatus.OK);
		} catch (Exception e) {
			return (ResponseEntity) ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT);
		}
	}

}
