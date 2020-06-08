package hu.ak_akademia.shc.preparedstatementwriter.by_id;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import hu.ak_akademia.shc.entities.Reservation;
import hu.ak_akademia.shc.preparedstatementwriter.insert.PreparedStatementWriter;

public class ReservationIdPreparedStatementWriter implements PreparedStatementWriter {

	private List<Reservation> reservations;

	public ReservationIdPreparedStatementWriter(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	@Override
	public void write(PreparedStatement statement) throws SQLException {
		for (Reservation reservation : reservations) {
			statement.setInt(1, reservation.getReservationId());
		}
	}

}
