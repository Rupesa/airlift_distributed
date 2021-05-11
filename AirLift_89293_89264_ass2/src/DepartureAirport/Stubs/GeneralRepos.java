package DepartureAirport.Stubs;

import DepartureAirport.Communication.*;
import DepartureAirport.EntitiesState.*;

/**
 * GeneralRepos stub. Class used to communicate with the logger
 * using TCP communication channels.
 */
public class GeneralRepos {
    
    /**
     * Name of the computational system where it is located the server.
     */
    private final String serverHostName;

    /**
     * Number of server listening port.
     */
    private final int serverPortNumb;
    
    /**
     * Stub instatiation.
     * @param hostName Name of the computational system where it is located the server.
     * @param port Number of server listening port.
     */
    public GeneralRepos (String hostName, int port) {
        serverHostName = hostName;
        serverPortNumb = port;
    }
            
    /**
     * Updates the state of the hostess
     * @param state new hostess state
     */
    public void updateHostessState(HostessState state){
        ClientCom com = new ClientCom (serverHostName, serverPortNumb);
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {
            }
        }
        Message msg = new Message(MessageType.UPDATE_HOSTESS_STATE, state);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close ();
    }
    
    /**
     * Updates the state of the pilot
     * @param state new pilot state
     */
    public void updateHostessState(PilotState state){
        ClientCom com = new ClientCom (serverHostName, serverPortNumb);
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {
            }
        }
        Message msg = new Message(MessageType.UPDATE_PILOT_STATE, state);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close ();
    }
    
    /**
     * Updates the state of a passenger
     * @param id id of the passenger
     * @param state new passenger state
     */
    public void updatePassengerState(int id, PassengerState state){
        ClientCom com = new ClientCom (serverHostName, serverPortNumb);
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {
            }
        }
        Message msg = new Message(MessageType.UPDATE_PASSENGER_STATE, id, state);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close ();
    }

    /**
     * Report the results of the flight.
     * @param horseIds id of the horses in the race
     * @param horsePositions position of the horses in the race
     */
    public void reportResults(int[] horseIds, int[] horsePositions){
//    public void reportResults(int[] horseIds, int[] horsePositions){
        ClientCom com = new ClientCom (serverHostName, serverPortNumb);
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {
            }
        }
        Message msg = new Message(MessageType.REPORT_RESULTS);
//        Message msg = new Message(MessageType.REPORT_RESULTS, horseIds, horsePositions);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close ();
    }
}
