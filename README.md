### Trade Alerts System - Design end to end Trade alert system to capture and report the suspecious activity of while trading by traders.
As per the original requirement, here is the various components based on the system design diagram shared already.
- TradeHoldingGenerator -  This is holding file generator service which continuously generate holding files (with predefined format) and copy it in a common landing area. In our case it is trade-alerts-system\src\main\resources\holdingfiles. We are generating the file in each 2 min.
- TradeHoldingFileLoader - This is a file watcher service which continuously monitor the common landing area if there are any new files has arrived. This service load 
the file in database.
- TradeAlertGenerator - This is alert engine service. It applies the rule to identify the suspecious activity and capture the details (predefined details)
- RegulatorReportController - This is Regulator API Service controller which is used to receive and expose the reported alerts to channel (such as queue).

### Technology stack used. 
- Java SE 1.8 (JRE 1.8.0_231)
- Windows 10 Home Edition
- Springboot 2.6.7
- h2-1.4.200 
- Springboot embedded activeMQ 5.16.4
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


