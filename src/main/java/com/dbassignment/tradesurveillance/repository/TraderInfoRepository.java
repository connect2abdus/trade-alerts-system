package com.dbassignment.tradesurveillance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbassignment.tradesurveillance.model.TraderInfo;

public interface TraderInfoRepository extends JpaRepository<TraderInfo, Long>{
	
	

}
