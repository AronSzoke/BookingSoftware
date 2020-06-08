package hu.ak_akademia.shc.db;

import hu.ak_akademia.shc.entities.Room;

public class RoomDao extends AbstractDataBaseDao<Room> {

	public RoomDao() {
		super();
	}

	public RoomDao(boolean manualConnectionManagement) {
		super(manualConnectionManagement);
	}

}
