package hu.ak_akademia.shc.servlets.review;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.shc.preparedstatementwriter.insert.PreparedStatementWriter;

public class SelectCurrentAverageReviewScoreForHotelPreparedStatementWriter implements PreparedStatementWriter<Integer> {

	private int hotelId;

	public SelectCurrentAverageReviewScoreForHotelPreparedStatementWriter(int hotelId) {
		this.hotelId = hotelId;
	}

	@Override
	public void write(PreparedStatement statement) throws SQLException {
		try {
			statement.setInt(1, hotelId);
		} catch (SQLException e) {
			System.out.println("Unable to set current average review score");
		}
	}

}
