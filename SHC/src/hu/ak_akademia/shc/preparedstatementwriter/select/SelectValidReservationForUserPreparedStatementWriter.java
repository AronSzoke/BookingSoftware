package hu.ak_akademia.shc.preparedstatementwriter.select;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.shc.preparedstatementwriter.insert.PreparedStatementWriter;

public class SelectValidReservationForUserPreparedStatementWriter implements PreparedStatementWriter<Integer> {

	private Integer userId;

	public SelectValidReservationForUserPreparedStatementWriter(Integer userId) {
		this.userId = userId;
	}

	@Override
	public void write(PreparedStatement statement) throws SQLException {
		try {
			statement.setInt(1, userId);
		} catch (SQLException e) {
			System.out.println("Unable to retrieve valid reservations for user");
		}
	}

}
