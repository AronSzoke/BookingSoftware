package hu.ak_akademia.shc.sqlbuilder.select;

import hu.ak_akademia.shc.sqlbuilder.SqlBuilder;

public class SelectFreeRoomsBetweenDatesSqlBuilder implements SqlBuilder {

	@Override
	public String build() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ");
		sql.append("    room.* ");
		sql.append("FROM ");
		sql.append("    room ");
		sql.append("WHERE ");
		sql.append("    room.room_id NOT IN ( ");
		sql.append("        SELECT ");
		sql.append("            room_to_reservation.room_id ");
		sql.append("        FROM ");
		sql.append("            room_to_reservation ");
		sql.append("            JOIN reservation ON room_to_reservation.reservation_id = reservation.reservation_id ");
		sql.append("            JOIN room ON room.room_id = room_to_reservation.room_id ");
		sql.append("        WHERE status = 'ACTIVE' ");
		sql.append("            AND (TO_DATE(? , 'yyyy-mm-dd') BETWEEN date_from AND date_to ");
		sql.append("            OR TO_DATE(?, 'yyyy-mm-dd') BETWEEN date_from AND date_to ");
		sql.append("            OR date_from BETWEEN TO_DATE(?, 'yyyy-mm-dd') AND TO_DATE(?, 'yyyy-mm-dd') ");
		sql.append("            OR date_to BETWEEN TO_DATE(?, 'yyyy-mm-dd') AND TO_DATE(?, 'yyyy-mm-dd')) ");
		sql.append("    ) ");
		return sql.toString();
	}

}
