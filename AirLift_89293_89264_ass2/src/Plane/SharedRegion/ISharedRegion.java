package Plane.SharedRegion;

import Plane.Communication.*;

/**
 * This interface represents a shared region interface.
 */
public interface ISharedRegion {
    
    /**
     * Process and reply a message.
     * @param inMessage message to be processed
     * @param scon communication channel
     * @return message to be replied
     */
    public Message processAndReply(Message inMessage, ServerComm scon);
}
