package Stubs;

import Communication.ClientCom;
import Communication.Message;
import Communication.MessageType;


/**
 * Destination Airport stub. Class used to communicate with the departure
 * airport using TCP communication channels.
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
     * Stub instatiation.
     *
     * @param hostName Name of the computational system where it is located the
     * server.
     * @param port Number of server listening port.
     */
    public DestinationAirport(String hostName, int port) {
        serverHostName = hostName;
        serverPortNumb = port;
    }

    /* ****************************** PASSENGER ***************************** */
    /**
     * The passenger leaves airport. It is called by a passenger.
     */
    public void leaveAirport() {
        ClientCom com = new ClientCom(serverHostName, serverPortNumb);

        while (!com.open()) {
            try {
                Thread.currentThread().sleep((long) (10));
            } catch (InterruptedException ex) {
            }
        }

        Message msg = new Message(MessageType.LEAVE_AIRPORT);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close();
    }
}
