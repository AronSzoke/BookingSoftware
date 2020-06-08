package hu.ak_akademia.shc.sqlbuilder.delete_by_id;

import hu.ak_akademia.shc.sqlbuilder.SqlBuilder;

public class DeleteServicesByIdSqlBuilder implements SqlBuilder {

	@Override
	public String build() {
		return "DELETE * FROM services WHERE service_id = ?";
	}

}
