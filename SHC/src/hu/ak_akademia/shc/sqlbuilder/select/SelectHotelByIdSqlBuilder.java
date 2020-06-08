package hu.ak_akademia.shc.sqlbuilder.select;

import hu.ak_akademia.shc.sqlbuilder.SqlBuilder;

public class SelectHotelByIdSqlBuilder implements SqlBuilder {

	@Override
	public String build() {
		return "SELECT * FROM hotel WHERE hotel_id = ?";
	}

}
