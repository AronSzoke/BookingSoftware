package hu.ak_akademia.shc.servlets.review;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.shc.preparedstatementwriter.insert.PreparedStatementWriter;

public class SelectHotelByReservationIdPreparedStatementWriter implements PreparedStatementWriter<Integer> {

	private int reservationId;

	public SelectHotelByReservationIdPreparedStatementWriter(int reservationId) {
		this.reservationId = reservationId;
	}

	@Override
	public void write(PreparedStatement statement) {
		try {
			statement.setInt(1, reservationId);
//			statement.addBatch();
		} catch (SQLException e) {
			System.out.println("Unable to retrieve hotel by reservation id");
		}
	}
}
