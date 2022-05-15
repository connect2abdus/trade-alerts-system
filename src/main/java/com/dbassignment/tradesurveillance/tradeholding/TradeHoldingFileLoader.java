package com.dbassignment.tradesurveillance.tradeholding;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.dbassignment.tradesurveillance.model.HoldingFiles;
import com.dbassignment.tradesurveillance.model.HoldingTransactions;
import com.dbassignment.tradesurveillance.repository.HoldingFilesRepository;
import com.dbassignment.tradesurveillance.repository.HoldingTransactionsRepository;

/**
 * 
 * @author Abdus Mondal
 * TradeHoldingFileLoader loads the data from tradeholding_YYYY-MM-DD-HHmmss.SSS.txt to transaction table.  
 *
 */
@Component
public class TradeHoldingFileLoader implements ApplicationRunner{
	
	//public static void main(String[] args) {}
	
	@Autowired
	HoldingFilesRepository holdingFilesRepository;
	
	@Autowired
	HoldingTransactionsRepository holdingTransactionsRepository;

public static String getCurrentLocalDateTimeStamp() {
    return LocalDateTime.now()
       .format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS"));
}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub

        System.out.println("--------------------------Started after Spring boot application -------------------------!");

Timer timer = new Timer();
timer.schedule(new TimerTask() {
	
	String businessDate = "2022-05-16";
	int i = 0;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		 List<HoldingFiles> holdingFilesList =  getHoldingFileList(false);
		 if(holdingFilesList != null && holdingFilesList.size() > 0) {
			 for(HoldingFiles holdingFiles: holdingFilesList) {
				String fileLocation =  holdingFiles.getFilelocation();
				File source = new File(fileLocation);
				try {
					BufferedReader br = new BufferedReader(new FileReader(source));
					
					String header = br.readLine();
					
					 String record;
				        // Condition holds true till
				        // there is character in a string
					 String[] fields = null;
				        while ((record = br.readLine()) != null) {
				        	  // Print the string
				        	
				        	fields =  record.split(";");
				        	if(fields.length != 11) {
				        		System.out.println("Insufficient records" + record);
				        	}else {
				        		HoldingTransactions holdingTransactions = new HoldingTransactions(0L, 
				        				fields[0],//firstName, 
				        				fields[1],//lastName, 
				        				fields[2],//nationality, 
				        				fields[3],//countryOfResidence, 
				        				fields[4],//dateOfBirth, 
				        				fields[5],//traderId, 
				        				fields[8],//stockId, 
				        				new Double(fields[6]),//tradeAmount, 
				        				fields[7],//currency, 
				        				fields[9],//buyOrSell, 
				        				Timestamp.valueOf(fields[10]),//tradeExecutionTime, 
				        				Timestamp.from(Instant.now()),//transactionCreationTime, Timestamp instant= Timestamp.from(Instant.now());  
				        				false,//isScanned, 
				        				null);//scanDateTime
				        	holdingTransactionsRepository.save(holdingTransactions);
				        	
				        	//System.out.println("---------Record saved for ---: " + holdingTransactions);
				        	
				        	}
				        	
				          //  System.out.println(st);
					
				        }
				          
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				holdingFiles.setIsprocessed(true);
				holdingFiles.setLoadstatus("SUCCESS");
				
				holdingFilesRepository.save(holdingFiles);
				i++;
				if(i==1) {
					try {
						Thread.sleep(30*60*1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			 }
		 }
		 
		
		
	}
}, 0, 15*1000);
	
// 2m = 2*60*1000 ms
	System.out.println(getCurrentLocalDateTimeStamp());	

    
		
	}
	
	
	public List<HoldingFiles> getHoldingFileList(boolean isprocessed){
		
		return holdingFilesRepository.findByIsprocessed(isprocessed);	 
	}
	
	//@PutMapping("/tutorials/{id}")
	public void saveHoldingFileDetails(File holdingFile, String errorMessage) {
		
		HoldingFiles holdingFiles = new HoldingFiles();
		
		holdingFiles.setFilename(holdingFile.getName());
		
		Timestamp instant= Timestamp.from(Instant.now());  
		holdingFiles.setFileCreationTimestamp(instant);
		
		holdingFiles.setFilelocation(holdingFile.getAbsolutePath());
		
		holdingFiles.setErrorlog(errorMessage);
		
		holdingFilesRepository.save(holdingFiles);
		
		System.out.println( "---------- "+ holdingFile.getName() + " holding file got generated from trading system ------------");
		
		
	}
}
