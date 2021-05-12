package DestinationAirport.SharedRegion;

import DestinationAirport.Stubs.*;
import genclass.GenericIO;

/**
 * Where passengers leave the airport.
 */
public class DestinationAirport {

    /**
     * GeneralRepos class for debugging.
     */
    private final GeneralRepos repos;

    // configurations
    private int numberOfPassengersLeavingThePlane;

    /**
     * DestinationAirport class constructor.
     * @param repos
     */
    public DestinationAirport(GeneralRepos repos) {
        this.repos = repos;
    }

    /* ****************************** PASSENGER ***************************** */
    /**
     * The passenger leaves airport. It is called by a passenger.
     */
    public synchronized void leaveAirport() {
        GenericIO.writelnString("(26) Passenger leave airport");
        numberOfPassengersLeavingThePlane++;
    }
}
