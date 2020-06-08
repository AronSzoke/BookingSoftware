package hu.ak_akademia.shc.servlets.reservation;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.shc.preparedstatementwriter.insert.PreparedStatementWriter;

public class SetReservationStatusToDeletedPreparedStatementWriter implements PreparedStatementWriter<Integer> {

	private int reservationId;

	public SetReservationStatusToDeletedPreparedStatementWriter(int reservationId) {
		this.reservationId = reservationId;
	}

	@Override
	public void write(PreparedStatement statement) throws SQLException {
		try {
			statement.setInt(1, reservationId);
		} catch (SQLException e) {
			System.out.println("Unable to set reservation status to be deleted");
		}
	}

}
