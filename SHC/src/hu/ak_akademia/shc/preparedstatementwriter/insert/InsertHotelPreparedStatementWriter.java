package hu.ak_akademia.shc.preparedstatementwriter.insert;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import hu.ak_akademia.shc.entities.Hotel;

public class InsertHotelPreparedStatementWriter implements PreparedStatementWriter {

	private List<Hotel> hotels;

	public InsertHotelPreparedStatementWriter(List<Hotel> hotels) {
		this.hotels = hotels;
	}

	@Override
	public void write(PreparedStatement statement) {
		for (Hotel hotel : hotels) {
			try {
				statement.setString(1, hotel.getHotelType());
				statement.setString(2, hotel.getHotelName());
				statement.setString(3, hotel.getAddress());
				statement.setInt(4, hotel.getStars());
				statement.setDouble(5, hotel.getReview());
				statement.addBatch();
			} catch (SQLException e) {
				System.out.println("Unable to set Hotel parameters");
			}
		}
	}

}
