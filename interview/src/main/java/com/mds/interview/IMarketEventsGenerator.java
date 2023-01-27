package com.mds.interview;


import java.util.List;


public interface IMarketEventsGenerator<T> {

    List<T> generateEvents();

}
