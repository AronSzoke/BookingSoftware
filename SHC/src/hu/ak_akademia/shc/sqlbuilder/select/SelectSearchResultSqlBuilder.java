package hu.ak_akademia.shc.sqlbuilder.select;

import hu.ak_akademia.shc.sqlbuilder.SqlBuilder;

public class SelectSearchResultSqlBuilder implements SqlBuilder {

	private final boolean withPriceFrom;
	private final boolean withPriceTo;

	public SelectSearchResultSqlBuilder(boolean withPriceFrom, boolean withPriceTo) {
		this.withPriceFrom = withPriceFrom;
		this.withPriceTo = withPriceTo;
	}

	@Override
	public String build() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT hotel_name ");
		sql.append("	,address ");
		sql.append("	,stars ");
		sql.append("	,review ");
		sql.append("	,search_room.room_id ");
		sql.append("	,room_number ");
		sql.append("	,room_type ");
		sql.append("	,room_price ");
		sql.append("	,bed_types ");
		sql.append("	,adults ");
		sql.append("FROM ( ");
		sql.append("	SELECT hotel_name ");
		sql.append("		,address ");
		sql.append("		,stars ");
		sql.append("		,review ");
		sql.append("		,room.room_id ");
		sql.append("		,room_number ");
		sql.append("		,room_type ");
		sql.append("		,room_price ");
		sql.append("		,LISTAGG(bed_type, ', ') WITHIN ");
		sql.append("	GROUP ( ");
		sql.append("			ORDER BY bed_type ");
		sql.append("			) bed_types ");
		sql.append("		,SUM(bed_space) adults ");
		sql.append("	FROM room ");
		sql.append("	JOIN bed_to_room ON room.room_id = bed_to_room.room_id ");
		sql.append("	JOIN bed ON bed_to_room.bed_id = bed.bed_id ");
		sql.append("	JOIN hotel ON room.hotel_id = hotel.hotel_id ");
		sql.append("	WHERE hotel.address = ? ");
		if (withPriceFrom) {
			sql.append("		AND room_price > ? ");
		}
		if (withPriceTo) {
			sql.append("		AND room_price < ? ");
		}
		sql.append("	GROUP BY hotel_name ");
		sql.append("		,address ");
		sql.append("		,stars ");
		sql.append("		,review ");
		sql.append("		,room.room_id ");
		sql.append("		,room_number ");
		sql.append("		,room_type ");
		sql.append("		,room_price ");
		sql.append("	HAVING ? <= SUM(bed_space) ");
		sql.append("	) search_room ");
		sql.append("JOIN ( ");
		sql.append("	SELECT room_id ");
		sql.append("	FROM room ");
		sql.append("	WHERE room_id NOT IN ( ");
		sql.append("			SELECT room_id ");
		sql.append("			FROM reservation ");
		sql.append("			JOIN room_to_reservation ON reservation.reservation_id = room_to_reservation.reservation_id ");
		sql.append("			WHERE status = 'ACTIVE' AND ");
		sql.append("				(TO_DATE(?, 'YYYY-MM-DD') BETWEEN date_from AND date_to ");
		sql.append("				OR TO_DATE(?, 'YYYY-MM-DD') BETWEEN date_from AND date_to ");
		sql.append("				OR date_from BETWEEN TO_DATE(?, 'YYYY-MM-DD') AND TO_DATE(?, 'YYYY-MM-DD') ");
		sql.append("				OR date_to BETWEEN TO_DATE(?, 'YYYY-MM-DD') AND TO_DATE(?, 'YYYY-MM-DD')) ");
		sql.append("			) ");
		sql.append("	) free_rooms ON search_room.room_id = free_rooms.room_id ");
		sql.append("ORDER BY adults ");
		return sql.toString();
	}

}
