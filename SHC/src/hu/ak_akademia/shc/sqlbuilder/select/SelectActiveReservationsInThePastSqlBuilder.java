package hu.ak_akademia.shc.sqlbuilder.select;

import hu.ak_akademia.shc.sqlbuilder.SqlBuilder;

public class SelectActiveReservationsInThePastSqlBuilder implements SqlBuilder {

	@Override
	public String build() {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append("    hotel_name, ");
		sql.append("    address, ");
		sql.append("    date_from, ");
		sql.append("    date_to, ");
		sql.append("    room.room_type, ");
		sql.append("    total_price, ");
		sql.append("    reservation_id ");
		sql.append("FROM ");
		sql.append("    reservation ");
		sql.append("    LEFT OUTER JOIN review ON reservation.reservation_id = review.reservation_id ");
		sql.append("    join room_to_reservation on room_to_reservation.reservation_id = reservation.reservation_id ");
		sql.append("    join room on room.room_id = room_to_reservation.room_id ");
		sql.append("    join hotel on room.hotel_id = hotel.hotel_id ");
		sql.append("WHERE ");
		sql.append("    user_id = ? ");
		sql.append("    AND date_to < SYSDATE ");
		sql.append("    AND status = 'ACTIVE' ");
		sql.append("    AND review_id IS NULL ");
		return sql.toString();
	}

}
