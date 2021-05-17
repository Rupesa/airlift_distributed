package DestinationAirport.Main;

/**
 *  Definition of the simulation parameters.
 */
public class SimulationParameters {
    
    /**
     * Total number of passengers.
     */
    public static final int TTL_PASSENGER = 21;
    
    /**
     * Number of passengers.
     */
    public static final int N_PASSENGER = 1;
   
    /**
     * Maximum number of passengers per flight.
     */
    public static final int MAX_PASSENGER = 10;
    
    /**
     * Minimum number of passengers per flight.
     */
    public static final int MIN_PASSENGER = 5;
    
    /**
     * General Repository server host name.
     */
    public final static String REPOS_HOST_NAME = "localhost";
    
    /**
     * General Repository server port.
     */
    public final static int REPOS_PORT = 8081;
    
    /**
     * Departure Airport server host name.
     */
    public final static String DEPARTURE_AIRPORT_HOST_NAME = "localhost";
    
    /**
     * Departure Airport server port.
     */
    public final static int DEPARTURE_AIRPORT_PORT = 8082;
    
    /**
     * Destination Airport server host name.
     */
    public final static String DESTINATION_AIRPORT_HOST_NAME = "localhost";
    
    /**
     * Destination Airport server port.
     */
    public final static int DESTINATION_AIRPORT_PORT = 8083;

    /**
     * Plane server host name.
     */
    public final static String PLANE_HOST_NAME = "localhost";
    
    /**
     * Plane server port.
     */
    public final static int PLANE_PORT = 8084;
    
    /**
    *   It can not be instantiated.
    */
    private SimulationParameters () { }

}