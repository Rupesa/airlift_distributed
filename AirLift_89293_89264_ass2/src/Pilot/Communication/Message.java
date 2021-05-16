package Pilot.Communication;

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
}
