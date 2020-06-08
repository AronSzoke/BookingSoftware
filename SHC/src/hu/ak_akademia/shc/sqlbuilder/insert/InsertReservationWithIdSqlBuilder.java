package hu.ak_akademia.shc.sqlbuilder.insert;

import hu.ak_akademia.shc.sqlbuilder.SqlBuilder;

public class InsertReservationWithIdSqlBuilder implements SqlBuilder {

	@Override
	public String build() {
		return "INSERT INTO reservation (reservation_id, user_id, date_from, date_to, total_price) VALUES (?, ?, ?, ?, ?)";
	}

}
