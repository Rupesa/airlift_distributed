package Pilot.Main;

import Pilot.Stubs.*;
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

        /**
         * Pilot lifecycle start.
         */
        Pilot passenger = new Pilot("Pilot", departureAirport, plane);
        passenger.start();
        try {
            passenger.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        GenericIO.writelnString("The pilot has terminated.");
    }
}
