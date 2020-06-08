package hu.ak_akademia.shc.servlets.review;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.shc.preparedstatementwriter.insert.PreparedStatementWriter;

public class UpdaterReviewForHotelPreparedStatementWriter implements PreparedStatementWriter<Integer> {

	private double review;
	private double hotelId;

	public UpdaterReviewForHotelPreparedStatementWriter(double review, double hotelId) {
		this.review = review;
		this.hotelId = hotelId;
	}

	@Override
	public void write(PreparedStatement statement) {
		try {
			statement.setDouble(1, review);
			statement.setDouble(2, hotelId);
//			statement.addBatch();
		} catch (SQLException e) {
			System.out.println("Unable to update review of a specific hotel");
		}
	}

}
