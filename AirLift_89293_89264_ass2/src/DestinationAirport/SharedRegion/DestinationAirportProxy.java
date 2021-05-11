package DestinationAirport.SharedRegion;

import DestinationAirport.Communication.Message;
import DestinationAirport.Communication.ServerComm;
import DestinationAirport.Main.SimulationParameters;

/**
 * Paddock proxy for the logger shared region.
 * Implements the ISharedRegion interface, and listens to the requests,
 * processes them and replies.
 */
public class DestinationAirportProxy implements IDestinationAirport {
    
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
     * Running 
     * @return check if it is running
     */
    @Override
    public synchronized boolean isRunning(){
        return isRunning;
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
}
