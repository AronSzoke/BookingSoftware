package hu.ak_akademia.shc.sqlbuilder.delete_by_id;

import hu.ak_akademia.shc.sqlbuilder.SqlBuilder;

public class DeleteUserByIdSqlBuilder implements SqlBuilder {

	@Override
	public String build() {
		return "DELETE FROM users WHERE user_id = ?";
	}

}
