package GeneralRepos.SharedRegion;

import Communication.Message;
import Communication.MessageType;
import Communication.ServerCom;


/**
 * Proxy for the general repository shared region. Implements the ISharedRegion
 * interface, and listens to the requests, processes them and replies.
 */
public class GeneralReposProxy implements ISharedRegion {

    /**
     * GeneralRepos used to process the messages.
     */
    private final GeneralRepos repos;

    /**
     * GeneralRepos Proxy constructor.
     *
     * @param logger repos to process the messages
     */
    public GeneralReposProxy(GeneralRepos logger) {
        this.repos = logger;
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
            case UPDATE_HOSTESS_STATE: {
                repos.updateHostessState(inMessage.getHostessState(), inMessage.getIdPassenger());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            }
            case UPDATE_PILOT_STATE: {
                repos.updatePilotState(inMessage.getPilotState());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            }
            case UPDATE_PASSENGER_STATE: {
                System.out.println("PASS23 > " + inMessage.getPassengerState());
                repos.updatePassengerState(inMessage.getPassengerState(), inMessage.getIdPassenger());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            }
            case REPORT_FINAL_RESULTS: {
                repos.reportFinalStatus();
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            }
            case SERVICE_END: {
                repos.serviceEnd();
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            }
        }
        return outMessage;
    }
}
