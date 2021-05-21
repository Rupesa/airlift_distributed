package Passenger.Main;

import EntitiesState.PassengerState;
import SimulationParameters.SimulationParameters;
import Stubs.DepartureAirport;
import Stubs.DestinationAirport;
import Stubs.Plane;
import genclass.GenericIO;

/**
 * Passenger thread. It simulates the passenger life cycle.
 */
public class Passenger extends Thread {

    /**
     * Instance of the departureAirport.
     */
    private final DepartureAirport departureAirport;

    /**
     * Instance of the destinationAirport.
     */
    private final DestinationAirport destinationAirport;

    /**
     * Instance of the Passenger.
     */
    private final Plane plane;

    /**
     * Count the number of passengers that finish the activity.
     */
    private static int count;

    /**
     * Id of Passenger
     */
    private int idPassenger;

    /**
     * Current passenger state.
     */
    private PassengerState state;

    /**
     * Passenger constructor
     *
     * @param name thread name
     * @param id of passenger
     * @param departureAirport instance of the departureAirport
     * @param plane instance of the plane
     * @param destinationAirport instance of the destinationAirport
     */
    public Passenger(String name, DepartureAirport departureAirport, Plane plane, DestinationAirport destinationAirport, int id) {
        super(name);
        this.departureAirport = departureAirport;
        this.destinationAirport = destinationAirport;
        this.plane = plane;
        this.idPassenger = id;
        this.state = PassengerState.GOING_TO_AIRPORT;
        this.count = 0;
    }

    @Override
    public void run() {
        GenericIO.writelnString("Started Passenger " + getPassengerId() + " activity");
        goingToAirport();
        departureAirport.travelToAirport(getPassengerId());
        departureAirport.waitInQueue(getPassengerId());
        departureAirport.showDocuments();
        plane.boardThePlane(getPassengerId());
        plane.waitForEndOfFlight();
        plane.leaveThePlane(getPassengerId());
        destinationAirport.leaveAirport();
        count++;
        if (count >= SimulationParameters.TTL_PASSENGER) {
            
            System.out.println("PASS1");
            // manda terminar o servico (serviceEnd = true)
            destinationAirport.serviceEnd();
            System.out.println("PASS2");
            // o servico nao desliga imediatamente porque a variavel so e verficada na proxima itercacao do ciclo while, chamando novamente esta funcao, vai forcar uma nova verificacao da condicao
            destinationAirport.serviceEnd();
            System.out.println("PASS3");
            plane.serviceEnd();
            System.out.println("PASS4");
            departureAirport.serviceEnd();
            System.out.println("PASS5");

        }
        GenericIO.writelnString("Ended Passenger " + getPassengerId() + " activity");
    }

    /**
     * The passenger goes to the airport.
     *
     * Internal operation.
     */
    private void goingToAirport() {
        int randomSleepValue = (int) ((Math.random() * (10 - 5)) + 5);
        try {
            Thread.sleep(randomSleepValue * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get the passenger id
     *
     * @return the id
     */
    public int getPassengerId() {
        return idPassenger;
    }

    /**
     * Set the passenger id
     *
     * @param id the id to set
     */
    public void setPassengerId(int id) {
        this.idPassenger = id;
    }

    /**
     * Get the passenger state
     *
     * @return the state
     */
    public PassengerState getPassengerState() {
        return state;
    }

    /**
     * Set the passenger state
     *
     * @param state the state to set
     */
    public void setPassengerState(PassengerState state) {
        this.state = state;
    }
}
