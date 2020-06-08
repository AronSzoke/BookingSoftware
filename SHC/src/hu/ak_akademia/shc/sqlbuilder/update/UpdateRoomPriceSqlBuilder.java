package hu.ak_akademia.shc.sqlbuilder.update;

import hu.ak_akademia.shc.sqlbuilder.SqlBuilder;

public class UpdateRoomPriceSqlBuilder implements SqlBuilder {

	@Override
	public String build() {
		return "UPDATE room SET room_price = ? WHERE room_id = ? ";
	}

}
