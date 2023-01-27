package com.mds.interview.models;


import java.time.LocalTime;

public class Quote {

    //TODO:
    // -- implement this class
    private MarketPrice bid;
    private MarketPrice ask;
    public Quote() {
    }

    public Quote(MarketPrice bid, MarketPrice ask) {
        this.bid = bid;
        this.ask = ask;
    }

    public MarketPrice getBid() {
        return bid;
    }

    public void setBid(MarketPrice bid) {
        this.bid = bid;
    }

    public MarketPrice getAsk() {
        return ask;
    }

    public void setAsk(MarketPrice ask) {
        this.ask = ask;
    }

    // - ensure this prints "BID 98.00 ASK 100.00 MID 99.00"
    @Override
    public String toString() {
        return String.format("BID %,.2f ASK %,.2f MID %,.2f", bid.getValue(), ask.getValue(), (bid.getValue() + ask.getValue()) / 2);
    }
}
