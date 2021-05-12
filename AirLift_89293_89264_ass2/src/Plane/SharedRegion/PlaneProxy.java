package Plane.SharedRegion;

import Plane.Communication.*;
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
    private final Plane pl;
    
    private boolean isRunning;
    
    /**
     * Plane Proxy constructor.
     * @param dp to process the messages
     */
    public PlaneProxy(Plane pl){
        this.pl = pl;
        isRunning = true;
    }
        
    /**
     * Process and reply a message
     * @param inMessage message to be processed
     * @param scon communication channel
     * @return message to be replied
     */
    @Override
    public Message processAndReply(Message inMessage, ServerComm scon){
        Message outMessage = null;
        ServiceProvider sp = (ServiceProvider) Thread.currentThread();
        
        switch(inMessage.getMethodType()){
            case BOARD_THE_PLANE:{
//                sp.setPassengerID(inMessage.getIdPassenger());
//                pl.boardPlane();
                outMessage.setOperationDone(true);
                break;
            }
            case WAIT_FOR_END_OF_FLIGHT:{
//                sp.setPassengerID(inMessage.getIdPassenger());
//                pl.waitForEndOfFlight();
                outMessage.setOperationDone(true);
                break;
            }
            case LEAVE_THE_PLANE:{
//                sp.setPassengerID(inMessage.getIdPassenger());
//                pl.leaveThePlane();
                outMessage.setOperationDone(true);
                break;
            }
            case ANNOUNCE_ARRIVAL:{
//                pl.announceArrival();
                outMessage.setOperationDone(true);
                break;
            }
            case WAIT_FOR_DEBOARDING:{
//                pl.waitForDeboarding();
                outMessage.setOperationDone(true);
                break;
            }
            case INFORM_NO_MORE_FLIGHTS_NEEDED:{
                outMessage.setOperationDone(true);
                synchronized (this){
                    isRunning = false;
                }
                break;
            }
        }
        return outMessage;
    }
    
    /**
     * Running 
     * @return check if it is running
     */
    @Override
    public synchronized boolean isRunning(){
        return isRunning;
    }
}