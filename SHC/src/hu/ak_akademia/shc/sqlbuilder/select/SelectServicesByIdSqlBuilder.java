package hu.ak_akademia.shc.sqlbuilder.select;

import hu.ak_akademia.shc.sqlbuilder.SqlBuilder;

public class SelectServicesByIdSqlBuilder implements SqlBuilder {

	@Override
	public String build() {
		return "SELECT * FROM services WHERE service_id = ?";
	}

}
