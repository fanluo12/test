package com.mds.interview;


public interface IMarketEventsProcessor<T> {


    void onEvent(T event);

}
