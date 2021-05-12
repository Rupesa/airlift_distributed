package Pilot.Main;

import Pilot.EntitiesState.*;
import Pilot.Stubs.*;

/**
 * Pilot thread.
 * It simulates the pilot life cycle.
 */
public class Pilot extends Thread {
    
    /**
     * Current pilot state.
     */
    private PilotState state;
        
    /**
     * Instance of the departureAirport.
     */
    private final DepartureAirport dp;
    
    /**
     * Instance of the plane.
     */
    private final Plane pl;
    
    /**
     * Instance of the generalRepos.
     */
//    private final GeneralRepos lg;
    
    /**
     * Pilot constructor
     * @param dp instance of the departureAirport
     * @param pl instance of the plane
     * @param lg instance of the generalRepos
     */
    public Pilot(DepartureAirport dp, Plane pl){
        this.state = PilotState.AT_TRANSFER_GATE;
        this.dp = dp;
        this.pl = pl;
//        this.lg = lg;
    }
//    public Pilot(DepartureAirport dp, Plane pl, GeneralRepos lg){
//        this.state = PilotState.AT_TRANSFER_GATE;
//        this.dp = dp;
//        this.pl = pl;
//        this.lg = lg;
//    }
    
    @Override
    public void run() {
//        while(!departureAirport.isInformPilotToCeaseActivity()) {
//
//            repository.update(SPilot.AT_TRANSFER_GATE);
//
//            departureAirport.informReadyBoarding();
//            departureAirport.waitingForBoarding();
//            //Fly to destination
//            repository.update(SPilot.FLYING_FORWARD);
//            fly();
//            plane.announceArrival();
//            plane.waitingForDeboarding();
//            
//            //Fly to origin point
//            repository.update(SPilot.FLYING_BACK);
//            fly();
//        }
    }
    
    /**
     * Get the pilot state
     * @return the state
     */
    public PilotState getPilotState() {
        return state;
    }

    /**
     * Set the pilot state
     * @param state the state to set
     */
    public void setPilotState(PilotState state) {
        this.state = state;
    }
}
