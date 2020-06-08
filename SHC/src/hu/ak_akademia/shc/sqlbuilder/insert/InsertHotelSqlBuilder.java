package hu.ak_akademia.shc.sqlbuilder.insert;

import hu.ak_akademia.shc.sqlbuilder.SqlBuilder;

public class InsertHotelSqlBuilder implements SqlBuilder {

	@Override
	public String build() {
		return "INSERT INTO hotel (hotel_id, hotel_type, hotel_name, address, stars, review) VALUES (hotel_seq.nextval, ?, ?, ?, ?, ?)";
	}

}
