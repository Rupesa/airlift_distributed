package Passenger.Main;

import Passenger.EntitiesState.*;
import Passenger.Stubs.*;

/**
 * Passenger thread.
 * It simulates the passenger life cycle.
 */
public class Passenger extends Thread {
    
    /**
     * Current passenger state.
     */
    private PassengerState state;
    
    /**
     * Id of Passenger
     */
    private int idPassenger;
        
    /**
     * Instance of the departureAirport.
     */
    private final DepartureAirport dp;
    
    /**
     * Instance of the destinationAirport.
     */
    private final DestinationAirport dt;
    
    /**
     * Instance of the plane.
     */
    private final Plane pl;
    
    /**
     * Instance of the generalRepos.
     */
    private final GeneralRepos lg;
    
    /**
     * Passenger constructor
     * @param idPassenger id of passenger
     * @param dp instance of the departureAirport
     * @param pl instance of the plane
     * @param dt instance of the destinationAirport
     * @param lg instance of the generalRepos
     */
    public Passenger(int idPassenger, DepartureAirport dp, Plane pl, DestinationAirport dt, GeneralRepos lg){
        this.state = PassengerState.GOING_TO_AIRPORT;
        this.dp = dp;
        this.dt = dt;
        this.pl = pl;
        this.lg = lg;
    }
    
    @Override
    public void run() {
//         //In departure airport
//        goingToAirport();
//        departureAirport.travelToAirport();
//        departureAirport.waitInQueue();
//        departureAirport.showDocuments();
//        departureAirport.waitingToBeCheckedIn();
//        //In plane
//        plane.boardPlane();
//        plane.waitForPlaneToLand();
//        plane.leavePlane();
//
//        //In arrival airport
//        arrivalAirport.leaveAirport();
    }
    
    /**
     * Get the passenger state
     * @return the state
     */
    public PassengerState getPassengerState() {
        return state;
    }

    /**
     * Set the passenger state
     * @param state the state to set
     */
    public void setPassengerState(PassengerState state) {
        this.state = state;
    }
}
