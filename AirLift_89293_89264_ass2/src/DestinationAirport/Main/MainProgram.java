package DestinationAirport.Main;

import Communication.ServerCom;
import DestinationAirport.SharedRegion.*;
import SimulationParameters.SimulationParameters;
import Stubs.GeneralRepos;
import java.net.SocketTimeoutException;

/**
 * Main DestinationAirport program.
 * Initializes the service provider and waits for a connection
 * in a communication channel.
 */
public class MainProgram {
    
    /**
     * Used to check if the service must terminate.
     */
    public static boolean serviceEnd = false;
    
    /**
     * Main DestinationAirport launcher
     * @param args args
     */
    public static void main(String [] args){

        /**
         * Communication channels.
         */
        ServerCom scon;

        ServerCom sconi;
        ServiceProvider sp;
        
        /**
         * Stub initialization.
         */
        GeneralRepos repos = new GeneralRepos(SimulationParameters.REPOS_HOST_NAME, SimulationParameters.REPOS_PORT);
        
        /**
         * Shared region and proxy initialization.
         */
        DestinationAirport pd = new DestinationAirport(repos);
        DestinationAirportProxy pdInt = new DestinationAirportProxy(pd);
        
        /**
         * Start listening on the communication channel.
         */
        scon = new ServerCom(SimulationParameters.DESTINATION_AIRPORT_PORT);
        scon.start();
        
        /**
         * While the service is not terminated, accept connections and send them
         * to the service provider.
         */
        while(!serviceEnd){
//            try {
                sconi = scon.accept();
                sp = new ServiceProvider(sconi, pdInt);
                sp.start();
//            } catch (SocketTimeoutException ex) {
//            }
        }
    }
}
