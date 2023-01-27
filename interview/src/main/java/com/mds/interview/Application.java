package com.mds.interview;

import com.mds.interview.models.Quote;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.util.List;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@SuppressWarnings("HideUtilityClassConstructor") // Spring boot application must have public constructor
public class Application {

    public static void main(final String[] args) {

        SpringApplication.run(Application.class, args);

        Quote lastQuote = new MarketEventsProcessor().processEvents(new MarketEventsGenerator().generateEvents());

        //TODO:
        // - ensure this prints "BID 98.00 ASK 100.00 MID 99.00"
        System.out.println(lastQuote.toString());
    }

}
