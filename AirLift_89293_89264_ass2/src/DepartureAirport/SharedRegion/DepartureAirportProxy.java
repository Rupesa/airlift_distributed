package DepartureAirport.SharedRegion;

import Communication.Message;
import Communication.MessageType;
import Communication.ServerCom;

/**
 * DepartureAiport proxy for the logger shared region. Implements the
 * ISharedRegion interface, and listens to the requests, processes them and
 * replies.
 */
public class DepartureAirportProxy implements ISharedRegion {

    /**
     * DepartureAiport used to process the messages.
     */
    private final DepartureAirport departureAirport;

    /**
     * DepartureAiport Proxy constructor.
     *
     * @param dp padock to process the messages
     */
    public DepartureAirportProxy(DepartureAirport dp) {
        this.departureAirport = dp;
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
            case WAIT_FOR_NEXT_FLIGHT: {
                departureAirport.waitForNextFlight();
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            }
            case WAIT_FOR_NEXT_PASSENGER: {
                departureAirport.waitForNextPassenger();
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            }
            case CHECK_DOCUMENTS: {
                departureAirport.checkDocuments();
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            }
            case INFORM_PLANE_READY_TO_TAKE_OFF: {
                departureAirport.informPlaneReadyToTakeOff();
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            }
            case TRAVEL_TO_AIPORT: {
                departureAirport.travelToAirport(inMessage.getIdPassenger());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            }
            case WAIT_IN_QUEUE: {
                departureAirport.waitInQueue(inMessage.getIdPassenger());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            }
            case SHOW_DOCUMENTS: {
                departureAirport.showDocuments();
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            }
            case INFORM_PLANE_READY_FOR_BOARDING: {
                departureAirport.informPlaneReadyForBoarding();
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            }
            case WAIT_FOR_ALL_IN_BOARD: {
                departureAirport.waitForAllInBoard();
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            }
            case INFORM_PILOT_TO_END_ACTIVITY: {
                boolean value = departureAirport.informPilotToEndActivity();
                outMessage = new Message(MessageType.RETURN_HOSTESS_INFORMS_PILOT_TO_END_ACTIVITY, value);
                break;
            }
            case SERVICE_END: {
                System.out.println("Depart serviceEnd Proxy1");
                departureAirport.serviceEnd();
                System.out.println("Depart serviceEnd Proxy2");
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            }
        }
        return outMessage;
    }
}
