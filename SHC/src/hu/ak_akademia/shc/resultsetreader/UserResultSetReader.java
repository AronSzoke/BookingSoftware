package hu.ak_akademia.shc.resultsetreader;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.ak_akademia.shc.entities.User;

public class UserResultSetReader implements ResultSetReader<User> {

	@Override
	public List<User> read(ResultSet resultSet) throws SQLException {
		List<User> users = new ArrayList<>();
			while (resultSet.next()) {
				int userId = resultSet.getInt("user_id");
				String userName = resultSet.getString("user_name");
				String password = resultSet.getString("user_password");
				String userType = resultSet.getString("user_type");
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				String email = resultSet.getString("email");
				Date dateOfBirth = resultSet.getDate("date_of_birth");

				User user = User.builder()
						.withUserId(userId)
						.withUserName(userName)
						.withPassword(password)
						.withUserType(userType)
						.withFirstName(firstName)
						.withLastName(lastName)
						.withEmail(email)
						.withDateOfBirth(dateOfBirth.toLocalDate())
						.build();

				users.add(user);

			}
		return users;
	}

}
