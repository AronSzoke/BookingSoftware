package hu.ak_akademia.shc.sqlbuilder.insert;

import hu.ak_akademia.shc.sqlbuilder.SqlBuilder;

public class InsertRoomSqlBuilder implements SqlBuilder {

	@Override
	public String build() {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO room (");
		sql.append("    room_id,");
		sql.append("    hotel_id,");
		sql.append("    room_type,");
		sql.append("    floor,");
		sql.append("    room_number,");
		sql.append("    room_size,");
		sql.append("    room_price,");
		sql.append("    balcony");
		sql.append(") VALUES (");
		sql.append("    room_seq.NEXTVAL,");
		sql.append("    ?,");
		sql.append("    ?,");
		sql.append("    ?,");
		sql.append("    ?,");
		sql.append("    ?,");
		sql.append("    ?,");
		sql.append("    ?");
		sql.append(")");
		return sql.toString();
	}

}
