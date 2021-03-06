package Passenger.Main;

import SimulationParameters.SimulationParameters;
import Stubs.DepartureAirport;
import Stubs.DestinationAirport;
import Stubs.GeneralRepos;
import Stubs.Plane;
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

        GeneralRepos repos = new GeneralRepos(SimulationParameters.REPOS_HOST_NAME, SimulationParameters.REPOS_PORT);

        /**
         * Passenger lifecycle start.
         */
        Passenger[] passenger = new Passenger[SimulationParameters.TTL_PASSENGER];

        for (int i = 0; i < passenger.length; i++) {
            passenger[i] = new Passenger("Passenger_" + i + 1, (DepartureAirport) departureAirport, (Plane) plane, (DestinationAirport) destinationAirport, i);
        }

        for (int i = 0; i < passenger.length; i++) {
            passenger[i].start();
        }

        for (int i = 0; i < passenger.length; i++) {
            try {
                passenger[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            GenericIO.writelnString("The passenger " + (i + 1) + " has terminated.");
        }
        
    }
}
