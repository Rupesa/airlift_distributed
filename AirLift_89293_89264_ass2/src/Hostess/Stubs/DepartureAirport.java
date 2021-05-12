package Hostess.Stubs;

import DepartureAirport.EntitiesState.*;
import DepartureAirport.Stubs.*;
import Hostess.Main.*;
import commInfra.*;
import genclass.GenericIO;
import java.util.logging.*;

/**
 * Departure Airport stub. 
 * Class used to communicate with the departure airport using TCP communication channels.
 */
public class DepartureAirport {
  
    /**
     * Name of the computational system where it is located the server.
     */
    private final String serverHostName;

    /**
     * Number of server listening port.
     */
    private final int serverPortNumb;
    
    /**
     *  Stub instatiation.
     *
     *    @param hostName Name of the computational system where it is located the server.
     *    @param port Number of server listening port.
     */
    public DepartureAirport (String hostName, int port)
    {
        serverHostName = hostName;
        serverPortNumb = port;
    }
}
