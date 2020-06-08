package hu.ak_akademia.shc.servlets.review;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import hu.ak_akademia.shc.entities.Review;
import hu.ak_akademia.shc.preparedstatementwriter.insert.PreparedStatementWriter;

public class InsertReviewPreparedStatementWriter implements PreparedStatementWriter<Review> {

	private List<Review> reviews;

	public InsertReviewPreparedStatementWriter(List<Review> reviews) {
		this.reviews = reviews;
	}

	@Override
	public void write(PreparedStatement statement) throws SQLException {
		for (Review review : reviews) {
			try {
				statement.setInt(1, review.getReservationId());
				statement.setDouble(2, review.getReviewScore());
				statement.setString(3, review.getReviewText());
				statement.addBatch();
			} catch (SQLException e) {
				System.out.println("Unable to set review parameters");
			}
		}

	}
}
