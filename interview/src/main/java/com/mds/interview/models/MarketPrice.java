package com.mds.interview.models;


public class MarketPrice {

    private String field;
    private Double value;


    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }


    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "MarketPrice{" +
                "field='" + field + '\'' +
                ", value=" + value +
                '}';
    }
}
