package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class SearchFlights {

    public boolean findFlight(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> flightsMap = new HashMap<>();
        flightsMap.put("Warsaw", true);
        flightsMap.put("Chicago", true);
        flightsMap.put("Berlin", true);
        flightsMap.put("Buenos Aires", false);
        flightsMap.put("Los Angeles", true);
        flightsMap.put("London", false);

        if(flightsMap.containsKey(flight.getArrivalAirport()) && flightsMap.get(flight.getArrivalAirport())){
            return flightsMap.get(flight.getArrivalAirport());
        }else {
            throw  new RouteNotFoundException();
        }
    }

}