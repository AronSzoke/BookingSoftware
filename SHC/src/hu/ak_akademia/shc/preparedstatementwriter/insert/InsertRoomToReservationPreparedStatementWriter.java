package hu.ak_akademia.shc.preparedstatementwriter.insert;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import hu.ak_akademia.shc.entities.RoomToReservation;

public class InsertRoomToReservationPreparedStatementWriter implements PreparedStatementWriter<RoomToReservation> {

	private List<RoomToReservation> roomToReservations;

	public InsertRoomToReservationPreparedStatementWriter(List<RoomToReservation> roomToReservations) {
		this.roomToReservations = roomToReservations;
	}

	@Override
	public void write(PreparedStatement statement) {
		for (RoomToReservation roomToReservation : roomToReservations) {
			try {
				statement.setInt(1, roomToReservation.getRoomId());
				statement.setInt(2, roomToReservation.getReservationId());
				statement.addBatch();
			} catch (SQLException e) {
				System.out.println("Unable to set RoomToReservation parameters");
			}
		}
	}

}
