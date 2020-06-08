package hu.ak_akademia.shc.preparedstatementwriter.by_id;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import hu.ak_akademia.shc.entities.Room;
import hu.ak_akademia.shc.preparedstatementwriter.insert.PreparedStatementWriter;

public class RoomIdPreparedStatementWriter implements PreparedStatementWriter {

	private List<Room> rooms;

	public RoomIdPreparedStatementWriter(List<Room> rooms) {
		this.rooms = rooms;
	}

	@Override
	public void write(PreparedStatement statement) throws SQLException {
		for (Room room : rooms) {
			statement.setInt(1, room.getRoomId());
		}
	}

}
