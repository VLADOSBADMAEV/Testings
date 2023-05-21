package org.example;

public class Service {
    public int averageSale(int[]sales){
        int fullPrice = 0;
        for(int sale : sales){
            fullPrice += sale;
        }
        return fullPrice / sales.length;
    }
}
