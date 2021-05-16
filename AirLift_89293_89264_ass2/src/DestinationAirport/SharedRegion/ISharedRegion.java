package DestinationAirport.SharedRegion;

import DestinationAirport.Communication.*;

/**
 * This interface represents a shared region interface of Destination Airport.
 */
public interface ISharedRegion {
    
    /**
     * Process and reply a message
     * @param inMessage message to be processed
     * @param scon communication channel
     * @return message to be replied
     */
    public Message processAndReply(Message inMessage, ServerComm scon);
}
