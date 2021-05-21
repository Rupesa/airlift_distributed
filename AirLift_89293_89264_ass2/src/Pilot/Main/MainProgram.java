package Pilot.Main;

import SimulationParameters.SimulationParameters;
import Stubs.DepartureAirport;
import Stubs.Plane;
import Stubs.DestinationAirport;
import genclass.GenericIO;

/**
 * Main pilot program. Initialize stubs and start pilot lifecycle.
 */
public class MainProgram {

    public static void main(String args[]) {

        /**
         * Stub initialization.
         */
        DepartureAirport departureAirport = new DepartureAirport(SimulationParameters.DEPARTURE_AIRPORT_HOST_NAME, SimulationParameters.DEPARTURE_AIRPORT_PORT);
        Plane plane = new Plane(SimulationParameters.PLANE_HOST_NAME, SimulationParameters.PLANE_PORT);
        DestinationAirport destinationAirport = new DestinationAirport(SimulationParameters.DESTINATION_AIRPORT_HOST_NAME, SimulationParameters.DESTINATION_AIRPORT_PORT);

        /**
         * Pilot lifecycle start.
         */
        Pilot passenger = new Pilot("Pilot", departureAirport, destinationAirport, plane);
        passenger.start();
        try {
            passenger.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        GenericIO.writelnString("The pilot has terminated.");
    }
}
