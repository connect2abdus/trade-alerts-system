package com.dbassignment.tradesurveillance.repository;

import java.sql.Timestamp;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dbassignment.tradesurveillance.model.HoldingTransactions;
import com.dbassignment.tradesurveillance.model.TradeAlert;

public interface HoldingTransactionsRepository extends JpaRepository<HoldingTransactions, Long> {
	public List<HoldingTransactions> findByIsScanned(boolean isScanned);

	public List<HoldingTransactions> findByIsScannedAndTradeExecutionTime(boolean isScanned,
			Timestamp tradeExecutionTime);

	// List<HoldingFiles> findByTitleContaining(String title);

	@Query("SELECT "
			+ "    new   com.dbassignment.tradesurveillance.model.TradeAlert(ht.firstName, ht.lastName, ht.nationality, "
			+ "	   ht.countryOfResidence, ht.dateOfBirth, ht.traderId, ht.stockId) " + " FROM "
			+ "    HoldingTransactions ht where ht.isScanned != true " + " GROUP BY " + "    ht.stockId" + " having count(*) > 5 ")
	public List<TradeAlert> getAlerts();

	@Modifying
	@Transactional
	@Query("Update HoldingTransactions ht SET ht.isScanned=:isscanned WHERE ht.traderId=:traderId and ht.stockId=:stockId")
	public void updateIsScanned(@Param("isscanned") Boolean isscanned, @Param("traderId") String traderId,
			@Param("stockId") String stockId);

}
