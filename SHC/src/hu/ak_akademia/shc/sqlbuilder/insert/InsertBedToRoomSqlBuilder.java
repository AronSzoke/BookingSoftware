package hu.ak_akademia.shc.sqlbuilder.insert;

import hu.ak_akademia.shc.sqlbuilder.SqlBuilder;

public class InsertBedToRoomSqlBuilder implements SqlBuilder {

	@Override
	public String build() {
		return "INSERT INTO bed_to_room (bed_to_room_id, room_id, bed_id) VALUES (bed_to_room_seq.nextval, ?, ?)";
	}

}
