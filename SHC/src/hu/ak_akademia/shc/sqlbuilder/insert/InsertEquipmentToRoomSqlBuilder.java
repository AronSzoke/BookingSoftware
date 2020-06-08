package hu.ak_akademia.shc.sqlbuilder.insert;

import hu.ak_akademia.shc.sqlbuilder.SqlBuilder;

public class InsertEquipmentToRoomSqlBuilder implements SqlBuilder {

	@Override
	public String build() {
		return "INSERT INTO equipment_to_room (equipment_to_room_id, equipment_id, room_id) VALUES (equipment_to_room_seq.nextval, ?, ?)";
	}

}
