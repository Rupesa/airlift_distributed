package DepartureAirport.SharedRegion;

import DepartureAirport.Communication.*;

/**
 * DepartureAiport proxy for the logger shared region.
 * Implements the ISharedRegion interface, and listens to the requests,
 * processes them and replies.
 */
public class DepartureAirportProxy implements ISharedRegion {
    
    /**
     * DepartureAiport used to process the messages.
     */
    private final DepartureAirport departureAirport;
    
    private boolean isRunning;
    
    /**
     * DepartureAiport Proxy constructor.
     * @param dp padock to process the messages
     */
    public DepartureAirportProxy(DepartureAirport dp){
        this.departureAirport = dp;
        this.isRunning = true;
    }
    
    /**
     * Process and reply a message.
     * @param inMessage message received
     * @param scon communication channel
     * @return message to be replied
     */
    @Override
    public Message processAndReply(Message inMessage, ServerComm scon){
        Message outMessage = new Message(false);
        ServiceProvider sp = (ServiceProvider) Thread.currentThread();
        
        switch(inMessage.getMessageType()){
            
            case WAIT_FOR_NEXT_FLIGHT:
                departureAirport.waitForNextFlight();
                outMessage.setOperationDone(true);
                break;

            case WAIT_FOR_NEXT_PASSENGER:
                departureAirport.waitForNextPassenger();
                outMessage.setOperationDone(true);
                break;

            case ASK_FOR_DOCUMENTS:
                departureAirport.checkDocuments();
                outMessage.setOperationDone(true);
                break;

//            case CHECK_DOCUMENTS:
////                sp.setPassengerID(inMessage.getIdPassenger());
////                departureAirport.waitingToBeCheckedIn();
//                outMessage = new Message(MessageType.STATUS_HOSTESS_OK);
//                break;
                
            case INFORM_PLANE_READY_TO_TAKE_OFF:
//                sp.setAllPassengersAttended(inMessage.gethostessAttendendedAllPassengers());
//                outMessage.setResponseBoolValue(departureAirport.informReadyToFly());
                outMessage.setOperationDone(true);
                break;

            case TRAVEL_TO_AIPORT:
//                sp.setPassengerID(inMessage.getIdPassenger());
                departureAirport.travelToAirport(inMessage.getIdPassenger());
                outMessage.setOperationDone(true);
                break;

            case WAIT_IN_QUEUE:
//                sp.setPassengerID(inMessage.getIdPassenger());
                departureAirport.waitInQueue(inMessage.getIdPassenger());
                outMessage.setOperationDone(true);
                break;

            case SHOW_DOCUMENTS:
//                sp.setPassengerID(inMessage.getIdPassenger());
                departureAirport.showDocuments();
                outMessage.setOperationDone(true);
                break;

            case INFORM_PLANE_READY_FOR_BOARDING:
                departureAirport.informPlaneReadyForBoarding();
                outMessage.setOperationDone(true);
                break;

            case WAIT_FOR_ALL_IN_BOARD:
                departureAirport.waitForAllInBoard();
                outMessage.setOperationDone(true);
                break;

            case INFORM_PILOT_TO_END_ACTIVITY:
                boolean value = departureAirport.informPilotToEndActivity();
//                outMessage.setResponseBoolValue(value);
                outMessage.setOperationDone(true);
           
//                synchronized (this){
//                    if(value){
//                        isRunning = false;
//                    }
//                }
                break;
        }
            
        return outMessage;
    }
    
//    @Override
//    public synchronized boolean isRunning(){
//        return isRunning;
//    }
}
