package hu.ak_akademia.shc.db;

import hu.ak_akademia.shc.entities.RoomToReservation;

public class RoomToReservationDao extends AbstractDataBaseDao<RoomToReservation> {

	public RoomToReservationDao() {
		super();
	}

	public RoomToReservationDao(boolean manualConnectionManagement) {
		super(manualConnectionManagement);
	}

}
