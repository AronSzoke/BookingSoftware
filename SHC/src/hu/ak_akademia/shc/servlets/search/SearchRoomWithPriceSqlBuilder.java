package hu.ak_akademia.shc.servlets.search;

import hu.ak_akademia.shc.sqlbuilder.SqlBuilder;

public class SearchRoomWithPriceSqlBuilder implements SqlBuilder {

	@Override
	public String build() {
		return "SELECT * FROM room WHERE room_price > ? AND room_price < ?";
	}

}
