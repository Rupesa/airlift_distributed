package Hostess.Main;

import Hostess.EntitiesState.*;
import Hostess.Stubs.*;
import genclass.GenericIO;

/**
 * Hostess thread.
 * It simulates the hostess life cycle.
 */
public class Hostess extends Thread {

    /**
     * Current hostess state.
     */
    private HostessState hostessState;
    
    /**
    *   Maximum number of passengers.
    */
    private int maxNumberOfPassengers;
    
    /**
    *   Nnumber of attended passengers.
    */
    private int numberOfAttendedPassengers;
    
    /**
     * Instance of the departureAirport.
     */
    private final DepartureAirport dp;
    
    /**
     * Instance of the generalRepos.
     */
//    private final GeneralRepos lg;
    
    /**
     * Hostess constructor
     * @param nPassengers maximum number of passengers
     * @param dp instance of the departureAirport
     * @param lg instance of the generalRepos
     */
    public Hostess(int nPassengers, DepartureAirport dp){
        this.hostessState = HostessState.WAIT_FOR_FLIGHT;
        this.dp = dp;
//        this.lg = lg;
        this.maxNumberOfPassengers = nPassengers;
        this.numberOfAttendedPassengers = 0;
    }
    
//    public Hostess(int nPassengers, DepartureAirport dp, GeneralRepos lg){
//        this.hostessState = HostessState.WAIT_FOR_FLIGHT;
//        this.dp = dp;
//        this.lg = lg;
//        this.maxNumberOfPassengers = nPassengers;
//        this.numberOfAttendedPassengers = 0;
//    }
    
    @Override
    public void run() {
        GenericIO.writelnString("Started Hostess activity");
        while(maxNumberOfPassengers != numberOfAttendedPassengers){
//            dp.waitForNextFlight();
//            dp.waitForNextPassenger();
//            dp.checkDocuments();
//            numberOfAttendedPassengers++;
//            dp.informPlaneReadyToTakeOff();
        }
    }
    
    /**
     * Get the hostess state
     * @return the state
     */
    public HostessState getHostessState() {
        return hostessState;
    }

    /**
     * Set the hostess state
     * @param state the state to set
     */
    public void setHostessState(HostessState state) {
        this.hostessState = state;
    }
}
