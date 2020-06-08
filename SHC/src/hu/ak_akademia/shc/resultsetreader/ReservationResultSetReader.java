package hu.ak_akademia.shc.resultsetreader;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.ak_akademia.shc.entities.Reservation;

public class ReservationResultSetReader implements ResultSetReader<Reservation> {

	@Override
	public List<Reservation> read(ResultSet resultSet) throws SQLException {
		List<Reservation> reservations = new ArrayList<>();
			while (resultSet.next()) {
				Integer reservationId = resultSet.getInt("reservation_id");
				Integer userId = resultSet.getInt("user_id");
				Date dateFrom = resultSet.getDate("date_from");
				Date dateTo = resultSet.getDate("date_to");
				Double totalPrice = resultSet.getDouble("total_price");
				String status = resultSet.getString("status");

				Reservation reservation = Reservation.builder()
						.withReservationId(reservationId)
						.withUserId(userId)
						.withDateFrom(dateFrom.toLocalDate())
						.withDateTo(dateTo.toLocalDate())
						.withTotalPrice(totalPrice)
						.withStatus(status)
						.build();

				reservations.add(reservation);

			}
		return reservations;
	}

}
