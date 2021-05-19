package Pilot.Main;

import Pilot.EntitiesState.*;
import Pilot.Stubs.*;
import genclass.GenericIO;

/**
 * Pilot thread. It simulates the pilot life cycle.
 */
public class Pilot extends Thread {

    /**
     * Instance of the departureAirport.
     */
    private final DepartureAirport departureAirport;

    /**
     * Instance of the plane.
     */
    private final Plane plane;

    /**
     * Current pilot state.
     */
    private PilotState state;

    /**
     * Pilot constructor
     *
     * @param name thread name
     * @param departureAirport instance of the departureAirport
     * @param plane instance of the plane
     */
    public Pilot(String name, DepartureAirport departureAirport, Plane plane) {
        super(name);
        this.departureAirport = departureAirport;
        this.plane = plane;
        this.state = PilotState.AT_TRANSFER_GATE;
    }

    @Override
    public void run() {
        GenericIO.writelnString("Started Pilot activity");
       while(!departureAirport.informPilotToEndActivity()){
           departureAirport.informPlaneReadyForBoarding();
           departureAirport.waitForAllInBoard();      
           plane.flyToDestinationPoint();
           plane.announceArrival();
           plane.flyToDeparturePoint();
           plane.parkAtTransferGate();
       }
        GenericIO.writelnString("Ended Pilot activity");
    }

    /**
     * Get the pilot state
     *
     * @return the state
     */
    public PilotState getPilotState() {
        return state;
    }

    /**
     * Set the pilot state
     *
     * @param state the state to set
     */
    public void setPilotState(PilotState state) {
        this.state = state;
    }
}
