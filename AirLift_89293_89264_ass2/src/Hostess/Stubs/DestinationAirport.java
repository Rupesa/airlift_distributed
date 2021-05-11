package Hostess.Stubs;

/**
 * Destination Airport stub. Class used to communicate with the departure airport
 * using TCP communication channels.
 */
public class DestinationAirport {
    
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
    public DestinationAirport (String hostName, int port)
    {
        serverHostName = hostName;
        serverPortNumb = port;
    }
}