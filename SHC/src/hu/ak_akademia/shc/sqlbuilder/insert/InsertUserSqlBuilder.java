package hu.ak_akademia.shc.sqlbuilder.insert;

import hu.ak_akademia.shc.sqlbuilder.SqlBuilder;

public class InsertUserSqlBuilder implements SqlBuilder {

	@Override
	public String build() {
		return "INSERT INTO users (user_id, user_name, user_password, user_type, first_name, last_name, email, date_of_birth) VALUES (users_seq.nextval, ?, ?, ?, ?, ?, ?, ?)";
	}

}
