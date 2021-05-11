package DestinationAirport.SharedRegion;

import DestinationAirport.Communication.Message;
import DestinationAirport.Communication.ServerComm;

/**
 * Service Provider implementation.
 * Processes and replies messages accordingly to the internal implementation
 * of a shared region.
 */
public class ServiceProvider extends Thread {
 
    /**
     * Communication channel with the server.
     */
    private final ServerComm serv;
    
    /**
     * Shared region implementation.
     */
    private final IDestinationAirport iDestAir;
    
    /**
     * Service Provider constructor.
     * @param serv communication channel with the server.
     * @param iDestAir shared region.
     */
    public ServiceProvider(ServerComm serv, IDestinationAirport iDestAir){
        this.serv = serv;
        this.iDestAir = iDestAir;
    }
    
    /**
     * Lifecycle of the service provider.
     */
    @Override
    public void run(){
        /* Read object from the communication channel. */
        Message inMessage = (Message) serv.readObject();
        /* Process and reply request. */
        Message outMessage = iDestAir.processAndReply(inMessage, serv);
        /* Send reply and close communication channel. */
        serv.writeObject(outMessage);
        serv.close();
    }
}
