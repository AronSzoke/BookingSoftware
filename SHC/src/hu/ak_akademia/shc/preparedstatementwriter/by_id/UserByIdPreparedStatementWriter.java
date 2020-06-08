package hu.ak_akademia.shc.preparedstatementwriter.by_id;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import hu.ak_akademia.shc.entities.User;
import hu.ak_akademia.shc.preparedstatementwriter.insert.PreparedStatementWriter;

public class UserByIdPreparedStatementWriter implements PreparedStatementWriter {

	private List<User> users;

	public UserByIdPreparedStatementWriter(List<User> users) {
		this.users = users;
	}

	@Override
	public void write(PreparedStatement statement) throws SQLException {
		for (User user : users) {
			statement.setInt(1, user.getUserId());
		}

	}

}
