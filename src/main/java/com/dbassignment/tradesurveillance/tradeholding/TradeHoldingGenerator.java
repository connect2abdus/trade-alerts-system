package com.dbassignment.tradesurveillance.tradeholding;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Abdus Mondal
 * @
 *
 */
@Component
public class TradeHoldingGenerator implements ApplicationRunner{
	
	//public static void main(String[] args) {}

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
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//System.out.println("HI");
		File source = new File("tradeholding.txt");
		
		String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS"));
		currentTime = currentTime.replaceAll(":", "");
		
        File dest = new File("src/main/resources/holdingfiles/tradeholding"+"_"+ businessDate + "-" + currentTime+ ".txt");
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } catch(IOException e){
        	e.printStackTrace();
        }
        finally {
            try {
				is.close();
				 os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           
        }
		
	}
}, 0, 10*1000);
	
// 2m = 2*60*1000 ms
	System.out.println(getCurrentLocalDateTimeStamp());	

    
		
	}
}
