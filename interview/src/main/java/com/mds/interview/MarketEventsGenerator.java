package com.mds.interview;


import com.mds.interview.models.MarketEvent;
import com.mds.interview.models.MarketPrice;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;


public class MarketEventsGenerator implements IMarketEventsGenerator<MarketEvent> {


    @Override
    public List<MarketEvent> generateEvents() {

        final Resource resource = new DefaultResourceLoader().getResource("classpath:marketData.txt");
        try (Reader reader = new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8)) {

            return new BufferedReader(reader).lines().map(line -> {

                final String[] lineTokens = line.split(" ");

                MarketEvent marketEvent = new MarketEvent();
                marketEvent.setTimestamp(LocalTime.parse(lineTokens[0], DateTimeFormatter.ofPattern("H:m:s")));

                MarketPrice marketPrice = new MarketPrice();
                marketPrice.setField(lineTokens[1]);
                marketPrice.setValue(Double.valueOf(lineTokens[2]));

                marketEvent.setMarketPrice(marketPrice);

                return marketEvent;

            }).collect(Collectors.toList());

        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

}
