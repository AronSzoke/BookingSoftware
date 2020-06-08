package hu.ak_akademia.shc.preparedstatementwriter.insert;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import hu.ak_akademia.shc.entities.BedToRoom;

public class InsertBedToRoomPreparedStatementWriter implements PreparedStatementWriter {

	private List<BedToRoom> bedToRooms;

	public InsertBedToRoomPreparedStatementWriter(List<BedToRoom> bedToRooms) {
		this.bedToRooms = bedToRooms;
	}

	@Override
	public void write(PreparedStatement statement) {
		for (BedToRoom bedToRoom : bedToRooms) {
			try {
				statement.setInt(1, bedToRoom.getRoomId());
				statement.setInt(2, bedToRoom.getBedId());
				statement.addBatch();
			} catch (SQLException e) {
				System.out.println("Unable to set BedToRoom parameters");
			}
		}
	}

}
