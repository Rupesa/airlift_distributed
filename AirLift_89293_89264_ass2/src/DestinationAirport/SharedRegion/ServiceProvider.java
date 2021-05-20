package DestinationAirport.SharedRegion;

import Communication.Message;
import Communication.ServerCom;

/**
 * Service Provider implementation.
 * Processes and replies messages accordingly to the internal implementation
 */
public class ServiceProvider extends Thread {

    /**
     * Communication channel with the server.
     */
    private final ServerCom com;
    
    /**
     * Shared region implementation.
     */
    private final ISharedRegion rtInt;
    
    /**
     * Service Provider constructor.
     * @param com communication channel with the server.
     * @param rtInt shared region.
     */
    public ServiceProvider(ServerCom com, ISharedRegion rtInt){
        this.com = com;
        this.rtInt = rtInt;
    }
    
    /**
     * Lifecycle of the service provider.
     */
    @Override
    public void run(){
        /* Read object from the communication channel. */
        Message inMessage = (Message) com.readObject();
        /* Process and reply request. */
        Message outMessage = rtInt.processAndReply(inMessage, com);
        /* Send reply and close communication channel. */
        com.writeObject(outMessage);
        com.close();
    }
}

