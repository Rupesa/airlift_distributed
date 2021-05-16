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
        GenericIO.writelnString ("\n" + "      Problem of the Air Lift\n");
        do {
            GenericIO.writeString ("Logging file name? ");
            fileName = GenericIO.readlnString ();
            if (FileOp.exists (".", fileName)){
                do {
                    GenericIO.writeString ("There is already a file with this name. Delete it (y - yes; n - no)? ");
                    opt = GenericIO.readlnChar ();
                } while ((opt != 'y') && (opt != 'n'));
                if (opt == 'y')
                    success = true;
                else 
                    success = false;
           }
           else 
                success = true;
        } while (!success);

        /**
         * Shared region and proxy initialization.
         */
        GeneralRepos repos = new GeneralRepos(fileName);

        GeneralReposProxy loggerInt = new GeneralReposProxy(repos);

        /**
         * Start listening on the communication channel.
         */
        scon = new ServerComm(SimulationParameters.REPOS_PORT);
        scon.start();

        /**
         * While the service is not terminated, accept connections and send them
         * to the service provider.
         */
        while (!serviceEnd) {
            try {
                sconi = scon.accept();
                sp = new ServiceProvider(sconi, loggerInt);
                sp.start();
            } catch (SocketTimeoutException ex) {
            }
        }
    }
}
