package Pilot.Stubs;

import Pilot.Communication.*;

/**
 * Plane stub. Class used to communicate with the departure airport using TCP
 * communication channels.
 */
public class Plane {

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
    public Plane(String hostName, int port) {
        serverHostName = hostName;
        serverPortNumb = port;
    }

    /* ****************************** PASSENGER ***************************** */
    /**
     * The passenger boards the plane.
     */
    public void boardThePlane(int id) {
        ClientCom com = new ClientCom(serverHostName, serverPortNumb);

        while (!com.open()) {
            try {
                Thread.currentThread().sleep((long) (10));
            } catch (InterruptedException ex) {
            }
        }

        Message msg = new Message(MessageType.BOARD_THE_PLANE, id);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close();
    }

    /**
     * The passenger waits for the flight to end.
     */
    public void waitForEndOfFlight() {
        ClientCom com = new ClientCom(serverHostName, serverPortNumb);

        while (!com.open()) {
            try {
                Thread.currentThread().sleep((long) (10));
            } catch (InterruptedException ex) {
            }
        }

        Message msg = new Message(MessageType.WAIT_FOR_END_OF_FLIGHT);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close();
    }

    /**
     * The passenger leaves the plane and, if he is the last to leave, notifies
     * the pilot that he is the last passenger of the plane.
     */
    public void leaveThePlane(int id) {
        ClientCom com = new ClientCom(serverHostName, serverPortNumb);

        while (!com.open()) {
            try {
                Thread.currentThread().sleep((long) (10));
            } catch (InterruptedException ex) {
            }
        }

        Message msg = new Message(MessageType.LEAVE_THE_PLANE, id);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close();
    }

    /* ******************************** PILOT ******************************* */
    /**
     * The pilot announces the arrival and waits all passengers to leave.
     */
    public void announceArrival() {
        ClientCom com = new ClientCom(serverHostName, serverPortNumb);

        while (!com.open()) {
            try {
                Thread.currentThread().sleep((long) (10));
            } catch (InterruptedException ex) {
            }
        }

        Message msg = new Message(MessageType.ANNOUNCE_ARRIVAL);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close();
    }

    /**
     * The pilot flight to the destination airport.
     */
    public void flyToDestinationPoint() {
        ClientCom com = new ClientCom(serverHostName, serverPortNumb);

        while (!com.open()) {
            try {
                Thread.currentThread().sleep((long) (10));
            } catch (InterruptedException ex) {
            }
        }

        Message msg = new Message(MessageType.FLY_TO_DESTINATION_POINT);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close();
    }

    /**
     * The pilot flight to the departure airport.
     */
    public void flyToDeparturePoint() {
        ClientCom com = new ClientCom(serverHostName, serverPortNumb);

        while (!com.open()) {
            try {
                Thread.currentThread().sleep((long) (10));
            } catch (InterruptedException ex) {
            }
        }

        Message msg = new Message(MessageType.FLY_TO_DEPARTURE_POINT);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close();
    }

    /**
     * The pilot parks the plane at the transfer gate.
     */
    public synchronized void parkAtTransferGate() {
        ClientCom com = new ClientCom(serverHostName, serverPortNumb);

        while (!com.open()) {
            try {
                Thread.currentThread().sleep((long) (10));
            } catch (InterruptedException ex) {
            }
        }

        Message msg = new Message(MessageType.PARK_AT_TRANSFER_GATE);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close();
    }
}
