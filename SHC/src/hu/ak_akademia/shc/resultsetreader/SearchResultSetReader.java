package hu.ak_akademia.shc.resultsetreader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.ak_akademia.shc.entities.SearchResults;

public class SearchResultSetReader implements ResultSetReader<SearchResults> {

	@Override
	public List<SearchResults> read(ResultSet resultSet) throws SQLException {
		List<SearchResults> results = new ArrayList<>();
			while (resultSet.next()) {
				String hotelName = resultSet.getString("hotel_name");
				String address = resultSet.getString("address");
				Integer stars = resultSet.getInt("stars");
				Double review = resultSet.getDouble("review");
				Integer roomId = resultSet.getInt("room_id");
				Integer roomNumber = resultSet.getInt("room_number");
				String roomType = resultSet.getString("room_type");
				String roomPrice = resultSet.getString("room_price");
				String bedTypes = resultSet.getString("bed_types");
				Integer adults = resultSet.getInt("adults");

				SearchResults result = SearchResults.builder()
						.withHotelName(hotelName)
						.withAddress(address)
						.withStars(stars)
						.withReview(review)
						.withRoomId(roomId)
						.withRoomNumber(roomNumber)
						.withRoomType(roomType)
						.withRoomPrice(roomPrice)
						.withBedTypes(bedTypes)
						.withAdults(adults)
						.build();

				results.add(result);
			}
		return results;
	}

}
