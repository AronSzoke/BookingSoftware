package hu.ak_akademia.shc.servlets.login;

import hu.ak_akademia.shc.sqlbuilder.SqlBuilder;

public class SelectUserByUserNameAndPasswordSqlBuilder implements SqlBuilder {

	@Override
	public String build() {
		return "SELECT * FROM users WHERE user_name = ? AND user_password = ?";
	}

}
