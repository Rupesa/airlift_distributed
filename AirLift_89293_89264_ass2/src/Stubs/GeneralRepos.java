package Stubs;

import Communication.ClientCom;
import Communication.Message;
import Communication.MessageType;
import EntitiesState.HostessState;
import EntitiesState.PassengerState;
import EntitiesState.PilotState;

/**
 * GeneralRepos stub. Class used to communicate with the logger using TCP
 * communication channels.
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
     *
     * @param hostName Name of the computational system where it is located the
     * server.
     * @param port Number of server listening port.
     */
    public GeneralRepos(String hostName, int port) {
        serverHostName = hostName;
        serverPortNumb = port;
    }

    /**
     * Updates the state of the hostess
     *
     * @param state new hostess state
     * @param id id of passenger
     */
    public void updateHostessState(HostessState state, int id) {
        ClientCom com = new ClientCom(serverHostName, serverPortNumb);
        while (!com.open()) {
            try {
                Thread.currentThread().sleep((long) (10));
            } catch (InterruptedException ex) {
            }
        }
        Message msg = new Message(MessageType.UPDATE_HOSTESS_STATE, state, id);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close();
    }

    /**
     * Updates the state of the hostess
     */
    public void reportFinalStatus() {
        ClientCom com = new ClientCom(serverHostName, serverPortNumb);
        while (!com.open()) {
            try {
                Thread.currentThread().sleep((long) (10));
            } catch (InterruptedException ex) {
            }
        }
        Message msg = new Message(MessageType.REPORT_FINAL_RESULTS);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close();
    }

    /**
     * Updates the state of the pilot
     *
     * @param state new pilot state
     */
    public void updatePilotState(PilotState state) {
        ClientCom com = new ClientCom(serverHostName, serverPortNumb);
        while (!com.open()) {
            try {
                Thread.currentThread().sleep((long) (10));
            } catch (InterruptedException ex) {
            }
        }
        Message msg = new Message(MessageType.UPDATE_PILOT_STATE, state);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close();
    }

    /**
     * Updates the state of a passenger
     *
     * @param id id of the passenger
     * @param state new passenger state
     */
    public void updatePassengerState(PassengerState state, int id) {
        ClientCom com = new ClientCom(serverHostName, serverPortNumb);
        while (!com.open()) {
            try {
                Thread.currentThread().sleep((long) (10));
            } catch (InterruptedException ex) {
            }
        }
        Message msg = new Message(MessageType.UPDATE_PASSENGER_STATE, state, id);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close();
    }

    /**
     * Updates the state of a flight
     *
     * @param numberOfFilght number of flight
     * @param numberOfPassengerOnThePlane number of passenger on the plane per
     * flight
     */
    public void updateInfoBoardPlane(int numberOfFilght, int numberOfPassengerOnThePlane) {
        ClientCom com = new ClientCom(serverHostName, serverPortNumb);
        while (!com.open()) {
            try {
                Thread.currentThread().sleep((long) (10));
            } catch (InterruptedException ex) {
            }
        }
        Message msg = new Message(MessageType.UPDATE_INFO_FLIGHT_STATE, numberOfFilght, numberOfPassengerOnThePlane);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close();
    }

    /**
     * Message sent to end the activity.
     */
    public void serviceEnd() {
        ClientCom com = new ClientCom(serverHostName, serverPortNumb);
        while (!com.open()) {
            try {
                Thread.currentThread().sleep((long) (10));
            } catch (InterruptedException ex) {
            }
        }
        Message msg = new Message(MessageType.SERVICE_END);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close();
    }
}
