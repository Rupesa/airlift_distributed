package Passenger.Main;

import Passenger.Stubs.*;

/**
 * Main passenger program.
 * Initialize stubs and start passenger lifecycle.
 */
public class MainProgram {
    
    public static void main(String args[]) {
        
        /**
         * Stub initialization.
         */
        DepartureAirport dp = new DepartureAirport(SimulationParameters.DEPARTURE_AIRPORT_HOST_NAME, SimulationParameters.DEPARTURE_AIRPORT_PORT);
        DestinationAirport dt = new DestinationAirport(SimulationParameters.DESTINATION_AIRPORT_HOST_NAME, SimulationParameters.DESTINATION_AIRPORT_PORT);
        Plane pl = new Plane(SimulationParameters.PLANE_HOST_NAME, SimulationParameters.PLANE_PORT);
        GeneralRepos lg = new GeneralRepos(SimulationParameters.REPOS_HOST_NAME, SimulationParameters.REPOS_PORT);

        /**
         * Passenger lifecycle start.
         */
        Passenger ps = new Passenger(Integer.parseInt(args[0]), dp, pl, dt, lg);
        ps.start();
        try {
            ps.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }  
}
