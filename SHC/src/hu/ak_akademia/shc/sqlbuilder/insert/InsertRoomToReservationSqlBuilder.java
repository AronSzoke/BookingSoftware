package hu.ak_akademia.shc.sqlbuilder.insert;

import hu.ak_akademia.shc.sqlbuilder.SqlBuilder;

public class InsertRoomToReservationSqlBuilder implements SqlBuilder {

	@Override
	public String build() {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO room_to_reservation (");
		sql.append("	room_to_reservation_id,");
		sql.append("	room_id,");
		sql.append("	reservation_id");
		sql.append(") VALUES (");
		sql.append("    room_to_reservation_seq.NEXTVAL,");
		sql.append("    ?,");
		sql.append("    ?");
		sql.append(")");
		return sql.toString();
	}

}
