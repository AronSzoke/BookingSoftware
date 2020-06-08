package hu.ak_akademia.shc.sqlbuilder.select;

import hu.ak_akademia.shc.sqlbuilder.SqlBuilder;

public class SelectReservationByIdSqlBuilder implements SqlBuilder {

	@Override
	public String build() {
		return "SELECT * FROM reservation WHERE reservation_id = ?";
	}

}
