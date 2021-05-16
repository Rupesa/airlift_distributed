package Passenger.Communication;

/**
 * Defines the message types used on the messaging system.
 */
public enum MessageType {

    /**
     * When a shared region answers with an OK to a request made by an entity.
     */
    STATUS_OK,
    /**
     * Signal the passenger that the results will be reported.
     */
    REPORT_RESULTS,
    /**
     * Update the state of the passenger.
     */
    UPDATE_PASSENGER_STATE,
    /**
     * Update the state of the hostess.
     */
    UPDATE_HOSTESS_STATE,
    /**
     * Update the state of the pilot.
     */
    UPDATE_PILOT_STATE,
    /**
     * The passenger goes to the airport.
     */
    TRAVEL_TO_AIPORT,
    /**
     * The passenger waits in line for the check in.
     */
    WAIT_IN_QUEUE,
    /**
     * The passenger is asked to show his documents and he shows them to the
     * hostess.
     */
    SHOW_DOCUMENTS,
    /**
     * The passenger boards the plane.
     */
    BOARD_THE_PLANE,
    /**
     * The passenger waits for the flight to end.
     */
    WAIT_FOR_END_OF_FLIGHT,
    /**
     * The passenger leaves the plane and, if he is the last to leave, notifies
     * the pilot that he is the last passenger of the plane.
     */
    LEAVE_THE_PLANE,
    /**
     * The passenger leaves airport.
     */
    LEAVE_AIRPORT,
    /**
     * The pilot informs the plane that he is ready to board.
     */
    INFORM_PLANE_READY_FOR_BOARDING,
    /**
     * The pilot waits for the passengers to be on the plane and then is ready
     * to fly.
     */
    WAIT_FOR_ALL_IN_BOARD,
    /**
     * The pilot flight to the destination airport.
     */
    FLY_TO_DESTINATION_POINT,
    /**
     * The pilot announces the arrival and waits all passengers to leave.
     */
    ANNOUNCE_ARRIVAL,
    /**
     * The pilot waits for the last passenger to notify that he is the last to
     * leave.
     */
    WAIT_FOR_DEBOARDING,
    /**
     * The pilot flight to the departure airport.
     */
    FLY_TO_DEPARTURE_POINT,
    /**
     * The pilot parks the plane at the transfer gate.
     */
    PARK_AT_TRANSFER_GATE,
    /**
     * The hostess waits for the next flight to be ready for boarding.
     */
    WAIT_FOR_NEXT_FLIGHT,
    /**
     * The hostess waits for the next passenger in the queue.
     */
    WAIT_FOR_NEXT_PASSENGER,
    /**
     * The hostess asks the passenger for the documents and waits for him to
     * deliver them.
     */
    CHECK_DOCUMENTS,
    /**
     * The hostess informs the pilot that the plane is ready to take off.
     */
    INFORM_PLANE_READY_TO_TAKE_OFF,
    /**
     * The hosstes informs the pilot thar he can end activity.
     */
    INFORM_PILOT_TO_END_ACTIVITY,
    /**
     * Answers if the hosstes informs the pilot thar he can end activity.
     */
    RETURN_HOSTESS_INFORMS_PILOT_TO_END_ACTIVITY,
    /**
     * Control center notifies shared regions that his service has ended.
     */
    SERVICE_END,
}
