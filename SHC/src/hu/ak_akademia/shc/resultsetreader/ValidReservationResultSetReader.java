package hu.ak_akademia.shc.resultsetreader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import hu.ak_akademia.shc.entities.ValidReservation;

public class ValidReservationResultSetReader implements ResultSetReader<ValidReservation> {

	@Override
	public List<ValidReservation> read(ResultSet resultSet) throws SQLException {
		List<ValidReservation> validReservations = new ArrayList<>();
			while (resultSet.next()) {
				Integer reservationId = resultSet.getInt("reservation_id");
				String hotelName = resultSet.getString("hotel_name");
				String address = resultSet.getString("address");
				LocalDate dateFrom = resultSet.getDate("date_from")
						.toLocalDate();
				LocalDate dateTo = resultSet.getDate("date_to")
						.toLocalDate();

				Integer totalPrice = resultSet.getInt("total_price");

				ValidReservation validReservation = ValidReservation.builder()
						.withReservationId(reservationId)
						.withHotelName(hotelName)
						.withAddress(address)
						.withDateFrom(dateFrom)
						.withDateTo(dateTo)
						.withTotalPrice(totalPrice)
						.build();

				validReservations.add(validReservation);
			}
		return validReservations;
	}

}
