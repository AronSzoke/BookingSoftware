package hu.ak_akademia.shc.resultsetreader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import hu.ak_akademia.shc.entities.ReservationToReview;

public class ReservationToReviewResultSetReader implements ResultSetReader<ReservationToReview> {

	@Override
	public List<ReservationToReview> read(ResultSet resultSet) throws SQLException {
		List<ReservationToReview> reservationsToReview = new ArrayList<>();
		while (resultSet.next()) {
			String hotelName = resultSet.getString("hotel_name");
			String address = resultSet.getString("address");
			LocalDate dateFrom = resultSet.getDate("date_from")
					.toLocalDate();
			LocalDate dateTo = resultSet.getDate("date_to")
					.toLocalDate();
			String roomType = resultSet.getString("room_type");
			Integer totalPrice = resultSet.getInt("total_price");
			Integer reservationId = resultSet.getInt("reservation_id");
 
			ReservationToReview reservationToReview = ReservationToReview.builder()
					.withHotelName(hotelName)
					.withAddress(address)
					.withDateFrom(dateFrom)
					.withDateTo(dateTo)
					.withRoomType(roomType)
					.withTotalPrice(totalPrice)
					.withReservationId(reservationId)
					.build();

			reservationsToReview.add(reservationToReview);

		}
		return reservationsToReview;
	}

}
