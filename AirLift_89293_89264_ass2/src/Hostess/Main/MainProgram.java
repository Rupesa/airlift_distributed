package Hostess.Main;

import Hostess.Stubs.*;
import genclass.GenericIO;

/**
 * Main hostess program.
 * Initialize stubs and start hostess lifecycle.
 */
public class MainProgram {
    
    public static void main(String args[]) {
        
        /**
         * Stub initialization.
         */
        DepartureAirport departureAirport = new DepartureAirport(SimulationParameters.DEPARTURE_AIRPORT_HOST_NAME, SimulationParameters.DEPARTURE_AIRPORT_PORT);

        /**
         * Hostess lifecycle start.
         */
        Hostess hostess = new Hostess("Hostess", departureAirport, SimulationParameters.N_PASSENGER); 
        hostess.start();
        try {
            hostess.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        GenericIO.writelnString ("The hostess has terminated.");
    }  
}
