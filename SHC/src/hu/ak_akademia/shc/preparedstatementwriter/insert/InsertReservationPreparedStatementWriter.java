package hu.ak_akademia.shc.preparedstatementwriter.insert;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import hu.ak_akademia.shc.entities.Reservation;

public class InsertReservationPreparedStatementWriter implements PreparedStatementWriter {

	private List<Reservation> reservations;

	public InsertReservationPreparedStatementWriter(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	@Override
	public void write(PreparedStatement statement) {
		for (Reservation reservation : reservations) {
			try {
				int i = 1;
				if (reservation.getReservationId() != null) {
					statement.setInt(i++, reservation.getReservationId());
				}
				statement.setInt(i++, reservation.getUserId());
				statement.setDate(i++, Date.valueOf(reservation.getDateFrom()));
				statement.setDate(i++, Date.valueOf(reservation.getDateTo()));
				statement.setDouble(i++, reservation.getTotalPrice());
				statement.addBatch();
			} catch (SQLException e) {
				System.out.println("Unable to set Reservation parameters");
			}
		}
	}

}
