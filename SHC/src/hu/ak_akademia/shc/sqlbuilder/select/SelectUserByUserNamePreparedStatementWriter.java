package hu.ak_akademia.shc.sqlbuilder.select;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.shc.entities.User;
import hu.ak_akademia.shc.preparedstatementwriter.insert.PreparedStatementWriter;

public class SelectUserByUserNamePreparedStatementWriter implements PreparedStatementWriter {

	private User user;

	public SelectUserByUserNamePreparedStatementWriter(User user) {
		this.user = user;
	}

	@Override
	public void write(PreparedStatement statement) throws SQLException {
		statement.setString(1, user.getUserName());

	}

}
