package DestinationAirport.SharedRegion;

import DestinationAirport.Communication.*;

/**
 * DestinationAirport proxy for the logger shared region. Implements the
 * ISharedRegion interface, and listens to the requests, processes them and
 * replies.
 */
public class DestinationAirportProxy implements ISharedRegion {

    /**
     * DestinationAirport used to process the messages.
     */
    private final DestinationAirport destinationAirport;

    /**
     * DestinationAirport Proxy constructor.
     *
     * @param destinationAirport to process the messages
     */
    public DestinationAirportProxy(DestinationAirport destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    /**
     * Process and reply a message.
     *
     * @param inMessage message received
     * @param scon communication channel
     * @return message to be replied
     */
    @Override
    public Message processAndReply(Message inMessage, ServerComm scon) {
        Message outMessage = null;

        switch (inMessage.getMethodType()) {
            case LEAVE_AIRPORT: {
                destinationAirport.leaveAirport();
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            }
            case SERVICE_END: {
                destinationAirport.serviceEnd();
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            }
        }
        return outMessage;
    }
}
