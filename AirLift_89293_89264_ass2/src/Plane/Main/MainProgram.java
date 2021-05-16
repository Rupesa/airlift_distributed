package Plane.Main;

import Plane.Communication.*;
import Plane.SharedRegion.*;
import Plane.Stubs.*;
import java.net.SocketTimeoutException;

/**
 * Main Plane program.
 * Initializes the service provider and waits for a connection
 * in a communication channel.
 */
public class MainProgram {
    
    /**
     * Used to check if the service must terminate.
     */
    public static boolean serviceEnd = false;
    
    /**
     * Main Plane launcher
     * @param args args
     */
    public static void main(String [] args){
        /**
         * Communication channels.
         */
        ServerComm scon, sconi;
        ServiceProvider sp;
        
        /**
         * Stub initialization.
         */
        GeneralRepos repos = new GeneralRepos(SimulationParameters.REPOS_HOST_NAME, SimulationParameters.REPOS_PORT);
        
        /**
         * Shared region and proxy initialization.
         */
        Plane pd = new Plane(repos);
        PlaneProxy pdInt = new PlaneProxy(pd);
        
        /**
         * Start listening on the communication channel.
         */
        scon = new ServerComm(SimulationParameters.PLANE_PORT);
        scon.start();
        
        /**
         * While the service is not terminated, accept connections and send them
         * to the service provider.
         */
        while(!serviceEnd){
            try {
                sconi = scon.accept();
                sp = new ServiceProvider(sconi, pdInt);
                sp.start();
            } catch (SocketTimeoutException ex) {
            }
        }
    }
}