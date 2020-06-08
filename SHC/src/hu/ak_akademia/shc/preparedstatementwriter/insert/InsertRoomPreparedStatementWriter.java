package hu.ak_akademia.shc.preparedstatementwriter.insert;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import hu.ak_akademia.shc.entities.Room;

public class InsertRoomPreparedStatementWriter implements PreparedStatementWriter<Room> {

	private List<Room> rooms;

	public InsertRoomPreparedStatementWriter(List<Room> rooms) {
		this.rooms = rooms;
	}

	@Override
	public void write(PreparedStatement statement) {
		for (Room room : rooms) {
			try {
				int i = 1;
				statement.setInt(i++, room.getHotelId());
				statement.setString(i++, room.getRoomType());
				statement.setInt(i++, room.getFloor());
				statement.setInt(i++, room.getRoomNumber());
				statement.setInt(i++, room.getRoomSize());
				statement.setDouble(i++, room.getRoomPrice());
				statement.setString(i++, room.getBalcony());
				statement.addBatch();
			} catch (SQLException e) {
				System.out.println("Unable to set Room parameters");
			}
		}
	}

}
