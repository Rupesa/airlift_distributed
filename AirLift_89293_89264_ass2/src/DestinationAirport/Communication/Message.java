package DestinationAirport.Communication;

import java.io.Serializable;

/**
 *  Represents a message that is goint to be sent between regions.
 *  The class is serializable, and has constructors adequated to every kind
 *  of message needed. Also has getters to get the values from the fields.
 */
public class Message implements Serializable {
        
    /**
     * Type of the message.
     */
    private DepartureAirport.Communication.MessageType type;
    
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
    
    /**
     * Constructor of Message.
     * @param id
     * @param type 
     */
    public Message(int id, DepartureAirport.Communication.MessageType type){
        this.idPassenger = id;
        this.type = type;
    }

    /**
     * Constructor of Message.
     * @param type 
     */
    public Message(DepartureAirport.Communication.MessageType type){
        this.idPassenger = -1;
        this.type = type;
    }

    /**
     * Constructor of Message.
     * @param operationDone 
     */
    public Message(Boolean operationDone){
        this.operationDone = operationDone;
    }

    /**
     * Get message type.
     * @return type
     */
    public DepartureAirport.Communication.MessageType getMethodType(){
        return type;
    }

    /**
     * Get id of passenger.
     * @return idPassenger
     */
    public int getIdPassenger(){
        return this.idPassenger;
    }

    /**
     * Set of operation was done.
     * @param value 
     */
    public void setOperationDone(boolean value){
        this.operationDone = value;
    }

    /**
     * Get of operation was done.
     * @return operationDone
     */
    public boolean getOperationDone(){
        return operationDone;
    }

    /**
     * Set of response was boolean value.
     * @param value 
     */
    public void setResponseBoolValue(boolean value){
        this.responseBoolean = value;
    }

    /**
     * Set of response was boolean value.
     * @return responseBoolean 
     */
    public boolean getResponseBoolValue(){
        return responseBoolean;
    }

    /**
     * Set of the hostess has already attendeded all passengers.
     * @param value 
     */
    public void sethostessAttendendedAllPassengers(boolean value){
        hostessAttendendedAllPassengers = value;
    }

    /**
     * Get of the hostess has already attendeded all passengers.
     * @return hostessAttendendedAllPassengers 
     */
    public boolean gethostessAttendendedAllPassengers(){
        return hostessAttendendedAllPassengers;
    }
}
