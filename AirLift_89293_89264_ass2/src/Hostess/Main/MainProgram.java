package Hostess.Main;

import Hostess.Stubs.*;

/**
 * Main hostess program.
 * Initialize stubs and start hostess lifecycle.
 */
public class MainProgram {
    
    public static void main(String args[]) {
        
        /**
         * Stub initialization.
         */
        DepartureAirport dp = new DepartureAirport(SimulationParameters.DEPARTURE_AIRPORT_HOST_NAME, SimulationParameters.DEPARTURE_AIRPORT_PORT);
        GeneralRepos lg = new GeneralRepos(SimulationParameters.REPOS_HOST_NAME, SimulationParameters.REPOS_PORT);

        /**
         * Hostess lifecycle start.
         */
        Hostess ht = new Hostess(SimulationParameters.N_PASSENGER, dp, lg); 
        ht.start();
        try {
            ht.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }  
}
