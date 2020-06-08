package hu.ak_akademia.shc.resultsetreader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.ak_akademia.shc.entities.Room;

public class RoomResultSetReader implements ResultSetReader<Room> {

	@Override
	public List<Room> read(ResultSet resultSet) throws SQLException {
		List<Room> rooms = new ArrayList<>();
			while (resultSet.next()) {
				Integer roomId = resultSet.getInt("room_id");
				Integer hotelId = resultSet.getInt("hotel_id");
				String roomType = resultSet.getString("room_type");
				Integer floor = resultSet.getInt("floor");
				Integer roomNumber = resultSet.getInt("room_number");
				Integer roomSize = resultSet.getInt("room_size");
				Integer roomPrice = resultSet.getInt("room_price");
				String balcony = resultSet.getString("balcony");

				Room room = Room.builder()
						.withRoomId(roomId)
						.withHotelId(hotelId)
						.withRoomType(roomType)
						.withFloor(floor)
						.withRoomNumber(roomNumber)
						.withRoomSize(roomSize)
						.withRoomPrice(roomPrice)
						.withBalcony(balcony)
						.build();

				rooms.add(room);

			}
		return rooms;
	}

}
