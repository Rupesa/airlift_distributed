package DepartureAirport.Communication;

import DepartureAirport.EntitiesState.*;
import java.io.Serializable;

/**
 * Represents a message that is goint to be sent between regions. The class is
 * serializable, and has constructors adequated to every kind of message needed.
 * Also has getters to get the values from the fields.
 */
public class Message implements Serializable {

    /**
     * Type of the message.
     */
    private MessageType type;

    /**
     * Id of passenger.
     */
    private int idPassenger;

    /**
     * Check if operation was done.
     */
    private boolean operationDone;
    /**
     * Check if response was a boolean value.
     */
    private boolean responseBoolean;
    /**
     * Check if the hostess has already attendeded all passengers.
     */
    private boolean hostessAttendendedAllPassengers;

//    /**
//     * State of the hostess.
//     */
//    private HostessState hostessState;
//
//    /**
//     * State of the pilot.
//     */
//    private PilotState pilotState;
//
//    /**
//     * State of the passenger.
//     */
//    private PassengerState passengerState;
    /**
     * Constructor with only the type of the message.
     *
     * @param type type of the message
     */
    public Message(MessageType type) {
        this.idPassenger = -1;
        this.type = type;
    }

    /**
     * Constructor with the type of the message and an integer argument.
     *
     * @param id integer argument
     * @param type type of the message
     */
    public Message(MessageType type, int id) {
        this.idPassenger = id;
        this.type = type;
    }

    /**
     * Constructor with the type of the message and a boolean.
     *
     * @param bool boolean argument
     */
    public Message(boolean bool) {
        this.operationDone = operationDone;
    }

    /**
     * Get the type of the message
     *
     * @return message type
     */
    public MessageType getMessageType() {
        return type;
    }

    /**
     * Get the id of the passenger
     *
     * @return passenger id
     */
    public int getIdPassenger() {
        return this.idPassenger;
    }

    /**
     * Set of operation was done.
     *
     * @param value
     */
    public void setOperationDone(boolean value) {
        this.operationDone = value;
    }

    /**
     * Get of operation was done.
     *
     * @return operationDone
     */
    public boolean getOperationDone() {
        return operationDone;
    }

    /**
     * Set of response was boolean value.
     *
     * @param value
     */
    public void setResponseBoolValue(boolean value) {
        this.responseBoolean = value;
    }

    /**
     * Set of response was boolean value.
     *
     * @return responseBoolean
     */
    public boolean getResponseBoolValue() {
        return responseBoolean;
    }

    /**
     * Set of the hostess has already attendeded all passengers.
     *
     * @param value
     */
    public void sethostessAttendendedAllPassengers(boolean value) {
        hostessAttendendedAllPassengers = value;
    }

    /**
     * Get of the hostess has already attendeded all passengers.
     *
     * @return hostessAttendendedAllPassengers
     */
    public boolean gethostessAttendendedAllPassengers() {
        return hostessAttendendedAllPassengers;
    }
}
