package hu.ak_akademia.shc.sqlbuilder.insert;

import hu.ak_akademia.shc.sqlbuilder.SqlBuilder;

public class InsertHotelToServiceSqlBuilder implements SqlBuilder {

	@Override
	public String build() {
		return "INSERT INTO hotel_to_service (hotel_to_service_id, hotel_id, service_id) VALUES (hotel_to_service_seq.nextval, ?, ?)";
	}

}
