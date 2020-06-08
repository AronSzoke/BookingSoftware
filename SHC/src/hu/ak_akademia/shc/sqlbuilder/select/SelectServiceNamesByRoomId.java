package hu.ak_akademia.shc.sqlbuilder.select;

import hu.ak_akademia.shc.sqlbuilder.SqlBuilder;

public class SelectServiceNamesByRoomId implements SqlBuilder {

	@Override
	public String build() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ");
		sql.append("    * ");
		sql.append("FROM ");
		sql.append("    services ");
		sql.append("WHERE ");
		sql.append("    service_id IN ( ");
		sql.append("        SELECT ");
		sql.append("            service_id ");
		sql.append("        FROM ");
		sql.append("            room ");
		sql.append("            JOIN hotel_to_service ON room.hotel_id = hotel_to_service.hotel_id ");
		sql.append("        WHERE ");
		sql.append("            room_id = ? ");
		sql.append("    ) ");
		return sql.toString();
	}

}
