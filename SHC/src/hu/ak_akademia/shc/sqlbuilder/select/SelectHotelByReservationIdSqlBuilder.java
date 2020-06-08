package hu.ak_akademia.shc.sqlbuilder.select;

import hu.ak_akademia.shc.sqlbuilder.SqlBuilder;

public class SelectHotelByReservationIdSqlBuilder implements SqlBuilder {

	@Override
	public String build() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ");
		sql.append("    hotel.* ");
		sql.append("FROM ");
		sql.append("    hotel ");
		sql.append("    JOIN room ON room.hotel_id = hotel.hotel_id ");
		sql.append("    JOIN room_to_reservation ON room_to_reservation.room_id = room.room_id ");
		sql.append("WHERE ");
		sql.append("    reservation_id = ? ");
		return sql.toString();
	}

}
