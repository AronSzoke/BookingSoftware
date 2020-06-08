package hu.ak_akademia.shc.preparedstatementwriter.by_id;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import hu.ak_akademia.shc.entities.Hotel;
import hu.ak_akademia.shc.preparedstatementwriter.insert.PreparedStatementWriter;

public class HotelIdPreparedStatementWriter implements PreparedStatementWriter {

	private List<Hotel> hotels;

	public HotelIdPreparedStatementWriter(List<Hotel> hotels) {
		this.hotels = hotels;
	}

	@Override
	public void write(PreparedStatement statement) throws SQLException {
		for (Hotel hotel : hotels) {
			statement.setInt(1, hotel.getHotelId());
		}
	}

}
