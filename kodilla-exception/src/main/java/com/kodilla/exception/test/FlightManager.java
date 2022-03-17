package com.kodilla.exception.test;

import java.util.ArrayList;
import java.util.List;

public class FlightManager {
    public static void main(String[] args) {

        Flight flight1 = new Flight("Warsaw", "Chicago");
        Flight flight2 = new Flight("Berlin", "Warsaw");
        Flight flight3 = new Flight("Los Angeles", "London");
        List<Flight> flightsToFind = new ArrayList<>();
        flightsToFind.add(flight1);
        flightsToFind.add(flight2);
        flightsToFind.add(flight3);

        for(Flight theFlight : flightsToFind) {
            SearchFlights flightFinder = new SearchFlights();
            System.out.println("Searching flights from " + theFlight.getDepartureAirport() + " to " + theFlight.getArrivalAirport());
            System.out.print("Result: ");
            try {
                if (flightFinder.findFlight(theFlight)) {
                    System.out.println("possible");
                } else {
                    System.out.println("impossible");
                }
            } catch (RouteNotFoundException e) {
                System.out.println("Departure airport's or arrival airport's name is not valid.");
            }
        }
    }
}