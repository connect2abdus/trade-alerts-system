package com.dbassignment.tradesurveillance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbassignment.tradesurveillance.model.HoldingFiles;

public interface HoldingFilesRepository extends JpaRepository<HoldingFiles, Long> {
  public List<HoldingFiles> findByIsprocessed(boolean isprocessed);

  //List<HoldingFiles> findByTitleContaining(String title);
}
