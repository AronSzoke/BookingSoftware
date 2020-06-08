package hu.ak_akademia.shc.sqlbuilder.select;

import hu.ak_akademia.shc.sqlbuilder.SqlBuilder;

public class SelectCurrentAverageReviewScoreForHotelSqlBuilder implements SqlBuilder {

	@Override
	public String build() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ");
		sql.append("    avg(review_score) review_score ");
		sql.append("FROM ");
		sql.append("    room ");
		sql.append("    join room_to_reservation on room_to_reservation.room_id = room.room_id ");
		sql.append("    join review on review.reservation_id = room_to_reservation.reservation_id ");
		sql.append("WHERE ");
		sql.append("    hotel_id = ? ");
		return sql.toString();
	}

}
