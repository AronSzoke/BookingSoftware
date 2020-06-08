package hu.ak_akademia.shc.sqlbuilder.select;

import hu.ak_akademia.shc.sqlbuilder.SqlBuilder;

public class SelectSpecificRoomBetweenDatesSqlBuilder implements SqlBuilder {

	@Override
	public String build() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ");
		sql.append("    room.* ");
		sql.append("FROM ");
		sql.append("    reservation ");
		sql.append("    JOIN room_to_reservation ON room_to_reservation.reservation_id = reservation.reservation_id ");
		sql.append("    JOIN room ON room_to_reservation.room_id = room.room_id ");
		sql.append("WHERE ");
		sql.append("    room_to_reservation.room_id = ? ");
		sql.append("    AND ( TO_DATE(?, 'YYYY-MM-DD') BETWEEN date_from AND date_to ");
		sql.append("          OR TO_DATE(?, 'YYYY-MM-DD') BETWEEN date_from AND date_to ");
		sql.append("          OR date_from BETWEEN TO_DATE(?, 'YYYY-MM-DD') AND TO_DATE(?, 'YYYY-MM-DD') ");
		sql.append("          OR date_to BETWEEN TO_DATE(?, 'YYYY-MM-DD') AND TO_DATE(?, 'YYYY-MM-DD') ) ");
		return sql.toString();
	}

}
