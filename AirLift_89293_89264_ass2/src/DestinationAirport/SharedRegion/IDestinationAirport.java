package DestinationAirport.SharedRegion;

import DestinationAirport.Communication.Message;
import DestinationAirport.Communication.ServerComm;

/**
 * This interface represents a shared region interface of Destination Airport.
 */
public interface IDestinationAirport {
    
    /**
     * Process and reply a message
     * @param inMessage message to be processed
     * @param scon communication channel
     * @return message to be replied
     */
    public Message processAndReply(Message inMessage, ServerComm scon);
    
    /**
     * Running 
     * @return check if it is running
     */
    public boolean isRunning();
}
