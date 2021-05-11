package Hostess.Main;

import Hostess.EntitiesState.*;
import Hostess.Stubs.*;

/**
 * Hostess thread.
 * It simulates the hostess life cycle.
 */
public class Hostess extends Thread {

    /**
     * Current hostess state.
     */
    private HostessState state;
    
    private int attendedPassengers;
    
    /**
     * Total number of passengers.
     */
    private int totalPassengers;
    
    /**
     * Instance of the departureAirport.
     */
    private final DepartureAirport dp;
    
    /**
     * Instance of the generalRepos.
     */
    private final GeneralRepos lg;
    
    /**
     * Hostess constructor
     * @param nPassengers number of passengers
     * @param dp instance of the departureAirport
     * @param lg instance of the generalRepos
     */
    public Hostess(int nPassengers, DepartureAirport dp, GeneralRepos lg){
        this.state = HostessState.WAIT_FOR_FLIGHT;
        this.dp = dp;
        this.lg = lg;
        this.totalPassengers = nPassengers;
        this.attendedPassengers = 0;
    }
    
    @Override
    public void run() {
        while(totalPassengers != attendedPassengers){
            boolean flight_full = false;
            
//            dp.waitingForNextFlight();
            while(!flight_full) {
//                dp.waitingForPassenger();
//                dp.askForDocuments();
//                dp.waitingToCheckPassenger();
                attendedPassengers++;
//                flight_full = dp.informReadyToFly();
            }
        }
    }
    
    /**
     * Get the hostess state
     * @return the state
     */
    public HostessState getHostessState() {
        return state;
    }

    /**
     * Set the hostess state
     * @param state the state to set
     */
    public void setHostessState(HostessState state) {
        this.state = state;
    }
}
