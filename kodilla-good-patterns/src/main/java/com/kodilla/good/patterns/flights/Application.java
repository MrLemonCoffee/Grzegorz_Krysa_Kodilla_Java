package com.kodilla.good.patterns.flights;

public class Application {
    public static void main(String[] args) {

        CityObjectGetter cityObjectGetter = new CityObjectGetter();
        FlightSearch flightSearch = new FlightSearch();

        try {
            flightSearch.showFlightsFrom(cityObjectGetter.get("Warszawa"));
        } catch (CityObjectGetterException e) {
            System.out.println("There is no such city.");
        }

        try {
            flightSearch.showFlightsTo(cityObjectGetter.get("Radom"));
        } catch (CityObjectGetterException e) {
            System.out.println("There is no such city.");
        }

        try {
            flightSearch.showDirectFlight(cityObjectGetter.get("Warszawa"), cityObjectGetter.get("Radom"));
        } catch (CityObjectGetterException e) {
            System.out.println("There is no such city.");
        }

        try {
            flightSearch.showDirectFlight(cityObjectGetter.get("Warszawa"), cityObjectGetter.get("Gdańsk"));
        } catch (CityObjectGetterException e) {
            System.out.println("There is no such city.");
        }

        try {
            flightSearch.showIndirectFlight(cityObjectGetter.get("Warszawa"), cityObjectGetter.get("Radom"));
        } catch (CityObjectGetterException e) {
            System.out.println("There is no such city.");
        }
    }
}
