package Pilot.Main;

import Pilot.Stubs.*;

/**
 * Main pilot program.
 * Initialize stubs and start pilot lifecycle.
 */
public class MainProgram {
    
    public static void main(String args[]) {
        
        /**
         * Stub initialization.
         */
        DepartureAirport dp = new DepartureAirport(SimulationParameters.DEPARTURE_AIRPORT_HOST_NAME, SimulationParameters.DEPARTURE_AIRPORT_PORT);
        Plane pl = new Plane(SimulationParameters.PLANE_HOST_NAME, SimulationParameters.PLANE_PORT);
//        GeneralRepos lg = new GeneralRepos(SimulationParameters.REPOS_HOST_NAME, SimulationParameters.REPOS_PORT);

        /**
         * Pilot lifecycle start.
         */
        Pilot ps = new Pilot(dp, pl);
//        Pilot ps = new Pilot(dp, pl, lg);
        ps.start();
        try {
            ps.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }  
}