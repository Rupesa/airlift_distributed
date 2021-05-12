package DestinationAirport.SharedRegion;

import DestinationAirport.Communication.*;
import DestinationAirport.Main.*;

/**
 * DestinationAirport proxy for the logger shared region.
 * Implements the ISharedRegion interface, and listens to the requests,
 * processes them and replies.
 */
public class DestinationAirportProxy implements ISharedRegion {
    
    /**
     * DestinationAirport used to process the messages.
     */
    private final DestinationAirport dp;
    
    private int count;
    private boolean isRunning;
    
    /**
     * DestinationAirport Proxy constructor.
     * @param dp to process the messages
     */
    public DestinationAirportProxy(DestinationAirport dp){
        this.dp = dp;
        this.count = 0;
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
            case LEAVE_AIRPORT:{
//                sp.setPassengerID(inMessage.getIdPassenger());
//                dp.leaveAirport();
                synchronized (this){
                    count++;
                    if(count == SimulationParameters.N_PASSENGER){
                        isRunning = false;
                        System.out.println("Shutdown arrival airport");
                    }
                }
                outMessage.setOperationDone(true);
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
