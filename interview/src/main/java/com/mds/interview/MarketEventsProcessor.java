package com.mds.interview;


import com.mds.interview.models.MarketEvent;
import com.mds.interview.models.MarketPrice;
import com.mds.interview.models.Quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;


public class MarketEventsProcessor implements IMarketEventsProcessor<MarketEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(MarketEventsProcessor.class);
    private MarketPrice mostRecentBid;
    private MarketPrice mostRecentAsk;



    /**
     *  Most recent + best doesn't make sense
     *  best bid = highest bid, best ask = lowest offer
     *  so best bid = 99, best ask = 98.9
     *  so best is not used, I use most recent instead of most recent best
     */
    public Quote processEvents(final List<MarketEvent> marketEvents) {

        // You have an incoming stream of events, where each event mentions:
        // - a timestamp
        // - a bid or an ask with its associated value
        LOGGER.debug("Get market event: {}", marketEvents);
        // TODO:
        // -- implement the "onEvent" method below, then
        // -- update this "processEvents" method,
        // so that we log a Quote object consisting of the most recent best bid & ask in addition to their average (mid).
        marketEvents.forEach(this::onEvent);

        // TODO:
        // -- return last Quote after processing marketEvents
        return new Quote(mostRecentBid, mostRecentAsk);
    }


    @Override
    public void onEvent(final MarketEvent event) {
        //TODO
        MarketPrice marketPrice  = event.getMarketPrice();
        if (marketPrice.getField().equals("BID")) {
            mostRecentBid = marketPrice;
        }
        else if (marketPrice.getField().equals("ASK")) {
            mostRecentAsk = marketPrice;
        }
        else {
            LOGGER.error("Input is wrong, it should be BID or ASK rather: " + event.getMarketPrice());
            throw new IllegalArgumentException("Field should be BID or ASK!");
        }
    }



}
