package GeneralRepos.Main;

import GeneralRepos.Communication.*;
import GeneralRepos.SharedRegion.*;
import genclass.FileOp;
import genclass.GenericIO;
import java.net.SocketTimeoutException;

/**
 * Main passenger program. Initializes the service provider and waits for a
 * connection in a communication channel.
 */
public class MainProgram {

    /**
     * Used to check if the service must terminate.
     */
    public static boolean serviceEnd = false;

    /**
     * Main control center launcher
     *
     * @param args args
     */
    public static void main(String args[]) {
        
        /**
         * Communication channels.
         */
        ServerComm scon, sconi;
        ServiceProvider sp;

        /* file options  */
        String fileName;
        char opt;
        boolean success; 
        
        /* problem initialization */
        // GenericIO.writelnString ("\n" + "      Problem of the Air Lift\n");

        /**
         * Shared region and proxy initialization.
         */
        GeneralRepos repos = new GeneralRepos("rep.txt");

        GeneralReposProxy loggerInt = new GeneralReposProxy(repos);

        /**
         * Start listening on the communication channel.
         */
        // GenericIO.writelnString (""+SimulationParameters.REPOS_PORT);
        scon = new ServerComm(SimulationParameters.REPOS_PORT);
        scon.start();

        /**
         * While the service is not terminated, accept connections and send them
         * to the service provider.
         */
        while (!serviceEnd) {
            try {
                //GenericIO.writelnString ("Passou 1\n");
                sconi = scon.accept();
                //GenericIO.writelnString ("Passou 1.5\n");
                sp = new ServiceProvider(sconi, loggerInt);
                sp.start();
                //GenericIO.writelnString ("Passou 2\n");
            } catch (SocketTimeoutException ex) {
            }
        }
    }
}
