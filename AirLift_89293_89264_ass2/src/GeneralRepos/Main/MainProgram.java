package GeneralRepos.Main;

import Communication.ServerCom;
import GeneralRepos.SharedRegion.*;
import SimulationParameters.SimulationParameters;

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
        ServerCom scon;
        ServerCom sconi;
        ServiceProvider sp;

        /**
         * Shared region and proxy initialization.
         */
        GeneralRepos repos = new GeneralRepos("rep.txt");
        GeneralReposProxy loggerInt = new GeneralReposProxy(repos);

        /**
         * Start listening on the communication channel.
         */
        scon = new ServerCom(SimulationParameters.REPOS_PORT);
        scon.start();

        /**
         * While the service is not terminated, accept connections and send them
         * to the service provider.
         */
        while (!serviceEnd) {
            sconi = scon.accept();
            sp = new ServiceProvider(sconi, loggerInt);
            sp.start();
        }
    }
}
