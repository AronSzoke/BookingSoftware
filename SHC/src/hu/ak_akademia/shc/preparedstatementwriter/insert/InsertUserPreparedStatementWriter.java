package hu.ak_akademia.shc.preparedstatementwriter.insert;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import hu.ak_akademia.shc.entities.User;

public class InsertUserPreparedStatementWriter implements PreparedStatementWriter<User> {

	private List<User> users;

	public InsertUserPreparedStatementWriter(List<User> users) {
		this.users = users;
	}

	@Override
	public void write(PreparedStatement statement) throws SQLException {
		for (User user : users) {
			statement.setString(1, user.getUserName());
			statement.setString(2, user.getUserPassword());
			statement.setString(3, user.getUserType());
			statement.setString(4, user.getFirstName());
			statement.setString(5, user.getLastName());
			statement.setString(6, user.getEmail());
			statement.setDate(7, user.getDateOfBirth());
			statement.addBatch();
		}
	}

}
