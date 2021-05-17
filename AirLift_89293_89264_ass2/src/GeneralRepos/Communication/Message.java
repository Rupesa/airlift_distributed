package GeneralRepos.Communication;

import GeneralRepos.EntitiesState.*;
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
     * Hostess inform pilot to end activity.
     */
    private boolean informPilotToEndActivity;

    /**
     * Id of passenger.
     */
    private int idPassenger;

    /**
     * Entities states.
     */
    private HostessState hostessState;
    private PilotState pilotState;
    private PassengerState passengerState;

    /**
     * Information of flight.
     */
    private int numOfFlight;
    private int numPassengersPerFlight;

    /**
     * Constructor of Message.
     */
    public Message() {
        this.idPassenger = -1;
        this.informPilotToEndActivity = false;
    }

    /**
     * Constructor of Message.
     *
     * @param type
     */
    public Message(MessageType type) {
        this.type = type;
    }

    /**
     * Constructor of Message.
     *
     * @param id
     * @param type
     */
    public Message(MessageType type, int id) {
        this.type = type;
        this.idPassenger = id;
    }

    /**
     * Constructor with the type of the message and a boolean.
     *
     * @param type type of the message
     * @param bool boolean argument
     */
    public Message(MessageType type, boolean bool) {
        this();
        this.type = type;
        switch (type) {
            case RETURN_HOSTESS_INFORMS_PILOT_TO_END_ACTIVITY:
                this.informPilotToEndActivity = bool;
                break;
        }
    }

//    /**
//     * Constructor with the type of the message and a state of Hostess.
//     *
//     * @param type type of the message
//     * @param state state of hostess argument
//     */
//    public Message(MessageType type, HostessState state) {
//        this();
//        this.type = type;
//        this.hostessState = hostessState;
//    }

    /**
     * Constructor with the type of the message and a state of Hostess.
     *
     * @param type type of the message
     * @param state state of hostess argument
     * @param id if of passenger
     */
    public Message(MessageType type, HostessState state, int id) {
        this();
        this.type = type;
        this.hostessState = hostessState;
        this.idPassenger = id;
    }

    /**
     * Constructor with the type of the message and a state of Pilot.
     *
     * @param type type of the message
     * @param state state of pilot argument
     */
    public Message(MessageType type, PilotState state) {
        this();
        this.type = type;
        this.pilotState = pilotState;
    }

    /**
     * Constructor with the type of the message and a state of Passenger.
     *
     * @param type type of the message
     * @param state state of passenger argument
     * @param id id of passenger
     */
    public Message(MessageType type, PassengerState state, int id) {
        this();
        this.type = type;
        this.pilotState = pilotState;
        this.idPassenger = id;
    }

    /**
     * Constructor with the type of the message and a state of Passenger.
     *
     * @param type type of the message
     * @param flight number of flight
     * @param passengers number of passengers per flight
     */
    public Message(MessageType type, int flight, int passengers) {
        this();
        this.type = type;
        this.numOfFlight = numOfFlight;
        this.numPassengersPerFlight = numPassengersPerFlight;
    }

    /**
     * Get message type.
     *
     * @return type
     */
    public MessageType getMethodType() {
        return type;
    }

    /**
     * Hostess informs pilot to end activity.
     *
     * @return informPilotToEndActivity
     */
    public boolean informPilotToEndActivity() {
        return informPilotToEndActivity;
    }

    /**
     * Get id of passenger.
     *
     * @return idPassenger
     */
    public int getIdPassenger() {
        return this.idPassenger;
    }

    /**
     * @return the hostessState
     */
    public HostessState getHostessState() {
        return hostessState;
    }

    /**
     * @return the pilotState
     */
    public PilotState getPilotState() {
        return pilotState;
    }

    /**
     * @return the passengerState
     */
    public PassengerState getPassengerState() {
        return passengerState;
    }

    /**
     * @return the numOfFlight
     */
    public int getNumOfFlight() {
        return numOfFlight;
    }

    /**
     * @return the numPassengersPerFlight
     */
    public int getNumPassengersPerFlight() {
        return numPassengersPerFlight;
    }
}
