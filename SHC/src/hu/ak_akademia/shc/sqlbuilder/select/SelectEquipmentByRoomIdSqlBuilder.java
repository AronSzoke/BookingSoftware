package hu.ak_akademia.shc.sqlbuilder.select;

import hu.ak_akademia.shc.sqlbuilder.SqlBuilder;

public class SelectEquipmentByRoomIdSqlBuilder implements SqlBuilder {

	@Override
	public String build() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ");
		sql.append("    equipment.* ");
		sql.append("FROM ");
		sql.append("    equipment ");
		sql.append("    JOIN equipment_to_room ON equipment_to_room.equipment_id = equipment.equipment_id ");
		sql.append("WHERE ");
		sql.append("    room_id = ? ");
		sql.append("ORDER BY ");
		sql.append("    name ");
		return sql.toString();
	}

}
