# Market Data Processor
This is a simplified version of how we process market data updates. 

 We have provided a marketData.txt file with sample market events. 
 The program reads the file and sends each `MarketEvent` to 
 the `MarketEventsProcessor`. 

## Assignment
You need to do the following:
1. Understand the application
2. Complete the Quote class
3. Implement `MarketEventsProcessor.processEvents` 
4. Implement `MarketEventsProcessor.onEvent`
5. Print `Quote` string: _BID 98.00 ASK 100.00 MID 99.00_ in `Application.main`  

Ideally, we don't want you to be spending more than 30 min on this task

## Additional Information
Please be prepared to talk or showcase these during the interview:
1. Different ways to test 
2. Performance improvements for different scenarios 