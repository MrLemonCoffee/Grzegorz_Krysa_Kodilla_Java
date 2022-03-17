package com.kodilla.exception.test;

public class RouteNotFoundExceptionHandling {

    public void findFlight(Flight flight) {

        SearchFlights searcher = new SearchFlights();
        try {
            searcher.findFlight(flight);
        } catch (RouteNotFoundException e) {
            System.out.println("No this flights at base");
        } finally {
            System.out.println("Search is ending");
        }
    }
}