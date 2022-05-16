package com.dbassignment.tradesurveillance.tradeholding;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.dbassignment.tradesurveillance.model.TradeAlert;
import com.dbassignment.tradesurveillance.model.TraderInfo;
import com.dbassignment.tradesurveillance.repository.HoldingTransactionsRepository;
import com.dbassignment.tradesurveillance.repository.TraderInfoRepository;

/**
 * 
 * @author Abdus Mondal TradeHoldingFileLoader loads the data from
 *         tradeholding_YYYY-MM-DD-HHmmss.SSS.txt to transaction table.
 *
 */
@Component
public class TradeAlertGenerator implements ApplicationRunner {
	
	private static Logger log = LoggerFactory.getLogger(TradeAlertGenerator.class);
	

	@Autowired
	HoldingTransactionsRepository holdingTransactionsRepository;

	@Autowired
	TraderInfoRepository traderInfoRepository;

	@Autowired
	RestTemplate restTemplate;
	
	public static String getCurrentLocalDateTimeStamp() {
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS"));
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub

		log.info("--------In TradeAlertGenerator: Generating the alerts in each 10 min ----------");

		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			String businessDate = "2022-05-16";
			int i = 0;

			@Override
			public void run() {

				List<TradeAlert> alerts = holdingTransactionsRepository.getAlerts();

				if (alerts != null && alerts.size() > 0) {
					//int i = 1;
					List<TraderInfo> flaggedTradersList = new ArrayList<>();
					for (TradeAlert alert : alerts) {
						// System.out.println(i + " alert " + alert.toString());
						 //Timestamp instant= Timestamp.from(Instant.now());
						
						TraderInfo traderInfo = new TraderInfo(alert.getFirstName(), alert.getLastName(),
								alert.getNationality(), alert.getCountryOfResidence(), alert.getDateOfBirth(),
								alert.getTraderId(), alert.getStockId(), Timestamp.from(Instant.now()).toString());
						flaggedTradersList.add(traderInfo);
					}

					if (flaggedTradersList.size() > 0)
						traderInfoRepository.saveAll(flaggedTradersList); // save traders.
					//update scanned status
					for (TraderInfo traderInfo : flaggedTradersList) {
						holdingTransactionsRepository.updateIsScanned(true, traderInfo.getTraderId(),
								traderInfo.getStockId());
						// Call the rest Regulatory API an report; 
						
						 String firstName = traderInfo.getFirstName();							
							 String lastName=traderInfo.getLastName(); 							
							 String nationality=traderInfo.getNationality();					
							 String countryOfResidence=traderInfo.getCountryOfResidence();							
							 String dateOfBirth=traderInfo.getDateOfBirth();					
							 String traderId=traderInfo.getTraderId();							
							 String stockId=traderInfo.getStockId();							
							 String reportingtime=traderInfo.getReportingtime();

						
						String url = "http://localhost:8090/api/regulator/v1/report-suspecious-trader";
												
						String	requestJson= 	"{\"firstName\":\"" +firstName + "\",\"lastName\":\"" +lastName + "\",\"nationality\":\""+nationality+ 
								"\",\"countryOfResidence\":\"" +countryOfResidence+ "\",\"dateOfBirth\":\""+dateOfBirth+"\",\"traderId\":\"" +traderId+ "\",\"stockId\":\""+stockId+ "\",\"reportingtime\":\"" +
								reportingtime + "\"}";	
						
						
						log.info("--------In TradeAlertGenerator: Alert!! < "+requestJson+ ">");
						
						HttpHeaders headers = new HttpHeaders();
						headers.setContentType(MediaType.APPLICATION_JSON);

						HttpEntity<String> entity = new HttpEntity<String>(requestJson,headers);
						String httpResponse = restTemplate.postForObject(url, entity, String.class);
						log.info("--------In TradeAlertGenerator: Alert submitted to Regulator with status !! < "+httpResponse+ ">");

					}

				}

			}
		}, 0, 20 * 1000);

		// 2m = 2*60*1000 ms
		

	}
	
	

}
