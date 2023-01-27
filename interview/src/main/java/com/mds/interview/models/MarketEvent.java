package com.mds.interview.models;


import java.time.LocalTime;


public class MarketEvent {

    private LocalTime timestamp;
    private MarketPrice marketPrice;


    public LocalTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalTime timestamp) {
        this.timestamp = timestamp;
    }


    public MarketPrice getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(MarketPrice marketPrice) {
        this.marketPrice = marketPrice;
    }

}
