package hu.ak_akademia.shc.resultsetreader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.ak_akademia.shc.entities.Hotel;

public class HotelResultSetReader implements ResultSetReader<Hotel> {

	@Override
	public List<Hotel> read(ResultSet resultSet) throws SQLException {
		List<Hotel> hotels = new ArrayList<>();
			while (resultSet.next()) {
				int hotelId = resultSet.getInt("hotel_id");
				String hotelType = resultSet.getString("hotel_type");
				String hotelName = resultSet.getString("hotel_name");
				String address = resultSet.getString("address");
				Integer stars = resultSet.getInt("stars");
				Double review = resultSet.getDouble("review");

				Hotel hotel = Hotel.builder()
						.withHotelId(hotelId)
						.withHotelType(hotelType)
						.withHotelName(hotelName)
						.withAddress(address)
						.withStars(stars)
						.withReview(review)
						.build();

				hotels.add(hotel);

			}
		return hotels;
	}

}
