### Trade Alerts System - Design end to end Trade alert system to capture and report the suspecious activity of while trading by traders.

### Technology stack used. 
- Java SE 1.8 (JRE 1.8.0_231)
- Windows 10 Home Edition
- Springboot 2.6.7
- h2-1.4.200 
- Springboot embedded activeMQ 5.16.4

As per the original requirement, here is the various components based on the system design diagram shared already.
- TradeHoldingGenerator -  This is holding file generator service which continuously generate holding files (with predefined format) and copy it in a common landing area. In our case it is trade-alerts-system\src\main\resources\holdingfiles. We are generating the file in each 2 min.
- TradeHoldingFileLoader - This is a file watcher service which continuously monitor the common landing area if there are any new files has arrived. This service load 
the file in database.
- TradeAlertGenerator - This is alert engine service. It applies the rule to identify the suspecious activity and capture the details (predefined details)
- RegulatorReportController - This is Regulator API Service controller which is used to receive and expose the reported alerts to channel (such as queue).

### Database Tables
```
- Holds all the ingesting file details , kind of file log 
@Entity
@Table(name = "holdingfiles")
public class HoldingFiles {

}

- Holds all the transactions generated and captured in holding files. In this table the Alert Generation rule is applied. 
@Entity
@Table(name = "holdingtransactions")
public class HoldingTransactions {

}

- Holds the details of the reported traders
@Entity
@Table(name = "traderinfo")
public class TraderInfo implements Serializable {

```
To access in-memory H2 database , when are application is up and running we can log on to the http://localhost:8090/h2-console with password as password and see the tables and content.

### Running the application in the local desktop/laptop
```
$git clone https://github.com/connect2abdus/trade-alerts-system.git
$cd trade-alerts-system
$mvn clean install
Now import the project as a maven project in your IDE like eclipse. Once imported successfully refresh the project.
 
 @SpringBootApplication
public class TradeAlertsSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradeAlertsSystemApplication.class, args);
	}

}
Run the TradeAlertsSystemApplication.java as standard Java Application.
Monitor the console log to see the see the end to end flow.

```
### Testing the flow 
We are using the  trade-alerts-system\tradeholding.txt file which is having two ba data for traders who's activity is reported as a suspecious activity.

```
First_name;Last_Name;Nationality;Country_of_Residence;date_of_birth;unique_Trader_id;Amount;currency;unique_Stock_ID;Buy_or_Sell;Trade_Execution_Date_Time
Maya;Amin;US;US;01011980;US001;10000;USD;US011;BUY;2022-05-16 09:25:24.741
Maya;Amin;US;US;01011980;US001;500;USD;US011;BUY;2022-05-16 09:29:10.700
Maya;Amin;US;US;01011980;US001;2500.50;USD;US011;SELL;2022-05-16 09:30:24.741
Maya;Amin;US;US;01011980;US001;1500.50;USD;US011;SELL;2022-05-16 09:32:24.741
Maya;Amin;US;US;01011980;US001;150;USD;US011;BUY;2022-05-16 09:32:20.741
Maya;Amin;US;US;01011980;US001;150;USD;US011;BUY;2022-05-16 09:32:21.741

Maya1;Amin;US;US;01011980;US002;10000;USD;US0021;BUY;2022-05-16 09:25:24.741
Maya1;Amin;US;US;01011980;US002;500;USD;US0021;BUY;2022-05-16 09:29:10.700
Maya1;Amin;US;US;01011980;US002;2500.50;USD;US0021;SELL;2022-05-16 09:30:24.741
Maya1;Amin;US;US;01011980;US002;1500.50;USD;US0021;SELL;2022-05-16 11:32:24.741
Maya1;Amin;US;US;01011980;US002;150;USD;US0021;BUY;2022-05-16 12:42:20.741
Maya1;Amin;US;US;01011980;US002;150;USD;US0021;BUY;2022-05-16 16:42:21.741

```
Once these transactios pass through the end to end process flow. we will see two Alerts received by the Regulator Queue.

### Test case scenarios 
1. Test case to check if we are receiving the holding file in each 2 min.
2. Receiving the holding file has 200 records.
3. Receiving the holding file has all the required field as per the specification and order mentioned.
4. Validate the positive scenatio to generate the alert.
5. Validate the negative scenatio to generate the alert. Alert does not generate in this case.
6. Report the Alert by calling the Regulatory API call. 
7. Submit an receive the alert from the ActiveMQ queue.
8. If Regulatory API call fails because of connectivity error , retry for 5 time in each 5 sec and log the error if still failing.
 
