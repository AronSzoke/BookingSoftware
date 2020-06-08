package hu.ak_akademia.shc.sqlbuilder.select;

import hu.ak_akademia.shc.sqlbuilder.SqlBuilder;

public class SelectNextReservationIdSqlBuilder implements SqlBuilder {

	@Override
	public String build() {
		return "SELECT reservation_seq.nextval reservation_id FROM dual";
	}

}
