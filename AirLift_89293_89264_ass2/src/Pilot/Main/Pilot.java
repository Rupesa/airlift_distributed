package Pilot.Main;

import EntitiesState.PilotState;
import Stubs.DepartureAirport;
import Stubs.Plane;
import Stubs.DestinationAirport;
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
     * Instance of the destinationAirport.
     */
    private final DestinationAirport destinationAirport;

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
    public Pilot(String name, DepartureAirport departureAirport, DestinationAirport destinationAirport, Plane plane) {
        super(name);
        this.departureAirport = departureAirport;
        this.plane = plane;
        this.destinationAirport = destinationAirport;
        this.state = PilotState.AT_TRANSFER_GATE;
    }

    @Override
    public void run() {
        GenericIO.writelnString("Started Pilot activity");
        while (!departureAirport.informPilotToEndActivity()) {
            departureAirport.informPlaneReadyForBoarding();
            departureAirport.waitForAllInBoard();
            plane.flyToDestinationPoint();
            plane.announceArrival();
            plane.flyToDeparturePoint();
            plane.parkAtTransferGate();
        }
        try {
            // manda terminar o servico (serviceEnd = true)
            destinationAirport.serviceEnd();
            // o servico nao desliga imediatamente porque a variavel so e verficada na proxima itercacao do ciclo while, chamando novamente esta funcao, vai forcar uma nova verificacao da condicao
            destinationAirport.serviceEnd();
            plane.serviceEnd();
            plane.serviceEnd();
            departureAirport.serviceEnd();
            GenericIO.writelnString("Ended Pilot activity");
        } catch (Exception e) {
        }
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
