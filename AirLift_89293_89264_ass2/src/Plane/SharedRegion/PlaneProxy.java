package Plane.SharedRegion;

import Communication.Message;
import Communication.MessageType;
import Communication.ServerCom;
import Plane.Main.*;

/**
 * Plane proxy for the logger shared region.
 * Implements the ISharedRegion interface, and listens to the requests,
 * processes them and replies.
 */
public class PlaneProxy implements ISharedRegion {
    
    /**
     * Plane used to process the messages.
     */
    private final Plane plane;
    
    /**
     * Plane Proxy constructor.
     * @param plane to process the messages
     */
    public PlaneProxy(Plane plane){
        this.plane = plane;
    }
           
    /**
     * Process and reply a message.
     *
     * @param inMessage message received
     * @param scon communication channel
     * @return message to be replied
     */
    @Override
    public Message processAndReply(Message inMessage, ServerCom scon) {
        Message outMessage = null;

        switch (inMessage.getMethodType()) {
            case BOARD_THE_PLANE: {
                plane.boardThePlane(inMessage.getIdPassenger());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            }
            case WAIT_FOR_END_OF_FLIGHT: {
                plane.waitForEndOfFlight();
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            }
            case LEAVE_THE_PLANE: {
                plane.leaveThePlane(inMessage.getIdPassenger());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            }
            case ANNOUNCE_ARRIVAL: {
                plane.announceArrival();
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            }
            case FLY_TO_DESTINATION_POINT: {
                plane.flyToDestinationPoint();
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            }
            case FLY_TO_DEPARTURE_POINT: {
                plane.flyToDeparturePoint();
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            }
            case PARK_AT_TRANSFER_GATE: {
                plane.parkAtTransferGate();
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            }
            case SERVICE_END: {
                plane.serviceEnd();
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            }
        }
        return outMessage;
    }
}