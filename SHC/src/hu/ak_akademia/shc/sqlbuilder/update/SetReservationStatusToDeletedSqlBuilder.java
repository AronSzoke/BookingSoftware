package hu.ak_akademia.shc.sqlbuilder.update;

import hu.ak_akademia.shc.sqlbuilder.SqlBuilder;

public class SetReservationStatusToDeletedSqlBuilder implements SqlBuilder {

	@Override
	public String build() {
		return "UPDATE reservation SET status = 'DELETED' WHERE reservation_id = ? ";
	}

}
