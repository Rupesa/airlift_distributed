package Passenger.Main;

import Passenger.Stubs.*;
import genclass.GenericIO;

/**
 * Main passenger program. Initialize stubs and start passenger lifecycle.
 */
public class MainProgram {

    public static void main(String args[]) {

        /**
         * Stub initialization.
         */
        DepartureAirport departureAirport = new DepartureAirport(SimulationParameters.DEPARTURE_AIRPORT_HOST_NAME, SimulationParameters.DEPARTURE_AIRPORT_PORT);
        DestinationAirport destinationAirport = new DestinationAirport(SimulationParameters.DESTINATION_AIRPORT_HOST_NAME, SimulationParameters.DESTINATION_AIRPORT_PORT);
        Plane plane = new Plane(SimulationParameters.PLANE_HOST_NAME, SimulationParameters.PLANE_PORT);

        /**
         * Passenger lifecycle start.
         */
        Passenger passenger = new Passenger("Passenger_" + (Integer.parseInt(args[0]) + 1), departureAirport, plane, destinationAirport, Integer.parseInt(args[0]));
        passenger.start();
        try {
            passenger.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        GenericIO.writelnString ("The passenger " + (Integer.parseInt(args[0])+1) + " has terminated.");
    }
}
