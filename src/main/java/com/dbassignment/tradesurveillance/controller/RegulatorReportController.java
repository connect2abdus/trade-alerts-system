package com.dbassignment.tradesurveillance.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbassignment.tradesurveillance.model.TraderInfo;

@CrossOrigin(origins = "http://localhost:8090")
@RestController
@RequestMapping("/api/regulator")
public class RegulatorReportController {
	
	//http://localhost:8090/api/regulator/v1/report-suspecious-trader
	@PostMapping(value = "/v1/report-suspecious-trader", consumes = "application/json")
	public ResponseEntity reportSuspeciousTrader(@RequestBody TraderInfo traderInfo) {
		try {
			System.out.println("-----------In Rest output " + traderInfo.toString());
			
			return ResponseEntity.ok(HttpStatus.OK);
		} catch (Exception e) {
			return  (ResponseEntity) ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT);
		}
	}

}
