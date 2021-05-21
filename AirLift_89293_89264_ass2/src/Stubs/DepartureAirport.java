package Stubs;

import Communication.ClientCom;
import Communication.Message;
import Communication.MessageType;

/**
 * Departure Airport stub. Class used to communicate with the departure airport
 * using TCP communication channels.
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
     * Stub instatiation.
     *
     * @param hostName Name of the computational system where it is located the
     * server.
     * @param port Number of server listening port.
     */
    public DepartureAirport(String hostName, int port) {
        serverHostName = hostName;
        serverPortNumb = port;
    }

    /**
     * The hostess waits for the next flight to be ready for boarding.
     */
    public void waitForNextFlight() {
        ClientCom com = new ClientCom(serverHostName, serverPortNumb);

        while (!com.open()) {
            try {
                Thread.currentThread().sleep((long) (10));
            } catch (InterruptedException ex) {
            }
        }

        Message msg = new Message(MessageType.WAIT_FOR_NEXT_FLIGHT);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close();
    }

    /**
     * The hostess waits for the next passenger in the queue.
     */
    public void waitForNextPassenger() {
        ClientCom com = new ClientCom(serverHostName, serverPortNumb);

        while (!com.open()) {
            try {
                Thread.currentThread().sleep((long) (10));
            } catch (InterruptedException ex) {
            }
        }
        Message msg = new Message(MessageType.WAIT_FOR_NEXT_PASSENGER);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close();
    }

    /**
     * The hostess asks the passenger for the documents and waits for him to
     * deliver them.
     */
    public void checkDocuments() {
        ClientCom com = new ClientCom(serverHostName, serverPortNumb);

        while (!com.open()) {
            try {
                Thread.currentThread().sleep((long) (10));
            } catch (InterruptedException ex) {
            }
        }

        Message msg = new Message(MessageType.CHECK_DOCUMENTS);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close();
    }

    /**
     * The hostess informs the pilot that the plane is ready to take off.
     */
    public void informPlaneReadyToTakeOff() {
        ClientCom com = new ClientCom(serverHostName, serverPortNumb);

        while (!com.open()) {
            try {
                Thread.currentThread().sleep((long) (10));
            } catch (InterruptedException ex) {
            }
        }

        Message msg = new Message(MessageType.INFORM_PLANE_READY_TO_TAKE_OFF);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close();
    }

    /* ****************************** PASSENGER ***************************** */
    /**
     * The passenger goes to the airport.It is called by a passenger.
     *
     * @param id passenger id
     */
    public void travelToAirport(int id) {
        ClientCom com = new ClientCom(serverHostName, serverPortNumb);

        while (!com.open()) {
            try {
                Thread.currentThread().sleep((long) (10));
            } catch (InterruptedException ex) {
            }
        }

        Message msg = new Message(MessageType.TRAVEL_TO_AIPORT, id);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close();
    }

    /**
     * The passenger waits in line for the check in.
     *
     * @param id passenger id
     */
    public void waitInQueue(int id) {
        ClientCom com = new ClientCom(serverHostName, serverPortNumb);

        while (!com.open()) {
            try {
                Thread.currentThread().sleep((long) (10));
            } catch (InterruptedException ex) {
            }
        }

        Message msg = new Message(MessageType.WAIT_IN_QUEUE, id);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close();
    }

    /**
     * The passenger is asked to show his documents and he shows them to the
     * hostess.
     */
    public void showDocuments() {
        ClientCom com = new ClientCom(serverHostName, serverPortNumb);

        while (!com.open()) {
            try {
                Thread.currentThread().sleep((long) (10));
            } catch (InterruptedException ex) {
            }
        }

        Message msg = new Message(MessageType.SHOW_DOCUMENTS);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close();
    }

    /* ******************************** PILOT ******************************* */
    /**
     * The pilot informs the plane that he is ready to board.
     */
    public void informPlaneReadyForBoarding() {
        ClientCom com = new ClientCom(serverHostName, serverPortNumb);

        while (!com.open()) {
            try {
                Thread.currentThread().sleep((long) (10));
            } catch (InterruptedException ex) {
            }
        }

        Message msg = new Message(MessageType.INFORM_PLANE_READY_FOR_BOARDING);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close();
    }

    /**
     * The pilot waits for the passengers to be on the plane and then is ready
     * to fly.
     */
    public void waitForAllInBoard() {
        ClientCom com = new ClientCom(serverHostName, serverPortNumb);

        while (!com.open()) {
            try {
                Thread.currentThread().sleep((long) (10));
            } catch (InterruptedException ex) {
            }
        }

        Message msg = new Message(MessageType.WAIT_FOR_ALL_IN_BOARD);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close();
    }

    /**
     * The pilot stops his activity when the hostess tells him to.
     *
     * @return the value of the hostessInformPilotToEndActivity variable
     */
    public boolean informPilotToEndActivity() {
        ClientCom com = new ClientCom(serverHostName, serverPortNumb);

        while (!com.open()) {
            try {
                Thread.currentThread().sleep((long) (10));
            } catch (InterruptedException ex) {
            }
        }

        Message msg = new Message(MessageType.INFORM_PILOT_TO_END_ACTIVITY);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close();
        return inMessage.informPilotToEndActivity();
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
