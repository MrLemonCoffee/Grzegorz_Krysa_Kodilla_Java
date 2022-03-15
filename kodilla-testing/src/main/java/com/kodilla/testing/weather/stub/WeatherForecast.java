package com.kodilla.testing.weather.stub;

import java.util.*;


public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {

            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0); // [1]
        }
        return resultMap;
    }
    public double averageTemperature(){
        double temperatureSum = 0;
        List<Double> temperaturesList = new ArrayList<>();

        for(Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()){
            temperaturesList.add(temperature.getValue());
            temperatureSum += temperature.getValue();
        }
        double average = temperatureSum/temperaturesList.size();
        return average;
    }
    public double medianTemperature(){
        int x = 0;
        double median = 0;
        List<Double> temperaturesList = new ArrayList<>();


        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            temperaturesList.add(temperature.getValue());
        }
        Collections.sort(temperaturesList);

        if (temperaturesList.size() % 2 == 0) {
            x = temperaturesList.size() / 2;
            median = (temperaturesList.get(x -1) + temperaturesList.get(x)) / 2;

        } else {
            x = (temperaturesList.size()) / 2;
            median = temperaturesList.get(x);
        }

        return median;
    }
}