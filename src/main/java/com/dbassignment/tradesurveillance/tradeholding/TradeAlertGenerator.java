package com.dbassignment.tradesurveillance.tradeholding;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

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

	@Autowired
	HoldingTransactionsRepository holdingTransactionsRepository;

	@Autowired
	TraderInfoRepository traderInfoRepository;

	public static String getCurrentLocalDateTimeStamp() {
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS"));
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub

		System.out
				.println("--------------------------Started after Spring boot application -------------------------!");

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
						// Timestamp instant= Timestamp.from(Instant.now());
						TraderInfo traderInfo = new TraderInfo(alert.getFirstName(), alert.getLastName(),
								alert.getNationality(), alert.getCountryOfResidence(), alert.getDateOfBirth(),
								alert.getTraderId(), alert.getStockId(), Timestamp.from(Instant.now()));
						flaggedTradersList.add(traderInfo);
					}

					if (flaggedTradersList.size() > 0)
						traderInfoRepository.saveAll(flaggedTradersList); // save traders.
					//update scanned status
					for (TraderInfo traderInfo : flaggedTradersList) {
						holdingTransactionsRepository.updateIsScanned(true, traderInfo.getTraderId(),
								traderInfo.getStockId());
						// Call the rest Regulatory API an report; 

					}

				}

			}
		}, 0, 20 * 1000);

		// 2m = 2*60*1000 ms
		System.out.println(getCurrentLocalDateTimeStamp());

	}

}
