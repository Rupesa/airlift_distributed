package DepartureAirport.Main;

import Communication.ServerCom;
import DepartureAirport.SharedRegion.*;
import SimulationParameters.SimulationParameters;
import Stubs.GeneralRepos;

/**
 * Main DepartureAirport program. Initializes the service provider and waits for
 * a connection in a communication channel.
 */
public class MainProgram {

    /**
     * Used to check if the service must terminate.
     */
    public static boolean serviceEnd = false;

    /**
     * Main DepartureAirport launcher
     *
     * @param args args
     */
    public static void main(String[] args) {

        /* Communication channels. */
        ServerCom scon;
        ServerCom sconi;
        ServiceProvider sp;

        /* Stub initialization. */
        GeneralRepos logger = new GeneralRepos(SimulationParameters.REPOS_HOST_NAME, SimulationParameters.REPOS_PORT);

        /* Shared region and proxy initialization. */
        DepartureAirport pd = new DepartureAirport(SimulationParameters.MIN_PASSENGER, SimulationParameters.MAX_PASSENGER, SimulationParameters.TTL_PASSENGER, logger);
        DepartureAirportProxy pdInt = new DepartureAirportProxy(pd);

        /**
         * Start listening on the communication channel.
         */
        scon = new ServerCom(SimulationParameters.DEPARTURE_AIRPORT_PORT);
        scon.start();

        /**
         * While the service is not terminated, accept connections and send them
         * to the service provider.
         */
        while (!serviceEnd) {
            System.out.println("Depart serviceEnd1 = " + serviceEnd);
            sconi = scon.accept();
            System.out.println("Depart serviceEnd2 = " + serviceEnd);
            sp = new ServiceProvider(sconi, pdInt);
            sp.start();
        }
    }
}
